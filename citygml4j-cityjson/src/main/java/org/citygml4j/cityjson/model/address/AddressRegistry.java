/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.address;

import org.citygml4j.cityjson.model.CityJSONVersion;
import org.xmlobjects.xal.model.types.AdministrativeAreaType;
import org.xmlobjects.xal.model.types.LocalityType;
import org.xmlobjects.xal.model.types.PostalDeliveryPointType;
import org.xmlobjects.xal.model.types.PremisesType;

import java.util.*;

public class AddressRegistry {
    private static final AddressRegistry instance = new AddressRegistry();
    private final Map<String, AddressToken> tokens = new HashMap<>();
    private final Map<String, AddressComponent> components = new HashMap<>();
    private final Map<AddressComponent, Map<CityJSONVersion, String>> componentNames = new HashMap<>();

    private AddressRegistry() {
        populateTokens();
        populateComponents();
    }

    public static AddressRegistry getInstance() {
        return instance;
    }

    public void registerProperty(String propertyName, AddressComponent component) {
        if (propertyName != null && component != null) {
            registerToken(AddressToken.of(propertyName, component));
        }
    }

    public void registerToken(AddressToken token) {
        if (token != null) {
            tokens.put(token.getPropertyName().toLowerCase(Locale.ROOT), token);
        }
    }

    public Optional<AddressToken> getToken(String propertyName) {
        return propertyName != null ?
                Optional.ofNullable(tokens.get(propertyName.toLowerCase(Locale.ROOT))) :
                Optional.empty();
    }

    public AddressComponent getComponent(String propertyName) {
        if (propertyName != null) {
            propertyName = propertyName.toLowerCase(Locale.ROOT);

            AddressToken token = tokens.get(propertyName);
            if (token != null) {
                return token.getComponent();
            }

            for (Map.Entry<String, AddressComponent> entry : components.entrySet()) {
                if (propertyName.startsWith(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }

        return AddressComponent.FREE_TEXT_ADDRESS;
    }

    public String getComponentName(AddressComponent component, CityJSONVersion version) {
        if (component != null && version != null) {
            Map<CityJSONVersion, String> names = componentNames.getOrDefault(component, Collections.emptyMap());
            return names.getOrDefault(version, component.getPropertyName(version));
        }

        return null;
    }

    public void setComponentName(AddressComponent component, String propertyName, CityJSONVersion version) {
        if (propertyName != null && component != null && version != null) {
            componentNames.computeIfAbsent(component, k -> new HashMap<>())
                    .put(version, propertyName);
        }
    }

    private void populateTokens() {
        Arrays.stream(AddressComponent.values()).forEach(component -> {
            registerProperty(component.getPropertyName(CityJSONVersion.v1_0), component);
            registerProperty(component.getPropertyName(CityJSONVersion.v2_0), component);
        });

        Arrays.stream(AdministrativeAreaType.values())
                .filter(type -> type != AdministrativeAreaType.CITY)
                .forEach(type -> registerProperty(type.toValue(), AddressComponent.ADMINISTRATIVE_AREA));
        Arrays.stream(LocalityType.values())
                .forEach(type -> registerProperty(type.toValue(), AddressComponent.LOCALITY));
        Arrays.stream(PostalDeliveryPointType.values())
                .forEach(type -> registerProperty(type.toValue(), AddressComponent.POSTAL_DELIVERY_POINT));
        Arrays.stream(PremisesType.values())
                .forEach(type -> registerProperty(type.toValue(), AddressComponent.PREMISE_NAME));

        registerProperty("CountryCode", AddressComponent.COUNTRY);
        registerProperty("City", AddressComponent.LOCALITY);
        registerProperty("PostCode", AddressComponent.POSTAL_CODE);
        registerProperty("ZipCode", AddressComponent.POSTAL_CODE);
        registerProperty("Premises", AddressComponent.PREMISE_NAME);
        registerProperty("Thoroughfare", AddressComponent.THOROUGHFARE_NAME);
        registerProperty("Street", AddressComponent.THOROUGHFARE_NAME);
        registerProperty("Road", AddressComponent.THOROUGHFARE_NAME);
        registerProperty("HouseNumber", AddressComponent.THOROUGHFARE_NUMBER);
    }

    private void populateComponents() {
        Arrays.stream(AddressComponent.values())
                .forEach(component -> components.put(component.name().toLowerCase(Locale.ROOT), component));
    }
}

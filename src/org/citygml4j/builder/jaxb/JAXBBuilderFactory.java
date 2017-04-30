package org.citygml4j.builder.jaxb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.citygml4j.builder.CityGMLBuilderException;
import org.citygml4j.model.citygml.ade.binding.ADEContext;

public class JAXBBuilderFactory {
	private ClassLoader classLoader;
	private HashSet<String> packageNames;
	private List<ADEContext> adeContexts;

	private JAXBBuilderFactory() {
		classLoader = ClassLoader.getSystemClassLoader();
		packageNames = new HashSet<>();
		adeContexts = new ArrayList<>();
	}

	public static JAXBBuilderFactory defaults() {
		return new JAXBBuilderFactory();
	}

	public JAXBBuilderFactory withClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
		return this;
	}

	public JAXBBuilderFactory withPackageNames(List<String> packageNames) {
		for (String packageName : packageNames) {
			if (packageName != null)
				this.packageNames.add(packageName);
		}

		return this;
	}

	public JAXBBuilderFactory withPackageNames(String... packageNames) {
		return withPackageNames(Arrays.asList(packageNames));
	}

	public JAXBBuilderFactory withADEContexts(List<ADEContext> adeContexts) {
		for (ADEContext adeContext : adeContexts) {
			if (adeContext != null) {
				this.adeContexts.add(adeContext);
				withPackageNames(adeContext.getJAXBPackageNames());
			}
		}

		return this;
	}

	public JAXBBuilder build() throws CityGMLBuilderException {
		try {
			return new JAXBBuilder(JAXBContext.newInstance(JAXBContextPath.getContextPath(packageNames), classLoader), adeContexts);
		} catch (JAXBException e) {
			throw new CityGMLBuilderException("Failed to build JAXB context.", e);
		}
	}

}

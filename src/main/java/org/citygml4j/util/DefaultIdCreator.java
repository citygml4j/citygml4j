package org.citygml4j.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultIdCreator implements IdCreator {
    private final Matcher matcher = Pattern.compile("[_A-Za-z][-._A-Za-z0-9]*", Pattern.UNICODE_CHARACTER_CLASS).matcher("");
    private String prefix;

    private DefaultIdCreator() {
        prefix = getDefaultPrefix();
    }

    public static synchronized DefaultIdCreator newInstance() {
        return new DefaultIdCreator();
    }

    public static synchronized DefaultIdCreator newInstance(String prefix) {
        return new DefaultIdCreator().withPrefix(prefix);
    }

    public String getDefaultPrefix() {
        return "UUID_";
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isValidPrefix(String prefix) {
        return prefix != null && !matcher.reset(prefix).matches();
    }

    public DefaultIdCreator withPrefix(String prefix) {
        this.prefix = isValidPrefix(prefix) ? prefix : getDefaultPrefix();
        return this;
    }

    @Override
    public String createId() {
        return prefix + UUID.randomUUID().toString();
    }
}

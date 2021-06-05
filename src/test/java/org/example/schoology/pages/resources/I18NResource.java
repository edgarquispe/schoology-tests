package org.example.schoology.pages.resources;

import java.util.Arrays;

public enum I18NResource {

    MESSAGE("Your item has been removed.", "resource.message");

    private final String uiName;
    private final String i18nKey;

    I18NResource(final String uiName, final String i18nKey) {
        this.uiName = uiName;
        this.i18nKey = i18nKey;
    }

    public static String getI18nKey(final String uiName) {
        I18NResource i18NResource = Arrays.stream(I18NResource.values())
                .filter(e -> e.uiName.equalsIgnoreCase(uiName))
                .findFirst()
                .orElseThrow();
        return i18NResource.i18nKey;
    }


}

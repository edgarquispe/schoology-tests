package org.example.schoology.pages.jorge.user;

import org.example.schoology.pages.courses.I18NCourse;

import java.util.Arrays;

public enum I18NUser {

    PROFILE_UPDATED("Your profile has been updated.", "user.message"),
    PROFILE_NAME("Your Profile", "user.profile");


    private final String uiName;
    private final String i18nKey;

    I18NUser(final String uiName, final String i18nKey) {
        this.uiName = uiName;
        this.i18nKey = i18nKey;
    }

    public static String getI18nKey(final String uiName) {
        I18NUser i18NUser = Arrays.stream(I18NUser.values())
                .filter(e -> e.uiName.equalsIgnoreCase(uiName))
                .findFirst()
                .orElseThrow();
        return i18NUser.i18nKey;
    }
}

package org.example.schoology.pages.courses;

import java.util.Arrays;

public enum I18NCourse {

    SUBJECT_AREA_MATHEMATICS("Mathematics", "course.subject_area.mathematics"),
    LEVEL_UNDERGRADUATE("Undergraduate", "course.level.undergraduate"),
    SUBJECT_AREA_SCIENCE("Science", "course.subject_area.science"),
    SUBJECT_AREA_TECHNOLOGY("Technology", "course.subject_area.technology"),
    MESSAGE("The section has been updated.", "course.message"),
    SECTION_MESSAGE("Successfully created", "course.section.add.message");

    private final String uiName;
    private final String i18nKey;

    I18NCourse(final String uiName, final String i18nKey) {
        this.uiName = uiName;
        this.i18nKey = i18nKey;
    }

    public static String getI18nKey(final String uiName) {
        I18NCourse i18NCourse = Arrays.stream(I18NCourse.values())
                .filter(e -> e.uiName.equalsIgnoreCase(uiName))
                .findFirst()
                .orElseThrow();
        return i18NCourse.i18nKey;
    }


}

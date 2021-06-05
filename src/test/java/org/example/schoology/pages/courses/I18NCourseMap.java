package org.example.schoology.pages.courses;

import java.util.HashMap;
import java.util.Map;

public final class I18NCourseMap {

    private static final Map<String, String> KEYS;
    static {
        KEYS = new HashMap<>();
        KEYS.put("Mathematics", "course.subject_area.mathematics");
        KEYS.put("Undergraduate", "course.level.undergraduate");
        KEYS.put("Science", "course.subject_area.science");
        KEYS.put("The section has been updated.", "course.message");
    }

    private I18NCourseMap() {
    }

    public static String getI18nKey(final String uiName) {
        return KEYS.get(uiName);
    }
}

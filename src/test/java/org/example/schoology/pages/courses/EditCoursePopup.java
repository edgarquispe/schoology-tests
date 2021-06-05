package org.example.schoology.pages.courses;

import java.util.Map;

public class EditCoursePopup extends AbstractCoursePopup {

    public Courses edit(final Map<CourseForm, String> courseMap) {
        fill(courseMap);
        submitButton.click();
        return new Courses();
    }

}

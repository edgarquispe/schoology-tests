package org.example.schoology.pages.courses;

import java.util.Map;

public class AddSectionPopup extends AbstractCoursePopup {

    public Courses add(final Map<CourseForm, String> courseMap) {
        fill(courseMap);
        submitButton.click();
        return new Courses();
    }

}

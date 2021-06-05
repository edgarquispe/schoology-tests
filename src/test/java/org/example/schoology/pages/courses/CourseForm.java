package org.example.schoology.pages.courses;

public enum CourseForm {
    COURSE_NAME("Course Name"),
    SECTION_NAME("Section Name"),
    SUBJECT_AREA("Subject Area"),
    LEVEL("Level");

    private final String name;

    CourseForm(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

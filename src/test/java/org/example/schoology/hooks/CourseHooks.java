package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.courses.Courses;
import org.example.schoology.pages.courses.DeletePopup;

public class CourseHooks {

    public static final String COURSE_KEY = "CourseKey";

    private final ScenarioContext context;

    public CourseHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios
    }

    @After(value = "@deleteCourse")
    public void deleteCourse() {
        // What is the course name for deleting ?

        // delete by UI (~10 sec)
        DriverFactory.getDriver().get("https://app.schoology.com/courses");
        DeletePopup deletePopup = new Courses().clickDeleteCourse(context.getValue(COURSE_KEY));
        deletePopup.clickDeleteButton();

        // delete by Rest API (~3 milli seconds)
    }

}

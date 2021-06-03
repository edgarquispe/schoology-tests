package org.example.schoology.steps;

import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.courses.*;
import org.testng.asserts.Assertion;

import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ScenarioContext;
import org.example.schoology.Resources;
import org.example.schoology.hooks.CourseHooks;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.SubMenu;

public class CourseStepDefs {

    private final ScenarioContext context;

    private Courses courses;

    private final Home home;

    private final Assertion assertion;

    private ResourceBundle resourceBundle;

    public CourseStepDefs(final AssertionGroup assertionGroup, final ScenarioContext context, final Courses courses) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.home = new Home();
        this.courses = courses;
        resourceBundle = ResourceBundle.getBundle(Resources.I18N_COURSE,
                Environment.getInstance().getLocale());
    }

    @And("I create a course with:")
    public void iCreateACourseWith(final Map<CourseForm, String> datatable) {
        final String keyCourses = "courses";
        String courses = ResourceBundle.getBundle(Resources.I18N_COURSE,
                Environment.getInstance().getLocale()).getString(keyCourses);
        SubMenu subMenu = home.clickMenu(courses);
        subMenu.clickViewListLink(keyCourses);
        CreateCoursePopup createCoursePopup = this.courses.clickCreateCourseButton();
        createCoursePopup.create(datatable);
        context.setContext(CourseHooks.COURSE_KEY, datatable.get(CourseForm.COURSE_NAME));
    }

    @And("I edit the {string} course with:")
    public void iEditTheCourseWith(final String name, final Map<CourseForm, String> datatable) {
        EditCoursePopup editCoursePopup = courses.clickEditCourse(name);
        courses = editCoursePopup.edit(datatable);
        context.setContext(CourseHooks.COURSE_KEY, datatable.get(CourseForm.COURSE_NAME));
    }

    @And("I add a Section into {string} course with:")
    public void iAddSectionWith(final String name, final Map<CourseForm, String> datatable) {
        AddSectionPopup addSectionPopup = courses.clickAddSectionButton(name);
        courses = addSectionPopup.add(datatable);
        context.setContext(CourseHooks.COURSE_KEY, datatable.get(CourseForm.COURSE_NAME));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I should see the {string} section on {string} course item")
    public void iShouldSeeTheSectionOnCourseItem(final String expectedSection, final String courseName) {
        List<String> coursesList = courses.getSectionsByName(courseName);
        assertion.assertTrue(coursesList.contains(expectedSection));
    }
//I should see the "Successfully created" message for "Technology Section" section on "Course for Section" course item
    @Then("I should see the {string} message for {string} section on {string} course item")
    public void iShouldSeeTheMessage(final String message, final String expectedSection, final String expectedCourseName) {
        assertion.assertEquals(new ViewList().getMessage(),
                String.format(resourceBundle.getString(I18NCourse.getI18nKey(message)),expectedCourseName,expectedSection),
                "Message banner");
    }
}

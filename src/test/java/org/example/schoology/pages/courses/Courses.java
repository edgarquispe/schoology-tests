package org.example.schoology.pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.schoology.pages.ViewList;

public class Courses extends ViewList {

    public static final String XPATH_COURSE_ACTIONS_BUTTON =
            "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
    public static final String XPATH_SECTION_BY_NAME =
            "//span[text()='%s']/parent::p/parent::li//a[@class='sExtlink-processed']";

    @FindBy(css = "a.create-course-btn")
    private WebElement createCourseButton;

    public CreateCoursePopup clickCreateCourseButton() {
        createCourseButton.click();
        return new CreateCoursePopup();
    }

    public EditCoursePopup clickEditCourse(final String courseName) {
        WebElement courseActionsButton = driver.findElement(By.xpath(String.format(XPATH_COURSE_ACTIONS_BUTTON,
                courseName)));
        action.scrollTo(courseActionsButton);
        action.jsClick(courseActionsButton);
        action.click(editOption);
        return new EditCoursePopup();
    }

    public DeletePopup clickDeleteCourse(final String courseName) {
        WebElement courseActionsButton = driver.findElement(By.xpath(String.format(XPATH_COURSE_ACTIONS_BUTTON,
                courseName)));
        action.scrollTo(courseActionsButton);
        action.jsClick(courseActionsButton);
        action.click(deleteOption);
        return new DeletePopup();
    }

    public String getSectionByName(final String courseName) {
        return action.getText(driver.findElement(By.xpath(String.format(XPATH_SECTION_BY_NAME, courseName))));
    }
}

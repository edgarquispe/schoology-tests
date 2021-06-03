package org.example.schoology.pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class Courses extends ViewList {

    public static final String XPATH_COURSE_ACTIONS_BUTTON =
            "//span[text()='%s']/ancestor::li//div[@class='action-links-unfold ']";
    public static final String XPATH_SECTION_BY_NAME =
            "//span[text()='%s']/parent::p/parent::li//a[@class='sExtlink-processed']";
    public static final String XPATH_ADD_SECTION =
            "//span[text()='%s']/ancestor::p/a[contains(@class,'add-section-icon')]";

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

    public AddSectionPopup clickAddSectionButton(final String courseName) {
        By addSectionBy = By.xpath(String.format(XPATH_ADD_SECTION,courseName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addSectionBy));
        wait.until(ExpectedConditions.elementToBeClickable(addSectionBy));
        WebElement addSectionButton = driver.findElement(addSectionBy);
        addSectionButton.click();
        return new AddSectionPopup();
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
    public List<String> getSectionsByName(final String courseName) {
        List<String> sectionsNames = new ArrayList<>();
        List<WebElement> sections = driver.findElements(By.xpath(String.format(XPATH_SECTION_BY_NAME, courseName)));
        for (WebElement section: sections) {
            sectionsNames.add(action.getText(section));
        }
        return sectionsNames;
    }
}

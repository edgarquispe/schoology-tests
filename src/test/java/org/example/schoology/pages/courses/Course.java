package org.example.schoology.pages.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.core.ui.AbstractPage;

public class Course extends AbstractPage {

    @FindBy(css = "#course-profile-materials")
    private WebElement courseProfileMaterials;

    public Course() {
        wait.until(ExpectedConditions.visibilityOf(courseProfileMaterials));
    }
}

package org.example.schoology.pages.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

public class DeletePopup extends AbstractPage {

    @FindBy(css = "#edit-submit")
    private WebElement deleteButton;

    public void clickDeleteButton() {
        action.click(deleteButton);
    }

}

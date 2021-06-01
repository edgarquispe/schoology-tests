package org.example.schoology.pages.jorge.user;

import org.example.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class User extends AbstractPage {

    @FindBy(css = ".edit-profile-link")
    private WebElement editButton;

    @FindBy(css = "#edit-submit")
    private WebElement saveChangesButton;

    public UserEditPage clickEdit() {
        action.click(editButton);
        return new UserEditPage();
    }

    public void updateProfile(final Map<String, String> profileData) {
        UserEditPage editPage = clickEdit();
        editPage.updateProfile(profileData);
    }

    public void clickSaveChanges() {
        action.click(saveChangesButton);
    }
}

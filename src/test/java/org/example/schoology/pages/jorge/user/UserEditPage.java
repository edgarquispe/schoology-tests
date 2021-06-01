package org.example.schoology.pages.jorge.user;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.groups.GroupForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class UserEditPage extends AbstractPage {

    @FindBy(css = "#edit-profile-about-bio")
    public WebElement bioTextElement;

    public void updateProfile(final Map<String, String> profileData) {
        action.setValue(bioTextElement, profileData.get("Bio"));
    }
}

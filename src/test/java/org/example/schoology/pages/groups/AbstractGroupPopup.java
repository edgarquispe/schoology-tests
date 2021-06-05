package org.example.schoology.pages.groups;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.example.core.ui.AbstractPage;
import org.example.schoology.pages.Step;

public abstract class AbstractGroupPopup extends AbstractPage {

    @FindBy(css = "#edit-name")
    private WebElement nameField;

    @FindBy(css = "#edit-description")
    private WebElement descriptionField;

    @FindBy(css = "#edit-group-code")
    private WebElement groupCodeField;

    @FindBy(css = "#edit-privacy-level")
    private WebElement privacyField;

    @FindBy(css = "#edit-invite-type")
    private WebElement accessField;

    @FindBy(css = "#edit-category")
    private WebElement categoryField;

    @FindBy(css = "#edit-submit")
    protected WebElement submitButton;

    public void fill(final Map<GroupForm, String> groupMap) {
        EnumMap<GroupForm, Step> stepMap = new EnumMap<>(GroupForm.class);
        stepMap.put(GroupForm.NAME, () -> setName(groupMap.get(GroupForm.NAME)));
        stepMap.put(GroupForm.DESCRIPTION, () -> setDescription(groupMap.get(GroupForm.DESCRIPTION)));
        stepMap.put(GroupForm.PRIVACY, () -> selectPrivacy(groupMap.get(GroupForm.PRIVACY)));
        stepMap.put(GroupForm.ACCESS, () -> selectAccess(groupMap.get(GroupForm.ACCESS)));
        stepMap.put(GroupForm.CATEGORY, () -> selectCategory(groupMap.get(GroupForm.CATEGORY)));

        for (final GroupForm keyField : groupMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void setName(final String name) {
        action.setValue(nameField, name);
    }

    public void setDescription(final String description) {
        action.setValue(descriptionField, description);
    }

    public void setGroupCode(final String code) {
        action.setValue(groupCodeField, code);
    }

    public void selectPrivacy(final String privacy) {
        Select selectPrivacy = new Select(privacyField);
        selectPrivacy.selectByVisibleText(privacy);
    }

    public void selectAccess(final String access) {
        Select selectAccess = new Select(accessField);
        selectAccess.selectByVisibleText(access);
    }

    public void selectCategory(final String category) {
        Select selectCategory = new Select(categoryField);
        selectCategory.selectByVisibleText(category);
    }
}

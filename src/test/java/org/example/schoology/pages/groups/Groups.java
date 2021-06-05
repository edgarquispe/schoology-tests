package org.example.schoology.pages.groups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.courses.DeletePopup;

public class Groups extends ViewList {

    public static final String GROUP_ACTIONS_BUTTON = "//a[text()='%s']/ancestor::li//div[@href='#']";
    public static final String GROUP_BY_NAME = "//a[text()='%s']";

    @FindBy(css = "a.create-group")
    private WebElement createGroupButton;

    public CreateGroupPopup clickCreateGroupButton() {
        action.jsClick(createGroupButton);
        return new CreateGroupPopup();
    }

    public EditGroupPopup clickEditGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        action.scrollTo(groupActionsButton);
        action.jsClick(groupActionsButton);
        action.jsClick(editOption);
        return new EditGroupPopup();
    }

    public DeletePopup clickDeleteGroup(final String groupName) {
        WebElement groupActionsButton = driver.findElement(By.xpath(String.format(GROUP_ACTIONS_BUTTON, groupName)));
        action.scrollTo(groupActionsButton);
        action.jsClick(groupActionsButton);
        action.click(deleteOption);
        return new DeletePopup();
    }

    public String getGroupByName(final String groupName) {
        return driver.findElement(By.xpath(String.format(GROUP_BY_NAME, groupName))).getText();
    }

}

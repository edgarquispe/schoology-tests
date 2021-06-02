package org.example.schoology.pages.resources;

import org.example.schoology.pages.AppPageFactory;
import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ResourcesPage extends ViewList {

    public static final String XPATH_FOLDER_ACTIONS_BUTTON =
            "//td/a[text()='%s']/ancestor::td//following-sibling::td//div[@class='action-links-unfold ']";

    private static final String RESOURCE_LINK = "a[href*='%s']";
    private static final String RESOURCE_NAME_LINK = "//a[text()='%s']";

    private static final Map<String, String> SPECIAL_RESOURCE_TYPE_FOR_LOCATOR = new HashMap<>();
    static {
        SPECIAL_RESOURCE_TYPE_FOR_LOCATOR.put("test/quiz", "/assessment");
        SPECIAL_RESOURCE_TYPE_FOR_LOCATOR.put("assessment", "/assessment-v2");
    }

    @FindBy(css = "#toolbar-add")
    private WebElement addResourcesDropdown;

    @FindBy(css = "#collection-add-folder")
    private WebElement addFolderOption;

    @FindBy(id = "collection-view-contents")
    private WebElement collectionView;


    public CreateFolderResourcePopup clickCreateFolderButton() {
        addResourcesDropdown.click();
        addFolderOption.click();
        return new CreateFolderResourcePopup();
    }

    public void deleteResource(final String folderName) {
        WebElement folderActionsButton = driver.findElement(By.xpath(String.format(XPATH_FOLDER_ACTIONS_BUTTON,
                folderName)));
        action.scrollTo(folderActionsButton);
        action.jsClick(folderActionsButton);
        action.click(deleteOption);
        new DeleteResourcePopup().clickDeleteButton();
    }

    public boolean verifyFolderResourceExists(final String folderName) {
        return action.getText(collectionView).contains(folderName);
    }

    public AddResourcePopupAbstract clickAddResources(final String resourceType) {
        String resourceTypeModified = resourceType.toLowerCase();
        resourceTypeModified = SPECIAL_RESOURCE_TYPE_FOR_LOCATOR.getOrDefault(resourceTypeModified,
                resourceTypeModified.replaceAll(" ", "_"));

        addResourcesDropdown.click();
        driver.findElement(By.cssSelector(String.format(RESOURCE_LINK, resourceTypeModified))).click();
        return AppPageFactory.getAddResourcePopup(resourceType);
    }

    public void openQuestionBankResource(final String resourceName) {
        action.click(By.xpath(String.format(RESOURCE_NAME_LINK, resourceName)));
    }
}

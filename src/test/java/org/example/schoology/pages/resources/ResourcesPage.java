package org.example.schoology.pages.resources;

import org.example.schoology.pages.ViewList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResourcesPage extends ViewList {

    public static final String XPATH_FOLDER_ACTIONS_BUTTON =
            "//td/a[text()='%s']/ancestor::td//following-sibling::td//div[@class='action-links-unfold ']";

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

    public void deleteFolderResource(final String folderName) {
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
}

package org.example.schoology.pages.resources;

import java.util.EnumMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.Environment;
import org.example.core.ui.AbstractPage;
import org.example.schoology.Resources;
import org.example.schoology.pages.Step;

public abstract class AbstractAddFolderResourcePopup extends AbstractPage {

    @FindBy(css = "#edit-title")
    private WebElement folderNameTextField;

    private final ResourceBundle bundle;

    public AbstractAddFolderResourcePopup() {
        super();
        bundle = ResourceBundle.getBundle(Resources.I18N_RESOURCE, Environment.getInstance().getLocale());
    }

    protected WebElement submitButton() {
        final String keyResources = "resource.button.create";
        return driver.findElement(By.cssSelector(String.format("[value='%s']",
                bundle.getString(keyResources))));
    }

    private WebElement folderColor(final String color) {
        return driver.findElement(By.cssSelector(String.format("[data-color='%s']", color.toLowerCase())));
    }

    public void fill(final Map<AddFolderForm, String> resourceMap) {
        EnumMap<AddFolderForm, Step> stepMap = new EnumMap<>(AddFolderForm.class);
        stepMap.put(AddFolderForm.FOLDER_NAME, () -> setName(resourceMap.get(AddFolderForm.FOLDER_NAME)));
        stepMap.put(AddFolderForm.FOLDER_COLOR, () -> setFolderColor(resourceMap.get(AddFolderForm.FOLDER_COLOR)));

        for (final AddFolderForm keyField : resourceMap.keySet()) {
            stepMap.get(keyField).execute();
        }
    }

    public void setName(final String name) {
        action.setValue(folderNameTextField, name);
    }

    public void setFolderColor(final String color) {
        action.click(folderColor(color));
    }
}

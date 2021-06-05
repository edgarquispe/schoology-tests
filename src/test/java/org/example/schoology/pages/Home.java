package org.example.schoology.pages;

import org.example.core.Environment;
import org.example.schoology.Resources;
import org.openqa.selenium.By;

import org.example.core.ui.AbstractPage;

import java.util.ResourceBundle;

public class Home extends AbstractPage {

    /**
     * This only works for Courses and Groups
     * Resources and More menu has another behavior.
     *
     * @param menuName {courses or groups}
     * @return {@link SubMenu}
     */
    public SubMenu clickMenu(final String menuName) {
        final String keyResources = "resources";
        String resource = ResourceBundle.getBundle(Resources.I18N_RESOURCE,
                Environment.getInstance().getLocale()).getString(keyResources);
        if (menuName.equals(resource)) {
            action.jsClick(driver.findElement(By.xpath(String.format("//li/a[text()='%s']", menuName))));
        } else {
            action.jsClick(driver.findElement(By.xpath(String.format("//span[text()='%s']/parent::button", menuName))));
        }

        return new SubMenu();
    }

}

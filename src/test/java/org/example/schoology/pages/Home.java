package org.example.schoology.pages;

import org.example.core.Environment;
import org.example.schoology.Resources;
import org.example.schoology.pages.jorge.user.I18NUser;
import org.example.schoology.pages.jorge.user.User;
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

    public User clickProfile(String account) {
        String userName = Environment.getInstance().getValue(String.format("credentials.%s.name", account));
        action.click(driver.findElement(By.xpath(String.format("//div[text()='%s']/parent::div/parent::button", userName))));
        final String profileName = "Your Profile";
        String profileOption = ResourceBundle.getBundle(Resources.I18N_USER, Environment.getInstance().getLocale()).getString(I18NUser.getI18nKey(profileName));
        action.click(driver.findElement(By.xpath(String.format("//a[text()='%s']", profileOption))));
        return new User();
    }
}

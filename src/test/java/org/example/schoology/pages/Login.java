package org.example.schoology.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.Environment;
import org.example.core.ui.AbstractPage;

public class Login extends AbstractPage {

    @FindBy(css = "#edit-mail")
    private WebElement usernameTextField;

    @FindBy(css = "#edit-pass")
    private WebElement passwordTextField;

    @FindBy(css = "#edit-submit")
    private WebElement loginButton;

    @FindBy(css = "#confirmation_cancel")
    private WebElement cancelVerifyYourAccountButton;

    @FindBy(css = "#site-navigation-footer button")
    private WebElement changeLanguageButton;

    @FindBy(css = "span[class*='LanguageSwitcher']:nth-child(1) button")
    private WebElement saveChangeLangButton;

    // Todo
    public Home loginAs(final String username, final String pass) {
        driver.manage().deleteAllCookies();
        driver.get("https://app.schoology.com/login");
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(pass);
        loginButton.click();
        verifyYourAccount();
        verifyLanguage();
        return new Home();
    }

    private void verifyYourAccount() {
        try {
            // Changing timeout
            driver.manage().timeouts().implicitlyWait(MIN_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            cancelVerifyYourAccountButton.click();
        } catch (NoSuchElementException e) {
            // nothing.
        } finally {
            // Restore timeout
            driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        }
    }

    public void verifyLanguage() {
        final String language = Environment.getInstance().getValue("language");
        if (!changeLanguageButton.getText().toLowerCase().contains(language)) {
            changeLanguageButton.click();
            action.jsClick(driver.findElement(By.cssSelector(String.format("input[value='%s']", language))));
            saveChangeLangButton.click();
        }
    }

}

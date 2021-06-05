package org.example.schoology.steps;

import java.util.Arrays;
import java.util.ResourceBundle;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.schoology.pages.resources.I18NResource;
import org.testng.asserts.Assertion;

import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ui.SharedDriver;
import org.example.schoology.Resources;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.courses.CourseForm;
import org.example.schoology.pages.courses.I18NCourse;
import org.example.schoology.pages.groups.GroupForm;
import org.example.schoology.pages.resources.AddFolderForm;

public class CommonStepDefs {

    private final Assertion assertion;

    private Home home;

    private ResourceBundle resourceBundle;

    public CommonStepDefs(final SharedDriver sharedDriver, final AssertionGroup assertionGroup) {
        assertion = assertionGroup.getAssertion();
        resourceBundle = ResourceBundle.getBundle(Resources.I18N_COURSE,
                Environment.getInstance().getLocale());
    }

    @DataTableType
    public CourseForm courseMap(final String courseFormField) {
        return Arrays.stream(CourseForm.values())
                .filter(e -> e.getName().equalsIgnoreCase(courseFormField))
                .findFirst()
                .orElseThrow();
    }

    @DataTableType
    public GroupForm groupMap(final String groupFormField) {
        return Arrays.stream(GroupForm.values())
                .filter(e -> e.getName().equalsIgnoreCase(groupFormField))
                .findFirst()
                .orElseThrow();
    }

    @DataTableType
    public AddFolderForm resourceMap(final String addFolderFormField) {
        return Arrays.stream(AddFolderForm.values())
                .filter(e -> e.getName().equalsIgnoreCase(addFolderFormField))
                .findFirst()
                .orElseThrow();
    }

    @Given("I log in as {string} user")
    public void iLogInAsUser(final String account) {
        Login login = new Login();
        home = login.loginAs(Environment.getInstance().getValue(String.format("credentials.%s.username", account)),
                Environment.getInstance().getValue(String.format("credentials.%s.password", account)));
    }

    @When("I navigate to {string}")
    public void iNavigateToCourses(final String menu) {
        SubMenu subMenu = home.clickMenu(resourceBundle.getString(menu.toLowerCase()));
        // Not put logic
        // for instance: if else, loops read files, handles strings, mathematical operations.
        subMenu.clickViewListLink(menu);
    }

    @Then("I should see the {string} message")
    public void iShouldSeeTheMessage(final String message) {
        assertion.assertEquals(new ViewList().getMessage(), resourceBundle.getString(I18NCourse.getI18nKey(message)),
                "Message banner");
    }

    @Then("I should see the {string} message in Resources")
    public void iShouldSeeTheMessageInResources(final String message) {
        resourceBundle = ResourceBundle.getBundle(Resources.I18N_RESOURCE,
                Environment.getInstance().getLocale());
        assertion.assertEquals(new ViewList().getMessage(), resourceBundle.getString(I18NResource.getI18nKey(message)),
                "Message banner");
    }

}

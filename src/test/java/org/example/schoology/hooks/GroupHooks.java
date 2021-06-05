package org.example.schoology.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.pages.courses.DeletePopup;
import org.example.schoology.pages.groups.Groups;

public class GroupHooks {

    public static final String GROUP_KEY = "GroupKey";

    private final ScenarioContext context;

    public GroupHooks(final ScenarioContext context) {
        this.context = context;
    }

    @Before
    public void beforeScenario() {
        // this will be executed in all the scenarios
    }

    @After(value = "@deleteGroup")
    public void deleteGroup() {
        // delete by UI (~10 sec)
        DriverFactory.getDriver().get("https://app.schoology.com/groups");
        DeletePopup deletePopup = new Groups().clickDeleteGroup(context.getValue(GROUP_KEY));
        deletePopup.clickDeleteButton();

        // delete by Rest API (~3 milli seconds)
    }

}

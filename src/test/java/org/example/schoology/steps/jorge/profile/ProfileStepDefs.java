package org.example.schoology.steps.jorge.profile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ScenarioContext;
import org.example.schoology.Resources;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.groups.GroupForm;
import org.example.schoology.pages.groups.Groups;
import org.example.schoology.pages.jorge.user.User;
import org.testng.asserts.Assertion;

import java.util.Map;
import java.util.ResourceBundle;

public class ProfileStepDefs {

    private User user;

    private Home home;

    private final Assertion assertion;

    private final ScenarioContext context;

    private ResourceBundle resourceBundle;

    public ProfileStepDefs(final AssertionGroup assertionGroup, final ScenarioContext context, final User user) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.user = user;
        resourceBundle = ResourceBundle.getBundle(Resources.I18N_USER, Environment.getInstance().getLocale());
    }

    @And("I update the profile {string} with:")
    public void iUpdateTheProfileWith(String account, final Map<String, String> profileData) {
        home = new Home();
        user = home.clickProfile(account);
        user.updateProfile(profileData);
    }

    @When("I save changes")
    public void iSaveChanges() {
        user.clickSaveChanges();
    }
}

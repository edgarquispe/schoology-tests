package org.example.schoology.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ScenarioContext;
import org.example.schoology.Resources;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.ViewList;
import org.example.schoology.pages.resources.AddFolderForm;
import org.example.schoology.pages.resources.CreateFolderResourcePopup;
import org.example.schoology.pages.resources.ResourcesPage;
import org.testng.asserts.Assertion;

import java.util.Map;
import java.util.ResourceBundle;

public class ResourcesStepDefs {

    private final ScenarioContext context;

    private ResourcesPage resources;

    private final Home home;

    private final Assertion assertion;

    private final ResourceBundle bundle;

    private final String keyResources = "resources";

    public ResourcesStepDefs(final AssertionGroup assertionGroup, final ScenarioContext context, final ResourcesPage resources) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        this.resources = resources;
        this.home = new Home();
        bundle = ResourceBundle.getBundle(Resources.I18N_RESOURCE, Environment.getInstance().getLocale());
    }

    @And("I add a folder in resources with:")
    public void iCreateAFolderInResourcesWith(final Map<AddFolderForm, String> datatable) {
        String resource = bundle.getString(keyResources);
        home.clickMenu(resource);
        CreateFolderResourcePopup createFolderResourcePopup = this.resources.clickCreateFolderButton();
        createFolderResourcePopup.create(datatable);
    }

    @When("I delete the {string} resource")
    public void iDeleteTheFolderResource(final String name) {
        new ViewList().waitForMessageToBeHidden();
        resources.deleteFolderResource(name);
    }

    @And("I should not see {string} resource")
    public void iShouldNotSeeTheResource(final String name) {
        String resource = bundle.getString(keyResources);
        home.clickMenu(resource);
        assertion.assertFalse(resources.verifyFolderResourceExists(name));
    }
}

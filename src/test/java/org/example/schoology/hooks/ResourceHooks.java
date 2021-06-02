package org.example.schoology.hooks;

import io.cucumber.java.After;
import org.example.core.Environment;
import org.example.core.ScenarioContext;
import org.example.core.ui.DriverFactory;
import org.example.schoology.Resources;
import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.resources.ResourcesPage;

import java.util.Arrays;
import java.util.ResourceBundle;

public class ResourceHooks {

    private ScenarioContext context;

    public ResourceHooks(final ScenarioContext context) {
        this.context = context;
    }

    @After(value = "@deleteResources")
    public void deleteResource() {
        DriverFactory.getDriver().get("https://app.schoology.com");
        String keyResource  = ResourceBundle.getBundle(Resources.I18N_MENU,
                Environment.getInstance().getLocale()).getString(Constants.RESOURCES.toLowerCase());
        new Home().clickMenu(keyResource);
        Arrays.stream(context.getValue(Constants.RESOURCE_KEY).split(",")).forEach(resource -> {
            new ResourcesPage().deleteResource(resource);
        });
    }

}

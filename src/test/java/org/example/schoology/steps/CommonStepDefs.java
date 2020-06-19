package org.example.schoology.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Environment;
import org.example.SharedDriver;
import org.example.schoology.pages.Home;
import org.example.schoology.pages.Login;
import org.example.schoology.pages.SubMenu;
import org.example.schoology.pages.ViewList;
import org.testng.Assert;

public class CommonStepDefs {

	private Home home;

	private SubMenu subMenu;

	public CommonStepDefs(SharedDriver sharedDriver) {

	}

	@Given("I log in as {string} user")
	public void iLogInAsUser(String account) {
		Login login = new Login();
		home = login.loginAs(Environment.getInstance().getValue(String.format("credentials.%s.username", account)),
				Environment.getInstance().getValue(String.format("credentials.%s.password", account)));
	}

	@When("I navigate to {string}")
	public void iNavigateToCourses(String menu) {
		subMenu = home.clickMenu(menu);
		subMenu.clickViewListLink(menu);
	}

	@Then("I should see the {string} message")
	public void iShouldSeeTheMessage(String message) {
		Assert.assertEquals(message, new ViewList().getMessage());
	}

}

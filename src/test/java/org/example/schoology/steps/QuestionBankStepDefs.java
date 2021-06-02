package org.example.schoology.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.core.AssertionGroup;
import org.example.core.Environment;
import org.example.core.ScenarioContext;
import org.example.schoology.Resources;
import org.example.schoology.constants.Constants;
import org.example.schoology.pages.questions.CreateQuestionAbstract;
import org.example.schoology.pages.resources.AddResourcePopupAbstract;
import org.example.schoology.pages.resources.QuestionBankResource;
import org.example.schoology.pages.resources.ResourcesPage;
import org.testng.asserts.Assertion;

import java.util.Map;
import java.util.ResourceBundle;

public class QuestionBankStepDefs {

    private final ScenarioContext context;

    private final Assertion assertion;

    // Pages
    private ResourcesPage resources;
    private QuestionBankResource questionBankResource;

    private final ResourceBundle bundle;


    public QuestionBankStepDefs(final AssertionGroup assertionGroup,
                            final ScenarioContext context) {
        assertion = assertionGroup.getAssertion();
        this.context = context;
        bundle = ResourceBundle.getBundle(Resources.I18N_RESOURCE, Environment.getInstance().getLocale());
    }

    @When("I create a {string} resource with:")
    public void createResource(final String resourceType, final Map<String, String> resourceMap) {
        resources = new ResourcesPage();
        AddResourcePopupAbstract addResourcePopup = resources.clickAddResources(resourceType);
        addResourcePopup.addResource(resourceMap);
        context.setContext(Constants.RESOURCE_KEY, resourceMap.get(Constants.NAME));
    }

    @When("I open the {string} question bank resource")
    public void openResource(final String resourceName) {
        resources = new ResourcesPage();
        resources.openQuestionBankResource(resourceName);
    }

    @When("I add a {string} question with:")
    public void addQuestion(final String questionType, final Map<String, String> questionMap) {
        questionBankResource = new QuestionBankResource();
        CreateQuestionAbstract createQuestion = questionBankResource.openCreateQuestion(questionType);
        questionBankResource = createQuestion.createQuestion(questionMap);
    }

    @Then("I should see the {string} Question Bank resource with questions:")
    public void verifyResourceIsCreated(final String resourceName, final DataTable questionsTable) {
        QuestionBankResource questionBankResource = new QuestionBankResource();
        assertion.assertEquals(questionBankResource.getResourceName(), resourceName);
        questionsTable.asMaps().forEach(questionMap -> {
            assertion.assertTrue(questionBankResource.isQuestionDisplayed(questionMap.get(Constants.TITLE)));
            assertion.assertEquals(questionBankResource.getQuestionTypeByTitle(questionMap.get(Constants.TITLE)),
                    bundle.getString(questionMap.get(Constants.QUESTION_TYPE)));
        });
    }
}

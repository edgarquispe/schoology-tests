package org.example.schoology.pages.questions;

import org.example.core.Environment;
import org.example.schoology.Resources;
import org.example.schoology.constants.Constants;
import org.example.schoology.pages.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CreateTrueFalseQuestion extends CreateQuestionAbstract {

    @FindBy(css = "#edit-correct")
    private WebElement correctAnswerSelect;

    @Override
    public Map<String, Step> getStepsMap(final Map<String, String> questionMap) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put(Constants.TITLE, () -> setTitle(questionMap.get(Constants.TITLE)));
        stepsMap.put(Constants.CORRECT_ANSWER, () -> selectCorrectAnswer(questionMap.get(Constants.CORRECT_ANSWER)));
        return stepsMap;
    }

    private void selectCorrectAnswer(final String correctAnswerOption) {
        String keyCorrectAnswer = "resource." + correctAnswerOption.toLowerCase();
        String correctAnswer = ResourceBundle.getBundle(Resources.I18N_RESOURCE,
                Environment.getInstance().getLocale()).getString(keyCorrectAnswer);
        action.selectDropDown(correctAnswerSelect, correctAnswer);
    }
}

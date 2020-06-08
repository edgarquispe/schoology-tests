package org.example.schoology.tests;

import org.example.schoology.pages.*;
import org.junit.Test;

public class ResourcesTest {

    public static final String PREFIX_AT = "AT";

    @Test
    public void deleteQuestionBank() {

        Login login = new Login();
        Home home = login.loginAs("carledriss+01@gmail.com", "P@ssw0rd");
        Resources resourcePage = home.clickMenuResource("Resources");
        resourcePage.addResource();
        resourcePage.addQuestionBank();

        String questionBankName = PREFIX_AT + "question bank" + System.currentTimeMillis();


    }
}

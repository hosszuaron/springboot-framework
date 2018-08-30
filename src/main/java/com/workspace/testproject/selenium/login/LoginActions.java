package com.workspace.testproject.selenium.login;

import org.springframework.stereotype.Component;

@Component
public class LoginActions {

    public void loginForAllPartners() {

        LoginFill loginFill = new LoginFill();
        loginFill.fillLoginFields(loginFill.getLoginFields());

        LoginElements loginElements = new LoginElements();
        loginElements.waitForClickableSubmitButton();
        loginElements.getSubmitButton().click();
    }
}

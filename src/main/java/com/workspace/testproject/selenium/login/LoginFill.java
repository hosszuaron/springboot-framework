package com.workspace.testproject.selenium.login;

public class LoginFill{

    private final String email = "aron.hosszu@accesa.eu";
    private final String password = "princesses";

    public LoginFields getLoginFields() {

        LoginFields loginFields = new LoginFields();
        loginFields.setEmail(email);
        loginFields.setPassword(password);
        return loginFields;
    }

    public void fillLoginFields(LoginFields loginFields) {

        LoginElements loginElements = new LoginElements();
        loginElements.waitForEmail();
        loginElements.getEmail().sendKeys(loginFields.getEmail());
        loginElements.getPassword().sendKeys(loginFields.getPassword());
    }
}

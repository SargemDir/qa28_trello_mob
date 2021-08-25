package com.elena.mob.tests;

import org.testng.annotations.Test;

public class LoginTests extends  TestBase{
    @Test
    public void TestLogin() throws InterruptedException {
        app.welcomeActivity().initLogin();
        app.loginActivity().fillLoginForm();
        app.loginActivity().confirmLogin();
    }
}

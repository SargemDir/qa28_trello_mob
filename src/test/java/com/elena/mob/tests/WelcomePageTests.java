package com.elena.mob.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WelcomePageTests extends TestBase{
    SoftAssert softAssert = new SoftAssert ();

    @Test
    public void swipeWelcomePageTest(){
        int pagesCount = 4;
        for(int i =0; i<4; i++) {
            String title = app.welcomeActivity().getTitle();
            System.out.println(title);
            Assert.assertTrue(app.welcomeActivity().isLoginButtonPresent(), "There isn't 'Login' button on the '" + title + "' page");
            Assert.assertTrue(app.welcomeActivity().isSignUpButtonPresent(), "There isn't 'Sign up' button on the '" + title + "' page");
          //  softAssert.assertTrue(app.welcomeActivity().isLoginButtonPresent(), "There isn't 'Login' button on the '" + title + "' page");
            app.welcomeActivity().swipePageToTheLeft();

        }
    }

}

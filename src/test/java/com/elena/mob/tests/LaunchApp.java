package com.elena.mob.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LaunchApp extends  TestBase{
    @Test
    public void testLaunchApp(){
        logger.info("app Trello is runned.");
        Assert.assertTrue(app.welcomeActivity().isHelloPresent());

    }
}

package com.elena.mob.tests;

import com.elena.mob.framework.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        // Capabilities caps = new DesiredCapabilities();
        app.init();
    }


    @AfterSuite(enabled = false)
    public void tearDown() throws InterruptedException {
      // app.board().clearBoardList();
        app.stop();
    }

    @BeforeMethod
    public void startLogger(Method m, Object[] p){

        logger.info("start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopLogger(Method m){
        logger.info("stop test " + m.getName());
    }
}

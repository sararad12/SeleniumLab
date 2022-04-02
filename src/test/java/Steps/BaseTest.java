package Steps;

import Utils.Driver;
import Utils.PropertiesReadingUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import Utils.Driver;
import Utils.PropertiesReadingUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class BaseTest {



        @BeforeTest
        public void beforeTest(){
            Driver.getDriver().manage().deleteAllCookies();
            Driver.getDriver().get(PropertiesReadingUtil.getProperties("URL"));
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }
        @AfterTest
        public void afterTest(){
            Driver.getDriver().quit();
        }
    }

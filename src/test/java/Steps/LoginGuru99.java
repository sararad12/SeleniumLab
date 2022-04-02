package Steps;

import Utils.Driver;
import Utils.PropertiesReadingUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CustPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginGuru99 extends BaseTest {

        Faker faker = new Faker();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        CustPage newCustomerPage = new CustPage();

        @Test
        public void TC_1_LoginGuru99() {

            String expectedTitle = "Guru99 Bank";
            String actualTitle = loginPage.loginPageTitle.getText();
            Assert.assertEquals(expectedTitle, actualTitle);


            loginPage.userIdInput.sendKeys(PropertiesReadingUtil.getProperties("userID"));
            loginPage.userPasswordInput.sendKeys(PropertiesReadingUtil.getProperties("password"));
            loginPage.loginButton.click();

            String expectedMangerText ="Manger Id : "+PropertiesReadingUtil.getProperties("userID");
            String actualMangerText = Driver.getDriver().findElement(By.xpath("//td[text()='Manger Id : "+PropertiesReadingUtil.getProperties("userID")+"']")).getText();
            Assert.assertEquals(expectedMangerText,actualMangerText);


            homePage.newCustomerButton.click();


            String expectedNewCustomerTitle = "Add New Customer";
            String actualNewCustomerTitle =  newCustomerPage.newCustomerTitle.getText();
            Assert.assertEquals(expectedNewCustomerTitle, actualNewCustomerTitle);

            newCustomerPage.newCustomerName.sendKeys(faker.name().fullName().replace("-",""));
            newCustomerPage.maleRadioButton.click();
            newCustomerPage.setDate("1993","11","01");
            newCustomerPage.addressInput.sendKeys("Mars");
            newCustomerPage.cityInput.sendKeys("Toronto");
            newCustomerPage.stateInput.sendKeys("Canada");
            newCustomerPage.pinnoInput.sendKeys("4546734564");
            newCustomerPage.telephoneNoInput.sendKeys("4161234567");
            newCustomerPage.emailInput.sendKeys(faker.internet().emailAddress());
            newCustomerPage.passwordInput.sendKeys("6262");
            newCustomerPage.submitButton.click();

            String expectedSuccessMessage = "Customer Registered Successfully!!!";
            String actualSuccessMessage = newCustomerPage.successMessage.getText();
            Assert.assertEquals(expectedSuccessMessage,actualSuccessMessage);
        }
    }


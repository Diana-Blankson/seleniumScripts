package demonopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Map;

public class Registration {
    private final WebDriver driver;
    private final Map<String, String> data;

    Registration(WebDriver driver){
        this.driver = driver;
        this.data = new Credentials().getAllCredentials();
    }
    public void testRegistration(){

        //driver.findElement(By.linkText("Register"));
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        //Fill form
        WebElement radioButton = driver.findElement(By.cssSelector("label[for='gender-female']"));
        radioButton.click();
        Assert.assertTrue(radioButton.isEnabled());


        driver.findElement(By.id("FirstName")).sendKeys(data.get("fName"));
        driver.findElement(By.name("LastName")).sendKeys(data.get("lName"));

        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));

        selectDay.selectByVisibleText("15");
        selectMonth.selectByVisibleText("October");
        selectYear.selectByVisibleText("2024");

        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(data.get("email"));
        driver.findElement(By.id("Company")).sendKeys(data.get("companyName"));
        driver.findElement(By.id("Password")).sendKeys(data.get("password"));

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys(data.get("wrongPassword"));
        driver.findElement(By.id("register-button")).click();

        WebElement errorMessage = driver.findElement(By.id("ConfirmPassword-error"));
        String expectedErrorMessage = "The password and confirmation password do not match.";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);

        //confirmPassword.clear();


    }


    public static void main (String []args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        //url.navigateToUrl();

        Registration register = new Registration(url.driver);
        register.testRegistration();
    }
}

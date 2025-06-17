 package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class LoginTest {

    private final  WebDriver driver;
    private final Map<String, String> data;


    LoginTest(WebDriver driver){
      this.driver = driver;
      this.data = new KeyValueObj().getAllData();

    }

    public void testLoginForm(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys(data.get("username"));
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(data.get("password"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement message = driver.findElement(By.id("flash"));
        String actualText = message.getText().replace("×","").trim();
        Assert.assertEquals(actualText,data.get("expectedTextLogin"));

    }

    public void logout(){
        driver.findElement(By.cssSelector("a[href='/logout']")).click();
    }

    public static void main (String[]args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        LoginTest login = new LoginTest(url.driver);
        login.testLoginForm();
        login.logout();
    }
}

package herokuapp;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Map;

public class Authentication {
    private final WebDriver driver;
    private final Map<String, String> data;

    Authentication(WebDriver driver){
        this.driver = driver;
        this.data = new KeyValueObj().getAllData();
    }

    public void testAuthentication(){
        //driver.findElement(By.linkText("Basic Auth")).click();
        driver.get(data.get("authenticationUrl"));

       // driver.get("https://the-internet.herokuapp.com/basic_auth");



        WebElement text = driver.findElement(By.id("content"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());


    }


    public static void main (String [] args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        //url.navigateToUrl();

        Authentication authenticate = new Authentication(url.driver);
        authenticate.testAuthentication();
    }
}

package demonopCommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Login {

    private final WebDriver driver;
    private final Map<String, String> data;


    Login (WebDriver driver){
        this.driver = driver;
        this.data = new Credentials().getAllCredentials();
    }

    public void testLogin(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        driver.findElement(By.className("email")).sendKeys(data.get("email"));
        driver.findElement(By.className("password")).sendKeys(data.get("password"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

    }
    public static void main (String []args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        //url.navigateToUrl();

        Login signIn = new Login(url.driver);
        signIn.testLogin();
    }
}

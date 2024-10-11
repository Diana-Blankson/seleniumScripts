package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Navigation {
    private final WebDriver driver;

    Navigation(WebDriver driver){
        this.driver = driver;
    }

    public void testRefreshNavigation(){
        //driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dynamic Content")).click();

        WebElement firstContent = driver.findElements(By.cssSelector("div[class='large-10 columns']")).getFirst();
        System.out.println(firstContent.getText());
        String textBeforeRefresh = firstContent.getText();

        driver.navigate().refresh();

        //reinitialize element again after refresh
        firstContent = driver.findElements(By.cssSelector("div[class='large-10 columns']")).getFirst();
        System.out.println(firstContent.getText());
        String textAfterRefresh = firstContent.getText();

        Assert.assertNotEquals(textBeforeRefresh,textAfterRefresh);
    }

    public void testNavigateBack(){
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://the-internet.herokuapp.com/");

    }

    public void testNavigateForward(){
        driver.navigate().forward();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://the-internet.herokuapp.com/dynamic_content");

    }

    public static void main (String[] args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        Navigation navigate = new Navigation(url.driver);
        navigate.testRefreshNavigation();
        navigate.testNavigateBack();
        navigate.testNavigateForward();
  }
}

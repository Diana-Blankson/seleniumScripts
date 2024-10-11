package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ExplicitWaits {
    private final WebDriver driver;

    ExplicitWaits(WebDriver driver){
        this.driver=driver;
    }

    public void testExplicitWaits(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.cssSelector("a[href='/dynamic_loading/1']")).click();
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loading"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[contains(text(),'Hello World')]"))));

        // Assert.assertEquals(element.getText(),"Hello World!");

    }
    public static void main(String [] args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        ExplicitWaits waits = new ExplicitWaits(url.driver);
        waits.testExplicitWaits();

    }
}

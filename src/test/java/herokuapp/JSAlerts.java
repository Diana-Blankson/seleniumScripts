package herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlerts {
    private final WebDriver driver;

    JSAlerts(WebDriver driver){
        this.driver = driver;
    }
    public void testAlerts(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Alert alertText = driver.switchTo().alert();
        System.out.println(alertText.getText());
        alertText.accept();
    }
    public void testConfirmation(){
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        Alert alertText = driver.switchTo().alert();
        System.out.println(alertText.getText());
        alertText.accept();
    }

    public void testPrompt(){
        driver.findElement(By.cssSelector("button[onclick='jsPrompt ()']")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Selenium ");
        alert.accept();
    }


    public static void main(String [] args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        JSAlerts alerts = new JSAlerts(url.driver);
        alerts.testAlerts();
        alerts.testConfirmation();
        alerts.testPrompt();

    }
}

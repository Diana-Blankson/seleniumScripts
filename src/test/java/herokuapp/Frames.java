package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames {
    private final WebDriver driver;

    Frames(WebDriver driver){
        this.driver = driver;
    }

    public void page(){
        driver.get("https://letcode.in/frame");
        System.out.println(driver.getTitle());
    }

    public void testFrames(){

        //driver.switchTo().frame(0);
        driver.switchTo().frame("firstFr");
        driver.findElement(By.cssSelector("input[placeholder='Enter name']")).sendKeys("Diana");

        WebElement innerFrame = driver.findElement(By.cssSelector("iframe[src=innerFrame]"));
        driver.switchTo().frame(innerFrame);
        driver.findElement(By.name("email")).sendKeys("dianablankson20@gmail.com");

        driver.switchTo().parentFrame();
        driver.findElement(By.name("lname")).sendKeys("Blankson");

        driver.switchTo().defaultContent();
       // driver.findElement(By.linkText("Watch tutorial")).click();

    }
    public static void main (String[]args){
        VisitPage browser = new VisitPage();
        browser.browserSetUp();

        Frames iframe = new Frames(browser.driver);
        iframe.page();
        iframe.testFrames();

        }

    }

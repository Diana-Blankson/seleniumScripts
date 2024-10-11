package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class KeyboardKeys {
    private final WebDriver driver;
    String generalText = "You entered:";

    KeyboardKeys(WebDriver driver){
        this.driver= driver;
    }

    public void testEnterKey(){
        driver.findElement(By.linkText("Key Presses")).click();

        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.ENTER);

    }

    public void testEscape(){
        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.ESCAPE);
        WebElement actualText = driver.findElement(By.id("result"));
        Assert.assertEquals(actualText.getText(), generalText + " " + "ESCAPE");
    }

    public void multipleKeys(){
        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.chord(Keys.SHIFT), "L");
    }

    public static void main (String [] args ){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        KeyboardKeys keyboard = new KeyboardKeys(url.driver);
        keyboard.testEnterKey();
        keyboard.testEscape();
        keyboard.multipleKeys();

    }
}

package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsAction {

    //webDriver object
    private final WebDriver driver;

    InputsAction(WebDriver driver) {
        this.driver = driver;
    }

    public void testInputs(){
        //driver.findElement(By.linkText("Inputs")).click();
        WebElement clickInputText = driver.findElement(By.linkText("Inputs"));
        clickInputText.click();

        WebElement inputField = driver.findElement(By.cssSelector("input[type='number']"));
        inputField.sendKeys("700");
        inputField.clear();

        //driver.quit();
    }

    public static void main(String [] args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        InputsAction input = new InputsAction(url.driver);
        input.testInputs();

    }
}

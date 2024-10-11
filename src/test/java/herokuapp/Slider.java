package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    private final WebDriver driver;

    Slider(WebDriver driver){
        this.driver=driver;
    }

    public void testSliders(){
        driver.findElement(By.linkText("Horizontal Slider")).click();

        //Use arrow key
        WebElement element = driver.findElement(By.cssSelector("input[type='range']"));
        element.sendKeys(Keys.ARROW_RIGHT);

        //Slide
        Actions action = new Actions(driver);
        action.moveToElement(element);
        //action.dragAndDropBy(element, 100, 0);

    }

    public static void main (String [] args ) {
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        Slider slide = new Slider(url.driver);
        slide.testSliders();
    }
}

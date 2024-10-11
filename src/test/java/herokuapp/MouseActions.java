package herokuapp;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MouseActions {
    private final WebDriver driver;

    MouseActions(WebDriver driver){
        this.driver = driver;

    }

    public void testHover(){
        driver.findElement(By.linkText("Hovers")).click();

        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector("img[alt = 'User Avatar']"));
        actions.moveToElement(element).perform();


        WebElement text = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        Assert.assertEquals(text.getText() , "name: user1");
        Assert.assertTrue(text.isDisplayed());

    }

    public void rightClick() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();

        Alert alertText = driver.switchTo().alert();
        Assert.assertEquals(alertText.getText(),"You selected a context menu");
        alertText.accept();

    }

    public static void main (String [] args ) {
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        MouseActions action = new MouseActions(url.driver);
        action.testHover();
        action.rightClick();

    }
}

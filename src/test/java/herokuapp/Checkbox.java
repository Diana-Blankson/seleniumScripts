package herokuapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Checkbox {
    private final WebDriver driver;

    Checkbox(WebDriver driver) {
        this.driver = driver;
    }
    public void testCheckbox(){
        WebElement checkboxText = driver.findElement(By.linkText("Checkboxes"));

        String fontColor = checkboxText.getCssValue("color");
        String lineHeight = checkboxText.getCssValue("line-height");
        String fontWeight = checkboxText.getCssValue("font-weight");

        System.out.println(fontColor);
        System.out.println(lineHeight);
        System.out.println(fontWeight);

        checkboxText.click();


        WebElement checkbox1 = driver.findElements(By.cssSelector("input[type='checkbox']")).getFirst();
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());


        WebElement checkbox2 = driver.findElements(By.cssSelector("input[type='checkbox']")).getLast();
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());


    }

    public static void main(String []args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        Checkbox check = new Checkbox(url.driver);
        check.testCheckbox();


    }
}


package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropDown {
    private final WebDriver driver;

    DropDown(WebDriver driver){
        this.driver=driver;
    }

    public void testDropDownDemo(){
        WebElement dropDownText = driver.findElement(By.linkText("Dropdown"));
        dropDownText.click();


        Select selectOption = new Select(driver.findElement(By.id("dropdown"))) ;
        selectOption.selectByVisibleText("Option 1");

        //Assert.assertTrue(selectOption.isSelected());

    }
    public static void main(String[] args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url .navigateToUrl();

        DropDown drop = new DropDown(url.driver);
        drop.testDropDownDemo();

    }
}

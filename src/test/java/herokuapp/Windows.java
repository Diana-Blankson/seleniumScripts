package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

public class Windows {
    private final WebDriver driver;

     Windows (WebDriver driver){
        this.driver=driver;
    }

    public void testNavigateToWindowPage(){
        driver.findElement(By.linkText("Multiple Windows")).click();

    }
    public void testClickNewWindow(){
        driver.findElement(By.linkText("Click Here")).click();
    }
    public void testOriginalWindowAssertion(){
        String originalWindowUrl = driver.getCurrentUrl();
        System.out.println(originalWindowUrl);
        Assert.assertEquals(originalWindowUrl,"https://the-internet.herokuapp.com/windows");

    }

    public void testSwitchToNewWindow(){
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

    }

    public void testNewWindowAssertion(){
        String title=driver.getTitle();
        Assert.assertEquals(title,"New Window");

        String newWindowUrl = driver.getCurrentUrl();
        System.out.println(newWindowUrl);
        Assert.assertEquals(newWindowUrl,"https://the-internet.herokuapp.com/windows/new");
    }

    public void testSwitchToOriginalWindow(){
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[0]);

    }


    public void createNewWindow(){
        driver.switchTo().newWindow(WindowType.TAB);

        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void testCloseCurrentWindow(){
        driver.close();
    }

    public void testCloseAllSessions(){
        driver.quit();
    }

    public static void main (String [] args ) {
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        Windows window = new Windows(url.driver);

        window.testNavigateToWindowPage();
        window.testOriginalWindowAssertion();
        window.testClickNewWindow();


        window.testSwitchToNewWindow();
        window.testNewWindowAssertion();

        window.testSwitchToOriginalWindow();
        window.testOriginalWindowAssertion();
        window.testClickNewWindow();

        window.testSwitchToNewWindow();
        window.testNewWindowAssertion();

        window.createNewWindow();

        window.testCloseCurrentWindow();
        window.testCloseAllSessions();

    }
}

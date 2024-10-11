package herokuapp;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

public class MainTest {


    public static void main(String [] args){



        System.setProperty("Webdriver.chrome.driver", "resources/chromedriver/chromedriver-win64/chromedriver.exe");


        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--remote-allow-origins=*");
        chromeOption.addArguments("--disable-extensions", "--incognito");
        WebDriver driver = new ChromeDriver(chromeOption);

        HasAuthentication authentication = (HasAuthentication) driver;

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        authentication.register(() -> new UsernameAndPassword("admin", "admin"));


        driver.get("https://the-internet.herokuapp.com/basic_auth");



    }
}

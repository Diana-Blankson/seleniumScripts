package herokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Map;


public class VisitPage {

    //webDriver object
    public  WebDriver driver;
    private final Map<String, String> data; ;

    VisitPage(){
        this.data = new KeyValueObj().getAllData();
    }

    public  void browserSetUp(){
        System.setProperty("WebDriver.chrome.driver", "resources/chromedriver/chromedriver-win64/chromedriver.exe");
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver();


        //Implicit Waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    }
    public void navigateToUrl(){
        driver.get(data.get("baseUrl")); 
        System.out.println(driver.getTitle());

    }

}

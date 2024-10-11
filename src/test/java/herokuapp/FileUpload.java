package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileUpload {

    private final WebDriver driver;

    FileUpload(WebDriver driver){
        this.driver=driver;
    }

    public void testFileUpload(){
        driver.findElement(By.linkText("File Upload")).click();

        WebElement fileInput = driver.findElement(By.id("file-upload"));
        String filePath = "C:\\Users\\DianaAborahBlankson\\Desktop\\seleniumTests\\resources\\files\\img.PNG";
        fileInput.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        //assertion
        WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'File Uploaded')]"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(),"File Uploaded!");

    }
    public static void main (String[]args){
        VisitPage url = new VisitPage();
        url.browserSetUp();
        url.navigateToUrl();

        FileUpload upload = new FileUpload(url.driver);
        upload.testFileUpload();


    }
}

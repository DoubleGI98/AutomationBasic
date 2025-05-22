import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class PracticAll {

    WebDriver driver;

    @Test

    public void practiceAll(){

        driver = new ChromeDriver();
        driver.get("https://www.vexio.ro/");
        //driver.manage().window().minimize();

//        try{
//        Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        driver.manage().window().maximize();

        WebElement searchBarField = driver.findElement(By.xpath("//input[@placeholder='Ce cauti azi?']"));
        String cuvant = "Wazney Card Riser pentru mining 8C PCIE V008c -4 condensatori";
        searchBarField.sendKeys(cuvant);
        WebElement butonCauta = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        butonCauta.click();

        try{
        Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
        WebElement productSelect = driver.findElement(By.xpath("//a[@class='preview btn'][@rel='nofollow']"));
        productSelect.click();





    }



      //WebDriverebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));







}

package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class AlertsTest extends BaseTest{



    @Test
    public void alertsTest(){
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesireMenu("Alerts, Frame & Windows");
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesireSubMenu("Alerts");
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.isPageLoaded();
        alertsPage.interactWithFirstAlert();
        alertsPage.interactWithTimerAlert();
        alertsPage.interactWithConfirmAlert("Cancel");
        //IMPLEMENTAREA BRUTA A TESTULUI

        //interactWithPromptButtonAlert("Eugen");


    }

//    public void openBrowser(){
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

//    public void choseMenu(){
//    WebElement alertsWindowsAndFramesMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        alertsWindowsAndFramesMenu.click();
//
//   }

//   public void scrollToElement(WebElement element){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//   }
//   // Mai trebuie adaugat scrollul , sau vazut defapt cum se poate importa in general (filmari mai vechi eventual)
//    // Update, sa te uiti in codul lui Maria din inregistrarea daca foloseste metoda scrollToElement
//
//
//    public void choseSubMenu(){
//        WebElement webTableSubMenu = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        webTableSubMenu.click();
//    }
//
//    public void interactWithFirstAlert(){
//        WebElement firstAlertButton = driver.findElement(By.id("alertButton"));
//        firstAlertButton.click();
//        Alert FirstAlert = driver.switchTo().alert();
//        FirstAlert.accept();
//    }
//
//    public void interactWithTimerAlert(){
//        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
//        timerAlertButton.click();
//        // Inainte sa schimbam focusul pe alerta , trebuie sa punem un wait explicit
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert timerAlert = driver.switchTo().alert();
//        timerAlert.accept();
//    }
//
//    public void interactWithConfirmAlert(String alertValue){
//        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
//        confirmAlertButton.click();
//        Alert confirmAlert = driver.switchTo().alert();
//        if (alertValue.equals("Ok")){
//            confirmAlert.dismiss();
//            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//            Assert.assertTrue(alertResultText.getText().contains(alertValue),"You didn't select Cancel. You selected: " + alertResultText.getText());
//
//        }
//        if (alertValue.equals("Cancel")){
//            confirmAlert.dismiss();
//            WebElement alertResultText = driver.findElement(By.id("confirmResult"));
//            Assert.assertTrue(alertResultText.getText().contains(alertValue),"You didn't select Cancel. You selected: " + alertResultText.getText());
//
//        }
//
//
//    }
//
//    public void interactWithPromptButtonAlert(String alertValue){
//       WebElement promptButton = driver.findElement(By.id("promptButton"));
//        promptButton.click();
//       Alert promptAlert = driver.switchTo().alert();
//        String alertTextValue = "Eugen";
//        promptAlert.sendKeys(alertTextValue);
//        promptAlert.accept();
//       WebElement resultText = driver.findElement(By.id("promptResult"));
//
//   }

    }



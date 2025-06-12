package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;

import static constants.MenuConstants.ALERTS_FRAMES_WINDOWS_MENU;

public class FramesTest extends BaseTest{


    @Test
    public void FrameTest(){
        HomePage homePage = new HomePage(driver);
        homePage.isPageLoaded();
        homePage.goToDesiredMenu(ALERTS_FRAMES_WINDOWS_MENU);
        CommonPage commonPage = new CommonPage(driver);
        commonPage.isPageLoaded();
        commonPage.goToDesireSubMenu("Frames");
        FramesPage framesPage = new FramesPage(driver);
        framesPage.interactWithFrameOne();
        framesPage.interactWithFrameTwo();


    }
//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

//    public void choseMenu() {
//        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMenu.click();
//
//    }

//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//    }

//    public void choseSubMenu() {
//        WebElement webTableSubMenu = driver.findElement(By.xpath("//span[text()='Frames']"));
//        webTableSubMenu.click();
//    }

//    public void closeBrowser(){
//        driver.quit();
//    }

//    public void interactWithFrameOne(){
//        WebElement frameOneElement = driver.findElement(By.id("frame1"));
//        driver.switchTo().frame(frameOneElement);
//        WebElement frameOneTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameOneTextValue.getText(), expectedText, "Text is not displayed properly");
//        System.out.println("Frame one text is: " + frameOneTextValue.getText());
//        driver.switchTo().defaultContent(); // schimbare focus pe pagina initiala
//    }
//
//    public void interactWithFrameTwo(){
//        WebElement frameTwoElement = driver.findElement(By.id("frame2"));
//        driver.switchTo().frame(frameTwoElement);
//        WebElement frameTwoTextValue = driver.findElement(By.id("sampleHeading"));
//        String expectedText = "This is a sample page";
//        Assert.assertEquals(frameTwoTextValue.getText(), expectedText, "Text is not displayed properly");
//        System.out.println("Frame two text is: " + frameTwoTextValue.getText());
//        driver.switchTo().defaultContent();
//    }
}

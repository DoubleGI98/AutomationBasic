package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowsTest extends BaseTest{



    @Test
    public void WindowsTest() {

        choseMenu();
        choseSubMenu();
        interactWithNewTab();
        interactWithNewWindow();
        interactWithNewWindowMessage();
        closeBrowser();

    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

    public void choseMenu() {
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        elementsMenu.click();

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void choseSubMenu() {
        WebElement webTableSubMenu = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        webTableSubMenu.click();
    }

    public void interactWithNewTab(){
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        newTabButton.click();
        List<String>windowsList = new ArrayList<>(driver.getWindowHandles()); // declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1)); // ne mutam pe tabul nou deschis
        WebElement tabTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(tabTextValue.getText(), expectedText, "Text is not displayed properly");
        driver.close(); // close , inchide fereastra , quit , inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));
    }

    public void interactWithNewWindow(){
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        newWindowButton.click();
        List<String>windowsList = new ArrayList<>(driver.getWindowHandles()); // declaram o lista de ferestre
        driver.switchTo().window(windowsList.get(1)); // ne mutam pe tabul nou deschis
        WebElement WindowTextValue = driver.findElement(By.id("sampleHeading"));
        String expectedText = "This is a sample page";
        Assert.assertEquals(WindowTextValue.getText(), expectedText, "Text is not displayed properly");
        driver.close(); // close , inchide fereastra , quit , inchide intreaga instanta
        driver.switchTo().window(windowsList.get(0));
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void interactWithNewWindowMessage(){
        WebElement newWindowMessageButton = driver.findElement(By.id("messageWindowButton"));
        newWindowMessageButton.click();
        List<String>windowsList = new ArrayList<>(driver.getWindowHandles()); // declaram o lista de ferestre
        if(windowsList.size()>1){
            System.out.println("A new window has successfully been opened ");
        }else{
            System.out.println("New window can't be opened");
        }

    }

}
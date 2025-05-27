package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{

    // Locatori specifici paginii;

    private By alertsWindowsAndFramesMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By pageTitle=By.xpath("//img[@alt='Selenium Online Training']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void choseMenu(){
        scrollIntoElement(driver.findElement(alertsWindowsAndFramesMenu));
        driver.findElement(alertsWindowsAndFramesMenu).click();
    }

    public void scrollIntoElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Override
    public void isPageLoaded() {
        Assert.assertEquals(driver.findElement(pageTitle).getDomAttribute("alt"),"Selenium Online Training","Page is not loaded properly");
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FramesPage extends BasePage{
    //locatori specifici paginii;
    private By frameOneLocator = By.id("frame1");
    private By frameTextValueLocator = By.id("sampleHeading");
    private By frameTwoLocator = By.id("frame2");
    String expectedText = "This is a sample page";

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {

    }

    public void interactWithFrameOne(){

        driver.switchTo().frame(driver.findElement(frameOneLocator));
        Assert.assertEquals(driver.findElement(frameTextValueLocator).getText(), expectedText, "Text is not displayed properly");
        System.out.println("Frame one text is: " + driver.findElement(frameTextValueLocator).getText());
        driver.switchTo().defaultContent(); // schimbare focus pe pagina initiala
    }

    public void interactWithFrameTwo(){
        driver.switchTo().frame(driver.findElement(frameTwoLocator));
        Assert.assertEquals(driver.findElement(frameTextValueLocator).getText(), expectedText, "Text is not displayed properly");
        System.out.println("Frame two text is: " + driver.findElement(frameTextValueLocator).getText());
        driver.switchTo().defaultContent();
    }
}

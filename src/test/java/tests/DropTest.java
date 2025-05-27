package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DropTest extends BaseTest{



    @Test
    public void DroppableTest(){

        choseMenu();
        choseSubMenu();
        pickAndDropElement();
    }

//    public void openBrowser() {
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//    }

    public void choseMenu() {
        WebElement interactionMenu = driver.findElement(By.xpath("//h5[text()='Interactions']"));
        interactionMenu.click();

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void choseSubMenu() {
        WebElement droppableSubMenu = driver.findElement(By.xpath("//span[text()='Droppable']"));
        droppableSubMenu.click();
    }

    public void pickAndDropElement(){
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableElement = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String initialTargetText = droppableElement.getText();
        Actions action = new Actions(driver);
        action.dragAndDrop(draggableElement,droppableElement).release().perform(); // drag de la elementul draggableElement la droppableElement , lasam + perform
        Assert.assertNotEquals(droppableElement.getText(),initialTargetText,"Initial text is the same with actual text after element dropped");
        System.out.println("Initial text is: " + initialTargetText + " text after successfully dropped: " + droppableElement.getText());
    }
}

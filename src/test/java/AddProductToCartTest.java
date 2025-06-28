import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddProductToCartTest {
// Eventual adaugat un assert , doar ca verificare
    WebDriver driver;

    @Test
    public void executeTest(){
        openBrowser();
        acceptCookie();
        searchBarBox();
        addProductToWishlist();
        waitThreeSeconds();
        continueShopping();
        waitThreeSeconds();
        checkProductInWishList();
    }

    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://greeno.ro/ro/");
        driver.manage().window().maximize();
    }

    public void acceptCookie(){
        WebElement acceptCookieButton = driver.findElement(By.xpath("//span[contains(@class,'cookiesplus-accept-label')]"));
        acceptCookieButton.click();
    }

    public void searchBarBox(){
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'catalog')]"));
        searchBox.click();
        String searchedProduct = "Glutation, Gluthion, Antioxidant, 10 fiole pulbere, 10 fiole solvent, 600mg/4ml";
        searchBox.sendKeys(searchedProduct);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void addProductToWishlist(){
        WebElement productToWishList = driver.findElement(By.xpath("//button[contains(@class,'btn btn-product-list add-to-cart')]"));
        productToWishList.click();
    }

    public void checkProductInWishList(){
        WebElement verifyProductInWishlist = driver.findElement(By.xpath("//span[contains(@class,'cart-products-count-btn')]"));
        verifyProductInWishlist.click();

    }

    public void waitThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void continueShopping(){
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(@class,'btn btn-secondary btn-block')]"));
        continueButton.click();
    }
}

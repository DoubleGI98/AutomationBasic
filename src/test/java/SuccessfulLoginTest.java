import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SuccessfulLoginTest {
    // Eventual adaugat un assert , doar ca verificare
    WebDriver driver;

    @Test
    public void executeTest(){

        openBrowser();
        acceptCookie();
        accesLoginPage();
        loginAccount();
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

    public void accesLoginPage(){
        WebElement clickloginPicture = driver.findElement(By.xpath("//i[contains(@class,'fa fa-user fa-fw icon')]"));
        clickloginPicture.click();
    }

    public void loginAccount(){
        WebElement emailBox = driver.findElement(By.id("field-email"));
        emailBox.click();
        String email = "ionci.florin@gmail.com";
        emailBox.sendKeys(email);

        WebElement passwordBox = driver.findElement(By.id("field-password"));
        passwordBox.click();
        String passwordAccount = "Harababura55*";
        passwordBox.sendKeys(passwordAccount);

        WebElement authenticationButton = driver.findElement(By.id("submit-login"));
        authenticationButton.click();
    }

}

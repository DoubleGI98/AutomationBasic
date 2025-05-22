import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    WebDriver driver;
    public int initialTableSize = 0;
    String firstName = "Nasturel";
    String lastName = "Firicel";
    String userEmail = "test@gmail.com";
    String age = "30";
    String salary = "30000";
    String department = "Avocatura";

    @Test
    public void webTableTest(){
        openBrowser();
        chooseMenu();
        chooseSubmeniu();
        getTableSize();
        clickToAddNewRecord();
        fillFormValues();
        validateThatNewRecordsAreAddedProperly();

    }

    // Facem o metoda care deschide un browser
    public void openBrowser(){
        driver = new ChromeDriver();
        //Navigam catre pagina website-ului
        driver.get("https://demoqa.com/");
        // Facem fereastra browser-ului maximize
        driver.manage().window().maximize();
    }

    // Facem o metoda care alege un meniu
    public void chooseMenu(){
        //Identificam meniul dorit si facem click pe el
        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        // In caz ca nu se poate identifica elementul si e nevoie de scroll pt al putea gasii
      scrollToElement(elementsMenu);
        //js.executeScript("window.scrollBy(0,500)");
        //Actionam butonul pe meniul de mai sus
        elementsMenu.click();
    }

    // Facem o metoda care sa faca scroll
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    // Facem o metoda care sa selecteze sub-meniul

    public void chooseSubmeniu(){
        WebElement PracticeFormSubMeniu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        PracticeFormSubMeniu.click();
    }
    // Facem o metoda care sa ia numarul initial de randuri din tabel

    public int getTableSize() {
        List<WebElement> tableRowList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        initialTableSize = tableRowList.size();
        System.out.println("Numarul initial de randuri in tabel este: " + initialTableSize);
        return initialTableSize;
    }
    // Facem o metoda care sa faca click pe adaugare rand nou in tabel
    public void clickToAddNewRecord(){
        WebElement addNewRecordBtn = driver.findElement(By.id("addNewRecordButton"));
        addNewRecordBtn.click();
    }
    // Facem o metoda care completeze toate campurile din formular
    public void fillFormValues(){
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        //firstNameField.sendKeys("Nasturel");
        firstNameField.sendKeys(firstName);
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        //lastNameField.sendKeys("Firicel");
        lastNameField.sendKeys(lastName);
        WebElement userEmailField = driver.findElement(By.id("userEmail"));
       // userEmailField.sendKeys("test@test.com");
        userEmailField.sendKeys(userEmail);
        WebElement ageField = driver.findElement(By.id("age"));
        //ageField.sendKeys("25");
        ageField.sendKeys(age);
        WebElement salaryField = driver.findElement(By.id("salary"));
        //salaryField.sendKeys("30000");
        salaryField.sendKeys(salary);
        WebElement departmentField = driver.findElement(By.id("department"));
        //departmentField.sendKeys("IT");
        departmentField.sendKeys(department);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }
    // Facem o metoda care sa valideze ca am adaugat o intrare noua in tabel si sa verifice valorile pe care le-am dat

    public void validateThatNewRecordsAreAddedProperly(){
        List<WebElement> tableRowList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']"));
        Assert.assertTrue(tableRowList.size()>initialTableSize,"There are no new entries in the table, initial table size: " +
                initialTableSize + " is the same with actual table size: " + tableRowList.size());
        String actualTableValues = tableRowList.get(tableRowList.size()-1).getText();
        System.out.println("New records values are: "+ actualTableValues);
        Assert.assertTrue(actualTableValues.contains(firstName),"First name value is not correct,expected firstname: " + firstName);
        Assert.assertTrue(actualTableValues.contains(lastName), "Last name value is not correct,expected lastname: " + lastName);
        Assert.assertTrue(actualTableValues.contains(userEmail) ,"userEmail value is not correct, expected useremail: " + userEmail);
        Assert.assertTrue(actualTableValues.contains(age), "Age value is not correct, expected age: " + age);
        Assert.assertTrue(actualTableValues.contains(salary),"Salary value is not correct, expected salary: " + salary);
        Assert.assertTrue(actualTableValues.contains(department), "Department value is not correct, expected department: " + department);

    //    Tema : Elements , check box de facut ca tema

    }

}

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;
import java.util.HashMap;
import java.util.List;

public class PracticeFormTest {

    WebDriver driver;

    @Test


    public void practiceFormTest(){

        driver = new ChromeDriver();
        //Navigam catre pagina website-ului
        driver.get("https://demoqa.com/");
        // Facem fereastra browser-ului maximize
        driver.manage().window().maximize();
        //Identificam meniul dorit si facem click pe el
        WebElement FormMeniu = driver.findElement(By.xpath("//h5[text()='Forms']"));


        // In caz ca nu se poate identifica elementul si e nevoie de scroll pt al putea gasii
       JavascriptExecutor js = (JavascriptExecutor) driver;
       //js.executeScript("arguments[0].scrollIntoView(true);", FormMeniu);
       //js.executeScript("window.scrollBy(0,500)");

        //Actionam butonul pe meniul de mai sus
        FormMeniu.click();
        // Identificam submeniul dorit si facem click pe el

        WebElement SubMeniu = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        SubMeniu.click();
        // Identificam elementele din formular si facem actiuni corespunzatoare pe fiecare
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        String firstNameText= "Mario";
        firstNameField.sendKeys(firstNameText);
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        String lastNameText = "Luigi";
        lastNameField.sendKeys(lastNameText);
        WebElement emailField = driver.findElement(By.id("userEmail"));
        String emailText = "test@gmail.com" ;
        emailField.sendKeys(emailText);
        WebElement genderMaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement genderFemaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement genderOther = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        String genderValueText = "Female";
        List<WebElement> genderList = List.of(genderMaleElement,genderFemaleElement,genderOther);
       // genderMaleElement.click();
        for(int i=0;i< genderList.size();i++){
            if(genderList.get(i).getText().equals(genderValueText)) {
                genderList.get(i).click();
                break;
            }
        }

//        Pe una sau mai multe site-uri
//        Initializare browser , gasit un element sau doua, facut o actiune gen click sau ce am facut la curs
                
        WebElement mobilePhoneField = driver.findElement(By.id("userNumber"));
        String mobilePhoneText = "0755566090";
        mobilePhoneField.sendKeys(mobilePhoneText);
        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.click();
        WebElement monthOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
        Select selectMonth = new Select(monthOfBirthElement);
        String monthValueText = "October";
        selectMonth.selectByVisibleText(monthValueText);

        WebElement yearOfBirthElement = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select selectYear = new Select(yearOfBirthElement);
        String yearValueText = "2025";
        selectYear.selectByVisibleText(yearValueText);
        // Alegem data ziua nasterii dintr-o lista de zile posibile

       List<WebElement>dayOfBirthList = driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day')]"));
        String dayValueText = "25";
       for(int i=0;i<dayOfBirthList.size();i++){
           if(dayOfBirthList.get(i).getText().equals(dayValueText)){
               dayOfBirthList.get(i).click();
               break;
           }
       }

       WebElement subjectInputElement = driver.findElement(By.id("subjectsInput"));
       String mathsSubjectText = "Maths";
       subjectInputElement.sendKeys(mathsSubjectText);
       subjectInputElement.sendKeys(Keys.ENTER);
        String physicsSubjectText = "Physics";
        subjectInputElement.sendKeys(physicsSubjectText);
        subjectInputElement.sendKeys(Keys.ENTER);
        js.executeScript("window.scrollBy(0,200)");
        WebElement sportHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        //sportHobbyElement.click();
        WebElement readingHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        //readingHobbyElement.click();
        WebElement musicHobbyElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
        List<WebElement> hobbiesList= List.of(sportHobbyElement,musicHobbyElement,readingHobbyElement);
        String sportHobbyText = "Sports";
        String readingHobbyText = "Reading";
        String musicHobbyText = "Music";
        List<String> hobbyValueTextList = List.of(sportHobbyText,readingHobbyText,musicHobbyText);
        for (String hobby: hobbyValueTextList){
            for(int i=0;i<hobbiesList.size();i++){
                if(hobbiesList.get(i).getText().equals(hobby)){
                    hobbiesList.get(i).click();
                    break;
                }
            }
        }

        //musicHobbyElement.click();
        WebElement uploadFileElement = driver.findElement(By.id("uploadPicture"));
        String pictureFileText = "poza.png";
        String pictureFilePath="src/test/resources/pictures/" + pictureFileText;
        File file=new File(pictureFilePath);
        uploadFileElement.sendKeys(file.getAbsolutePath());
        js.executeScript("window.scrollBy(0,500)");
        WebElement adressField = driver.findElement(By.id("currentAddress"));
        String adressValueText = "Strada Iorga";
        adressField.sendKeys(adressValueText);
        WebElement stateInputElement = driver.findElement(By.id("react-select-3-input"));
        String stateValueText ="NCR";
        stateInputElement.sendKeys(stateValueText);
        stateInputElement.sendKeys(Keys.ENTER);
        // Alegem orasul pentru formular
        WebElement cityInputElement = driver.findElement(By.id("react-select-4-input"));
        String cityValueText = "Delhi";
        cityInputElement.sendKeys(cityValueText);
        cityInputElement.sendKeys(Keys.ENTER);
        // Apasam butonul Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Validam tabelul cu datele de intrare folosite

        // Facem un hashmap cu expected values
        HashMap<String, String> expectedValues = new HashMap<>();
        expectedValues.put("Student Name",firstNameText+" " + lastNameText);
        expectedValues.put("Student Email",emailText);
        expectedValues.put("Gender",genderValueText);
        expectedValues.put("Mobile",mobilePhoneText);
        expectedValues.put("Date of Birth", dayValueText + " " + monthValueText + ","+ yearValueText);
        expectedValues.put("Subjects",mathsSubjectText + ", " + physicsSubjectText);
        expectedValues.put("Hobbies",sportHobbyText + ", " + readingHobbyText + ", " + musicHobbyText);
        expectedValues.put("Picture", pictureFileText);
        expectedValues.put("Address",adressValueText);
        expectedValues.put("State and City",stateValueText + " " + cityValueText);

        // declaram listele cu valorile actuale din tabel

        List<WebElement> submitTablesKeys = driver.findElements(By.xpath("//tbody//td[1]"));
        List<WebElement> submitTablesValues = driver.findElements(By.xpath("//tbody//td[2]"));

        HashMap<String, String> actualValues = new HashMap<>();
        for(int i =0;i< submitTablesKeys.size();i++){
            actualValues.put(submitTablesKeys.get(i).getText(), submitTablesValues.get(i).getText());
        }


        // Tema , de mentionat fiecare pas facut in cod

        Assert.assertEquals(actualValues, expectedValues, "Actual Values: " +actualValues + " are not equal/are not the same with the expected value" + expectedValues);

    }

    // assert-ul


}

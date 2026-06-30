package pages;

import Base.DriverManager;
import Base.DriverUtilites;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatient extends DriverUtilites {
    String day;

    WebDriver driver;
    public AddPatient() {
        this.driver= DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="(//span[text()='Yes']/parent::button)[1]")
    WebElement PATIENT_IDENTITY;
    @FindBy(id="givenName")
    WebElement FIRST_NAME;
    @FindBy(xpath = "//span[text()='Male']/preceding-sibling::span")
    WebElement GENDER_MALE;
    @FindBy(xpath = "//button[@aria-label='Calendar']")
    WebElement BIRTH_DATE;
    @FindBy(id="familyName")
    WebElement FAMILY_NAME;
    @FindBy(id = "address1")
    WebElement ADDRESS;
    @FindBy(id="phone")
    WebElement PHONE_NUMBER;
    @FindBy(xpath = "//button[text()='Register patient']")
    WebElement REGISTER_PATIENT_BUTTON;
    @FindBy(xpath = "//header[@aria-label=\"patient banner\"]")
    WebElement PATIENT_BANNER;

    @FindBy(css = "span[data-type='year']")
    WebElement BIRTH_YEAR;

    @FindBy(xpath = "//span[@data-type='month']")
    WebElement BIRTH_MONTH;

    @FindBy(xpath = "//span[@data-type='day']")
    WebElement BIRTH_DAY;

    @FindBy(xpath = "//h4[text()='Identifiers']")
    WebElement IDENTIFIER;
    @FindBy(id="contact")
    WebElement CONTACT_DETAILS;

    @FindBy(id ="birthdate")
    WebElement BIRTH_CONTAINER;

    @FindBy(xpath = "//h4[text()='Create new patient']")
    WebElement CREATE_NEW_PATIENT;

    @FindBy(xpath = "//div[@role='alertdialog']")
    WebElement ERROR_MESSAGE;


    public String checkPatientIdentity() {
        waitForElementVisible(PATIENT_IDENTITY);
         return PATIENT_IDENTITY.getAttribute("aria-selected");
    }
    public void enterFirstNameAndFamily(String firstName, String FamilyName) {
        if(firstName !=null && FamilyName !=null ) {
            FIRST_NAME.sendKeys(firstName);
            FAMILY_NAME.sendKeys(FamilyName);
        }

    }
    public void selectGender() {
        //scrollToElement(GENDER_MALE);
       // moveToElement(GENDER_MALE);
        GENDER_MALE.click();
    }
    public void enterBirthDate(String day, String month, String year)  {
        //scrollToelementRedBlock(BIRTH_DATE);
        System.out.println("%%%%%%%%%%%%&*******(");
        waitElementToBeClickable(BIRTH_DATE);
        Point p = BIRTH_DATE.getLocation();

        System.out.println("X = " + p.getX());
        System.out.println("Y = " + p.getY());

        BIRTH_DAY.sendKeys(day);
        BIRTH_MONTH.sendKeys(month);
        BIRTH_YEAR.sendKeys(year);

    }
    public void enterAddress(String address) {
       // scrollToElement(ADDRESS);
        ADDRESS.sendKeys(address);
    }
    public void enterPhoneNumber(String phoneNumber) {
        //scrollToElement(PHONE_NUMBER);
       // moveToElement(PHONE_NUMBER);
        PHONE_NUMBER.sendKeys(phoneNumber);
    }
    public void clickOnRegisterPatientButton() throws InterruptedException {

        getPointerValues(REGISTER_PATIENT_BUTTON);
        getPositionRealtiveToViewPort(REGISTER_PATIENT_BUTTON);
        scrollIntoPostion(REGISTER_PATIENT_BUTTON);
        waitForElementVisible(REGISTER_PATIENT_BUTTON);
        REGISTER_PATIENT_BUTTON.click();
    }
    public boolean getPatientBannerText() {
        waitForElementVisible(PATIENT_BANNER);
        return PATIENT_BANNER.isDisplayed();
    }
    public Boolean errorMessageForMisssingFields(){
        waitForElementVisible(ERROR_MESSAGE);

        return ERROR_MESSAGE.isDisplayed();
    }
}

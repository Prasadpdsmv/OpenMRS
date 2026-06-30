package pages;

import Base.DriverManager;
import Base.DriverUtilites;
import org.apache.commons.compress.compressors.pack200.Pack200Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.time.Duration;

public class LoginPage extends DriverUtilites {
    // oage object for login page
    // page factory pattern
    //WebElement username;
    WebDriver driver;

    public LoginPage() {
        this.driver= DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="username")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    WebElement loginButton;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueButton;

    @FindBy(xpath = "//p[contains(text(), 'Welcome')]")
    WebElement locationSelectPage;

    @FindBy(tagName = "title")
    WebElement pageTitle;

    @FindBy(xpath = "//div[text()='Error']")
    WebElement ErrorMessage;

    @FindBy(xpath = "//span[text()='Outpatient Clinic']")
    WebElement OUTPATIENT_CLINIC;

    @FindBy(xpath = "//button[@aria-label=\"Add patient\"]")
    WebElement ADD_PATIENT;

    @FindBy(xpath = "//input[@data-testid=\"patientSearchBar\"]")
    private WebElement SEARCH_PATEINT;

    @FindBy(xpath = "//div[@data-openmrs-role=\"Search Results\"]//a[1]")
    private WebElement SEARCH_RESULT;
    @FindBy(xpath = "//button[@data-testid=\"searchPatientIcon\"]")
    private WebElement SEARCH_BUTTON;
    @FindBy(xpath = "//p[contains(text(), 'search results')]")
    private WebElement SEARCH_CONTAINER;
    @FindBy(xpath = "//div[@class=\"cds--inline-loading__animation\"]")
    private WebElement LOADING_ICON;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    private WebElement SEARCH;

    public  void enterUsernameAndPassword(String usernameInput, String passwordInput ) {
        driver.get("http://localhost/openmrs/spa/login");
        waitForElementVisible(username);
        username.sendKeys(usernameInput);
        continueButton.click();
        password.sendKeys(passwordInput);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }
    public String verifyPageTitle() {
        String title = driver.getTitle();
        if (title.equals("OpenMRS")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
        return title;
    }
    public boolean locationPage(){

        System.out.println(" is "+continueButton.isEnabled());
        waitForElementVisible(locationSelectPage);
        return locationSelectPage.isDisplayed();
    }
    public boolean errorMeassageValidation(){

        return ErrorMessage.isDisplayed();

    }
    public void selectOutPtientLocation(){
        waitForElementVisible(OUTPATIENT_CLINIC);
        scrollToElement(OUTPATIENT_CLINIC);
        OUTPATIENT_CLINIC.click();

        continueButton.click();
    }
    public void addPatientMenu(){
        waitForElementVisible(ADD_PATIENT);
        ADD_PATIENT.click();
    }
    public void searchPatient(String patientName){
        waitForElementVisible(SEARCH_BUTTON);
        SEARCH_BUTTON.click();
       /* SEARCH_PATEINT.sendKeys(patientName);
       // SEARCH_PATEINT.sendKeys(Keys.ENTER);
        Actions actions=new Actions(driver);
        //actions.sendKeys(Keys.ENTER);

        WebElement active=driver.switchTo().activeElement();

        System.out.println(active.getAttribute("outerHTML"));
        waitElementDisappear(LOADING_ICON);
        waitForElementVisible(SEARCH_CONTAINER);

       SEARCH_PATEINT.sendKeys(Keys.ARROW_DOWN);
       SEARCH_PATEINT.sendKeys(Keys.ARROW_DOWN);
       SEARCH_PATEINT.sendKeys(Keys.ENTER);*/

        Actions actions=new Actions(driver);
        WebElement active=driver.switchTo().activeElement();

        System.out.println(active.getAttribute("outerHTML"));
        actions.click(SEARCH_PATEINT).
                sendKeys(patientName).
                pause(Duration.ofSeconds(5)).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).perform();
        WebElement active2=driver.switchTo().activeElement();

        System.out.println(active2.getAttribute("outerHTML"));
        //driver.switchTo().activeElement().click();

        SEARCH.click();
        waitForElementVisible(SEARCH_RESULT);
        SEARCH_RESULT.click();

    }
}

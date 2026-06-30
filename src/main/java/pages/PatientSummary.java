package pages;

import Base.DriverManager;
import Base.DriverUtilites;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PatientSummary extends DriverUtilites {
    WebDriver driver;

    public PatientSummary() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label=\"Search patient\"]")
    WebElement SEARCH_BUTTON;
    @FindBy(xpath = "//a[@class=\"-esm-patient-search__compact-patient-banner__patientSearchResult___fJ6Ec\"]//span[text()='test o']")
    WebElement SEARCH_OUTPUT;

    @FindBy(xpath = "//div[@data-extension-slot-name=\"patient-chart-dashboard-slot\"]")
    WebElement PATIENT_SUMMARY_DASHBOARD;
    @FindBy(xpath = "//button[text()='vital signs']")
    WebElement RECORD_VITALSANDBIOMETRICS;
    @FindBy(xpath = "//input[@placeholder=\"Search for a patient by name or identifier number\"]")
    WebElement SEARCH_INPUT;
    @FindBy(xpath = "//a[@class=\"-esm-patient-search__compact-patient-banner__patientSearchResult___fJ6Ec\"]")
    List<WebElement> SEARCH_RESULTS;

    public void seacrPatient(String PatienName){

        System.out.println("patient name is  : "+PatienName);

        waitForElementVisible(SEARCH_BUTTON);
        SEARCH_BUTTON.click();
        SEARCH_INPUT.sendKeys(PatienName);

        waitForElementVisible(SEARCH_OUTPUT);
        waitElementToBeClickable(SEARCH_OUTPUT);
        System.out.println("output search is here ");
        SEARCH_OUTPUT.click();

        /*for (WebElement RESULT : SEARCH_RESULTS){
            if (RESULT.getText().contains(PatienName)){
                RESULT.click();
                break;
            }
        }*/

    }
    public boolean verifyPatientDashBoardDiaplayed(){
        waitForElementVisible(PATIENT_SUMMARY_DASHBOARD);
        return PATIENT_SUMMARY_DASHBOARD.isDisplayed();
    }
    public void clickRecordVitalsAnsBiometris(){
        waitForElementVisible(RECORD_VITALSANDBIOMETRICS);
        RECORD_VITALSANDBIOMETRICS.click();
    }

}

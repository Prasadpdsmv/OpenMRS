package pages;

import Base.DriverManager;
import Base.DriverUtilites;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vitals_Biometrics extends DriverUtilites {

        WebDriver driver;

        public Vitals_Biometrics() {
                this.driver= DriverManager.getDriver();
                PageFactory.initElements(driver, this);
        }

        // --- Header Elements ---
        @FindBy(className = "cds")
        private WebElement headerTitle; // "Record Vitals and Biometrics"

        @FindBy(xpath = "//button[@aria-label='Close']")
        private WebElement closeHeaderButton;

        @FindBy(xpath = "//button[@aria-label='Search patient']")
        public WebElement searchPatientButton;

        @FindBy(xpath = "//button[@aria-label='My Account']")
        public WebElement myAccountButton;

        // --- Side Navigation Links ---
        @FindBy(linkText = "Patient summary")
        public WebElement sideNavLinkPatientSummary;

        @FindBy(linkText = "Vitals & Biometrics")
        public WebElement sideNavLinkVitalsBiometrics;

        @FindBy(linkText = "Medications")
        public WebElement sideNavLinkMedications;

        // --- Vitals Form Inputs ---
      //  @FindBy(id = ":r2cp:-temperature")
        @FindBy(name = "Temperature")
        public WebElement temperatureInput;


        @FindBy(name = "systolic")
        public WebElement systolicBPInput;

        @FindBy(name = "diastolic")
        public WebElement diastolicBPInput;

        @FindBy(name = "Pulse")
        public WebElement pulseInput;

        @FindBy(name = "Respiration rate")
        public WebElement respirationRateInput;

        @FindBy(name = "Oxygen saturation")
        public WebElement oxygenSaturationInput;

        @FindBy(id = ":r2cu:-generalPatientNote")
        public WebElement notesTextArea;

        // --- Biometrics Form Inputs ---
        @FindBy(name = "Weight")
        public WebElement weightInput;

        @FindBy(name = "Height")
        public WebElement heightInput;

        @FindBy(id = ":r2d2:-computedBodyMassIndex")
        public WebElement bmiInput;

        @FindBy(id = ":r2d3:-midUpperArmCircumference")
        public WebElement muacInput;

        // --- Form Action Buttons ---
        @FindBy(xpath = "//button[text()='Discard']")
        public WebElement discardButton;

        @FindBy(xpath = "//button[text()='Save and close']")
        public WebElement saveAndCloseButton;

        // --- Patient Actions ---
        @FindBy(id = "patient-actions-menu-trigger-:r26r:")
        public WebElement actionsMenuButton;

        @FindBy(xpath = "//button[contains(text(), 'Add visit')]")
        public WebElement addVisitMenuItem;

        @FindBy(xpath = "//div[@class=\"cds--actionable-notification__content\"]")
        public WebElement SUCCESS_MESSAGE;

        public void enterTemperature(String tempa){
                waitForElementVisible(temperatureInput);
                temperatureInput.sendKeys(tempa);
        }
        public void enterBloodPressure(String SysBP, String number){
                systolicBPInput.sendKeys(SysBP);
                diastolicBPInput.sendKeys(number);
        }
        public void enterHeartRate(String heartRate){
                pulseInput.sendKeys(heartRate);
        }
        public void enterRespirationRate(String respirationRate){
                respirationRateInput.sendKeys(respirationRate);
        }
        public void enterOxygenSaturationRate(String OxygenRate){
                scrolActionlToElement(oxygenSaturationInput);
                oxygenSaturationInput.sendKeys(OxygenRate);
        }
        public void enterHeightInut(String Height){
                //scrolActionlToElement(oxygenSaturationInput);
                heightInput.sendKeys(Height);
        }
        public void enterWeightInut(String Weight){
                heightInput.sendKeys(Weight);
        }
        public void enterMUAC(String Height){
                heightInput.sendKeys(Height);
        }
        public void clickSaveAndClose(){
                saveAndCloseButton.click();
        }
        public boolean verifySuccessMessage(){
                waitForElementVisible(SUCCESS_MESSAGE);
                return SUCCESS_MESSAGE.isDisplayed();
        }


    }

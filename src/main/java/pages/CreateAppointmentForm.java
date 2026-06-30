package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAppointmentForm {

    // --- Form Select Dropdowns ---
    
    @FindBy(id = "location")
    public WebElement LOCATION_SELECT;

    @FindBy(id = "service")
    public WebElement SERVICE_SELECT;

    @FindBy(id = "appointmentType")
    public WebElement APPOINTMENT_TYPE_SELECT;

    @FindBy(id = "provider")
    public WebElement PROVIDER_SELECT;

    // --- Date and Time (Commonly identified by ID or Placeholder) ---
    
    @FindBy(id = "date")
    public WebElement APPOINTMENT_DATE_INPUT;

    @FindBy(id = "startTime")
    public WebElement START_TIME_INPUT;

    @FindBy(id = "endTime")
    public WebElement END_TIME_INPUT;

    // --- Additional Information ---
    
    @FindBy(id = "notes")
    public WebElement NOTES_TEXTAREA;

    // --- Action Buttons ---
    
    @FindBy(xpath = "//button[text()='Save and close']")
    public WebElement SAVE_AND_CLOSE_BUTTON;

    @FindBy(xpath = "//button[text()='Discard']")
    public WebElement DISCARD_BUTTON;

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement CLOSE_FORM_BUTTON;
}
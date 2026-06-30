package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicationsPage {

    // --- Side Navigation ---
    @FindBy(xpath = "//a[contains(@class, 'cds--side-nav__link') and contains(., 'Medications')]")
    public WebElement ACTIVE_MEDICATIONS_NAV_LINK;

    @FindBy(linkText = "Patient summary")
    public WebElement PATIENT_SUMMARY_NAV_LINK;

    @FindBy(linkText = "Orders")
    public WebElement ORDERS_NAV_LINK;

    @FindBy(linkText = "Results")
    public WebElement RESULTS_NAV_LINK;

    @FindBy(linkText = "Visits")
    public WebElement VISITS_NAV_LINK;

    // --- Page Headers ---
    @FindBy(xpath = "//h4[text()='Active Medications']")
    public WebElement ACTIVE_MEDICATIONS_HEADER;

    @FindBy(xpath = "//h4[text()='Past Medications']")
    public WebElement PAST_MEDICATIONS_HEADER;

    // --- Action Buttons ---
    @FindBy(xpath = "//button[text()='Record active medications']")
    public WebElement RECORD_ACTIVE_MEDICATIONS_BUTTON;

    @FindBy(xpath = "//button[text()='Record vitals']")
    public WebElement RECORD_VITALS_BUTTON;

    @FindBy(xpath = "//button[text()='Show more']")
    public WebElement SHOW_MORE_DETAILS_BUTTON;

    @FindBy(id = "patient-actions-menu-trigger-:r26r:")
    public WebElement ACTIONS_MENU_BUTTON;

    // --- Header Icons / Global ---
    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement CLOSE_HEADER_BUTTON;

    @FindBy(xpath = "//button[@aria-label='Search patient']")
    public WebElement SEARCH_PATIENT_BUTTON;

    @FindBy(xpath = "//button[@aria-label='My Account']")
    public WebElement MY_ACCOUNT_BUTTON;

    // --- Medication Menu Items (if actions menu is open) ---
    @FindBy(xpath = "//button[text()='Add visit']")
    public WebElement ADD_VISIT_MENU_ITEM;

    @FindBy(xpath = "//button[text()='End active visit']")
    public WebElement END_VISIT_MENU_ITEM;
}
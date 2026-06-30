package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentsPage {

    // --- Side Navigation ---
    @FindBy(xpath = "//a[contains(@class, 'cds--side-nav__link') and contains(., 'Appointments')]")
    public WebElement ACTIVE_APPOINTMENTS_NAV_LINK;

    @FindBy(linkText = "Programs")
    public WebElement PROGRAMS_NAV_LINK;

    @FindBy(linkText = "Billing history")
    public WebElement BILLING_HISTORY_NAV_LINK;

    // --- Tab Switcher ---
    @FindBy(xpath = "//button[@role='tab' and text()='Upcoming']")
    public WebElement UPCOMING_APPOINTMENTS_TAB;

    @FindBy(xpath = "//button[@role='tab' and text()='Today']")
    public WebElement TODAY_APPOINTMENTS_TAB;

    @FindBy(xpath = "//button[@role='tab' and text()='Past']")
    public WebElement PAST_APPOINTMENTS_TAB;

    // --- Action Buttons ---
    @FindBy(xpath = "//button[text()='Add']")
    public WebElement ADD_APPOINTMENT_BUTTON;

    // --- Appointments Data Table ---
    @FindBy(css = "table.cds--data-table")
    public WebElement APPOINTMENTS_DATA_TABLE;

    @FindBy(xpath = "//button[text()='Date']")
    public WebElement DATE_COLUMN_SORT;

    @FindBy(xpath = "//button[text()='Location']")
    public WebElement LOCATION_COLUMN_SORT;

    @FindBy(xpath = "//button[text()='Status']")
    public WebElement STATUS_COLUMN_SORT;

    // --- Pagination ---
    @FindBy(xpath = "//select[contains(@id, 'pagination-select')]")
    public WebElement ITEMS_PER_PAGE_SELECT;

    @FindBy(xpath = "//button[@aria-label='Next page']")
    public WebElement NEXT_PAGE_BUTTON;

    @FindBy(xpath = "//button[@aria-label='Previous page']")
    public WebElement PREVIOUS_PAGE_BUTTON;

    // --- Patient Banner Actions ---
    @FindBy(id = "patient-actions-menu-trigger-:r26r:")
    public WebElement PATIENT_ACTIONS_MENU;

    @FindBy(xpath = "//button[text()='Record vitals']")
    public WebElement RECORD_VITALS_BUTTON;
}
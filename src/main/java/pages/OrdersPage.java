package pages;

import Base.DriverManager;
import Base.DriverUtilites;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends DriverUtilites {
    WebDriver driver;
    public OrdersPage() {
        this.driver= DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }

    // --- Side Navigation ---
    @FindBy(xpath = "//a[contains(@class, 'cds--side-nav__link') and contains(., 'Orders')]")
    public WebElement ACTIVE_ORDERS_NAV_LINK;

    @FindBy(linkText = "Medications")
    public WebElement MEDICATIONS_NAV_LINK;

    @FindBy(linkText = "Results")
    public WebElement RESULTS_NAV_LINK;

    // --- Filter and Search ---
    @FindBy(xpath = "//button[@role='combobox' and contains(., 'All orders')]")
    public WebElement ALL_ORDERS_FILTER_DROPDOWN;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement SEARCH_TABLE_INPUT;

    @FindBy(xpath = "//button[@aria-label='Calendar']")
    public WebElement DATE_FILTER_CALENDAR_BUTTON;

    // --- Action Buttons ---
    @FindBy(xpath = "//button[text()='Add']")
    public WebElement ADD_ORDER_BUTTON;

    @FindBy(xpath = "//button[text()='Record vitals']")
    public WebElement RECORD_VITALS_BUTTON;

    @FindBy(xpath = "//a[@class=\"cds--side-nav__link\"]//span[contains(text(), 'Orders')]")
    private WebElement OREDER_MENU;

    // --- Orders Data Table ---
    @FindBy(css = "table.cds--data-table")
    public WebElement ORDERS_DATA_TABLE;

    @FindBy(xpath = "//th[contains(., 'Order number')]")
    public WebElement ORDER_NUMBER_COLUMN_HEADER;

    @FindBy(xpath = "//th[contains(., 'Status')]")
    public WebElement STATUS_COLUMN_HEADER;

    @FindBy(xpath = "//button[@aria-label='Expand all rows']")
    public WebElement EXPAND_ALL_ROWS_BUTTON;

    // --- Pagination ---
    @FindBy(xpath = "//select[contains(@id, 'pagination-select')]")
    public WebElement ITEMS_PER_PAGE_SELECT;

    @FindBy(xpath = "//button[@aria-label='Previous page']")
    public WebElement PREVIOUS_PAGE_BUTTON;

    @FindBy(xpath = "//button[@aria-label='Next page']")
    public WebElement NEXT_PAGE_BUTTON;

    // --- Patient Banner / Header ---
    @FindBy(xpath = "//button[text()='Actions']")
    public WebElement PATIENT_ACTIONS_BUTTON;

    @FindBy(xpath = "//button[@aria-label='Close']")
    public WebElement CLOSE_FORM_BUTTON;
    @FindBy(xpath = "//span[contains(text(), 'Sign and close')]/parent::button")
    public WebElement SIGN_AND_CLOSE_BUTTON;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement CANCEL_ORDER_BUTTON;

    // Specific "Add" buttons inside the basket panel
    @FindBy(xpath = "//button[contains(@class, 'drug-order-basket-panel') and text()='Add']")
    public WebElement ADD_DRUG_ORDER_BUTTON;

    @FindBy(xpath = "//button[contains(@class, 'lab-order-basket-panel') and text()='Add']")
    public WebElement ADD_LAB_ORDER_BUTTON;

    @FindBy(id = "search-input-:r2ek:")
    public WebElement TABLE_SEARCH_INPUT;


    // Search and Input fields that appear in the form
    @FindBy(xpath = "//div[contains(@class, 'order-basket')]//input")
    public WebElement ORDER_SEARCH_INPUT;

    @FindBy(xpath = "//button[contains(normalize-space(), 'Record orders')]")
    public WebElement RECORD_ORDER;

    @FindBy(xpath = "//div[@class='cds--modal-header']")
    public WebElement NO_ACTIVE_LIST;

    @FindBy(xpath = "//a[@class='cds--header__name']")
    private WebElement OREDER_BASKET;
    @FindBy(xpath = "//div[@data-extension-id=\"drug-order-panel\"]//button[contains(text(),  'Add')]")
    private WebElement ADD_DRUGS;
    @FindBy(xpath = "//div[@data-extension-id=\"lab-order-panel\"]//button[contains(text(),  'Add')]")
    private WebElement ADD_LAB_ORDERS;
    @FindBy(xpath = "//input[@class=\"cds--search-input\"]")
    private WebElement SEARCH_LAB_ORDERS;
    @FindBy(xpath = "//button[contains(text(), 'Add to basket')]")
    private WebElement ADD_TO_BASKET;
    @FindBy(xpath = "//button[contains(text(), 'Order form')]")
    private WebElement ORDER_FROM;
    @FindBy(xpath = "//button[contains(text(), 'Save order')]")
    private WebElement SAVE_ORDER;



    public boolean clickAddRecordsAndVerifyNoActiveVisit(){
        RECORD_ORDER.click();
        waitForElementVisible(NO_ACTIVE_LIST);
        if (NO_ACTIVE_LIST.isDisplayed()){

            System.out.println("patient have no active vists first add visit");
            return true;
        }
        else {
            System.out.println("for no active visit patient it should show pop up with NO ACTIVE VISITS");
            return false;
        }

    }
    public void recordLabOrders(){
        RECORD_ORDER.click();
        waitForElementVisible(OREDER_BASKET);
        waitElementToBeClickable(ADD_LAB_ORDERS);
        ADD_LAB_ORDERS.click();
        waitForElementVisible(SEARCH_LAB_ORDERS);
        SEARCH_LAB_ORDERS.sendKeys("haemoglo");
       // ADD_TO_BASKET.click();
        waitForElementVisible(ORDER_FROM);
        ORDER_FROM.click();
        SAVE_ORDER.click();
        waitForElementVisible(SIGN_AND_CLOSE_BUTTON);
        SIGN_AND_CLOSE_BUTTON.click();
    }
    public void clicKOnOrders(){
        waitForElementVisible(OREDER_MENU);
        OREDER_MENU.click();
        waitForElementVisible(RECORD_ORDER);

    }

}
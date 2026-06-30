package Base;

import io.cucumber.java.sl.In;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class DriverUtilites {
    //public static WebDriver driver;
    public static WebDriverWait wait;
    private static String browser;

    //set driver and browser and pass it to thread local
    public static void setDriver() {

        // to execute on remote environment.
        if (ConfigReader.getProperty("execution-env").equals("remote")) {

            WebDriver driverLocal;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(Platform.WIN11);

            System.out.println("desired capabilities");
            browser=ConfigReader.getProperty("browser");
            switch (browser.toLowerCase()){
                case "chrome":
                    capabilities.setBrowserName(Browser.CHROME.browserName());
                    ChromeOptions options=new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--window-size=1920,1080");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

                    System.out.println("chrome driver set as browser");
                    break;
                case "firefox":
                    capabilities.setBrowserName(Browser.FIREFOX.browserName());
                    System.out.println("firefox as browser name");
                    break;
                case "edge" :
                    capabilities.setBrowserName(Browser.EDGE.browserName());
                    System.out.println("egde as browser name");
                    break;
            }
            try {
                System.out.println("driver is set now passing remote web driver");
                driverLocal = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
                System.out.println("driver value we passing "+driverLocal);
                DriverManager.setDriver(driverLocal);
            }
            catch (MalformedURLException e){
                System.out.println("remote driver initialisation failed");
                e.printStackTrace();
            }


        }


        if (ConfigReader.getProperty("execution-env").equals("local")) {
            WebDriver driverLocal;
            browser = ConfigReader.getProperty("browser");
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--window-size=1920,1080");
                    driverLocal = new ChromeDriver(options);
                    driverLocal.manage().window().maximize();
                    DriverManager.setDriver(driverLocal);
                    break;
                case "firefox":

                    FirefoxOptions optionsf = new FirefoxOptions();
                    optionsf.addArguments("--width=1920");
                    optionsf.addArguments("--height=1080");
                    driverLocal = new FirefoxDriver(optionsf);

                    driverLocal.manage().window().maximize();

                    DriverManager.setDriver(driverLocal);
                    break;
                case "edge":
                    EdgeOptions optionsE = new EdgeOptions();
                    optionsE.addArguments("--window-size=1920,1080");

                    driverLocal = new EdgeDriver(optionsE);

                    driverLocal.manage().window().maximize();

                    DriverManager.setDriver(driverLocal);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Unsupported browser: " + browser);
            }
        }



    }
    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
    public static void waitForElementVisible(WebElement element) {
        //System.out.println("+driver value "+ driver);
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        System.out.println("wait for element visible"+element);
        //System.out.println("the element value "+ element);

       // wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void scrollToElement(WebElement element) {
        Actions act=new Actions(DriverManager.getDriver());
       // act.moveToElement(element).perform();
        JavascriptExecutor js= ((JavascriptExecutor) DriverManager.getDriver());
                js.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println("scrolled to element"+element);
        //System.out.println("y off set values"+js.executeScript("window.pageYOffset"));
    }
    public static void scrollToWindow(){
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.scrollBy(0,821);");
        System.out.println("***** scroll to window **********");

    }
    public static void scrollToBlock(WebElement element){

       // WebElement container=driver.findElement(By.xpath("//div[@class=\"cds--tile\"]"));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollHeight",
                element
        );

    }
    public static void scrolActionlToElement(WebElement element) {
        Actions act=new Actions(DriverManager.getDriver());
        act.moveToElement(element).perform();
    }
    public static void scrollToelementRedBlock(WebElement element){
        ((JavascriptExecutor)DriverManager.getDriver())
                .executeScript(
                        "arguments[0].style.border='5px solid red'",
                        element);
    }
    public static void waitElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void scrollToWindowWithPoints(int x, int y){
        System.out.println(
                ((JavascriptExecutor)DriverManager.getDriver())
                        .executeScript("return window.scrollY"));

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.scrollTo("+x+","+y+");");
    }
    public void scrollToWindow00(){
        WebElement registerBtn =
                DriverManager.getDriver().findElement(By.xpath("//button[text()='Register patient']"));

        System.out.println("Location = " + registerBtn.getLocation());
        System.out.println("Rect = " + registerBtn.getRect());

        Long scrollY = (Long)((JavascriptExecutor)DriverManager.getDriver())
                .executeScript("return window.scrollY");

        System.out.println("ScrollY = " + scrollY);
        ((JavascriptExecutor)DriverManager.getDriver())
                .executeScript("window.scrollTo(0,0)");
    }
    public void moveToElement(WebElement element){
        Actions act=new Actions(DriverManager.getDriver());
        act.scrollToElement(element).perform();
        System.out.println("****** moved to "+element);
    }
    public void keysMethod(){
        Actions act=new Actions(DriverManager.getDriver());
        act.keyDown(Keys.ARROW_DOWN);
    }
    public void getPointerValues(WebElement element){
       // WebElement element = DriverManager.getDriver().findElement(By.id("register-patient"));

        Point p = element.getLocation();

        System.out.println("X = " + p.getX());
        System.out.println("Y = " + p.getY());
    }
    public  void  getPositionRealtiveToViewPort(WebElement element){
        // gives values of element relative to current view poition , like after scroll viewport changes
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        Map<String, Object> rect = (Map<String, Object>) js.executeScript(
                "var r = arguments[0].getBoundingClientRect();" +
                        "return {" +
                        "top:r.top," +
                        "left:r.left," +
                        "bottom:r.bottom," +
                        "right:r.right," +
                        "width:r.width," +
                        "height:r.height};",
                element);

        System.out.println(rect);
    }
    public void scrollIntoPostion(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        Long scrollY =
                ((Number) js.executeScript(
                        "return window.pageYOffset"))
                        .longValue();

        System.out.println("Current Scroll = " + scrollY);

        js.executeScript("window.scrollTo(016, 230)");

        wait.until(driver -> {

            Long top = ((Number) js.executeScript(
                    "return Math.round(arguments[0].getBoundingClientRect().top);",
                    element))
                    .longValue();

            return top >= 0;
        });

       // Thread.sleep(10000);

        System.out.println("__________srolled to position_____________");

        Long scrollY1 =
                ((Number) js.executeScript(
                        "return window.pageYOffset"))
                        .longValue();
        System.out.println("Current Scroll = " + scrollY1);

    }

    public void waitElementDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
        System.out.println("elemnt is disappeared");
    }
}

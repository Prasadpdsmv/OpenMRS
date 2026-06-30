package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class tryExecution {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

// Fixes the WebSocket connection issue
        options.addArguments("--remote-allow-origins=*");

// Helps run in restricted network/CI environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");


        WebDriver driver=new ChromeDriver(options);
        driver.get("http://localhost/openmrs/spa/home ");

        WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        driver.findElement(By.id("username")).sendKeys("Admin");

        driver.findElement(By.xpath("//button[contains(text(), 'Continue')]")).click();


        driver.findElement(By.id("password")).sendKeys("Admin123");

        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();



        WebElement element=driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        driver.findElement(By.ByClassName.className("nav-link")).click(); // Using class name
        driver.findElement(By.className("nav-link")).click();// Using class name


        //
        WebDriverWait wait2=new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Home')")));

         element.click();

         String title=driver.getTitle();
    }


    public void testCockies(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

// Fixes the WebSocket connection issue
        options.addArguments("--remote-allow-origins=*");

// Helps run in restricted network/CI environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");


        WebDriver driver=new ChromeDriver(options);

        driver.get("https://www.makemytrip.com/");

        Set<Cookie> allCookies=driver.manage().getCookies();

        for (Cookie cookie : allCookies) {
            System.out.println("Cookie Name: " + cookie.getName());
            System.out.println("Cookie Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("Is Secure: " + cookie.isSecure());
            System.out.println("Is HttpOnly: " + cookie.isHttpOnly());
            System.out.println("-----------------------------------");
        }

        System.out.println("*** the value of cookie bm_s");
        Cookie specificCookie = driver.manage().getCookieNamed("bm_s");
        if (specificCookie != null) {
            System.out.println("Cookie Name: " + specificCookie.getName());
            System.out.println("Cookie Value: " + specificCookie.getValue());
            System.out.println("Domain: " + specificCookie.getDomain());
            System.out.println("Path: " + specificCookie.getPath());
            System.out.println("Expiry: " + specificCookie.getExpiry());
            System.out.println("Is Secure: " + specificCookie.isSecure());
            System.out.println("Is HttpOnly: " + specificCookie.isHttpOnly());
        } else {
            System.out.println("Cookie 'bm_s' not found.");
        }

        Actions action=new Actions(driver);
        //action.moveToElement(driver.findElement(By.xpath("//span[contains(text(), 'Login or Create Account')]"))).perform();

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        js.executeAsyncScript("window ");
    }




}

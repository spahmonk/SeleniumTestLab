package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGridClass {
    public WebDriver driver;
    public String URL, Node;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;

    void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Parameters("browser")
    @BeforeTest
    public void launchBrowser(String browser) throws MalformedURLException {
        String URL = "http://www.calculator.net";

        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println(" Executing on FireFox");
            String Node = "http://localhost:4444/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL(Node), cap);
            // Puts an Implicit wait, Will wait for 10 seconds before throwing
            // exception
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Launch website
            //driver.navigate().to(URL);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println(" Executing on CHROME");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            String Node = "http://localhost:4444/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Launch website
            //driver.navigate().to(URL);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.out.println(" Executing on IE");
            DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
            cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            cap.setBrowserName("internet explorer");
            cap.setCapability("ignoreZoomSetting", true);
            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            String Node = "http://localhost:4444/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Launch website
            //driver.navigate().to(URL);

        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

  /*  @Test
    public void calculatePercent() {
        // Click on Math Calculators
        driver.findElement(By.xpath("//a[contains(text(),'Math')]")).click();
        // Click on Percent Calculators
        driver.findElement(
                By.xpath("//a[contains(text(),'Percentage Calculator')]"))
                .click();
        // Enter value 17 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("17");
        // Enter value 35 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("35");

        // Click Calculate Button
        driver.findElement(
                By.xpath("(//input[contains(@value,'Calculate')])[1]")).click();
        // Get the Result Text based on its xpath
        String result = driver.findElement(
                By.xpath("./*//*[@id='content']/p[2]/font/b")).getText();
        // Print a Log In message to the screen
        System.out.println(" The Result is " + result);
        if (result.equals("5.95")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
    }*/

    @Test
    public void googletTst(){
        driver.get("http://google.com");
        waitForLoad(driver);
        driver.findElement(By.xpath("//*[@title=\"Search\" and @name=\"q\"]")).sendKeys("googleHelp");
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void closeBrowser() {
         driver.quit();
    }
}


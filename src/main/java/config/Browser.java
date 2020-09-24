package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static constans.Constans.pathArchivo;


public class Browser {


    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static WebDriver driver;

    public Browser ( WebDriver driver ){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @BeforeTest
    public static void getUp(String browser, String url) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", ".\\DriverNavegador\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",pathArchivo.concat("\\DriverNavegador\\chromedriver.exe"));
            //create chrome instance
            driver = new ChromeDriver();
            capabilities.setBrowserName("Chrome");
            driver.manage().window().maximize();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver",".\\DriverNavegador\\MicrosoftWebDriver.exe");
            //create Edge instance
            driver = new EdgeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterTest
    public static void getClose(){
        driver.close();
    }
}

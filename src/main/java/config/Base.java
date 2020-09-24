package config;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static constans.Constans.pathArchivo;
import static constans.Constans.urlBase;


public class Base {

    protected WebDriver driver = null;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    ChromeOptions cap = new ChromeOptions();

    @BeforeClass
    @Parameters({"browser","port"})
    public void initialize(@Optional("chrome") String browser,@Optional("0000") String port) throws MalformedURLException {
        switch(browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", pathArchivo.concat("\\DriverNavegador\\chromedriver.exe"));
                driver = new ChromeDriver();
                capabilities.setBrowserName("Chrome");
                cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                        UnexpectedAlertBehaviour.IGNORE);
                driver.manage().window().maximize();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", pathArchivo.concat("\\DriverNavegador\\geckodriver.exe"));
                driver = new FirefoxDriver();
                capabilities.setBrowserName("Firefox");
                cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                        UnexpectedAlertBehaviour.IGNORE);
                capabilities.setCapability("acceptInsecureCerts",true);
                capabilities.setAcceptInsecureCerts(true);
                capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("No es posible ejecutar el navegador: " + browser);
        }
        if(port.equalsIgnoreCase("9001")){
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), cap);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        }else if((port.equalsIgnoreCase("9002"))) {
            driver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), cap);
            driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        }
            driver.get(urlBase);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}

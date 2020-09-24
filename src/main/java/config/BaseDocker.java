package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import static constans.Constans.urlBase;

public class BaseDocker {

    protected WebDriver driver;

    @BeforeTest
    @Parameters({"host"})
    public void setupDriver(String host) throws MalformedURLException {
        //String host = "localhost";
        DesiredCapabilities capabilities;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            capabilities = DesiredCapabilities.firefox();
        }else {
            capabilities = DesiredCapabilities.chrome();
        }
        if(System.getProperty("HUB_HOST") !=null ){
            host = System.getProperty("HUB_HOST");
        }

        String completeURL="http://" + host + ":4444/wd/hub";
        driver = new RemoteWebDriver(new URL(completeURL), capabilities);
        driver.get(urlBase);
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

}

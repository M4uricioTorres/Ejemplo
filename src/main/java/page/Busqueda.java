package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Utilitarios.esperar;

public class Busqueda {

    private WebDriver driver;

    public Busqueda ( WebDriver driver ){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Imágenes')]")
    WebElement btnBusquedaImg;
    @FindBy(name = "btnK")
    WebElement btnBuscar;



    public void esperarResultado(){
        boolean esperars = esperar(btnBusquedaImg,driver);
        if(esperars){
            System.out.println("ok");
        }
    }

}

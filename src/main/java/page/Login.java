package page;

import config.Base;
import config.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utilitarios.esperar;
import static utils.Utilitarios.esperarElemento;

public class Login {

    protected WebDriver driver;

    public Login ( WebDriver driver ){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
/*
    @FindBy(xpath = "//*[@name='q']")
    WebElement inputBuscar;
    @FindBy(name = "btnK")
    WebElement btnBuscar;

 */

    @FindBy(name="Email")
    WebElement txtEmail;
    @FindBy(name="Password")
    WebElement txtPass;
    @FindBy( className ="login-button")
    WebElement btnIn;

/*
    public void buscar (String buscarTexto){
        esperar(inputBuscar, driver);
        inputBuscar.sendKeys( buscarTexto );
        //esperarElemento(btnBuscar);
        btnBuscar.click();

    }

 */
    public void logear(String email, String pass)
    {
        esperar(txtPass, driver);
        txtEmail.sendKeys( email );
        txtPass.sendKeys( pass );

        //esperarElemento(btnBuscar);
        btnIn.click();
    }
}
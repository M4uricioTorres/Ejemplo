package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static utils.Utilitarios.esperar;

public class Agregar {

    protected WebDriver driver;

    public Agregar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Agregar()
    {

    }


    @FindBy(id = "newsletter-subscribe-button")
    WebElement BtnSuscribir;
    @FindBy(id = "newsletter-email")
    WebElement TxtSus;


    public void AddItem ()
    {
        TxtSus.sendKeys("vamo a darle");
        BtnSuscribir.click();
        List<WebElement> lista= driver.findElements(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        System.out.println("el largo de la lista es= "+ lista.size());
        lista.get(1).click();

        esperar(10);

    }


}

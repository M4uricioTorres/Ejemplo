package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.w3c.dom.html.HTMLSelectElement;
import utils.Utilitarios;

import java.awt.*;
import java.util.List;

import static utils.Utilitarios.*;
import static utils.Utilitarios.*;

public class Formulario {

    protected WebDriver driver;
    Utilitarios utilitarios = new Utilitarios();

    public Formulario ( WebDriver driver ){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
/*
    @FindBy(xpath = "//*[@name='q']")
    WebElement inputBuscar;
    @FindBy(name = "btnK")
    WebElement btnBuscar;

 */

    @FindBy(id="firstName")
    WebElement FirstName;
    @FindBy(id="lastName")
    WebElement LastName;
    @FindBy(id="userEmail")
    WebElement Email;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement RbGender;
    @FindBy(id="userNumber")
    WebElement NumberPhone;
    @FindBy(id ="dateOfBirthInput")
    WebElement InputDate;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    WebElement SelectMoth;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    WebElement SelectYear;
    @FindBy(xpath = "//div[@aria-label='Choose Wednesday, January 6th, 1993']")
    WebElement SelectDay;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement CheckHobbie;
    @FindBy(id = "uploadPicture")
    WebElement BtnArchivo;
    @FindBy(id = "currentAddress")
    WebElement CurrentAddress;
    @FindBy(id = "submit")
    WebElement BtnSubmit;
    @FindBy(xpath = "//div[@class='modal-header']")
    WebElement Modal;
    @FindBy(xpath = "//*[@id=\"subjectsContainer\"]/div/div[1]")
    WebElement AutoComplete;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement TitleModal;



    public void llenar(String firstname,
                       String lastaname,
                       String email,
                       String num,
                       String direccion) throws AWTException, InterruptedException {
        esperar(1);
        FirstName.sendKeys(firstname);
        LastName.sendKeys(lastaname);
        Email.sendKeys(email);
        RbGender.click();
        NumberPhone.sendKeys(num);
        InputDate.click();

        seleccionarItemSelectOption(SelectMoth,"January");
        seleccionarItemSelectOption(SelectYear,"1993");

        SelectDay.click();
        CheckHobbie.click();

        AutoComplete.click();
        Utilitarios.robotType("M");
        esperar(1);
        presionaEnterWindows();

        esperar(3);
        CurrentAddress.sendKeys(direccion);
        BtnArchivo.sendKeys("C:\\Users\\Mauricio.Torres\\Desktop\\goku.jpg");
        esperar(3);
        BtnSubmit.click();

        //visualizarObjeto(Modal,10);
        Assert.assertEquals(TitleModal.getText(),"Thanks for submitting the form");
        System.out.println("Hay conincidencia de titulos en el modal");

    }
}

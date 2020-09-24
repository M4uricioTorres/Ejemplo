package testCases;


import config.Base;
import config.BaseDocker;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.Agregar;
import page.Busqueda;
import page.Formulario;
import page.Login;

import java.awt.*;
import java.sql.Driver;

public class Caso001 extends Base {


    /*
    public void testParameterWithXML() {

        Login login = new Login(driver);
        Busqueda busqueda = new Busqueda(driver);
        login.buscar("que sucede");
        busqueda.esperarResultado();

    }

*/
    @Test(priority = 0)
    @Parameters({"firstname","lastname","email","num","direccion"})
    public void CompletarFormulario(@Optional("Mao")String firstname,
                                    @Optional("Torres")String lastname,
                                    @Optional("torresmauricio.es@gmail.com")String email,
                                    @Optional("4446462131")String num,
                                    @Optional("Isla Piazzi 1443")String direccion) throws InterruptedException, AWTException {

        Formulario formulario = new Formulario(driver);
        Busqueda busqueda= new Busqueda(driver);
        formulario.llenar(firstname,lastname,email,num,direccion);
        //busqueda.esperarResultado();
    }




}

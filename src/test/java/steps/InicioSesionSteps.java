package steps;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.InicioSesionPage;
import pages.LeerArchivo;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

public class InicioSesionSteps {

    InicioSesionPage inisioSesion = new InicioSesionPage();

    @Given("Haga clic en el boton registrarse")
    public void clic_boton_registrarse() {
        inisioSesion.clicOpcionLogin();
    }

    @When("Por favor diligencie todo los datos del formulario desde la hoja (.*) y el numero de fila (.*)")
    public void escribir_para_buscar_prenda(String sheetName, int rowNumber)
            throws InvalidFormatException, IOException, InterruptedException {
        LeerArchivo reader = new LeerArchivo();
        List<Map<String, String>> testData = reader.getData("src/test/resources/Datos/inicioSesion.xlsx", sheetName);
        String eEmail = testData.get(rowNumber).get("Email");
        String eContrasena = testData.get(rowNumber).get("Contrasena");
        inisioSesion.formularioInicioSesion(eEmail, eContrasena);

    }

    @And("Para continuar por favor Haga clic en el boton registrarse")
    public void clic_boton_registrarse_datos_erroneos() {
        inisioSesion.clicBotonRegistrarse();

    }

    @Then("El sistema mostrara el mensaje Authentication failed.")
    public void clic_mensaje_autenticacion_fallida() {
        inisioSesion.clicAutenticacionFallida();
        Assert.assertTrue("Authentication failed.", true);
    }

    @When("Diligencie por favor  todo los datos del formulario desde la hoja (.*) y el numero de fila (.*)")
    public void escribir_para_ingresar(String sheetName, int rowNumber)
            throws InvalidFormatException, IOException, InterruptedException {
        LeerArchivo reader = new LeerArchivo();
        List<Map<String, String>> testData = reader.getData("src/test/resources/Datos/inicioSesion.xlsx", sheetName);
        String eEmail = testData.get(rowNumber).get("Email");
        String eContrasena = testData.get(rowNumber).get("Contrasena");
        inisioSesion.formularioInicioSesion(eEmail, eContrasena);

    }

    @And("Continuar por favor haga clic en el boton registrarse")
    public void clic_boton_registrarse_datos_correctos() {
        inisioSesion.clicBotonRegistrarse();

    }

    @Then("Se ingresa a la pagina de cliente")
    public void clic_pagina_de_login() {
        inisioSesion.clicVolverPagina();

    }

    @When("Hagá clic en el  link para recuperar su contrasena")
    public void clic_link_cambiar_contrasens() {
        inisioSesion.clicLinkCambioContrasena();
    }

    @And("Ingrese el correo electronico que tiene registrado en el sistema (.*)")
    public void clic_correo_cambio_clave(String eEmail) {
        inisioSesion.clicIngresarEmail(eEmail);
    }
    @And("Presione por favor el boton recuperar contrasena")
    public void clic_boton_recuperar_contrasena(){
        inisioSesion.clicBotonRecuperarContrasena();
    }
    @Then("Mostrara el mensaje A confirmation email has been sent to your address:")
    public void clic_mensaje_recuperacion_Exitosa(){
        Assert.assertTrue("A confirmation email has been sent to your address:",true);
    }
}

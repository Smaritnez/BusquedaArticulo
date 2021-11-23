package steps;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LeerArchivo;
import pages.RegistroUsuarioPage;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class RegistroUsuarioSteps {

    RegistroUsuarioPage registro = new RegistroUsuarioPage();

    @Given("Clic en el boton registrarse")
    public void clic_boton_registrarse() {
        registro.clicOpcionLogin();
    }

    @When("Digite un correo electronico para continuar (.*)")
    public void clic_ingresar_correo(String eEmailCrearCuanta) {
        registro.escribirCorreo(eEmailCrearCuanta);
    }

    @And("Presionar el boton crear cuenta")
    public void clic_boton_crear_cuenta() {
        registro.clicBotonCrearCuenta();
    }

    @And("Favor diligenciar todo los datos del formulario desde la hoja (.*) y el numero de fila (.*)")
    public void clic_formulario_registro(String sheetName, int rowNumber)
            throws InvalidFormatException, IOException, InterruptedException {
        LeerArchivo reader = new LeerArchivo();
        List<Map<String, String>> testData = reader.getData("src/test/resources/Datos/Registro.xlsx", sheetName);
        String eNombre = testData.get(rowNumber).get("PrimerNombre");
        String eApellido = testData.get(rowNumber).get("PrimerApellido");
        String eContrasena = testData.get(rowNumber).get("Contrasena");
        String eNombres = testData.get(rowNumber).get("Nombre");
        String eApellidos = testData.get(rowNumber).get("Apellido");
        String eEmpresa = testData.get(rowNumber).get("Empresa");
        String eDireccion = testData.get(rowNumber).get("Direccion");
        String eCiudad= testData.get(rowNumber).get("Ciudad");
        String eCodigoPostal= testData.get(rowNumber).get("CodigoPostal");
        String eMovil= testData.get(rowNumber).get("Movil");

        registro.formularioRegistro(eNombre, eApellido, eContrasena, eNombres, eApellidos, eEmpresa, eDireccion, eCiudad, eCodigoPostal, eMovil);
    }
    @And("Seleccionar por favor un estado (.*)")
    public void clic_Selecionar_estado(String eEstado){
        registro.seleccionarEstado(eEstado);
    }
    @And("Hago clic en el boton registrarse")
    public void clic_boton_registrar(){
        registro.clicBotonRegistrarse();
    }

}

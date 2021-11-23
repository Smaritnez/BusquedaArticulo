package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.BusquedaArticuloPage;
import pages.LeerArchivo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class BusquedaArticuloSteps {

    BusquedaArticuloPage buscarArticulo = new BusquedaArticuloPage();

    @Given("Hacer clic en el recuadro  de busqueda de prendas")
    public void clic_cuadro_buscar_prenda() {
        buscarArticulo.clicBuscarArticulo();
    }
    @When("Diligencie todo los datos del formulario desde la hoja (.*) y el numero de fila (.*)")
    public void escribir_para_buscar_prenda(String sheetName, int rowNumber)throws InvalidFormatException, IOException, InterruptedException{
        LeerArchivo reader = new LeerArchivo();
        List<Map<String, String>> testData = reader.getData("src/test/resources/Datos/BuscarPrenda.xlsx", sheetName);
        String eBuscarPrenda=testData.get(rowNumber).get("Prenda");
        buscarArticulo.clicBuscarPrenda(eBuscarPrenda);
    }
    @And("Hacer clic en el boton buscar")
    public void clic_boton_buscar(){
        buscarArticulo.clicBotonBuscar();
        buscarArticulo.clicBotonDisponible();
        buscarArticulo.clicAgregarCarrito();
        buscarArticulo.clicSeguirComprando();
        buscarArticulo.clicVolverPagina();
    }
    @And("Presionar en el carrito para continuar con la compra")
    public void clic_carrito_compra(){
        buscarArticulo.clicCarritoCompra();
    }
    @And("Continuar con el proceso de compra")
    public void clic_continuar_compra(){
        buscarArticulo.clicContinuarCompra();
    }
    @And("Por favor hacér clic en el boton pasar a caja")
    public void clic_boton_pasar_caja(){
        buscarArticulo.clicBotonPasarCaja();

    } 
    @And("Click en el boton continuar compra por favor")
    public void clic_contiar_compra_pagar(){
        buscarArticulo.clicBotonContinuarCompra();
    }

}

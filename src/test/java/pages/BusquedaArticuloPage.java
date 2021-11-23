package pages;

public class BusquedaArticuloPage extends BasePage {
    // #region Variables
    private String buscarPrenda = "search_query_top";
    private String btnBuscar = "//*[@id='searchbox']/button";
    private String disponible="//*[@id='center_column']/ul/li/div/div[2]/span/span";
    private String btnAgregarCarrito="//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]";
    private String continuarComprendo="//*[@id='layer_cart']/div[1]/div[1]";
    private String btnContinuarComprando="//*[@id='layer_cart']/div[1]/div[2]/div[4]/span";
    private String paginaPrincipal="//*[@id='columns']/div[1]/a/i";
    private String carritoCompra="//*[@id='header']/div[3]/div/div/div[3]/div/a";
    private String continuarCompra="//*[@id='center_column']/p[2]/a[1]";
    private String btnPasarCaja="//*[@id='center_column']/form/p/button/span";
    private String continuarCompras="//*[@id='form']/p/button/span";
    private String aceptaTerminos="cgv";
    // #endregion

    // #region Constructor
    public BusquedaArticuloPage() {
        super(driver);

    }

    // #endregion
    // #region Metodos
    public void clicBuscarArticulo() {
        clicId(buscarPrenda);
    }

    public void clicBuscarPrenda(String eBuscarPrenda) {
        escribirId(buscarPrenda, eBuscarPrenda);

    }

    public void clicBotonBuscar() {
        clic(btnBuscar);
    }
    public void clicBotonDisponible(){
        clic(disponible);
    }
    public void clicAgregarCarrito(){
        clic(btnAgregarCarrito);
    }
    public void clicSeguirComprando(){
        String ventanaPrincipal = cambiarAVentanaSecundaria();
        clic(continuarComprendo);
        clic(btnContinuarComprando);
        volverAVentanaPrincipal(ventanaPrincipal);

    }
    public void clicVolverPagina(){
        clic(paginaPrincipal);
    }
    public void clicCarritoCompra(){
        clic(carritoCompra);
    }
     public void clicContinuarCompra(){
         clic(continuarCompra);
     }

     public void clicBotonPasarCaja(){
         clic(btnPasarCaja);
     }
     public void clicBotonContinuarCompra(){
         marcarCheckbox(aceptaTerminos);
         clic(continuarCompras);
     }
    // #endregion

}

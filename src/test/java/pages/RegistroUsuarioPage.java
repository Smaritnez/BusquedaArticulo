package pages;

public class RegistroUsuarioPage extends BasePage {
    // #region Variables
    private String emailCrearCuanta = "email_create";
    private String opcionLogin = "//*[@id='header']/div[2]/div/div/nav/div[1]/a";
    private String btnCrearCuenta = "SubmitCreate";
    private String nombre = "customer_firstname";
    private String apellido = "customer_lastname";
    private String contrasena = "passwd";
    private String nombres = "firstname";
    private String apellidos = "lastname";
    private String empresa = "company";
    private String direccion = "address1";
    private String ciudad = "city";
    private String estado = "id_state";
    private String codigoPostal = "postcode";
    private String movil = "phone_mobile";
    private String btnRegistrese = "submitAccount";
    // #endregion

    // #region Constructor
    public RegistroUsuarioPage() {
        super(driver);

    }
    // #endregion

    // #region Metodos

    public void clicOpcionLogin() {
        clic(opcionLogin);
    }

    public void escribirCorreo(String eEmailCrearCuanta) {
        escribirId(emailCrearCuanta, eEmailCrearCuanta);

    }

    public void clicBotonCrearCuenta() {
        clicId(btnCrearCuenta);
    }

    public void formularioRegistro(String eNombre, String eApellido, String eContrasena, String eNombres,
            String eApellidos, String eEmpresa, String eDireccion, String eCiudad, String eCodigoPostal,
            String eMovil) {
        escribirId(nombre, eNombre);
        escribirId(apellido, eApellido);
        escribirId(contrasena, eContrasena);
        escribirId(nombres, eNombres);
        escribirId(apellidos, eApellidos);
        escribirId(empresa, eEmpresa);
        escribirId(direccion, eDireccion);
        escribirId(ciudad, eCiudad);
        escribirId(codigoPostal, eCodigoPostal);
        escribirId(movil, eMovil);

    }

    public void seleccionarEstado(String eEstado) {
        opValorListaJS(estado, eEstado);
    }
    public void clicBotonRegistrarse(){
        clicId(btnRegistrese);
    }

    // #endregion

}

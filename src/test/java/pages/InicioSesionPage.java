package pages;



public class InicioSesionPage extends BasePage{
    //#region Variables
    private String opcionLogin="//*[@id='header']/div[2]/div/div/nav/div[1]/a";
    private String email="email";
    private String contrasena="passwd";
    private String btnRegistrarse="SubmitLogin";
    private String mensajeAlerta="//*[@id='center_column']/div[1]";
    private String paginaPrincipal="//*[@id='columns']/div[1]/a/i";
    private String linkCambioContrasena="//*[@id='login_form']/div/p[1]/a";
    private String recuperarContrasena="//*[@id='form_forgotpassword']/fieldset/p/button";
    //#endregion
    
    //#region Constructor
    public InicioSesionPage() {
        super(driver);
        
    }
    //#endregion

    //#region Metodos
    public void clicOpcionLogin(){
        clic(opcionLogin);
    }
    public void formularioInicioSesion(String eEmail,String eContrasena){
        escribirId(email, eEmail);
        escribirId(contrasena, eContrasena);

    }
    public void clicBotonRegistrarse(){
        clicId(btnRegistrarse);
    }
    public void clicAutenticacionFallida(){
        clic(mensajeAlerta);
    }
    public void clicVolverPagina(){
        clic(paginaPrincipal);
    }
    public void clicLinkCambioContrasena(){
        clic(linkCambioContrasena);
    }
    public void clicIngresarEmail(String eEmail){
        escribirId(email,eEmail);
    }
    public void clicBotonRecuperarContrasena(){
        clic(recuperarContrasena);
    }
    ////#endregion
    
}

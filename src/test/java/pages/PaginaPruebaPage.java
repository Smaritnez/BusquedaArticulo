package pages;

public class PaginaPruebaPage extends BasePage {

    public PaginaPruebaPage() {
        super(driver);

    }
    public void abrirNavegador(){
        navegar("http://automationpractice.com/index.php");
    }

}

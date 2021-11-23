package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    // // #region Variable
    protected static WebDriver driver;
    private static WebDriverWait wait;
    // private static Actions action;

    // // #endregion
    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions opChrome = new ChromeOptions();
        driver = new ChromeDriver(opChrome);
        wait = new WebDriverWait(driver, 19);

    }
    // #endregion

    // #region Constructor

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    // #endregion
    // #region Métodos

    /**
     * Este metodo se usa para ingresar a una url
     * 
     * @param url Este es el primer parametro para indicar la url a ingresar
     */
    public static void navegar(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * Este metodo se usa para encontrar un elemento
     * 
     * @param localizador Este es el parametro para encontrar un elemento
     */

    private WebElement Buscar(String localizador) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(localizador)));
    }

    private WebElement BuscarId(String localizador) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(localizador)));
    }

    /**
     * Este metodo se usa para hacer clic a un elemento
     * 
     * @param localizador Este es el parametro para encontrar el elemento
     */
    public void clic(String localizador) {
        Buscar(localizador).click();

    }

    public void clicId(String localizador) {
        BuscarId(localizador).click();

    }

    /**
     * Este metodo se usa para escribir en un campo de tipo texto
     * 
     * @param localizador Este es el primer parametro para encontrar el elemento
     *                    dentro del DOM
     * @param texto       es el segundo parametro para indicar el dato que se quiere
     *                    escribir en el campo
     */
    public void escribir(String localizador, String texto) {
        Buscar(localizador).click();
        Buscar(localizador).sendKeys(texto);
    }

    /**
     * Este metodo se usa para escribir en un campo de tipo texto
     * 
     * @param localizador Este es el primer parametro para encontrar el elemento
     *                    dentro del DOM por id
     * @param texto       es el segundo parametro para indicar el dato que se quiere
     *                    escribir en el campo
     */
    public void escribirId(String localizador, String texto) {
        BuscarId(localizador).click();
        BuscarId(localizador).sendKeys(texto);
    }

    /**
     * Este metodo se usa para marcar un checkbox utilizando javascript
     * 
     * @param localizador Este es el primer parametro para encontrar el elemento
     */
    public void marcarCheckbox(String localizador) {
        String jsScript = "document.getElementById('" + localizador + "').checked = true";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(jsScript);
    }

    /**
     * Este metodo se utiliza para seleccionar un elemento por id a traves de
     * javascript
     * 
     * @param localizador Id del elemento en el cual se necesita hacer clic
     */
    public void ClickJavaScript(String localizador) {
        WebElement element = BuscarId(localizador);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String cambiarAVentanaSecundaria() {
        String ventanaPrincipal = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String ventanaNueva : handles) {
            if (!ventanaNueva.equals(ventanaPrincipal)) {
                driver.switchTo().window(ventanaNueva);
            }
        }
        return ventanaPrincipal;
    }

    /**
     * Este metodo se utiliza para retornar a la ventana principal del navegador
     * 
     * @Param Id de la ventana principal del navegador
     */
    public void volverAVentanaPrincipal(String ventanaPrincipal) {
        driver.switchTo().window(ventanaPrincipal);
    }

    public void opValorListaJS(String localizador, String valor) {
        String jsScript = "$('#" + localizador + "').val('" + valor + "');" + "$('#" + localizador
                + "').trigger('chosen:updated');" + "$('#" + localizador + "').change();";
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(jsScript);
    }
}

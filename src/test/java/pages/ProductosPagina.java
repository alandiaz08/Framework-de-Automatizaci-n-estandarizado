package pages;

import driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.LoginPagina.TIME_OUT;

/**
 * Clase que representa la página de productos en una aplicación web.
 * Extiende de {@code WebDriverManager} para heredar las capacidades de manejo de WebDriver,
 * facilitando las interacciones con la página de productos.
 *
 * Esta clase encapsula los elementos y las funcionalidades específicas de la página de productos,
 * proporcionando métodos para realizar acciones como obtener la lista de productos y interactuar con ellos.
 */
public class ProductosPagina extends WebDriverManager {

  //Selectores
  protected static By listaProductos = By.cssSelector("[id='inventory_container']");

  /**
   * Constructor para la clase de la página de productos.
   * Inicializa la instancia de WebDriver utilizada para interactuar con la página.
   * @param driver El controlador de WebDriver.
   */
  public ProductosPagina (WebDriver driver) {
    this.driver = driver;
  }

  /**
   * Verifica si el contenedor de la lista de productos está presente y visible en la página.
   * @return true si el contenedor está visible, false en caso contrario.
   */
  public boolean estaPresenteListaProductos() {
    logger.info("El contenedor de la lista de productos está presente");
    WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
    try {
      // Utiliza el método findElement para buscar el contenedor de la lista de productos.
      // Comprueba si el contenedor está visible.
      return wait.until(ExpectedConditions.visibilityOfElementLocated(listaProductos)).isDisplayed();
    } catch (NoSuchElementException e) {
      logger.error("El contenedor de la lista de productos no está presente.");
      // Si el elemento no se encuentra, retorna false.
      return false;
    }
  }

}

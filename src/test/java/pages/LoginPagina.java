package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.WebDriverManager;

/**
 * Clase loginPagina que gestiona las interacciones en la página de inicio de sesión.
 * Extiende de WebDriverManager para heredar las capacidades de manejo del WebDriver.
 * Provee métodos para ingresar credenciales y validar estados en la página de login.
 * </pre>
 */
public class LoginPagina extends WebDriverManager {

	//Selectores
	private WebDriver driver;
	protected static By entradaUsuario = By.cssSelector("[data-test='username']");
	protected static By entradaContraseña = By.cssSelector("[data-test='password']");
	protected static By botonIniciarSesion = By.cssSelector("[data-test='login-button']");
	protected static By mensajeBloqueado = By.cssSelector("[data-test='error']");
	
	protected static int TIME_OUT = 5;

	/**
	 * Constructor para la clase de la página de inicio de sesión.
	 * Inicializa la instancia de WebDriver utilizada para interactuar con la página.
	 * @param driver El controlador de WebDriver.
	 */
	public LoginPagina(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Ingresa el nombre de usuario en el campo correspondiente.
	 * @param usuario El nombre de usuario a ingresar.
	 * @return La página de login para permitir el encadenamiento de métodos.
	 */
	public LoginPagina ingresarUsuarioErroneo(String usuario) {
		logger.debug("Ingresando el nombre de usuario: " + usuario);
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(entradaUsuario)).sendKeys(usuario);
		return this;
	}

	/**
	 * Ingresa el nombre de usuario en el campo correspondiente.
	 * @param usuario El nombre de usuario a ingresar.
	 * @return La página de login para permitir el encadenamiento de métodos.
	 */
	public LoginPagina ingresarUsuario(String usuario) {
		logger.debug("Ingresando el nombre de usuario: " + usuario);
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(entradaUsuario)).sendKeys(usuario);
		return this;
	}


	/**
	 * Ingresa la contraseña en el campo de contraseña.
	 * @param contraseña La contraseña a ingresar.
	 * @return La página de login para permitir encadenamiento de métodos.
	 */
	public LoginPagina ingresarContraseña(String contraseña) {
		logger.debug("Ingresando contraseña: " + contraseña);
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(entradaContraseña)).sendKeys(contraseña);
		return this;
	}

	/**
	 * Hace clic en el botón de iniciar sesión.
	 * @return La página de login para permitir encadenamiento de métodos.
	 */
	public LoginPagina hacerClickEnIniciarSesion() {
		logger.debug("Haciendo clic en el botón de iniciar sesión");
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
		wait.until(ExpectedConditions.elementToBeClickable(botonIniciarSesion)).click();
		return this;
	}

	/**
	 * Verifica si el mensaje de cuenta bloqueada es visible.
	 * @return Verdadero si el mensaje está visible, falso de lo contrario.
	 */
	public boolean estaBloqueadoMensajeVisible() {
		logger.debug("Verificando la visibilidad del mensaje de error.");
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT);
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeBloqueado)).isDisplayed();
		} catch (TimeoutException e) {
			logger.error("El mensaje de cuenta bloqueada no está visible.");
			return false;
		}
	}

	
}

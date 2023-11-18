package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Gestor de WebDriver que proporciona una capa de abstracción sobre la configuración
 * y manejo del WebDriver de Selenium. Encapsula la funcionalidad común para la
 * inicialización y configuración de instancias de WebDriver que serán utilizadas
 * por las clases de pruebas.
 *
 * Uso:
 * Esta clase se extiende en las clases de prueba para obtener métodos de
 * configuración y utilidades predefinidas, permitiendo un enfoque modular
 * y reutilizable para la gestión de navegadores en pruebas automatizadas.
 */
public class WebDriverManager {
	protected WebDriver driver;

	/**
	 * Logger.
	 */
	protected static final Logger logger = LogManager.getLogger(WebDriverManager.class);

	 LocalDate time = LocalDate.now(); 
	 long startTime;
	 long delta;

	/**
	 * Calcula el tiempo transcurrido desde un momento de inicio.
	 */
	public void deltaTime(){
		long currentTime = System.currentTimeMillis();
		delta = currentTime - startTime;
		logger.info("Tiempo transcurrido calculado como: " + delta + " milisegundos.");
	}

	/**
	 * Configura el entorno antes de cada método de prueba.
	 * Inicializa el navegador y navega a la página de inicio.
	 * @throws Exception si ocurre un error al configurar el entorno de prueba.
	 */
	@BeforeMethod
	public void setUp() throws Exception {
		logger.info("Configurando el entorno de prueba.");
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		startTime = System.currentTimeMillis();
	}

	/**
	 * Limpia el entorno después de cada método de prueba.
	 * Cierra y sale del navegador.
	 * @param result Resultado de la ejecución del método de prueba.
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {
		logger.info("El test " + result.getMethod().getDescription() +
						" resultó en estado: " + ((result.getStatus() == ITestResult.SUCCESS) ? "EXITOSO" : "FALLIDO"));
		driver.close();
		driver.quit();
	}
}

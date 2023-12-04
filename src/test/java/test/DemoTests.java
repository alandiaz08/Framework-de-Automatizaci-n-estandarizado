package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import driver.WebDriverManager;
import pages.LoginPagina;
import pages.ProductosPagina;

public class DemoTests extends WebDriverManager{
	@Test(testName = "Login Test",
				description = "Verifica que el usuario pueda iniciar sesión y ver la lista de productos.")
	public void test() {
		// Datos
		final String usuario = "standard_user";
		final String contraseña = "secret_sauce";

		//Acto
		LoginPagina loginPagina = new LoginPagina(driver);

		loginPagina
						.ingresarUsuario(usuario)
						.ingresarContraseña(contraseña)
						.hacerClickEnIniciarSesion();

		ProductosPagina productosPagina = new ProductosPagina(driver);

		//Afirmacion

		Assert.assertTrue("La lista de productos debería estar presente.",
						productosPagina.estaPresenteListaProductos());
	}	

}

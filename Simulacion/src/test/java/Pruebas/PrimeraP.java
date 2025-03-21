package Pruebas;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;




public class PrimeraP {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","./src/test/resources/Driver/chromedriver.exe");
		driver= new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		}

		@Test
		public void PrimerTest() {
			WebElement txtUser = driver.findElement(By.id("user-name"));
			WebElement txtPasswrd = driver.findElement(By.id("password"));
			WebElement btnlogin = driver.findElement(By.id("login-button"));
		
			if (txtPasswrd.isDisplayed() && txtPasswrd.isEnabled()) {
				txtUser.sendKeys("standard_user");
				txtPasswrd.sendKeys("secret_sauce");
				btnlogin.click();
			}
			
			WebElement lbproducts = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/div[3]/div"));
			String txtProducts = lbproducts.getText();
			System.out.println(txtProducts);
			
			assertEquals("Prueba de lb prodcts","Products",txtProducts);
			}
		
		public void LoginIN() {
			WebElement txtUser = driver.findElement(By.id("user-name"));
			WebElement txtPasswrd = driver.findElement(By.id("password"));
			WebElement btnlogin = driver.findElement(By.id("login-button"));
		
			if (txtPasswrd.isDisplayed() && txtPasswrd.isEnabled()) {
				txtUser.sendKeys("standard_user");
				txtPasswrd.sendKeys("secret_sauce");
				btnlogin.click();
			}
		}
		
		@Test
		public void SegundoTest() {
			LoginIN();
			
			WebElement btnsauceBP= driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div"));
			if(btnsauceBP.isDisplayed()) {
				btnsauceBP.click();
			}
			
			WebElement txtdescripcion = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div[2]"));
			String descripcion = txtdescripcion.getText();
			assertEquals("descripcion correcta","carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",descripcion);
			
			
			
		}

		@Test
		public void TercerTest() {
		    LoginIN();

		    List<WebElement> buttons = driver.findElements(By.className("btn_inventory"));
		    buttons.get(0).click(); // Selecciona el primer botón
		    
		    WebElement btcarrito = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/a"));
		    btcarrito.click();
		    String producto="Sauce Labs Backpack";
		    WebElement txtProducto = driver.findElement(By.className("inventory_item_name"));
		    String producto2= txtProducto.getText();
		   
		    if(producto2.equals(producto)) {
		    	System.out.println("SE AGREGO EL PRIMER ITEM");
		    	
		    }else {
		    	System.out.println("NOP");
		    }
		    
		    
		    
}
		@Test
		public void cuartoTest() {
			TercerTest();
			WebElement btCheck = driver.findElement(By.className("checkout_button"));
			btCheck.click();
			WebElement txtname = driver.findElement(By.id("first-name"));
			WebElement txtapellido = driver.findElement(By.id("last-name"));
			WebElement txtzip = driver.findElement(By.id("postal-code"));
			
			if(txtname.isDisplayed()&& txtapellido.isDisplayed()&& txtzip.isDisplayed() ) {
				txtname.sendKeys("Billem");
				txtapellido.sendKeys("Quesada");
				txtzip.sendKeys("30109");
				
			}
			WebElement btcontinue = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input"));
			btcontinue.click();
			
			}
		
		@Test
		public void quintoTest() throws InterruptedException {
			cuartoTest();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).perform();  // Baja una pantalla
			Thread.sleep(1000); // Espera 1 segundo
			WebElement finishButton = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]"));
			finishButton.click();
			
			Thread.sleep(1000); // Espera 1 segundo

			WebElement txtconfirmacion = driver.findElement(By.className("complete-header"));
		
			String confirmacion= txtconfirmacion.getText();
			String confirmacion1="THANK YOU FOR YOUR ORDER";
			if(confirmacion1.equals(confirmacion)) {
				System.out.println("CONFIRMACION DE TRANSACCION");
			}else {
				System.out.println("nop 2 ");
			}}
		
		
		@Test
		public void sextoTest() throws InterruptedException{
			cuartoTest();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.PAGE_DOWN).perform();  // Baja una pantalla
			Thread.sleep(1000); // Espera 1 segundo
			WebElement finishButton = driver.findElement(By.className("btn_action"));
			finishButton.click();
			
			Thread.sleep(1000);
			WebElement btmenu = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/button"));
			if(btmenu.isEnabled()) {
				btmenu.click();
				System.out.println("menu accedido");
			}else {
				System.out.println("nop 3 ");
			}
			
			Thread.sleep(1000);
			WebElement btsalir = driver.findElement(By.id("logout_sidebar_link"));
			if(	btsalir.isEnabled()) {
				btsalir.click();
				System.out.println("logout exitoso ");
				
			}else{
				System.out.println("nop 4 ");
			}
			
			
			
		
		}
	
			
			
			
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

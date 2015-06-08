import junit.framework.Assert;

<<<<<<< HEAD
=======
import org.junit.After;
import org.junit.Before;
>>>>>>> 94ccb32ad2e947d2f61b66d09baa999ad87ea8a4
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
//import org.openqa.selenium.firefox.FirefoxDriver;
=======
import org.openqa.selenium.firefox.FirefoxDriver;
>>>>>>> 94ccb32ad2e947d2f61b66d09baa999ad87ea8a4
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class DesafiosBlogEliasNogueira {
	private String baseURL = null;
<<<<<<< HEAD
	//WebDriver driver = new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	 @BeforeClass
	 public static void setup(){
	  System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
	 }
=======
	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.chrome.driver", "./resouce/chromedriver.exe");
	}
	@After
	public void close(){
		driver.close();
	}
//	WebDriver driver = new FirefoxDriver();
	
	WebDriver driver = new ChromeDriver();
>>>>>>> 94ccb32ad2e947d2f61b66d09baa999ad87ea8a4
	
	@Test
	public void somaComNumerosAleatorios(){
		 baseURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/1desafio/";
		 String valor1, valor2;
		 int resultado;
		 driver.get(baseURL);
		 
		 valor1 = driver.findElement(By.id("number1")).getText();
		 valor2 = driver.findElement(By.id("number2")).getText();
		 resultado = Integer.parseInt(valor1) + Integer.parseInt(valor2);
		 driver.findElement(By.name("soma")).sendKeys(Integer.toString(resultado));
		 driver.findElement(By.name("submit")).click();
		 Assert.assertEquals(true,  driver.findElement(By.id("resultado")).isDisplayed());
		 Assert.assertEquals("CORRETO", driver.findElement(By.id("resultado")).getText());
		 edicaoInline();
		 
	}
	
	public void edicaoInline(){
		 baseURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/2desafio/";
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 driver.get(baseURL);
		 
		 driver.findElement(By.id("name_rg_display_section")).click();
		 driver.findElement(By.id("nome_pessoa")).clear();
		 driver.findElement(By.id("nome_pessoa")).sendKeys("Nome alterado");
		 driver.findElement(By.xpath("//div[@id='name_hv_editing_section']/input[2]")).click();
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name_rg_display_section"))));
		 
		 driver.findElement(By.id("email_rg_display_section")).click();
		 driver.findElement(By.id("email_value")).clear();
		 driver.findElement(By.id("email_value")).sendKeys("alterado@email.com");
		 driver.findElement(By.xpath("//div[@id='email_hv_editing_section']/input[2]")).click();
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_rg_display_section"))));
		 
		 driver.findElement(By.id("phone_rg_display_section")).click();
		 driver.findElement(By.id("phone_value")).clear();
		 driver.findElement(By.id("phone_value")).sendKeys("11 9999-9999");
		 driver.findElement(By.xpath("//div[@id='phone_hv_editing_section']/input[2]")).click();
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("phone_rg_display_section"))));
		 
		 Assert.assertEquals("Nome alterado",  driver.findElement(By.id("name_rg_display_section")).getText());
		 Assert.assertEquals("Email: alterado@email.com",  driver.findElement(By.id("email_rg_display_section")).getText());
		 Assert.assertEquals("Telefone: 11 9999-9999",  driver.findElement(By.id("phone_rg_display_section")).getText());
		 carrinhoDeComprasAjax();
	}
	//@Test
	public void carrinhoDeComprasAjax(){
		Actions action = new Actions(driver);
		Action dragAndDrop = null;
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php");
		driver.manage().window().maximize();
		WebElement iphone = driver.findElement(By.xpath("//div[@class='content drag-desired']/div[3]"));
		WebElement ipodSuffle = driver.findElement(By.xpath("//div[@class='content drag-desired']/div[4]"));
		WebElement appleTv = driver.findElement(By.xpath("//div[@class='content drag-desired']/div[6]"));
		WebElement carrinho = driver.findElement(By.id("cart-icon"));
		
		dragAndDrop = action.clickAndHold(iphone).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		dragAndDrop = action.clickAndHold(ipodSuffle).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		dragAndDrop = action.clickAndHold(appleTv).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		

	}
	public void autoPreenchimentoDeCampos(){
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/4desafio/");
		driver.findElement(By.id("cep")).sendKeys("05424060");
		driver.findElement(By.id("cep"));
		//incompleto devido ao desafio estar com bug
	}
}

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class DesafiosBlogEliasNogueira {
	private String baseURL = null;
	WebDriver driver = new FirefoxDriver();
	
	//@Test
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
	}
	@Test
	public void carrinhoDeComprasAjax(){
		Actions action = new Actions(driver);
		Action dragAndDrop = null;
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php");
		driver.manage().window().maximize();
		WebElement ipod = driver.findElement(By.xpath("//div[@class='content drag-desired']/div[1]"));
		WebElement carrinho = driver.findElement(By.xpath("//div[@class='content drop-here ui-droppable']"));
		
		
		dragAndDrop = action.clickAndHold(ipod).moveToElement(carrinho).release().build();
		dragAndDrop.perform();
		//(new Actions(driver)).dragAndDrop(element, target).perform();
	}
	
}

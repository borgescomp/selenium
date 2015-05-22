import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class SiteCalculoExtatoTest {
	@Test
	public void testConversaoUnidadesComprimento(){
		 String baseURL = "http://calculoexato.com.br/";
		 WebDriver driver = new FirefoxDriver();
		 driver.get(baseURL);
	     
	     //WebElement element;
	     
	     driver.findElement(By.xpath("//strong/a[text()='Conversão de unidades']")).click();
	     driver.findElement(By.xpath("//strong/a[text()='1. Conversão de unidades de comprimento']")).click();
	     driver.findElement(By.id("txt1")).clear();
	     driver.findElement(By.id("txt1")).sendKeys("100");
	     Select select = new Select(driver.findElement(By.id("comboConv1")));
	     select.selectByVisibleText("quilômetro(s)");
	     Select select2 = new Select(driver.findElement(By.id("comboConv2")));
	     select2.selectByVisibleText("milha(s)");
	     
	     driver.findElement(By.id("btnContinuar")).click();
	     Assert.assertEquals("100 quilômetro(s) = 62,1371 milha(s)", driver.findElement(By.xpath("//span[@id='lblMsg']")).getText());
	     
	     	     
	}
}

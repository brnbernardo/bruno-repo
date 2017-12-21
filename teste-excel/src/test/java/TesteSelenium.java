import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteSelenium {

	public static void main(String[] args) {
		//preencheFormularioCorreiosBuscaLogradouroPorBairro();
		testandoCorporativoService();
	}

	@Test
	public static void testandoCorporativoService() {
		
		System.setProperty("webdriver.chrome.driver", "/d:/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/CorporativoService");
		
		// Preenche a Localidade com o valor "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("negocio"));
		inputLocalidade.sendKeys("24802443");
		
		WebElement buttonBuscar = driver.findElement(By.cssSelector("button[type='button'"));
		buttonBuscar.click();
		
	}
	
	@Test
	public static void preencheFormularioCorreiosBuscaLogradouroPorBairro() {

		System.setProperty("webdriver.chrome.driver", "/d:/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		// Visita a página do Correios
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/buscaLogBairro.cfm");

		// Escolhe o valor de UF
		Select selectUF = new Select(driver.findElement(By.name("UF")));
		selectUF.selectByVisibleText("RJ");
		// Preenche a Localidade com o valor "Rio de Janeiro"
		WebElement inputLocalidade = driver.findElement(By.name("Localidade"));
		inputLocalidade.sendKeys("Rio de Janeiro");
		// Preenche o campo Bairro com o valor "Copacabana"
		WebElement inputBairro = driver.findElement(By.name("Bairro"));
		inputBairro.sendKeys("Copacabana");

		// clica no botão Buscar
		WebElement buttonBuscar = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonBuscar.click();
	}

}

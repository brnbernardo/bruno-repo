import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TesteSelenium {

	public static void main(String[] args) {
		// preencheFormularioCorreiosBuscaLogradouroPorBairro();

		try {
			montarHeader();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// testandoCorporativoService();
	}

	@Test
	public static void testandoCorporativoService() {

		// System.setProperty("webdriver.chrome.driver", "/d:/chromedriver.exe");

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

	private static void montarHeader() throws InterruptedException {

		Map<String, String> headersValues = new ConcurrentHashMap<>();

		headersValues.put("TIPOSITE", "SISTEMAS");
		headersValues.put("LOGIN", "T803530");
		headersValues.put("LOCALUSUARIO", "4402");

		File addonpath = new File("D:\\Users\\t803530\\Downloads\\Modify-Headers-for-Google-Chrome_v2.0.7.crx");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(addonpath);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(options);
		driver.get("chrome-extension://innpjfdalfhpcoinfnehdnbkglpmogdi/options.html");
		driver.navigate().refresh();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

		WebElement actionElem = driver.findElement(By.name("action"));
		Select select = new Select(actionElem);
		select.selectByVisibleText("Add");
		WebElement nameElem = driver.findElement(By.name("name"));
		nameElem.sendKeys("cpf");

		WebElement valueElem = driver.findElement(By.name("value"));
		valueElem.sendKeys("98765432100");

		WebElement descElem = driver.findElement(By.name("description"));
		descElem.sendKeys("empty");
		driver.findElement(By.xpath("//button[@id='btn_save_1']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Start Modifying Headers']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();
		Thread.sleep(2000);

		montarMapHeader(headersValues, driver);

		driver.get("http://localhost:8080/CorporativoService");

		List<WebElement> list = driver.findElements(By.className("container"));
		Thread.sleep(2000);

		for (WebElement element : list) {

			WebElement we = element.findElement(By.xpath(".//*[@id='negocio']"));
			if (we.isDisplayed()) {
				we.sendKeys("24802443");
			}

		}
		WebElement buttonBuscar = driver.findElement(By.cssSelector("button[type='button'"));
		buttonBuscar.click();

		Thread.sleep(30000); // Let the user actually see something!
		driver.close();
		driver.quit();

	}

	private static void montarMapHeader(Map<String, String> headersValues, WebDriver driver)
			throws InterruptedException {
		
		int i = 2;
		for (Map.Entry<String, String> entry : headersValues.entrySet()) {

			driver.findElement(By.xpath("//button[@tooltip='Add New']")).click();

			WebElement action = driver.findElement(By.name("action"));
			Select selectElemen = new Select(action);
			selectElemen.selectByVisibleText("Add");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys(entry.getKey());

			WebElement value = driver.findElement(By.name("value"));
			value.sendKeys(entry.getValue());

			WebElement desc = driver.findElement(By.name("description"));
			desc.sendKeys("empty");

			String id = "btn_save_" + i++;

			driver.findElement(By.xpath("//button[@id='" + id + "']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//button[@tooltip='Enable']")).click();
			Thread.sleep(2000);
		}
	}

}

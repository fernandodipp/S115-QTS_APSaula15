/*
 * Ao clicar no botão de salvar, é realizado as validações abaixo:
Não aceitar nome em branco
Não aceitar endereço em branco
Deve ser selecionado alguma opção do campo sexo
Não aceitar idade em branco e números inválidos.
Aceitar somente valores igual ou acima de 0.

O trabalho consiste em realizar testes de sistema usando a ferramenta Selenium.
Os casos de teste a serem realizados estão abaixo.

Caso de Teste 1: Validar valores válidos e inválidos para o campo nome. 
Caso de Teste 2: Validar o título da página.

 */


package seleniumTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class SeleniumTest {
	static WebDriver driver = null;

	private static String namePaginaPrincipal;

	public SeleniumTest() {
	}

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");

		namePaginaPrincipal = driver.getWindowHandle();
	}


	@Test
	public void casoTeste2() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		String tituloExperado = "Trabalho 2-1";
		
		Assert.assertEquals(tituloExperado, driver.getTitle());
	}

	@Test
	public void testeFormVVVV() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Fulano");
		campoEndereco.sendKeys("Porto Alegre");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("21");
		submit.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("Cadastro realizado com sucesso"));
        alert.accept();
		
	}

	@Test
	public void testeFormFVVV() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("");
		campoEndereco.sendKeys("Porto Alegre");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("21");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo nome"));
		
	}
	
	@Test
	public void testeFormVFVV() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Fulano");
		campoEndereco.sendKeys("");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("21");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo endereco"));
		
	}
	
	@Test
	public void testeFormVVFV() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Fulano");
		campoEndereco.sendKeys("Porto Alegre");
		selectObjectSexo.selectByValue("...");
		campoIdade.sendKeys("21");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Selecione um valor para o campo sexo"));
		
	}
	
	@Test
	public void testeFormVVVFnulo() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Fulano");
		campoEndereco.sendKeys("Porto Alegre");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo idade, somente com numeros"));
		
	}
	
	@Test
	public void testeFormVVVFnegativo() {
		driver.get("C:\\chromedriver_win32\\trabalho2-1.html");
		
		WebElement selectElementSexo = driver.findElement(By.id("sexo"));
		Select selectObjectSexo = new Select(selectElementSexo);
		WebElement campoNome = driver.findElement(By.id("nome"));
		WebElement campoEndereco = driver.findElement(By.id("endereco"));
		WebElement campoIdade = driver.findElement(By.id("idade"));
		WebElement submit = driver.findElement(By.id("botao_somar"));
		
		campoNome.sendKeys("Fulano");
		campoEndereco.sendKeys("Porto Alegre");
		selectObjectSexo.selectByValue("m");
		campoIdade.sendKeys("-21");
		submit.click();
        String codigProximaPagina =  driver.getPageSource();
        Assert.assertTrue(codigProximaPagina.contains("Preencha o campo idade com valores acima de 0"));
		
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}

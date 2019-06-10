package br.com.fatesg.eventos.entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Teste Criar Nova Categoria
 */
//@WebIntegrationTest(value = "server.port=9000")
//@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:9000")
public class CategoriaAutoTest {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
		WebDriver driver = new SafariDriver();
//		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
//		WebDriver driver = new FirefoxDriver();

		driver.get("http://localhost:8080/#/acesso");

		// Maximiza o navegador
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// Login
		driver.findElement(By.id("usuario")).sendKeys("test_robot");
		driver.findElement(By.id("senha")).sendKeys("12345");
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(3000);

		// Cadastro de Categoria
		driver.findElement(By.id("categoria")).click();
		Thread.sleep(3000);

		driver.findElement(By.className("btn-info")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("nome-categoria")).sendKeys("Teste Automatizado");
		driver.findElement(By.className("btn-info")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("descricao-categoria")).sendKeys("Descrição do Teste Automatizado");
		Thread.sleep(3000);

		driver.findElement(By.className("btn-info")).click();
		Thread.sleep(3000);

		// Filtrar Categoria
		driver.findElement(By.id("filtrar-categoria")).sendKeys("Teste Automatizado");

		// Editar de Categoria
		driver.findElement(By.id("editar-categoria")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nome-categoria")).clear();
		driver.findElement(By.id("nome-categoria")).sendKeys("Teste Automatizado Atualizado");
		driver.findElement(By.id("descricao-categoria")).clear();
		driver.findElement(By.id("descricao-categoria")).sendKeys("Descrição do Teste Automatizado " +
				"Atualizado");
		driver.findElement(By.className("btn-info")).click();

		// Filtrar Categoria
		driver.findElement(By.id("filtrar-categoria")).clear();
		driver.findElement(By.id("filtrar-categoria")).sendKeys("Teste Automatizado Atualizado");

		// Excluir de Categoria
		driver.findElement(By.id("excluir-categoria")).click();

		// Atualiza Pagina
		driver.navigate().refresh();
		Thread.sleep(5000);

		driver.close();
	}
}

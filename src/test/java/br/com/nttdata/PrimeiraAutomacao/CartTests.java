package br.com.nttdata.PrimeiraAutomacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTests {

    @Test
    public void testCreateCart() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://store.vivo.com.br/");

        //Clicar em continuar e fechar
        driver.findElement(By.id("consent")).click();

        //Clicar no menun "Celulares"
        driver.findElement(By.xpath("//a[@title='Celulares']")).click();

        //Clicar no primeiro produto da lista
        driver.findElement(By.xpath("(//h3[@class='product-card__name'])[1]")).click();

        // Capturar o preço do produto
        String preco = driver.findElement(By.xpath("(//div[@aria-label='new item price']//p[contains(text(),'R$')])[1]")).getText();
        System.out.println("Preço do produto: " + preco);

        // Clicar em colocar no carrinho
        //driver.findElement(By.xpath("//span[contains(text(), 'Colocar no carrinho')]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Colocar no carrinho']")).click();


        // Verificar se o produto foi adicionado ao carrinho
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement itemNoCarrinho = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("item-description")));

        assertTrue("O produto deveria estar visível no carrinho", itemNoCarrinho.isDisplayed());

        // Verifica valor total do carrinho
        String valorTotal = driver.findElement(By.id("total-value")).getText();
        System.out.println("Valor total do carrinho: " + valorTotal);

        assertEquals("O valor total do carrinho deveria ser igual ao preço do produto", preco, valorTotal);


        driver.quit();
    }
}

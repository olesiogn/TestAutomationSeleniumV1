package br.com.nttdata.PageObject;

import br.com.nttdata.PageObject.pages.PageCarrinho;
import br.com.nttdata.PageObject.pages.PageCelulares;
import br.com.nttdata.PageObject.pages.PageHome;
import br.com.nttdata.PageObject.pages.PageProduto;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageObjectTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void testCreateCart() {
        PageHome home = new PageHome(driver);
        PageCelulares celulares = new PageCelulares(driver);
        PageProduto produto = new PageProduto(driver);
        PageCarrinho carrinho = new PageCarrinho(driver);
        String precoProduto = "";
        String valorTotal = "";
        boolean isVisible = false;

        driver.get("https://store.vivo.com.br/");
        home.clickConsentButton();
        home.selectMenu("Celulares");
        celulares.clickFirstProduct();
        precoProduto = produto.returnProductPrice();
        produto.clickAddToCart();

        isVisible = carrinho.isProductInCartVisible();
        assertTrue("O produto deveria estar visível no carrinho", isVisible);

        valorTotal = carrinho.getTotalCartValue();
        assertEquals("O valor total do carrinho deveria ser igual ao preço do produto", precoProduto, valorTotal);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

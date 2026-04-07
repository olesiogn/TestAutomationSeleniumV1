package br.com.nttdata.PageObject.Pages;

import br.com.nttdata.PageObject.attributes.AttributesProduto;
import org.openqa.selenium.WebDriver;

public class PageProduto extends AttributesProduto {
    private WebDriver driver;

    public PageProduto(WebDriver driver) {
        this.driver = driver;
    }

    public String returnProductPrice() {
        String preco = driver.findElement(productPrice).getText();
        System.out.println("Preço do produto: " + preco);
        return preco;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

}

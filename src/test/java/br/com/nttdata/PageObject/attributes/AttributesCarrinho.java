package br.com.nttdata.PageObject.attributes;

import org.openqa.selenium.By;

public class AttributesCarrinho {
    protected By productInCart = By.className("item-description");
    protected By totalCartValue = By.id("total-value");
}

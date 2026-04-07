package br.com.nttdata.PageObject.attributes;

import org.openqa.selenium.By;

public class AttributesHome {
    protected By consentButton = By.id("consent");

    protected By menuCelulares(String menu){
        return By.xpath("//a[@title='" + menu + "']");
    }
}

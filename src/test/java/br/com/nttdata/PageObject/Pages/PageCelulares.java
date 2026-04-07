package br.com.nttdata.PageObject.Pages;

import br.com.nttdata.PageObject.attributes.AttributesCelulares;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageCelulares extends AttributesCelulares {
    private WebDriver driver;

    public PageCelulares(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct)).click();
    }

}

package com.ktronix.steps;

import com.ktronix.pagesObjects.InicioPagesObjects;
import com.ktronix.pagesObjects.SearchPageObjects;
import com.ktronix.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static com.ktronix.drivers.SeleniumWebDriver.driver;

public class SeleccionCatalogoSteps {
    @Step
    public void SeleccionCatalogo() {

        ArrayList<Map<String, String>> dataExcel;

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx", "Buscar");


            esperarElementoVisible(SearchPageObjects.getBtnProducto(), Duration.ofSeconds(10));
            seleccionClick(SearchPageObjects.getBtnProducto());
            esperarElementoVisible(SearchPageObjects.getBtnAgregarCarrito(), Duration.ofSeconds(10));
            clickJavaScript(SearchPageObjects.getBtnAgregarCarrito());
            esperarElementoVisible(SearchPageObjects.getBtnCarrito(), Duration.ofSeconds(10));
            clickJavaScript(SearchPageObjects.getBtnCarrito());

            esperarElementoVisible(SearchPageObjects.getBtnFacturacion(), Duration.ofSeconds(10));
            clickJavaScript(SearchPageObjects.getBtnFacturacion());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void seleccionClick(By elemento) {
        driver.findElement(elemento).click();
    }
    public void escrituraTexto(By elemento, String texto){

        driver.findElement(elemento).sendKeys(texto);
    }
    public void esperarElementoVisible(By elemento, Duration tiempoEsperaSegundos){
        WebDriverWait wait = new WebDriverWait(driver,tiempoEsperaSegundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));

    }

    public void clickJavaScript(By elemento){
        WebElement element = driver.findElement(elemento);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
}




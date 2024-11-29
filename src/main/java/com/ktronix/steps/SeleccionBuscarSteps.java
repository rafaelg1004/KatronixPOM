package com.ktronix.steps;

import com.ktronix.pagesObjects.InicioPagesObjects;
import com.ktronix.pagesObjects.SearchPageObjects;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.ktronix.utils.DatosExcel;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static com.ktronix.drivers.SeleniumWebDriver.driver;
public class SeleccionBuscarSteps {

    @Step
    public void SeleccionBuscar(){
        seleccionClick(InicioPagesObjects.getBtnBusqueda());
        ArrayList<Map<String, String>> dataExcel;

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx","Buscar");

            escrituraTexto(InicioPagesObjects.getTxtBusqueda(),dataExcel.get(1).get("Nombre"));
            esperarElementoVisible(InicioPagesObjects.getBtnProducto(dataExcel.get(1).get("Nombre")), Duration.ofSeconds(10));
            seleccionClick(InicioPagesObjects.getBtnProducto(dataExcel.get(1).get("Nombre")));

        //    esperarElementoVisible(SearchPageObjects.getBtnProducto(), Duration.ofSeconds(10));
          //  seleccionClick(SearchPageObjects.getBtnProducto());


        }catch (IOException e){
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

package com.ktronix.steps;

import com.ktronix.pagesObjects.SearchPageObjects;
import com.ktronix.utils.DatosExcel;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ktronix.pagesObjects.FacturacionPagesObjects   ;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import static com.ktronix.drivers.SeleniumWebDriver.driver;

public class ValidacionSteps {
    @Step
    public void validacionBusqueda(){
        ArrayList<Map<String, String>> dataExcel;

        try {

            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx","Buscar");
            esperarElementoVisible(SearchPageObjects.getBtnFacturacion(), Duration.ofSeconds(10));
            WebElement tableElement = driver.findElement(SearchPageObjects.getLblCarrito(dataExcel.get(1).get("Nombre")));
            String textoTabla = tableElement.getText();
            Assert.assertEquals(dataExcel.get(0).get("validacion"),textoTabla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Step
    public void validacionFacturacion(){
        ArrayList<Map<String, String>> dataExcel;
        ArrayList<Map<String, String>> dataExcel2;
        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx","Facturacion");
            dataExcel2 = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx","Buscar");
            WebElement tableElement = driver.findElement(FacturacionPagesObjects.getLblFacturacion(dataExcel2.get(1).get("Nombre")));
            String textoTabla = tableElement.getText();
            Assert.assertEquals(dataExcel.get(0).get("validacion"),textoTabla);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void esperarElementoVisible(By elemento, Duration tiempoEsperaSegundos){
        WebDriverWait wait = new WebDriverWait(driver,tiempoEsperaSegundos);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));

    }
}

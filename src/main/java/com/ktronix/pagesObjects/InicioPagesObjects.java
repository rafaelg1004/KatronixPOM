package com.ktronix.pagesObjects;
import org.openqa.selenium.By;

public class InicioPagesObjects {

    private static By btnBusqueda = By.xpath("//input[@id='js-algolia-site-search-input']");
    private static By txtBusqueda = By.xpath("//input[@id='autocomplete-0-input']");
    public static By getBtnProducto (String txtProducto){
        return By.xpath("//a[@href='/search?text=" + txtProducto + "']");


    }

    public static By getBtnBusqueda() {
        return btnBusqueda;
    }

    public static By getTxtBusqueda() {
        return txtBusqueda;
    }

    private InicioPagesObjects(){

    };
}

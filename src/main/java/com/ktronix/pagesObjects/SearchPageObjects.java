package com.ktronix.pagesObjects;

import org.openqa.selenium.By;

public class SearchPageObjects {

    private static By btnProducto = By.xpath("(//div[@class='product__item__top js-algolia-product-click'])[1]");
    private static By btnAgregarCarrito = By.xpath("(//button[@id='addToCartButton'])[1]");
    private static By btnCarrito = By.xpath("(//a[@href='/cart'])[3]");
    public static By getLblCarrito(String textoValidacion){
        return By.xpath("//div[@class='col-xs-7 no-padding mycart__discount__product-totals' and contains(translate(., ' ABCDEFGHIJKLMNOPQRSTUVWXYZ', ' abcdefghijklmnopqrstuvwxyz'), '"+textoValidacion+"')]");
    }
    private static By btnFacturacion= By.xpath("//button[@id='js-go-to-pay']");

    public static By getBtnFacturacion() {
        return btnFacturacion;
    }

    public static By getBtnCarrito() {
        return btnCarrito;
    }

    public static By getBtnAgregarCarrito() {
        return btnAgregarCarrito;
    }

    public static By getBtnProducto() {
        return btnProducto;
    }

    public static By getLblSearch(String textoValidacion){
        return  By.xpath("//div[@class='ts-product-name' and text()='"+textoValidacion+"']");
    }
}

package com.ktronix.stepsDefinitions;

import com.ktronix.drivers.SeleniumWebDriver;
import com.ktronix.steps.SeleccionBuscarSteps;
import com.ktronix.steps.SeleccionCatalogoSteps;
import com.ktronix.steps.ValidacionSteps;
import io.cucumber.java.es.*;
import net.thucydides.core.annotations.Steps;
import com.ktronix.steps.FacturaccionSteps;
public class AgregarProductoStepDefinition {

    @Steps
    SeleccionBuscarSteps seleccionBuscarSteps=new SeleccionBuscarSteps();
    @Steps
    SeleccionCatalogoSteps seleccionCatalogoSteps=new SeleccionCatalogoSteps();
    @Steps
    FacturaccionSteps facturaccionSteps=new FacturaccionSteps();
    @Steps
    ValidacionSteps validacionSteps=new ValidacionSteps();

    @Dado("estoy en el menu de categoria de Producto de Ktronix")
    public void estoyEnElMenuDeCategoriaDeProductoDeKtronix() {
        SeleniumWebDriver.chromeDrive("https://www.ktronix.com/");

    }
    @Cuando("Aparece la ventana de la categoria")
    public void apareceLaVentanaDeLaCategoria() {

    seleccionBuscarSteps.SeleccionBuscar();
    }
    @Cuando("Selecciono un producto para agregar al carrito")
    public void seleccionoUnProductoParaAgregarAlCarrito() {
        seleccionCatalogoSteps.SeleccionCatalogo();
        validacionSteps.validacionBusqueda();

    }
    @Entonces("visualizare la ventana de facturacion")
    public void visualizareLaVentanaDeFacturacion() {
    facturaccionSteps.Facturar();
    validacionSteps.validacionFacturacion();
    }



}

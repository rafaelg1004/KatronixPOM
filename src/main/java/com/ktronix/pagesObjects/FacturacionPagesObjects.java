package com.ktronix.pagesObjects;

import org.openqa.selenium.By;

public class FacturacionPagesObjects {

 private static By txtCorreo = By.xpath("//input[@id='j_username']");
 private static By btnSiguiente = By.xpath("//button[@class='button-primary js-enabled-btn-continue js-btnAnimationSoftLogin']");
 private static By txtNombre =By.xpath("//input[@id='firstName']");
    private static By txtApellido =By.xpath("//input[@id='lastName']");
    private static By txtTelofono =By.xpath("//input[@id='phone']");
    private static  By btnTerminos =By.xpath("//label[@for='consent']");
    private static By btnSiguienteTusDatos =By.xpath("//button[@id='js-buttonSignIn']");
    private static  By btnTipoDocumento = By.xpath("(//div[@class='addressId']//div[@class='float-select js-float-select js-float-group float-small'])[1]");
    private static By btnDocumento = By.xpath("//div[@class='float-select--list js-float-list open']//li[@data-value='CC']");
    private static By txtDocumento = By.xpath("//input[@id='address.idNumber']");
    private static By btnDepartamento = By.xpath("(//div[@class='float-select js-float-select js-float-group'])[1]");
    public static By getBtnNombreDepartamento (String txtDepartamento){
        return By.xpath("(//li[text()='"+txtDepartamento+"'])[1]");
    }

    private static By btnCiudad= By.xpath("(//div[@class='float-select js-float-select js-float-group active-click'])[2]");
    public static By getBtnNombreCiudad (String txtCiudad){
        return By.xpath("(//li[text()='"+txtCiudad+"'])[1]");

    }
    private static By txtDireccion = By.xpath("//input[@id='addressLine1']");
    private static By txtBarrio = By.xpath("//input[@id='addressDistrict']");
    private static By btnSiguienteDireccion = By.xpath("//button[@id='continueAddress']");
    private static By btnSisguenteMetodoEnvio= By.xpath("//button[@id='deliveryMethodSubmit']");
    private static By btnMetodoDePago =By.xpath("//li[@data-link='tab3']");
    private static By btnBilletera = By.xpath("(//div[@class='form-check custom-radio bankOption'])[2]");
    private static By btnTipoidentificacion= By.xpath("(//div[@class='float-select js-float-select js-float-group'])[1]");
    private static By btnCcIdentificacion = By.xpath("(//li[@data-value='CC'])[4]");
    private static By txtIdentificacion = By.xpath("//input[@id='documentId']");
    private static By btnSiguienteFormaDePago = By.xpath("//button[@class='button-primary js-verify-id-v2 js-animationPaymentMethodBtn js-bindDigitalSubmit submitDigitalBtn js-changeDocumentIdDigitalPayments']");

    public static By getLblFacturacion(String textoValidacion){
        return  By.xpath("//div[@class='col-xs-7 no-padding mycart__discount__product-totals' and contains(translate(., ' ABCDEFGHIJKLMNOPQRSTUVWXYZ', ' abcdefghijklmnopqrstuvwxyz'), '"+textoValidacion+"')]");
    }
    public static By getBtnSiguienteFormaDePago() {
        return btnSiguienteFormaDePago;
    }

    public static By getTxtIdentificacion() {
        return txtIdentificacion;
    }


    public static By getBtnCcIdentificacion(){
        return btnCcIdentificacion;
    }

    public static By getBtnTipoIdentificacion(){
        return btnTipoidentificacion;
    }

    public static By getBtnBilletera(){
        return btnBilletera;
    }

    public static By getBtnMetodoDePago(){
        return btnMetodoDePago;
    }

    public static By getBtnSisguenteMetodoEnvio(){
        return btnSisguenteMetodoEnvio;
    }

    public static By getTxtDireccion() {
        return txtDireccion;
    }
    public static By getTxtBarrio() {
        return txtBarrio;
    }

    public static By getBtnSiguienteDireccion() {
        return btnSiguienteDireccion;
    }
    public static By getBtnCiudad() {
        return btnCiudad;
    }
    public static By getBtnDepartamento() {
        return btnDepartamento;
    }

    public static By getTxtDocumento() {
        return txtDocumento;
    }

    public static By getBtnDocumento() {
        return btnDocumento;
    }

    public static By getBtnTipoDocumento(){
        return btnTipoDocumento;
    }

    public static By getBtnSiguienteTusDatos() {
        return btnSiguienteTusDatos;
    }

    public static By getBtnTerminos() {
        return btnTerminos;
    }

    public static By getTxtTelofono() {
        return txtTelofono;
    }

    public static By getTxtApellido() {
        return txtApellido;
    }

    public static By getTxtNombre() {
        return txtNombre;
    }

    public static By getBtnSiguiente() {
	 return btnSiguiente;
 }

 public static By getTxtCorreo() {
	 return txtCorreo;
 }
}

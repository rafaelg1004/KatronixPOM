package com.ktronix.steps;

import com.ktronix.pagesObjects.FacturacionPagesObjects;
import com.ktronix.pagesObjects.InicioPagesObjects;
import com.ktronix.utils.DatosExcel;
import com.ktronix.utils.Scroll;
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
public class FacturaccionSteps
{
    @Step
    public void Facturar(){
       autoScrollDuringTests();
        ArrayList<Map<String, String>> dataExcel;

        try {
            dataExcel = DatosExcel.leerDatosDeHojaDeExcel("parametros/Datos.xlsx","Facturacion");
            esperarElementoVisible(FacturacionPagesObjects.getTxtCorreo(), Duration.ofSeconds(10));
        escrituraTexto(FacturacionPagesObjects.getTxtCorreo(),dataExcel.get(0).get("correo"));
        seleccionClick(FacturacionPagesObjects.getBtnSiguiente());
        esperarElementoVisible(FacturacionPagesObjects.getTxtNombre(), Duration.ofSeconds(10));
        escrituraTexto(FacturacionPagesObjects.getTxtNombre(),dataExcel.get(0).get("nombre"));
        escrituraTexto(FacturacionPagesObjects.getTxtApellido(),dataExcel.get(0).get("apellido"));
        escrituraTexto(FacturacionPagesObjects.getTxtTelofono(),dataExcel.get(0).get("telefono"));
        seleccionClick(FacturacionPagesObjects.getBtnTerminos());
        clickJavaScript(FacturacionPagesObjects.getBtnSiguienteTusDatos());
esperarElementoVisible(FacturacionPagesObjects.getBtnTipoDocumento(), Duration.ofSeconds(10));
        clickJavaScript(FacturacionPagesObjects.getBtnTipoDocumento());
            esperarElementoVisible(FacturacionPagesObjects.getTxtDocumento(), Duration.ofSeconds(10));
        clickJavaScript(FacturacionPagesObjects.getBtnDocumento());

        escrituraTexto(FacturacionPagesObjects.getTxtDocumento(),dataExcel.get(0).get("documento"));

      clickJavaScript(FacturacionPagesObjects.getBtnDepartamento());

       esperarElementoVisible(FacturacionPagesObjects.getBtnNombreDepartamento(dataExcel.get(0).get("departamento")), Duration.ofSeconds(10));
       esperarElementoInteractuable(FacturacionPagesObjects.getBtnNombreDepartamento(dataExcel.get(0).get("departamento")), Duration.ofSeconds(10));
       String departamento = dataExcel.get(0).get("departamento").trim();
       clickJavaScript(FacturacionPagesObjects.getBtnNombreDepartamento(departamento));
       esperarElementoVisible(FacturacionPagesObjects.getBtnCiudad(), Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnCiudad());
      String ciudad =dataExcel.get(0).get("ciudad").trim();
       esperarElementoVisible(FacturacionPagesObjects.getBtnNombreCiudad(ciudad), Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnNombreCiudad(ciudad));
       escrituraTexto(FacturacionPagesObjects.getTxtDireccion(),dataExcel.get(0).get("direccion"));
       escrituraTexto(FacturacionPagesObjects.getTxtBarrio(),dataExcel.get(0).get("barrio"));
       clickJavaScript(FacturacionPagesObjects.getBtnSiguienteDireccion());
       esperarElementoVisible(FacturacionPagesObjects.getBtnSisguenteMetodoEnvio(),Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnSisguenteMetodoEnvio());
       esperarElementoVisible(FacturacionPagesObjects.getBtnMetodoDePago(),Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnMetodoDePago());
       esperarElementoVisible(FacturacionPagesObjects.getBtnBilletera(),Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnBilletera());
       clickJavaScript(FacturacionPagesObjects.getBtnTipoIdentificacion());
       esperarElementoVisible(FacturacionPagesObjects.getBtnCcIdentificacion(),Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnCcIdentificacion());
       escrituraTexto(FacturacionPagesObjects.getTxtIdentificacion(),dataExcel.get(0).get("identificacion"));
       esperarElementoVisible(FacturacionPagesObjects.getBtnSiguienteFormaDePago(),Duration.ofSeconds(10));
       clickJavaScript(FacturacionPagesObjects.getBtnSiguienteFormaDePago());



        }catch (IOException e){
            e.printStackTrace();
        }finally {
            // Detén el scroll automático al finalizar las pruebas
            stopAutoScroll();
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
    public void esperarElementoInteractuable(By elemento, Duration tiempoEsperaSegundos){
        WebDriverWait wait = new WebDriverWait(driver,tiempoEsperaSegundos);
        wait.until(ExpectedConditions.elementToBeClickable(elemento));

    }

    public void clickJavaScript(By elemento){
        WebElement element = driver.findElement(elemento);
        JavascriptExecutor jsExecutor = (JavascriptExecutor)  driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    private Thread scrollThread;

    public void autoScrollDuringTests() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Configura un hilo separado para hacer scroll continuamente
        scrollThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // Scroll hacia abajo en pasos de 100px
                    jsExecutor.executeScript("window.scrollBy(0, 100);");
                    Thread.sleep(500); // Espera 500ms entre desplazamientos
                }
            } catch (InterruptedException e) {
                System.out.println("Scroll automático detenido.");
            }
        });
        scrollThread.start();
    }

    public void stopAutoScroll() {
        if (scrollThread != null) {
            scrollThread.interrupt();
        }
    }

}

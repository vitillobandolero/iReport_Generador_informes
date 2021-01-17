/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_tarea6;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.help.UnsupportedOperationException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.fxutils.viewer.JasperViewerFX;

/**
 * Esta clase genera los alumnos que despues usaremos para generar los informes
 *
 * @author Víctor Gallego Cabezas
 * @version 2.0
 *
 */
public class FXMLDocumentController implements Initializable {

    /**
     * ArrayList para almacenar los alumnos.
     */
    ArrayList<Alumno> alumnos = new ArrayList<>();

    /**
     * Este método se ejecuta al iniciar la aplicación, en él creamos los
     * alumnos y los almacenamos en un ArrayList
     *
     * @param url Establece que archivo fxml tiene que ejecutar. Es generado
     * auntomaticamente por el SceneBuilder
     * @param rb Sirve para pasarle los recursos
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        alumnos.add(new Alumno("53466422R", "DI", "Madrid", 10));
        alumnos.add(new Alumno("53589652A", "DI", "Cordoba", 9.5));
        alumnos.add(new Alumno("54566422Q", "DI", "Granada", 5));
        alumnos.add(new Alumno("53454422W", "DI", "Granada", 3.7));
        alumnos.add(new Alumno("55345422Z", "DI", "Barcelona", 0.2));

        alumnos.add(new Alumno("53323322T", "DI", "Caceres", 8.8));
        alumnos.add(new Alumno("54346422P", "DI", "Zaragoza", 9.9));
        alumnos.add(new Alumno("53488882E", "DI", "Toledo", 10));
        alumnos.add(new Alumno("56456722M", "DI", "Madrid", 8.7));
        alumnos.add(new Alumno("85698321P", "DI", "Madrid", 9.1));

        alumnos.add(new Alumno("58963214T", "AD", "Madrid", 10));
        alumnos.add(new Alumno("54325522I", "AD", "Madrid", 10));
        alumnos.add(new Alumno("67855322R", "AD", "Madrid", 10));
        alumnos.add(new Alumno("53467885U", "AD", "Madrid", 10));
        alumnos.add(new Alumno("53878822R", "AD", "Madrid", 10));

        alumnos.add(new Alumno("553434324Y", "PMDM", "Madrid", 10));
        alumnos.add(new Alumno("564545543T", "PMDM", "Madrid", 10));
        alumnos.add(new Alumno("589754522K", "PMDM", "Madrid", 10));
        alumnos.add(new Alumno("654556622J", "PMDM", "Madrid", 10));
        alumnos.add(new Alumno("567657422R", "PMDM", "Madrid", 10));

        alumnos.add(new Alumno("53654422T", "PMDM", "Madrid", 10));
        alumnos.add(new Alumno("52346422E", "PSP", "Madrid", 10));
        alumnos.add(new Alumno("53467852Y", "PSP", "Madrid", 10));
        alumnos.add(new Alumno("54676422P", "PSP", "Madrid", 10));

    }

    /**
     * Este método nos genera un listado de todos los alumnos matriculados en DI
     *
     * @param event Le pasamos el nombre del botón que se ha pulsado
     */
    @FXML
    private void listado(ActionEvent event) {
        //Definimos de donde cogeremos los datos
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(alumnos);
        //Cargamos el boton que dispara el evento y crea un nodo con él.
        Node source = (Node) event.getSource();
        //Cargamos la escena a la que pertenece el boton y obtenemos la ventana
        Stage stage = (Stage) source.getScene().getWindow();
        /*Creo el visor de informes y le pasamos por parametros: la escena, un titulo para el informe
        la ruta de acceso al informe correspondiente, un objeto HashMap que necesita pero no ultilizo,
        y el objeto donde tenemos almacenados los datos*/
        JasperViewerFX viewerfx = new JasperViewerFX(stage, "Listado de alumnos", "/informes/Informe.jasper",
                new HashMap(), beanColDataSource);
        //mostramos el informe
        viewerfx.show();
    }

    /**
     * Este método nos genera un informe por sectores de la cantidad de alumnos
     * que hay matriculados en cada módulo
     *
     * @param event Le pasamos el nombre del botón que se ha pulsado
     */
    @FXML
    private void sectores(ActionEvent event) throws JRException {
        //Definimos de donde cogeremos los datos
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(alumnos);
        //Cargamos el boton que dispara el evento y crea un nodo con él.
        Node source = (Node) event.getSource();
        //Cargamos la escena a la que pertenece el boton y obtenemos la ventana
        Stage stage = (Stage) source.getScene().getWindow();
        /*Creo el visor de informes y le pasamos por parametros: la escena, un titulo para el informe
        la ruta de acceso al informe correspondiente, un objeto HashMap que necesita pero no ultilizo,
        y el objeto donde tenemos almacenados los datos*/
        JasperViewerFX viewerfx = new JasperViewerFX(stage, "Grafico de barras", "/informes/Sectores.jasper",
                new HashMap(), beanColDataSource);
        //mostramos el informe
        viewerfx.show();
    }

    /**
     * Este método nos genera un informe de barras de la cantidad de alumnos que
     * hay matriculados en cada módulo
     *
     * @param event Le pasamos el nombre del botón que se ha pulsado
     */
    @FXML
    private void barras(ActionEvent event) {
        //Definimos de donde cogeremos los datos
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(alumnos);
        //Cargamos el boton que dispara el evento y crea un nodo con él.
        Node source = (Node) event.getSource();
        //Cargamos la escena a la que pertenece el boton y obtenemos la ventana
        Stage stage = (Stage) source.getScene().getWindow();
        /*Creo el visor de informes y le pasamos por parametros: la escena, un titulo para el informe
        la ruta de acceso al informe correspondiente, un objeto HashMap que necesita pero no ultilizo,
        y el objeto donde tenemos almacenados los datos*/
        JasperViewerFX viewerfx = new JasperViewerFX(stage, "Grafico de barras", "/informes/barras.jasper",
                new HashMap(), beanColDataSource);
        //mostramos el informe
        viewerfx.show();
    }

    /**
     * Este método cierra la aplicación
     * @param event Le pasamos el nombre del botón que se ha pulsado
     */
    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Con este metodo abrimos la ayuda en línea
     * @param event Le pasamos el nombre del botón que se ha pulsado
     */
    @FXML
    private void abrirAyuda(ActionEvent event) {
        try {

            /*Lo primero que hay que hacer en nuestro código es leer el fichero
            .hs (help_set.hs). Las tres líneas siguientes hacen eso. */
            File fichero = new File("src\\documentacion\\help_set.hs");

            URL hsURL = fichero.toURI().toURL();

            /*La clase HelpSet contiene todos los datos relativos a nuestra 
            ayuda, leídos de los ficheros de configuración que se crearon 
            anteriormente*/
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);

            /* HelpBroker no es más que una clase de ayuda que nos ofrece JavaHelp
          para facilitarnos un uso por defecto de la ayuda desde código.
          Helpbroker nos proporciona una interfaz para manejar todas las
          ventanas de ayuda(tabla de contenidos, visor de ayuda, panel de 
          búsqueda, índice), y métodos adecuados para que podamos añadir dichas
          ventanas a nuestros botones de ayuda o a la pulsación de la tecla
          de ayuda F1  */
            HelpBroker hb = helpset.createHelpBroker();

            /* Mostramos el sistema de ayuda */
            hb.setDisplayed(true);

        } catch (MalformedURLException | HelpSetException | UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }

    }

}

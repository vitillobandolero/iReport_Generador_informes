/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_tarea5;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.fxutils.viewer.JasperViewerFX;

/**
 *
 * @author vitil
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    ArrayList<Alumno> alumnos = new ArrayList<>();

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

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}

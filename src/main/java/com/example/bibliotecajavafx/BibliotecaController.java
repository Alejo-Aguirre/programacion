package com.example.bibliotecajavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.bibliotecajavafx.ControllerViewAutor;
import co.uniquindio.model.biblioteca.*;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class BibliotecaController {

    private ObservableList<Autor> listaAutores = FXCollections.observableArrayList();

    private Archivos archivoNacionalidades;
    private static String ARCHIVO_NACIONALIDADES  = "nacionalidades.txt";
    private Archivos archivoAutores;
    private static String ARCHIVO_AUTORES  = "autores.txt";

    @FXML
    private MenuItem btnAcercaDe;
    @FXML
    private MenuItem btnAgregarAutor;
    @FXML
    private MenuItem btnSalir;
    @FXML
    private MenuItem btnGuardar;
    @FXML
    private MenuItem btnCargarDatos;
    @FXML
    private MenuItem btnAgregarLibro;
    @FXML
    private TableView<Autor> tblAutores;
    @FXML
    private TableColumn colNombreAutor;
    @FXML
    private TableColumn colNacionalidadAutor;
    @FXML
    private TableColumn colFechaNacimientoAutor;


    @FXML
    private void cargarDatos(ActionEvent event) {
        ArrayList<Autor> temp = this.archivoAutores.leerAutores();

        for(Autor a:temp)
            listaAutores.add(a);
        this.tblAutores.setItems(listaAutores);
    }

    public void guardar(ActionEvent actionEvent) {
    }

    public void salir(ActionEvent actionEvent) {
    }


    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        this.tblAutores.setItems(listaAutores);
        this.colNombreAutor.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colNacionalidadAutor.setCellValueFactory(new PropertyValueFactory("nacionalidad"));
        this.colFechaNacimientoAutor.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));

/*
        tblAutores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            Autor autorSeleccionado = newSelection;
        });
        */

        //Manejo de archivos
        this.archivoNacionalidades = new Archivos(ARCHIVO_NACIONALIDADES);
        if(!this.archivoNacionalidades.existe()) {
            this.archivoNacionalidades.crearArchivo();
            System.out.println("archivo " + ARCHIVO_NACIONALIDADES + " creado");
        } else {
            System.out.println("archivo " + ARCHIVO_NACIONALIDADES + " existe");
        }

        this.archivoAutores = new Archivos(ARCHIVO_AUTORES);
        if(!this.archivoAutores.existe()) {
            this.archivoAutores.crearArchivo();
            System.out.println("archivo " +  ARCHIVO_AUTORES + " creado");
        } else {
            System.out.println("archivo " + ARCHIVO_AUTORES + " existe");
        }

    }


    public void agregarAutor(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewAutor.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Agregar Autor");
            stage.setScene(new Scene(root1));


            ControllerViewAutor controlador = fxmlLoader.getController();
            controlador.inicializarAtributos(listaAutores);

            stage.showAndWait();

            Autor autorDevuelto = controlador.getAutor();
            if(autorDevuelto != null) {
                this.listaAutores.add(autorDevuelto);
                this.tblAutores.refresh();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void agregarLibro(ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewLibro.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Agregar Libro");
            stage.setScene(new Scene(root1));

            /*
            LibroAgregarController controlador = fxmlLoader.getController();
            controlador.inicializarAtributos(listaAutores);



			Autor autorDevuelto = controlador.getAutor();
			if(autorDevuelto != null) {
				this.listaAutores.add(autorDevuelto);
				this.tblAutores.refresh();
			}
			*/
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void mostrarAcercaDe(ActionEvent actionEvent) {
    }
}
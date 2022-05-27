package com.example.bibliotecajavafx;

import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import co.uniquindio.model.biblioteca.*;


public class ControllerViewAutor implements Initializable{
    Biblioteca biblioteca;
    private ObservableList<String> paises;
    private static String ARCHIVO_NACIONALIDADES  = "nacionalidades.txt";

    @FXML
    private TextField txtNombreAutor;
    @FXML
    private ComboBox<String> txtNacionalidadAutor;
    @FXML
    private DatePicker txtFechaNacimientoAutor;
    @FXML
    private Button btnGuardarAutor;

    private ObservableList<Autor> listaAutores;
    private Autor autor;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
    }


    public void inicializarAtributos(ObservableList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
        //Llenado de ComboBox de Paises

        this.paises =  FXCollections.observableArrayList();
        Archivos archivoNacionalidades = new Archivos(ARCHIVO_NACIONALIDADES);
        this.paises.addAll(archivoNacionalidades.obtenerDatos());
        this.txtNacionalidadAutor.setItems(paises);

        System.out.println("llenado de ComboBox Nacionalidades");
    }

    @FXML
    public void guardarAutor(ActionEvent actionEvent) {
        String nombre = this.txtNombreAutor.getText();
        String nacionalidad = this.txtNacionalidadAutor.getValue();
        LocalDate temp = this.txtFechaNacimientoAutor.getValue();
        String fechaNacimiento = temp.toString();

		/*
		System.out.println("los datos son: ");
		System.out.println("nombre: " + nombreAutor);
		System.out.println("nacionalidad: " + nacionalidadAutor);
		System.out.println("fecha Nacimiento: "+ fechaNacimientoAutor);
		*/

        Autor nuevoAutor = new Autor(nombre, nacionalidad, LocalDate.parse(fechaNacimiento));
        this.autor = nuevoAutor;
        System.out.println("Autor Creado "+this.autor.toString());
        //listaAutores.add(nuevoAutor);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Informacion");
        alert.setContentText("Se ha aÃ±adido correctamente");
        alert.showAndWait();

        //Cerrar ventana
        Stage stage = (Stage)this.btnGuardarAutor.getScene().getWindow();
        stage.close();



    }
    public Autor getAutor() {
        return this.autor;
    }




/*
    public ObservableList<Autor> getListaAutores() {

        listaAutores.addAll(biblioteca.obtenerAutores());
        return listaAutores;
    }
*/
}


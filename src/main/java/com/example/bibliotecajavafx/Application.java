package com.example.bibliotecajavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

       FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ViewBiblioteca.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("biblioteca");
        stage.setScene(scene);
       stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
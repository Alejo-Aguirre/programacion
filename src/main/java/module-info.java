module com.example.bibliotecajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bibliotecajavafx to javafx.fxml;
    exports com.example.bibliotecajavafx;
}
module org.example.practicaparejasbd {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.practicaparejasbd to javafx.fxml;
    exports org.example.practicaparejasbd;
}
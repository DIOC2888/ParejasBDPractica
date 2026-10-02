module org.example.practicaparejasbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.practicaparejasbd to javafx.fxml;
    exports org.example.practicaparejasbd;
}
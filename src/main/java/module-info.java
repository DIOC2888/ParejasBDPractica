module org.example.practicaparejasbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    exports org.example.practicaparejasbd;
    opens org.example.practicaparejasbd.controller to javafx.fxml;
    opens org.example.practicaparejasbd.model to javafx.fxml;
    exports org.example.practicaparejasbd.connection;
    exports org.example.practicaparejasbd.controller;
    exports org.example.practicaparejasbd.model;

}
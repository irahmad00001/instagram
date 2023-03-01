module com.example.instagram {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javafx.media;

    opens com.example.instagram to javafx.fxml;
    exports com.example.instagram;
}
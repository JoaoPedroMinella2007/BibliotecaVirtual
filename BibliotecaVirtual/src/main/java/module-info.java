module principal.bibliotecavirtual {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // <- ESSA LINHA É ESSENCIAL PRA FUNCIONAR
    requires java.base;

    opens Controller to javafx.fxml;
    exports Controller;
    exports dao;
    exports principal;
}
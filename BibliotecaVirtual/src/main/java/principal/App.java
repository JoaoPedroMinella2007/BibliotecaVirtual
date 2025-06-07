package principal;

import Controller.TelaEntrarController;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import static javafx.application.Application.launch;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        URL url = new File("src/main/java/View/TelaEntrar.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage telaEntrar = new Stage();
        TelaEntrarController tec = loader.getController();
        tec.setStage(telaEntrar);
        telaEntrar.setOnShown(event -> {
        tec.abrirJanela();
        });
        
        Scene scene = new Scene (root);
        
        /*Image icone = new Image(getClass().getResourceAsStream("/icons/Bh.png"));
        telaEntrar.getIcons().add(icone);*/
        
        telaEntrar.setScene(scene);
        telaEntrar.setTitle("BV - Biblioteca Virtual | Entrar no sistema");
        // Tamanho fixo
        telaEntrar.setResizable(false); // Impede redimensionamento
        telaEntrar.setWidth(1250);       // Largura fixa
        telaEntrar.setHeight(800);      // Altura fixa
        telaEntrar.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaEntrarController {

    @FXML
    private Button btnCadastrarUsuario;

    @FXML
    private Button btnEntrar;
    
    private Stage stageEntrar;

    @FXML
    void OnActionCadastrarUsuario(ActionEvent event) throws IOException {
        
        URL url = new File("src/main/java/View/TelaCadastroUsuario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage telaCadastroUsuario = new Stage();
        TelaCadastroUsuarioController tcuc = loader.getController();
        tcuc.setStage(telaCadastroUsuario);
        telaCadastroUsuario.setOnShown(evento -> {
        tcuc.abrirJanela();
        });
        
        Scene scene = new Scene (root);
        
        /*Image icone = new Image(getClass().getResourceAsStream("/icons/Bh.png"));
        telaEntrar.getIcons().add(icone);*/
        
        //impede o redimensionamento e maximização da tela      
        telaCadastroUsuario.setResizable(false);
        telaCadastroUsuario.setMaximized(false);
        
        telaCadastroUsuario.setScene(scene);
        telaCadastroUsuario.setTitle("BV - Biblioteca Virtual | Cadastro de usuário");
        telaCadastroUsuario.setMaximized(false);
        telaCadastroUsuario.show();

    }

    @FXML
    void OnActionEntrar(ActionEvent event) throws IOException {
        
        URL url = new File("src/main/java/View/TelaLogin.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Stage telaLogin = new Stage();
        TelaLoginController tlc = loader.getController();
        tlc.setStage(telaLogin);
        telaLogin.setOnShown(evento -> {
        tlc.abrirJanela();
        });
        
        Scene scene = new Scene (root);
        
        /*Image icone = new Image(getClass().getResourceAsStream("/icons/Bh.png"));
        telaEntrar.getIcons().add(icone);*/
        
        //impede o redimensionamento e maximização da tela      
        telaLogin.setResizable(false);
        telaLogin.setMaximized(false);
        
        telaLogin.setScene(scene);
        telaLogin.setTitle("BV - Biblioteca Virtual | Login");
        telaLogin.setMaximized(false);
        telaLogin.show();

    }

    public void setStage(Stage telaEntrar) {
        this.stageEntrar = telaEntrar;
    }

    public void abrirJanela() {
    }

}

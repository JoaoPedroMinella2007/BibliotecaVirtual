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

public class TelaCadastroController {

    @FXML
    private Button btnCadastrarClientes;

    @FXML
    private Button btnCadastrarLivros;

    @FXML
    void OnActionCadastrarClientes(ActionEvent event) throws IOException {
        
            //Abre a janela a tela de cadastro de clientes
            URL url = new File("src/main/java/View/TelaCadastroCliente.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage telaCadastroCliente = new Stage();
            
            TelaCadastroClienteController tccc = loader.getController();
            tccc.setStage(telaCadastroCliente);
             
            telaCadastroCliente.setOnShown(eventInicial -> {
            tccc.abrirJanela();
            });

            Scene scene = new Scene (root);

            /*
            Adiciona a logo no ícone da tela
            
            Image icone = new Image(getClass().getResourceAsStream("/icons/Bh.png"));
            telaEntrar.getIcons().add(icone);
            */

           //impede o redimensionamento e maximização da tela      
            telaCadastroCliente.setResizable(false);
            telaCadastroCliente.setMaximized(false);

            telaCadastroCliente.setScene(scene);
            telaCadastroCliente.setTitle("BV - Biblioteca Virtual | Cadastro de cliente");
            telaCadastroCliente.setMaximized(false);
            telaCadastroCliente.show();

    }

    @FXML
    void OnActionCadastrarLivros(ActionEvent event) throws IOException {
        
        //Abre a janela a tela de cadastro de clientes
            URL url = new File("src/main/java/View/TelaCadastroLivros.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage telaCadastroLivros = new Stage();
            
            TelaCadastroLivroController tclc = loader.getController();
            tclc.setStage(telaCadastroLivros);
             
            telaCadastroLivros.setOnShown(eventInicial -> {
            tclc.abrirJanela();
            });

            Scene scene = new Scene (root);

            /*
            Adiciona a logo no ícone da tela
            
            Image icone = new Image(getClass().getResourceAsStream("/icons/Bh.png"));
            telaEntrar.getIcons().add(icone);
            */

           //impede o redimensionamento e maximização da tela      
            telaCadastroLivros.setResizable(false);
            telaCadastroLivros.setMaximized(false);

            telaCadastroLivros.setScene(scene);
            telaCadastroLivros.setTitle("BV - Biblioteca Virtual | Cadastro de livros");
            telaCadastroLivros.show();

    }

}

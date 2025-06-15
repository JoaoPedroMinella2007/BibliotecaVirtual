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
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TelaConsultasController {

    @FXML
    private Button btnConsultarClientes;

    @FXML
    private Button btnConsultarLivros;

    @FXML
    void OnActionConsultarClientes(ActionEvent event) throws IOException {
        
         //Abre a janela a tela de cadastro de clientes
            URL url = new File("src/main/java/View/TelaConsultaClientes.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage telaConsultaClientes = new Stage();
            
            TelaConsultaClientesController tccc = loader.getController();
            tccc.setStage(telaConsultaClientes);
             
            telaConsultaClientes.setOnShown(eventInicial -> {
            tccc.abrirJanela();
            });

            Scene scene = new Scene (root);

            
            //Adiciona a logo no ícone da tela         
            Image icone = new Image(getClass().getResourceAsStream("/images/IconeBV.png"));
            telaConsultaClientes.getIcons().add(icone);
            

           //impede o redimensionamento e maximização da tela      
            telaConsultaClientes.setResizable(false);
            telaConsultaClientes.setMaximized(false);

            telaConsultaClientes.setScene(scene);
            telaConsultaClientes.setTitle("BV - Biblioteca Virtual | Cadastro de cliente");
            telaConsultaClientes.setMaximized(false);
            telaConsultaClientes.show();

    }

    @FXML
    void OnActionConsultarLivros(ActionEvent event) {

    }

}

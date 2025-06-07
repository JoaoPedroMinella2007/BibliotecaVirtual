package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.AlertUtil;

public class TelaLoginController {

    @FXML
    private Button btnSignIn;

    @FXML
    private Hyperlink hyEsqueciMinhaSenha;

    @FXML
    private PasswordField txtfdSenha;

    @FXML
    private TextField txtfdUsuario;
    
    private final UsuarioDAO usuarioDao = new UsuarioDAO();
    
    private Stage stageLogin;

    @FXML
    void OnActionEsqueciMinhaSenha(ActionEvent event) {      
        System.out.println("Controller.TelaLoginController.OnActionEsqueciMinhaSenha()");
    }

    @FXML
    void OnActionSignIn(ActionEvent event) throws IOException {
        
        String login = txtfdUsuario.getText().trim();
        String password = txtfdSenha.getText().trim();
            
        if(login.isEmpty() || password.isEmpty()){
           AlertUtil.mostrarErro("Erro","Campos obrigatórios não preenchidos","Por favor, preencha todos os campos obrigatórios");
           return;
        }
         
        try {
            Usuario usuario = processarLogin(login, password);

            if (usuario != null) {
                abrirTelaInicial(usuario);
            } else {
                AlertUtil.mostrarErro("Erro", "Erro ao efetuar o login", "Senha ou email incorreto. Verifique e adicione corretamente!");
            }

        } catch (IOException e) {
            Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, e);
            AlertUtil.mostrarErro("Erro", "Erro inesperado", "Ocorreu um erro ao tentar realizar o login.");
        }

    }

    void abrirJanela() {
        System.out.println("Janela exibida");
    }

    private void abrirTelaInicial(Usuario usuario) throws IOException {
        
            //Abre a janela a tela inicial
            URL url = new File("src/main/java/View/TelaInicial.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage telaInicial = new Stage();
            
            TelaInicialController tic = loader.getController();
            tic.setStage(telaInicial);
            
            // Aqui passa o usuário logado
            tic.setUsuarioLogado(usuario);  // essencial
            
            telaInicial.setOnShown(eventInicial -> {
            tic.abrirJanela();
            });

            Scene scene = new Scene (root);

            /*
            Adiciona a logo no ícone da tela
            
            Image icone = new Image(getClass().getResourceAsStream("/icons/Bh.png"));
            telaEntrar.getIcons().add(icone);
            */

            telaInicial.setScene(scene);
            telaInicial.setTitle("BV - Biblioteca Virtual | Home");
            
            // Tamanho fixo
            telaInicial.setResizable(false); // Impede redimensionamento
            telaInicial.setWidth(1250);       // Largura fixa
            telaInicial.setHeight(800);      // Altura fixa
            telaInicial.show();
            
        if (stageLogin != null) {
            stageLogin.close();        
        }
        
    }

    private Usuario processarLogin(String login, String password) {
        
        if (!usuarioDao.bancoOnline()) {
            System.out.println("Banco de dados desconectado!");
            return null;
        }

        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            return usuarioDao.autenticar(login, password);
        }

        return null;
        
        
    }    
     void setStage(Stage telaLogin) {
         this.stageLogin = telaLogin;
    }
    
}

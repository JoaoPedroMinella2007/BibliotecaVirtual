package Controller;

import Model.Usuario;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.AlertUtil;

public class TelaInicialController {

    @FXML
    private Label NomeUsuario;

    @FXML
    private Button btnAbrirTelaCadastro;

    @FXML
    private Button btnAbrirTelaConsultas;

    @FXML
    private Button btnAbrirTelaEmprestimo;

    @FXML
    private Button btnConfiguracoes;

    @FXML
    private Button btnEncerrarSistema1;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnSobre;

    @FXML
    private Label conteudoPrincipal;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Label perfilUsuario;
    
    private Stage stageInicial;
    
    private Usuario usuarioLogado;
    
    @FXML
    void OnActionBtnAbrirTelaCadastro(ActionEvent event) throws IOException {
        
        File file = new File("src/main/java/View/TelaCadastro.fxml");
        URL url = file.toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent cadastro = loader.load();
        mainPane.setCenter(cadastro);

    }

    @FXML
    void OnActionBtnAbrirTelaConsultas(ActionEvent event) {

    }

    @FXML
    void OnActionBtnAbrirTelaEmprestimo(ActionEvent event) {

    }


    @FXML
    void OnMouseClickedConfiguracoes(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedEncerrarSistema(MouseEvent event) {
        
        Optional<ButtonType> resultado = AlertUtil.mostrarConfirmacao("Confirmar", 
                "Encerrar sistema", usuarioLogado.getNome()+", tem certeza que deseja encerrar o sistema?");
        
        if(resultado.isPresent()){
            ButtonType botaoPressionado = resultado.get();
            if(botaoPressionado == ButtonType.OK){
                 System.exit(0);
            }
        }

    }
    
    @FXML
    void onActionBtnLogout(ActionEvent event) throws IOException {
        
        Optional<ButtonType> resultado = AlertUtil.mostrarConfirmacao("Confirmar", 
                "Logout", usuarioLogado.getNome()+", tem certeza que deseja efetuar o logout?");
        
        if(resultado.isPresent()){
            ButtonType botaoPressionado = resultado.get();
            if(botaoPressionado == ButtonType.OK){
                stageInicial.close();            }
        }        
    }

    @FXML
    void OnMouseClickedSobre(MouseEvent event) throws MalformedURLException, IOException {
        
        File file = new File("src/main/java/View/TelaSobre.fxml");
        URL url = file.toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent sobre = loader.load();
        mainPane.setCenter(sobre);

    }
        
    void setStage(Stage telaInicial) {
        this.stageInicial = telaInicial;
    }

    void abrirJanela() {
        if (usuarioLogado != null) {
        NomeUsuario.setText(usuarioLogado.getNome());
        perfilUsuario.setText(usuarioLogado.getPerfil());
        configurarAcesso();
    }
    }

    void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }
    
    private void configurarAcesso() {
        String perfil = usuarioLogado.getPerfil().trim();
        System.out.println("Perfil do usuário logado: [" + perfil + "]");

    if (perfil.equalsIgnoreCase("Administrador")) {
        System.out.println("Usuário admin, liberando tudo");
        btnAbrirTelaCadastro.setDisable(false);
        btnConfiguracoes.setDisable(false);
    } else {
        System.out.println("Usuário comum, bloqueando e ocultando");
        btnAbrirTelaCadastro.setDisable(true);
        btnConfiguracoes.setDisable(true);
    }
    }
}

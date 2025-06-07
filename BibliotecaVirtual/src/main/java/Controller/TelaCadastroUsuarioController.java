package Controller;

import Model.UsuarioDAO;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import util.AlertUtil;

public class TelaCadastroUsuarioController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private DatePicker dtDataNascimento;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbUser;

    @FXML
    private TextField txfdNome;

    @FXML
    private TextField txfdSobrenome;

    @FXML
    private PasswordField txtfdConfirmarSenha;

    @FXML
    private PasswordField txtfdSenha;

    @FXML
    private TextField txtfdUsuario;
    
    private Stage stage;
    
    private ToggleGroup grupoPerfil;
    
    @FXML
    void initialize(){
        
        grupoPerfil = new ToggleGroup();
      
        rbAdmin.setToggleGroup(grupoPerfil);
        rbUser.setToggleGroup(grupoPerfil);
        
    }

    @FXML
    void OnActionCadastrar(ActionEvent event) {
        
        String login = txtfdUsuario.getText();
        String password = txtfdSenha.getText();
        String confirmPassword = txtfdConfirmarSenha.getText();
        String nome = txfdNome.getText();
        String sobrenome = txfdSobrenome.getText();
        LocalDate dataNascimento = dtDataNascimento.getValue();

        RadioButton rbSelecionadoPerfil = (RadioButton) grupoPerfil.getSelectedToggle();
        String perfil = (rbSelecionadoPerfil != null) ? rbSelecionadoPerfil.getText() : null;

        // Validações antes do cadastro
        if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || perfil == null) {
            AlertUtil.mostrarErro("Erro", "Campos obrigatórios não preenchidos",
                    "Por favor, preencha todos os campos obrigatórios e selecione um perfil de acesso.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            AlertUtil.mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Inconsistência de dados",
                    "As senhas informadas não são idênticas.");
            return;
        }

        // Só tenta cadastrar se passou pelas validações
        boolean sucesso = UsuarioDAO.cadastrarUsuario(login, password, perfil, nome, sobrenome, dataNascimento);

        if (sucesso) {
            AlertUtil.mostrarInformacao("Cadastro realizado com sucesso", "Usuário cadastrado",
                    "O novo usuário foi cadastrado com êxito no sistema.");
            stage.close();
        } else {
            AlertUtil.mostrarErro("Erro", "Falha no cadastro", "Não foi possível cadastrar o usuário");
        }

        }

    void setStage(Stage telaCadastroUsuario) {
        this.stage = telaCadastroUsuario;
    }

    void abrirJanela() {
    }

}

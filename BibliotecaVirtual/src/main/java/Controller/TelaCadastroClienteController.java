package Controller;

import Model.ClientesDAO;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.AlertUtil;

public class TelaCadastroClienteController {

    @FXML
    private Button btnCadastrarCliente;

    @FXML
    private DatePicker dtDataCadastroCliente;

    @FXML
    private DatePicker dtDataNascimentoCliente;
    
     @FXML
    private TextField txfdEnderecoCliente;
   
    @FXML
    private TextField txfdTelefoneCliente;

    @FXML
    private TextField txtfdCPFCliente;

    @FXML
    private TextField txtfdEmailCliente;

    @FXML
    private TextField txtfdNomeCliente;

    @FXML
    private TextField txtfdSobrenomeCliente;
    
    private Stage stageCadastroCliente;

    @FXML
    void OnActionCadastrar(ActionEvent event) {
        
        String nomeCliente = txtfdNomeCliente.getText();
        String sobrenomeCliente = txtfdSobrenomeCliente.getText();
        String cpfCliente = txtfdCPFCliente.getText();
        String emailCliente = txtfdEmailCliente.getText();
        String telefoneCliente = txfdTelefoneCliente.getText();
        String enderecoCliente = txfdEnderecoCliente.getText();
        LocalDate dataNascimentoCliente = dtDataNascimentoCliente.getValue();
        LocalDate dataCadastroCliente = dtDataCadastroCliente.getValue();
        
        if(nomeCliente.isEmpty() || sobrenomeCliente.isEmpty() || cpfCliente.isEmpty() || emailCliente.isEmpty()
                || telefoneCliente.isEmpty() || enderecoCliente.isEmpty() || dataNascimentoCliente == null || dataCadastroCliente == null){
            AlertUtil.mostrarErro("Erro", "Campos obrigatórios não preenchidos",
                    "Por favor, preencha todos os campos obrigatórios.");
            return;
        }
        
        boolean sucesso = ClientesDAO.cadastrarCliente(nomeCliente, sobrenomeCliente, cpfCliente, emailCliente, enderecoCliente, telefoneCliente, dataNascimentoCliente, dataCadastroCliente);
        
        if(sucesso){
            AlertUtil.mostrarInformacao("Cadastro realizado com sucesso", "Cliente cadastrado",
                    "O cliente foi cadastrado com êxito no sistema.");
            stageCadastroCliente.close();
        } else {
            AlertUtil.mostrarErro("Erro", "Falha no cadastro", "Não foi possível cadastrar o cliente");
        }
        }

    void setStage(Stage telaCadastroCliente) {
        this.stageCadastroCliente = telaCadastroCliente;
    }

    void abrirJanela() {
        
    }

}

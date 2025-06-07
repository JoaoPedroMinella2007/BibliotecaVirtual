package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    }

    void setStage(Stage telaCadastroCliente) {
        this.stageCadastroCliente = telaCadastroCliente;
    }

    void abrirJanela() {
        
    }

}

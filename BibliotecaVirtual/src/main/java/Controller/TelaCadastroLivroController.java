package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroLivroController {

    @FXML
    private Button btnCadastrarLivro;

    @FXML
    private DatePicker dtAnoPublicacao;

    @FXML
    private DatePicker dtDataCadastro;

    @FXML
    private TextArea txtaDescricaoSinopse;

    @FXML
    private TextField txtfdAutor;

    @FXML
    private TextField txtfdCategoria;

    @FXML
    private TextField txtfdEditora;

    @FXML
    private TextField txtfdISBN;

    @FXML
    private TextField txtfdTituloLivro;
    
    private Stage stageCadastroLivro;

    @FXML
    void OnActionCadastrarLivro(ActionEvent event) {

    }

    void setStage(Stage telaCadastroLivros) {
        this.stageCadastroLivro = telaCadastroLivros;
        
    }

    void abrirJanela() {
    }

}

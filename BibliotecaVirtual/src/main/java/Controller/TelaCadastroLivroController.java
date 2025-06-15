package Controller;

import Model.LivroDAO;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.AlertUtil;

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
        
        String titulo = txtfdTituloLivro.getText();
        String autor = txtfdAutor.getText();
        String categoria = txtfdCategoria.getText();
        String editora = txtfdEditora.getText();
        String ISBN = txtfdISBN.getText();
        String descricaoSinopse = txtaDescricaoSinopse.getText();
        LocalDate anoPublicacao = dtAnoPublicacao.getValue();
        LocalDate dataCadastro = dtDataCadastro.getValue();
        
         if(titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty() || editora.isEmpty()
                || ISBN.isEmpty() || descricaoSinopse.isEmpty() || anoPublicacao == null || dataCadastro == null){
            AlertUtil.mostrarErro("Erro", "Campos obrigatórios não preenchidos",
                    "Por favor, preencha todos os campos obrigatórios.");
            return;
        }
         
        boolean sucesso = LivroDAO.cadastrarLivro(titulo, autor, editora, ISBN, categoria, descricaoSinopse, anoPublicacao, dataCadastro);
        
         if(sucesso){
            AlertUtil.mostrarInformacao("Cadastro realizado com sucesso", "Livro cadastrado",
                    "O Livro foi cadastrado com êxito no sistema.");
            stageCadastroLivro.close();
        } else {
            AlertUtil.mostrarErro("Erro", "Falha no cadastro", "Não foi possível cadastrar o livro!");
        }
  
    }

    void setStage(Stage telaCadastroLivros) {
        this.stageCadastroLivro = telaCadastroLivros;
        
    }

    void abrirJanela() {
    }

}

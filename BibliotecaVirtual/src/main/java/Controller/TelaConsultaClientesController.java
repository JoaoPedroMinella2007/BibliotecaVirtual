package Controller;

import Model.Clientes;
import Model.ClientesDAO;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaConsultaClientesController {

    @FXML
    private TableView<Clientes> tabelaClientes;
     
    @FXML
    private TableColumn<Clientes, java.time.LocalDate> TableColumnCadastro;

    @FXML
    private TableColumn<Clientes, String> TableColumnCpf;

    @FXML
    private TableColumn<Clientes, String> TableColumnEmail;

    @FXML
    private TableColumn<Clientes, String> TableColumnEndereco;

    @FXML
    private TableColumn<Clientes, Number> TableColumnId;

    @FXML
    private TableColumn<Clientes, java.time.LocalDate> TableColumnNascimento;

    @FXML
    private TableColumn<Clientes, String> TableColumnNome;

    @FXML
    private TableColumn<Clientes, String> TableColumnSobrenome;

    @FXML
    private TableColumn<Clientes, String> TableColumnTelefone;

    @FXML
    private TextField txtfdPesquisaFiltrada;
    
    private Stage stageConsultaClientes;
    
    @FXML
    public void initialize() {
        configurarColunasTabela();
        carregarClientesTabela();      
    }

    private void configurarColunasTabela() {
        
        //Configura as tabelas da coluna por meio dos propertys da classe -> clientes
        
        TableColumnId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        TableColumnNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        TableColumnSobrenome.setCellValueFactory(cellData -> cellData.getValue().sobrenomeProperty());
        TableColumnCpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        TableColumnEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        TableColumnEndereco.setCellValueFactory(cellData -> cellData.getValue().enderecoProperty());
        TableColumnTelefone.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
        TableColumnNascimento.setCellValueFactory(cellData -> cellData.getValue().dataNascimentoProperty());
        TableColumnCadastro.setCellValueFactory(cellData -> cellData.getValue().dataCadastroProperty());
        
    }

    private void carregarClientesTabela(){
        
        List<Clientes> listaClientes = ClientesDAO.listarTodos();
        ObservableList<Clientes> observableList = FXCollections.observableArrayList(listaClientes);
        tabelaClientes.setItems(observableList);
        
    }

    void setStage(Stage telaConsultaClientes) {
        this.stageConsultaClientes = telaConsultaClientes;
    }

    void abrirJanela() {
    }
    
    

}

package Model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Clientes {
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty nome =  new SimpleStringProperty();
    private final StringProperty sobrenome = new SimpleStringProperty();
    private final StringProperty cpf = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty endereco = new SimpleStringProperty();
    private final StringProperty telefone = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dataNascimento = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> dataCadastro = new SimpleObjectProperty<>();
    
    //Construtor sem parâmetros
    public Clientes() {
    }
   
    //Construtor com os parâmetros
    public Clientes(int id, String nome, String sobrenome, String cpf, String email, String endereco, String telefone, LocalDate dataNascimento, LocalDate dataCadastro){
        this.id.set(id);
        this.nome.set(nome);
        this.sobrenome.set(sobrenome);
        this.cpf.set(cpf);
        this.email.set(email);
        this.endereco.set(endereco);
        this.telefone.set(telefone);
        this.dataNascimento.set(dataNascimento);
        this.dataCadastro.set(dataCadastro);
    }
    
    //Construtor com os parâmetros, porém sem o id
    public Clientes(String nome, String sobrenome, String cpf, String email, String endereco, String telefone, LocalDate dataNascimento, LocalDate dataCadastro){
        this.nome.set(nome);
        this.sobrenome.set(sobrenome);
        this.cpf.set(cpf);
        this.email.set(email);
        this.endereco.set(endereco);
        this.telefone.set(telefone);
        this.dataNascimento.set(dataNascimento);
        this.dataCadastro.set(dataCadastro);
    }
    
    //getter & setter
    
     public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }
    
     public String getSobrenome() {
        return sobrenome.get();
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome.set(sobrenome);
    }

    public StringProperty sobrenomeProperty() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public StringProperty cpfProperty() {
        return cpf;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getEndereco() {
        return endereco.get();
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    public StringProperty enderecoProperty() {
        return endereco;
    }

    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento.get();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento.set(dataNascimento);
    }

    public ObjectProperty<LocalDate> dataNascimentoProperty() {
        return dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro.get();
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro.set(dataCadastro);
    }

    public ObjectProperty<LocalDate> dataCadastroProperty() {
        return dataCadastro;
    }
    
    
    
    
}

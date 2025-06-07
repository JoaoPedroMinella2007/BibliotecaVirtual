package Model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty login = new SimpleStringProperty();
    private final StringProperty senha = new SimpleStringProperty();
    private final StringProperty perfil = new SimpleStringProperty();
    private final StringProperty nome = new SimpleStringProperty();
    private final StringProperty sobrenome = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> dataNascimento = new SimpleObjectProperty<>();
     
    public Usuario() {
    }
    
    //método construtor com os parâmetros completos
    public Usuario(int id, String login, String senha, String perfil, String nome, String sobrenome, LocalDate dataNascimento) {
        this.id.set(id);
        this.login.set(login);
        this.senha.set(senha);
        this.perfil.set(perfil);
        this.nome.set(nome);
        this.sobrenome.set(sobrenome);
        this.dataNascimento.set(dataNascimento);
    }
    
    //método construtor sem id
    public Usuario(String login, String senha, String perfil, String nome, String sobrenome, LocalDate dataNascimento) {
        this.login.set(login);
        this.senha.set(senha);
        this.perfil.set(perfil);
        this.nome.set(nome);
        this.sobrenome.set(sobrenome);
        this.dataNascimento.set(dataNascimento);
    }
    
    //getters & setters

            public IntegerProperty idProperty() {
        return id;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public StringProperty loginProperty() {
        return login;
    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public StringProperty senhaProperty() {
        return senha;
    }

    public String getSenha() {
        return senha.get();
    }

    public void setSenha(String senha) {
        this.senha.set(senha);
    }

    public StringProperty perfilProperty() {
        return perfil;
    }

    public String getPerfil() {
        return perfil.get();
    }

    public void setPerfil(String perfil) {
        this.perfil.set(perfil);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty sobrenomeProperty() {
        return sobrenome;
    }

    public String getSobrenome() {
        return sobrenome.get();
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome.set(sobrenome);
    }

    public ObjectProperty<LocalDate> dataNascimentoProperty() {
        return dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento.get();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento.set(dataNascimento);
    }
    
}

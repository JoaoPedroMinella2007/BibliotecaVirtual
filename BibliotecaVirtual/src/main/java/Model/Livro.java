package Model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Livro {
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty titulo =  new SimpleStringProperty();
    private final StringProperty autor = new SimpleStringProperty();
    private final StringProperty editora = new SimpleStringProperty();
    private final StringProperty isbn = new SimpleStringProperty();
    private final StringProperty categoria = new SimpleStringProperty();
    private final StringProperty descricao = new SimpleStringProperty();
    private final ObjectProperty<LocalDate> anoPublicacao = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> dataCadastro = new SimpleObjectProperty<>();

    public Livro() {
    }
    
    public Livro(int id, String titulo, String autor, String editora, String isbn, String categoria, 
            String descricao, LocalDate anoPublicacao, LocalDate dataCadastro) {
        
        this.id.set(id);
        this.titulo.set(titulo);
        this.autor.set(autor);
        this.editora.set(autor);
        this.isbn.set(isbn);
        this.categoria.set(categoria);
        this.descricao.set(descricao);
        this.anoPublicacao.set(anoPublicacao);
        this.dataCadastro.set(dataCadastro);
        
    }
    
    public Livro(String titulo, String autor, String editora, String isbn, String categoria, 
            String descricao, LocalDate anoPublicacao, LocalDate dataCadastro) {
        
        this.titulo.set(titulo);
        this.autor.set(autor);
        this.editora.set(autor);
        this.isbn.set(isbn);
        this.categoria.set(categoria);
        this.descricao.set(descricao);
        this.anoPublicacao.set(anoPublicacao);
        this.dataCadastro.set(dataCadastro);
        
    }
    
    // getters & setters
    
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public StringProperty tituloProperty() {
        return titulo;
    }

    public String getAutor() {
        return autor.get();
    }

    public void setAutor(String autor) {
        this.autor.set(autor);
    }

    public StringProperty autorProperty() {
        return autor;
    }

    public String getEditora() {
        return editora.get();
    }

    public void setEditora(String editora) {
        this.editora.set(editora);
    }

    public StringProperty editoraProperty() {
        return editora;
    }

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public StringProperty isbnProperty() {
        return isbn;
    }

    public String getCategoria() {
        return categoria.get();
    }

    public void setCategoria(String categoria) {
        this.categoria.set(categoria);
    }

    public StringProperty categoriaProperty() {
        return categoria;
    }

    public String getDescricao() {
        return descricao.get();
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao.get();
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao.set(anoPublicacao);
    }

    public ObjectProperty<LocalDate> anoPublicacaoProperty() {
        return anoPublicacao;
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


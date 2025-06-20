package Model;

import dao.ConexaoBD;
import java.sql.Connection;

public abstract class GenericDAO {
	private Connection conexao;

	// Protected pois pertencem a esta classe, somente podem ser usadas por classes
	// que herdam desta
	protected GenericDAO() {
		this.conexao = ConexaoBD.conectar();
	}

	// Método que retorna a conexaao
	protected Connection conectarDAO() {
		this.conexao = ConexaoBD.conectar();
		return conexao;
	}
    
}

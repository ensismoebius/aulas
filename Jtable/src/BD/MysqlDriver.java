package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlDriver implements IBdDriver {

	private Connection conexao;
	private ResultSet resultados;

	public boolean conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexao = DriverManager
					.getConnection("jdbc:mysql://localhost/test?user=root&password=1234");
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean desconectar() {
		try {
			this.conexao.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean executarQuerieComRetorno(String sql) {

		Statement query;
		try {
			query = conexao.createStatement();
			query.execute(sql);
			this.resultados = query.getResultSet();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean executarQuerieSemRetorno(String sql) {
		Statement query;
		try {
			query = conexao.createStatement();
			query.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ResultSet retornarResultados() {
		return this.resultados;
	}

}

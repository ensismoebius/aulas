package BD;
import java.sql.ResultSet;

/**
 * O sistema deve usar esta classe para fazer as transações com o banco de dados
 * 
 * @author André Furlan
 * 
 */
public class BaseDeDados {

	private IBdDriver driver;

	public BaseDeDados(IBdDriver driverDoBancoDeDados) {
		this.driver = driverDoBancoDeDados;
	}

	public boolean executarQuerie(String sql) {

		String sqlEmLetraMaiuscula = sql.toUpperCase().trim();

		this.driver.desconectar();
		if (!this.driver.conectar())
			return false;

		if (sqlEmLetraMaiuscula.startsWith("SELECT")) {

			return this.driver.executarQuerieComRetorno(sql);
		}

		return this.driver.executarQuerieSemRetorno(sql);

	}

	public ResultSet retornarResultados() {
		return this.driver.retornarResultados();
	}

}

package BD;
import java.sql.ResultSet;

/**
 * Define os padrões de conexão com qualquer banco de dados na nossa aplicação
 * 
 * @author André Furlan
 */
public interface IBdDriver {

	/**
	 * Define o padrão usado para iniciar a conexão com o banco de dados
	 * 
	 * @return true - Caso tenha conectado ou False - Caso não tenha conectado
	 */
	public boolean conectar();

	/**
	 * Define o padrão usado para terminar a conexão com o banco de dados
	 * 
	 * @return true - Caso tenha desconectado ou False - Caso não tenha
	 *         desconectado
	 */
	public boolean desconectar();

	/**
	 * Reponsável por executar os SELECTs
	 * 
	 * @param sql - O SELECT a ser executado
	 * @return true para excução com sucesso e false para execução sem sucesso
	 */
	public boolean executarQuerieComRetorno(String sql);

	/**
	 * Reponsável por executar os DELETES, UPDATES, INSERTS, etc.
	 * 
	 * @param sql - O querie a ser executada
	 * @return true para excução com sucesso e false para execução sem sucesso
	 */
	public boolean executarQuerieSemRetorno(String sql);
	
	
	/**
	 * Deve retornar os resultados gerados pelo método executarQuerieComRetorno
	 * @return os resultados do SELECT
	 */
	public ResultSet retornarResultados();
	
	
	

}

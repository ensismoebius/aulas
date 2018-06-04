package Table;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import BD.BaseDeDados;
import BD.MysqlDriver;

/**
 * O modelo de dados para a JTable
 * 
 * Obs: NESTE CASO todos os métodos públicos sobrescrevem algum método de
 * AbstractTableModel
 * 
 * @author André Furlan
 * 
 */
public class MyFuckingGoodDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 8139700190575605691L;

	private BaseDeDados bd;

	/**
	 * Construtor da classe
	 */
	public MyFuckingGoodDataModel(String sql) {

		this.bd = new BaseDeDados(new MysqlDriver());
		this.bd.executarQuerie(sql);
	}

	/**
	 * Retorna a qtde de linhas
	 */
	public int getRowCount() {
		try {
			return this.bd.retornarResultados().getFetchSize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Retorna a qtde de colunas
	 */
	public int getColumnCount() {
		try {
			return this.bd.retornarResultados().getMetaData().getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Retorna o valor de uma determinada célula
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			this.bd.retornarResultados().absolute(rowIndex + 1);
			return this.bd.retornarResultados().getObject(columnIndex + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna o nome de uma determinada coluna
	 */
	public String getColumnName(int column) {
		try {
			return this.bd.retornarResultados().getMetaData()
					.getColumnName(column + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Informa se a célula é editável
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	/**
	 * Retorna a classe do dado para que o mesmo seja renderizado devidamente
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
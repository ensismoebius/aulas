package Table;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 * O modelo de dados para a JTable
 * 
 * Obs: NESTE CASO todos os métodos públicos sobrescrevem algum método de
 * AbstractTableModel
 * 
 * @author André Furlan
 * 
 */
public class MyDataModel extends AbstractTableModel {

	private static final long serialVersionUID = 8139700190575605691L;

	/**
	 * Vou armazena os dados num ArrayList bidimensional
	 */
	private ArrayList<ArrayList<Object>> dados = new ArrayList<ArrayList<Object>>();

	/**
	 * Construtor da classe
	 */
	public MyDataModel() {

		// Gerando os dados para as linhas e as colunas
		for (int indiceLinha = 0; indiceLinha < this.getRowCount(); indiceLinha++) {

			ArrayList<Object> linha = new ArrayList<Object>();

			for (int indiceColuna = 0; indiceColuna < this.getColumnCount(); indiceColuna++) {

				if (indiceColuna == this.getColumnCount() - 1) {
					linha.add(indiceColuna, new Boolean(true));
					continue;
				}

				linha.add(indiceColuna, indiceColuna + indiceLinha);
			}
			this.dados.add(indiceLinha, linha);
		}
	}

	/**
	 * Retorna a qtde de linhas
	 */
	public int getRowCount() {
		return 5;
	}

	/**
	 * Retorna a qtde de colunas
	 */
	public int getColumnCount() {
		return 3;
	}

	/**
	 * Retorna o valor de uma determinada célula
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return (this.getColumnCount()*rowIndex+columnIndex)+1;

		//return this.dados.get(rowIndex).get(columnIndex);
	}

	/**
	 * Atribui o valor a uma determinada célula
	 */
	public void setValueAt(Object value, int row, int col) {
		this.dados.get(row).set(col, (Object) value);

		// Importante! Sem isso os eventos não funcionam
		this.fireTableCellUpdated(row, col);
		// Chama um gambi didática
		this.showData();
	}

	/**
	 * Retorna o nome de uma determinada coluna
	 */
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "preço";
		case 1:
			return "Quantidade";
		case 2:
			return "Cod do tipo";
		}
		return null;
	}

	/**
	 * Informa se a célula é editável
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//if (columnIndex == 1 || columnIndex == 2)
		//	return true;
		return true;
	}

	/**
	 * Retorna a classe do dado para que o mesmo seja renderizado devidamente
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/**
	 * Gambi para mostrar que os dados realmente estão mudando
	 */
	private void showData() {
		for (ArrayList<Object> linha : this.dados) {
			for (Object celula : linha) {
				System.out.print(celula.toString() + "|");
			}
			System.out.println();
		}
		System.out.print("------\n");
	}
}

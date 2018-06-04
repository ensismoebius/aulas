package Table;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Widget personalizado É simplesmente um JScrollPane com uma JTable dentro e
 * que implementa um "escutador" de eventos na tabela
 * 
 * @author André Furlan
 * 
 */
public class MyTable extends JScrollPane implements TableModelListener, ListSelectionListener {

	private static final long serialVersionUID = -1715838604026982974L;

	/**
	 * Propriedade onde guardamos a tablela
	 */
	private JTable tabela;

	// **Modelo de dados
	private MyDataModel dataModel;

	// **Ordenador da tabela
	private TableRowSorter<MyDataModel> ordenador;

	/**
	 * Construtor da classe
	 */
	public MyTable() {

		// Guardando o modelo de dados
		this.dataModel = new MyDataModel();

		// **Criando o ordenador de dados
		this.ordenador = new TableRowSorter<MyDataModel>(this.dataModel);
		this.ordenador.setModel(this.dataModel);

		// Criando uma nova instância da JTable e formatando
		this.tabela = new JTable();
		this.tabela.setBorder((Border) new LineBorder(Color.black));
		this.tabela.setGridColor(MinhasCores.verdeAmarelado);
		this.tabela.setShowGrid(true);

		// Detecta duplos cliques, a célula não pode ser editável
		this.tabela.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 2) {
					System.out.println(" clique duplo ");
				}
			}
		});

		// **Forma dificil
		this.tabela.setRowSorter(this.ordenador);

		// **Forma fácil
		// this.tabela.setAutoCreateRowSorter(true);

		// **É possível selecionar apenas uma linha por vez
		this.tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Atribuindo o modelo de dados a tabela
		this.tabela.setModel(this.dataModel);

		// Falando para a JTable usar comboBoxes como editor padrão na coluna
		// "Quantidade"
		this.configurarColunaDaQuantidade(this.tabela.getColumnModel().getColumn(1));

		// Definindo o tamnho do JScrollPane
		this.setSize(450, 500);

		// Adicionando a tabela ao JScrollPane
		this.getViewport().add(this.tabela);

		// Registrando o "escutador" de eventos
		this.tabela.getModel().addTableModelListener(this);

		this.tabela.getSelectionModel().addListSelectionListener(this);

	}

	/**
	 * Fala para a JTable usar comboBoxes como editor padrão na coluna
	 * "Quantidade"
	 * 
	 * @param coluna
	 */
	public void configurarColunaDaQuantidade(TableColumn coluna) {
		JComboBox<Integer> comboBoxes = new JComboBox<Integer>();
		comboBoxes.addItem(0);
		comboBoxes.addItem(1);
		comboBoxes.addItem(2);
		comboBoxes.addItem(3);
		comboBoxes.addItem(4);
		comboBoxes.addItem(5);

		coluna.setCellEditor(new DefaultCellEditor(comboBoxes));
	}

	/**
	 * Este método é chamado sempre que algo muda na tabela
	 */
	public void tableChanged(TableModelEvent e) {

		Integer linha = e.getFirstRow();
		Integer coluna = e.getColumn();

		TableModel dados = (TableModel) e.getSource();

		String nomeDaColuna = dados.getColumnName(coluna);

		Object dado = dados.getValueAt(linha, coluna);

		System.out.println("A linha " + linha.toString() + " na coluna " + nomeDaColuna + " mudou para " + dado.toString());

	}

	/**
	 * Escuta os eventos de seleção
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println(this.tabela.getSelectedRow());

	}

}

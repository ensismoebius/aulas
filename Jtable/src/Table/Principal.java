package Table;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	/**
	 * Construtor da classe
	 */
	public Principal() {

		this.add(new MyTable());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}

	/**
	 * Inicia o programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new Principal();

	}
}

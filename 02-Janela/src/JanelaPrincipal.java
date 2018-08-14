import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame {
	private JTextField txtcpf;
	private JLabel lblcpf;

	private JTextField txtrg;
	private JLabel lblrg;

	private JButton btnsalvar;

	public JanelaPrincipal() {
		this.txtcpf = new JTextField(10);
		this.lblcpf = new JLabel("Cpf: ");

		this.txtrg = new JTextField(10);
		this.lblrg = new JLabel("Rg: ");

		this.btnsalvar = new JButton("Salvar");
		this.btnsalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ahhh!!!");
			}
		});

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints coordenadas = new GridBagConstraints();

		this.setLayout(layout);

		coordenadas.gridx = 0;
		coordenadas.gridy = 0;
		layout.setConstraints(lblcpf, coordenadas);
		this.getContentPane().add(lblcpf);

		coordenadas.gridx = 1;
		coordenadas.gridy = 0;
		layout.setConstraints(txtcpf, coordenadas);
		this.getContentPane().add(txtcpf);

		coordenadas.gridx = 0;
		coordenadas.gridy = 1;
		layout.setConstraints(lblrg, coordenadas);
		this.getContentPane().add(lblrg);

		coordenadas.gridx = 1;
		coordenadas.gridy = 1;
		layout.setConstraints(txtrg, coordenadas);
		this.getContentPane().add(txtrg);

		coordenadas.gridx = 0;
		coordenadas.gridy = 2;
		coordenadas.gridwidth = 2;
		coordenadas.fill = GridBagConstraints.HORIZONTAL;
		layout.setConstraints(btnsalvar, coordenadas);
		this.getContentPane().add(btnsalvar);

		this.pack();
		this.setVisible(true);

	}

}

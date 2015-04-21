import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DevolverPasaje extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField codPasaje;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DevolverPasaje frame = new DevolverPasaje();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DevolverPasaje(final Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIngreseElCodigo = new JLabel("Ingrese el codigo del pasaje");
		lblIngreseElCodigo.setBounds(68, 56, 206, 14);
		panel.add(lblIngreseElCodigo);
		
		codPasaje = new JTextField();
		codPasaje.setBounds(68, 81, 154, 20);
		panel.add(codPasaje);
		codPasaje.setColumns(10);
		
		JButton btnDevolver = new JButton("Devolver Pasaje");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pasaje pasaje;
					int codigo = Integer.parseInt(codPasaje.getText());
					if((pasaje=agencia.buscarPasaje(codigo))!=null) {
						JOptionPane.showMessageDialog(null, "Se ha devuelto el pasaje de valor " + pasaje.getPrecio() + ".");
						agencia.borrarPasaje(codigo);
						
						DevolverPasaje frame = new DevolverPasaje(agencia);
						frame.setVisible(true);
						
						DevolverPasaje.this.dispose();
						
					}
					else
						JOptionPane.showMessageDialog(null, "Codigo de pasaje no fue encontrado.");
				}
				catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "El codigo puede ser solo numeros.");
				}
			}
		});
		btnDevolver.setBounds(232, 80, 148, 23);
		panel.add(btnDevolver);
		
		JButton btnVolverAlMenu = new JButton("volver al Menu Principal");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame = new MenuPrincipal(agencia);
				frame.setVisible(true);
				
				DevolverPasaje.this.dispose();
			}
		});
		btnVolverAlMenu.setBounds(232, 11, 169, 23);
		panel.add(btnVolverAlMenu);
	}

}

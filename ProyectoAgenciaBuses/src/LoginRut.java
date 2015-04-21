import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginRut extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginRut frame = new LoginRut();
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
	public LoginRut(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIngreseRut = new JLabel("Ingrese rut(Ej 123456789)");
		lblIngreseRut.setBounds(81, 79, 192, 14);
		panel.add(lblIngreseRut);
		
		textField = new JTextField();
		textField.setBounds(110, 104, 94, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(agencia.validarRut(textField.getText())) {
					Cliente cliente;
					if((cliente = agencia.buscarCliente(textField.getText()))!=null) {

						BuscarBuses frame = new BuscarBuses(agencia, cliente);
						frame.setVisible(true);
						
						LoginRut.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Primero tienes que registrarte.");
				}
				else
					JOptionPane.showMessageDialog(null, "RUT incorrecto, intente nuevamente.");
					
			}
		});
		btnLogin.setBounds(224, 103, 89, 23);
		panel.add(btnLogin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrameAgregarCliente frame = new FrameAgregarCliente(agencia);
				frame.setVisible(true);
				
				LoginRut.this.dispose();
			}
		});
		btnRegistrarse.setBounds(148, 173, 110, 23);
		panel.add(btnRegistrarse);
		
		JButton btnVolverAlMenu = new JButton("Volver al Menu Principal");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame = new MenuPrincipal(agencia);
				frame.setVisible(true);
				
				LoginRut.this.dispose();
			}
		});
		btnVolverAlMenu.setBounds(247, 11, 177, 23);
		panel.add(btnVolverAlMenu);
	}
}

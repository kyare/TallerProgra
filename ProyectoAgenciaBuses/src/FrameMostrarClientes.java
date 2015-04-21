import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameMostrarClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameMostrarClientes frame = new FrameMostrarClientes();
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
	public FrameMostrarClientes(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setBounds(168, 51, 69, 14);
		panel.add(lblClientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 76, 296, 165);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rut", "Nombre", "Apellido", "Fecha de Nacimiento", "Estudiante"
			}
		));
		scrollPane.setViewportView(table);
		

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		Cliente clientes[] = agencia.listarClientes();
		if(clientes != null)
			for(int i = 0; i < clientes.length; i++) {
				String[] row = { clientes[i].getRut(), clientes[i].getNombres(), clientes[i].getApellidos(), 
						clientes[i].getFechaNacimiento(), "" + clientes[i].getEstudiante() };
				model.addRow(row);
			}
		
		JButton button = new JButton("Volver al Menu Principal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameMostrarClientes.this.dispose();
			}
		});
		button.setBounds(266, 0, 158, 23);
		panel.add(button);
	}

}

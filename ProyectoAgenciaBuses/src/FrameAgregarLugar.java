import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FrameAgregarLugar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLugar;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrameAgregarLugar frame = new FrameAgregarLugar();
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
	public FrameAgregarLugar(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		
		JButton btnVolverAlMenu = new JButton("Volver al Menu Principal");
		btnVolverAlMenu.setBounds(260, 11, 145, 23);
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame = new MenuPrincipal(agencia);
				frame.setVisible(true);
				
				FrameAgregarLugar.this.dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnVolverAlMenu);
		
		JButton btnAgregar = new JButton("Agregar Lugar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldLugar.getText().length()>0 && agencia.buscarLugar(textFieldLugar.getText())==null) {
					agencia.agregarLugar(textFieldLugar.getText());
					JOptionPane.showMessageDialog(null, "Se ha agregado correctamente.");
					FrameAgregarLugar frame = new FrameAgregarLugar(agencia);
					frame.setVisible(true);
					
					FrameAgregarLugar.this.dispose();
				}
				else {
					if(textFieldLugar.getText().length()>0)
						JOptionPane.showMessageDialog(null, "Ya existe un lugar con ese nombre.");
					else
						JOptionPane.showMessageDialog(null, "El nombre no puede estar en blanco.");
				}
				
				
			}
		});
		btnAgregar.setBounds(292, 89, 113, 23);
		panel.add(btnAgregar);
		
		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(196, 90, 86, 20);
		panel.add(textFieldLugar);
		textFieldLugar.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 25, 136, 226);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre del Lugar"
			}
		));

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		String[] lugares = agencia.listarLugarestoString();
		if(lugares != null)
			for(int i=0;i<lugares.length; i++) {
				String[] row = { lugares[i]};
				model.addRow(row);
			}
		scrollPane.setViewportView(table);
	}
}

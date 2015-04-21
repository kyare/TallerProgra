import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameMostrarLugares extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableLugares;

	/**
	 * Create the frame.
	 */
	public FrameMostrarLugares(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLugares = new JLabel("Lugares");
		lblLugares.setBounds(170, 24, 75, 14);
		panel.add(lblLugares);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 49, 192, 192);
		panel.add(scrollPane);
		
		tableLugares = new JTable();
		tableLugares.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lugar"
			}
		));
		scrollPane.setViewportView(tableLugares);
		
		JButton button = new JButton("Volver al Menu Principal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameMostrarLugares.this.dispose();
			}
		});
		button.setBounds(266, 0, 158, 23);
		panel.add(button);
		

		DefaultTableModel model = (DefaultTableModel) tableLugares.getModel();
		model.setNumRows(0);
		String lugares[] = agencia.listarLugarestoString();
		if(lugares != null)
			for(int i = 0; i < lugares.length; i++) {
				String[] row = { lugares[i] };
				model.addRow(row);
			}
	}
}

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameMostrarTramos extends JFrame {

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
//					FrameMostrarTramos frame = new FrameMostrarTramos();
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
	public FrameMostrarTramos(final Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTramos = new JLabel("Tramos");
		lblTramos.setBounds(186, 41, 93, 14);
		panel.add(lblTramos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 66, 253, 175);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Salida", "Llegada", "Tarifa"
			}
		));
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setNumRows(0);
		Tramo tramos[] = agencia.listarTramos();
		if(tramos != null)
			for(int i = 0; i < tramos.length; i++) {
				String[] row = { tramos[i].getSalida().getLugar(), tramos[i].getLlegada().getLugar(), "" + tramos[i].getTarifa() };
				model.addRow(row);
			}
		
		JButton button = new JButton("Volver al Menu Principal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameMostrarTramos.this.dispose();
			}
		});
		button.setBounds(256, 0, 158, 23);
		panel.add(button);
	}

}

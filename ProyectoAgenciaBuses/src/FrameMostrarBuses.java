import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameMostrarBuses extends JFrame {

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
//					FrameMostrarBuses frame = new FrameMostrarBuses();
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
	public FrameMostrarBuses(Agencia agencia) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton button = new JButton("Volver al Menu Principal");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameMostrarBuses.this.dispose();
			}
		});
		button.setBounds(514, 0, 169, 23);
		panel.add(button);
		
		JLabel label = new JLabel("Salida");
		label.setBounds(93, 51, 43, 14);
		panel.add(label);
		
		JComboBox<String> comboBoxSalida = new JComboBox<String>();
			String[] lugares = agencia.listarLugarestoString();
			comboBoxSalida.removeAllItems();
			comboBoxSalida.addItem("");
			for(int i = 0; i < lugares.length; i++) {
				comboBoxSalida.addItem(lugares[i]);
			}
		comboBoxSalida.setBounds(71, 71, 65, 20);
		panel.add(comboBoxSalida);
		
		JLabel label_1 = new JLabel("Llegada");
		label_1.setBounds(164, 51, 54, 14);
		panel.add(label_1);
		
		JComboBox<String> comboBoxLlegada = new JComboBox<String>();
		comboBoxLlegada.removeAllItems();
		comboBoxLlegada.addItem("");
		for(int i = 0; i < lugares.length; i++) {
			comboBoxLlegada.addItem(lugares[i]);
		}
		comboBoxLlegada.setBounds(146, 71, 72, 20);
		panel.add(comboBoxLlegada);
		
		JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.setBounds(255, 71, 37, 20);
		panel.add(comboBoxDia);
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.setBounds(298, 71, 79, 20);
		panel.add(comboBoxMes);
		
		JComboBox<Integer> comboBoxAnio = new JComboBox<Integer>();
		comboBoxAnio.setBounds(383, 71, 57, 20);
		panel.add(comboBoxAnio);
		

		comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Enero", "Febrero", "Marzo", 
				"Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBoxDia.setModel(new DefaultComboBoxModel<String>(new String[] {"", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxAnio.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2015, 2016}));
		
		JLabel label_2 = new JLabel("Fecha");
		label_2.setBounds(318, 51, 59, 14);
		panel.add(label_2);
		
		JButton button_1 = new JButton("Buscar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comboBoxSalida.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de salida no puede estar en blanco.");
				else if(comboBoxLlegada.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de llegada no puede estar en blanco.");
				else if(comboBoxSalida.getSelectedIndex() == comboBoxLlegada.getSelectedIndex())
					JOptionPane.showMessageDialog(null, "Lugar de salida y lugar de llegada no pueden ser iguales.");
				else if(comboBoxDia.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Dia no puede estar en blanco.");
				else if(comboBoxMes.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Mes no puede estar en blanco.");
				else  {
					Lugar salida = agencia.buscarLugar((String) comboBoxSalida.getSelectedItem());
					Lugar llegada = agencia.buscarLugar((String) comboBoxLlegada.getSelectedItem());
					Tramo tramo = agencia.buscarTramo(salida, llegada);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setNumRows(0);
					if(tramo != null) {
						String dia = comboBoxDia.getSelectedIndex() + "";
						if(dia.length()==1)
							dia = "0" + dia;
						String mes = comboBoxMes.getSelectedIndex() + "";
						if(mes.length()==1)
							mes = "0" + mes;
						String annio = comboBoxAnio.getSelectedItem() + "";
						String buscarFecha = dia + "/" + mes + "/" + annio;
						Bus[] buses = tramo.listarBuses(buscarFecha);
						if(buses == null)
							JOptionPane.showMessageDialog(null, "Se han encontrado 0 resultados.");
						else {
							JOptionPane.showMessageDialog(null, "Se encontraron " + buses.length + " resultados.");
							for(int i = 0; i < buses.length; i++) {
								String[] row = { "" + (i + 1), buses[i].getFecha(), buses[i].getHorario(), 
										 buses[i].getHorario(), "" + (44 - buses[i].contAsientos)};
								model.addRow(row);
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Tramo no encontrado.");
				}
			}
		});
		button_1.setBounds(469, 48, 78, 43);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 121, 594, 312);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha", "Hora Salida", "Hora Llegada", "Asiemtos Disp"
			}
		));
		scrollPane.setViewportView(table);
	}

}

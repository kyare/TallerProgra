
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class BuscarBuses extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel busqueda = new JPanel();
	private final JPanel resultados = new JPanel();
	
	private final JPanel panelBusqueda = new JPanel();
	private final JComboBox<String> comboBoxSalida = new JComboBox<String>();
	private final JComboBox<String> comboBoxLlegada = new JComboBox<String>();
	private JTextField textFieldAsientos;
	private final JTable table = new JTable();
	
	private final Agencia agencia;
	private Tramo tramo = null;
	private Bus[] buses = null;
	
	private final JComboBox<String> comboBoxDia = new JComboBox<String>();
	private final JComboBox<String> comboBoxMes = new JComboBox<String>();
	private final JLabel lblFecha = new JLabel("Fecha");
	private final JPanel panel = new JPanel();
	private final JTextField textFieldIdBus = new JTextField();
	private final JButton btnVerBus = new JButton("Ver Bus");
	private final JPanel panel_1 = new JPanel();
	private final JLabel labelNombre;
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton btnVolver = new JButton("Volver");
	private final JButton btnVolverAlMenu = new JButton("Volver al Menu Principal");

	/**
	 * Create the frame.
	 */
	public BuscarBuses(Agencia agencia, Cliente cliente) {
		this.agencia = agencia;
		this.labelNombre = new JLabel("Bienvenid@ " + cliente.getNombres() + " " + cliente.getApellidos());
		textFieldIdBus.setColumns(10);
		comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Enero", "Febrero", "Marzo", 
				"Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBoxDia.setModel(new DefaultComboBoxModel<String>(new String[] {"", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31"}));
		recargarLugares();
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setName("panel1");
		getContentPane().setMaximumSize(new Dimension(12312344, 2147483647));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		busqueda.setBounds(227, 54, 224, 24);
		getContentPane().add(busqueda);
		
		JLabel realizarBusqueda = new JLabel("Realizar Busqueda");
		busqueda.add(realizarBusqueda);
		resultados.setBounds(227, 165, 224, 24);
		getContentPane().add(resultados);
		
		JLabel busesEncontrados = new JLabel("Buses Encontrados");
		resultados.add(busesEncontrados);
		panelBusqueda.setBounds(41, 89, 608, 65);
		
		getContentPane().add(panelBusqueda);
		
		textFieldAsientos = new JTextField();
		textFieldAsientos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			}
		});
		textFieldAsientos.setText("1");
		textFieldAsientos.setColumns(10);
		
		JComboBox<Integer> comboBoxAnio = new JComboBox<Integer>();
		comboBoxAnio.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2015, 2016}));
		
		JLabel lblSalida = new JLabel("Salida");
		
		JLabel lblLlegada = new JLabel("Llegada");
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
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
				else if(textFieldAsientos.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Asientos disponibles no puede estar en blanco.");
				else  {
					try {
						if(Integer.parseInt(textFieldAsientos.getText()) < 1)
							JOptionPane.showMessageDialog(null, "Asientos disponibles no puede ser menor a 1.");
						else {
							Lugar salida = agencia.buscarLugar((String) comboBoxSalida.getSelectedItem());
							Lugar llegada = agencia.buscarLugar((String) comboBoxLlegada.getSelectedItem());
							tramo = agencia.buscarTramo(salida, llegada);
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
								if(Integer.parseInt(textFieldAsientos.getText()) == 1)
									buses = tramo.listarBuses(buscarFecha);
								else
									buses = tramo.listarBuses(buscarFecha,Integer.parseInt(textFieldAsientos.getText()));
								if(buses == null)
									JOptionPane.showMessageDialog(null, "Se han encontrado 0 resultados " + buscarFecha);
								else {
									JOptionPane.showMessageDialog(null, "Se encontraron " + buses.length + " resultados. "+ buscarFecha);
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
					catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Asientos disponibles tiene que ser un numero.");
					}
				}
			}
		});
		
		
		
		JLabel lblAsientos = new JLabel("Asientos");
		GroupLayout gl_panelBusqueda = new GroupLayout(panelBusqueda);
		gl_panelBusqueda.setHorizontalGroup(
			gl_panelBusqueda.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelBusqueda.createSequentialGroup()
					.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addGap(18)
							.addComponent(comboBoxSalida, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBoxLlegada, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addGap(40)
							.addComponent(lblSalida)
							.addGap(43)
							.addComponent(lblLlegada)))
					.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addGap(37)
							.addComponent(comboBoxDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxAnio, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addGap(100)
							.addComponent(lblFecha)))
					.addGap(27)
					.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAsientos)
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addGap(10)
							.addComponent(textFieldAsientos, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_panelBusqueda.setVerticalGroup(
			gl_panelBusqueda.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBusqueda.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addComponent(lblAsientos)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldAsientos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBusqueda.createSequentialGroup()
							.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblSalida)
									.addComponent(lblLlegada))
								.addComponent(lblFecha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelBusqueda.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxLlegada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxSalida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxDia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelBusqueda.setLayout(gl_panelBusqueda);
		
		JScrollPane panelResultados = new JScrollPane();
		panelResultados.setBounds(41, 200, 608, 235);
		getContentPane().add(panelResultados);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fecha", "Hora Salida", "Hora Llegada", "Asientos Disponibles"
			}
		));
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setToolTipText("");
		
		panelResultados.setViewportView(table);
		panel.setBounds(227, 446, 224, 41);
		
		getContentPane().add(panel);
		
		panel.add(textFieldIdBus);
		btnVerBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(buses != null && Integer.parseInt(textFieldIdBus.getText()) > 0 && (buses.length + 1) > Integer.parseInt(textFieldIdBus.getText())) {

						BuscarAsiento frame = new BuscarAsiento(agencia, cliente, tramo, buses[Integer.parseInt(textFieldIdBus.getText()) - 1]);
						frame.setVisible(true);
						BuscarBuses.this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "El id del bus no esta en la lista.");
					}
				}
				catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "El id del bus tiene que ser un numero.");
				}
			}
		});
		
		panel.add(btnVerBus);
		panel_1.setBounds(227, 11, 224, 25);
		
		getContentPane().add(panel_1);
		
		panel_1.add(labelNombre);
		panel_2.setBounds(10, 11, 189, 50);
		
		getContentPane().add(panel_2);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginRut frame = new LoginRut(agencia);
				frame.setVisible(true);
				
				BuscarBuses.this.dispose();
			}
		});
		
		panel_2.add(btnVolver);
		panel_3.setBounds(475, 11, 200, 58);
		
		getContentPane().add(panel_3);
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				BuscarBuses.this.dispose();
			}
		});
		
		panel_3.add(btnVolverAlMenu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 536);
	}
	
	public void recargarLugares() {
		String[] lugares = agencia.listarLugarestoString();
		comboBoxSalida.removeAllItems();
		comboBoxLlegada.removeAllItems();
		comboBoxSalida.addItem("");
		comboBoxLlegada.addItem("");
		for(int i = 0; i < lugares.length; i++) {
			comboBoxSalida.addItem(lugares[i]);
			comboBoxLlegada.addItem(lugares[i]);
		}
	}
}

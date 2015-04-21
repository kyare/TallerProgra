import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameAgregarTramo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarTramo frame = new FrameAgregarTramo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public FrameAgregarTramo(final Agencia agencia) {
		setTitle("Agregar un Tramo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLugarDeLlegada = new JLabel("Lugar de Llegada");
		lblLugarDeLlegada.setBounds(234, 66, 114, 14);
		contentPane.add(lblLugarDeLlegada);
		
		JLabel lblLugarDeSalida = new JLabel("Lugar de Salida");
		lblLugarDeSalida.setBounds(127, 66, 103, 14);
		contentPane.add(lblLugarDeSalida);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(137, 125, 49, 14);
		contentPane.add(lblTarifa);
		
		final JComboBox<String> comboBoxLlegada = new JComboBox<String>();
		comboBoxLlegada.setBounds(234, 91, 103, 20);
		contentPane.add(comboBoxLlegada);
		
		final JComboBox<String> comboBoxSalida = new JComboBox<String>();
		comboBoxSalida.setBounds(111, 91, 103, 20);
		contentPane.add(comboBoxSalida);
		
		// Agregando lugares a comboBoxLlegada y comboBoxSalida.
		String[] lugares = agencia.listarLugarestoString();
		comboBoxSalida.removeAllItems();
		comboBoxLlegada.removeAllItems();
		comboBoxSalida.addItem("");
		comboBoxLlegada.addItem("");
		for(int i = 0; i < lugares.length; i++) {
			comboBoxSalida.addItem(lugares[i]);
			comboBoxLlegada.addItem(lugares[i]);
		}
		
		textField = new JTextField();
		textField.setBounds(189, 122, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAgregarTramo = new JButton("Agregar Tramo");
		btnAgregarTramo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxSalida.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de salida no puede estar en blanco.");
				else if(comboBoxLlegada.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de llegada no puede estar en blanco.");
				else if(comboBoxSalida.getSelectedIndex() == comboBoxLlegada.getSelectedIndex())
					JOptionPane.showMessageDialog(null, "Lugar de salida y lugar de llegada no pueden ser iguales.");
				else if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Tarifa no puede estar en blanco.");
				else  {
					try {
						if(Integer.parseInt(textField.getText()) < 1)
							JOptionPane.showMessageDialog(null, "Tarifa no puede ser menor a uno.");
						else {
							Lugar salida = agencia.listarLugares()[comboBoxSalida.getSelectedIndex() - 1];
							Lugar llegada = agencia.listarLugares()[comboBoxLlegada.getSelectedIndex() - 1];
							int tarifa = Integer.parseInt(textField.getText());
							if(agencia.agregarTramo(salida, llegada, tarifa)!=null) {
								JOptionPane.showMessageDialog(null, "Se ha agregado correctamente.");

								FrameAgregarTramo frame = new FrameAgregarTramo(agencia);
								frame.setVisible(true);
								
								FrameAgregarTramo.this.dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Ya existe ese tramo, intente con otro tramo.");
						}
							
					}
					catch(NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Tarifa tiene que ser un numero.");
					}
				}
			}
		});
		btnAgregarTramo.setBounds(149, 161, 139, 23);
		contentPane.add(btnAgregarTramo);
		
		JButton btnVolver = new JButton("Volver al Menu Principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameAgregarTramo.this.dispose();
			}
		});
		btnVolver.setBounds(235, 11, 189, 23);
		contentPane.add(btnVolver);
	}
}

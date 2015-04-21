import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;


public class FrameAgregarBus extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarBus frame = new FrameAgregarBus();
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
	
	public FrameAgregarBus(Agencia agencia) {
		setTitle("Agregar un Bus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(118, 114, 60, 14);
		contentPane.add(lblFecha);
		
		JLabel lblHoraDeLlegada = new JLabel("Hora de llegada");
		lblHoraDeLlegada.setBounds(118, 170, 75, 14);
		contentPane.add(lblHoraDeLlegada);
		
		JLabel lblHoraDeSalida = new JLabel("Hora de salida");
		lblHoraDeSalida.setBounds(118, 142, 93, 14);
		contentPane.add(lblHoraDeSalida);
		
		final JComboBox<String> comboBoxDia = new JComboBox<String>();
		comboBoxDia.addItem("Dia");
		for (int i = 1; i <=31; i++) {
			if(i < 10)
				comboBoxDia.addItem("0" + String.valueOf(i));
			else
				comboBoxDia.addItem(String.valueOf(i));
		}
		comboBoxDia.setBounds(166, 111, 45, 20);
		contentPane.add(comboBoxDia);
		
		JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.addItem("Mes");
		for (int i = 1; i <= 12; i++) {
			if(i < 10)
				comboBoxMes.addItem("0" + String.valueOf(i));
			else
				comboBoxMes.addItem(String.valueOf(i));
		}
		comboBoxMes.setBounds(221, 111, 45, 20);
		contentPane.add(comboBoxMes);
		
		JComboBox<String> comboBoxAño = new JComboBox<String>();
		comboBoxAño.addItem("Año");
		for (int i = 1920; i <= 2015 ; i++) {
			comboBoxAño.addItem(String.valueOf(i));
		}
		comboBoxAño.setBounds(276, 111, 51, 20);
		contentPane.add(comboBoxAño);
		
		String[] tiempo = new String[62];
		tiempo[0] = "";
		for(int i = 0; i < 10; i++)
			tiempo[i+1] = "0" + i;
		for(int i = 10; i < 60; i++)
			tiempo[i+1] = "" + i;
		
		JComboBox<String> comboBoxHoraSal = new JComboBox<String>();
		comboBoxHoraSal.setModel(new DefaultComboBoxModel<String>(tiempo));
		comboBoxHoraSal.addItem("HSalida");
		for (int i = 00; i <= 23 ; i++) {
			comboBoxHoraSal.addItem(String.valueOf(i));
		}
		comboBoxHoraSal.setBounds(203, 139, 45, 20);
		contentPane.add(comboBoxHoraSal);
		
		JComboBox<String> comboBoxMinutoSal = new JComboBox<String>();
		comboBoxMinutoSal.setModel(new DefaultComboBoxModel<String>(tiempo));
		comboBoxMinutoSal.addItem("MSalida");
		for (int i = 00; i <= 59 ; i++) {
			comboBoxMinutoSal.addItem(String.valueOf(i));
		}
		comboBoxMinutoSal.setBounds(258, 139, 45, 20);
		contentPane.add(comboBoxMinutoSal);
		
		JComboBox<String> comboBoxHoraLleg = new JComboBox<String>();
		comboBoxHoraLleg.setModel(new DefaultComboBoxModel<String>(tiempo));
		comboBoxHoraLleg.addItem("HLlegada");
		for (int i = 00; i <= 23 ; i++) {
			comboBoxHoraLleg.addItem(String.valueOf(i));
		}
		comboBoxHoraLleg.setBounds(203, 167, 45, 20);
		contentPane.add(comboBoxHoraLleg);
		
		JComboBox<String> comboBoxMinutoLleg = new JComboBox<String>();
		comboBoxMinutoLleg.setModel(new DefaultComboBoxModel<String>(tiempo));
		comboBoxMinutoLleg.addItem("MinutoLleg");
		for (int i = 00; i <= 59 ; i++) {
			comboBoxMinutoLleg.addItem(String.valueOf(i));
		}
		comboBoxMinutoLleg.setBounds(258, 167, 45, 20);
		contentPane.add(comboBoxMinutoLleg);
		
		JComboBox<String> comboBoxSalida = new JComboBox<String>();	
		comboBoxSalida.setBounds(118, 80, 91, 20);
		contentPane.add(comboBoxSalida);
		
		JComboBox<String> comboBoxLlegada = new JComboBox<String>();
		comboBoxLlegada.setBounds(242, 80, 85, 20);
		contentPane.add(comboBoxLlegada);
		
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

		JButton btnAgregarElBus = new JButton("Agregar el bus");
		btnAgregarElBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				if(comboBoxSalida.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de la salida no puede estar en blanco.");
				else if(comboBoxLlegada.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Lugar de llegada no puede estar en blanco.");
				else if(comboBoxDia.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Dia no puede estar en blanco.");
				else if(comboBoxMes.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Mes no puede estar en blanco.");
				else if(comboBoxAño.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Año no pueden ser iguales.");
				else if(comboBoxHoraSal.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Hora de salida no puede estar en blanco.");
				else if(comboBoxMinutoSal.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Minutos de la salida no puede estar en blanco.");
				else if(comboBoxHoraLleg.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Hora de llegada no puede estar en blanco.");
				else if(comboBoxMinutoLleg.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Minutos de la llegada no puede estar en blanco.");
				else {
					Lugar salida = agencia.listarLugares()[comboBoxSalida.getSelectedIndex() - 1];
					Lugar llegada = agencia.listarLugares()[comboBoxLlegada.getSelectedIndex() - 1];
					Tramo tramo = agencia.buscarTramo(salida, llegada);
					if(tramo != null) {
						String dia=(String)comboBoxDia.getSelectedItem();
						String mes=(String)comboBoxMes.getSelectedItem();
						String año=(String)comboBoxAño.getSelectedItem();
						String horaSal=(String)comboBoxHoraSal.getSelectedItem();
						String minutoSal=(String)comboBoxMinutoSal.getSelectedItem();
						String horaLleg=(String)comboBoxHoraLleg.getSelectedItem();
						String minutoLleg=(String)comboBoxMinutoLleg.getSelectedItem();
						if(tramo.agregarBus(horaSal, minutoSal, horaLleg, minutoLleg, dia, mes, año)!=null) {
							JOptionPane.showMessageDialog(null, "Se ha guardado correctamente.");

							FrameAgregarBus frame = new FrameAgregarBus(agencia);
							frame.setVisible(true);
							
							FrameAgregarBus.this.dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "Ya existe un bus con esa fecha y hora.");
					}
					else
						JOptionPane.showMessageDialog(null, "Tramo no encontrado, intente con otro tramo.");
				}
			}
		});
		btnAgregarElBus.setBounds(162, 209, 122, 23);
		contentPane.add(btnAgregarElBus);
		
		JLabel lblLugarSalida = new JLabel("Lugar Salida");
		lblLugarSalida.setBounds(136, 54, 75, 17);
		contentPane.add(lblLugarSalida);
		
		JLabel lblLugarLlegada = new JLabel("Lugar Llegada");
		lblLugarLlegada.setBounds(242, 55, 85, 14);
		contentPane.add(lblLugarLlegada);
		
				
		JButton btnVolver = new JButton("Volver al Menu Principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameAgregarBus.this.dispose();
			}
		});
		btnVolver.setBounds(241, 11, 183, 23);
		contentPane.add(btnVolver);
	}
	
}

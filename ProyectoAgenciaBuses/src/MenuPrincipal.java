import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuPrincipal( final Agencia agencia) {
		//setAlwaysOnTop(true);
		
		setTitle("Empresa de Buses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Lugar", "Tramo", "Bus", "Cliente"}));
		comboBox.setBounds(169, 89, 138, 20);
		contentPane.add(comboBox);
		
		JLabel lblOpcionesDeAgregado = new JLabel("Opciones de agregado");
		lblOpcionesDeAgregado.setForeground(Color.BLUE);
		lblOpcionesDeAgregado.setBounds(27, 88, 144, 23);
		contentPane.add(lblOpcionesDeAgregado);
		
		JLabel label = new JLabel("");
		label.setBounds(27, 25, 46, 14);
		contentPane.add(label);
		
		final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Compra de  Pasajes", "Devoluci\u00F3n de Pasajes"}));
		comboBox_1.setBounds(169, 60, 138, 20);
		contentPane.add(comboBox_1);
		 JLabel lblOpcionesDePasajes = new JLabel("Opciones de Pasajes");
		lblOpcionesDePasajes.setForeground(Color.BLUE);
		lblOpcionesDePasajes.setBounds(27, 63, 126, 14);
		contentPane.add(lblOpcionesDePasajes);
		
		JLabel lblBienvenidoAlMenu = new JLabel("Bienvenido al Menu Principal ");
		lblBienvenidoAlMenu.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblBienvenidoAlMenu.setBounds(58, 11, 249, 28);
		contentPane.add(lblBienvenidoAlMenu);
		
		JButton btnListo = new JButton("Listo");
		btnListo.addActionListener(new ActionListener() {/*se selecciona el boton de pasajes*/
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_1.getSelectedIndex()==0) {
					LoginRut frame = new LoginRut(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
				}
				else {
					DevolverPasaje frame = new DevolverPasaje(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
				}
			}
		});/*boton de Opcion Pasajeros*/
		btnListo.setBounds(317, 59, 89, 23);
		contentPane.add(btnListo);
		
		JButton btnListo_1 = new JButton("Listo");

		btnListo_1.addActionListener(new ActionListener() {/*boton presionado*/
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedIndex()==0) {
					FrameAgregarLugar frame = new FrameAgregarLugar(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
					
				}
				if(comboBox.getSelectedIndex()==1){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								FrameAgregarTramo frame = new FrameAgregarTramo(agencia);
								frame.setVisible(true);
								MenuPrincipal.this.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				if(comboBox.getSelectedIndex()==2){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								FrameAgregarBus frame = new FrameAgregarBus(agencia);
								frame.setVisible(true);
								MenuPrincipal.this.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				if(comboBox.getSelectedIndex()==3){
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								FrameAgregarCliente frame = new FrameAgregarCliente(agencia);
								MenuPrincipal.this.setVisible(false);
								frame.setVisible(true);
								MenuPrincipal.this.dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
			}
		});/*boton de Opcion Agregar*/
		btnListo_1.setBounds(317, 88, 89, 23);
		contentPane.add(btnListo_1);
		
		JLabel lblMostrar = new JLabel("Mostrar Todos los");
		lblMostrar.setForeground(Color.BLUE);
		lblMostrar.setBounds(27, 123, 144, 23);
		contentPane.add(lblMostrar);
		
		final JComboBox<String> comboBoxMostrar = new JComboBox<String>();
		comboBoxMostrar.setModel(new DefaultComboBoxModel<String>(new String[] {"Lugares", "Tramos", "Buses", "Clientes"}));
		comboBoxMostrar.setBounds(169, 124, 138, 20);
		contentPane.add(comboBoxMostrar);
		
		JButton buttonMostrar = new JButton("Listo");
		buttonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxMostrar.getSelectedIndex() == 0) {
					FrameMostrarLugares frame = new FrameMostrarLugares(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
				}
				else if(comboBoxMostrar.getSelectedIndex() == 1) {
					FrameMostrarTramos frame = new FrameMostrarTramos(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
					
				}
				else if(comboBoxMostrar.getSelectedIndex() == 2) {
					FrameMostrarBuses frame = new FrameMostrarBuses(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
					
				}
				else if(comboBoxMostrar.getSelectedIndex() == 3) {
					FrameMostrarClientes frame = new FrameMostrarClientes(agencia);
					frame.setVisible(true);
					
					MenuPrincipal.this.dispose();
					
				}
			}
		});
		buttonMostrar.setBounds(317, 123, 89, 23);
		contentPane.add(buttonMostrar);
		
	}
}
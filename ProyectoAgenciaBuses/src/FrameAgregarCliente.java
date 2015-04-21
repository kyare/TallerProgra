import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FrameAgregarCliente extends JFrame {

	/**
	 * 
	 */
	BufferedReader lee=new BufferedReader(new InputStreamReader(System.in));
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldRut;
	private JTextField textFieldTelefono;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAgregarCliente frame = new FrameAgregarCliente();
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
	public FrameAgregarCliente(final Agencia agencia) {
		setTitle("Agregar Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLleneLosCampos = new JLabel("Llene los campos para agregar un cliente");
		lblLleneLosCampos.setBounds(33, 16, 250, 19);
		contentPane.add(lblLleneLosCampos);
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		lblEstudiante.setBounds(237, 72, 62, 14);
		contentPane.add(lblEstudiante);
		
		final JComboBox<String> comboBoxEstudiante = new JComboBox<String>();
		comboBoxEstudiante.setBounds(310, 69, 46, 20);
		comboBoxEstudiante.setModel(new DefaultComboBoxModel<String>(new String[] {"Si", "No"}));
		contentPane.add(comboBoxEstudiante);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(28, 46, 56, 14);
		contentPane.add(lblNombres);
		
		textFieldNombres = new JTextField();
		textFieldNombres.setBounds(105, 43, 105, 20);
		contentPane.add(textFieldNombres);
		textFieldNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(28, 72, 56, 14);
		contentPane.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(105, 69, 105, 20);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setBounds(28, 144, 126, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(237, 47, 28, 14);
		contentPane.add(lblRut);
		
		textFieldRut = new JTextField();
		textFieldRut.setBounds(270, 41, 86, 20);
		contentPane.add(textFieldRut);
		textFieldRut.setColumns(10);
		
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(28, 100, 62, 14);
		contentPane.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(105, 97, 105, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		final JComboBox<String> comboBoxDia = new JComboBox<String>();	
		comboBoxDia.addItem("Dia");
		for (int i = 1; i <=31; i++) {
			comboBoxDia.addItem(String.valueOf(i));
		}
		comboBoxDia.setBounds(156, 141, 46, 20);
		contentPane.add(comboBoxDia);
		
		
		final JComboBox<String> comboBoxMes = new JComboBox<String>();
		comboBoxMes.addItem("Mes");
		for (int i = 1; i <= 12; i++) {
			comboBoxMes.addItem(String.valueOf(i));
		}
		comboBoxMes.setBounds(221, 141, 62, 20);
		contentPane.add(comboBoxMes);
		
		
		final JComboBox<String> comboBoxAnio = new JComboBox<String>();
		comboBoxAnio.addItem("Año");
		for (int i = 1920; i <= 2015 ; i++) {
			comboBoxAnio.addItem(String.valueOf(i));
		}
		comboBoxAnio.setBounds(298, 141, 62, 20);
		contentPane.add(comboBoxAnio);
		
		JButton btnAgregarDatos = new JButton("Agregar Datos");
		btnAgregarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean estudiante;
				estudiante=comboBoxEstudiante.getSelectedIndex()==0;
				String rut;
				String fechaNac;
				rut=textFieldRut.getText();
				rut = rut.toUpperCase();
				rut = rut.replace(".", "");
				rut = rut.replace("-", "");
			
				fechaNac=(String) comboBoxDia.getSelectedItem() + (String) comboBoxMes.getSelectedItem() + (String)comboBoxAnio.getSelectedItem() ;
				//verificar datos y agregarlos si se puede
				if(agencia.validarRut(rut)==true)
				{//rut es valido
					if(!(textFieldRut.getText().equals("") || textFieldNombres.getText().equals("") || textFieldApellidos.getText().equals("") || fechaNac.equals("DiaMesAño") ||  textFieldTelefono.getText().equals("") ))
					{
						if(null!=agencia.agregarCliente(rut, textFieldNombres.getText().toUpperCase(), textFieldApellidos.getText().toUpperCase(),  fechaNac, estudiante, textFieldTelefono.getText()))
						{

//							agencia.mostrarCliente(rut);

							JOptionPane.showMessageDialog(null, "Se ha guardado correctamente.");
							
							LoginRut frame = new LoginRut(agencia);
							frame.setVisible(true);
							
							FrameAgregarCliente.this.dispose();

						}


						else {
							JOptionPane.showMessageDialog(null, "El cliente ya se encuentra registrado");//llamar a ventana emergente hubo un error al agregar asegurese de que no hayan campos en blanco y que el rut ingresado sea valido
						}

					}else{
						JOptionPane.showMessageDialog(null, "Llene todos los campos");
					}
				}else JOptionPane.showMessageDialog(null, "Ingrese un rut valido");
			
			}
		});
		btnAgregarDatos.setBounds(76, 185, 127, 23);
		contentPane.add(btnAgregarDatos);
		
		
		JButton btnVolver = new JButton("volver al Menu Principal");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal frame=new MenuPrincipal(agencia);
				frame.setVisible(true);
				FrameAgregarCliente.this.dispose();
			}
		});
		btnVolver.setBounds(237, 185, 170, 23);
		contentPane.add(btnVolver);
	
	}
	
}

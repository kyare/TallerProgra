import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BuscarAsiento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private boolean asientosComprados[] = new boolean[44];
	
	/**
	 * Create the frame.
	 */
	public BuscarAsiento(Agencia agencia, Cliente cliente, Tramo tramo, Bus bus) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 620, 458);
		contentPane.add(panel);
		
		

		JLabel lblNewLabel = new JLabel("Asientos");
		lblNewLabel.setBounds(99, 47, 72, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNumeroDePasajes = new JLabel("Numero de Pasajes seleccionados:");
		lblNumeroDePasajes.setBounds(263, 104, 201, 14);
		panel.add(lblNumeroDePasajes);
		
		JLabel pasajes = new JLabel("0");
		pasajes.setBounds(474, 104, 46, 14);
		panel.add(pasajes);
		
		JLabel lblCostoTotal = new JLabel("Costo total:");
		lblCostoTotal.setBounds(400, 134, 64, 14);
		panel.add(lblCostoTotal);
		
		JLabel total = new JLabel("0");
		total.setBounds(474, 134, 46, 14);
		panel.add(total);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(pasajes.getText()) > 0) {
					Cliente cliente1 = null;
					cliente1 = agencia.buscarCliente("111111111");
					if(cliente1 != null) {
						int j=0;
						for(int i = 0; i < 44; i++) {
							if(asientosComprados[i]) {
								agencia.comprarPasaje(bus,cliente1.getRut(), bus.getFecha(), tramo.getSalida(), tramo.getLlegada(), i, tramo.getTarifa());
								j++;
							}
						}
						JOptionPane.showMessageDialog(null, "Se han comprado " + j + " pasajes satisfactoriamente.");
						
						

						BuscarAsiento frame = new BuscarAsiento(agencia, cliente, tramo, bus);
						frame.setVisible(true);
						BuscarAsiento.this.dispose();
							
					}
				}
				else
				JOptionPane.showMessageDialog(null, "Tienes que seleccionar a lo menos un asiento.");
			}
		});
		btnComprar.setBounds(347, 288, 89, 23);
		panel.add(btnComprar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Abrir ventana BuscarBuses
				BuscarBuses frame = new BuscarBuses(agencia,cliente);
				frame.setVisible(true);

				BuscarAsiento.this.dispose();
			}
		});
		btnVolver.setBounds(23, 18, 89, 23);
		panel.add(btnVolver);
		
		JButton asiento1 = new JButton("1");
		asiento1.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(0)) {
			asiento1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento1.getForeground() != Color.BLUE)
					{
						asiento1.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[0] = true;
					}
					else {
						asiento1.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[0] = false;
					}
				}
			});
		}
		else {
			asiento1.setEnabled(false);
		}
		asiento1.setBounds(45, 60, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento1.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento1);
		
		JButton asiento2 = new JButton("2");
		asiento2.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(1)) {
			asiento2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento2.getForeground() != Color.BLUE)
					{
						asiento2.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[1] = true;
					}
					else {
						asiento2.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[1] = false;
					}
				}
			});
		}
		else {
			asiento2.setEnabled(false);
		}
		asiento2.setBounds(80, 60, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento2.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento2);
		
		JButton asiento3 = new JButton("3");
		asiento3.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(2)) {
			asiento3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento3.getForeground() != Color.BLUE)
					{
						asiento3.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[2] = true;
					}
					else {
						asiento3.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[2] = false;
					}
				}
			});
		}
		else {
			asiento3.setEnabled(false);
		}
		asiento3.setBounds(165, 60, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento3.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento3);
		
		JButton asiento4 = new JButton("4");
		asiento4.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(3)) {
			asiento4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento4.getForeground() != Color.BLUE)
					{
						asiento4.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[3] = true;
					}
					else {
						asiento4.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[3] = false;
					}
				}
			});
		}
		else {
			asiento4.setEnabled(false);
		}
		asiento4.setBounds(130, 60, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento4.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento4);
		
		JButton asiento5 = new JButton("5");
		asiento5.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(4)) {
			asiento5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento5.getForeground() != Color.BLUE)
					{
						asiento5.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[4] = true;
					}
					else {
						asiento5.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[4] = false;
					}
				}
			});
		}
		else {
			asiento5.setEnabled(false);
		}
		asiento5.setBounds(45, 95, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento5.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento5);
		
		JButton asiento6 = new JButton("6");
		asiento6.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(5)) {
			asiento6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento6.getForeground() != Color.BLUE)
					{
						asiento6.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[5] = true;
					}
					else {
						asiento6.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[5] = false;
					}
				}
			});
		}
		else {
			asiento6.setEnabled(false);
		}
		asiento6.setBounds(80, 95, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento6.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento6);
		
		JButton asiento7 = new JButton("7");
		asiento7.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(6)) {
			asiento7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento7.getForeground() != Color.BLUE)
					{
						asiento7.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[6] = true;
					}
					else {
						asiento7.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[6] = false;
					}
				}
			});
		}
		else {
			asiento7.setEnabled(false);
		}
		asiento7.setBounds(165, 95, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento7.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento7);
		
		JButton asiento8 = new JButton("8");
		asiento8.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(7)) {
			asiento8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento8.getForeground() != Color.BLUE)
					{
						asiento8.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[7] = true;
					}
					else {
						asiento8.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[7] = false;
					}
				}
			});
		}
		else {
			asiento8.setEnabled(false);
		}
		asiento8.setBounds(130, 95, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento8.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento8);
		
		JButton asiento9 = new JButton("9");
		asiento9.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(8)) {
			asiento9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento9.getForeground() != Color.BLUE)
					{
						asiento9.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[8] = true;
					}
					else {
						asiento9.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[8] = true;
					}
				}
			});
		}
		else {
			asiento9.setEnabled(false);
		}
		asiento9.setBounds(45, 130, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento9.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento9);
		
		JButton asiento10 = new JButton("10");
		asiento10.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(9)) {
			asiento10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento10.getForeground() != Color.BLUE)
					{
						asiento10.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[9] = true;
					}
					else {
						asiento10.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[9] = false;
					}
				}
			});
		}
		else {
			asiento10.setEnabled(false);
		}
		asiento10.setBounds(80, 130, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento10.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento10);
		
		JButton asiento11 = new JButton("11");
		asiento11.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(10)) {
			asiento11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento11.getForeground() != Color.BLUE)
					{
						asiento11.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[10] = true;
					}
					else {
						asiento11.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[10] = false;
					}
				}
			});
		}
		else {
			asiento11.setEnabled(false);
		}
		asiento11.setBounds(165, 130, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento11.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento11);
		
		JButton asiento12 = new JButton("12");
		asiento12.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(11)) {
			asiento12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento12.getForeground() != Color.BLUE)
					{
						asiento12.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[11] = true;
					}
					else {
						asiento12.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[11] = false;
					}
				}
			});
		}
		else {
			asiento12.setEnabled(false);
		}
		asiento12.setBounds(130, 130, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento12.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento12);
		
		JButton asiento13 = new JButton("13");
		asiento13.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(12)) {
			asiento13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento13.getForeground() != Color.BLUE)
					{
						asiento13.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[12] = true;
					}
					else {
						asiento13.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[12] = false;
					}
				}
			});
		}
		else {
			asiento13.setEnabled(false);
		}
		asiento13.setBounds(45, 165, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento13.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento13);
		
		JButton asiento14 = new JButton("14");
		asiento14.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(13)) {
			asiento14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento14.getForeground() != Color.BLUE)
					{
						asiento14.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[13] = true;
					}
					else {
						asiento14.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[13] = false;
					}
				}
			});
		}
		else {
			asiento14.setEnabled(false);
		}
		asiento14.setBounds(80, 165, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento14.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento14);
		
		JButton asiento15 = new JButton("15");
		asiento15.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(14)) {
			asiento15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento15.getForeground() != Color.BLUE)
					{
						asiento15.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[14] = true;
					}
					else {
						asiento15.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[14] = false;
					}
				}
			});
		}
		else {
			asiento15.setEnabled(false);
		}
		asiento15.setBounds(165, 165, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento15.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento15);
		
		JButton asiento16 = new JButton("16");
		asiento16.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(15)) {
			asiento16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento16.getForeground() != Color.BLUE)
					{
						asiento16.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[15] = true;
					}
					else {
						asiento16.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[15] = false;
					}
				}
			});
		}
		else {
			asiento16.setEnabled(false);
		}
		asiento16.setBounds(130, 165, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento16.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento16);
		
		JButton asiento17 = new JButton("17");
		asiento17.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(16)) {
			asiento17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento17.getForeground() != Color.BLUE)
					{
						asiento17.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[16] = true;
					}
					else {
						asiento17.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[16] = false;
					}
				}
			});
		}
		else {
			asiento17.setEnabled(false);
		}
		asiento17.setBounds(45, 200, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento17.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento17);
		
		JButton asiento18 = new JButton("18");
		asiento18.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(17)) {
			asiento18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento18.getForeground() != Color.BLUE)
					{
						asiento18.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[17] = true;
					}
					else {
						asiento18.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[17] = false;
					}
				}
			});
		}
		else {
			asiento18.setEnabled(false);
		}
		asiento18.setBounds(80, 200, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento18.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento18);
		
		JButton asiento19 = new JButton("19");
		asiento19.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(18)) {
			asiento19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento19.getForeground() != Color.BLUE)
					{
						asiento19.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[18] = true;
					}
					else {
						asiento19.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[18] = false;
					}
				}
			});
		}
		else {
			asiento19.setEnabled(false);
		}
		asiento19.setBounds(165, 200, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento19.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento19);
		
		JButton asiento20 = new JButton("20");
		asiento20.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(19)) {
			asiento20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento20.getForeground() != Color.BLUE)
					{
						asiento20.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[19] = true;
					}
					else {
						asiento20.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[19] = false;
					}
				}
			});
		}
		else {
			asiento20.setEnabled(false);
		}
		asiento20.setBounds(130, 200, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento20.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento20);
		
		JButton asiento21 = new JButton("21");
		asiento21.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(20)) {
			asiento21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento21.getForeground() != Color.BLUE)
					{
						asiento21.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[20] = true;
					}
					else {
						asiento21.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[20] = false;
					}
				}
			});
		}
		else {
			asiento21.setEnabled(false);
		}
		asiento21.setBounds(45, 235, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento21.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento21);
		
		JButton asiento22 = new JButton("22");
		asiento22.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(21)) {
			asiento22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento22.getForeground() != Color.BLUE)
					{
						asiento22.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[21] = true;
					}
					else {
						asiento22.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[21] = false;
					}
				}
			});
		}
		else {
			asiento22.setEnabled(false);
		}
		asiento22.setBounds(80, 235, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento22.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento22);
		
		JButton asiento23 = new JButton("23");
		asiento23.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(22)) {
			asiento23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento23.getForeground() != Color.BLUE)
					{
						asiento23.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[22] = true;
					}
					else {
						asiento23.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[22] = false;
					}
				}
			});
		}
		else {
			asiento23.setEnabled(false);
		}
		asiento23.setBounds(165, 235, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento23.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento23);
		
		JButton asiento24 = new JButton("24");
		asiento24.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(23)) {
			asiento24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento24.getForeground() != Color.BLUE)
					{
						asiento24.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[23] = true;
					}
					else {
						asiento24.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[23] = false;
					}
				}
			});
		}
		else {
			asiento24.setEnabled(false);
		}
		asiento24.setBounds(130, 235, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento24.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento24);
		
		JButton asiento25 = new JButton("25");
		asiento25.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(24)) {
			asiento25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento25.getForeground() != Color.BLUE)
					{
						asiento25.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[24] = true;
					}
					else {
						asiento25.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[24] = false;
					}
				}
			});
		}
		else {
			asiento25.setEnabled(false);
		}
		asiento25.setBounds(45, 270, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento25.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento25);
		
		JButton asiento26 = new JButton("26");
		asiento26.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(25)) {
			asiento26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento26.getForeground() != Color.BLUE)
					{
						asiento26.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[25] = true;
					}
					else {
						asiento26.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[25] = false;
					}
				}
			});
		}
		else {
			asiento26.setEnabled(false);
		}
		asiento26.setBounds(80, 270, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento26.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento26);
		
		JButton asiento27 = new JButton("27");
		asiento27.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(26)) {
			asiento27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento27.getForeground() != Color.BLUE)
					{
						asiento27.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[26] = true;
					}
					else {
						asiento27.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[26] = false;
					}
				}
			});
		}
		else {
			asiento27.setEnabled(false);
		}
		asiento27.setBounds(165, 270, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento27.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento27);
		
		JButton asiento28 = new JButton("28");
		asiento28.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(27)) {
			asiento28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento28.getForeground() != Color.BLUE)
					{
						asiento28.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[27] = true;
					}
					else {
						asiento28.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[27] = false;
					}
				}
			});
		}
		else {
			asiento28.setEnabled(false);
		}
		asiento28.setBounds(130, 270, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento28.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento28);
		
		JButton asiento29 = new JButton("29");
		asiento29.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(28)) {
			asiento29.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento29.getForeground() != Color.BLUE)
					{
						asiento29.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[28] = true;
					}
					else {
						asiento29.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[28] = false;
					}
				}
			});
		}
		else {
			asiento29.setEnabled(false);
		}
		asiento29.setBounds(45, 305, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento29.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento29);
		
		JButton asiento30 = new JButton("30");
		asiento30.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(29)) {
			asiento30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento30.getForeground() != Color.BLUE)
					{
						asiento30.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[29] = true;
					}
					else {
						asiento30.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[29] = false;
					}
				}
			});
		}
		else {
			asiento30.setEnabled(false);
		}
		asiento30.setBounds(80, 305, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento30.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento30);
		
		JButton asiento31 = new JButton("31");
		asiento31.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(30)) {
			asiento31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento31.getForeground() != Color.BLUE)
					{
						asiento31.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[30] = true;
					}
					else {
						asiento31.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[30] = false;
					}
				}
			});
		}
		else {
			asiento31.setEnabled(false);
		}
		asiento31.setBounds(165, 305, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento31.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento31);
		
		JButton asiento32 = new JButton("32");
		asiento32.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(31)) {
			asiento32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento32.getForeground() != Color.BLUE)
					{
						asiento32.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[31] = true;
					}
					else {
						asiento32.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[31] = false;
					}
				}
			});
		}
		else {
			asiento32.setEnabled(false);
		}
		asiento32.setBounds(130, 305, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento32.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento32);
		
		JButton asiento33 = new JButton("33");
		asiento33.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(32)) {
			asiento33.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento33.getForeground() != Color.BLUE)
					{
						asiento33.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[32] = true;
					}
					else {
						asiento33.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[32] = false;
					}
				}
			});
		}
		else {
			asiento33.setEnabled(false);
		}
		asiento33.setBounds(45, 340, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento33.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento33);
		
		JButton asiento34 = new JButton("34");
		asiento34.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(33)) {
			asiento34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento34.getForeground() != Color.BLUE)
					{
						asiento34.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[33] = true;
					}
					else {
						asiento34.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[33] = false;
					}
				}
			});
		}
		else {
			asiento34.setEnabled(false);
		}
		asiento34.setBounds(80, 340, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento34.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento34);
		
		JButton asiento35 = new JButton("35");
		asiento35.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(34)) {
			asiento35.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento35.getForeground() != Color.BLUE)
					{
						asiento35.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[34] = true;
					}
					else {
						asiento35.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[34] = false;
					}
				}
			});
		}
		else {
			asiento35.setEnabled(false);
		}
		asiento35.setBounds(165, 340, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento35.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento35);
		
		JButton asiento36 = new JButton("36");
		asiento36.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(35)) {
			asiento36.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento36.getForeground() != Color.BLUE)
					{
						asiento36.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[35] = true;
					}
					else {
						asiento36.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[35] = false;
					}
				}
			});
		}
		else {
			asiento36.setEnabled(false);
		}
		asiento36.setBounds(130, 340, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento36.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento36);
		
		JButton asiento37 = new JButton("37");
		asiento37.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(36)) {
			asiento37.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento37.getForeground() != Color.BLUE)
					{
						asiento37.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[36] = true;
					}
					else {
						asiento37.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[36] = false;
					}
				}
			});
		}
		else {
			asiento37.setEnabled(false);
		}
		asiento37.setBounds(45, 375, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento37.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento37);
		
		JButton asiento38 = new JButton("38");
		asiento38.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(37)) {
			asiento38.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento38.getForeground() != Color.BLUE)
					{
						asiento38.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[37] = true;
					}
					else {
						asiento38.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[37] = false;
					}
				}
			});
		}
		else {
			asiento38.setEnabled(false);
		}
		asiento38.setBounds(80, 375, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento38.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento38);
		
		JButton asiento39 = new JButton("39");
		asiento39.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(38)) {
			asiento39.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento39.getForeground() != Color.BLUE)
					{
						asiento39.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[38] = true;
					}
					else {
						asiento39.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[38] = false;
					}
				}
			});
		}
		else {
			asiento39.setEnabled(false);
		}
		asiento39.setBounds(165, 375, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento39.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento39);
		
		JButton asiento40 = new JButton("40");
		asiento40.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(39)) {
			asiento40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento40.getForeground() != Color.BLUE)
					{
						asiento40.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[39] = true;
					}
					else {
						asiento40.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[39] = false;
					}
				}
			});
		}
		else {
			asiento40.setEnabled(false);
		}
		asiento40.setBounds(130, 375, 30, 25);
//		asiento44.setBounds(290, 410, 30, 25);
		asiento40.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento40);
		
		JButton asiento41 = new JButton("41");
		asiento41.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(40)) {
			asiento41.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento41.getForeground() != Color.BLUE)
					{
						asiento41.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[40] = true;
					}
					else {
						asiento41.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[40] = false;
					}
				}
			});
		}
		else {
			asiento41.setEnabled(false);
		}
		asiento41.setBounds(45, 410, 30, 25);
//		asiento41.setBounds(400, 410, 30, 25);
		asiento41.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento41);
		
		JButton asiento42 = new JButton("42");
		asiento42.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(41)) {
			asiento42.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento42.getForeground() != Color.BLUE)
					{
						asiento42.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[41] = true;
					}
					else {
						asiento42.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[41] = false;
					}
				}
			});
		}
		else {
			asiento42.setEnabled(false);
		}
		asiento42.setBounds(80, 410, 30, 25);
//		asiento42.setBounds(375, 410, 30, 25);
		asiento42.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento42);
		
		JButton asiento43 = new JButton("43");
		asiento43.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(42)) {
			asiento43.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento43.getForeground() != Color.BLUE)
					{
						asiento43.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[42] = true;
					}
					else {
						asiento43.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[42] = false;
					}
				}
			});
		}
		else {
			asiento43.setEnabled(false);
		}
		asiento43.setBounds(165, 410, 30, 25);
//		asiento43.setBounds(350, 410, 30, 25);
		asiento43.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento43);
		
		JButton asiento44 = new JButton("44");
		asiento44.setFont(new Font("Tahoma", Font.BOLD, 11));
		if(bus.revisarAsientos(43)) {
			asiento44.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(asiento44.getForeground() != Color.BLUE)
					{
						asiento44.setForeground(Color.BLUE);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) + 1));
						total.setText("" + (Integer.parseInt(total.getText()) + tramo.getTarifa()));
						asientosComprados[43] = true;
					}
					else {
						asiento44.setForeground(Color.BLACK);
						pasajes.setText("" + (Integer.parseInt(pasajes.getText()) - 1));
						total.setText("" + (Integer.parseInt(total.getText()) - tramo.getTarifa()));
						asientosComprados[43] = false;
					}
				}
			});
		}
		else {
			asiento44.setEnabled(false);
		}
		asiento44.setBounds(130, 410, 30, 25);
//		asiento44.setBounds(290, 410, 30, 25);
		asiento44.setMargin(new Insets(2, 2, 2, 2));
		panel.add(asiento44);
		
		panel.setLayout(null);
		
		JLabel infoBus = new JLabel(tramo.getSalida().getLugar() + "-" + tramo.getLlegada().getLugar());
		infoBus.setBounds(178, 22, 201, 14);
		panel.add(infoBus);
		
		JButton btnVolverAlMenu = new JButton("volver al Menu Principal");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuPrincipal frame = new MenuPrincipal(agencia);
				frame.setVisible(true);
				
				BuscarAsiento.this.dispose();
			}
		});
		btnVolverAlMenu.setBounds(414, 18, 167, 23);
		panel.add(btnVolverAlMenu);
		
	}
}

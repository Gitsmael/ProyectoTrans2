package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class Vista extends JFrame {

	public JPanel contentPane, panelPrincipal;
	public JButton btnNewButton;
	public JButton btnGenerarInformes;
	public JPanel panelGeneracion;
	public JPanel panel_mostrar;
	public JPanel panel_2;
	public JPanel panel_3;
	public JPanel panel_4;
	public JButton btnColaboradorestoCSV;
	public JProgressBar progresoGenerador;
	public Button home;
	public JPanel panel;
	public JList listCreadores;
	public JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista vista = new Vista();
					Controlador controlador = new Controlador(vista);
					vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 577);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelGeneracion = new JPanel();
		panelGeneracion.setBackground(Color.WHITE);
		panelGeneracion.setBounds(0, 0, 664, 538);
		contentPane.add(panelGeneracion);
		panelGeneracion.setVisible(false);
		panelGeneracion.setLayout(null);
		
		btnColaboradorestoCSV = new JButton("Generar archivo CSV de las colaboraciones");
		btnColaboradorestoCSV.setBounds(32, 130, 291, 47);
		panelGeneracion.add(btnColaboradorestoCSV);
		
		progresoGenerador = new JProgressBar();
		progresoGenerador.setBounds(85, 398, 221, 24);
		panelGeneracion.add(progresoGenerador);
		
		home = new Button("");
		home.setBounds(606, 0, 58, 56);
		panelGeneracion.add(home);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(458, 77, 169, 226);
		panelGeneracion.add(scrollPane);
		
		listCreadores = new JList();
		scrollPane.setViewportView(listCreadores);
		listCreadores.setBackground(Color.LIGHT_GRAY);
		
		panel_mostrar = new JPanel();
		panel_mostrar.setBackground(Color.WHITE);
		panel_mostrar.setBounds(0, 0, 664, 538);
		contentPane.add(panel_mostrar);
		panel_mostrar.setVisible(false);
		panel_mostrar.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 310, 664, 228);
		panel_mostrar.add(panel);
		panel.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBounds(0, 0, 664, 538);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		btnGenerarInformes = new JButton("Reportes JSON/CSV");
		btnGenerarInformes.setBounds(61, 180, 213, 39);
		panelPrincipal.add(btnGenerarInformes);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 664, 538);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 664, 538);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 664, 552);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		

		
	}
}

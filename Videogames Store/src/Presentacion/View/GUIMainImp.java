/**
 * 
 */
package _2.Diseño.Presentacion.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIMainImp extends GUIMain {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
	public GUIMainImp() {
		super();
		contentPanel = new JPanel();
		contentPanel.setVisible(true);
		contentPanel.setBackground(new Color(192, 217, 252));
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private void initGUI() {
		setTitle("Pantalla Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 450, 360);

		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblMenuPrincipal = new JLabel("GAME STORE");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Arial", Font.BOLD, 18));
		lblMenuPrincipal.setBounds(125, 10, 200, 23);
		contentPanel.add(lblMenuPrincipal);
		
		// Products
		JLabel lblProducts = new JLabel("Products");
		lblProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducts.setFont(new Font("Arial", Font.BOLD, 14));
		lblProducts.setBounds(30, 145, 120, 14);
		contentPanel.add(lblProducts);
		
		JButton btnProducts = new JButton("");
		btnProducts.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { Controller.getInstance().action(new Context(Events.CREATE_GUI_PRODUCT, null)); } });
		btnProducts.setBounds(30, 40, 120, 100);
		btnProducts.setIcon(new ImageIcon(new ImageIcon("image//videojuego.png") //https://www.flaticon.es
				.getImage().getScaledInstance(btnProducts.getWidth(), btnProducts.getHeight(), Image.SCALE_DEFAULT)));
		contentPanel.add(btnProducts);
		
		//Tickets
		JLabel lblTickets = new JLabel("Tickets");
		lblTickets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTickets.setFont(new Font("Arial", Font.BOLD, 14));
		lblTickets.setBounds(160, 145, 120, 14);
		contentPanel.add(lblTickets);
		
		
		JButton btnTickets = new JButton("");
		btnTickets.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { Controller.getInstance().action(new Context(Events.CREATE_GUI_TICKET, null)); } });
		btnTickets.setBounds(160, 40, 120, 100);
		btnTickets.setIcon(new ImageIcon(new ImageIcon("image//factura.png") //https://www.flaticon.es
				.getImage().getScaledInstance(btnTickets.getWidth(), btnTickets.getHeight(), Image.SCALE_DEFAULT)));
		contentPanel.add(btnTickets);
		
		//Clients
		JLabel lblClients = new JLabel("Clients");
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setFont(new Font("Arial", Font.BOLD, 14));
		lblClients.setBounds(290, 145, 120, 14);
		contentPanel.add(lblClients);
		
		JButton btnClients = new JButton("");
		btnClients.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { Controller.getInstance().action(new Context(Events.CREATE_GUI_CLIENT, null)); } });
		btnClients.setBounds(290, 40, 120, 100);
		btnClients.setIcon(new ImageIcon(new ImageIcon("image//clasificacion.png") //https://www.flaticon.es
				.getImage().getScaledInstance(btnClients.getWidth(), btnClients.getHeight(), Image.SCALE_DEFAULT)));
		contentPanel.add(btnClients);
		
		//Companies
		JLabel lblCompanies = new JLabel("Companies");
		lblCompanies.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompanies.setFont(new Font("Arial", Font.BOLD, 14));
		lblCompanies.setBounds(30, 285, 120, 14);
		contentPanel.add(lblCompanies);
		
		JButton btnCompanies = new JButton("");
		btnCompanies.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { Controller.getInstance().action(new Context(Events.CREATE_GUI_COMPANY, null)); } });
		btnCompanies.setBounds(30, 180, 120, 100);
		btnCompanies.setIcon(new ImageIcon(new ImageIcon("image//edificios.png") //https://www.flaticon.es
				.getImage().getScaledInstance(btnCompanies.getWidth(), btnCompanies.getHeight(), Image.SCALE_DEFAULT)));
		contentPanel.add(btnCompanies);
		
		//Employees
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployees.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmployees.setBounds(160, 285, 120, 14);
		contentPanel.add(lblEmployees);
		
		JButton btnEmployees = new JButton("");
		btnEmployees.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { Controller.getInstance().action(new Context(Events.CREATE_GUI_EMPLOYEES, null)); } });
		btnEmployees.setBounds(160, 180, 120, 100);
		btnEmployees.setIcon(new ImageIcon(new ImageIcon("image//empleado.png") //https://www.flaticon.es
				.getImage().getScaledInstance(btnEmployees.getWidth(), btnEmployees.getHeight(), Image.SCALE_DEFAULT)));
		contentPanel.add(btnEmployees);
		
		//Fairs
		JLabel lblFairs = new JLabel("Fairs");
		lblFairs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFairs.setFont(new Font("Arial", Font.BOLD, 14));
		lblFairs.setBounds(290, 285, 120, 14);
		contentPanel.add(lblFairs);
		
		JButton btnFairs = new JButton("");
		btnFairs.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { Controller.getInstance().action(new Context(Events.CREATE_GUI_FAIR, null)); } });
		btnFairs.setBounds(290, 180, 120, 100);
		btnFairs.setIcon(new ImageIcon(new ImageIcon("image//destacar.png") //https://www.flaticon.es
				.getImage().getScaledInstance(btnFairs.getWidth(), btnFairs.getHeight(), Image.SCALE_DEFAULT)));
		contentPanel.add(btnFairs);
	}

	@Override
	public void update(Context context) {
		initGUI();
	}
}
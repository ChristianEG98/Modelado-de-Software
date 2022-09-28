package _2.Diseño.Presentacion.Employees;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Company.imp.Company;
import _2.Diseño.Negocio.Company.imp.TCompany;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

public class GUICreateEmployees extends GUIEmployees {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textName;
	private JTextField textLastName;
	private JTextField textDni;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textPayRoll;
	private JTextField textCompany;
	
	private JRadioButton buttonFullTimeEmployees;
	private JRadioButton buttonPartTimeEmployees;
	private JPanel contentPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JLabel lblHours;
	private JLabel lblBonus;
	private JTextField textBonus;
	private JTextField textHours;
	
	 public GUICreateEmployees() {
		// TODO Auto-generated constructor stub
		 super();
		 setResizable(false);
		 initGUI();
		 this.setLocationRelativeTo(null);
	}
	
	 private void initGUI() {
			setTitle("Create Employees");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 390);
			contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPanel);
			contentPanel.setLayout(null);
			
			JLabel lblDni = new JLabel("Dni:");
			lblDni.setBounds(10, 16, 94, 14);
			contentPanel.add(lblDni);
			
			textDni = new JTextField();
			textDni.setBounds(114, 8, 310, 30);
			contentPanel.add(textDni);
			textDni.setColumns(10);
			
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(10, 53, 94, 14);
			contentPanel.add(lblName);
			
			textName = new JTextField();
			textName.setBounds(114, 45, 310, 30);
			contentPanel.add(textName);
			textName.setColumns(10);
			
			JLabel lblLastName = new JLabel("Last Name:");
			lblLastName.setBounds(10, 88, 94, 14);
			contentPanel.add(lblLastName);
			
			textLastName = new JTextField();
			textLastName.setBounds(114, 80, 310, 30);
			contentPanel.add(textLastName);
			textLastName.setColumns(10);
			
			JLabel lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(10, 123, 94, 14);
			contentPanel.add(lblPhone);
			
			textPhone = new JTextField();
			textPhone.setBounds(114, 115, 310, 30);
			contentPanel.add(textPhone);
			textPhone.setColumns(10);
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(10, 160, 94, 14);
			contentPanel.add(lblEmail);
			
			textEmail = new JTextField();
			textEmail.setBounds(114, 150, 310, 30);
			contentPanel.add(textEmail);
			textEmail.setColumns(10);
			
			JLabel lblPayRoll = new JLabel("Euro/hour:");
			lblPayRoll.setBounds(10, 196, 94, 14);
			contentPanel.add(lblPayRoll);
			
			textPayRoll = new JTextField();
			textPayRoll.setBounds(114, 185, 310, 30);
			contentPanel.add(textPayRoll);
			textPayRoll.setColumns(10);
			
			lblHours = new JLabel("Hours:");
			lblHours.setBounds(10, 295, 118, 14);
			contentPanel.add(lblHours);
			lblHours.setVisible(false);
			
			textHours = new JTextField();
			textHours.setBounds(114, 290, 310, 30);
			contentPanel.add(textHours);
			textHours.setColumns(10);
			textHours.setVisible(false);
			
			lblBonus = new JLabel("Bonus:");
			lblBonus.setBounds(10, 295, 118, 14);
			contentPanel.add(lblBonus);
			lblBonus.setVisible(false);
			
			textBonus = new JTextField();
			textBonus.setBounds(114, 290, 310, 30);
			contentPanel.add(textBonus);
			textBonus.setColumns(10);
			textBonus.setVisible(false);
			
			JLabel lblCompany = new JLabel("Company:");
			lblCompany.setBounds(10, 230, 94, 14);
			contentPanel.add(lblCompany);
			
			textCompany = new JTextField();
			textCompany.setBounds(114, 220, 310, 30);
			contentPanel.add(textCompany);
			textCompany.setColumns(10);
			
			
			buttonFullTimeEmployees = new JRadioButton("Full Time Employees");
	    	buttonFullTimeEmployees.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	lblHours.setVisible(false);
	            	textHours.setVisible(false);
	            	
	            	lblBonus.setVisible(true);
	            	textBonus.setVisible(true);
	            	
	            }
	        });
			buttonGroup.add(buttonFullTimeEmployees);
			buttonFullTimeEmployees.setBounds(40, 260, 165, 23);
			contentPanel.add(buttonFullTimeEmployees);
			
			buttonPartTimeEmployees = new JRadioButton("Part Time Employees");
			buttonPartTimeEmployees.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	lblHours.setVisible(true);
	            	textHours.setVisible(true);
	            		            	
	            	lblBonus.setVisible(false);
	            	textBonus.setVisible(false);
	            	
	            	
	            }
	        });
			buttonGroup.add(buttonPartTimeEmployees);
			buttonPartTimeEmployees.setBounds(230, 260, 165, 23);
			contentPanel.add(buttonPartTimeEmployees);
			
			
			
			JButton btnOk = new JButton("Create");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						
						boolean error = false;
						String name = textName.getText();
						String lastname = textLastName.getText();
						String dni = textDni.getText();
						String email = textEmail.getText();
						int phone = Integer.parseInt(textPhone.getText());
						Float payroll = Float.parseFloat(textPayRoll.getText());
						int company = Integer.parseInt(textCompany.getText());
						TCompany comp= new TCompany(company, " ", " ", 0, true);
						
						int hours= 0;
						Float bonus= 0.0f;
						
						if(name.equals("") ||lastname.equals("") ||email.equals("") || phone < 0 || payroll < 0 || company<0){
							JOptionPane.showMessageDialog(new JFrame(), "There can be no empty fileds", "Error",
									JOptionPane.ERROR_MESSAGE);
							error = true;
						}
						
						if (dni.length()!=9){
							JOptionPane.showMessageDialog(new JFrame(), "The DNI must have 9 characters", "Error",
									JOptionPane.ERROR_MESSAGE);
							error = true;
						}
		
						if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email)) {
							JOptionPane.showMessageDialog(new JFrame(), "The email is invalid. Ej: aaa@aaa.com", "Error",
									JOptionPane.ERROR_MESSAGE);
							error = true;
						}				
						
						if(buttonFullTimeEmployees.isSelected()){
							bonus = Float.parseFloat(textBonus.getText());
							if (bonus<0)
							{
								JOptionPane.showMessageDialog(new JFrame(), "The bonus cannot be negative", "Error",
										JOptionPane.ERROR_MESSAGE);
								error = true;
							}
							
							
						} else if (buttonPartTimeEmployees.isSelected()) {
							hours = Integer.parseInt(textHours.getText());
							
							
							if (hours < 0 ) {
								JOptionPane.showMessageDialog(new JFrame(), "The number of hours cannot be negative",
										"Error", JOptionPane.ERROR_MESSAGE);
								error = true;
							}
						}
						if (error) {
							JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							if (buttonFullTimeEmployees.isSelected()) {
								TFullTimeEmployees tFulltimeemployees= new TFullTimeEmployees( dni,name, lastname, phone, email, payroll, true,  new Company (comp),bonus);
								Controller.getInstance().action(new Context(Events.CREATE_EMPLOYEES, tFulltimeemployees));
								
								
							} else if (buttonPartTimeEmployees.isSelected()) {
								TPartTimeEmployees tParttimeemployees = new TPartTimeEmployees( dni,name, lastname, phone, email, payroll, true,new Company (comp), hours);
								Controller.getInstance().action(new Context(Events.CREATE_EMPLOYEES, tParttimeemployees));
							}
						}
					}
					catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnOk.setBounds(335, 330, 89, 23);
			contentPanel.add(btnOk);
			
			JButton btnExit = new JButton("Close");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnExit.setBounds(20, 330, 89, 23);
			contentPanel.add(btnExit);
			
			
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			
	 }
	
	

	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch(context.getEvent()){
		case Events.CREATE_EMPLOYEES_OK:
			JOptionPane.showMessageDialog(null, "Employees " + context.getDetails() + " create.");
			this.dispose();
			break;
		case Events.CREATE_EMPLOYEES_KO:
			if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "That employee already exists");
			}
			else if ((int) context.getDetails() == -1)
				JOptionPane.showMessageDialog(null, "Company not found");
		else{
				JOptionPane.showMessageDialog(null, "Error creating employee");
			}
			break;
		}
	}
	
	public void clearData() {
		textName.setText("");
		textLastName.setText("");
		textDni.setText("");
		textEmail.setText("");
		textPhone.setText("");
		textPayRoll.setText("");
		textBonus.setText("");
		textHours.setText("");
		textCompany.setText("");
		
		lblBonus.setVisible(false);
		lblHours.setVisible(false);
		textBonus.setVisible(false);
		textHours.setVisible(false);
		
		buttonFullTimeEmployees.setSelected(false);
		buttonPartTimeEmployees.setSelected(false);
		buttonGroup.clearSelection();
	}

}

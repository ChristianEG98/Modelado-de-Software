package _2.Diseño.Presentacion.Employees;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Company.imp.Company;
import _2.Diseño.Negocio.Company.imp.TCompany;
import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

public class GUIModifyEmployees extends GUIEmployees {

	private static final long serialVersionUID = 1L;
	
	private int idEmployees;
	private JTextField textIdEmployees;
	private JPanel contentPane;
	
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textDni;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textPayRoll;
	private JTextField textCompany;
	
	private JLabel lblBonus;
	private JLabel lblHours;
	private JTextField textBonus;
	private JTextField textHours;
	private JButton btnModify;
	private TEmployees tEmployees;
	
	
	public GUIModifyEmployees(){
		super();
		contentPane=new JPanel();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("MODIFY EMPLOYEES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblID = new JLabel("Employee id");
		lblID.setBounds(54, 25, 100, 14);
		contentPane.add(lblID);

		textIdEmployees = new JTextField();
		textIdEmployees.setBounds(163, 23, 96, 20);
		contentPane.add(textIdEmployees);
		textIdEmployees.setColumns(10);
		

		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(54, 62, 53, 14);
		contentPane.add(lblDni);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(54, 87, 53, 14);
		contentPane.add(lblName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(54, 112, 73, 14);
		contentPane.add(lblLastName);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(54, 137, 83, 14);
		contentPane.add(lblPhone);

		JLabel lblPayRoll = new JLabel("Euro/hour");
		lblPayRoll.setBounds(54, 162, 60, 14);
		contentPane.add(lblPayRoll);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(54, 187, 53, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(54, 212, 53, 14);
		contentPane.add(lblCompany);

		lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(54,237, 53, 14);
		contentPane.add(lblBonus);

		lblHours = new JLabel("Hours");
		lblHours.setBounds(54, 237, 100, 14);
		contentPane.add(lblHours);

		textDni = new JTextField();
		textDni.setBounds(163, 62, 96, 20);
		textDni.setEditable(false);
		contentPane.add(textDni);
		textDni.setColumns(10);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(163, 87, 96, 20);
		textName.setEditable(false);
		contentPane.add(textName);

		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(163, 112, 96, 20);
		textLastName.setEditable(false);
		contentPane.add(textLastName);

		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(163, 137, 96, 20);
		textPhone.setEditable(false);
		contentPane.add(textPhone);

		textPayRoll = new JTextField();
		textPayRoll.setColumns(10);
		textPayRoll.setBounds(163, 162, 96, 20);
		textPayRoll.setEditable(false);
		contentPane.add(textPayRoll);
		
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(163, 187, 96, 20);
		textEmail.setEditable(false);
		contentPane.add(textEmail);
		
		
		textCompany = new JTextField();
		textCompany.setColumns(10);
		textCompany.setBounds(163, 212, 96, 20);
		textCompany.setEditable(false);
		contentPane.add(textCompany);
		

		textBonus = new JTextField();
		textBonus.setColumns(10);
		textBonus.setBounds(163, 237, 96, 20);
		textBonus.setEditable(false);
		contentPane.add(textBonus);

		textHours = new JTextField();
		textHours.setColumns(10);
		textHours.setBounds(163, 237, 96, 20);
		textHours.setEditable(false);
		contentPane.add(textHours);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(290, 23, 75, 20);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					idEmployees = Integer.parseInt(textIdEmployees.getText());

					if (idEmployees < 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Wrong information (Id has to be greater than 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_MODIFY_EMPLOYEES, idEmployees));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnSearch);

		 btnModify = new JButton("Modify");
		btnModify.setBounds(315, 237, 89, 23);
		btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String name = textName.getText();
					String lastname = textLastName.getText();
					String dni = textDni.getText();
					String email = textEmail.getText();
					int phone = Integer.parseInt(textPhone.getText());
					Float payroll = Float.parseFloat(textPayRoll.getText());
					int idComapny = Integer.parseInt(textCompany.getText());
					int hours= 0;
					Float bonus= 0.0f;
					
					if (name.equals("") || lastname.equals(""))
						JOptionPane.showMessageDialog(new JFrame(), "There can be no empty fields", "Error",
								JOptionPane.ERROR_MESSAGE);
					if (phone==9)
						JOptionPane.showMessageDialog(new JFrame(), "The phone must have 9 digits", "Error",
								JOptionPane.ERROR_MESSAGE);
					if (payroll< 0)
						JOptionPane.showMessageDialog(new JFrame(), "Salary cannot be negative", "Error",
								JOptionPane.ERROR_MESSAGE);

					if (dni.length() != 9)
						JOptionPane.showMessageDialog(new JFrame(), "The DNI mut have 9 characters", "Error",
								JOptionPane.ERROR_MESSAGE);
					
					if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",email)) {
						JOptionPane.showMessageDialog(new JFrame(), "The email is invalid. Ej: aaa@aaa.com", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					if (tEmployees instanceof TFullTimeEmployees) {
						bonus = Float.parseFloat(textBonus.getText());
						if (bonus < 0)
							JOptionPane.showMessageDialog(new JFrame(), "The bonus cannot be negative", "Error",
									JOptionPane.ERROR_MESSAGE);
					}
					if (tEmployees instanceof TPartTimeEmployees) {
						hours = Integer.parseInt(textHours.getText());
						if (hours < 0)
							JOptionPane.showMessageDialog(new JFrame(), "The number of hours cannot be negative",
									"Error", JOptionPane.ERROR_MESSAGE);
					}
					TCompany company = new TCompany(idComapny, ""," ", 0,
							true);

					if (tEmployees instanceof TFullTimeEmployees) {
						TFullTimeEmployees tNewEmployees = new TFullTimeEmployees( idEmployees,dni,name, lastname, phone, email, payroll, true,  new Company (company),bonus);
						Controller.getInstance().action(new Context(Events.MODIFY_EMPLOYEES, tNewEmployees));
					}
					if (tEmployees instanceof TPartTimeEmployees) {
						TPartTimeEmployees tNewEmployees = new TPartTimeEmployees(idEmployees, dni,name, lastname, phone, email, payroll, true,new Company (company), hours);
						Controller.getInstance().action(new Context(Events.MODIFY_EMPLOYEES, tNewEmployees));
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnModify);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(315, 210, 89, 23);
		contentPane.add(btnClose);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

	}
	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch(context.getEvent()){
			case Events.MODIFY_EMPLOYEES_OK:
				JOptionPane.showMessageDialog(null, "Employees " + context.getDetails() + " successfully modified.");
				this.dispose();
				break;
			case Events.MODIFY_EMPLOYEES_KO:
				if((int)context.getDetails() == -1){
					JOptionPane.showMessageDialog(null, "The DNI already exists");
				}
				else if((int)context.getDetails() == -2){
					JOptionPane.showMessageDialog(null, "The employees is not active");
				}
				else if((int)context.getDetails() == -3){
					JOptionPane.showMessageDialog(null, "The employee does not exist");
				}
				else{
					JOptionPane.showMessageDialog(null, "Company not found");
				}
				
				break;
			case Events.SEARCH_MODIFY_EMPLOYEES_OK:
				tEmployees = (TEmployees) context.getDetails();
				textName.setEditable(true);
				textLastName.setEditable(true);
				textDni.setEditable(true);
				textPhone.setEditable(true);
				textEmail.setEditable(true);
				textPayRoll.setEditable(true);
				textCompany.setEditable(true);
				btnModify.setEnabled(true);
				
				
				textName.setText(tEmployees.getName());
				textLastName.setText(tEmployees.getLastName()+"");
				textDni.setText(tEmployees.getDni()+"");
				textPhone.setText(tEmployees.getPhone()+"");
				textEmail.setText(tEmployees.getEmail()+"");
				textPayRoll.setText(tEmployees.getPayroll()+"");
				textCompany.setText(tEmployees.getCompany().getIdCompany()+"");
				
				if(tEmployees instanceof TFullTimeEmployees){	
					lblBonus.setVisible(true);
					textBonus.setVisible(true);
					textBonus.setEditable(true);
					textBonus.setText(((TFullTimeEmployees) tEmployees).getBonus()+"");		
					lblHours.setVisible(false);
					textHours.setVisible(false);
					
				}
				if(tEmployees instanceof TPartTimeEmployees){
					textHours.setVisible(true);
					textHours.setEditable(true);
					lblHours.setVisible(true);
					lblBonus.setVisible(false);			
					textBonus.setVisible(false);
					
					textHours.setText(((TPartTimeEmployees) tEmployees).getHours()+"");
					
					
					
				}
				break;
			case Events.SEARCH_MODIFY_EMPLOYEES_KO:
				JOptionPane.showMessageDialog(null, "Error searching employees");
				break;
		}
	}
	
	public void clearData() {		
		lblBonus.setVisible(false);
    	textBonus.setVisible(false);
    	lblHours.setVisible(false);
    	textHours.setVisible(false);
    	textHours.setEditable(false);
    	textBonus.setEditable(false);
    	textPhone.setEditable(false);
    	textDni.setEditable(false);
    	textEmail.setEditable(false);
    	textName.setEditable(false);
    	textLastName.setEditable(false);
    	textPayRoll.setEditable(false);
    	textCompany.setEditable(false);
    	
    	textIdEmployees.setText("");
    	textName.setText("");
    	textLastName.setText("");
    	textDni.setText("");
    	textEmail.setText("");
    	textPayRoll.setText("");
    	textPhone.setText("");
    	textBonus.setText("");
    	textHours.setText("");
    	textCompany.setText("");    	
	}


}

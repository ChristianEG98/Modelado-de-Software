package _2.Diseño.Presentacion.Employees;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;


public class GUISearchEmployees extends GUIEmployees {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private JTextField textIdEmployees;
	private JPanel contentPane;
	
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textDni;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textPayRoll;
	private JTextField textCompany;
	private JTextField activeType;
	private JTextField nonActiveType;
	
	private JLabel lblBonus;
	private JLabel lblHours;
	private JTextField textBonus;
	private JTextField textHours;
	
	public GUISearchEmployees() {
		// TODO Auto-generated constructor stub
	
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	 
	 private void initGUI() {
			// begin-user-code
			// TODO Auto-generated method stub
			// end-user-code
			setTitle("Search Employees");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			setBounds(100, 100, 450, 380);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			
			JLabel lblIdEmployees = new JLabel("Id Employees:");
			lblIdEmployees .setBounds(10, 23, 90, 14);
			contentPane.add(lblIdEmployees);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 50, 424, 2);
			contentPane.add(separator);
			
			textIdEmployees = new JTextField();
			textIdEmployees.setBounds(140, 20, 150, 20);
			contentPane.add(textIdEmployees);
			textIdEmployees.setColumns(10);
			
		
			
			JLabel lblDni = new JLabel("Dni:");
			lblDni.setBounds(10, 67, 90, 14);
			contentPane.add(lblDni);
			textDni = new JTextField();
			textDni.setEditable(false);
			textDni.setBounds(140, 64, 150, 20);
			contentPane.add(textDni);
			textDni.setColumns(10);
			
			
			JLabel lblName = new JLabel("Name:");
			lblName.setBounds(10, 98, 90, 14);
			contentPane.add(lblName);
			textName = new JTextField();
			textName.setEditable(false);
			textName.setBounds(140, 95, 150, 20);
			contentPane.add(textName);
			textName.setColumns(10);
			
			JLabel lblLastName = new JLabel("Last Name:");
			lblLastName.setBounds(10, 129, 90, 14);
			contentPane.add(lblLastName);
			textLastName = new JTextField();
			textLastName.setEditable(false);
			textLastName.setBounds(140, 126, 150, 20);
			contentPane.add(textLastName);
			textLastName.setColumns(10);
			
			JLabel lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(10, 160, 90, 14);
			contentPane.add(lblPhone);
			textPhone = new JTextField();
			textPhone.setEditable(false);
			textPhone.setBounds(140, 157, 150, 20);
			contentPane.add(textPhone);
			textPhone.setColumns(10);
			
			
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(10, 191, 90, 14);
			contentPane.add(lblEmail);
			textEmail = new JTextField();
			textEmail.setEditable(false);
			textEmail.setBounds(140, 188, 150, 20);
			contentPane.add(textEmail);
			textEmail.setColumns(10);
			
			
			JLabel lblPayRoll = new JLabel("Euro/hour:");
			lblPayRoll.setBounds(10, 253, 90, 14);
			contentPane.add(lblPayRoll);
			textPayRoll = new JTextField();
			textPayRoll.setEditable(false);
			textPayRoll.setBounds(140, 250, 150, 20);
			contentPane.add(textPayRoll);
			textPayRoll.setColumns(10);
			
			
			JLabel lblComapny = new JLabel("Company:");
			lblComapny.setBounds(10, 222, 90, 14);
			contentPane.add(lblComapny);
			textCompany = new JTextField();
			textCompany.setEditable(false);
			textCompany.setBounds(140, 220, 150, 20);
			contentPane.add(textCompany);
			textCompany.setColumns(10);
			
			lblHours = new JLabel("Hours:");
			lblHours.setBounds(10, 315, 90, 14);
			contentPane.add(lblHours);
			textHours = new JTextField();
			textHours.setEditable(false);
			textHours.setBounds(140, 315, 150, 20);
			contentPane.add(textHours);
			textHours.setColumns(10);
			
			lblBonus = new JLabel("Bonus:");
			lblBonus.setBounds(10, 315, 90, 14);
			contentPane.add(lblBonus);
			textBonus = new JTextField();
			textBonus.setEditable(false);
			textBonus.setBounds(140, 315, 150, 20);
			contentPane.add(textBonus);
			textBonus.setColumns(10);
			
			JButton btnOk = new JButton("Close");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOk.setBounds(330, 320, 89, 23);
			contentPane.add(btnOk);
			
			JLabel lblStatus = new JLabel("Active:");
			lblStatus.setBounds(10, 284, 120, 14);
			contentPane.add(lblStatus);
			
			activeType = new JTextField();
			activeType.setEditable(false);
			activeType.setBounds(140, 282, 150, 20);
			activeType.setBackground(Color.GREEN);
			contentPane.add(activeType);
			activeType.setColumns(10);
			
			nonActiveType = new JTextField();
			nonActiveType.setEditable(false);
			nonActiveType.setBounds(140, 282, 150, 20);
			nonActiveType.setBackground(Color.RED);
			contentPane.add(nonActiveType);
			nonActiveType.setColumns(10);
			
						
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						int id;
						id = Integer.parseInt(textIdEmployees.getText());
						if (id <= 0) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Error,the idEmployees has to be greater than 0", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else
							Controller.getInstance().action(new Context(Events.SEARCH_EMPLOYEES, id));
					}
					catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSearch.setBounds(330, 22, 89, 23);
			contentPane.add(btnSearch);
			
			
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	 }

	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch(context.getEvent()){
		case Events.SEARCH_EMPLOYEES_OK:
			TEmployees tEmployees = (TEmployees)context.getDetails();
			
			textName.setText(tEmployees.getName());
			textLastName.setText(tEmployees.getLastName()+"");
			textDni.setText(tEmployees.getDni()+"");
			textPhone.setText(tEmployees.getPhone()+"");
			textPayRoll.setText(tEmployees.getPayroll()+"");
			textEmail.setText(tEmployees.getEmail()+"");
			textCompany.setText(tEmployees.getCompany().getIdCompany()+"");
			if(tEmployees instanceof TFullTimeEmployees){
				textBonus.setText(((TFullTimeEmployees) tEmployees).getBonus()+"");
				textBonus.setVisible(true);
				textHours.setVisible(false);
				lblBonus.setVisible(true);
				lblHours.setVisible(false);
			
			}
			if(tEmployees instanceof TPartTimeEmployees){
				textHours.setText(((TPartTimeEmployees) tEmployees).getHours()+"");
				textBonus.setVisible(false);
				textHours.setVisible(true);
				lblBonus.setVisible(false);
				lblHours.setVisible(true);
				
			}
			
			if(tEmployees.getActive()){
				activeType.setVisible(true);
				nonActiveType.setVisible(false);
			}
			else{
				activeType.setVisible(false);
				nonActiveType.setVisible(true);
			}
			
			break;
		case Events.SEARCH_EMPLOYEES_KO:
			JOptionPane.showMessageDialog(null, "Error searching for employee");
			break;
		}
		
	
	}
	
	public void clearData() {
    	lblBonus.setVisible(false);
    	textBonus.setVisible(false);
    	lblHours.setVisible(false);
    	textHours.setVisible(false);
		activeType.setVisible(false);
		nonActiveType.setVisible(false);
		
		textIdEmployees.setText("");
    	textName.setText("");
    	textLastName.setText("");
    	textDni.setText("");
    	textPayRoll.setText("");
    	textPhone.setText("");
    	textEmail.setText("");
    	textHours.setText("");
    	textBonus.setText("");
    	textCompany.setText("");
	
	}

	

}

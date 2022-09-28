package _2.Diseño.Presentacion.Employees;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

public class GUIPayRollEmployees extends GUIEmployees{

	private static final long serialVersionUID = 1L;
	

	private JTextField textIdEmployees;
	private JPanel contentPane;
	private JTextPane textPR;

	
	public GUIPayRollEmployees() {
		// TODO Auto-generated constructor stub
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	 
	 private void initGUI() {
			// begin-user-code
			// TODO Auto-generated method stub
			// end-user-code
			setTitle("PayRoll Employee");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(false);
			setBounds(100, 100, 300, 200);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			
			JLabel lblIdEmployees = new JLabel("Id Employee:");
			lblIdEmployees .setBounds(30, 21, 90, 14);
			contentPane.add(lblIdEmployees);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 80, 275, 2);
			contentPane.add(separator);
			
			textIdEmployees = new JTextField();
			textIdEmployees.setBounds(180, 20, 100, 20);
			contentPane.add(textIdEmployees);
			textIdEmployees.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!textIdEmployees.getText().equals("")) {
						try {
							int id = Integer.parseInt(textIdEmployees.getText());
							Controller.getInstance().action(new Context(Events.PAYROLL_EMPLOYEES, id));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Introduzca un Id en la caja de texto", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnSearch.setBounds(100, 50, 89, 23);
			contentPane.add(btnSearch);
			
			JLabel lblPR = new JLabel("Total Month PayRoll:");
			lblPR.setBounds(30, 94, 140, 14);
			contentPane.add(lblPR);
			textPR = new JTextPane();
			textPR.setEditable(false);
			textPR.setBounds(180, 90, 100, 20);
			contentPane.add(textPR);
						
			JButton btnAceptar = new JButton("Close");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAceptar.setBounds(100, 120, 89, 23);
			contentPane.add(btnAceptar);	
			
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	 }

	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		TEmployees tEmployees = (TEmployees)context.getDetails();
		Float PR;
		switch(context.getEvent()){
		case Events.PAYROLL_EMPLOYEE_OK:
			
			if(tEmployees instanceof TFullTimeEmployees){
				PR = (tEmployees.getPayroll() * 8 * 30) +  ((TFullTimeEmployees) tEmployees).getBonus();
				textPR.setText(PR.toString() + " €");
			}
			if(tEmployees instanceof TPartTimeEmployees){
				PR = (tEmployees.getPayroll() * 30 * ((TPartTimeEmployees) tEmployees).getHours());
				textPR.setText(PR.toString() + " €");
			}
			break;
		case Events.PAYROLL_EMPLOYEE_KO:
			JOptionPane.showMessageDialog(null, "Error searching for employee");
			break;
		}
		
	
	}
	
	public void clearData() {
		textPR.setText("");
   	
	}

}
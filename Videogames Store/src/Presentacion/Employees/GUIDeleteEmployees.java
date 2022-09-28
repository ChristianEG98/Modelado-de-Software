package _2.Diseño.Presentacion.Employees;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

public class GUIDeleteEmployees extends GUIEmployees{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	public GUIDeleteEmployees(){
		super();
		contentPane = new JPanel();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("DELETE EMPLOYEES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 280, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idEmployees;
					
					idEmployees = Integer.parseInt(textField.getText());
					
					if(idEmployees <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Error, the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						int option = JOptionPane.showOptionDialog(new JFrame(),
								"Are you sure to delete this employees?", "Quit",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.YES_NO_OPTION, null, null, null);
						if (option == JOptionPane.YES_OPTION){
						Controller.getInstance().action(new Context(Events.DELETE_EMPLOYEES, idEmployees));
						}
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemove.setBounds(70, 80,120,30);
		contentPane.add(btnRemove);
		
		JLabel lblId = new JLabel("ID Employees:");
		lblId.setBounds(30, 50, 90, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(120, 48, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(70, 120, 120,30);
		contentPane.add(btnCancel);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch(context.getEvent()){
		case Events.DELETE_EMPLOYEES_OK:
			JOptionPane.showMessageDialog(null, "Employees " + context.getDetails() + " delete.");
			this.dispose();
			break;
			
		case Events.DELETE_EMPLOYEES_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The employee does not exist");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "The employee has already been deleted");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error removing employee");
			}
			break;
		}
	}

	public void clearData() {
		textField.setText("");
	}
}

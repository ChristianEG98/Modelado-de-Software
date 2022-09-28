package _2.Diseño.Presentacion.Employees;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

public class GUIListEmployees extends GUIEmployees{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Name", "LastName", "Dni", "Email","Company", "Phone", "Euro/hour", "Hours", "Bonus"};
	private DefaultTableModel tableModel;
	private JTable table;

	public GUIListEmployees(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("List employeess");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1325, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1300, 177);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		tableModel.setColumnCount(0);

		for (int i = 0; i < columnNames.length; ++i) {
			tableModel.addColumn(columnNames[i]);
		}
		
		table.setModel(tableModel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(650, 227, 120, 23);
		contentPane.add(btnOk);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch (context.getEvent()) {
		case Events.LIST_EMPLOYEESS_OK:
			
			ArrayList<TEmployees> res = (ArrayList<TEmployees>) context.getDetails();
			if(res.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no employees");
			
			for (int i = 0; i < res.size(); i++) {

				if (res.get(i) instanceof TFullTimeEmployees) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
								
							res.get(i).getIdEmployees(),
							res.get(i).getName(),
							res.get(i).getLastName(),
							res.get(i).getDni(),
							res.get(i).getEmail(),
							res.get(i).getCompany().getIdCompany(),
							res.get(i).getPhone(),
							res.get(i).getPayroll(),
							"-",
							((TFullTimeEmployees)res.get(i)).getBonus()});
							
				}
				else if (res.get(i) instanceof TPartTimeEmployees){
					tableModel.insertRow(i, new Object[] 
							{ i+1,
								res.get(i).getIdEmployees(),
								res.get(i).getName(),
								res.get(i).getLastName(),
								res.get(i).getDni(),
								res.get(i).getEmail(),
								res.get(i).getCompany().getIdCompany(),
								res.get(i).getPhone(),
								res.get(i).getPayroll(),
								((TPartTimeEmployees)res.get(i)).getHours(),
					"-"});
								
								
							
				
				}
			}
			table.setModel(tableModel);
			break;
			
		case Events.LIST_EMPLOYEESS_KO:
			JOptionPane.showMessageDialog(null, "Error listing employees", "Error listing", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
		
	
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
	}

}

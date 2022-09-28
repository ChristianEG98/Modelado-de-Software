/**
 * 
 */
package _2.Diseño.Presentacion.Company;

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

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Negocio.Company.imp.TCompany;
import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Employees.TFullTimeEmployees;
import _2.Diseño.Negocio.Employees.TPartTimeEmployees;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUIListCompanies extends GUICompany {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private String[]columnNames ={"#", "IdCompany", "Name", "Cif", "Num Employees"};
	private DefaultTableModel tableModel;
	private JTable table;
	
	public GUIListCompanies(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	


	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setTitle("LIST COMPANIES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 614, 177);
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
		btnOk.setBounds(260, 227, 120, 23);
		contentPane.add(btnOk);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void update(Context context) {
		// TODO Auto-generated method stub
		switch (context.getEvent()) {
		case Events.LIST_COMPANIES_OK:
			
			@SuppressWarnings("unchecked") ArrayList<TCompany> res = (ArrayList<TCompany>) context.getDetails();
			if(res.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no companies");
			
			for (int i = 0; i < res.size(); i++) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
								
							res.get(i).getIdCompany(),
							res.get(i).getName(),
							res.get(i).getCif(),
							res.get(i).getNumEmployees(),
							"-",
							});
			}
			table.setModel(tableModel);
			break;
			
		case Events.LIST_COMPANIES_KO:
			JOptionPane.showMessageDialog(null, "Error listing companies", "Error listing", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
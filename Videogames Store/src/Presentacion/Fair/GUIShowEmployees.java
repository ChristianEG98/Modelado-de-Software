/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import _2.Diseño.Negocio.Fair.imp.TAssist;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIShowEmployees extends GUIFair {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTable table;
	private String[] columnNames = { "&", "IdFair", "idEmployee" };
	private DefaultTableModel tableModel;
	private JTextField textField;

	
	public GUIShowEmployees(){
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
		// begin-user-code
		// TODO Auto-generated method stub
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 604, 174);
		contentPanel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel(){
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
		
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(504, 237, 120, 23);
		contentPanel.add(btnExit);
		
		textField = new JTextField();
		textField.setBounds(385, 14, 100, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idFair = Integer.parseInt(textField.getText());
					
					if(idFair <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Error, the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						Controller.getInstance().action(new Context(Events.SHOW_EMPLOYEES_FAIR, idFair));
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(504, 13, 120, 23);
		contentPanel.add(btnSearch);
		
		JLabel lblIdFair = new JLabel("Id Fair:");
		lblIdFair.setBounds(270, 17, 105, 14);
		contentPanel.add(lblIdFair);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		
		
		// end-user-code
	}

	public void update(Context context){
		switch (context.getEvent()) {
		case Events.SHOW_EMPLOYEES_FAIR_OK:
			@SuppressWarnings("unchecked") List<TAssist> res = (List<TAssist>) context.getDetails();
			if (res.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no employees at this fair");
			System.out.println(res.size());
			for (int i = 0; i < res.size(); i++) {
				tableModel.insertRow(i, new Object[] { i + 1, res.get(i).getfair(), res.get(i).getemployees() });
			}
			table.setModel(tableModel);
			break;

		case Events.SHOW_EMPLOYEES_FAIR_KO:
			JOptionPane.showMessageDialog(null, "Error displaying fair employees", "Error listing", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		// begin-user-code
		// TODO Auto-generated method stub
		textField.setText("");
		tableModel.setRowCount(0);
		table.setModel(tableModel);
		// end-user-code
	}
}
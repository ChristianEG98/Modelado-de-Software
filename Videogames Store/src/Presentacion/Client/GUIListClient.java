/**
 * 
 */
package _2.Diseño.Presentacion.Client;

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
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIListClient extends GUIClient {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Name", "Last Name", "Dni", "Phone", "Email"};
	private DefaultTableModel tableModel;
	private JTable table;
	
	/**
	 * 
	 */
	public GUIListClient(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private void initGUI() {
		setTitle("List clients");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 750, 177);
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
		
		JButton btnSearch = new JButton("OK");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSearch.setBounds(330, 227, 120, 23);
		contentPane.add(btnSearch);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch (context.getEvent()) {
		case Events.LIST_CLIENTS_OK:
			
			@SuppressWarnings("unchecked") ArrayList<TClient> res = (ArrayList<TClient>) context.getDetails();
			if(res.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no clients");
			
			for (int i = 0; i < res.size(); i++) {
				tableModel.insertRow(i,
						new Object[] 
						{ i+1,
						res.get(i).getIdClient(),
						res.get(i).getName(),
						res.get(i).getLastName(),
						res.get(i).getDNI(),
						res.get(i).getPhone(),
						res.get(i).getEmail(),
					});
			}
			table.setModel(tableModel);
			break;
			
		case Events.LIST_CLIENTS_KO:
			JOptionPane.showMessageDialog(null, "Error listing clients", "Error listing", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
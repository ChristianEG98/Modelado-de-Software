package _2.Diseño.Presentacion.Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;
import _2.Diseño.Presentacion.View.GUI;

public class GUICustomersWhoHaveMadeMoreThan_X_Purchases extends GUIListClient{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Name", "Last Name", "Dni", "Phone", "Email"};
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField textPurchases;
	
	/**
	 * 
	 */
	public GUICustomersWhoHaveMadeMoreThan_X_Purchases(){
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
		setTitle("LIST CLIENTS WHO HAVE MADE MORE THAN X PURCHASES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 860, 150);
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
		
		JLabel lblPurchases = new JLabel("Purchases:");
		lblPurchases.setBounds(320, 11, 136, 14);
		contentPane.add(lblPurchases);
		
		textPurchases = new JTextField();
		textPurchases.setBounds(390, 8, 120, 20);
		contentPane.add(textPurchases);
		textPurchases.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 860, 2);
		contentPane.add(separator);
		
		JButton btnBuscar = new JButton("Search");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int purchase = Integer.parseInt(textPurchases.getText());
					
					TQuery tQuery = new TQuery(purchase);
					clearData();
					Controller.getInstance().action(new Context(Events.CUSTOMERS_MORE_X_PURCHASES, tQuery));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(533, 7, 89, 23);
		contentPane.add(btnBuscar);
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
		
		btnOk.setBounds(430, 240, 120, 23);
		contentPane.add(btnOk);
		
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
		textPurchases.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch (context.getEvent()) {
		case Events.CUSTOMERS_MORE_X_PURCHASES_OK:
			
			@SuppressWarnings("unchecked") 
			ArrayList<TClient> res = (ArrayList<TClient>) context.getDetails();
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
			
		case Events.CUSTOMERS_MORE_X_PURCHASES_KO:
			JOptionPane.showMessageDialog(null, "Error listing clients", "Error listing", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

}

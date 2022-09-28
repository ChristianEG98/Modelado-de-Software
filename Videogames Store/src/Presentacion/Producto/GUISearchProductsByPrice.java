/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUISearchProductsByPrice extends GUIProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private String[]columnNames ={"#", "Id", "Name", "Price", "Stock", "Storage", "Colour", "Manufacture", "Gender", "Age", "Platform"};
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField textField;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUISearchProductsByPrice(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("SEARCH PRODUCTS BY PRICE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 614, 177);
		contentPanel.add(scrollPane);
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
		
		JLabel lblPrecio = new JLabel("Price:");
		lblPrecio.setBounds(25, 11, 355, 14);
		contentPanel.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(90, 8, 120, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 614, 2);
		contentPanel.add(separator);
		
		JButton btnBuscar = new JButton("Search");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float precio;
					precio = Float.parseFloat(textField.getText());
					if (precio < 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information (price has to be greater than 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_PRODUCTS_BY_PRICE, precio));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(533, 7, 89, 23);
		contentPanel.add(btnBuscar);
		
		JButton btnAceptar = new JButton("OK");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(504, 237, 120, 23);
		contentPanel.add(btnAceptar);
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
		table.setEnabled(false);
		this.textField.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.SEARCH_PRODUCTS_BY_PRICE_OK:
			tableModel.setRowCount(0);
			@SuppressWarnings("unchecked") ArrayList<TProduct> res = (ArrayList<TProduct>) context.getDetails();
			if(res.size() == 0){
				JOptionPane.showMessageDialog(null, "There are no products with a price less than that indicated.");
			}

			for (int i = 0; i < res.size(); i++) {
				if (res.get(i) instanceof TVideogames) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
							res.get(i).getIdProduct(),
							res.get(i).getName(),
							res.get(i).getPrice(),
							res.get(i).getStock(),
							"-",
							"-",
							"-",
							((TVideogames)res.get(i)).getGender(),
							((TVideogames)res.get(i)).getAge(),
							((TVideogames)res.get(i)).getPlatform(),
							});
				}
				else if (res.get(i) instanceof TConsoles){
					tableModel.insertRow(i, new Object[] 
							{ i+1,
							res.get(i).getIdProduct(),
							res.get(i).getName(),
							res.get(i).getPrice(),
							res.get(i).getStock(),
							((TConsoles)res.get(i)).getStorage(),
							((TConsoles)res.get(i)).getColour(),
							((TConsoles)res.get(i)).getManufacturer(),
							
							"-",
							"-",
							"-",
							});
				}
			}
			table.setModel(tableModel);
			break;
		case Events.SEARCH_PRODUCTS_BY_PRICE_KO:
			JOptionPane.showMessageDialog(null, "Error searching for the products", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

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
import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIListProducts extends GUIProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Name", "Price", "Stock", "Storage", "Colour", "Manufacture", "Gender", "Age", "Platform"};
	private DefaultTableModel tableModel;
	private JTable table;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	public GUIListProducts(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("LIST PRODUCTS");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 830, 177);
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
		
		JButton btnAceptar = new JButton("OK");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(380, 210, 120, 23);
		contentPane.add(btnAceptar);
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
			case Events.LIST_PRODUCTS_OK:
				
				@SuppressWarnings("unchecked") ArrayList<TProduct> res = (ArrayList<TProduct>) context.getDetails();
				if(res.size() == 0)
					JOptionPane.showMessageDialog(null, "There are no products");
				
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
				
			case Events.LIST_PRODUCTS_KO:
				JOptionPane.showMessageDialog(null, "Error listing products", "Error listing", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
}
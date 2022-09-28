/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

import _2.Diseño.Negocio.Ticket.imp.TTicket;
import _2.Diseño.Negocio.Ticket.imp.LineaTicket;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIModifyTicket extends JFrame implements GUI  {
	
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPanel contentPanel;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private DefaultTableModel tableModel;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TTicket ticket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTable tabla;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTextField txtfield_IdProduct;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Object[] colNames = { "&", "IdProduct", "NumProducts" };
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JSpinner spinner;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param context
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		// begin-user-code
		// TODO Auto-generated method stub
		switch (context.getEvent()) {
		case Events.MODIFY_TICKET_OK:
			clearTable();
			HashMap<Integer, LineaTicket> lineas = this.ticket.getLineaTicket();
			Collection<LineaTicket> values = lineas.values();
			Iterator<LineaTicket> iterator = values.iterator();
			LineaTicket lt;
			while (iterator.hasNext()) {

				lt = iterator.next();
				tableModel.insertRow(tableModel.getRowCount(),
						new Object[] { tableModel.getRowCount() + 1, lt.getIdProduct(), lt.getNumProducts(), });
			}

			tabla.setModel(tableModel);
			break;
		case Events.MODIFY_TICKET_KO:
			JOptionPane.showMessageDialog(new JFrame(),
					"Error, Does the selected product exist?", "Modify Tickets",
					JOptionPane.ERROR_MESSAGE);
			break;
		// end-user-code
		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void initGUI() {
		// begin-user-code
		// TODO Auto-generated method stub
		setTitle("ADD/REMOVE PRODUCTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 290);
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblProductosEnVenta = new JLabel("Products for current sale:");
		lblProductosEnVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductosEnVenta.setBounds(51, 19, 192, 14);
		contentPanel.add(lblProductosEnVenta);


		clearTable();
		HashMap<Integer, LineaTicket> lineas = this.ticket.getLineaTicket();
		Collection<LineaTicket> values = lineas.values();
		Iterator<LineaTicket> iterator = values.iterator();
		LineaTicket lt;
		while (iterator.hasNext()) {

			lt = iterator.next();
			tableModel.insertRow(tableModel.getRowCount(),
					new Object[] { tableModel.getRowCount() + 1, lt.getIdProduct(), lt.getNumProducts() });

		}

		JLabel lblIdProduct = new JLabel("Id Product:");
		lblIdProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdProduct.setBounds(381, 86, 82, 14);
		contentPanel.add(lblIdProduct);

		txtfield_IdProduct = new JTextField();
		txtfield_IdProduct.setBounds(469, 85, 45, 20);
		contentPanel.add(txtfield_IdProduct);
		txtfield_IdProduct.setColumns(10);


		JLabel lblNumProducts = new JLabel("Quantity");
		lblNumProducts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumProducts.setBounds(381, 125, 82, 14);
		contentPanel.add(lblNumProducts);

		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
		spinner.setBounds(469, 124, 45, 20);
		contentPanel.add(spinner);


		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtfield_IdProduct.getText().equals("")) {

					try {
						int cantidad = (int) spinner.getValue();
						int idProduc = Integer.parseInt(txtfield_IdProduct.getText());
						int[] data = { idProduc, cantidad };
						if (cantidad>0){
						
						Controller.getInstance().action(new Context(Events.MODIFY_TICKET, data));
						}
						else{
							JOptionPane.showMessageDialog(new JFrame(), "Quantity has to be more than 0", "Error",
									JOptionPane.ERROR_MESSAGE);
							
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en el id. Error: " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(new JFrame(), "Enter a product id", "Error",
							JOptionPane.ERROR_MESSAGE);
			}

		});
		btnConfirm.setBounds(432, 203, 107, 25);
		contentPanel.add(btnConfirm);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(340, 203, 82, 25);
		contentPanel.add(btnBack);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUIModifyTicket(TTicket tTicket) {
		// begin-user-code
		// TODO Auto-generated constructor stub
		super();
		
		this.ticket = tTicket;
		txtfield_IdProduct = new JTextField();
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void refresh() {
		// begin-user-code
		// TODO Auto-generated method stub
		txtfield_IdProduct.setText("");
		spinner.setValue(0);
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearTable() {
		// begin-user-code
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 61, 298, 158);
		contentPanel.add(scrollPane);
		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		tableModel = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.setColumnIdentifiers(colNames);
		tabla.setModel(tableModel);
		// end-user-code
	}
}
/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;

import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Ticket.imp.LineaTicket;
import _2.Diseño.Negocio.Ticket.imp.TOATotalInvoice;
import _2.Diseño.Presentacion.Context;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIGetInvoice extends JFrame implements GUI {
	
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
	private TOATotalInvoice invoice = null;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Object[] col_Names = { "&", "IdProduct", "Product", "NumProducts", "P/U", "Total" };
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTable tableLineaTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel idTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel ClientName;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel ClientDni;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel priceTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel date;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JScrollPane scrollPanel;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUIGetInvoice() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		super();
		contentPanel = new JPanel();
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
	public void initGUI() {
		// begin-user-code
		// TODO Auto-generated method stub
		setTitle("Invoice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 357);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblFacturaDeVenta = new JLabel("Invoice Ticket ID: ");
		lblFacturaDeVenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFacturaDeVenta.setBounds(35, 29, 242, 14);
		contentPanel.add(lblFacturaDeVenta);

		idTicket = new JLabel("");
		idTicket.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		idTicket.setBounds(200, 29, 46, 14);
		contentPanel.add(idTicket);

		JLabel lblClient = new JLabel("Client: ");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClient.setBounds(35, 73, 55, 14);
		contentPanel.add(lblClient);

		ClientName = new JLabel("");
		ClientName.setFont(new Font("Tahoma", Font.ITALIC, 12));
		ClientName.setBounds(80, 73, 77, 14);
		contentPanel.add(ClientName);

		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(210, 73, 60, 14);
		contentPanel.add(lblDni);

		ClientDni = new JLabel("");
		ClientDni.setFont(new Font("Tahoma", Font.ITALIC, 12));
		ClientDni.setBounds(248, 73, 90, 14);
		contentPanel.add(ClientDni);

		scrollPanel = new JScrollPane();
		scrollPanel.setBounds(35, 112, 284, 127);
		contentPanel.add(scrollPanel);

		tableLineaTicket = new JTable();
		scrollPanel.setViewportView(tableLineaTicket);
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

		tableModel.setColumnIdentifiers(col_Names);
		tableLineaTicket.setModel(tableModel);

		JLabel lblTotalPagado = new JLabel("Paid:");
		lblTotalPagado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPagado.setBounds(128, 259, 91, 14);
		contentPanel.add(lblTotalPagado);

		priceTicket = new JLabel("");
		priceTicket.setFont(new Font("Tahoma", Font.ITALIC, 12));
		priceTicket.setBounds(170, 259, 60, 14);
		contentPanel.add(priceTicket);

		JLabel lblTicketDate = new JLabel("Ticket date:");
		lblTicketDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTicketDate.setBounds(35, 293, 99, 14);
		contentPanel.add(lblTicketDate);

		date = new JLabel("");
		date.setFont(new Font("Tahoma", Font.ITALIC, 12));
		date.setBounds(119, 293, 91, 14);
		contentPanel.add(date);
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
		idTicket.setText("");
		ClientName.setText("");
		ClientDni.setText("");
		priceTicket.setText("");
		tableLineaTicket = new JTable();
		scrollPanel.setViewportView(tableLineaTicket);
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

		tableModel.setColumnIdentifiers(col_Names);
		tableLineaTicket.setModel(tableModel);
		

		date.setText("");
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		// begin-user-code
		// TODO Auto-generated method stub
		invoice = (TOATotalInvoice) context.getDetails();

		idTicket.setText("" + invoice.getTicket().getIdTicket());
		ClientName.setText(invoice.gettCLiente().getName());
		ClientDni.setText(invoice.gettCLiente().getDNI());
		priceTicket.setText(invoice.getTicket().getPrice() + " €");
		date.setText(invoice.getTicket().getDate().toString());
		HashMap<Integer, LineaTicket> lineas = invoice.getTicketLine();
		Collection<LineaTicket> values = lineas.values();
		Iterator<LineaTicket> iterator = values.iterator();

		LineaTicket lt;
		int i = 0;
		float precioUnitario=0;
		while (iterator.hasNext()) {
			lt = iterator.next();
			
			TProduct p = invoice.getProducts().get(i);
			if(lt.getNumProducts()>0){
				precioUnitario = lt.getTotalPrice()/lt.getNumProducts();
				tableModel.insertRow(tableModel.getRowCount(), new Object[] { tableModel.getRowCount() + 1, lt.getIdProduct(),
						p.getName(), lt.getNumProducts(), precioUnitario, lt.getTotalPrice() });
			}

			++i;
		}
		TableColumnModel columnModel = tableLineaTicket.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(60);
		columnModel.getColumn(4).setPreferredWidth(50);
		

		// end-user-code
	}

}
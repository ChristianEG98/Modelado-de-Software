/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Ticket.imp.TTicket;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIListTickets extends JFrame implements GUI {
	

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
	private Object[] colNames = { "Date", "idTicket", "idClient", "TotalPrice" };
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTable table;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void initGUI() {
		// begin-user-code
		// TODO Auto-generated method stub
		setResizable(false);
		setTitle("List tickets");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 614, 205);
		contentPanel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		tableModel = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.setColumnCount(0);

		tableModel.setColumnIdentifiers(colNames);
		table.setModel(tableModel);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(260, 227, 120, 23);
		contentPanel.add(btnOk);
		// end-user-code
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUIListTickets() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		super();
		contentPanel = new JPanel();
		contentPanel.setVisible(true);
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
		initGUI();
		this.setLocationRelativeTo(null);
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
		switch (context.getEvent()) {
		case Events.LIST_TICKET_OK:
			@SuppressWarnings("unchecked") ArrayList<TTicket> res = (ArrayList<TTicket>) context.getDetails();

			for (int i = 0; i < res.size(); i++) {
				tableModel.insertRow(i, new Object[] { res.get(i).getDate().toString(), res.get(i).getIdTicket(),
						res.get(i).getIdCliente(), res.get(i).getPrice()});
			}
			table.setModel(tableModel);
			break;
		case Events.LIST_TICKET_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Error listing tickets", "List Sales",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		// end-user-code
	}

}
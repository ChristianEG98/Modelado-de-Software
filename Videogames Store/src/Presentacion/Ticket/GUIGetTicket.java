/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import _2.Diseño.Negocio.Ticket.imp.TTicket;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIGetTicket extends JFrame implements GUI { 
	
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
	private JLabel lb_IdTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel lb_IdClient;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel lb_Date;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel lb_Price;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JLabel lb_Cif;
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
	private GUIGetInvoice gUIGetInvoice;
	private JLabel lblIdTicket;
	private JLabel lblIdTi ;
	private JTextField textIdTicket ;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUIGetTicket() {
		// begin-user-code
		// TODO Auto-generated constructor stub
		super();
		contentPanel = new JPanel();
		gUIGetInvoice = new GUIGetInvoice();
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
		setType(Type.POPUP);
		setTitle("Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblTicketData = new JLabel("TICKET DETAILS:");
		lblTicketData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTicketData.setBounds(41, 31, 150, 14);
		contentPanel.add(lblTicketData);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 424, 2);
		contentPanel.add(separator);
		
		 lblIdTi = new JLabel("Enter Id :");
		lblIdTi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdTi .setBounds(41, 69, 84, 14);
		contentPanel.add(lblIdTi);
		
		
		textIdTicket = new JTextField();
		textIdTicket.setBounds(135, 69, 150, 20);
		contentPanel.add(textIdTicket);
		textIdTicket.setColumns(10);
		

		 lblIdTicket= new JLabel("Id Ticket: ");
		lblIdTicket.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdTicket.setBounds(41, 99, 84, 14);
		contentPanel.add(lblIdTicket);

		lb_IdTicket = new JLabel("");
		lb_IdTicket.setBounds(137, 101, 54, 14);
		contentPanel.add(lb_IdTicket);

		JLabel lblIdCliente = new JLabel("Id Client:");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(41, 124, 73, 14);
		contentPanel.add(lblIdCliente);

		lb_IdClient = new JLabel("");
		lb_IdClient.setBounds(137, 126, 60, 14);
		contentPanel.add(lb_IdClient);

		JLabel lblFecha = new JLabel("Date:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(41, 149, 46, 14);
		contentPanel.add(lblFecha);

		lb_Date = new JLabel("");
		lb_Date.setBounds(137, 149, 73, 14);
		contentPanel.add(lb_Date);
		
		JLabel lblPrecio = new JLabel("Total:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(41, 175, 50, 14);
		contentPanel.add(lblPrecio);

		lb_Price = new JLabel("");
		lb_Price.setBounds(137, 175, 83, 14);
		contentPanel.add(lb_Price);
		
		JLabel lblCif = new JLabel("Cif:");
		lblCif.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCif.setBounds(41, 201, 30, 14);
		contentPanel.add(lblCif);
		
		lb_Cif = new JLabel("");
		lb_Cif.setBounds(137, 201, 83, 14);
		contentPanel.add(lb_Cif);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idTicket = Integer.parseInt(textIdTicket.getText());

					if (idTicket <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error,the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_TICKET, idTicket));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 69, 89, 24);
		contentPanel.add(btnSearch);

		JButton btnGetInvoice = new JButton("Get Invoice");
		btnGetInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(new Context(Events.GET_INVOICE, getChosenTicket().getIdTicket()));
			}
		});
		btnGetInvoice.setBounds(175, 250, 100, 24);
		contentPanel.add(btnGetInvoice);
		// end-user-code
	}

	public TTicket getChosenTicket() {
		return this.ticket;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void refresh() {
		// begin-user-code
		// TODO Auto-generated method stub
		lb_IdTicket.setText("");
		lb_IdClient.setText("");
		lb_Date.setText("");
		lb_Price.setText("");
		lb_Cif.setText("");
		textIdTicket.setText("");
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
		case (Events.SEARCH_TICKET_OK):
			ticket = (TTicket) context.getDetails();

			String id = Integer.toString(ticket.getIdTicket());
			String idCli = Integer.toString(ticket.getIdCliente());
			String fecha = ticket.getDate().toString();
			String precio = Double.toString(ticket.getPrice());
			String cif = ticket.getCif();

			lb_IdTicket.setText(id);
			lb_IdClient.setText(idCli);
			lb_Date.setText(fecha);
			lb_Price.setText(precio + "€");
			lb_Cif.setText(cif);
			break;
		case (Events.SEARCH_TICKET_KO):
			JOptionPane.showMessageDialog(new JFrame(), "Error, cannot show ticket",
					"Mostrar Ticket", JOptionPane.ERROR_MESSAGE);
			break;
		case (Events.GET_INVOICE_OK):
			gUIGetInvoice.refresh();
			gUIGetInvoice.update(context);
			gUIGetInvoice.setVisible(true);
			break;
		case(Events.GET_INVOICE_KO):
			gUIGetInvoice.refresh();
		JOptionPane.showMessageDialog(new JFrame(), "Error, invoice cannot be displayed",
				"Mostrar Factura", JOptionPane.ERROR_MESSAGE);
		
		}
		// end-user-code
	}

}
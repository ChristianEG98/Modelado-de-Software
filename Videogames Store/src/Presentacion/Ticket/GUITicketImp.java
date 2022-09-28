/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Ticket.imp.TTicket;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUITicketImp extends GUITicket {
	
	private static final long serialVersionUID = 12L;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	//private GUIGetInvoice gUIGetInvoice;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUICreateTicket gUICreateTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIModifyTicket gUIModifyTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIGetTicket gUIGetTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIListTickets gUiListTickets;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIReturn gUIReturn;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TTicket tCurrentTicket;

	private JButton btAddRemoveProducts;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPanel contentPanel;

	JButton buttonCreateTicket;
	JButton buttonCloseTicket;
	JButton buttonReturnProduct;
	JButton buttonGetInvoice;
	JButton buttonSearchTicket;
	JButton buttonListTickets;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void initGUI() {
		this.setTitle("TICKETS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 217, 252));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		buttonCreateTicket = new JButton("CREATE TICKET");
		buttonCreateTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUICreateTicket.refresh();
				gUICreateTicket.setVisible(true); 
			}
		});
		buttonCreateTicket.setBounds(10, 30, 200, 45);
		contentPanel.add(buttonCreateTicket );
		buttonCloseTicket = new JButton("CLOSE TICKET");
		buttonCloseTicket .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*gUICloseTicket.refresh(); 
				gUICloseTicket.setVisible(true);*/
				TTicket ticketInProgress = getCurrentTicket();
				int option = JOptionPane.showOptionDialog(new JFrame(),
						"Are you sure to finish this sale?", "Quit",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.YES_NO_OPTION, null, null, null);
				if (option == JOptionPane.YES_OPTION){
				Controller.getInstance().action(new Context(Events.CLOSE_TICKET, ticketInProgress));
				}
			}
		});
		buttonCloseTicket.setBounds(224, 30, 200, 45);
		contentPanel.add(buttonCloseTicket);
		btAddRemoveProducts = new JButton("ADD/REMOVE PRODUCTS");
		btAddRemoveProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModifyTicket = new GUIModifyTicket(tCurrentTicket);
				gUIModifyTicket.refresh();
				gUIModifyTicket.setVisible(true);
			}
		});
		btAddRemoveProducts.setBounds(10, 90, 200, 45);
		contentPanel.add(btAddRemoveProducts);

		buttonSearchTicket = new JButton("SEARCH TICKET");
		buttonSearchTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIGetTicket.refresh();
				gUIGetTicket.setVisible(true);
			}
		});
		buttonSearchTicket.setBounds(224, 90, 200, 45);
		contentPanel.add(buttonSearchTicket);
		setBtTicketInProgress(false);
		
		buttonListTickets = new JButton("LIST TICKETS");
		buttonListTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().action(new Context(Events.LIST_TICKET, null));	
			}
		});
		buttonListTickets.setBounds(10, 150, 200, 45);
		contentPanel.add(buttonListTickets);

		buttonReturnProduct = new JButton("RETURN PRODUCT");
		buttonReturnProduct .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIReturn.refresh();
				gUIReturn.setVisible(true);
			}
		});
		buttonReturnProduct.setBounds(224, 150, 200, 45);
		contentPanel.add(buttonReturnProduct);
		
		JButton btMainMenu = new JButton("MAIN MENU");
		btMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int option = JOptionPane.showOptionDialog(new JFrame(),
							"Are you sure to return to the main menu?", "Quit",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.YES_NO_OPTION, null, null, null);
					if (option == JOptionPane.YES_OPTION){
				dispose();
					}
			}
		});
		btMainMenu.setBounds(115, 210, 200, 45);
		contentPanel.add(btMainMenu);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUITicketImp() {
		super();
		gUICreateTicket= new GUICreateTicket();
		gUIReturn = new GUIReturn();
		gUiListTickets= new GUIListTickets();
		gUIGetTicket= new GUIGetTicket();
		
		contentPanel = new JPanel();
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param context
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.CREATE_TICKET_OK:
			this.tCurrentTicket = (TTicket) context.getDetails();
			this.buttonCreateTicket.setEnabled(false);
			setBtTicketInProgress(true);
			JOptionPane.showMessageDialog(new JFrame(), "New ticket created", "Create Ticket",
					JOptionPane.INFORMATION_MESSAGE);

			break;
		case Events.CREATE_TICKET_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Failed to create ticket", "Create Ticket",
					JOptionPane.ERROR_MESSAGE);
			this.buttonCreateTicket.setEnabled(true);
			setBtTicketInProgress(false);
			break;
		case Events.LIST_TICKET_OK:
			gUiListTickets.refresh();
			gUiListTickets.update(context);
			gUiListTickets.setVisible(true);
			break;
		case Events.LIST_TICKET_KO:
			gUiListTickets.refresh();
			gUiListTickets.update(context);
			break;
		case Events.RETURN_PRODUCT_OK:
			gUIReturn.refresh();
			gUIReturn.update(context);
			break;
		case Events.RETURN_PRODUCT_KO:
			gUIReturn.refresh();
			gUIReturn.update(context);
			break;
		case Events.SEARCH_TICKET_OK:
			gUIGetTicket.refresh();
			gUIGetTicket.update(context);
			gUIGetTicket.setVisible(true);
			break;
		case Events.SEARCH_TICKET_KO:
			gUIGetTicket.refresh();
			gUIGetTicket.update(context);
			break;
		case Events.MODIFY_TICKET_OK:
			gUIModifyTicket.refresh();
			gUIModifyTicket.update(context);
			gUIModifyTicket.setVisible(true);
			break;
		case Events.MODIFY_TICKET_KO:
			gUIModifyTicket.refresh();
			gUIModifyTicket.update(context);
			gUIModifyTicket.setVisible(true);
			break;
		case Events.CLOSE_TICKET_OK:
			this.buttonCreateTicket.setEnabled(true);
			setBtTicketInProgress(false);
			if ((int) context.getDetails() == -4)
				JOptionPane.showMessageDialog(new JFrame(), "Ticket canceled", "Close Ticket",
						JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(new JFrame(), "Ticket created with id:" + (int) context.getDetails(),
						"Close Ticket", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.CLOSE_TICKET_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Error: " + context.getDetails(), "Close Ticket",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Events.GET_INVOICE_OK:
			gUIGetTicket.update(context);
			break;
		case Events.GET_INVOICE_KO:
			gUIGetTicket.update(context);
			break;
		}
	}

	public void setBtTicketInProgress(boolean status) {

		this.buttonCloseTicket.setEnabled(status);
		this.btAddRemoveProducts.setEnabled(status);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TTicket getCurrentTicket() {
		// begin-user-code
		// TODO Auto-generated method stub
		return this.tCurrentTicket;
		// end-user-code
	}
	
	public void setTicket(TTicket tticket) {
		this.tCurrentTicket = tticket;
	}
}
/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIReturn extends JFrame implements GUI {
	
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
	private JTextField txt_IdTicket;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTextField txt_IdProduct;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JTextField txt_NumProducts;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public GUIReturn() {
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
		setTitle("RETURN");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblIdTicket = new JLabel("Id ticket:");
		lblIdTicket.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdTicket.setBounds(25, 20, 216, 14);
		contentPanel.add(lblIdTicket);
		
		JLabel lblIdProducto = new JLabel("Id product:");
		lblIdProducto.setFont(new Font("Arial", Font.PLAIN, 16));
		lblIdProducto.setBounds(25, 50, 216, 14);
		contentPanel.add(lblIdProducto);
		
		JLabel lblCantidad = new JLabel("Quantity:");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantidad.setBounds(25, 80, 216, 14);
		contentPanel.add(lblCantidad);
		
		txt_IdTicket = new JTextField();
		txt_IdTicket.setBounds(110, 17, 86, 20);
		contentPanel.add(txt_IdTicket);
		txt_IdTicket.setColumns(10);
		
		txt_IdProduct = new JTextField();
		txt_IdProduct.setColumns(10);
		txt_IdProduct.setBounds(110, 47, 86, 20);
		contentPanel.add(txt_IdProduct);
		
		txt_NumProducts = new JTextField();
		txt_NumProducts.setColumns(10);
		txt_NumProducts.setBounds(110, 77, 86, 20);
		contentPanel.add(txt_NumProducts);
		
		JButton btnDevolver = new JButton("Return");
		btnDevolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnDevolver.setForeground(Color.BLACK);
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idTicket=Integer.parseInt(txt_IdTicket.getText());
				int idProducto= Integer.parseInt(txt_IdProduct.getText());
				int cantidad = Integer.parseInt(txt_NumProducts.getText());
				
				int []datos={ idTicket, idProducto, cantidad};
				
				Controller.getInstance().action(new Context(Events.RETURN_PRODUCT, datos));
			}
		});
		btnDevolver.setBounds(55, 125, 150, 31);
		contentPanel.add(btnDevolver);
		
		
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(55, 170, 150, 31);
		contentPanel.add(btnExit);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		// end-user-code
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param context
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		// begin-user-code
		// TODO Auto-generated method stub
		switch(context.getEvent()){
		case Events.RETURN_PRODUCT_OK:
			JOptionPane.showMessageDialog(null, "Ticket return with id: " + context.getDetails(), "Return", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			break;
		case Events.RETURN_PRODUCT_KO:
			JOptionPane.showMessageDialog(null, "Error in the return" , "Return", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			break;
		}
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
		this.txt_IdTicket.setText("");
		this.txt_IdProduct.setText("");
		this.txt_NumProducts.setText("");
		// end-user-code
	}

}
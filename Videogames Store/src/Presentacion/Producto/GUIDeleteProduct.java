/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIDeleteProduct extends GUIProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField textField;

	public GUIDeleteProduct(){
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
		setTitle("DELETE PRODUCT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 270, 200);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		JButton btnRemove = new JButton("Delete");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idProduct;
					
					idProduct = Integer.parseInt(textField.getText());
					
					if(idProduct <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Error, the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						int option = JOptionPane.showOptionDialog(new JFrame(),
								"Are you sure to delete this product?", "Quit",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.YES_NO_OPTION, null, null, null);
						if (option == JOptionPane.YES_OPTION){
						Controller.getInstance().action(new Context(Events.DELETE_PRODUCT, idProduct));
						}
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemove.setBounds(70, 80,120,30);
		contentPanel.add(btnRemove);
		
		JLabel lblId = new JLabel("ID Product:");
		lblId.setBounds(40, 50, 70, 14);
		contentPanel.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(110, 48, 96, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(70, 120, 120,30);
		contentPanel.add(btnCancel);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearData() {
		textField.setText("");
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.DELETE_PRODUCT_OK:
			JOptionPane.showMessageDialog(null, "Product " + context.getDetails() + "delete successfully.");
			this.dispose();
			break;
		case Events.DELETE_PRODUCT_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The product does not exist");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "The indicated product has already been eliminated");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error to remove product");
			}
			break;
		}
	}
}
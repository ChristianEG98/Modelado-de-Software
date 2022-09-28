/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Fair.imp.TFair;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUICreateFair extends GUIFair{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	private JTextField textNameFair;
	private JTextField textCapacity;
	private JTextField textPlace;
	private JPanel contentPane;
		

	public GUICreateFair(){
		super();
		
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setTitle("CREATE FAIR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("Name fair: ");
		name.setBounds(10, 16, 94, 14);
		contentPane.add(name);
		
		textNameFair= new JTextField();
		textNameFair.setBounds(114, 8, 310, 30);
		contentPane.add(textNameFair);
		textNameFair.setColumns(10);
		
		JLabel Place = new JLabel("Place: ");
		Place.setBounds(10, 85, 94, 14);
		contentPane.add(Place);
		
		textPlace = new JTextField();
		textPlace.setBounds(114, 77, 310, 30);
		contentPane.add(textPlace);
		textPlace.setColumns(10);
		
		JLabel Capacity = new JLabel("Capacity: ");
		Capacity.setBounds(10, 154, 94, 14);
		contentPane.add(Capacity);
		
		textCapacity = new JTextField();
		textCapacity.setBounds(114, 146, 310, 30);
		contentPane.add(textCapacity);
		textCapacity.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textNameFair.getText();
					String Place = textPlace.getText();
					int capacity = Integer.parseInt(textCapacity.getText());
					boolean error = false;
					if (name.equals("") || Place.equals("") || capacity < 0) {
						error = true;
					}
					if (error) {
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						TFair tfair = new TFair(true, capacity, Place, name);
						Controller.getInstance().action(new Context(Events.CREATE_FAIR, tfair));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnOk.setBounds(335, 227, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(222, 227, 89, 23);
		contentPane.add(btnExit);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void update(Context context){
		switch(context.getEvent()){
		case Events.CREATE_FAIR_OK:
			JOptionPane.showMessageDialog(null, "Fair " + context.getDetails() + " create.");
			this.dispose();
			break;
		case Events.CREATE_FAIR_KO:
			if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "The fair already exists");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error creating fair");
			}
			break;
		}
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textNameFair.setText("");
		textPlace.setText("");
		textCapacity.setText("");
	}
}
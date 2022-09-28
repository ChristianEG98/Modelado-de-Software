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
import javax.swing.JSeparator;
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
public class GUIModifyFair extends GUIFair{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idfair;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNameFair;
	private JTextField textCapacity;
	private JTextField textPlace;
	private JButton btnModify;

	public GUIModifyFair(){
		super();
		
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("MODIFY FAIR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(60, 88, 90, 14);
		contentPane.add(lblName);

		JLabel lblPlace = new JLabel("Place:");
		lblPlace.setBounds(60, 134, 90, 14);
		contentPane.add(lblPlace);

		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setBounds(60, 182, 90, 14);
		contentPane.add(lblCapacity);

		textNameFair = new JTextField();
		textNameFair.setEditable(false);
		textNameFair.setBounds(160, 85, 150, 20);
		contentPane.add(textNameFair);
		textNameFair.setColumns(10);

		textPlace = new JTextField();
		textPlace.setEditable(false);
		textPlace.setBounds(160, 131, 150, 20);
		contentPane.add(textPlace);
		textPlace.setColumns(10);

		textCapacity = new JTextField();
		textCapacity.setEditable(false);
		textCapacity.setBounds(160, 179, 150, 20);
		contentPane.add(textCapacity);
		textCapacity.setColumns(10);

		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String Name, Place;
					int Capacity;
					boolean ok = false;
					Name = textNameFair.getText();
					Place = textPlace.getText();
					Capacity = Integer.parseInt(textCapacity.getText());
					if (Name.equals("") || Place.equals("") || Capacity <= 0) {
						ok = true;
					}
					if (ok) {
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						TFair tfair = new TFair(idfair, true, Capacity, Place, Name);
						Controller.getInstance().action(new Context(Events.MODIFY_FAIR, tfair));
					}} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModify.setBounds(330, 237, 89, 23);
		contentPane.add(btnModify);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 414, 2);
		contentPane.add(separator);
		
		textId = new JTextField();
		textId.setBounds(160, 23, 150, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(60, 23, 150, 20);
		contentPane.add(lblId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textId.getText());
					idfair = id;
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_MODIFY_FAIR, id));
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JFrame(), "Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 22, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(230, 237, 89, 23);
		contentPane.add(btnCancel);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void update(Context context){
		switch(context.getEvent()){
		case Events.SEARCH_MODIFY_FAIR_OK:
			TFair fair = (TFair) context.getDetails();
			textNameFair.setText(fair.getNameFair());
			textCapacity.setText(fair.getCapacity()+"");
			textPlace.setText(fair.getPlace());
			btnModify.setEnabled(true);
			textNameFair.setEditable(true);
			textCapacity.setEditable(true);
			textPlace.setEditable(true);
			break;
		case Events.SEARCH_MODIFY_FAIR_KO:
			JOptionPane.showMessageDialog(null, "Error searching the fair");
			break;
		case Events.MODIFY_FAIR_OK:
			JOptionPane.showMessageDialog(null, "Fair " + context.getDetails() + " modify.");
			this.dispose();
			break;
		case Events.MODIFY_FAIR_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The fair does not exist");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "The fair is not active");
			}
			else if((int)context.getDetails() == -3){
				JOptionPane.showMessageDialog(null, "That fair name already exists");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error when modifying the fair");
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
		textId.setText("");
		textNameFair.setText("");
		textCapacity.setText("");
		textPlace.setText("");
		textNameFair.setEditable(false);
		textCapacity.setEditable(false);
		textPlace.setEditable(false);
	}
}
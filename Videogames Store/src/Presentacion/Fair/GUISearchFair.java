/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import java.awt.Color;
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
public class GUISearchFair extends GUIFair{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	private JTextField textIdFair;
	private JTextField textNameFair;
	private JTextField textCapacity;
	private JTextField textPlace;
	private JTextField activeType;
	private JTextField nonActiveType;

	public GUISearchFair(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setTitle("SEARCH FAIR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(60, 67, 90, 14);
		contentPane.add(lblName);

		JLabel lblPlace = new JLabel("Place:");
		lblPlace.setBounds(60, 113, 90, 14);
		contentPane.add(lblPlace);

		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setBounds(60, 160, 90, 14);
		contentPane.add(lblCapacity);

		textNameFair = new JTextField();
		textNameFair.setEditable(false);
		textNameFair.setBounds(160, 64, 150, 20);
		contentPane.add(textNameFair);
		textNameFair.setColumns(10);

		textPlace = new JTextField();
		textPlace.setEditable(false);
		textPlace.setBounds(160, 110, 150, 20);
		contentPane.add(textPlace);
		textPlace.setColumns(10);

		textCapacity = new JTextField();
		textCapacity.setEditable(false);
		textCapacity.setBounds(160, 157, 150, 20);
		contentPane.add(textCapacity);
		textCapacity.setColumns(10);

		JButton btnExit = new JButton("Close");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(330, 237, 89, 23);
		contentPane.add(btnExit);
		
		JLabel lblEstado = new JLabel("Status:");
		lblEstado.setBounds(60, 200, 90, 14);
		contentPane.add(lblEstado);
		
		activeType = new JTextField();
		activeType.setEditable(false);
		activeType.setBounds(160, 200, 150, 20);
		activeType.setBackground(Color.GREEN);
		contentPane.add(activeType);
		activeType.setColumns(10);
		
		nonActiveType = new JTextField();
		nonActiveType.setEditable(false);
		nonActiveType.setBounds(160, 200, 150, 20);
		nonActiveType.setBackground(Color.RED);
		contentPane.add(nonActiveType);
		nonActiveType.setColumns(10);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 54, 414, 2);
		contentPane.add(separator);
		
		textIdFair = new JTextField();
		textIdFair.setBounds(160, 23, 150, 20);
		contentPane.add(textIdFair);
		textIdFair.setColumns(10);
		
		JLabel lblId = new JLabel("Id fair:");
		lblId.setBounds(60, 26, 90, 14);
		contentPane.add(lblId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textIdFair.getText());
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error,the id has to be greater than 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_FAIR, id));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 22, 89, 23);
		contentPane.add(btnSearch);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void update(Context context){
		switch (context.getEvent()) {
		case Events.SEARCH_FAIR_OK:
			TFair feria = (TFair)context.getDetails();
			
			textNameFair.setText(feria.getNameFair());
			textCapacity.setText(feria.getCapacity()+"");
			textPlace.setText(feria.getPlace());
			
			if(feria.getActive()){
				activeType.setVisible(true);
				nonActiveType.setVisible(false);
			}
			else{
				activeType.setVisible(false);
				nonActiveType.setVisible(true);
			}
			break;
		case Events.SEARCH_FAIR_KO:
			JOptionPane.showMessageDialog(null, "Error searching the fair");
			break;
		}
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textIdFair.setText("");
		textNameFair.setText("");
		textCapacity.setText("");
		textPlace.setText("");
		activeType.setVisible(false); 
		nonActiveType.setVisible(false);
		/*labelActive.setVisible(false);
		labelInactive.setVisible(false);*/
	}
}
/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Negocio.Product.imp.VideogamesType;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUICreateProduct extends GUIProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	//Product
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textStock;
	//Consoles
	private JRadioButton buttonConsoles;
	private JLabel lblStorage;
	private JLabel lblManufacture;
	private JLabel lblColour;
	private JTextField textStorage;
	private JTextField textManufacture;
	private JTextField textColour;
	
	//Videogames
	private JRadioButton buttonVideoGames;
	private JComboBox<VideogamesType> comboBox;
	private JLabel lblType;
	private JLabel lblAge;
	private JLabel lblGender;
	private JTextField textAge;
	private JTextField textGender;
	
	
	public GUICreateProduct(){
		super();
		
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private void initGUI() {
		setTitle("CREATE PRODUCT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//Nombre
		JLabel lblNombre = new JLabel("Name:");
		lblNombre.setBounds(10, 16, 94, 14);
		contentPanel.add(lblNombre);
		
		textName = new JTextField();
		textName.setBounds(114, 8, 310, 30);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		//Precio
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 53, 94, 14);
		contentPanel.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(114, 45, 310, 30);
		contentPanel.add(textPrice);
		textPrice.setColumns(10);
		
		//Stock
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 89, 94, 14);
		contentPanel.add(lblStock);
		
		textStock = new JTextField();
		textStock.setBounds(114, 80, 310, 30);
		contentPanel.add(textStock);
		textStock.setColumns(10);
		
		//Capacidad
		lblStorage = new JLabel("Storage:");
		lblStorage.setBounds(10, 157, 118, 14);
		contentPanel.add(lblStorage);
		lblStorage.setVisible(false);
		
		textStorage = new JTextField();
		textStorage.setBounds(114, 150, 310, 30);
		contentPanel.add(textStorage);
		textStorage.setColumns(10);
		textStorage.setVisible(false);
		
		//Color
		lblColour = new JLabel("Colour:");
		lblColour.setBounds(10, 190, 118, 14);
		contentPanel.add(lblColour);
		lblColour.setVisible(false);
		
		textColour = new JTextField();
		textColour.setBounds(114, 185, 310, 30);
		contentPanel.add(textColour);
		textColour.setColumns(10);
		textColour.setVisible(false);
		
		//Fabricante
		lblManufacture = new JLabel("Manufacture:");
		lblManufacture.setBounds(10, 225, 118, 14);
		contentPanel.add(lblManufacture);
		lblManufacture.setVisible(false);
		
		textManufacture = new JTextField();
		textManufacture.setBounds(114, 220, 310, 30);
		contentPanel.add(textManufacture);
		textManufacture.setColumns(10);
		textManufacture.setVisible(false);
		
		//Genero
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 157, 118, 14);
		contentPanel.add(lblGender);
		lblGender.setVisible(false);
		
		textGender = new JTextField();
		textGender.setBounds(114, 150, 310, 30);
		contentPanel.add(textGender);
		textGender.setColumns(10);
		textGender.setVisible(false);
		
		//Edad
		lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 190, 118, 14);
		contentPanel.add(lblAge);
		lblAge.setVisible(false);
		
		textAge = new JTextField();
		textAge.setBounds(114, 185, 310, 30);
		contentPanel.add(textAge);
		textAge.setColumns(10);
		textAge.setVisible(false);
		
		//Tipo
		lblType = new JLabel("Platform:");
		lblType.setBounds(10, 225, 118, 14);
		contentPanel.add(lblType);
		
		comboBox = new JComboBox<VideogamesType>();
		comboBox.setModel(new DefaultComboBoxModel<VideogamesType>(VideogamesType.values()));
		comboBox.setBounds(114, 220, 310, 30);
		contentPanel.add(comboBox);
		
		comboBox.setVisible(false);
    	lblType.setVisible(false);
    	buttonVideoGames = new JRadioButton("Videogame");
    	buttonVideoGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	lblStorage.setVisible(false);
            	textStorage.setVisible(false);
            	
            	lblManufacture.setVisible(false);
            	textManufacture.setVisible(false);
            	
            	lblColour.setVisible(false);
            	textColour.setVisible(false);
            	
            	lblGender.setVisible(true);
            	textGender.setVisible(true);
            	
            	lblAge.setVisible(true);
            	textAge.setVisible(true);
            	
            	comboBox.setVisible(true);
            	lblType.setVisible(true);
            }
        });
		buttonGroup.add(buttonVideoGames);
		buttonVideoGames.setBounds(54, 117, 165, 23);
		contentPanel.add(buttonVideoGames);
		
		buttonConsoles = new JRadioButton("Console");
		buttonConsoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	lblStorage.setVisible(true);
            	textStorage.setVisible(true);
            	
            	lblManufacture.setVisible(true);
            	textManufacture.setVisible(true);
            	
            	lblColour.setVisible(true);
            	textColour.setVisible(true);
            	
            	lblGender.setVisible(false);
            	textGender.setVisible(false);
            	
            	lblAge.setVisible(false);
            	textAge.setVisible(false);
            	
            	comboBox.setVisible(false);
            	lblType.setVisible(false);
            }
        });
		buttonGroup.add(buttonConsoles);
		buttonConsoles.setBounds(249, 117, 109, 23);
		contentPanel.add(buttonConsoles);
		
		JButton btnAceptar = new JButton("Create");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					boolean error = false;
					String nombre = textName.getText();
					Float precio = Float.parseFloat(textPrice.getText());
					int stock = Integer.parseInt(textStock.getText());
					
					int capacidad = -1;
					String fabricante = null;
					String color = null;
					
					String genero = null;
					int edad = -1;
					VideogamesType tipo = null;
					
					if(nombre.equals("") || precio < 0 || stock < 0){
						error = true;
					}
					
					if(buttonVideoGames.isSelected()){
						edad = Integer.parseInt(textAge.getText());
						genero = textGender.getText().toString();
						tipo = (VideogamesType) comboBox.getSelectedItem();
						
						if (edad < 0 || genero == null || tipo == null) error = true;
					} else if (buttonConsoles.isSelected()) {
						capacidad = Integer.parseInt(textStorage.getText());
						fabricante = textManufacture.getText().toString();
						color = textColour.getText().toString();
						
						if (capacidad < 0 || fabricante == null || color == null) error = true;
					}
					if (error) {
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (buttonVideoGames.isSelected()) {
							TVideogames tVideogame = new TVideogames(nombre, precio, stock, true, genero, tipo, edad);
							Controller.getInstance().action(new Context(Events.CREATE_PRODUCT, tVideogame));
						} else if (buttonConsoles.isSelected()) {
							TConsoles tConsole = new TConsoles(nombre, precio, stock, true, capacidad, color, fabricante);
							Controller.getInstance().action(new Context(Events.CREATE_PRODUCT, tConsole));
						}
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(335, 280, 89, 23);
		contentPanel.add(btnAceptar);
		
		JButton btnSalir = new JButton("Close");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(20, 280, 89, 23);
		contentPanel.add(btnSalir);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	public void clearData() {
    	lblStorage.setVisible(false);
    	textStorage.setVisible(false);
    	lblManufacture.setVisible(false);
    	textManufacture.setVisible(false);
    	lblColour.setVisible(false);
    	textColour.setVisible(false);
    	lblGender.setVisible(false);
    	textGender.setVisible(false);
    	lblAge.setVisible(false);
    	textAge.setVisible(false);
    
    	textName.setText("");
    	textPrice.setText("");
    	textStock.setText("");
    	textManufacture.setText("");
    	textGender.setText("");
    	textAge.setText("");
    	textColour.setText("");
    	textStorage.setText("");
;    	
    	
    	buttonConsoles.setSelected(false);
    	buttonVideoGames.setSelected(false);
    	buttonGroup.clearSelection();
    	
    	comboBox.setVisible(false);
    	lblType.setVisible(false);
	}
	
	
	public void update(Context context) {
		switch(context.getEvent()){
			case Events.CREATE_PRODUCT_OK:
				JOptionPane.showMessageDialog(null, "Product " + context.getDetails() + " create.");
				this.dispose();
				break;
			case Events.CREATE_PRODUCT_KO:
				if((int)context.getDetails() == -1){
					JOptionPane.showMessageDialog(null, "There is already a product with that name");
				}
				else if((int)context.getDetails() == -2){
					JOptionPane.showMessageDialog(null, "Cannot reactivate a product of a different type");
				}
				else{
					JOptionPane.showMessageDialog(null, "Error creating product");
				}
				
				break;
		}
	}


}
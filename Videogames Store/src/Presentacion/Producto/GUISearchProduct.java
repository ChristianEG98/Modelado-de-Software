/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

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

import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUISearchProduct extends GUIProduct {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	
	//Product
	private JTextField textIdProduct;
		private JTextField textName;
		private JTextField textPrice;
		private JTextField textStock;
		private JTextField activeType;
		private JTextField nonActiveType;
		//Consoles
		private JLabel lblStorage;
		private JLabel lblManufacture;
		private JLabel lblColour;
		private JTextField textStorage;
		private JTextField textManufacture;
		private JTextField textColour;
		//Videogames
		private JTextField textType;
		private JLabel lblType;
		private JLabel lblAge;
		private JLabel lblGender;
		private JTextField textAge;
		private JTextField textGender;
		private JLabel lblEstado;
		
		public GUISearchProduct(){
			super();
			initGUI();
			this.setLocationRelativeTo(null);
		}
		
	private void initGUI() {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
		setTitle("SEARCH PRODUCT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 350);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		setContentPane(contentPanel);
		
		JLabel lblIdProducto = new JLabel("Id Product:");
		lblIdProducto.setBounds(10, 23, 90, 14);
		contentPanel.add(lblIdProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 424, 2);
		contentPanel.add(separator);
		
		textIdProduct = new JTextField();
		textIdProduct.setBounds(140, 20, 150, 20);
		contentPanel.add(textIdProduct);
		textIdProduct.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textIdProduct.getText());
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Wrong information (Id has to be greater than 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_PRODUCT, id));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setBounds(330, 19, 89, 23);
		contentPanel.add(btnSearch);
		
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 67, 90, 14);
		contentPanel.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 98, 90, 14);
		contentPanel.add(lblPrice);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 129, 90, 14);
		contentPanel.add(lblStock);
		
		textName = new JTextField();
		textName.setEditable(false);
		textName.setBounds(140, 64, 150, 20);
		contentPanel.add(textName);
		textName.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setEditable(false);
		textPrice.setBounds(140, 95, 150, 20);
		contentPanel.add(textPrice);
		textPrice.setColumns(10);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		textStock.setBounds(140, 126, 150, 20);
		contentPanel.add(textStock);
		textStock.setColumns(10);
		
		lblStorage = new JLabel("Storage:");
		lblStorage.setBounds(10, 160, 118, 14);
		contentPanel.add(lblStorage);
		
		textStorage = new JTextField();
		textStorage.setBounds(140, 157, 150, 20);
		textStorage.setEditable(false);
		contentPanel.add(textStorage);
		textStorage.setColumns(10);
		
		lblManufacture = new JLabel("Colour:");
		lblManufacture.setBounds(10, 225, 118, 14);
		contentPanel.add(lblManufacture);
		
		textManufacture = new JTextField();
		textManufacture.setBounds(140, 220, 150, 20);
		textManufacture.setEditable(false);
		contentPanel.add(textManufacture);
		textManufacture.setColumns(10);
		
		lblColour = new JLabel("Manufacture:");
		lblColour.setBounds(10, 192, 118, 14);
		contentPanel.add(lblColour);
				
		textColour = new JTextField();
		textColour.setBounds(140, 190, 150, 20);
		textColour.setEditable(false);
		contentPanel.add(textColour);
		textColour.setColumns(10);
				
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 160, 118, 14);
		contentPanel.add(lblGender);
		
		textGender = new JTextField();
		textGender.setBounds(140, 157, 150, 20);
		textGender.setEditable(false);
		contentPanel.add(textGender);
		textGender.setColumns(10);
		
		lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 192, 118, 14);
		contentPanel.add(lblAge);
		
		textAge = new JTextField();
		textAge.setBounds(140, 190, 150, 20);
		textAge.setEditable(false);
		contentPanel.add(textAge);
		textAge.setColumns(10);
		
		lblType = new JLabel("Platform:");
		lblType.setBounds(10, 225, 118, 14);
		contentPanel.add(lblType);
		
		textType = new JTextField();
		textType.setEditable(false);
		textType.setBounds(140, 220, 150, 20);
		contentPanel.add(textType);
		textType.setColumns(10);
		
		JButton btnAceptar = new JButton("Close");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(330, 280, 89, 23);
		contentPanel.add(btnAceptar);
		
		lblEstado = new JLabel("Active:");
		lblEstado.setBounds(10, 255, 120, 14);
		contentPanel.add(lblEstado);
		
		activeType = new JTextField();
		activeType.setEditable(false);
		activeType.setBounds(140, 252, 150, 20);
		activeType.setBackground(Color.GREEN);
		contentPanel.add(activeType);
		activeType.setColumns(10);
		
		nonActiveType = new JTextField();
		nonActiveType.setEditable(false);
		nonActiveType.setBounds(140, 252, 150, 20);
		nonActiveType.setBackground(Color.RED);
		contentPanel.add(nonActiveType);
		nonActiveType.setColumns(10);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void clearData() {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
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
    	lblType.setVisible(false);
    	textType.setVisible(false);
		activeType.setVisible(false);
		nonActiveType.setVisible(false);
		textIdProduct.setText("");
    	textName.setText("");
    	textPrice.setText("");
    	textStock.setText("");
    	textAge.setText("");
    	textType.setText("");
    	
    	
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.SEARCH_PRODUCT_OK:
			TProduct tProduct = (TProduct)context.getDetails();
			
			textName.setText(tProduct.getName());
			textPrice.setText(tProduct.getPrice()+"");
			textStock.setText(tProduct.getStock()+"");
			if(tProduct instanceof TConsoles){
				textStorage.setText(((TConsoles) tProduct).getStorage()+"");
				textManufacture.setText(((TConsoles) tProduct).getManufacturer()+"");
				textColour.setText(((TConsoles) tProduct).getColour()+"");
				textStorage.setVisible(true);
				textManufacture.setVisible(true);
				textColour.setVisible(true);
				textType.setVisible(false);
				textGender.setVisible(false);
				textAge.setVisible(false);
				lblStorage.setVisible(true);
				lblColour.setVisible(true);
				lblManufacture.setVisible(true);
				lblType.setVisible(false);
				lblGender.setVisible(false);
				lblAge.setVisible(false);
			}
			if(tProduct instanceof TVideogames){
				textType.setText(((TVideogames) tProduct).getPlatform()+"");
				textGender.setText(((TVideogames) tProduct).getGender()+"");
				textAge.setText(((TVideogames) tProduct).getAge()+"");
				textStorage.setVisible(false);
				textManufacture.setVisible(false);
				textColour.setVisible(false);
				textType.setVisible(true);
				textGender.setVisible(true);
				textAge.setVisible(true);
				lblStorage.setVisible(false);
				lblColour.setVisible(false);
				lblManufacture.setVisible(false);
				lblType.setVisible(true);
				lblGender.setVisible(true);
				lblAge.setVisible(true);
			}
			
			if(tProduct.getActive()){
				activeType.setVisible(true);
				nonActiveType.setVisible(false);
			}
			else{
				activeType.setVisible(false);
				nonActiveType.setVisible(true);
			}
			break;
		case Events.SEARCH_PRODUCT_KO:
			JOptionPane.showMessageDialog(null, "Error searching for the product");
			break;
		}
		
	
	}

}
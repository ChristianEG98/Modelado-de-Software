/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import _2.Diseño.Negocio.Product.imp.VideogamesType;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIModifyProduct extends GUIProduct {
	private static final long serialVersionUID = 3544475956378616643L;
	private JPanel contentPane;
	private JTextField textIdproduct;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textStock;
	private int idProduct;
	private TProduct tProduct;
	
	//consoles
	private JLabel lblStorage;
	private JLabel lblManufacture;
	private JLabel lblColour;
	private JTextField textStorage;
	private JTextField textManufacture;
	private JTextField textColour;
	
	//videogames
	private JComboBox<VideogamesType> comboBox;
	private JLabel lblType;
	private JLabel lblAge;
	private JLabel lblGender;
	private JTextField textAge;
	private JTextField textGender;
	private JButton btnModificar;
	
	
	public GUIModifyProduct()
	{
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
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
		setTitle("MODIFY PRODUCT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblIdProducto = new JLabel("Id Product:");
		lblIdProducto.setBounds(10, 23, 90, 14);
		contentPane.add(lblIdProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 424, 2);
		contentPane.add(separator);
		
		textIdproduct = new JTextField();
		textIdproduct.setBounds(140, 20, 150, 20);
		contentPane.add(textIdproduct);
		textIdproduct.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idproduct;
					idproduct = Integer.parseInt(textIdproduct.getText());
					idProduct = idproduct; 
					if (idproduct <= 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Wrong information (Idproduct has to be greater than 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controller.getInstance().action(new Context(Events.SEARCH_MODIFY_PRODUCT, idproduct));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSearch.setBounds(330, 19, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 67, 90, 14);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 98, 90, 14);
		contentPane.add(lblPrice);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 129, 90, 14);
		contentPane.add(lblStock);
		
		textName = new JTextField();
		textName.setEditable(false);
		textName.setBounds(140, 64, 150, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textPrice = new JTextField();
		textPrice.setEditable(false);
		textPrice.setBounds(140, 95, 150, 20);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		textStock.setBounds(140, 126, 150, 20);
		contentPane.add(textStock);
		textStock.setColumns(10);
		
		lblStorage = new JLabel("Storage:");
		lblStorage.setBounds(10, 157, 118, 14);
		contentPane.add(lblStorage);
				
		textStorage = new JTextField();
		textStorage.setBounds(140, 155, 150, 20);
		contentPane.add(textStorage);
			
		lblColour = new JLabel("Manufacture:");
		lblColour.setBounds(10, 190, 118, 14);
		contentPane.add(lblColour);
					
		textColour = new JTextField();
		textColour.setBounds(140, 185, 150, 20);
		contentPane.add(textColour);
				

		lblManufacture = new JLabel("Colour:");
		lblManufacture.setBounds(10, 225, 118, 14);
		contentPane.add(lblManufacture);
				
		textManufacture = new JTextField();
		textManufacture.setBounds(140, 220, 150, 20);
		contentPane.add(textManufacture);
				
		lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 157, 118, 14);
		contentPane.add(lblGender);
				
		textGender = new JTextField();
		textGender.setBounds(140, 155, 150, 20);
		contentPane.add(textGender);
				
		lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 190, 118, 14);
		contentPane.add(lblAge);
				
		textAge = new JTextField();
		textAge.setBounds(140, 185, 150, 20);
		contentPane.add(textAge);
				
		lblType = new JLabel("Platform:");
		lblType.setBounds(10, 225, 118, 14);
		contentPane.add(lblType);
				
		comboBox = new JComboBox<VideogamesType>();
		comboBox.setModel(new DefaultComboBoxModel<VideogamesType>(VideogamesType.values()));
		comboBox.setBounds(140, 220, 150, 20);
		contentPane.add(comboBox);
				
		 btnModificar = new JButton("Modify");
		 btnModificar.setEnabled(false);
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String name, gender = null,colour = null, manufacture = null ;
							int stock, age = 0,storage=0 ;
							float price;
							VideogamesType type = null;
							boolean error = false;

							name = textName.getText();
							price = Float.parseFloat(textPrice.getText());
							stock = Integer.parseInt(textStock.getText());

							if (name.equals("") || price < 0 || stock < 0) {
								error = true;
							}
							if (tProduct instanceof TConsoles) {
								storage = Integer.parseInt(textStorage.getText());
								manufacture = textManufacture.getText();
								colour=textColour.getText();

								if (storage < 0 ) {
									error = true;
								}
							}
							if (tProduct instanceof TVideogames) {
								age = Integer.parseInt(textAge.getText()); //esto era textStorage y por eso cascaba
								if (age < 0 ) {
									error = true;
								}
								gender=textGender.getText();
								type = (VideogamesType) comboBox.getSelectedItem();
								if (type == null) {
									error = true;
								}
							}
							if (error) {
								JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								if (tProduct instanceof TConsoles) {
									TConsoles tNewConsoles = new TConsoles(idProduct, name, price, stock, true, storage, colour, manufacture);
									Controller.getInstance().action(new Context(Events.MODIFY_PRODUCT, tNewConsoles));
								}
								if (tProduct instanceof TVideogames) {
									TVideogames tNewVideogames = new TVideogames(idProduct, name, price, stock, true, gender, type, age);
									Controller.getInstance().action(new Context(Events.MODIFY_PRODUCT, tNewVideogames));
								}

							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnModificar.setBounds(330, 260, 89, 23);
				contentPane.add(btnModificar);
				
				JButton btnClose = new JButton("Close");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnClose.setBounds(330, 230, 89, 23);
				contentPane.add(btnClose);
				
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
    	comboBox.setVisible(false);
    	lblType.setVisible(false);
    	textName.setEditable(false);
		textPrice.setEditable(false);
		textStock.setEditable(false);
    	textIdproduct.setText("");
    	textName.setText("");
    	textPrice.setText("");
    	textStock.setText("");
    	textAge.setText("");
    	textStorage.setText("");
    	textGender.setText("");
    	textColour.setText("");
    	textManufacture.setText("");
    	
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void update(Context context) {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
		switch(context.getEvent()){
		case Events.MODIFY_PRODUCT_OK:
			JOptionPane.showMessageDialog(null, "Product " + context.getDetails() + "successfully modified.");
			this.dispose();
			break;
		case Events.MODIFY_PRODUCT_KO:
			if((int)context.getDetails() == -1){
				JOptionPane.showMessageDialog(null, "The product does not");
			}
			else if((int)context.getDetails() == -2){
				JOptionPane.showMessageDialog(null, "There is already a product with that name");
			}
			else if((int)context.getDetails() == -3){
				JOptionPane.showMessageDialog(null, "The product is not active");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error modifying the product");
			}
			
			break;
		case Events.SEARCH_MODIFY_PRODUCT_OK:
			tProduct = (TProduct) context.getDetails();
			textName.setEditable(true);
			textPrice.setEditable(true);
			textStock.setEditable(true);
			btnModificar.setEnabled(true);
			textName.setText(tProduct.getName());
			textPrice.setText(tProduct.getPrice()+"");
			textStock.setText(tProduct.getStock()+"");
			
			if(tProduct instanceof TConsoles){	
				lblStorage.setVisible(true);
				lblManufacture.setVisible(true);
				lblColour.setVisible(true);
				textStorage.setVisible(true);
				textManufacture.setVisible(true);
				textColour.setVisible(true);
				
				textStorage.setText(((TConsoles) tProduct).getStorage()+"");
				textManufacture.setText(((TConsoles) tProduct).getManufacturer()+"");
				textColour.setText(((TConsoles) tProduct).getColour()+"");
				comboBox.setVisible(false);
				lblType.setVisible(false);
				lblAge.setVisible(false);
				lblGender.setVisible(false);
			}
			if(tProduct instanceof TVideogames){
				lblStorage.setVisible(false);
				lblManufacture.setVisible(false);
				lblColour.setVisible(false);
				textStorage.setVisible(false);
				textManufacture.setVisible(false);
				textColour.setVisible(false);
				comboBox.setVisible(true);
				lblType.setVisible(true);
				lblAge.setVisible(true);
				lblGender.setVisible(true);
				textAge.setVisible(true);
				textGender.setVisible(true);
				textAge.setText(((TVideogames) tProduct).getAge()+"");
				textGender.setText(((TVideogames) tProduct).getGender()+"");	
				comboBox.setSelectedItem(((TVideogames) tProduct).getPlatform());
			}
			
			break;
		case Events.SEARCH_MODIFY_PRODUCT_KO:
			JOptionPane.showMessageDialog(null, "Error searching for the product");
			break;
		}
	}
}
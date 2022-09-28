/**
 * 
 */
package _2.Diseño.Presentacion.Producto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIProductImp extends GUIProduct {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUISearchProductsByPrice gUISearchProductsByPrice;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUICreateProduct gUICreateProduct;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUISearchProduct gUISearchProduct;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIModifyProduct gUIModifyProduct;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIDeleteProduct gUIDeleteProduct;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIListProducts gUIListProducts;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private GUIListProducts gUIBestSellingProductsSinceXDate;
	
	
	private JPanel contentPanel;
	JButton buttonCreateProduct;
	JButton buttonDeleteProduct;
	JButton buttonModifyProduct;
	JButton buttonSearchProduct;
	JButton buttonListProducts;
	JButton buttonSearchProductPrice;
	JButton buttonBestSellingProducts;
	
	public GUIProductImp(){
		super();
		gUICreateProduct= new GUICreateProduct();
		gUIDeleteProduct= new GUIDeleteProduct();
		gUIModifyProduct = new GUIModifyProduct();
		gUISearchProduct= new GUISearchProduct();
		gUIListProducts= new GUIListProducts();
		gUISearchProductsByPrice= new GUISearchProductsByPrice();
		gUIBestSellingProductsSinceXDate = new GUIBestSellingProductsSinceXDate();
		
		setResizable(false);
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	
	private void initGUI() {
		this.setTitle("PRODUCTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(192, 217, 252));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//CREATE PRODUCT
		buttonCreateProduct = new JButton("CREATE PRODUCT");
		buttonCreateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUICreateProduct.clearData();
				gUICreateProduct.setVisible(true); 
			}
		});
		buttonCreateProduct.setBounds(10, 30, 200, 45);
		contentPanel.add(buttonCreateProduct );
		
		//DELETE PRODUCT
		buttonDeleteProduct = new JButton("DELETE PRODUCT");
		buttonDeleteProduct .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIDeleteProduct.clearData(); 
				gUIDeleteProduct.setVisible(true); 
			}
		});
		buttonDeleteProduct.setBounds(224, 30, 200, 45);
		contentPanel.add(buttonDeleteProduct);
		
		//MODIFY PRODUCT
		buttonModifyProduct = new JButton("MODIFY PRODUCT");
		buttonModifyProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModifyProduct.clearData();
				gUIModifyProduct.setVisible(true);
			}
		});
		buttonModifyProduct.setBounds(10, 90, 200, 45);
		contentPanel.add(buttonModifyProduct);
		
		//SEARCH PRODUCT
		buttonSearchProduct = new JButton("SEARCH PRODUCT");
		buttonSearchProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUISearchProduct.clearData();
				gUISearchProduct.setVisible(true);
			}
		});
		buttonSearchProduct.setBounds(224, 90, 200, 45);
		contentPanel.add(buttonSearchProduct);
		
		//LIST PRODUCTS
		buttonListProducts = new JButton("LIST PRODUCTS");
		buttonListProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIListProducts.clearData();
				gUIListProducts.setVisible(true);
				Controller.getInstance().action(new Context(Events.LIST_PRODUCTS, null));
				gUIListProducts.toFront();
			}
		});
		buttonListProducts.setBounds(10, 150, 200, 45);
		contentPanel.add(buttonListProducts);
		
		//SEARCH PRODUCT PRICE
		buttonSearchProductPrice = new JButton("SEARCH PRODUCT BY PRICE");
		buttonSearchProductPrice .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUISearchProductsByPrice.clearData();
				gUISearchProductsByPrice.setVisible(true);
			}
		});
		buttonSearchProductPrice .setBounds(224, 150, 200, 45);
		contentPanel.add(buttonSearchProductPrice );
		
		//BEST SELLING PRODUCTS SINCE X DATE
		buttonBestSellingProducts = new JButton("BEST SELLING PRODUCTS SINCE X DATE");
		buttonBestSellingProducts .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBestSellingProductsSinceXDate.clearData();
				gUIBestSellingProductsSinceXDate.setVisible(true);
			}
		});
		buttonBestSellingProducts.setBounds(50, 210, 350, 45);
		
		contentPanel.add(buttonBestSellingProducts);
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
		btMainMenu.setBounds(115, 270, 200, 45);
		contentPanel.add(btMainMenu);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public void update (Context context)
	{
		switch(context.getEvent()){
		case Events.CREATE_PRODUCT_OK:
			gUICreateProduct.update(context);
			break;
		case Events.CREATE_PRODUCT_KO:
			gUICreateProduct.update(context);
			break;
		case Events.LIST_PRODUCTS_OK:
			gUIListProducts.update(context);
			break;
		case Events.LIST_PRODUCTS_KO:
			gUIListProducts.update(context);
			break;
		case Events.SEARCH_PRODUCTS_BY_PRICE_OK:
			gUISearchProductsByPrice.update(context);
			break;
		case Events.SEARCH_PRODUCTS_BY_PRICE_KO:
			gUISearchProductsByPrice.update(context);
			break;
		case Events.DELETE_PRODUCT_OK:
			gUIDeleteProduct.update(context);
			break;
		case Events.DELETE_PRODUCT_KO:
			gUIDeleteProduct.update(context);
			break;
		case Events.SEARCH_PRODUCT_OK:
			gUISearchProduct.update(context);
			break;
		case Events.SEARCH_PRODUCT_KO:
			gUISearchProduct.update(context);
			break;
		case Events.SEARCH_MODIFY_PRODUCT_OK:
			gUIModifyProduct.update(context);
			break;
		case Events.SEARCH_MODIFY_PRODUCT_KO:
			gUIModifyProduct.update(context);
			break;
		case Events.MODIFY_PRODUCT_OK:
			gUIModifyProduct.update(context);
			break;
		case Events.MODIFY_PRODUCT_KO:
			gUIModifyProduct.update(context);
			break;
		case Events.BEST_SELLING_PRODUCTS_OK:
			gUIBestSellingProductsSinceXDate.update(context);
			break;
		case Events.BEST_SELLING_PRODUCTS_KO:
			gUIBestSellingProductsSinceXDate.update(context);
			break;
	}
	}
}
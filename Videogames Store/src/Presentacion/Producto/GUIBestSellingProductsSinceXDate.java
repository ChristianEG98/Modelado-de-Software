package _2.Diseño.Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Controller.Controller;

public class GUIBestSellingProductsSinceXDate extends GUIListProducts {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Name", "Price", "Stock", "Storage", "Colour", "Manufacture", "Gender", "Age", "Platform"};
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField textField;
	
	public GUIBestSellingProductsSinceXDate(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("serial")
	private void initGUI(){
		setTitle("BESt SELLING PRODUCTS SINCE SPECIFIC DATE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 614, 177);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		tableModel.setColumnCount(0);

		for (int i = 0; i < columnNames.length; ++i) {
			tableModel.addColumn(columnNames[i]);
		}
		
		table.setModel(tableModel);
		
		JLabel lblFecha = new JLabel("Date (yyyy-mm-dd):");
		lblFecha.setBounds(244, 11, 136, 14);
		contentPane.add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(390, 8, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 614, 2);
		contentPane.add(separator);
		
		JButton btnBuscar = new JButton("Search");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.sql.Date fecha;
					fecha = Date.valueOf(textField.getText());
					
					TQuery tQuery = new TQuery(fecha);
					clearData();
					Controller.getInstance().action(new Context(Events.BEST_SELLING_PRODUCTS, tQuery));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Wrong information", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(533, 7, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAceptar = new JButton("OK");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(504, 235, 120, 23);
		contentPane.add(btnAceptar);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
		table.setEnabled(false);
		this.textField.setText("");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Context context) {
		switch(context.getEvent()){
		case Events.BEST_SELLING_PRODUCTS_OK:
			
			@SuppressWarnings("unchecked") ArrayList<TProduct> res = (ArrayList<TProduct>) context.getDetails();
			if(res.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no products");
			
			for (int i = 0; i < res.size(); i++) {

				if (res.get(i) instanceof TVideogames) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
							res.get(i).getIdProduct(),
							res.get(i).getName(),
							res.get(i).getPrice(),
							res.get(i).getStock(),
							"-",
							"-",
							"-",
							((TVideogames)res.get(i)).getGender(),
							((TVideogames)res.get(i)).getAge(),
							((TVideogames)res.get(i)).getPlatform(),
							});
				}
				else if (res.get(i) instanceof TConsoles){
					tableModel.insertRow(i, new Object[] 
							{ i+1,
							res.get(i).getIdProduct(),
							res.get(i).getName(),
							res.get(i).getPrice(),
							res.get(i).getStock(),
							((TConsoles)res.get(i)).getStorage(),
							((TConsoles)res.get(i)).getManufacturer(),
							((TConsoles)res.get(i)).getColour(),
							"-",
							"-",
							"-",
							});
				}
			}
			table.setModel(tableModel);
			break;
			
		case Events.BEST_SELLING_PRODUCTS_KO:
			JOptionPane.showMessageDialog(null, "Error when listing the best-selling products", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}

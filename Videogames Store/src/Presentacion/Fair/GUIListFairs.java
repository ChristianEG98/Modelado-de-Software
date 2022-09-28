/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import _2.Diseño.Negocio.Fair.imp.TFair;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class GUIListFairs extends GUIFair{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private String[] columnNames = { "&", "IdFair", "NameFair","Place", "Capacity" };
	private DefaultTableModel tableModel;

	public GUIListFairs(){
		super();
		initGUI();
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() {
		setResizable(false);
		setTitle("LIST FAIRS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 604, 208);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel(){
			private static final long serialVersionUID = 1L;

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
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(260, 227, 120, 23);
		contentPane.add(btnOk);
	}
	
	public void update(Context context){
		switch (context.getEvent()) {
		case Events.LIST_FAIRS_OK:

			@SuppressWarnings("unchecked") List<TFair> res = (List<TFair>) context.getDetails();
			if (res.size() == 0)
				JOptionPane.showMessageDialog(null, "There are no fairs");

			for (int i = 0; i < res.size(); i++) {

				tableModel.insertRow(i, new Object[] { i + 1, res.get(i).getIdFair(), res.get(i).getNameFair(),
						res.get(i).getPlace(), res.get(i).getCapacity() });

			}
			table.setModel(tableModel);
			break;

		case Events.LIST_FAIRS_KO:
			JOptionPane.showMessageDialog(null, "Error listing fairs", "Error listing", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
	}
}
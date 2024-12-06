package Interface;

import Data.*;
import subClass.*;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class orderPanel extends JPanel {
	private final JPanel ordPanel = new JPanel();
	private JTextField ordTextField;
	private JPanel infoPanel;
	private JTextField prodNameTextField;
	private JTextField cusTextField;
	private JTextField empTextField;
	private JTextField prodNameInput;
	private JTextField cusInput;
	private JTextField empInput;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnSortProduct;
	private JButton btnSortCustomer;
	private JButton btnSortEmployee;
	private JTable ordTable;
	private JScrollPane ordScrollPanel;
	private DefaultTableModel model;
	private JTable productTable;
	private JScrollPane productSearch;
	private DefaultTableModel productModel;
	private JTable employeeTable;
	private JScrollPane employeeSearch;
	private DefaultTableModel employeeModel;
	private orderData orders = new orderData();               
	private stringFormat format = new stringFormat();
	private JTextField quantityInput;
	private JTextField txtQuantity;
	/**
	 * Create the panel.
	 */
	public orderPanel() {
		setLayout(null);
		ordPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ordPanel.setBounds(0, 0, 1215, 735);
		add(ordPanel);
		ordPanel.setLayout(null);
		setVisible(true);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		searchPanel.setBounds(25, 25, 350, 75);
		ordPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		ordTextField = new JTextField();
		ordTextField.setEditable(false);
		ordTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ordTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		ordTextField.setHorizontalAlignment(SwingConstants.LEFT);
		ordTextField.setText("Order Info:");
		ordTextField.setBounds(20, 20, 120, 30);
		searchPanel.add(ordTextField);
		ordTextField.setColumns(10);
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoPanel.setBounds(25, 155, 350, 400);
		ordPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		prodNameTextField = new JTextField();
		prodNameTextField.setText("Product:");
		prodNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		prodNameTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		prodNameTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
		prodNameTextField.setEditable(false);
		prodNameTextField.setColumns(10);
		prodNameTextField.setBounds(10, 20, 120, 30);
		infoPanel.add(prodNameTextField);
		
		quantityInput = new JTextField();
		quantityInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		quantityInput.setColumns(10);
		quantityInput.setBounds(140, 70, 180, 30);
		infoPanel.add(quantityInput);
		
		txtQuantity = new JTextField();
		txtQuantity.setText("Quantity:");
		txtQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		txtQuantity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtQuantity.setEditable(false);
		txtQuantity.setColumns(10);
		txtQuantity.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtQuantity.setBounds(10, 70, 120, 30);
		infoPanel.add(txtQuantity);
		
		cusTextField = new JTextField();
		cusTextField.setText("Customer: ");
		cusTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cusTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cusTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		cusTextField.setEditable(false);
		cusTextField.setColumns(10);
		cusTextField.setBounds(10, 120, 120, 30);
		infoPanel.add(cusTextField);
		
		empTextField = new JTextField();
		empTextField.setText("Employee:");
		empTextField.setHorizontalAlignment(SwingConstants.LEFT);
		empTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		empTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		empTextField.setEditable(false);
		empTextField.setColumns(10);
		empTextField.setBounds(10, 170, 120, 30);
		infoPanel.add(empTextField);
		
		prodNameInput = new JTextField();
		prodNameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model =
						(DefaultTableModel) productTable.getModel();
				TableRowSorter<DefaultTableModel> search = new TableRowSorter<>(model);
				productTable.setRowSorter(search);
				search.setRowFilter(RowFilter.regexFilter(prodNameInput.getText()));
			}
		});
		prodNameInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		prodNameInput.setColumns(10);
		prodNameInput.setBounds(140, 20, 180, 30);
		infoPanel.add(prodNameInput);
		
		cusInput = new JTextField();
		cusInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar())) {
						e.consume();
				}
			}
		});
		cusInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cusInput.setColumns(10);
		cusInput.setBounds(140, 120, 180, 30);
		infoPanel.add(cusInput);
		
		empInput = new JTextField();
		empInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel model =
						(DefaultTableModel) productTable.getModel();
				TableRowSorter<DefaultTableModel> search = new TableRowSorter<>(model);
				productTable.setRowSorter(search);
				search.setRowFilter(RowFilter.regexFilter(empInput.getText()));
			}
		});
		empInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		empInput.setColumns(10);
		empInput.setBounds(140, 170, 180, 30);
		infoPanel.add(empInput);
		
		
		ordTable = new JTable();
		ordTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) ordTable.getModel();
				String product = tblModel.getValueAt(ordTable.getSelectedRow(), 0).toString();
				String customer = tblModel.getValueAt(ordTable.getSelectedRow(), 1).toString();
				String employee = tblModel.getValueAt(ordTable.getSelectedRow(), 2).toString();
				
				prodNameInput.setText(product);
				cusInput.setText(customer);
				empInput.setText(employee);
			}
		});
		ordTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ordTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		model = new DefaultTableModel();
		Object[] orderCols = {"Product", "Quantity", "Customer", "Employee"};
		model.setColumnIdentifiers(orderCols);
		ordTable.setModel(model);
		ordTable.setBounds(700, 25, 490, 685);
		
		ordScrollPanel = new JScrollPane();
		ordScrollPanel.setBounds(700, 25, 490, 685);
		ordPanel.add(ordScrollPanel);
		ordScrollPanel.setViewportView(ordTable);
		
		productSearch = new JScrollPane();
		productSearch.setBounds(400, 25, 290, 330);
		ordPanel.add(productSearch);
		
		productTable = new JTable();
		productTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) productTable.getModel();
				if (tblModel.getValueAt(productTable
						.getSelectedRow(), 0) != null) {
					String product = tblModel.getValueAt(productTable.getSelectedRow(), 0).toString();
					prodNameInput.setText(product);
				}
			}
		});
		productTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		productTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		productModel = new DefaultTableModel();
		Object[] productCols = {"Product"};
		productModel.setColumnIdentifiers(productCols);
		productTable.setModel(productModel);
		productTable.setBounds(400, 25, 290, 685);
		productSearch.setViewportView(productTable);
		
		employeeSearch = new JScrollPane();
		employeeSearch.setBounds(400, 369, 290, 340);
		ordPanel.add(employeeSearch);
		
		employeeTable = new JTable();
		employeeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) employeeTable.getModel();
				if (tblModel.getValueAt(employeeTable
						.getSelectedRow(), 0) != null) {
					String employee = tblModel.getValueAt(employeeTable.getSelectedRow(), 0).toString();
					empInput.setText(employee);
				}
			}
		});
		employeeTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		employeeTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		employeeModel = new DefaultTableModel();
		Object[] employeeCols = {"Product"};
		employeeModel.setColumnIdentifiers(employeeCols);
		employeeTable.setModel(employeeModel);
		employeeTable.setBounds(400, 369, 290, 340);
		employeeSearch.setViewportView(employeeTable);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (prodNameInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter product.");
				else if (cusInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter customer.");
				else if (empInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter employee.");
				else {
					String product = format.capitalizeWord(prodNameInput.getText());
					int quantity = Integer.parseInt(quantityInput.getText());
					String customer = format.capitalizeWord(cusInput.getText());
					String employee = format.capitalizeWord(empInput.getText());
					prodNameInput.setText("");
					quantityInput.setText("");
					cusInput.setText("");
					empInput.setText("");
					orders.addOrder(product, quantity, customer, employee);
					getOrder();
					Menu.switchPanels(2 ,customer);
				}
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(10, 224, 120, 30);
		infoPanel.add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) ordTable.getModel();
				if (ordTable.getSelectedRowCount() == 1) {
					String product = prodNameInput.getText();
					int quantity = Integer.parseInt(quantityInput.getText());
					String customer = cusInput.getText();
					String employee = empInput.getText();					
					tblModel.setValueAt(product, ordTable.getSelectedRow(), 0);
					tblModel.setValueAt(quantity, ordTable.getSelectedRow(), 1);
					tblModel.setValueAt(customer, ordTable.getSelectedRow(), 2);
					tblModel.setValueAt(employee, ordTable.getSelectedRow(), 3);
					orders.updateOrder(product, quantity, customer, employee);
				} else {
					if (ordTable.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.");
					} else {
						JOptionPane.showMessageDialog(null, "Select single row to update.");
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(10, 284, 120, 30);
		infoPanel.add(btnUpdate);

		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) ordTable.getModel();
				if (ordTable.getSelectedRowCount() == 1) {
					String product = prodNameInput.getText();
					int quantity = Integer.parseInt(quantityInput.getText());
					String customer = cusInput.getText();
					String employee = empInput.getText();	
					prodNameInput.setText("");
					quantityInput.setText("");
					cusInput.setText("");
					empInput.setText("");
					orders.deleteOrder(product, quantity, customer, employee);
					tblModel.removeRow(ordTable.getSelectedRow());
				} else {
					if (ordTable.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.");
					} else {
						JOptionPane.showMessageDialog(null, "Select single row to update.");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.setBounds(10, 344, 120, 30);
		infoPanel.add(btnDelete);

		btnSortProduct = new JButton("Sort Product");
		btnSortProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders.sortOrder(1);
				getOrder();
			}
		});
		btnSortProduct.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortProduct.setBounds(150, 224, 170, 30);
		infoPanel.add(btnSortProduct);
		
		btnSortCustomer = new JButton("Sort Customer");
		btnSortCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders.sortOrder(2);
				getOrder();
			}
		});
		btnSortCustomer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortCustomer.setBounds(150, 284, 170, 30);
		infoPanel.add(btnSortCustomer);
		
		btnSortEmployee = new JButton("Sort Employee");
		btnSortEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders.sortOrder(3);
				getOrder();
			}
		});
		btnSortEmployee.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortEmployee.setBounds(150, 344, 170, 30);
		infoPanel.add(btnSortEmployee);

		getOrder();
		getProductAndEmployee();
		
	}
	public void getProductAndEmployee() {
		DefaultTableModel productModel = 
				(DefaultTableModel) productTable.getModel();
		DefaultTableModel employeeModel = 
				(DefaultTableModel) employeeTable.getModel();
		int index = 0;
		productModel.getDataVector().removeAllElements();
		employeeModel.getDataVector().removeAllElements();
	    revalidate();
		while (employeeData.getNames().get(index) != null
				|| productData.getProducts().getNode(index) != null) {
			Object productName = null;
			Object employeeName = null;
			if (productData.getProducts().getNode(index) != null) 
				productName = productData.getProducts().getNode(index);
		else	
				productName = null;
			if (employeeData.getNames().get(index) != null)
				employeeName = employeeData.getNames().get(index);
			else
				employeeName = null;
			Object[] productData = {productName};
			Object[] employeeData = {employeeName};
			productModel.addRow(productData);
			employeeModel.addRow(employeeData);
			index++;
		}
	}
	
	public void getOrder() {
		DefaultTableModel tblModel = 
				(DefaultTableModel) ordTable.getModel();
		int index = 0;
		tblModel.getDataVector().removeAllElements();
	    revalidate();
		while (orderData.getProducts().get(index) != null) {
			Object product = orderData.getProducts().get(index);
			Object quantity = orderData.getQuantities().get(index);
			Object customer = orderData.getCustomers().get(index);
			Object employee = orderData.getEmployees().get(index);
			Object[] orderData = { product, quantity, customer, employee };
			tblModel.addRow(orderData);
			index++;
		}
	}
}


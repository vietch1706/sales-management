package Interface;

import Data.*;
import subClass.*;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class productPanel extends JPanel {
	private final JPanel prodPanel = new JPanel();
	private JTextField prodTextField;
	private JPanel infoPanel;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextField qtyTextField;
	private JTextField importTextField;
	private JTextField wrtTextField;
	private JTextField codeTextField;
	private JTextField nameInput;
	private JTextField priceInput;
	private JTextField qtyInput;
	private JDateChooser dateChooser;
	@SuppressWarnings("rawtypes")
	private JComboBox wrtInput;
	private JTextField codeInput;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSortName;
	private JButton btnSortPrice;
	private JButton btnSortCode;
	private JTable prodTable;
	private DefaultTableModel model;
	private JScrollPane scrollPanel;
	private productData product = new productData();
	private stringFormat format = new stringFormat();
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public productPanel() {
		setLayout(null);
		prodPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		prodPanel.setBounds(0, 0, 1215, 735);
		add(prodPanel);
		prodPanel.setLayout(null);
		setVisible(true);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		searchPanel.setBounds(25, 25, 350, 75);
		prodPanel.add(searchPanel);
		searchPanel.setLayout(null);
		
		prodTextField = new JTextField();
		prodTextField.setEditable(false);
		prodTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		prodTextField.setHorizontalAlignment(SwingConstants.LEFT);
		prodTextField.setText("Product Info:");
		prodTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		prodTextField.setBounds(20, 20, 120, 30);
		searchPanel.add(prodTextField);
		prodTextField.setColumns(10);
		
		infoPanel = new JPanel();
		infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoPanel.setBounds(25, 115, 350, 585);
		prodPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setText("Name:");
		nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nameTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameTextField.setColumns(10);
		nameTextField.setBounds(10, 20, 120, 30);
		infoPanel.add(nameTextField);
		
		priceTextField = new JTextField();
		priceTextField.setEditable(false);
		priceTextField.setText("Price:");
		priceTextField.setHorizontalAlignment(SwingConstants.LEFT);
		priceTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		priceTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		priceTextField.setColumns(10);
		priceTextField.setBounds(10, 70, 120, 30);
		infoPanel.add(priceTextField);
		
		qtyTextField = new JTextField();
		qtyTextField.setEditable(false);
		qtyTextField.setText("Quantity:");
		qtyTextField.setHorizontalAlignment(SwingConstants.LEFT);
		qtyTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		qtyTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		qtyTextField.setColumns(10);
		qtyTextField.setBounds(10, 120, 120, 30);
		infoPanel.add(qtyTextField);
		
		importTextField = new JTextField();
		importTextField.setEditable(false);
		importTextField.setText("Import Date:");
		importTextField.setHorizontalAlignment(SwingConstants.LEFT);
		importTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		importTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		importTextField.setColumns(10);
		importTextField.setBounds(10, 170, 120, 30);
		infoPanel.add(importTextField);
		
		wrtTextField = new JTextField();
		wrtTextField.setEditable(false);
		wrtTextField.setText("Warranty:");
		wrtTextField.setHorizontalAlignment(SwingConstants.LEFT);
		wrtTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		wrtTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		wrtTextField.setColumns(10);
		wrtTextField.setBounds(10, 220, 120, 30);
		infoPanel.add(wrtTextField);
		
		codeTextField = new JTextField();
		codeTextField.setEditable(false);
		codeTextField.setText("Code:");
		codeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		codeTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		codeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		codeTextField.setColumns(10);
		codeTextField.setBounds(10, 270, 120, 30);
		infoPanel.add(codeTextField);
		
		prodTable = new JTable();
		prodTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) prodTable.getModel();
				String nameText = tblModel.getValueAt(prodTable.getSelectedRow(), 0).toString();
				String priceText = tblModel.getValueAt(prodTable.getSelectedRow(), 1).toString();
				String qtyText = tblModel.getValueAt(prodTable.getSelectedRow(), 2).toString();
				String codeText = tblModel.getValueAt(prodTable.getSelectedRow(), 5).toString();
				
				nameInput.setText(nameText);
				priceInput.setText(priceText);
				qtyInput.setText(qtyText);
				codeInput.setText(codeText);
			}
		});
		prodTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		prodTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		model = new DefaultTableModel();
		Object[] cols =	{"Name", "Price", "Quantity", "Import Date", "Warranty", "Code"};
		model.setColumnIdentifiers(cols);
		prodTable.setBounds(400, 25, 435, 535);
		prodTable.setModel(model);
		
		scrollPanel = new JScrollPane();
		scrollPanel.setBounds(400, 25, 790, 685);
		prodPanel.add(scrollPanel);
		scrollPanel.setViewportView(prodTable);
		
		nameInput = new JTextField();
		nameInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameInput.setColumns(10);
		nameInput.setBounds(140, 20, 180, 30);
		infoPanel.add(nameInput);
		
		priceInput = new JTextField();
		priceInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		priceInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
		        if ((Character.isDigit(c)) || (c == KeyEvent.VK_PERIOD) || 
		        		(c == KeyEvent.VK_BACK_SPACE)) {
		            if (c == KeyEvent.VK_PERIOD) { 
		                        String s = priceInput.getText();
		                        int dot = s.indexOf('.');
		                        if(dot != -1) {
		                            getToolkit().beep();
		                            e.consume();
		                        }
		                    }
		        }
		        else {    
		            getToolkit().beep();
		            e.consume();
		        }
			}
		});
		priceInput.setColumns(10);
		priceInput.setBounds(140, 70, 180, 30);
		infoPanel.add(priceInput);

		qtyInput = new JTextField();
		qtyInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		qtyInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar()) )
					e.consume();
			}
		});
		qtyInput.setColumns(10);
		qtyInput.setBounds(140, 120, 180, 30);
		infoPanel.add(qtyInput);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d/M/y");
		dateChooser.setBounds(140, 170, 180, 30);
		infoPanel.add(dateChooser);
	
		wrtInput = new JComboBox();
		wrtInput.setModel(new DefaultComboBoxModel(
				new String[] {"Yes", "No"}));
		wrtInput.setMaximumRowCount(2);
		wrtInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		wrtInput.setBounds(140, 220, 180, 30);
		infoPanel.add(wrtInput);
		
		codeInput = new JTextField();
		codeInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar()))
					e.consume();	
			}
		});
		codeInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		codeInput.setColumns(10);
		codeInput.setBounds(140, 270, 180, 30);
		infoPanel.add(codeInput);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter name.");
				else if (priceInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter price.");
				else if (qtyInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter quantity.");
				else if (dateChooser.getDate() == null)
					JOptionPane.showMessageDialog(null, 
							"Please enter Import Date.");
				else if (codeInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter Code.");
				else {
					String prodName = format.capitalizeWord(nameInput.getText());
					float price = Float.parseFloat(priceInput.getText());
					int quantity = Integer.parseInt(qtyInput.getText());
					Date importDate = dateChooser.getDate();
					String warranty = 
							wrtInput.getSelectedItem().toString();
					int code = Integer.parseInt(codeInput.getText());
					nameInput.setText("");
					priceInput.setText("");
					qtyInput.setText("");
					codeInput.setText("");
					product.addProduct(prodName, price, quantity, 
							importDate, warranty, code);
					getProduct();
				}
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(10, 320, 120, 30);
		infoPanel.add(btnAdd);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) prodTable.getModel();
				if (prodTable.getSelectedRowCount() == 1) {
					String prodName = nameInput.getText();
					float price = Float.parseFloat(priceInput.getText());
					int quantity = Integer.parseInt(qtyInput.getText());
					Date importDate = dateChooser.getDate();
					SimpleDateFormat simpleDateFormat = 
							new SimpleDateFormat("dd/MM/yyyy");
					String warranty = 
							wrtInput.getSelectedItem().toString();
					int code = Integer.parseInt(codeInput.getText());					
					tblModel.setValueAt(prodName, prodTable.getSelectedRow(), 0);
					tblModel.setValueAt(price, prodTable.getSelectedRow(), 1);
					tblModel.setValueAt(quantity, prodTable.getSelectedRow(), 2);
					tblModel.setValueAt(simpleDateFormat.format(importDate),
							prodTable.getSelectedRow(), 3);
					tblModel.setValueAt(warranty, prodTable.getSelectedRow(), 4);
					tblModel.setValueAt(code, prodTable.getSelectedRow(), 5);
					product.updateProduct(prodName, price, quantity, 
							importDate, warranty, code);
				} else {
					if (prodTable.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.");
					} else {
						JOptionPane.showMessageDialog(null, "Select single row to update.");
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(10, 380, 120, 30);
		infoPanel.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) prodTable.getModel();
				if (prodTable.getSelectedRowCount() == 1) {
					String prodName = nameInput.getText();
					float price = Float.parseFloat(priceInput.getText());
					int quantity = Integer.parseInt(qtyInput.getText());
					Date importDate = dateChooser.getDate();
					String warranty = 
							wrtInput.getSelectedItem().toString();
					int code = Integer.parseInt(codeInput.getText());
					nameInput.setText("");
					priceInput.setText("");
					qtyInput.setText("");
					codeInput.setText("");
					product.deleteProduct(prodName, price, quantity, 
							importDate, warranty, code);
					tblModel.removeRow(prodTable.getSelectedRow());
				} else {
					if (prodTable.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.");
					} else {
						JOptionPane.showMessageDialog(null, "Select single row to update.");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.setBounds(10, 440, 120, 30);
		infoPanel.add(btnDelete);
		
		btnSortName = new JButton("Sort Name");
		btnSortName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product.sortProduct(1);
				getProduct();
			}
		});
		btnSortName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortName.setBounds(150, 320, 150, 30);
		infoPanel.add(btnSortName);

		
		btnSortPrice = new JButton("Sort Price");
		btnSortPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product.sortProduct(2);
				getProduct();
			}
		});
		btnSortPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortPrice.setBounds(150, 380, 150, 30);
		infoPanel.add(btnSortPrice);

		btnSortCode = new JButton("Sort Code");
		btnSortCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product.sortProduct(3);
				getProduct();
			}
		});
		btnSortCode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortCode.setBounds(150, 440, 150, 30);
		infoPanel.add(btnSortCode);
		
		JDateChooser startDate = new JDateChooser();
		startDate.setDateFormatString("d/M/y");
		startDate.setBounds(10, 500, 150, 30);
		infoPanel.add(startDate);
		
		JDateChooser endDate = new JDateChooser();
		endDate.setDateFormatString("d/M/y");
		endDate.setBounds(190, 500, 150, 30);
		infoPanel.add(endDate);
		
		JButton btnFindFromBounded = new JButton("Find From Range");
		btnFindFromBounded.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date start = startDate.getDate();
				Date end = endDate.getDate();
				if (startDate.getDate() == null && endDate.getDate() != null ||
						startDate.getDate() != null && endDate.getDate() == null) {
					JOptionPane.showMessageDialog(null, 
							"Please enter both start date and end date.");
									}
				else if (startDate.getDate() != null && endDate.getDate() != null){
					DefaultTableModel tblModel = 
							(DefaultTableModel) prodTable.getModel();
					int index = 0;
					tblModel.getDataVector().removeAllElements();
				    revalidate();
					while (productData.getProducts().getNode(index) != null) {
						Object name = productData.getProducts().getNode(index);
						Object price = productData.getPrices().getNode(index);
						Object qty = productData.getQuantities().getNode(index);
						Object importDate = productData.getImportDates().getNode(index);
						Date date1 = null;
						 try {
							date1 = new SimpleDateFormat("dd/MM/yyyy").parse((String) importDate);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Object wrt = productData.getWarranties().getNode(index);
						Object code = productData.getCodes().getNode(index);
						Object[] productData = {name, price, qty, importDate, wrt, code};
						if(date1.after(start) && date1.before(end)) {
							tblModel.addRow(productData);
						}
						index++;
					}
				} else getProduct();
			}
		});
		btnFindFromBounded.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnFindFromBounded.setBounds(50, 545, 250, 30);
		infoPanel.add(btnFindFromBounded);
	}
	public void getProduct() {
		DefaultTableModel tblModel = 
				(DefaultTableModel) prodTable.getModel();
		int index = 0;
		tblModel.getDataVector().removeAllElements();
	    revalidate();
		while (productData.getProducts().getNode(index) != null) {
			Object name = productData.getProducts().getNode(index);
			Object price = productData.getPrices().getNode(index);
			Object qty = productData.getQuantities().getNode(index);
			Object importDate = productData.getImportDates().getNode(index);
			Object wrt = productData.getWarranties().getNode(index);
			Object code = productData.getCodes().getNode(index);
			Object[] productData = {name, price, qty, importDate, wrt, code};
			tblModel.addRow(productData);
			index++;
		}
	}
}

package Interface;

import Data.*;
import subClass.*;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class customerPanel extends JPanel {
	private final JPanel cusPanel = new JPanel();
	private JPanel searchPanel;
	private JPanel infoPanel;
	private JTextField cusTextField;
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JTextField genderTextField;
	private JTextField dobTextField;
	private JTextField nameInput;
	private JTextField phoneInput;
	@SuppressWarnings("rawtypes")
	private JComboBox genderInput;
	private JDateChooser dobInput;
	private JTable cusTable;
	private DefaultTableModel model;
	private JScrollPane scrollPanel;
	private JButton btnAdd;
	private JButton btnSortName;
	private JButton btnUpdate;
	private JButton btnDelete;
	private orderPanel ordPanel = new orderPanel();
	private customerData customer = new customerData();
	private stringFormat format = new stringFormat();
	private JButton btnBack;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public customerPanel() {
		setLayout(null);
		cusPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cusPanel.setBounds(0, 0, 1215, 735);
		add(cusPanel);
		cusPanel.setLayout(null);
		setVisible(true);
		
		searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		searchPanel.setBounds(25, 25, 350, 75);
		cusPanel.add(searchPanel);
		
		cusTextField = new JTextField();
		cusTextField.setText("Customer Info:");
		cusTextField.setHorizontalAlignment(SwingConstants.LEFT);
		cusTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cusTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		cusTextField.setEditable(false);
		cusTextField.setColumns(10);
		cusTextField.setBounds(20, 11, 140, 30);
		searchPanel.add(cusTextField);
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoPanel.setBounds(25, 180, 350, 530);
		cusPanel.add(infoPanel);
		
		nameTextField = new JTextField();
		nameTextField.setText("Name:");
		nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		nameTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		nameTextField.setEditable(false);
		nameTextField.setColumns(10);
		nameTextField.setBounds(10, 20, 120, 30);
		infoPanel.add(nameTextField);
		
		phoneTextField = new JTextField();
		phoneTextField.setText("Phone:");
		phoneTextField.setHorizontalAlignment(SwingConstants.LEFT);
		phoneTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		phoneTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		phoneTextField.setEditable(false);
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(10, 70, 120, 30);
		infoPanel.add(phoneTextField);
		
		genderTextField = new JTextField();
		genderTextField.setText("Gender: ");
		genderTextField.setHorizontalAlignment(SwingConstants.LEFT);
		genderTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		genderTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		genderTextField.setEditable(false);
		genderTextField.setColumns(10);
		genderTextField.setBounds(10, 120, 120, 30);
		infoPanel.add(genderTextField);
		
		dobTextField = new JTextField();
		dobTextField.setText("Birthday: ");
		dobTextField.setHorizontalAlignment(SwingConstants.LEFT);
		dobTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dobTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		dobTextField.setEditable(false);
		dobTextField.setColumns(10);
		dobTextField.setBounds(10, 170, 120, 30);
		infoPanel.add(dobTextField);
		
		cusTable = new JTable();
		cusTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) cusTable.getModel();
				String nameText = tblModel.getValueAt(cusTable.getSelectedRow(), 0).toString();
				String phoneText = tblModel.getValueAt(cusTable.getSelectedRow(), 1).toString();
				nameInput.setText(nameText);
				phoneInput.setText(phoneText);
			}
		});
		cusTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		cusTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		model = new DefaultTableModel();
		Object[] cols =	{"Name", "Phone", "Gender", "Birthday"};
		model.setColumnIdentifiers(cols);
		cusTable.setModel(model);
		cusTable.setBounds(400, 25, 435, 535);
		
		scrollPanel = new JScrollPane();
		scrollPanel.setBounds(400, 25, 790, 685);
		cusPanel.add(scrollPanel);
		scrollPanel.setViewportView(cusTable);
		
		nameInput = new JTextField();
		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar())) {
						e.consume();
				}
			}
		});
		nameInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameInput.setColumns(10);
		nameInput.setBounds(140, 20, 180, 30);
		infoPanel.add(nameInput);
		
		phoneInput = new JTextField();
		phoneInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String phoneNumber = phoneInput.getText();
				int length = phoneNumber.length();
				if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					if (length < 11) {
						phoneInput.setEditable(true);
					} else {
						phoneInput.setEditable(false);
					}
				} else {
					if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || 
							e.getExtendedKeyCode() == KeyEvent.VK_DELETE)
						phoneInput.setEditable(true);
					else 
						phoneInput.setEditable(false);
				} 
			}
		});
		phoneInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phoneInput.setColumns(10);
		phoneInput.setBounds(140, 70, 180, 30);
		infoPanel.add(phoneInput);
		
		genderInput = new JComboBox();
		genderInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		genderInput.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderInput.setMaximumRowCount(2);
		genderInput.setBounds(140, 120, 180, 30);
		infoPanel.add(genderInput);
		
		dobInput = new JDateChooser();
		dobInput.setDateFormatString("d/M/y");
		dobInput.setBounds(140, 170, 180, 30);
		infoPanel.add(dobInput);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter name.");
				else if (phoneInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter phone number.");
				else if (dobInput.getDate() == null)
					JOptionPane.showMessageDialog(null, 
							"Please enter birthday.");
				else {
					String name = format.capitalizeWord(nameInput.getText());
					String phone = phoneInput.getText();
					String gender = 
							genderInput.getSelectedItem().toString();
					Date dob = dobInput.getDate();
					nameInput.setText("");
					phoneInput.setText("");
					customer.addCustomer(name, phone, gender, dob);
					getCustomer();
				}
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(10, 230, 310, 30);
		infoPanel.add(btnAdd);
		
		btnSortName = new JButton("Sort Name");
		btnSortName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.sortCustomer();
				getCustomer();
			}
		});
		btnSortName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortName.setBounds(10, 290, 310, 30);
		infoPanel.add(btnSortName);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) cusTable.getModel();
				if (cusTable.getSelectedRowCount() == 1) {
					String name = nameInput.getText();
					String phone = phoneInput.getText();
					String gender = 
							genderInput.getSelectedItem().toString();
					Date dob = dobInput.getDate();
					SimpleDateFormat simpleDateFormat = 
							new SimpleDateFormat("dd/MM/yyyy");				
					tblModel.setValueAt(name, cusTable.getSelectedRow(), 0);
					tblModel.setValueAt(phone, cusTable.getSelectedRow(), 1);
					tblModel.setValueAt(gender, cusTable.getSelectedRow(), 2);
					tblModel.setValueAt(simpleDateFormat.format(dob),
							cusTable.getSelectedRow(), 3);
					customer.updateCustomer(name, phone, gender, dob);
				} else {
					if (cusTable.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.");
					} else {
						JOptionPane.showMessageDialog(null, "Select single row to update.");
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(10, 350, 310, 30);
		infoPanel.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) cusTable.getModel();
				if (cusTable.getSelectedRowCount() == 1) {
					String name = nameInput.getText();
					String phone = phoneInput.getText();
					String gender = 
							genderInput.getSelectedItem().toString();
					Date dob = dobInput.getDate();
					nameInput.setText("");
					phoneInput.setText("");
					customer.deleteCustomer(name, phone, gender,dob);
					tblModel.removeRow(cusTable.getSelectedRow());
				} else {
					if (cusTable.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Table is Empty.");
					} else {
						JOptionPane.showMessageDialog(null, "Select single row to update.");
					}
				}
			}
		});
		
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.setBounds(10, 410, 310, 30);
		infoPanel.add(btnDelete);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.switchPanels(3, null);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBounds(10, 470, 310, 30);
		infoPanel.add(btnBack);
		
	}

	public void getCustomer() {
		DefaultTableModel tblModel = 
				(DefaultTableModel) cusTable.getModel();
		int index = 0;
		tblModel.getDataVector().removeAllElements();
	    revalidate();
		while (customerData.getNames().getNode(index) != null) {
			Object name = customerData.getNames().getNode(index);
			Object phone = customerData.getPhones().getNode(index);
			Object gender = customerData.getGenders().getNode(index);
			Object birthday = customerData.getBirthdays().getNode(index);
			Object[] customerData = {name, phone, gender, birthday};
			tblModel.addRow(customerData);
			index++;
		}
	}
	public void setCustomerName(String customer) {
		nameInput.setText(customer);
	}
}


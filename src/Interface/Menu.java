package Interface;

import subClass.*;
import Data.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Menu extends JFrame {
	// khoi tao cac method cua JFrame
	productPanel product = new productPanel();
	employeePanel employee = new employeePanel();
	static customerPanel customer = new customerPanel();
	orderPanel order = new orderPanel();
	productData products = new productData();
	employeeData employees = new employeeData();
	customerData customers = new customerData();
	orderData orders = new orderData();
	static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
	private JTextField txtMember1;
	private JTextField txtMember2;
	private JTextField txtMember3;
	public Menu() {
		// Doc cac gia tri tu file txt va bo vao cac cau truc du lieu
		products.readProduct();
		products.clearProduct();
		employees.readEmployee();
		employees.clearEmployee();
		customers.readCustomer();
		customers.clearCustomer();
		orders.readOrder();
		orders.clearOrder();
		setTitle("SALES MANAGEMENT");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// Tao chuc nang tat chuong trinh
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				 String ObjButtons[] = {"Yes", "No"};
			     int PromptResult = JOptionPane.showOptionDialog(null, 
			        		"Do You Want to Save?", "S A L E S  M A N A G E M E N T"
			        		, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
			        		null, ObjButtons, ObjButtons[1]);
			     if(PromptResult == JOptionPane.YES_OPTION) { // Bam Yes thi se luu lai du lieu roi thoat
			    	 products.saveProduct();
			    	 products.sortProduct(1);
			    	 employees.saveEmployee();
			    	 employees.sortEmployee(1);
			    	 customers.saveCustomer();
			    	 customers.sortCustomer();
			    	 orders.saveOrder();
			    	 orders.sortOrder(1);
			    	 System.exit(0);
			     } else System.exit(0);	// No thi se ko luu lai gia tri
			}
		});
		getContentPane().setLayout(null);
		tabbedPane.setBorder(null);
		
		tabbedPane.setBounds(350, 100, 1400, 735);
		getContentPane().add(tabbedPane);
		tabbedPane.addTab("Product", null, product, null);
		tabbedPane.addTab("Employee", null, employee, null);
		tabbedPane.addTab("Customer", null, customer, null);
		tabbedPane.addTab("Oder", null, order, null);
		order.getOrder();
		order.setVisible(false);
		customer.getCustomer();
		customer.setVisible(false);
		employee.getEmployee();
		employee.setVisible(false);
		product.getProduct();
		product.setVisible(false);
		setBounds(0, 0, 1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("S A L E S  M A N A G E M E N T");
		lblNewLabel.setBounds(25, 10, 1535, 79);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 60));
		getContentPane().add(lblNewLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(25, 100, 300, 550);
		buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton prodButton = new JButton("Products");
		prodButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		prodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// load vao panel san pham
				Menu.switchPanels(0, null);
			}
		});
		prodButton.setBounds(25, 50, 250, 50);
		buttonPanel.add(prodButton);
		
		JButton empButton = new JButton("Employees");
		empButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				load vao panel nhan vien
				Menu.switchPanels(1, null);
			}
		});
		empButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		empButton.setBounds(25, 150, 250, 50);
		buttonPanel.add(empButton);
		
		JButton cusButton = new JButton("Customers");
		cusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				load vao panel khach hang
				Menu.switchPanels(2, null);
			}
		});
		cusButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		cusButton.setBounds(25, 250, 250, 50);
		buttonPanel.add(cusButton);
		
		JButton ordButton = new JButton("Orders");
		ordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				load vao panel don hang
				Menu.switchPanels(3, null);
				order.getProductAndEmployee();	// Lay ra ten san pham va nhan vien de tim kiem
			}
		});
		ordButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		ordButton.setBounds(25, 350, 250, 50);
		buttonPanel.add(ordButton);
		// Chuc nang nut bam exit co tac dung nhu nut (X)
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String ObjButtons[] = {"Yes", "No"};
			     int PromptResult = JOptionPane.showOptionDialog(null, 
			        		"Do You Want to Save?", "S A L E S  M A N A G E M E N T"
			        		, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
			        		null, ObjButtons, ObjButtons[1]);
			     if(PromptResult == JOptionPane.YES_OPTION) {
			    	 products.saveProduct();
			    	 products.sortProduct(1);
			    	 employees.saveEmployee();
			    	 employees.sortEmployee(1);
			    	 customers.saveCustomer();
			    	 customers.sortCustomer();
			    	 orders.saveOrder();
			    	 orders.sortOrder(1);
			         System.exit(0);
			      } else System.exit(0);
			}
		});
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		exitButton.setBounds(25, 450, 250, 50);
		buttonPanel.add(exitButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(25, 682, 300, 155);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtMember1 = new JTextField();
		txtMember1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMember1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMember1.setEditable(false);
		txtMember1.setBounds(25, 10, 250, 30);
		txtMember1.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtMember1.setText("Cù Hoài Việt 20119177");
		panel.add(txtMember1);
		txtMember1.setColumns(10);
		
		txtMember2 = new JTextField();
		txtMember2.setHorizontalAlignment(SwingConstants.CENTER);
		txtMember2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMember2.setEditable(false);
		txtMember2.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtMember2.setText("Khổng Thành Đạt 20119123");
		txtMember2.setColumns(10);
		txtMember2.setBounds(25, 50, 250, 30);
		panel.add(txtMember2);
		
		txtMember3 = new JTextField();
		txtMember3.setHorizontalAlignment(SwingConstants.CENTER);
		txtMember3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMember3.setEditable(false);
		txtMember3.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtMember3.setText("Phạm Chí Phát 20119191");
		txtMember3.setColumns(10);
		txtMember3.setBounds(25, 90, 250, 30);
		panel.add(txtMember3);

	}
	public static void switchPanels(int index, String text) {
		tabbedPane.setSelectedIndex(index);
		customer.setCustomerName(text);
	}
}


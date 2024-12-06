
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Menu extends JFrame {
	JpanelLoader load = new JpanelLoader();
	productPanel product = new productPanel();
	employeePanel employee = new employeePanel();
	customerPanel customer = new customerPanel();
	orderPanel order = new orderPanel();
	productData products = new productData();
	employeeData employees = new employeeData();
	customerData customers = new customerData();
	orderData orders = new orderData();
	public Menu() {
		products.readProduct();
		product.getProduct();
		products.clearProduct();
		employees.readEmployee();
		employee.getEmployee();
		employees.clearEmployee();
		customers.readCustomer();
		customer.getCustomer();
		customers.clearCustomer();
		orders.readOrder();
		order.getOrder();
		orders.clearOrder();
		setTitle("SALES MANAGEMENT");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				 String ObjButtons[] = {"Yes", "No"};
			     int PromptResult = JOptionPane.showOptionDialog(null, 
			        		"Do You Want to Save?", "S A L E S  M A N A G E M E N T"
			        		, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
			        		null, ObjButtons, ObjButtons[1]);
			     if(PromptResult==JOptionPane.YES_OPTION) {
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
		setBounds(0, 0, 1600, 900);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("S A L E S  M A N A G E M E N T");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 60));
		lblNewLabel.setBounds(25, 10, 1535, 70);
		getContentPane().add(lblNewLabel);
		
		JPanel loadPanel = new JPanel();
		loadPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		loadPanel.setBounds(350, 100, 1215, 735);
		getContentPane().add(loadPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonPanel.setBounds(25, 100, 300, 550);
		getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		JButton prodButton = new JButton("Products");
		prodButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		prodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load.jPanelLoader(loadPanel, product);
			}
		});
		prodButton.setBounds(25, 50, 250, 50);
		buttonPanel.add(prodButton);
		
		JButton empButton = new JButton("Employees");
		empButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load.jPanelLoader(loadPanel, employee);
			}
		});
		empButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		empButton.setBounds(25, 150, 250, 50);
		buttonPanel.add(empButton);
		
		JButton cusButton = new JButton("Customers");
		cusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load.jPanelLoader(loadPanel, customer);
			}
		});
		cusButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		cusButton.setBounds(25, 250, 250, 50);
		buttonPanel.add(cusButton);
		
		JButton ordButton = new JButton("Orders");
		ordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load.jPanelLoader(loadPanel, order);
				order.getProductAndEmployee();
			}
		});
		ordButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		ordButton.setBounds(25, 350, 250, 50);
		buttonPanel.add(ordButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String ObjButtons[] = {"Yes", "No"};
			     int PromptResult = JOptionPane.showOptionDialog(null, 
			        		"Do You Want to Save?", "S A L E S  M A N A G E M E N T"
			        		, JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,
			        		null, ObjButtons, ObjButtons[1]);
			     if(PromptResult==JOptionPane.YES_OPTION) {
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
	}
}

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.print.attribute.AttributeSet;
import javax.swing.DefaultComboBoxModel;

public class employeePanel extends JPanel {
	private final JPanel empPanel = new JPanel();
	private JPanel searchPanel;
	private JPanel infoPanel;
	private JTextField empTextField;
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JTextField genderTextField;
	private JTextField positionTextField;
	private JTextField dobTextField;
	private JTextField codeTextField;
	private JTextField nameInput;
	private JTextField phoneInput;
	@SuppressWarnings("rawtypes")
	private JComboBox genderInput;
	private JTextField positionInput;
	private JDateChooser dobInput;
	private JTextField codeInput;
	private JTable empTable;
	private DefaultTableModel model;
	private JButton btnAdd;
	private JButton btnSortName;
	private JButton btnSortPosition;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSortCode;
	private employeeData employee = new employeeData();
	private stringFormat format = new stringFormat();
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public employeePanel() {
		setLayout(null);
		empPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		empPanel.setBounds(0, 0, 1215, 735);
		add(empPanel);
		empPanel.setLayout(null);
		setVisible(true);
		
		searchPanel = new JPanel();
		searchPanel.setBounds(25, 25, 350, 75);
		searchPanel.setLayout(null);
		searchPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		empPanel.add(searchPanel);
		
		empTextField = new JTextField();
		empTextField.setText("Employee Info:");
		empTextField.setHorizontalAlignment(SwingConstants.LEFT);
		empTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		empTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		empTextField.setEditable(false);
		empTextField.setColumns(10);
		empTextField.setBounds(20, 20, 140, 30);
		searchPanel.add(empTextField);
		
		infoPanel = new JPanel();
		infoPanel.setLayout(null);
		infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoPanel.setBounds(25, 150, 350, 510);
		empPanel.add(infoPanel);
		
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
		
		positionTextField = new JTextField();
		positionTextField.setText("Position:");
		positionTextField.setHorizontalAlignment(SwingConstants.LEFT);
		positionTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		positionTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		positionTextField.setEditable(false);
		positionTextField.setColumns(10);
		positionTextField.setBounds(10, 170, 120, 30);
		infoPanel.add(positionTextField);
		
		dobTextField = new JTextField();
		dobTextField.setText("Birthday:");
		dobTextField.setHorizontalAlignment(SwingConstants.LEFT);
		dobTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dobTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		dobTextField.setEditable(false);
		dobTextField.setColumns(10);
		dobTextField.setBounds(10, 220, 120, 30);
		infoPanel.add(dobTextField);
		
		codeTextField = new JTextField();
		codeTextField.setText("Employee Code:");
		codeTextField.setHorizontalAlignment(SwingConstants.LEFT);
		codeTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		codeTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		codeTextField.setEditable(false);
		codeTextField.setColumns(10);
		codeTextField.setBounds(10, 270, 150, 30);
		infoPanel.add(codeTextField);

		empTable = new JTable();
		empTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel =
						(DefaultTableModel) empTable.getModel();
				String nameText = tblModel.getValueAt(empTable.getSelectedRow(), 0).toString();
				String phoneText = tblModel.getValueAt(empTable.getSelectedRow(), 1).toString();
				String genderText = tblModel.getValueAt(empTable.getSelectedRow(), 2).toString();
				String positionText = tblModel.getValueAt(empTable.getSelectedRow(), 3).toString();
				String dobText = tblModel.getValueAt(empTable.getSelectedRow(), 4).toString();
				String codeText = tblModel.getValueAt(empTable.getSelectedRow(), 5).toString();
				
				nameInput.setText(nameText);
				phoneInput.setText(phoneText);
				positionInput.setText(positionText);
				codeInput.setText(codeText);
			}
		});
		empTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		empTable.setFont(new Font("Times New Roman", Font.BOLD, 15));
		model = new DefaultTableModel();
		Object[] cols =	{"Name", "Phone", "Gender", "Postion", "Birthday", "Employee Code"};
		model.setColumnIdentifiers(cols);
		empTable.setModel(model);
		empTable.setBounds(400, 25, 435, 535);
		
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(400, 25, 790, 685);
		empPanel.add(scrollPanel);
		scrollPanel.setViewportView(empTable);
		
		nameInput = new JTextField();
		nameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar()))
					e.consume();
			}
		});
		nameInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		nameInput.setColumns(10);
		nameInput.setBounds(140, 20, 180, 30);
		infoPanel.add(nameInput);
		
		phoneInput = new JFormattedTextField();
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
		genderInput.setMaximumRowCount(2);
		genderInput.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		genderInput.setBounds(140, 120, 180, 30);
		infoPanel.add(genderInput);
		
		positionInput = new JTextField();
		positionInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar())) {
						e.consume();
				}
			}
		});
		positionInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		positionInput.setColumns(10);
		positionInput.setBounds(140, 170, 180, 30);
		infoPanel.add(positionInput);
		
		dobInput = new JDateChooser();
		dobInput.setDateFormatString("d/M/y");
		dobInput.setBounds(140, 220, 180, 30);
		infoPanel.add(dobInput);
		
		codeInput = new JTextField();
		codeInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
						e.consume();
				}
			}
		});
		codeInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		codeInput.setColumns(10);
		codeInput.setBounds(170, 270, 150, 30);
		infoPanel.add(codeInput);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter name.");
				else if (phoneInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter phone number.");
				else if (positionInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter position.");
				else if (dobInput.getDate() == null)
					JOptionPane.showMessageDialog(null, 
							"Please enter birthday.");
				else if (codeInput.getText().isEmpty())
					JOptionPane.showMessageDialog(null, 
							"Please enter Code.");
				else {
					String name = format.capitalizeWord(nameInput.getText());
					String phone = phoneInput.getText();
					String gender = 
							genderInput.getSelectedItem().toString();
					String position = format.capitalizeWord(positionInput.getText());
					Date dob = dobInput.getDate();
					SimpleDateFormat simpleDateFormat = 
							new SimpleDateFormat("dd/MM/yyyy");
					int code = Integer.parseInt(codeInput.getText());
					Object[] employeeData = {name, phone, gender, position,
							simpleDateFormat.format(dob), code};
					nameInput.setText("");
					phoneInput.setText("");
					positionInput.setText("");
					codeInput.setText("");
					employee.addEmloyee(name, phone, gender, position, dob, code);
					getEmployee();
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
						(DefaultTableModel) empTable.getModel();
				if (empTable.getSelectedRowCount() == 1) {
					String name = nameInput.getText();
					String phone = phoneInput.getText();
					String gender = 
							genderInput.getSelectedItem().toString();
					String position = positionInput.getText();
					Date dob = dobInput.getDate();
					SimpleDateFormat simpleDateFormat = 
							new SimpleDateFormat("dd/MM/yyyy");
					int code = Integer.parseInt(codeInput.getText());					
					tblModel.setValueAt(name, empTable.getSelectedRow(), 0);
					tblModel.setValueAt(phone, empTable.getSelectedRow(), 1);
					tblModel.setValueAt(gender, empTable.getSelectedRow(), 2);
					tblModel.setValueAt(position, empTable.getSelectedRow(), 3);
					tblModel.setValueAt(simpleDateFormat.format(dob),
							empTable.getSelectedRow(), 4);
					tblModel.setValueAt(code, empTable.getSelectedRow(), 5);
					employee.updateEmloyee(name, phone, gender, position, dob, code);
				} else {
					if (empTable.getRowCount() == 0) {
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
						(DefaultTableModel) empTable.getModel();
				if (empTable.getSelectedRowCount() == 1) {
					String name = nameInput.getText();
					String phone = phoneInput.getText();
					String gender = 
							genderInput.getSelectedItem().toString();
					String position = positionInput.getText();
					Date dob = dobInput.getDate();
					SimpleDateFormat simpleDateFormat = 
							new SimpleDateFormat("dd/MM/yyyy");
					int code = Integer.parseInt(codeInput.getText());
					nameInput.setText("");
					phoneInput.setText("");
					positionInput.setText("");
					codeInput.setText("");
					employee.deleteEmployee(name, phone, gender, position, dob, code);
					tblModel.removeRow(empTable.getSelectedRow());
				} else {
					if (empTable.getRowCount() == 0) {
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
				employee.sortEmployee(1);
				getEmployee();
			}
		});
		btnSortName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortName.setBounds(150, 320, 150, 30);
		infoPanel.add(btnSortName);
		
		btnSortPosition = new JButton("Sort Position");
		btnSortPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee.sortEmployee(2);
				getEmployee();
			}
		});
		btnSortPosition.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortPosition.setBounds(150, 380, 150, 30);
		infoPanel.add(btnSortPosition);
		
		
		btnSortCode = new JButton("Sort Code");
		btnSortCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee.sortEmployee(3);
				getEmployee();
			}
		});
		btnSortCode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSortCode.setBounds(150, 440, 150, 30);
		infoPanel.add(btnSortCode);
		
	}
	public void getEmployee() {
		DefaultTableModel tblModel = 
				(DefaultTableModel) empTable.getModel();
		int index = 0;
		tblModel.getDataVector().removeAllElements();
	    revalidate();
		while (employeeData.getNames().get(index) != null) {
			Object name = employeeData.getNames().get(index);
			Object phone = employeeData.getPhones().get(index);
			Object gender = employeeData.getGenders().get(index);
			Object position = employeeData.getPositions().get(index);
			Object dob = employeeData.getBirthdays().get(index);
			Object code = employeeData.getEmpCodes().get(index);
			Object[] employeeData = {name, phone, gender, position, dob, code};
			tblModel.addRow(employeeData);
			index++;
		}
	}
}

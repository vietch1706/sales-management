import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import DataStructure.*;
public class orderData {
private static dynamicArray products = new dynamicArray();
private static dynamicArray customers = new dynamicArray();
private static dynamicArray employees = new dynamicArray();
private static Object[] storage = { products, customers, employees };
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\orderData.txt";
	writeAndRead hehe = new writeAndRead();
	
	public static dynamicArray getProducts() {
		return products;
	}

	public static dynamicArray getCustomers() {
		return customers;
	}

	public static dynamicArray getEmployees() {
		return employees;
	}

	public void addOrder(String product ,String customer, String employee) {
		products.add(product);
		customers.add(customer);
		employees.add(employee);
		saveOrder();
	}
	
	public void clearOrder() {
		hehe.clearFile(fileName);
	}
	
	public void saveOrder() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readOrder() {
		String tmp = null;
		String[] arr = null;
		try {
			tmp = (hehe.readFile(fileName, storage));
			System.out.println(tmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tmp != "-1") {
			arr = tmp.split("->");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "->");	
			}
			System.out.println();
			int index = 0;
			if (arr.length > 5) {
				for (int i = 0; i < storage.length; i++) {
					dynamicArray dyArr = (dynamicArray) storage[i];
					dyArr.add(arr[index]);
					dyArr.toString();
					index++;
					if (i == storage.length - 1 && index < arr.length) i = -1; 
				}
			}
		}
	}
	
	public void updateOrder(String product ,String customer, String employee) {
		int index = 0;
		while (products.get(index) != null) {
			String text = products.get(index).toString();
			if (text.equalsIgnoreCase(product)) {
				products.update(index, product);
				customers.update(index, customer);
				employees.update(index, customer);
			}
			index++;
		}

	}

	public void sortOrder(int wayOfSort) {
		int index = 0;
		if (products.get(index) == null) return;
		String product = products.get(index).toString();
		String customer = customers.get(index).toString();
		String employee = employees.get(index).toString();
		switch (wayOfSort) {
		case 1:
	    	while (products.get(index + 1) != null) {
	    		product = products.get(index).toString();
	    		String product1 = products.get(index + 1).toString();
	    		customer = customers.get(index).toString();
	    		employee = employees.get(index).toString();
				if (product.compareTo(product1) > 0) {
					products.update(index, products.get(index + 1));
					products.update(index + 1, product);
					customers.update(index, customers.get(index + 1));
					customers.update(index + 1, customer);
					employees.update(index, employees.get(index + 1));
					employees.update(index + 1, employee);
				}
				index++;
			}
			break;
		case 2:
	    	while (products.get(index + 1) != null) {
	    		product = products.get(index).toString();
	    		customer = customers.get(index).toString();
	    		String customer1 = products.get(index + 1).toString();
	    		employee = employees.get(index).toString();
				if (customer.compareTo(customer1) > 0) {
					products.update(index, products.get(index + 1));
					products.update(index + 1, product);
					customers.update(index, customers.get(index + 1));
					customers.update(index + 1, customer);
					employees.update(index, employees.get(index + 1));
					employees.update(index + 1, employee);
				}
				index++;
			}
			break;

		case 3:
			while (products.get(index + 1) != null) {
	    		product = products.get(index).toString();
	    		customer = customers.get(index).toString();
	    		employee = employees.get(index).toString();
	    		String employee1 = products.get(index + 1).toString();
				if (employee.compareTo(employee1) > 0) {
					products.update(index, products.get(index + 1));
					products.update(index + 1, product);
					customers.update(index, customers.get(index + 1));
					customers.update(index + 1, customer);
					employees.update(index, employees.get(index + 1));
					employees.update(index + 1, employee);
				}
				index++;
			}
			break;

		}
	}
	
	public void deleteOrder(String product ,String customer, String employee) {
		int index = 0;
		while (products.get(index) != null) {
			String text = products.get(index).toString();
			if (text.equalsIgnoreCase(product)) {
				products.delete(product);
				customers.delete(customer);
				employees.delete(employee);
			}
			index++;
		}
	}
}	

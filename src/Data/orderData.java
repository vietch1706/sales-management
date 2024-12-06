package Data;

import subClass.*;
import DataStructure.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
public class orderData {
	// Khoi tao cac bien su dung de luu tru don hang theo mang dong
	private static dynamicArray products = new dynamicArray();
	private static dynamicArray quantities = new dynamicArray();
	private static dynamicArray customers = new dynamicArray();
	private static dynamicArray employees = new dynamicArray();
	private static Object[] storage = { products, quantities, customers, employees };
	// Tao ra duong dan toi file txt luu du lieu
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\orderData.txt";
	writeAndRead hehe = new writeAndRead();
	// lay ra cac gia tri cua don hang ( ten san pham, ten khach hang, ten nhan vien)
	public static dynamicArray getProducts() {
		return products;
	}
	
	public static dynamicArray getQuantities() {
		return quantities;
	}

	public static dynamicArray getCustomers() {
		return customers;
	}

	public static dynamicArray getEmployees() {
		return employees;
	}
	// Them don hang
	public void addOrder(String product ,int quantity, String customer, String employee) {
		products.add(product);
		quantities.add(quantity);
		customers.add(customer);
		employees.add(employee);
		saveOrder();
	}
	// Xoa gia tri don hang luu tru trong file txt
	public void clearOrder() {
		hehe.clearFile(fileName);
	}
	// Luu tru don hang vao file txt
	public void saveOrder() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Lay ra gia tri don hang tu file txt vao mang dong
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
		// neu temp co du lieu thi bat dau xuat du lieu ra 1 mang 
		if (tmp != "-1") {
			arr = tmp.split("->");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "->");	
			}
			System.out.println();
			int index = 0;
			if (arr.length > 5) {
				// luu lai cac gia tri xuat tu file txt ra mang dong
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
	// chinh sua lai gia tri cua don hang
	public void updateOrder(String product ,int quantity, String customer, String employee) {
		int index = 0;
		while (products.get(index) != null) {
			String text = products.get(index).toString();
			if (text.equalsIgnoreCase(product)) {
				products.update(index, product);
				quantities.update(index, quantity);
				customers.update(index, customer);
				employees.update(index, customer);
			}
			index++;
		}

	}
	// sap xep lai cac nhan vien theo ten su dung bubble sort ( 3 cach sap xep )
	public void sortOrder(int wayOfSort) {
		/*
		 * Cach 1: Sap xep theo ten san pham
		 * Cach 2: Sap xep theo ten khach hang
		 * Cach 3: Sap xep theo ten nhan vien
		 * */
		String compare;
		if (products.get(0) == null) return;
		switch (wayOfSort) {
		// Sap xep theo ten san pham
		case 1:
			for (int index = 0; index < products.getCapacity(); index++) {
				if (products.get(index) == null) break;
				for (int nextIndex = index + 1;
						nextIndex < products.getCapacity() - 1; nextIndex++) {
					if (products.get(nextIndex) == null) break;
		    		String temp = products.get(index).toString();
		    		String temp1 = products.get(nextIndex).toString();
					if (temp.compareTo(temp1) > 0) {
						compare = products.get(index).toString();
						products.update(index, products.get(nextIndex));
						products.update(nextIndex, compare);
						compare = quantities.get(index).toString();
						quantities.update(index, quantities.get(nextIndex));
						quantities.update(index, compare);
						compare = customers.get(index).toString();
						customers.update(index, customers.get(nextIndex));
						customers.update(nextIndex, compare);
						compare = employees.get(index).toString();
						employees.update(index, employees.get(nextIndex));
						employees.update(nextIndex, compare);
					}
				}
			}
			break;
		// Sap xep theo ten khach hang
		case 2:
			for (int index = 0; index < customers.getCapacity(); index++) {
				if (customers.get(index) == null) break;
				for (int nextIndex = index + 1;
						nextIndex < customers.getCapacity() - 1; nextIndex++) {
					if (customers.get(nextIndex) == null) break;
		    		String temp = customers.get(index).toString();
		    		String temp1 = customers.get(nextIndex).toString();
					if (temp.compareTo(temp1) > 0) {
						compare = products.get(index).toString();
						products.update(index, products.get(nextIndex));
						products.update(nextIndex, compare);
						compare = quantities.get(index).toString();
						quantities.update(index, quantities.get(nextIndex));
						quantities.update(index, compare);
						compare = customers.get(index).toString();
						customers.update(index, customers.get(nextIndex));
						customers.update(nextIndex, compare);
						compare = employees.get(index).toString();
						employees.update(index, employees.get(nextIndex));
						employees.update(nextIndex, compare);
					}
				}
			}
			break;
		// Sap xep theo ten nhan vien
		case 3:
			for (int index = 0; index < employees.getCapacity(); index++) {
				if (employees.get(index) == null) break;
				for (int nextIndex = index + 1;
						nextIndex < employees.getCapacity() - 1; nextIndex++) {
					if (employees.get(nextIndex) == null) break;
		    		String temp = employees.get(index).toString();
		    		String temp1 = employees.get(nextIndex).toString();
					if (temp.compareTo(temp1) > 0) {
						compare = products.get(index).toString();
						products.update(index, products.get(nextIndex));
						products.update(nextIndex, compare);
						compare = quantities.get(index).toString();
						quantities.update(index, quantities.get(nextIndex));
						quantities.update(index, compare);
						compare = customers.get(index).toString();
						customers.update(index, customers.get(nextIndex));
						customers.update(nextIndex, compare);
						compare = employees.get(index).toString();
						employees.update(index, employees.get(nextIndex));
						employees.update(nextIndex, compare);
					}
				}
			}
			break;
		}
	}
	// Xoa don hang
	public void deleteOrder(String product, int quantity, String customer, String employee) {
		int index = 0;
		while (products.get(index) != null) {
			String text = products.get(index).toString();
			if (text.equalsIgnoreCase(product)) {
				products.delete(product);
				quantities.delete(quantity);
				customers.delete(customer);
				employees.delete(employee);
			}
			index++;
		}
	}

}	

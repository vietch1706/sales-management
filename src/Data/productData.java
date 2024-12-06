package Data;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import subClass.*;
import DataStructure.*;
public class productData {
	// Khoi tao cac bien su dung de luu tru don hang theo danh sach lien ket
	private static linkedList products = new linkedList();
	private static linkedList prices = new linkedList();
	private static linkedList quantities = new linkedList();
	private static linkedList importDates = new linkedList();
	private static linkedList warranties = new linkedList();
	private static linkedList codes = new linkedList();
	private static Object[] storage = { products, prices, quantities, 
		importDates, warranties, codes};
	// Tao ra duong dan toi file txt luu du lieu
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\productData.txt";
	writeAndRead hehe = new writeAndRead();
	// lay ra cac gia tri cua san pham (ten san pham, gia tien, so luong, ngay nhap hang, bao hanh, ma san pham)
	public static linkedList getProducts() {
		return products;
	}

	public static linkedList getPrices() {
		return prices;
	}

	public static linkedList getQuantities() {
		return quantities;
	}

	public static void setQuantities(int index, int quantity) {
		quantities.updateNode(index, quantity);
	}
	
	public static linkedList getImportDates() {
		return importDates;
	}

	public static linkedList getWarranties() {
		return warranties;
	}

	public static linkedList getCodes() {
		return codes;
	}
	// Them san pham moi 
	public void addProduct(String prodName ,float price, int quantity, 
			Date importDate, String warranty, int code) {
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("dd/MM/yyyy");
		products.insert(products, prodName);
		prices.insert(prices, price);
		quantities.insert(quantities, quantity);
		importDates.insert(importDates, simpleDateFormat.format(importDate));
		warranties.insert(warranties, warranty);
		codes.insert(codes, code);
	}
	// Xoa cac gia tri duoc luu tru trong file txt
	public void clearProduct() {
		hehe.clearFile(fileName);
	}
	// Luu lai cac gia tri tu danh sach lien ket vao file txt
	public void saveProduct() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Doc gia tri tu file txt va luu vao danh sach lien ket
	public void readProduct() {
		writeAndRead hehe = new writeAndRead();
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
			if (arr.length > 5) {
				int index = 0;
				// luu lai cac gia tri xuat tu file txt ra danh sach lien ket
				for (int i = 0; i < storage.length; i++) {
					linkedList llist = (linkedList) storage[i];
					llist.insert(llist, arr[index]);
					llist.printList();
					index++;
					if (i == storage.length - 1 && index < arr.length) i = -1; 
				}
			}
		}
	}
	// chinh sua lai du lieu co trong danh sach lien ket
	public void updateProduct(String prodName, float price, 
			int quantity, Date importDate, String warranty, int code) {
		int index = 0;
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("dd/MM/yyyy");
		while (products.getNode(index) != null) {
			String text = products.getNode(index).toString();
			if (text.equalsIgnoreCase(prodName)) {
				products.updateNode(index, prodName);
				prices.updateNode(index, price);
				quantities.updateNode(index, quantity);
				importDates.updateNode(index, simpleDateFormat.format(importDate));
				warranties.updateNode(index, warranty);
				codes.updateNode(index, code);
			}
			index++;
		}
	}
	// sap xep lai cac san pham theo ten su dung bubble sort ( 3 cach sap xep )
	public void sortProduct(int wayOfSort) {
		/*
		 * Cach 1: Sap xep theo ten san pham
		 * Cach 2: Sap xep theo ten gia tien
		 * Cach 3: Sap xep theo ten ma san pham
		 * */
		String compare;
		if (products.getNode(0) == null) return;
		switch (wayOfSort) {
		// Sap xep theo ten san pham
		case 1:
			for (int index = 0; ; index++) {
				if (products.getNode(index) == null) break;
				for (int nextIndex = index + 1; ; nextIndex++) {
					if (products.getNode(nextIndex) == null) break;
		    		String temp = products.getNode(index).toString();
		    		String temp1 = products.getNode(nextIndex).toString();
					if (temp.compareTo(temp1) > 0) {
						compare = products.getNode(index).toString();
						products.updateNode(index, products.getNode(nextIndex));
						products.updateNode(nextIndex, compare);
						compare = prices.getNode(index).toString();
						prices.updateNode(index, prices.getNode(nextIndex));
						prices.updateNode(nextIndex, compare);
						compare = quantities.getNode(index).toString();
						quantities.updateNode(index, quantities.getNode(nextIndex));
						quantities.updateNode(nextIndex, compare);
						compare = importDates.getNode(index).toString();
						importDates.updateNode(index, importDates.getNode(nextIndex));
						importDates.updateNode(nextIndex, compare);
						compare = warranties.getNode(index).toString();
						warranties.updateNode(index, warranties.getNode(nextIndex));
						warranties.updateNode(nextIndex, compare);
						compare = codes.getNode(index).toString();
						codes.updateNode(index, codes.getNode(nextIndex));
						codes.updateNode(nextIndex, compare);
					}
				}
			}
			break;
		// Sap sep theo gia tien
		case 2:
			for (int index = 0; ; index++) {
				if (prices.getNode(index) == null) break;
				for (int nextIndex = index + 1; ; nextIndex++) {
					if (prices.getNode(nextIndex) == null) break;
		    		String temp = prices.getNode(index).toString();
		    		String temp1 = prices.getNode(nextIndex).toString();
		    		float temp2 = Float.parseFloat(temp);
		    		float temp3 = Float.parseFloat(temp1);
					if (temp2 > temp3) {
						compare = products.getNode(index).toString();
						products.updateNode(index, products.getNode(nextIndex));
						products.updateNode(nextIndex, compare);
						compare = prices.getNode(index).toString();
						prices.updateNode(index, prices.getNode(nextIndex));
						prices.updateNode(nextIndex, compare);
						compare = quantities.getNode(index).toString();
						quantities.updateNode(index, quantities.getNode(nextIndex));
						quantities.updateNode(nextIndex, compare);
						compare = importDates.getNode(index).toString();
						importDates.updateNode(index, importDates.getNode(nextIndex));
						importDates.updateNode(nextIndex, compare);
						compare = warranties.getNode(index).toString();
						warranties.updateNode(index, warranties.getNode(nextIndex));
						warranties.updateNode(nextIndex, compare);
						compare = codes.getNode(index).toString();
						codes.updateNode(index, codes.getNode(nextIndex));
						codes.updateNode(nextIndex, compare);
					}
				}
			}
			break;
		// Sap xep theo ma san pham
		case 3:
			for (int index = 0; ; index++) {
				if (codes.getNode(index) == null) break;
				for (int nextIndex = index + 1; ; nextIndex++) {
					if (codes.getNode(nextIndex) == null) break;
		    		String temp = codes.getNode(index).toString();
		    		String temp1 = codes.getNode(nextIndex).toString();
		    		int temp2 = Integer.parseInt(temp);
		    		int temp3 = Integer.parseInt(temp1);
					if (temp2 > temp3) {
						compare = products.getNode(index).toString();
						products.updateNode(index, products.getNode(nextIndex));
						products.updateNode(nextIndex, compare);
						compare = prices.getNode(index).toString();
						prices.updateNode(index, prices.getNode(nextIndex));
						prices.updateNode(nextIndex, compare);
						compare = quantities.getNode(index).toString();
						quantities.updateNode(index, quantities.getNode(nextIndex));
						quantities.updateNode(nextIndex, compare);
						compare = importDates.getNode(index).toString();
						importDates.updateNode(index, importDates.getNode(nextIndex));
						importDates.updateNode(nextIndex, compare);
						compare = warranties.getNode(index).toString();
						warranties.updateNode(index, warranties.getNode(nextIndex));
						warranties.updateNode(nextIndex, compare);
						compare = codes.getNode(index).toString();
						codes.updateNode(index, codes.getNode(nextIndex));
						codes.updateNode(nextIndex, compare);
					}
				}
			}
			break;
		}
	}
	// Xoa san pham
	public void deleteProduct(String prodName, float price, 
			int quantity, Date importDate, String warranty, int code) {
		int index = 0;
		while (products.getNode(index) != null) {
			String text = products.getNode(index).toString();
			if (text.equalsIgnoreCase(prodName)) {
				products.deleteAtPosition(products, index);
				prices.deleteAtPosition(prices, index);
				quantities.deleteAtPosition(quantities, index);
				importDates.deleteAtPosition(importDates, index);
				warranties.deleteAtPosition(warranties, index);
				codes.deleteAtPosition(codes, index);	
			}
			index++;
		}
	}
}
	
	

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import DataStructure.*;
public class productData {
	private static linkedList products = new linkedList();
	private static linkedList prices = new linkedList();
	private static linkedList quantities = new linkedList();
	private static linkedList importDates = new linkedList();
	private static linkedList warranties = new linkedList();
	private static linkedList codes = new linkedList();
	private static Object[] storage = { products, prices, quantities, 
		importDates, warranties, codes};
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\productData.txt";
	writeAndRead hehe = new writeAndRead();
	public static linkedList getProducts() {
		return products;
	}

	public static linkedList getPrices() {
		return prices;
	}

	public static linkedList getQuantities() {
		return quantities;
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
	
	public void clearProduct() {
		hehe.clearFile(fileName);
	}
	
	public void saveProduct() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
		if (tmp != "-1") {
			arr = tmp.split("->");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "->");	
			}
			System.out.println();
			if (arr.length > 5) {
				int index = 0;
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
	
	public void sortProduct(int wayOfSort) {
		int index = 0;
		if (products.getNode(index) == null) return;
		String name = products.getNode(index).toString();
		String price = prices.getNode(index).toString();
		String quantity = quantities.getNode(index).toString();
		String importDate = importDates.getNode(index).toString();
		String warranty = warranties.getNode(index).toString();
		String code = codes.getNode(index).toString();
		switch (wayOfSort) {
		case 1:
	    	while (products.getNode(index + 1) != null) {
	    		name = products.getNode(index).toString();
	    		String name1 = products.getNode(index + 1).toString();
	    		price = prices.getNode(index).toString();
	    		quantity = quantities.getNode(index).toString();
	    		importDate = importDates.getNode(index).toString();
	    		warranty = warranties.getNode(index).toString();
	    		code = codes.getNode(index).toString();
				if (name.compareTo(name1) > 0) {
					products.updateNode(index, products.getNode(index + 1));
					products.updateNode(index + 1, name);
					prices.updateNode(index, prices.getNode(index + 1));
					prices.updateNode(index + 1, price);
					quantities.updateNode(index, quantities.getNode(index + 1));
					quantities.updateNode(index + 1, quantity);
					importDates.updateNode(index, importDates.getNode(index + 1));
					importDates.updateNode(index + 1, importDate);
					warranties.updateNode(index, warranties.getNode(index + 1));
					warranties.updateNode(index + 1, warranty);
					codes.updateNode(index, codes.getNode(index + 1));
					codes.updateNode(index + 1, code);
				}
				index++;
			}
			break;
		case 2:
			while (prices.getNode(index + 1) != null) {
	    		name = products.getNode(index).toString();
	    		price = prices.getNode(index).toString();
	    		String price1 = prices.getNode(index + 1).toString();
	    		quantity = quantities.getNode(index).toString();
	    		importDate = importDates.getNode(index).toString();
	    		warranty = warranties.getNode(index).toString();
	    		code = codes.getNode(index).toString();
				if (price.compareTo(price1) > 0) {
					products.updateNode(index, products.getNode(index + 1));
					products.updateNode(index + 1, name);
					prices.updateNode(index, prices.getNode(index + 1));
					prices.updateNode(index + 1, price);
					quantities.updateNode(index, quantities.getNode(index + 1));
					quantities.updateNode(index + 1, quantity);
					importDates.updateNode(index, importDates.getNode(index + 1));
					importDates.updateNode(index + 1, importDate);
					warranties.updateNode(index, warranties.getNode(index + 1));
					warranties.updateNode(index + 1, warranty);
					codes.updateNode(index, codes.getNode(index + 1));
					codes.updateNode(index + 1, code);
				}
				index++;
			}
			break;
		case 3:
			while (prices.getNode(index + 1) != null) {
	    		name = products.getNode(index).toString();
	    		price = prices.getNode(index).toString();
	    		quantity = quantities.getNode(index).toString();
	    		importDate = importDates.getNode(index).toString();
	    		warranty = warranties.getNode(index).toString();
	    		code = codes.getNode(index).toString();
	    		String code1 = codes.getNode(index + 1).toString();
				if (code.compareTo(code1) > 0) {
					products.updateNode(index, products.getNode(index + 1));
					products.updateNode(index + 1, name);
					prices.updateNode(index, prices.getNode(index + 1));
					prices.updateNode(index + 1, price);
					quantities.updateNode(index, quantities.getNode(index + 1));
					quantities.updateNode(index + 1, quantity);
					importDates.updateNode(index, importDates.getNode(index + 1));
					importDates.updateNode(index + 1, importDate);
					warranties.updateNode(index, warranties.getNode(index + 1));
					warranties.updateNode(index + 1, warranty);
					codes.updateNode(index, codes.getNode(index + 1));
					codes.updateNode(index + 1, code);
				}
				index++;
			}
			break;
		}
	}

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
	
	

package Data;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import subClass.*;
import DataStructure.*;
public class customerData {
	// Khoi tao cac bien su dung de luu tru khach hang theo danh sach lien ket
	private static linkedList names = new linkedList();
	private static linkedList phones = new linkedList();
	private static linkedList genders = new linkedList();
	private static linkedList birthdays = new linkedList();
	private static Object[] storage = { names, phones, genders, birthdays};
	// Tao ra duong dan toi file txt luu du lieu
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\customerData.txt";
	writeAndRead hehe = new writeAndRead();
	// lay ra cac gia tri cua khach hang (ten khach hang, so dien thoai, gioi tinh, ngay sinh)
		public static linkedList getNames() {
			return names;
		}

		public static linkedList getPhones() {
			return phones;
		}

		public static linkedList getGenders() {
			return genders;
		}

		public static linkedList getBirthdays() {
			return birthdays;
		}
	// Them khach hang
	public void addCustomer(String name ,String phone, String gender, 
			Date dob) {
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("dd/MM/yyyy");
		names.insert(names, name);
		phones.insert(phones, phone);
		genders.insert(genders, gender);
		birthdays.insert(birthdays, simpleDateFormat.format(dob));
		saveCustomer();
	}
	// Xoa du lieu khach hang trong file txt
	public void clearCustomer() {
		hehe.clearFile(fileName);
	}
	// Luu lai cac khach hang trong danh sach lien ket vao file txt
	public void saveCustomer() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Doc file txt xuat ra cac khach hang vao danh sach lien ket
	public void readCustomer() {
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
	// chinh sua lai gia tri cua khach hang
	public void updateCustomer(String name ,String phone, 
			String gender, Date dob) {
		int index = 0;
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("dd/MM/yyyy");
		while (names.getNode(index) != null) {
			String text = phones.getNode(index).toString();
			if (text.equalsIgnoreCase(name)) {
				names.updateNode(index, name);
				phones.updateNode(index, phone);
				genders.updateNode(index, gender);
				birthdays.updateNode(index, simpleDateFormat.format(dob));
			}
			index++;
		}
	}
	// sap xep lai cac khach hang theo ten su dung bubble sort
	public void sortCustomer() {
		String compare;
		if (names.getNode(0) == null) return;
		for (int index = 0; ; index++) {
			if (names.getNode(index) == null) break;
			for (int nextIndex = index + 1; ; nextIndex++) {
				if (names.getNode(nextIndex) == null) break;
	    		String temp = names.getNode(index).toString();
	    		String temp1 = names.getNode(nextIndex).toString();
				if (temp.compareTo(temp1) > 0) {
					compare = names.getNode(index).toString();
					names.updateNode(index, names.getNode(nextIndex));
					names.updateNode(nextIndex, compare);
					compare = phones.getNode(index).toString();
					phones.updateNode(index, phones.getNode(nextIndex));
					phones.updateNode(nextIndex, compare);
					compare = genders.getNode(index).toString();
					genders.updateNode(index, genders.getNode(nextIndex));
					genders.updateNode(nextIndex, compare);
					compare = birthdays.getNode(index).toString();
					birthdays.updateNode(index, birthdays.getNode(nextIndex));
					birthdays.updateNode(nextIndex, compare);
				}
			}
		}
	}
	// xoa di khach hang da lua chon tu bang
	public void deleteCustomer(String name ,String phone, String gender, 
			Date dob) {
		int index = 0;
		while (names.getNode(index) != null) {
			String text = names.getNode(index).toString();
			if (text.equalsIgnoreCase(name)) {
				names.deleteAtPosition(names, index);
				phones.deleteAtPosition(phones, index);
				genders.deleteAtPosition(genders, index);
				birthdays.deleteAtPosition(birthdays, index);
			}
			index++;
		}
	}
	
}	

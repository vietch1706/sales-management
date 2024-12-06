import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import DataStructure.*;
public class customerData {
private static linkedList names = new linkedList();
private static linkedList phones = new linkedList();
private static linkedList genders = new linkedList();
private static linkedList birthdays = new linkedList();
private static Object[] storage = { names, phones, genders, birthdays};
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\customerData.txt";
	writeAndRead hehe = new writeAndRead();

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

	public void clearCustomer() {
		hehe.clearFile(fileName);
	}
	
	public void saveCustomer() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	
	public void updateCustomer(String name ,String phone, String gender,
			Date dob) {
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

	public void sortCustomer() {
		int index = 0;
		if (names.getNode(index) == null) return;
		String name = names.getNode(index).toString();
		String phone = phones.getNode(index).toString();
		String gender = genders.getNode(index).toString();
		String dob = birthdays.getNode(index).toString();
		while (names.getNode(index + 1) != null) {
    		name = names.getNode(index).toString();
    		String name1 = names.getNode(index + 1).toString();
    		phone = phones.getNode(index).toString();
    		gender = genders.getNode(index).toString();
    		dob = birthdays.getNode(index).toString();
			if (name.compareTo(name1) > 0) {
				names.updateNode(index, names.getNode(index + 1));
				names.updateNode(index + 1, name);
				phones.updateNode(index, phones.getNode(index + 1));
				phones.updateNode(index + 1, phone);
				genders.updateNode(index, genders.getNode(index + 1));
				genders.updateNode(index + 1, gender);
				birthdays.updateNode(index, birthdays.getNode(index + 1));
				birthdays.updateNode(index + 1, dob);
			}
			index++;
		}
	}
	
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

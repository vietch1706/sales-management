package Data;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import subClass.*;
import DataStructure.*;
public class employeeData {
	// Khoi tao cac bien su dung de luu tru nhan vien theo mang dong
	private static dynamicArray names = new dynamicArray();
	private static dynamicArray phones = new dynamicArray();
	private static dynamicArray genders = new dynamicArray();
	private static dynamicArray positions = new dynamicArray();
	private static dynamicArray birthdays = new dynamicArray();
	private static dynamicArray empCodes = new dynamicArray();
	private static Object[] storage = { names, phones, genders, 
		positions, birthdays, empCodes};
	// Tao ra duong dan toi file txt luu du lieu
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\employeeData.txt";
	writeAndRead hehe = new writeAndRead();
	// Lay ra du lieu cua cac nhan vien (ten, sdt, gioi tinh, vi tri, sinh nhat, ma nhan vien)
	public static dynamicArray getNames() {
		return names;
	}

	public static dynamicArray getPhones() {
		return phones;
	}

	public static dynamicArray getGenders() {
		return genders;
	}

	public static dynamicArray getPositions() {
		return positions;
	}

	public static dynamicArray getBirthdays() {
		return birthdays;
	}

	public static dynamicArray getEmpCodes() {
		return empCodes;
	}
	// Them nhan vien
	public void addEmloyee(String name ,String phone, String gender, 
			String position, Date dob, int empCode) {
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("dd/MM/yyyy");
		names.add(name);
		phones.add(phone);
		genders.add(gender);
		positions.add(position);
		birthdays.add(simpleDateFormat.format(dob));
		empCodes.add(empCode);
		saveEmployee();
	}
	// Xoa du lieu nhan vien trong file txt
	public void clearEmployee() {
		hehe.clearFile(fileName);
	}
	// Luu lai cac nhan vien trong mang dong vao file txt
	public void saveEmployee() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// Doc file txt xuat ra cac khach hang vao mang dong
	public void readEmployee() {
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
	// chinh sua lai gia tri cua nhan vien
	public void updateEmloyee(String name ,String phone, String gender, 
			String position, Date dob, int empCode) {
		int index = 0;
		while (names.get(index) != null) {
			String text = names.get(index).toString();
			if (text.equalsIgnoreCase(name)) {
				names.update(index, name);
				phones.update(index, phone);
				genders.update(index, gender);
				positions.update(index, position);
				birthdays.update(index, dob);
				empCodes.update(index, empCode);
			}
			index++;
		}

	}
	// sap xep lai cac nhan vien theo ten su dung bubble sort ( 3 cach sap xep )
	public void sortEmployee(int wayOfSort) {
		/*
		 * Cach 1: Sap xep theo ten nhan vien
		 * Cach 2: Sap xep theo vi tri nhan vien
		 * Cach 3: Sap xep theo Ma nhan vien
		 * */
		String compare;
		if (names.get(0) == null) return;
		switch (wayOfSort) {
		// Sap xep theo ten nhan vien
		case 1:
			for (int index = 0; index < names.getCapacity(); index++) {
				if (names.get(index) == null) break;
				for (int nextIndex = index + 1;
						nextIndex < names.getCapacity() - 1; nextIndex++) {
					if (names.get(nextIndex) == null) break;
		    		String temp = names.get(index).toString();
		    		String temp1 = names.get(nextIndex).toString();
					if (temp.compareTo(temp1) > 0) {
						compare = names.get(index).toString();
						names.update(index, names.get(nextIndex));
						names.update(nextIndex, compare);
						compare = phones.get(index).toString();
						phones.update(index, phones.get(nextIndex));
						phones.update(nextIndex, compare);
						compare = genders.get(index).toString();
						genders.update(index, genders.get(nextIndex));
						genders.update(nextIndex, compare);
						compare = positions.get(index).toString();
						positions.update(index, positions.get(nextIndex));
						positions.update(nextIndex, compare);
						compare = birthdays.get(index).toString();
						birthdays.update(index, birthdays.get(nextIndex));
						birthdays.update(nextIndex, compare);
						compare = empCodes.get(index).toString();
						empCodes.update(index, empCodes.get(nextIndex));
						empCodes.update(nextIndex, compare);
					}
				}
			}
			break;
		// Sap xep theo vi tri nhan vien
		case 2:
			for (int index = 0; index < positions.getCapacity(); index++) {
				if (positions.get(index) == null) break;
				for (int nextIndex = index + 1;
						nextIndex < positions.getCapacity() - 1; nextIndex++) {
					if (positions.get(nextIndex) == null) break;
		    		String temp = positions.get(index).toString();
		    		String temp1 = positions.get(nextIndex).toString();
					if (temp.compareTo(temp1) > 0) {
						compare = names.get(index).toString();
						names.update(index, names.get(nextIndex));
						names.update(nextIndex, compare);
						compare = phones.get(index).toString();
						phones.update(index, phones.get(nextIndex));
						phones.update(nextIndex, compare);
						compare = genders.get(index).toString();
						genders.update(index, genders.get(nextIndex));
						genders.update(nextIndex, compare);
						compare = positions.get(index).toString();
						positions.update(index, positions.get(nextIndex));
						positions.update(nextIndex, compare);
						compare = birthdays.get(index).toString();
						birthdays.update(index, birthdays.get(nextIndex));
						birthdays.update(nextIndex, compare);
						compare = empCodes.get(index).toString();
						empCodes.update(index, empCodes.get(nextIndex));
						empCodes.update(nextIndex, compare);
					}
				}
			}
			break;
		// Sap xep theo ma nhan vien
		case 3:
			for (int index = 0; index < empCodes.getCapacity(); index++) {
				if (empCodes.get(index) == null) break;
				for (int nextIndex = index + 1;
						nextIndex < empCodes.getCapacity() - 1; nextIndex++) {
					if (empCodes.get(nextIndex) == null) break;
		    		String temp = empCodes.get(index).toString();
		    		String temp1 = empCodes.get(nextIndex).toString();
		    		int temp2 = Integer.parseInt(temp);
		    		int temp3 = Integer.parseInt(temp1);
					if (temp2 > temp3) {
						compare = names.get(index).toString();
						names.update(index, names.get(nextIndex));
						names.update(nextIndex, compare);
						compare = phones.get(index).toString();
						phones.update(index, phones.get(nextIndex));
						phones.update(nextIndex, compare);
						compare = genders.get(index).toString();
						genders.update(index, genders.get(nextIndex));
						genders.update(nextIndex, compare);
						compare = positions.get(index).toString();
						positions.update(index, positions.get(nextIndex));
						positions.update(nextIndex, compare);
						compare = birthdays.get(index).toString();
						birthdays.update(index, birthdays.get(nextIndex));
						birthdays.update(nextIndex, compare);
						compare = empCodes.get(index).toString();
						empCodes.update(index, empCodes.get(nextIndex));
						empCodes.update(nextIndex, compare);
					}
				}
			}
			break;
		}
	}
	// Xoa di nhan vien da lua chon trong bang
	public void deleteEmployee(String name ,String phone, String gender, 
			String position, Date dob, int empCode) {
		int index = 0;
		while (names.get(index) != null) {
			String text = names.get(index).toString();
			if (text.equalsIgnoreCase(name)) {
				names.delete(name);
				phones.delete(phone);
				genders.delete(gender);
				positions.delete(position);
				birthdays.delete(dob);
				empCodes.delete(empCode);	
			}
			index++;
		}
	}
}	

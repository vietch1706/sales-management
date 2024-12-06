import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import DataStructure.*;
public class employeeData {
private static dynamicArray names = new dynamicArray();
private static dynamicArray phones = new dynamicArray();
private static dynamicArray genders = new dynamicArray();
private static dynamicArray positions = new dynamicArray();
private static dynamicArray birthdays = new dynamicArray();
private static dynamicArray empCodes = new dynamicArray();
private static Object[] storage = { names, phones, genders, 
		positions, birthdays, empCodes};
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath()
			.toString() + "\\saveData\\employeeData.txt";
	writeAndRead hehe = new writeAndRead();


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
	
	public void clearEmployee() {
		hehe.clearFile(fileName);
	}
	
	public void saveEmployee() {
		try {
			hehe.writeFile(fileName, storage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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

	public void sortEmployee(int wayOfSort) {
		int index = 0;
		if (names.get(index) == null) return;
		String name = names.get(index).toString();
		String phone = phones.get(index).toString();
		String gender = genders.get(index).toString();
		String position = positions.get(index).toString();
		String dob = birthdays.get(index).toString();
		String code = empCodes.get(index).toString();
		switch (wayOfSort) {
		case 1:
	    	while (names.get(index + 1) != null) {
	    		name = names.get(index).toString();
	    		String name1 = names.get(index + 1).toString();
	    		phone = phones.get(index).toString();
	    		gender = genders.get(index).toString();
	    		position = positions.get(index).toString();
	    		dob = birthdays.get(index).toString();
	    		code = empCodes.get(index).toString();
				if (name.compareTo(name1) > 0) {
					names.update(index, names.get(index + 1));
					names.update(index + 1, name);
					phones.update(index, phones.get(index + 1));
					phones.update(index + 1, phone);
					genders.update(index, genders.get(index + 1));
					genders.update(index + 1, gender);
					positions.update(index, positions.get(index + 1));
					positions.update(index + 1, position);
					birthdays.update(index, birthdays.get(index + 1));
					birthdays.update(index + 1, dob);
					empCodes.update(index, empCodes.get(index + 1));
					empCodes.update(index + 1, code);
				}
				index++;
			}
			break;
		case 2:
			while (names.get(index + 1) != null) {
	    		name = names.get(index).toString();
	    		phone = phones.get(index).toString();
	    		gender = genders.get(index).toString();
	    		position = positions.get(index).toString();
	    		String position1 = positions.get(index + 1).toString();
	    		dob = birthdays.get(index).toString();
	    		code = empCodes.get(index).toString();
				if (position.compareTo(position1) > 0) {
					names.update(index, names.get(index + 1));
					names.update(index + 1, name);
					phones.update(index, phones.get(index + 1));
					phones.update(index + 1, phone);
					genders.update(index, genders.get(index + 1));
					genders.update(index + 1, gender);
					positions.update(index, positions.get(index + 1));
					positions.update(index + 1, position);
					birthdays.update(index, birthdays.get(index + 1));
					birthdays.update(index + 1, dob);
					empCodes.update(index, empCodes.get(index + 1));
					empCodes.update(index + 1, code);
				}
				index++;
			}
			break;

		case 3:
			while (names.get(index + 1) != null) {
	    		name = names.get(index).toString();
	    		phone = phones.get(index).toString();
	    		gender = genders.get(index).toString();
	    		position = positions.get(index).toString();
	    		dob = birthdays.get(index).toString();
	    		code = empCodes.get(index).toString();
	    		String code1 = empCodes.get(index + 1).toString();
				if (code.compareTo(code1) > 0) {
					names.update(index, names.get(index + 1));
					names.update(index + 1, name);
					phones.update(index, phones.get(index + 1));
					phones.update(index + 1, phone);
					genders.update(index, genders.get(index + 1));
					genders.update(index + 1, gender);
					positions.update(index, positions.get(index + 1));
					positions.update(index + 1, position);
					birthdays.update(index, birthdays.get(index + 1));
					birthdays.update(index + 1, dob);
					empCodes.update(index, empCodes.get(index + 1));
					empCodes.update(index + 1, code);
				}
				index++;
			}
			break;

		}
	}
	
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

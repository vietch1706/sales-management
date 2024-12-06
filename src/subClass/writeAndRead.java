package subClass;

import java.io.*;
import DataStructure.*;

public class writeAndRead {
	public static void writeFile(String fileName, Object[] storage) throws IOException {
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		PrintWriter pw = null;
		try { 
			fw = new FileWriter(fileName, true); 
			bw = new BufferedWriter(fw); 
			pw = new PrintWriter(bw);
			boolean isAdding = true;
			String getStorage = storage[0].getClass().getName();
			if(getStorage.equalsIgnoreCase("DataStructure.linkedList")) {
				int index = 0;
				for (int i = 0; i < storage.length; i++) {
					linkedList llist = (linkedList) storage[i];
					
					while (llist.getNode(index) != null) {
						if (isAdding) {
							pw.print(llist.getNode(index) + "->");
							System.out.print(llist.getNode(index) + "->");
							isAdding = false;
	 					} else {
							isAdding = true;
							break;
						}
					}
					if (llist.getNode(index) != null && i == storage.length - 1) {
						index++;
						i = -1;
					}
				}
			} else if(getStorage.equalsIgnoreCase("DataStructure.dynamicArray")) {
				int index = 0;
				for (int i = 0; i < storage.length; i++) {
					dynamicArray dyArr = (dynamicArray) storage[i];
					
					while (dyArr.get(index) != null) {
						if (isAdding) {
							pw.print(dyArr.get(index) + "->");
							System.out.print(dyArr.get(index) + "->");
							isAdding = false;
	 					} else {
							isAdding = true;
							break;
						}
					}
					if (dyArr.get(index) != null && i == storage.length - 1) {
						index++;
						i = -1;
					}
				}
			}
			pw.println();
			System.out.println("\nData Successfully appended into file"); 
			pw.flush(); 
		} finally {
			try { 
				pw.close(); 
				bw.close(); 
				fw.close(); 
			} catch (IOException io) {
			}
		}
	}
	public static String readFile(String fileName, Object[] storage) throws Exception {
        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fileName));
        String st = null;
        if ((st = br.readLine()) != null) return st;
//		clearFile(fileName);
		return "-1";
	}
	public static void clearFile(String fileName) { 
	    try {
	    FileWriter fw = new FileWriter(fileName, false);
	    PrintWriter pw = new PrintWriter(fw, false);
	    pw.flush();
	    pw.close();
	    fw.close();
	    } catch(Exception exception) {
	        System.out.println("Exception have been caught");
	    }
	}
}

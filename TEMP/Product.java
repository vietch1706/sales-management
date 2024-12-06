import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Product {
	Scanner sc = new Scanner(System.in);
	public String product[][] = new String[2][100];
	private int col = 0;
	Path currentRelativePath = Paths.get("");
	private String fileName = currentRelativePath.toAbsolutePath().toString()
			+ "\\data\\product.txt";
	
	void productFunc() throws Exception {
		writeAndRead.readFile(fileName, product);
		writeAndRead.clearFile(fileName);
		boolean isChoosing = true;
		int key;
		do {
			System.out.println("1. Add product");
			System.out.println("2. Print product");
			System.out.println("3. Back");			
			System.out.print("Enter your choice: ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				addProduct();
				break;
			case 2:
				printProduct(product);
				break;
			case 3:
				writeAndRead.writeFile(fileName, product);
				isChoosing = false;
				break;
			default:
				System.out.println("Wrong input. Again.");
				break;
			}
		} while (isChoosing);
	}
	void addProduct() throws Exception {
		boolean isEntering = true;
		String yN;
		System.out.print("Enter product(Y or N): ");
		do {
			yN = sc.next();
			switch (yN) {
			case "Y": {
				System.out.print("Product name: ");
				product[0][col] = sc.next();
				System.out.print("Product manufacturer: ");
				product[1][col] = sc.next();
				System.out.print("Continue enter product (Y or N): ");
				col++;
				break;
			}
			case "N": {
				isEntering = false;
				System.out.println("Quit enter product.");
				break;
			}
			default:
				System.out.print("Wrong input. Enter again (Y or N): ");
			}
				
		} while (isEntering);
	}
	void printProduct(String[][] product) throws Exception {
		System.out.println("Product \t Manufacturer" );
		for (int i = 0; i < product[0].length; i++) {
			if (product[0][i] != null) {
				System.out.println(product[0][i] + "\t\t" + 
						product[1][i]);
			}
		}
	}
}


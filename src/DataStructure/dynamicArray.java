package DataStructure;
// khai bao mang dong
public class dynamicArray {
	int size;	
	private int capacity = 10;	// khich thuoc ban dau cua mang la 1o
	Object[] array;
	// lay ra kich thuoc cua mang
	public int getCapacity() {
		return capacity;
	}
	
	public dynamicArray() {
		this.array = new Object[capacity];
	}
	// tao mang dong co kich thuoc la capacity
	public dynamicArray(int capacity) {	
		this.capacity = capacity;
		this.array = new Object[capacity];
	}
	// lay ra du lieu tai vi tri index cua mang dong
    public Object get(int index) {
    	// neu vi tri can tim lon hon kich thuoc thi tra ve null
    	if (index == capacity) array[index] = null;
    	return array[index];	// tra ve gia tri can tim
    }
	// them du lieu cho mang dong
	public void add(Object data) {
		if(size >= capacity) {	/*Neu do lon hien tai cua mang
		 						bang kich thuoc cua mang thi 
		 						mo rong kich thuoc*/
			grow();
		}
		array[size] = data;	// them gia tri moi
		size++;
	}
	// xoa du lieu trong mang
	public void delete(Object data) {
		
		for(int i = 0; i < size; i++) {
			if(array[i] == data) {
				for(int j = 0; j < (size - i - 1); j++){
					array[i + j] = array[i + j + 1];
				}
				array[size - 1] = null;
				size--;
				if(size <=(int) (capacity/3)) {	/* Neu do lon cua mang
				 							be hon 3 lan so voi kich thuic
				 						mang thi lam be lai kich thuoc*/
					shrink();
				}
				break;
			}
		}
	}
	// chinh sua gia tri cua phan tu tai index cua mang
	public void update(int index, Object data) {
		
		for(int i = 0; i < size; i++) {
			if(i == index) {
				array[i] = data;
			}
		}
	}
	// tang kich thuoc mang
	private void grow() {
		// tu tang kich thuoc len gap doi
		int newCapacity = (int)(capacity * 2);
		Object[] newArray = new Object[newCapacity];
		
		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		capacity = newCapacity;
		array = newArray;
	}
	// giam kich thuoc mang
	private void shrink() {
		// tu giam kich thuoc cua mang di 2 lan
		int newCapacity = (int)(capacity / 2);
		Object[] newArray = new Object[newCapacity];
		
		for(int i = 0; i < size; i++) {
			newArray[i] = array[i];
		}
		capacity = newCapacity;
		array = newArray;
	}
	// kiem tra mang rong
	public boolean isEmpty() {
		return size == 0;
	}
	// in ra du lieu co trong mang
	public String toString() {
		
		String string = "";
		
		for(int i = 0; i < capacity; i++) {
			string += array[i] + ", ";
		}
		if(string != "") {
			string = string.substring(0, string.length() - 2);
		}
		else {
			string = "";
		}
		return string;
	}
}
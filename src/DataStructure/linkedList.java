package DataStructure;
// Danh sach lien ket
public class linkedList { 
    Node head;	// Tao Node head
    
    class Node {  
        Object data; // Du lieu duoc luu tru
        Node next; // Node next de lien ket voi node tiep theo
        // luu gia tri cua node vao
        Node(Object d) { 
            data = d; 
            next = null; 
        }
    }
    // chen them node moi vao danh sach lien ket
    public linkedList insert(linkedList list, Object data) {
        Node new_node = new Node(data); // tao ra node moi
        if (list.head == null) {	// neu node head la null thi them node moi
            list.head = new_node; 
        } 
        else {	// neu node head ko bang null
            Node last = list.head; 
            while (last.next != null) {	// tim kiem node cuoi cung
                last = last.next; 
            }
            last.next = new_node;	// them node moi
        }
        return list;	// tra ve danh sach
    }
    // lay ra gia tri cua node tai dia chi cu the
    public Object getNode(int index) {
        Node current = head;
        int count = 0; /*  so thu tu cua node ta dang tro toi  */
        while (current != null)
        {
            if (count == index)	// neu tim duoc so do thi tra ve du lieu
                return current.data;
            count++;
            current = current.next;
        }
  
        /* neu chay toi day thi tuc la vi tri do
         * ko ton tai va tra ve assert la false */
        assert (false);
        return null;
    }
    // chinh sua lai gia tri cua node
    public void updateNode(int index, Object data) {
        Node current = head;
        int count = 0; /* so thu tu cua node ta dang tro toi  */
        while (current != null)
        {
            if (count == index)
                current.data = data;
            count++;
            current = current.next;
        }
  
        /* neu chay toi day thi tuc la vi tri do
         * ko ton tai va tra ve assert la false */
        assert (false);
    }
    
    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    // tim va xoa node tai vi tri cho san
    public linkedList deleteAtPosition(linkedList list, int index) {
    	// khai bao gia tri node hien tai 
        Node currNode = list.head, prev = null;
        // vi tri can tim la 0 va node hien tai
        // khong phai la null thi tra ve node head
        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            System.out.println(
                index + " position element deleted");
            return list;
        }
        int counter = 0;
        // node hien tai khac 0 thi tim kiem
        while (currNode != null) {
            if (counter == index) {	// tim toi vi tri cua node can tim
                prev.next = currNode.next;
                System.out.println(
                    index + " position element deleted");
                break;
            }
            else {	// neu chua toi vi tri can tim thi tro node tiep theo
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null) {	// neu node la null thi tra ve ko co gia tri
            System.out.println(
                index + " position element not found");
        }
        return list;	// tra ve danh sach 
    }
}

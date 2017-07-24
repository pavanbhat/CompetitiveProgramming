
public class ReverseLinkedList {

	public static void main(String[] args) {
		ReverseLinkedList sol = new ReverseLinkedList();
		Node head = new Node();
		int offset = 10; 
		for(int i = 1; i < 5; i++){
			sol.addNode(head, i * offset);
		}
		Node temp = head;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
		
		Node nextNode = null;
		Node prevNode = null;
		Node currNode = head;
		while(currNode != null){
			nextNode = currNode.next;
			currNode.next = prevNode;
		    prevNode = currNode;
		    currNode = nextNode;
		}

		System.out.println();
		temp = prevNode;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
		

	}
	
	public Node addNode(Node head, int data){
		Node temp = head;
		if(temp == null){
			temp = new Node(null, data);
			return head;
		}
		while(temp != null){	
			if(temp.next == null){
				temp.next = new Node(null, data);
				return head;				
			}
			temp = temp.next;
		}
		return head;
	}

}


class Node{
	Node next;
	int data;
	
	public Node(){
		this.next = null;
		this.data = 0;
	}
	
	public Node(Node next, int data) {
		this.next = next;
		this.data = data;
	}
	
}
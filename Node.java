//This is for a single linked list
public class Node {
	
	public int data;
	public Node next;
	public Node(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}
	public static void main(String args[]) {
		Node head=new Node(6);
		Node nodeB=new Node(3);
		Node nodeC=new Node(4);
		Node nodeD=new Node(2);
		Node nodeE=new Node(1);
		head.next=nodeB;
		nodeB.next=nodeC;
		nodeC.next=nodeD;
		nodeD.next=nodeE;	
		System.out.println(count(head));
		Node temp=head;
		while(temp!=null) {
			System.out.println("Forward iteration: "+temp.data);
			temp=temp.next;
		}
	}
	public static int count(Node head) {
		int num=1;
		if(head.next==null)
			return num+=0;
		else
			return num+count(head.next);
	}
}

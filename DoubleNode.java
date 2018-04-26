
public class DoubleNode {

	public DoubleNode next;
	public DoubleNode prev;
	public int data;
	public DoubleNode(int data) {
		// TODO Auto-generated constructor stub
		this.data=data;
	}
	public static int size(DoubleNode tem) {
		int num=1;
		if(tem.next==null)
			return num+=0;
		else
			return num+size(tem.next);
	}
	public static void main(String args[]) {
		DoubleNode head=new DoubleNode(5);
		DoubleNode nodeA=new DoubleNode(8);
		DoubleNode nodeB=new DoubleNode(9);
		DoubleNode nodeC=new DoubleNode(4);
		DoubleNode tail=new DoubleNode(7);
		head.next=nodeA;
		nodeA.next=nodeB;
		nodeB.next=nodeC;
		nodeC.next=tail;
		tail.prev=nodeC;
		nodeC.prev=nodeB;
		nodeB.prev=nodeA;
		nodeA.prev=head;
		DoubleNode temp=head;
		while(temp!=null) {
			System.out.println("Forward iteration: "+temp.data);
			temp=temp.next;
		}
		temp=tail;
		while(temp!=null) {
			System.out.println("Backward iteration: "+temp.data);
			temp=temp.prev;
		}
	}
	
}

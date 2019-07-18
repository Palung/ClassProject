
public class LinkedQueue {
	protected int size;
	protected Node front;
	protected Node rear;
	public LinkedQueue() {
		size=0;
		front=null;
		rear=null;
	}
	public int binarySearchRecursive(int[] num, int low, int high, int target) {
		int middle=(low+high)/2;
		if(low>high) {
			System.out.print(target+ " this number doesn't exist: ");
			return -1;
		}
		if(num[middle]==target)
			return num[middle];
		else
			if(num[middle]>target) {
				//if the current number>target then we decease the middle
				//We use high because the index of high decreases as we
				//Transverse the lower halves of the array/subarray
				return binarySearchRecursive(num, low, middle-1, target);
			}
			else
				//if the current number<target then we increase the lower bound
				//while increasing the middle and we have to transverse the upper
				//half of the array/subarray
				return binarySearchRecursive(num, middle+1,high, target);
	}
	public void bubbleSort(int[] data) {
		int temp=data[0];
	}
	public void enQueue(int data) {
		Node newNode=new Node(data);
		Node dummy=newNode;
		if(getSize()==0) {
			front=newNode;
			rear=front;
		}
//			if(front==rear) {
//				System.out.println("2 Nodes");
//				rear=newNode;
//				System.out.println(rear.data + " data second");
//			}
//			else {
//				System.out.println("next nodes");
//				temp=newNode;
//				rear=temp;
//				temp=temp.next;
//				System.out.println(rear.data +" data over 2nd");
//			}
		rear.next=newNode;
		rear=newNode;
		System.out.println(data +" has been enQueued");
		size++;
	}
	public void iterate() {
		Node temp=front;
		System.out.println("Iterate: ");
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public int getSize() {
		return size;
	}
	public int deQueue() {
		Node newFront=new Node(-3);
		Node dummy=front;
		int x[]=new int[2];
		if(front==null) {
			newFront.data=-1;
		}
		else {
			newFront=front;
			front=front.next;
		}
		size--;
		System.out.println("Dequeue "+newFront.data);
		return newFront.data;
	}
	public int first() {
		return front.data;
	}
	public int last() {
		return rear.data;
	}
	public boolean isEmpty(){
		return front==null;
	}
	public int linearSearch( int target) {
		int x=0;
		Node temp=front;
		while(temp!=null&&x!=target) {
			System.out.println("Linear search iteration: "+temp.data);
			if(temp.data==target)
				x=target;
			else
				x=-1;
			temp=temp.next;
		}
		return x;
	}
	public int partition(int data[], int pivot, int left, int right) {
		int i=left;
		int j=right;
		int temp=0;
//		pivot=data[(left+right)/2];
		while(i<=j) {
			while(data[i]<pivot) {
//				System.out.println("i "+i);
				i++;
//				System.out.println("new i "+i);
			}
			while(data[j]>pivot) {
//				System.out.println("j "+j);
				j--;
//				System.out.println("new j: "+j);
			}
			if(i<=j) {
				temp=data[i];
				data[i]=data[j];
				data[j]=temp;
				i++;
				j--;
			}
		}
		return i;
	}
	public void quickSort(int[] data, int left, int right) {
		int index=partition(data,data[(right+left)/2],left, right);
		if(left<index-1) {
			quickSort(data, left, index-1);
		}
		if(right>index) {
			quickSort(data,index, right);
		}
	}
	public void sortQueue() {
		Node temp=front;
		int x[]=new int[getSize()];
		int i=0;
		while(temp!=null) {
			x[i]=deQueue();
			temp=temp.next;
			i++;
		}
		quickSort(x, 0, x.length-1);
		for(int j=0; j<x.length; j++) {
			enQueue(x[j]);
		}
	}
	public static void main(String args[]) {
		LinkedQueue queue=new LinkedQueue();
		queue.enQueue(4);
		queue.enQueue(6);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(1);
		queue.enQueue(5);
		queue.enQueue(7);
		System.out.println("Delimiter");
//		System.out.println("First element is: "+queue.first());
//		System.out.println("Last element is: "+queue.last());
//		System.out.println("It is empty: "+queue.isEmpty());
//		queue.iterate();
//		System.out.println("Size of queue is: "+queue.getSize());
//		System.out.println("Linear searching target " +queue.linearSearch(4));
//		System.out.println("After deQueueing the new front is "+queue.deQueue());
//		queue.iterate();
		queue.sortQueue();
		System.out.println("Delimiter");
		queue.iterate();
		System.out.println("It is empty "+queue.isEmpty());
	}
}

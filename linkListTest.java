/* Keith Bender
 * Assignment 02
 * 3354 Monday 6:30pm
 * Due 10/01/2018
 * Description: This program implements a linkList class an a reverse method. It prints out the linkList as well as its reverse.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ListIterator;


public class linkListTest
{
	public static void main(String[] args) 
	{
		//create new list
		List<Integer> newList = new ArrayList<Integer>();
		
		for(int i = 0; i < 5; i++)
		{
			//generate randomNumber
			Random rand = new Random();
			int randomNum = rand.nextInt(1000); //random number between 0 and 1000;
			newList.add(randomNum);
		}
		
		LinkedList linkedList = new LinkedList();
		linkedList = linkedList.createLinkList(newList);
		
		System.out.println("List of integers");
		for(int i = 0; i < newList.size(); i++)
		{
			System.out.println(newList.get(i));
		}
		
		System.out.println();
		System.out.println("Linked List of integers");
		for(int i = 0; i < linkedList.size(); i++) 
		{
			System.out.println(linkedList.get(i));
		}
		
		System.out.println();
		System.out.println("Reverse Linked List of integers");
		
		LinkedList reverseList = new LinkedList();
		reverseList = linkedList.reverseLinkedList(linkedList);
		for(int i = 0; i < reverseList.size(); i++) 
		{
			System.out.println(reverseList.get(i));
		}
	}
}

class LinkedList {
	//Public
	//Default Constructor
	public LinkedList () {}
	
	//create link list from a list of integer
	public LinkedList createLinkList(List<Integer> integerList) 
	{
		LinkedList linkList = new LinkedList();
		
		for(int i = 0; i < integerList.size(); i++)
		{
			linkList.add(integerList.get(i));
		}
		return linkList;
	}
	
	public LinkedList reverseLinkedList(LinkedList inputList) 
	{
		LinkedList temp = new LinkedList();
		temp = inputList;
		Node current = temp.head;
		Node prev = null;
		Node next;
		
		while(current != null) 
		{
			next = current.next;
			current.setNext(prev);
			prev = current;
			current = next;
		}
		temp.head = prev;
		return temp;
	}
	
	//adds at the end of the list
	public void add (Object data)
	{	
		//initialize if it is only he 1st element
		if (head == null)
		{
			head = new Node(data);
		}

		Node temp = new Node(data);
		Node currentHead = head;

		if (currentHead != null)
		{
			while (currentHead.getNext() != null) 
			{
				currentHead = currentHead.getNext();
			}
			currentHead.setNext(temp);
		}
		incrementCounter();
	}

	public void add (Object data, int index)
	{
		Node temp = new Node(data);
		Node currentHead = head;

		if (currentHead != null)
		{
			for (int i = 0; i < index && currentHead.getNext() != null; i++)
			{
				currentHead = currentHead.getNext();
			}
		}
			temp.setNext(currentHead.getNext());
			currentHead.setNext(temp);
			incrementCounter();
	}
	
	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index < 0)
			return null;
		Node currentHead = null;
		if (head != null) 
		{
			currentHead = head.getNext();
			for (int i = 0; i < index; i++) 
			{
				if (currentHead.getNext() == null)
					return null;
 
				currentHead = currentHead.getNext();
			}
			return currentHead.getData();
		}
		return currentHead;
 
	}
	
	public boolean remove(int index) {
		 
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;
 
		Node currentHead = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (currentHead.getNext() == null)
					return false;
 
				currentHead = currentHead.getNext();
			}
			currentHead.setNext(currentHead.getNext().getNext());
 
			// decrement the number of elements variable
			decrementCounter();
			return true;
 
		}
		return false;
	}

	public int size ()
	{
		return getCounter();
	}	
	
	public String toString() {
		String output = "";
 
		if (head != null) {
			Node currentHead = head.getNext();
			while (currentHead != null) {
				output += "[" + currentHead.getData().toString() + "]";
				currentHead = currentHead.getNext();
			}
 
		}
		return output;
	}

	//Private
	private static int counter;
	private Node head;
	
	private static int getCounter()
	{
		return counter;
	}

	private static void incrementCounter()
	{
		counter++;
	}

	private void decrementCounter()
	{
		counter--;
	}
	
	//nodes for linked list
	private class Node 
	{
		Node next;
		Object data;

		public Node (Object value) 
		{
			next = null;
			data = value;
		}

		public Node (Object value, Node nextValue)
		{
			next = nextValue;
			data = value;	
		}

		public Object getData()
		{
			return data;
		}

		public void setData(Object value)
		{
			data =	value;
		}

		public Node getNext()
		{
			return next;
		}

		public void setNext(Node nextValue)
		{
			next = nextValue;
		}
	}
}

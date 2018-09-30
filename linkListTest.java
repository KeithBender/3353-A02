/* Keith Bender
 * Assignment 02
 * 3354 Monday 6:30pm
 * Due 10/01/2018
 * Description: This program implements a linkList class an a reverse method. It prints out the linkList as well as its reverse.
 */


public class linkListTest
{
	public static void main(String[] args) 
	{

	}

}

class linkList {
	//Public
	//Default Constructor
	public linkList () {}
	
	public void creatLinkList(List<Integer> integerList)
	{
	
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

	public int size ()
	{
		return getCounter();
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

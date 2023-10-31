import java.util.Comparator;
/**
 * Singly Linked List class 
 * @author alyssalandeta starlynrivas jannubana
 *
 * @param <T>
 */
public class SLL<T extends Comparable<T>> {
	
	public Node<T> start;
	private Node<T> end;
	private int size;
	private Comparator<T> comparator;

	/**
	 * SLL constructor 
	 */
	public SLL() {
		start = null;
		size = 0;
		comparator = null;
	}

	/**
	 * Method to check if the Singly Linked List is empty
	 * @return true if it is empty, false if else
	 */
	public boolean isEmpty() {
		if (start == null)
			return true;
		else
			return false;
	}

	/**
	 * SLL constructor that takes in External Comparator
	 * @param externalComp externam comparator
	 */
	public SLL(Comparator<T> externalComp) {
		start = null;
		comparator = externalComp;
	}

	/**
	 * Method to return the size of the SLL
	 * @return len int that holds the size of the list
	 */
	public int size() {
		Node<T> mover = start;
		int len = 0;
		while(mover != null) {
			len++;
			mover = mover.getNext();
		}
		return len;
	}

	/**
	 * Compare method that adresses if there is no Comparator passed to the constructor.
	 * @param a1
	 * @param a2
	 * @return
	 */
	private int compare(T a1, T a2) {
		if (comparator == null)
			return a1.compareTo(a2);
		else 
			return comparator.compare(a1, a2);
	}

	/**
	 * This method adds the Avenger to the appropriate place in the singly linked list 
	 * depending and compares and sorts the the avengers accordingly
	 * @param n
	 */
	private void addInOrder(Node<T> n) {
		
		if (isEmpty()) {
			addAvengerToStart(n);
		} else {
			if (compare(n.getData(), start.getData()) <= 0)
				addAvengerToStart(n);
			else {
				Node<T> currentAvenger = start;
				while (currentAvenger.getNext() != null && compare(n.getData(), currentAvenger.getNext().getData()) > 0) {
					// n.getData().compareTo(currentAvenger.getNext().getData()) > 0 ignore for now
					currentAvenger = currentAvenger.getNext();
				}
				if (currentAvenger.getNext() == null) {
					addAvengerToEnd(n);
				} else {
					n.setNext(currentAvenger.getNext());
					currentAvenger.setNext(n);
				}

			}
		}
		
	}
	public void addInOrder(T data) {addInOrder(new Node<>(data));}

	/**
	 * This method adds the Avenger node to the start of the list
	 * @param n
	 */
	private void addAvengerToStart(Node<T> n) {
		
		if (isEmpty()) {
			start = n;
			end = n;
		} else {
			n.setNext(start);
			start = n;
		}
		
		
	}
	public void addAvengerToStart(T data) {addAvengerToStart(new Node<>(data));}
	/**
	 * This method adds the Avenger node to the end of the list
	 * @param n
	 */
	private void addAvengerToEnd(Node<T> nodeToAdd) {
		
		if (isEmpty()) {
			addAvengerToStart(nodeToAdd);
		} else {
			end.setNext(nodeToAdd);
			end = nodeToAdd;
		}
	
	}
	public void addAvengerToEnd (T data) {addAvengerToEnd(new Node<>(data));}

	/**
	 * Remove an Avenger node method
	 * @param key
	 * @return
	 */
	private Node<T> deleteAvenger(T key) {
		Node<T> currentAvenger = start;
		Node<T> previousAvenger = start;
		while (currentAvenger != null) {
			if (currentAvenger.getData().equals(key)) {
				if (start == end) {
					start = null;
					end = null;
					return currentAvenger;
				}
				
				if (currentAvenger == start)
					start = currentAvenger.getNext();
				else {
					previousAvenger.setNext(currentAvenger.getNext());
				}
				
				if (currentAvenger == end) {
					end = previousAvenger;
				}
				
				return currentAvenger;
			}
			
			else { 
				previousAvenger = currentAvenger;
				currentAvenger = currentAvenger.getNext();
			}
		}
		
		return null;
		
	}

	/**
	 * Finds the avenger in the SLL by traversing the list
	 * @param avg
	 * @return Avenger being searched for in the list
	 */
	private Node<T> findNode(T data) {
		
		Node<T> currentAvenger = start; // mover node
		while (currentAvenger != null) {
			
			if (currentAvenger.getData().equals(data)) 
			{
				return currentAvenger;
			}
			currentAvenger = currentAvenger.getNext();
		}
		return null;
	}
	public T findAvenger(T data) {
		if(findNode(data) == null)
			return null;
		return findNode(data).getData();
		}

	
	/**
	 * Method used to get a specific node by traversing list 
	 * @param i
	 * @return Node<T> node to be returned
	 */
	private Node<T> get(int i){
		int len = size();
		Node<T> nodeToGet = null;
		
		if(i < len && i >= 0) {
			Node<T> mover = start;
			for(int count = 0; count < i; count++) {
				mover = mover.getNext();
			}
			nodeToGet = mover;
		}
		return nodeToGet;
	}
	
	/**
	 * method used to print the mentionList
	 */
	public void printLinkedList() {
	       Node<T> currentNode = start;
	       while (currentNode != null) 
	       {
	           System.out.println(currentNode.getData());
	           currentNode = currentNode.getNext();
	       }
	}
	
	/**
	 * method used to print only 4 avengers
	 */
	public void printTopFour() {
		Node<T> currentNode = start;
		int count = 0;
		
		while(currentNode != null && count <= 3) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
			count++;
		}
		
	}
}

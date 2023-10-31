import java.util.Comparator;

public class SLL<T extends Comparable<T>> {
	
	public Node<T> start;
	private Node<T> end;
	private int size;
	private Comparator<T> comparator;

	public SLL() {
		start = null;
		size = 0;
		comparator = null;
	}

	public void addAvengerToStart(T data) {
	}

	public void addAvengerToEnd(T data) {
	}

	public void addInOrder(T data) {
	}
	
	public boolean isEmpty() {
		if (start == null)
			return true;
		else
			return false;
	}

	public SLL(Comparator<T> externalComp) {
		start = null;
		comparator = externalComp;
	}

	public int size() {
		Node<T> mover = start;
		int len = 0;
		while(mover != null) {
			len++;
			mover = mover.getNext();
		}
		return len;
	}

	private int compare(T a1, T a2) {
		if (comparator == null)
			return a1.compareTo(a2);
		else 
			return comparator.compare(a1, a2);
	}

	// note: compare method needs to be properly implemented in addInOrder method below:
	public void addInOrder(Node<T> n) {
		
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

	public void addAvengerToStart(Node<T> n) {
		
		if (isEmpty()) {
			start = n;
			end = n;
		} else {
			n.setNext(start);
			start = n;
		}
		
		
	}

	public void addAvengerToEnd(Node<T> n) {
		
		if (isEmpty()) {
			addAvengerToStart(n);
		} else {
			end.setNext(n);
			end = n;
		}
	
	}

	// it kept giving me an error so type changed to Object - idk if thats right, i feel like it def isn't
	public Object deleteAvenger(T key) {
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

	public Node<T> findAvenger(T avg) {
		Node<T> currentAvenger = start;
		while (currentAvenger != null) {
			
			if (currentAvenger.getData().equals(avg)) 
			{
				return currentAvenger;
			}
			currentAvenger = currentAvenger.getNext();

		}
		return null;
	}
	
	public Node<T> get(int i){
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
	
	public void printLinkedList() {
	       Node<T> currentNode = start;
	       while (currentNode != null) 
	       {
	           System.out.println(currentNode.getData());
	           currentNode = currentNode.getNext();
	       }
	}
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

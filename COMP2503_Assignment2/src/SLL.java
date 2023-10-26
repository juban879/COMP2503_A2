import java.util.Comparator;

public class SLL<T extends Comparable<T>> {
	
	private Node<T> start;
	private Node<T> end;
	private int size;
	private Comparator<T> comparator;

	public SLL() {
		start = null;
		size = 0;
		comparator = null;
	}
	
	public boolean isEmpty() {
		if (start == null)
			return true;
		else
			return false;
	}

	public SLL(Comparator<T> externalComp) {
		start = null;
		size = 0;
		comparator = externalComp;
	}

	public int size() {
		return size;
	}

	private int compare(T a1, T a2) {
		if (comparator == null)
			return a1.compareTo(a2);
		else 
			return comparator.compare(a1, a2);
	}

	// note: compare method needs to be properly implemented in addInOrder method below:
	private void addInOrder(Node<T> n) {
		if (isEmpty()) {
			addAvenger(n);
		} else {
			if (n.getData().compareTo(start.getData()) <= 0)
				addAvenger(n);
			else {
				Node<T> currentAvenger = start;
				while (currentAvenger.getNext() != null && n.getData().compareTo(currentAvenger.getNext().getData()) > 0) {
					currentAvenger = currentAvenger.getNext();
				}
				
				if (currentAvenger.getNext() == null) {
					
					
				} else { 
					n.setNext(currentAvenger.getNext());
					currentAvenger.setNext(n);
				}
			}
		}
		
	}
	
	private void addAvenger(Node<T> n) {
		
		
	}
	
	private void deleteAvenger(Node<T> n) {
		
	}

	private void find(Node<T> n) {

	}
}

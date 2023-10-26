
public class SLL<T extends Comparable<T>> {
	
	private Node<T> start;
	private Node<T> end;
	
	public boolean isEmpty() {
		if (start == null)
			return true;
		else
			return false;
	}

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
	
	private void removeAvenger(Node<T> data) {
		
	}
}

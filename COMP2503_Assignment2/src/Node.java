/**
 * This class represents a Node Object for the Singly Linked Lists.
 * @author jannubana
 *
 * @param <T>
 */
class Node<T extends Comparable<T>> {

	private T data;
	private Node<T> next;

	/**
	 * Constructor method for objects of class Node
	 * @param d
	 */
	public Node(T d) {
		data = d;
		next = null;
	}
	/**
	 * Getter method to retrieve Node data
	 * @return data 
	 */
	public T getData() {
		return data;
	}

	/**
	 * Setter method to set object to generic type
	 * @param o
	 */
	public void setData(T o) {
		data = o;
	}

	/**
	 * Getter method to return the next node
	 * @return
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * Setter method to set the pointer of the next
	 * @param n
	 */
	public void setNext(Node<T> n) {
		next = n;
	}

	/**
	 * To String method to print the Node
	 */
	public String toString() {
		return "Node: " + getData().toString();
	}

} // Node
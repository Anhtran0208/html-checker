/**
 * Single node in a linked list. The LinkedListNode
 * has two instance variables, data and next.
 *
 * @author ponbarry
 * @version 21 Feb 2023
 */

public class LinkedListNode<T> {

	/** Variable to hold the data in the node */
	private T data;

	/** Variable to hold the node that comes after this one */
	private LinkedListNode<T> next;

	/**
	 * Constructor; creates an empty node with no data
	 */
	public LinkedListNode() {}


	/**
	 * Constructor; creates a node with data
	 *
	 * @param d the data
	 */
	public LinkedListNode(T d) {
		data = d;
	}

	/**
	 * Returns the data in this node.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Returns the LinkedListNode that is pointed to 
	 * by the 'next' field of this node.
	 * If this node is the last node in the list, the value
	 * of 'next' is null.
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Sets the data in this node.
	 */
	public void setData(T d) {
		data = d;
	}

	/**
	 * Sets the 'next' field in this node.
	 */
	public void setNext(LinkedListNode<T> n) {
		next = n;
	}

	/** 
	 * Returns the result of calling toString on the data 
	 * in this node.
	 */
	public String toString() {
		return data.toString();
	}
}

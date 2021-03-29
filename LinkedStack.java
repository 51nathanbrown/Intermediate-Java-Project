// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, 
// nor will I accept the actions of those who do.
// -- Nathan Brown (bnathan)

package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;
/**
 * Creates LinkedStack object
 * @author Nathan Brown (bnathan)
 * @version 2020.10.20
 * @param <T> object to be stored in stack
 */
public class LinkedStack<T> implements StackInterface<T> {
    private int size;
    private Node<T> topNode;
    /**
     * Instantiates LinkedStack object
     */
    public LinkedStack() {
        this.topNode = null;
        this.size = 0;
    }
    /**
     * returns size of linked stack
     * @return int size
     */
    public int size() {
        return this.size;
    }
    /**
     * returns string representation of linked stack
     * @return String items in linked stack
     */
    public String toString() {
        super.toString();
        Node<T> holder = this.topNode;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (holder != null) {
            result.append(holder.getData().toString() + ", ");
            holder = holder.getNextNode();
        }
        if (this.topNode != null) {
            result.delete(result.length() - 2, result.length()); 
        }
        result.append("]");
        return result.toString();
    }
    @Override
    public void clear() {
        this.topNode = null;
        this.size = 0;
    }
    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }
    @Override
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return this.topNode.getData();
        }
    }
    @Override
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> holder = this.topNode;
        this.topNode = holder.getNextNode();
        size--;
        return holder.getData();
    }
    @Override
    public void push(T entry) {
        Node<T> newTop = new Node<T>(entry, topNode);
        this.topNode = newTop;
        size++;
    }
    /**
     * Creates a Node<T> object
     * @author Nathan Brown (bnathan)
     * @version 2020.10.20
     */
    private class Node<T> {
        private Node<T> next;
        private T data;
        /**
         * instantiates node object
         * @param obj data in node
         * @param node next node
         */
        public Node(T obj, Node<T> node) {
            this.next = node;
            this.data = obj;
        }
        /**
         * returns next node
         * @return Node<T> next node
         */
        public Node<T> getNextNode() {
            return this.next;
        }
        /**
         * returns node data
         * @return T data
         */
        public T getData() {
            return this.data;
        }
    }
}
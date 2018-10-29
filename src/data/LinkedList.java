package data;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Justin Deutsch (djustin8)

/**
 * The data structure that will contain the songs. Each song
 * will be stored as a unique node within the LinkedList.
 *
 * @author Justin Deutsch (djustin8)
 * @version 2018.06.04
 * @param <T>
 *            the data type that will be stored
 *
 */
public class LinkedList<T> {

    /**
     * The inner node class that will store the
     * data passed into it.
     *
     * @param <T>
     *            the type of data being stored
     */
    @SuppressWarnings("hiding")
    private class Node<T> {

        /**
         * The next node in the chain
         */
        private Node<T> next;

        /**
         * The previous node in the chain
         */
        private Node<T> prev;

        /**
         * The data stored within the node
         */
        private T data;


        /**
         * The default constructor when no parameters
         * are given to set the values
         */
        private Node() {
            next = null;
            prev = null;
            data = null;
        }


        /**
         * Creates a new node containing the given data
         * and links the given node as the new node's next
         *
         * @param data
         *            the data to be stored
         */
        private Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }


        /**
         * Links this node with the the given nextNode
         *
         * @param nextNode
         *            the node to link with
         */
        private void linkWith(Node<T> nextNode) {
            this.next = nextNode;
            nextNode.prev = this;
        }


        /**
         * inserts this node after the given current node
         *
         * @param current
         *            the node to be inserted after
         */
        private void insertAfter(Node<T> current) {
            Node<T> nextNode = current.next;
            current.linkWith(this);
            this.linkWith(nextNode);
        }


        /**
         * Removes this node from the list and connects
         * the previous to the next
         *
         */
        private void remove() {
            Node<T> previousNode = this.prev;
            Node<T> nextNode = this.next;
            previousNode.linkWith(nextNode);
        }

    }


    /**
     * The private inner class that will make the LinkedList
     * be iterable so that it can easily be traversed.
     */
    private class ListIterator implements Iterator<T> {
        /**
         * The current node of the iterator
         */
        private Node<T> curr;


        /**
         * Creates a new iterator object
         */
        public ListIterator() {
            curr = head.next;
        }


        /**
         * Checks if there is a next node s
         *
         * @returns true if there is a next node
         */
        @Override
        public boolean hasNext() {
            return curr != tail;
        }


        /**
         * Moves to the next node returning a reference
         * to the node just passed
         *
         * @return the key of the next node
         * @throws NoSuchElementException
         *             if called when no next element exists
         */
        @Override
        public T next() {
            if (this.hasNext()) {
                T data = curr.data;
                curr = curr.next;
                return data;
            }

            throw new NoSuchElementException(
                    "There is no next element to obtain.");
        }


        /**
         * Does not allow items to be removed
         */
        public void remove() {
            throw new UnsupportedOperationException(
                    "Items are not allowed to be removed");

        }

    }

    /**
     * The first Node in the Linked List
     */
    private Node<T> head;

    /**
     * The last node in the Linked List
     */
    private Node<T> tail;

    /**
     * The number of entries in the LinkedList
     */
    private int size;


    /**
     * The default constructor for the LinkedList
     * which initializes the fields to the default
     * values.
     */
    public LinkedList() {
        head = new Node<T>();
        tail = new Node<T>();
        head.linkWith(tail);
        size = 0;
    }


    /**
     * Returns the size of the list
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }


    /**
     * Returns if the list is empty or not
     *
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Adds the given data to the beginning of the Linked List
     * in a new node
     *
     * @param data
     *            the data to be stored
     */
    public void add(T data) {

        if (data == null) {
            throw new IllegalArgumentException("The data passed was null");
        }

        Node<T> newNode = new Node<T>(data);
        newNode.insertAfter(head);
        size++;
    }


    /**
     * Adds the given data after the node containing the given data.
     * If no node contains the data, it is added to the front
     *
     * @precondition nodeBefore cannot be the tail node
     *
     * @param newData
     *            the data to be stored
     * @param dataBefore
     *            the data of the node to place the new
     *            node after
     *
     * @throws IllegalArgumentException
     *             when data or dataBefore are null
     */
    public void addAfter(T newData, T dataBefore) {

        if (newData == null || dataBefore == null) {
            throw new IllegalArgumentException(
                    "The data or dataBefore inputs cannot be null");
        }

        Node<T> nodeBefore = getReferenceTo(dataBefore);

        if (nodeBefore != null) {
            Node<T> newNode = new Node<T>(newData);
            newNode.insertAfter(nodeBefore);
        }
        else {
            add(newData);
            size--;
        }

        size++;
    }


    /**
     * Removes the node first node containing the given data
     * from the Linked List and returns whether the removal was
     * successful
     *
     * @param anEntry
     *            the data to look for and remove
     * @return if the data was removed
     */
    public boolean remove(T anEntry) {

        boolean res = false;
        Node<T> refNode = getReferenceTo(anEntry);

        if (refNode != null) {
            refNode.remove();
            res = true;
            size--;
        }

        return res;

    }


    /**
     * Returns true if this list contains the specified key.
     *
     * @param anEntry
     *            an entry whose presence in this list is to be tested
     * @return true if this list contains the specified key
     */
    public boolean contains(T anEntry) {
        for (Node<T> curr = head.next; curr != tail; curr = curr.next) {
            if (curr.data.equals(anEntry)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Returns a string representation of this linked-list displaying the key.
     * The list's string representation is written as a comma-separated list of
     * its contents (in front-to-rear order) surrounded by square brackets, like
     * this:
     *
     * [52, 14, 12, 119, 73, 80, 35]
     *
     * An empty linked-list is simply [].
     *
     * @return a string representation of the linked-list's keys
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<T> i = iterator();
        builder.append("[");
        while (i.hasNext()) {
            builder.append(i.next());
            builder.append(i.hasNext() ? ", " : "");
        }
        builder.append("]");
        return builder.toString();
    }


    /**
     * Determines if two LinkedLists are equal. They are
     * equal when their toString methods produce the same
     * results.
     *
     * @param   obj the object to check against
     * @return  if they are equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (obj.getClass() == this.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = (LinkedList<T>)obj;
            return this.toString().equals(other.toString());
        }
        else {
            return false;
        }
    }


    /**
     * Returns a reference to the first node containing
     * the given entry as its data. If no node contains
     * the given entry, then null is returned.
     *
     * @param anEntry
     *            the entry to acquire a reference to
     * @return the reference to the node or null
     */
    private Node<T> getReferenceTo(T anEntry) {

        Node<T> ref = null;
        Node<T> curr = head.next;
        boolean notFound = true;

        while (curr != tail) {
            if (notFound && curr.data.equals(anEntry)) {
                ref = curr;
                notFound = false;
            }

            curr = curr.next;
        }
        return ref;

    }


    /**
     * Creates a ListIterator
     *
     * @return an iterator
     */
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    /**
     * Sorts the list using an insertion sort technique
     * using the given comparator to determine the order
     * the nodes should be moved in.
     *
     * @param comparator
     *            the comparator to use to sort
     */
    public void sort(Comparator<T> comparator) {
        Node<T> unsortedPart = head.next.next;
        // head.next.next = null <- causing NPE when supposed to add to end
        // b/c tail deleted
        head.next.linkWith(tail);
        unsortedPart.prev = null;

        while (unsortedPart.data != null) {
            Node<T> nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.next;

            insertInOrder(nodeToInsert, comparator);

        }

    }


    /**
     * Inserts a given node based on how it should be compared
     *
     * @param nodeToInsert
     *            the node that is inserted
     * @param comparator
     *            the type of comparison
     */
    private void insertInOrder(Node<T> nodeToInsert, Comparator<T> comparator) {
        T item = nodeToInsert.data;
        Node<T> currentNode = head.next;

        while (currentNode != tail && comparator.compare(item,
                currentNode.data) > 0) {
            currentNode = currentNode.next;
        }

        nodeToInsert.insertAfter(currentNode.prev);

    }


    /**
     * Writes the list to an array
     *
     * @return the generic array of songs starting at index 0
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] ret = (T[])new Object[size];
        Iterator iter = iterator();
        for (int i = 0; i < size; i++) {
            ret[i] = (T)iter.next();
        }
        return ret;
    }
}
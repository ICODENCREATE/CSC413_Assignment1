package linkedlistwithiterator;

import java.util.*;

/**
 *
 * @author sarvesh
 */
public class MyLList<E> implements ListInterface<E> {

    private ListNode headNode; // reference to first node of the list
    private int numberOfEntries; // number of entries in list

    // constructor
    public MyLList() {
        clear();
    } // end default constructor

    // clear list. Set firstNode to NULL
    public final void clear() {

        headNode = null;
        numberOfEntries = 0;
    } // end clear

    public boolean isEmpty() {

        return (headNode == null);

    } // end isEmpty

    public int getLength() {
        return numberOfEntries;
    }

    public boolean contains(E anEntry) {

        ListNode fn = headNode;

        if (fn == null)
            return false;
        else if (fn.getData().equals(anEntry))
            return true;
        else {
            do {
                fn = fn.next;
                if (anEntry.equals(fn.getData()))
                    return true;
            } while (fn.next != null);
        }
        return false;
    }

    public void printAll() {

        E[] arr = this.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public E[] toArray() {

        if (headNode == null)
            return null;

        E[] arr = (E[]) new Comparable[numberOfEntries];

        int count = 0;
        ListNode currentNode = headNode;

        // Traverse from head
        while (currentNode != null) {
            arr[count] = currentNode.getData();
            count++;
            currentNode = currentNode.next;
        }
        return arr;

    }

    /*
     * 1 based index 
     */
    private ListNode getNodeAt(int givenPosition) {

        // use temporary node currentNode to traverse
        // list starting at firstNode
        ListNode currentNode = headNode;
        // traverse the list to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.next;
        }

        // currentNode now refers to node at givenPosition
        return currentNode;
    }

    /*
     * 0 based index
     */
    public E getEntry(int i) {

        E[] arr = this.toArray();

        E element = null;
        if ((i > 0) && (i <= arr.length)) {
            element = (E) arr[i - 1];
        }

        return element;

    }

    public E replace(int position, E anEntry) {

        if (!((position >= 1) && (position <= numberOfEntries))) {
            return null;
        } else {

            ListNode theNode = this.getNodeAt(position - 1);
            theNode.setData(anEntry);
        }

        return anEntry;

    }

    public E remove(int position) {

        E result = null; // return value

        if ((position >= 1) && (position <= numberOfEntries)) {
            if (position == 1) { // case 1: first node, remove first entry
                result = headNode.data; // save entry to be removed
                headNode = headNode.next;
            } else { // case 2: not first node
                ListNode nodeBefore = getNodeAt(position - 1);
                ListNode nodeToRemove = nodeBefore.next;
                ListNode nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter; // disconnect the node to be removed
                result = nodeToRemove.getData(); // save entry to be removed
            }

            numberOfEntries--;

        } else {

            System.out.println(position + ": is out of range of the list with size: " + numberOfEntries);

        }

        return result;
    }

    /**
     * append an existing entry to the tail
     * @param anEntry The object to be added as a new entry.
     */
    public void add(E anEntry) {

        // get new node to hold newEntry
        ListNode newNode = new ListNode(anEntry);

        // adding to empty list
        if (isEmpty()) {
            headNode = newNode;
        } else {
            ListNode lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode; // make last node reference new node
        }
        numberOfEntries++;
    }

    public boolean add(int insertPosition, E anEntry) {

        ListNode nodeBefore, nodeAfter;

        boolean isSuccessful = true;
        if ((insertPosition >= 1) && (insertPosition <= numberOfEntries + 1)) {
            // get new node to hold newEntry
            ListNode newNode = new ListNode(anEntry);
            if (isEmpty() || (insertPosition == 1)) { // empty or 1st position
                newNode.next = headNode;
                headNode = newNode;
            } else {// not empty and newPosition > 1
                nodeBefore = getNodeAt(insertPosition - 1);

                // if insert point was after last node
                if (nodeBefore.next == null) {
                    nodeBefore.next = newNode;
                    newNode.next = null;
                    // if insert point was somewhere in the middle of the list//
                } else {
                    nodeAfter = nodeBefore.next;
                    newNode.next = nodeAfter;
                    nodeBefore.next = newNode;
                }
            } // end if

            numberOfEntries++;
        } else
            isSuccessful = false;

        return isSuccessful;
    }

    public void printLinkedList() {

        int nodeCount = 1;
        ListNode currentNode = headNode;
        E data = (E) currentNode.getData();

        System.out.println("Node[1]: " + data);

        while ((currentNode.getNextNode() != null)) {

            currentNode = currentNode.getNextNode();
            data = (E) currentNode.getData();
            System.out.println("Node[" + (++nodeCount) + "]: " + data);

        }
    }

    /**
     *
     * @author kmehta
     */
    public class ListNode {

        public E data; // entry in queue
        public ListNode next; // link to next node

        public ListNode(E anEntry) {
            this(anEntry, null);
        }

        public ListNode(E anEntry, ListNode n) {
            this.data = anEntry;
            this.next = n;
        }

        public E getData() {
            return data;
        }

        public ListNode getNextNode() {
            return this.next;
        }

        public void setNextNode(ListNode anEntry) {
            this.next = anEntry;
        }

        public void setData(E anEntry) {
            this.data = anEntry;
        }

    } // end QueueNode

}// end MyLList

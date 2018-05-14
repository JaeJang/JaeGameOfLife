package ca.bcit.comp2526.a2c;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<E> implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 2823907356661788391L;
    E data;
    Node<E> next;
    Node<E> pre;

    public Node(E data) {
        this.data = data;
    }
}

class Element {
    int data;

    public Element(int data) {
        this.data = data;
    }
}

public class DoubleLinkedList<E> implements Iterable<E>, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -2266373848549176826L;
    private Node<E> head;
    private Node<E> tail;
    private int length;

    

    public void addToFront(E e) throws CouldNotAddException {
        Node<E> temp = new Node<E>(e);
        
        if(temp.data == null) {
            throw new CouldNotAddException();
        }
        if (head == null) {
            head = tail = temp;
            length++;
        } else {
            head.pre = temp;
            temp.next = head;
            head = temp;
            length++;
        }
    }

    public E removeFromFront() throws CouldNotRemoveException {

        if (head == null) {
            throw new CouldNotRemoveException();
        }
        Node<E> removedNode = null;
        if ((--length) == 0) {
            removedNode = head;
            head = tail = null;
            return removedNode.data;
        }
        removedNode = head;
        head = head.next;
        /*if(head.pre != null) {
            head.pre = null;
        }
        if(length == 1) {
            head = tail;
        }*/
        return removedNode.data;

    }

    public void addToEnd(E e) throws CouldNotAddException {
        Node<E> temp = new Node<E>(e);
        if(temp.data == null) {
            throw new CouldNotAddException();
        }
        if (head == null) {
            head = tail = temp;
            length++;
        } else {
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
            length++;
        }
    }

    public E removeFromEnd() throws CouldNotRemoveException {

        if (head == null) {
            throw new CouldNotRemoveException();
        }
        Node<E> removedNode = null;

        if ((--length) == 0) {
            removedNode = tail;
            head = tail = null;
            return removedNode.data;
        }
        removedNode = tail;
        tail = tail.pre;
        /*if (tail.next != null) {
            tail.next = null;
        }*/

        /*if (length == 1) {
            head = tail;
        }*/
        return removedNode.data;

    }

    public E get(int index) {
        Node<E> temp = head;

        for (int i = 0; temp != null; i++) {
            if (i == index) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    public int size() {
        return length;
    }

    public E getFirst() {
        return head == null ? null : head.data;
    }

    public E getLast() {
        return tail == null ? null : tail.data;
    }

    public Iterator<E> iterator() throws NoSuchElementException {

        return new Iterator<E>() {
            int index;

            @Override
            public boolean hasNext() {

                return index < length;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return get(index++);
                }
                else {
                    throw new NoSuchElementException();
                }
            }

        };

    }

}

package no.kristiania.MyLinkedList;

public class MyLinkedList <T> implements MyList<T>{

    private class ListNode {
        T value;
        ListNode next;
    }

    private ListNode head;

    private ListNode tail;

    private int size;
//------------------------------------------------
    @Override
    public void delete(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
                tail = null;
            }
        } else {
            ListNode current = head;
            int counter = 0;
            while(counter != index -1) {
                current = current.next; //next element
                counter++;
            }
            if(current.next == tail) {
                tail = current;
            }

            current.next = current.next.next;

        }
        size++;
    }

    //------------------------------------------------
    @Override
    public T get (int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        ListNode current = head;
        int counter = 0;

        while (current != null) {
            if(counter == index) {
                return current.value;
            }
            current = current.next;
            counter++;
        }
        assert false;
        return null;
    }

    //------------------------------------------------
    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode node = new ListNode();
        node.value = value;

        if(head == null) {
            //add on empty list
            assert size == 0;
            head = node;
            tail = node;
        } else if (index == 0) {
            node.next = head;
            head = node;
        } else if(index == size) {
            //Add at the end of non-empty list.
            tail.next = node;
            tail = node;
        } else {
            //insertion in the middle of the list
            int counter = index-1;
            ListNode previous = head;

            while(counter > 0) {
                previous = previous.next;
                counter--;
            }

            node.next = previous.next;
            previous.next = node;
        }
        size++;
    }
    //------------------------------------------------

     @Override
    public int size() {
        return size;
    }
}

package linkedlist;

class DListNode {
    int val;
    DListNode next;
    DListNode prev;

    DListNode(int x) {
        val = x;
    }
}

public class DesignDoublyLinkedList {
    int size;
    DListNode head, tail;

    public DesignDoublyLinkedList() {
        size = 0;
        head = new DListNode(0);
        tail = new DListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public void addAtHead(int val) {
        DListNode pred = head, succ = head.next;

        ++size;
        DListNode newNode = new DListNode(val);
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;
    }

    public void addAtTail(int val) {
        DListNode succ = tail, pred = tail.prev;
        ++size;
        DListNode newNode = new DListNode(val);
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;

    }

    public void addAtIndex(int index, int val) {
        if (index < 0)
            index = 0;
        if (index > size)
            return;

        DListNode newNode = new DListNode(val);
        DListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++)
                pred = pred.next;
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++)
                succ = succ.prev;
            pred = succ.prev;

        }
        ++size;
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        DListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++)
                pred = pred.next;
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++)
                succ = succ.prev;
            pred = succ.prev.prev;
        }

        --size;
        pred.next = succ;
        succ.prev = pred;

    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        DListNode curr = head;
        if (index + 1 < size - index)
            for (int i = 0; i < index + 1; ++i)
                curr = curr.next;
        else {
            curr = tail;
            for (int i = 0; i < size - index; ++i)
                curr = curr.prev;
        }
        return curr.val;
    }
}
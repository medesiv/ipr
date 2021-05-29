package linkedlist;

/**
 * This class does crud operations in a singly linked list
 */

class SingleLinkedList {
    int size;
    ListNode head;

    SingleLinkedList() {
        size = 0;
        // sentinel node
        head = new ListNode(0);
    }

    public ListNode get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);

    }

    public void addAtIndex(int index, int val) {
        if (index < 0)
            index = 0;
        if (index > size)
            return;
        ++size;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = pred.next;
        pred.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if (index > size || index < 0)
            return;
        --size;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
    public void print(){
        for(ListNode temp =head.next;temp!=null;temp=temp.next){
            System.out.print(temp.val+"->");
        }
        System.out.println("null");
    }
}

class Solution {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        l1.next = l2;

        SingleLinkedList sll = new SingleLinkedList();
        sll.addAtHead(4);
        sll.addAtTail(7);
        sll.addAtHead(3);
        sll.addAtIndex(1, 5);
        sll.deleteAtIndex(1);
        System.out.println(sll.get(1).val);

        DesignDoublyLinkedList dll = new DesignDoublyLinkedList();
        dll.addAtHead(4);
        dll.addAtTail(7);
        dll.addAtHead(3);
        dll.addAtIndex(1, 5);
        dll.deleteAtIndex(1);
        System.out.println(dll.get(1));
    }

}
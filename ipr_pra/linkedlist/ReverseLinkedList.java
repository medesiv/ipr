package linkedlist;

public class ReverseLinkedList {

    static ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public static void main(String[] args){
        SingleLinkedList ll = new SingleLinkedList();
        ll.addAtHead(4);
        ll.addAtIndex(1,20);
        ll.addAtIndex(2,5);
        ll.addAtIndex(3,99);
        ll.print();
        //System.out.println(""+ll.get(0).val);
        ListNode newHead = reverseList(ll.get(0));
        for(ListNode temp = newHead;temp!=null;temp=temp.next){
            System.out.print(temp.val+"->");
        }
        System.out.println("null");
    }
}

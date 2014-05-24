public class ListUtil {
    /**
     * Returns the number of elements in a list.
     * @param head The head pointer of the list
     * @return The number of elements in the list.
     */
    public static int length(ListNode head) {
        int count = 0;
        ListNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Build a list in decreasing order.
     * @param length The length of the linked list.
     * @return The head reference of the list.
     */
    public static ListNode buildHead(int length) {
        ListNode head = null;

        for (int i = 0; i < length; i++) {
            ListNode node = new ListNode(i);
            node.next = head;
            head = node;
        }

        return head;
    }

    /**
     * Build a list in increasing order.
     * @param length The length of the linked list.
     * @return The head reference of the list.
     */
    public static ListNode buildTail(int length) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int i = 0; i < length; i++) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}

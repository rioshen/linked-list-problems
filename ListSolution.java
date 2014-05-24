class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class ListSolution {
    /**
     * Counts the number of times a given value occurs in the list.
     * @param head The head node of the linked list.
     * @param target A given value in a list.
     * @return 0 if the target doesn't exist else return its index.
     */
    public static int count(ListNode head, int target) {
        int count = 0;

        if (head == null) {
            return count;
        }

        ListNode current = head;
        while (current != null) {
            if (current.value == target) count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Returns the data stored in the node at the index position.
     * The index uses the C numbering convention that starts from 0.
     * @param head The head node of the linked list.
     * @param index The index position
     * @return the value stored in the node.
     */
    public static int getNth(ListNode head, int index) {
        if (head == null) {
            throw new IllegalArgumentException("Empty list.");
        }

        int count = 0;
        ListNode current = head;
        while (count < index && current != null) {
            count++;
            current = current.next;
        }

        if (current == null) { //special case, the index is invalid.
            throw new IndexOutOfBoundsException();
        } else {
            return current.value;
        }
    }

    /**
     * Note: Java uses pass-by-value, like a constant reference in c++, you can only modify the
     * content of the reference, but cannot change the reference.
     * Deletes the first node of a given list, and returns its value.
     * @param head The head node of the linked list.
     * @return the value of head node.
     */
    public static int pop(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("Empty list.");
        }

        /* Not finish yet */

        return head.value;
    }

    /**
     * Inserts a new node at any index within a list. The legal index should be in the range [0..length]
     * @param head The head node of the linked list.
     * @param n The index position
     * @param value the new value.
     * @return The new list.
     */
    public static ListNode insertNth(ListNode head, int n, int value) {
        if (head == null) {
            throw new IllegalArgumentException("Empty list.");
        }

        ListNode node = new ListNode(value);
        if (n == 0) { //special case, insert at the head
            node.next = head;
            return node;
        }

        int count = 0;
        ListNode current = head;
        while (current != null && count < n - 1) {
            count++;
            current = current.next;
        }
        if (current == null) { // given position is greater than the list.
            throw new IllegalArgumentException("Invalid position.");
        }
        node.next = current.next;
        current.next = node;

        return head;
    }


    /**
     * Inserts the node into the correct sorted position in the list.
     * @param head The head node of the linked list.
     * @param value target value
     * @return new sorted list
     */
    public static ListNode sortedInsert(ListNode head, int value) {
        ListNode node = new ListNode(value);

        if (head == null || value <= head.value) {
            node.next = head;
            return node;
        }

        ListNode current = head;
        while (current.next != null && current.next.value < value) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;

        return head;
    }

    public static ListNode sortedInsertDummy(ListNode head, int value) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        dummy.next = head;
        while (current.next != null && current.next.value < value) {
            current = current.next;
        }

        ListNode node = new ListNode(value);
        node.next = current.next;
        current.next = node;

        return dummy.next;
    }

    /**
     * Appends the second list onto the end of the first list.
     * @param a
     * @param b
     * @return
     */
    public static ListNode append(ListNode a, ListNode b) {
        if (a == null) { //special case if a is empty
            return b;
        }

        /* Iterate down the 'a' list until we find its last node. */
        ListNode current = a;
        while (current.next != null) {
            current = current.next;
        }
        current.next = b;

        return a;
    }

    public static void removeDuplicates(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next.next;
            if (current.value == current.next.value) {
                current.next = next;
            } else {
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildTail(3);
        head = sortedInsertDummy(head, 3);
        ListUtil.printList(head);
    }
}
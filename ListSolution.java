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
     *
     * @param head The head node of the linked list.
     * @param target
     * @return
     */
    public static int count(ListNode head, int target) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            if (current.value == target) count++;
            current = current.next;
        }
        return count;
    }

    public static int getNth(ListNode head, int index) {
        if (head == null) {
            return -1;
        }
        int count = 0;
        ListNode current = head;
        while (count < index && current != null) {
            count++;
            current = current.next;
        }
        return current == null ? -1 : current.value;
    }

    public static ListNode insertNth(ListNode head, int n, int value) {
        if (head == null) {
            return null;
        }

        if (n == 0) { // index 0 is a special case.
            ListNode node = new ListNode(value);
            node.next = head;
            return node;
        }

        int count = 0;
        ListNode current = head;
        while (count < n && current != null) {
            count++;
            current = current.next;
        }
        if (current == null) {
            return null;
        }

        ListNode node = new ListNode(value);
        node.next = current.next;
        current.next = node;

        return head;
    }

    public static ListNode sortedInsert(ListNode head, int value) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        while (current.value < value && current.next != null) {
            current = current.next;
        }
        if (current.next == null) {
            current.next = new ListNode(value);
        } else {
            ListNode node = new ListNode(value);
            node.next = current.next;
            current.next = node.next;
        }

        return head;
    }

    public static ListNode append(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

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

    /**
     * Build a linked list in ascend order.
     */
    private static ListNode build(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = append(build(3), build(3));
        removeDuplicates(a);
        ListUtil.printList(a);
    }
}

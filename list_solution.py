#!/usr/bin/env python

__author__ = 'Rio'


class ListNode:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next


def length(head):
    """
    Returns the number of elements in a list.
    """
    count, current = 0, head
    while current:
        count += 1
        current = current.next
    return count


def build_head(num):
    """
    Builds a linked list, so the whole list will be in reversed order.
    """
    current = None
    for i in range(num):
        node = ListNode(i)
        node.next = current
        current = node
    return current


def build_tail(num):
    """
    Builds a linked list and returns the head.
    """
    dummy = ListNode(-1)
    current = dummy
    for i in range(num):
        node = ListNode(i)
        current.next = node
        current = node
    return dummy.next


def print_list(head):
    """
    Iterate over a list from head and print.
    """
    current = head
    while current:
        print current.value, " ",
        current = current.next
    print


def count(head, target):
    """
    Calculates number of times of target occurs in the list.
    """
    count, current = 0, head
    while current:
        if current.value == target: count += 1
        current = current.next
    return count


def get_nth(head, n):
    """
    Returns the data stored in the node at the index n position.
    """
    if head is None: raise Exception

    count, current = 0, head
    while current and count < n:
        count += 1
        current = current.next

    if current is None: raise Exception

    return current.value


def insert_nth(head, n, value):
    """
    Insert a new node at n index within a list. The new node should be
    inserted so as to be at that index.
    """
    if head is None: raise Exception

    node = ListNode(value)
    if n == 0:
        node.next = head
        return node

    count, current = 0, head
    while current and count < n - 1:
        count += 1
        current = current.next
    if current is None: raise Exception

    node.next = current.next
    current.next = node
    return head


def sorted_insert(head, target):
    """
    Inserts the node into the correct sorted position in the list.
    """
    dummy = ListNode(-1)
    current = dummy
    dummy.next = head

    while current.next is not None and current.next.value < target:
        current = current.next

    node = ListNode(target)
    node.next = current.next
    current.next = node

    return dummy.next


def append(a, b):
    """
    Appends list b onto the end of list a.
    """
    if a is None: return b

    current = a
    while current.next is not None:
        current = current.next
    current.next = b

    return a


def test():
    head = build_tail(5)
    print_list(head)
    head = insert_nth(head, 1, 10)
    print_list(head)


if __name__ == '__main__': test()
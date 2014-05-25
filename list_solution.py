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


def test():
    head = build_head(5)
    print_list(head)
    head = build_tail(5)
    print_list(head)
    print count(head, 0)


if __name__ == '__main__': test()
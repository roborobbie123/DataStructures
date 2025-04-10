public class DoublyLinkedList {
    Node head;
    Node tail;
    int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }
    public int getLength() {
        return length;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > length - 1) {
            return null;
        }
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.next = after;
        after.prev = newNode;
        before.next = newNode;
        newNode.prev = before;

        length++;
        return true;
    }
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node target = get(index);
        Node before = target.prev;
        Node after = target.next;
        before.next = after;
        after.prev = before;
        target.prev = null;
        target.next = null;
        length--;
        return target;
    }

    public void swapFirstLast() {
        if (length > 1) {
            int first = head.value;
            int last = tail.value;
            head.value = last;
            tail.value = first;
        }
    }

    public void reverse() {
        if (length > 1) {
            Node prev = null;
            Node current = head;

            while (current != null) {
                prev = current.prev;
                current.prev = current.next;
                current.next = prev;
                current = current.prev;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }
    }

    public boolean palindromeChecker() {
        if (length == 0) return false;
        if (length == 1) return true;
        Node first = head;
        Node last = tail;
        for (int i = 0; i < length / 2; i++) {
            if (first.value != last.value) return false;
            first = first.next;
            last = last.prev;
        }
        return true;
    }
}

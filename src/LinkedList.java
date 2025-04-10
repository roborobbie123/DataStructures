import java.util.HashSet;

public class LinkedList {
    Node head;
    Node tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public static class Node {
        int value;
        Node next;

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
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }
        Node target = tail;
        while (temp.next != target) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        length--;

        return target;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }
        Node first = head;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return first;
        }
        head = first.next;
        first.next = null;
        length--;
        return first;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        int counter = 0;
        Node temp = head;
        while (counter < index) {
            temp = temp.next;
            counter++;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp == null) {
            return false;
        } else {
            temp.value = value;
            return true;
        }
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        Node temp = get(index);
        if (temp == null) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node pre = get(index - 1);
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        if (length == 0) {
            return;
        }

        Node temp = head;
        head = tail;
        tail = temp;

        Node after = tail.next;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        if (length == 0) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k) {
        if (k < 0 || k > length) return null;
        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
                length--;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        Node temp = head;
        int decimal = 0;

        while (temp != null) {
            decimal = decimal * 2 + temp.value;
            temp = temp.next;
        }
        return decimal;
    }

}

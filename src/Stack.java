public class Stack {
   Node top;
   int height;

   public Stack(int value) {
       top = new Node(value);
       height = 1;
   }

   public static class Node {
       int value;
       Node next;

       public Node(int value) {
           this.value = value;
       }
   }

   public Node getTop() {
       return top;
   }
   public int getHeight() {
       return height;
   }
   public void printStack() {
       Node temp = top;
       while (temp != null) {
           System.out.println(temp.value);
           temp = temp.next;
       }
   }

   public void makeEmpty() {
       top = null;
       height = 0;
   }

   public void push(int value) {
       Node newNode = new Node(value);
       if (height == 0) {
           top = newNode;
       } else {
           newNode.next = top;
           top = newNode;
       }
       height++;
   }

   public Node pop() {
       if (height == 0) {
           return null;
       }
       Node temp = top;
       if (height == 1) {
           top = null;
       } else {
           top = top.next;
           temp.next = null;
       }
       height--;
       return temp;
   }






}

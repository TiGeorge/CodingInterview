package problem_2_5;

import datastructures.lists.MyLinkedList;
import datastructures.lists.Node;


public class Sollution {

    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();
        a.add(7);
        a.add(1);
        a.add(6);
        //a.add(6);
        MyLinkedList<Integer> b = new MyLinkedList<>();
        b.add(5);
        b.add(9);
        b.add(2);

        MyLinkedList<Integer> c = sumLinkedList(a, b);

        System.out.println(c);
    }

    public static MyLinkedList<Integer> sumLinkedList(MyLinkedList<Integer> a, MyLinkedList<Integer> b) {
        MyLinkedList<Integer> result = new MyLinkedList<>();
        result.first = (sumNodes(a.first, b.first, 0));
        return result;
    }

    private static Node<Integer> sumNodes(Node<Integer> a, Node<Integer> b, Integer carry) {

        if (a == null && b == null && carry == 0) return null;

        int sum = carry;

        Node<Integer> nextA = null;
        if (a != null) {
            nextA = a.next;
            sum += a.value;
        }

        Node<Integer> nextB = null;
        if (b != null) {
            nextB = b.next;
            sum += b.value;
        }

        return new Node<>(sum % 10, sumNodes(nextA, nextB, sum / 10));
    }

}


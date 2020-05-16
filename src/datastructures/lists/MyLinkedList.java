package datastructures.lists;

public class MyLinkedList<E> {

    public Node<E> first;

    public void add(E e) {
        first = new Node<>(e, first);
    }

    public E remove() {
        if (first == null) return null;
        E result = first.value;
        first = first.next;
        return result;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[ ");
        Node<E> node = first;
        if (node != null) {
            while (node != null) {
                sb.append(node.value).append(", ");
                node = node.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}


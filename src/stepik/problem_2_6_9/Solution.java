package stepik.problem_2_6_9;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        NodeImpl root = new NodeImpl("0");
        root.left = new NodeImpl("1");
        root.right = new NodeImpl("2");
        root.left.left = new NodeImpl("3");
        root.left.right = new NodeImpl("4");

        TreeIterator treeIterator = new TreeIterator(root);
        while (treeIterator.hasNext()) {
            System.out.println(((NodeImpl) (treeIterator.next())).name);
        }

    }

}

class TreeIterator implements Iterator<Node> {
    private final Node root;
    private final LinkedList<NodeImpl> stack = new LinkedList<>();

    public TreeIterator(Node root) {
        this.root = root;
        stack.push((NodeImpl) root);
    }

    @Override
    public boolean hasNext() {
        // enter your code
        NodeImpl peek = stack.peek();
        if (peek == null) {
            return false;
        }

        if (stack.size() > 1) {
            return true;
        }

        boolean goLeft = !peek.isLeftDone && peek.getLeft() != null;
        boolean goRight = !peek.isRightDone && peek.getRight() != null;
        return goLeft || goRight;
    }

    @Override
    public Node next() {
        // enter your code
        NodeImpl current = stack.peek();

        if (current == null) {
            return null;
        }


        if (!current.isLeftDone && current.getLeft() != null) {
            current.isLeftDone = true;
            NodeImpl left = (NodeImpl) current.getLeft();
            stack.push(left);
            left.isDone = true;
            return left;

        } else if (!current.isRightDone && current.getRight() != null) {
            current.isRightDone = true;
            NodeImpl right = (NodeImpl) current.getRight();
            stack.push(right);
            right.isDone = true;
            return right;
        } else {
            current = stack.pop();

        }
        current.isDone = true;
        return current;
    }
}

class NodeImpl implements Node {
    NodeImpl left;
    NodeImpl right;
    boolean isDone;
    boolean isLeftDone;
    boolean isRightDone;
    String name;

    public NodeImpl(String name) {
        this.name = name;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }
}

interface Node {
    Node getLeft();

    Node getRight();
}
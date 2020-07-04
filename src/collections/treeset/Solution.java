package collections.treeset;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {

    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>(Comparator.comparing(String::length));

        Set<String> syncTreeSet = Collections.synchronizedSet(treeSet);


    }

    @Test
    public void whenAddingElement_shouldAddElement() {
        Set<String> treeSet = new TreeSet<>();

        assertTrue(treeSet.add("String Added"));
    }
}

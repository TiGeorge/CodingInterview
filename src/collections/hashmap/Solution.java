package collections.hashmap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class Solution {

    @Test
    public void whenHashCodeIsCalledOnPut__thenCorrect() {
        MyKey key = new MyKey(1);
        Map<MyKey, String> map = new HashMap<>();
        map.put(key, "val");
    }

    @Test
    public void givenNullKeyAndVal__whenAccepts__thenCorrect(){
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
    }

    @Test
    public void givenExistingKey__whenPutReturnsPrevValue__thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "val1");

        String rtnVal = map.put("key1", "val2");

        assertEquals("val1", rtnVal);
    }

    @Test
    public void givenNewKey__whenPutReturnsNull__thenCorrect() {
        Map<String, String> map = new HashMap<>();

        String rtnVal = map.put("key1", "val1");

        assertNull(rtnVal);
    }

    @Test
    public void givenNullVal__whenPutReturnsNull__thenCorrect() {
        Map<String, String> map = new HashMap<>();

        String rtnVal = map.put("key1", null);

        assertNull(rtnVal);
    }

    @Test
    public void whenGetWorks__thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "val");

        String val = map.get("key");

        assertEquals("val", val);
    }

    @Test
    public void whenHashCodeIsCalledOnGet__thenCorrect() {
        MyKey key = new MyKey(1);
        Map<MyKey, String> map = new HashMap<>();
        map.put(key, "val");
        map.get(key);
    }

    @Test
    public void givenHashMap__whenRetrievesKeyset__thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<String> keys = map.keySet();

        assertEquals(2, keys.size());
        assertTrue(keys.contains("name"));
        assertTrue(keys.contains("type"));
    }

    @Test
    public void givenKeySet__whenChangeReflectsInMap__thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        assertEquals(2, map.size());

        Set<String> keys = map.keySet();
        keys.remove("name");

        assertEquals(1, map.size());
    }

    @Test
    public void givenHashMap__whenRetrievesValues__thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Collection<String> values = map.values();

        assertEquals(2, values.size());
        assertTrue(values.contains("baeldung"));
        assertTrue(values.contains("blog"));
    }

    @Test
    public void givenHashMap_whenRetrievesEntries_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        assertEquals(2, entries.size());
        for (Map.Entry<String, String> e : entries) {
            String key = e.getKey();
            String val = e.getValue();
            assertTrue(key.equals("name") || key.equals("type"));
            assertTrue(val.equals("baeldung") || val.equals("blog"));
        }
    }

    @Test
    public void givenIterator_whenFailsFastOnModification_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        map.remove("type");
        while (it.hasNext()) {
            String key = it.next();
        }
    }

    @Test
    public void givenIterator_whenRemoveWorks_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "baeldung");
        map.put("type", "blog");

        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            it.next();
            it.remove();
        }

        assertEquals(0, map.size());
    }

    @Test
    public void whenCallsEqualsOnCollision_thenCorrect() {
        HashMap<MyKey, String> map = new HashMap<>();
        MyKey k1 = new MyKey(1, "firstKey");
        MyKey k2 = new MyKey(2, "secondKey");
        MyKey k3 = new MyKey(2, "thirdKey");

        System.out.println("storing value for k1");
        map.put(k1, "firstValue");
        System.out.println("storing value for k2");
        map.put(k2, "secondValue");
        System.out.println("storing value for k3");
        map.put(k3, "thirdValue");

        System.out.println("retrieving value for k1");
        String v1 = map.get(k1);
        System.out.println("retrieving value for k2");
        String v2 = map.get(k2);
        System.out.println("retrieving value for k3");
        String v3 = map.get(k3);

        assertEquals("firstValue", v1);
        assertEquals("secondValue", v2);
        assertEquals("thirdValue", v3);
    }
}

class MyKey {
    private String name;
    private int id;

    public MyKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyKey(int id) {
        this.id = id;
    }

    // standard getters and setters

    @Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return id;
    }

    // toString override for pretty logging
    @Override
    public boolean equals(Object o) {

        System.out.println("Calling equals() for key: " + o);

        if (this == o) return true;
        if (!(o instanceof MyKey)) return false;

        MyKey myKey = (MyKey) o;

        if (id != myKey.id) return false;
        return name != null ? name.equals(myKey.name) : myKey.name == null;
    }

    @Override
    public String toString() {
        return "MyKey{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}


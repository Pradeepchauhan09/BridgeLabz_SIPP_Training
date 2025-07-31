import java.util.*;

class CustomHashMap<K, V> {
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;
    private List<Node<K, V>> buckets;

    CustomHashMap() {
        buckets = new ArrayList<>(Collections.nCopies(SIZE, null));
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = buckets.get(index);
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        buckets.set(index, newNode);
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> head = buckets.get(index);
        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }
}

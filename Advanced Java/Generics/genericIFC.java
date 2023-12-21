public interface Pair<K, V> {
    K getKey();
    V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        OrderedPair<String, Integer> orderedPair = new OrderedPair<>("One", 1);
        System.out.println("Key: " + orderedPair.getKey() + ", Value: " + orderedPair.getValue());
    }
}

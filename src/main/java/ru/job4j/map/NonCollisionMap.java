package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        } else {
            return false;
        }
    }

    private int hash(int hashCode) {
        int hash = 65536;
        return hashCode == hash ? hashCode + 1 : hashCode % hash;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        int newCapacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[newCapacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int newHash = hash(Objects.hashCode(entry.key));
                int newIndex = newHash & (newCapacity - 1);
                newTable[newIndex] = entry;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    @Override
    public V get(K key) {
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            return table[index].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int currentIndex = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                while (currentIndex < capacity && (table[currentIndex] == null)) {
                    currentIndex++;
                }
                return currentIndex < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[currentIndex++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        list.listIterator(index).add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        list.listIterator(index + 1).add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> tListIterator = list.listIterator();
        while (tListIterator.hasNext()) {
            if (filter.test(tListIterator.next())) {
                tListIterator.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> tListIterator = list.listIterator();
        while (tListIterator.hasNext()) {
            if (filter.test(tListIterator.next())) {
                tListIterator.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> tListIterator = list.listIterator();
        while (tListIterator.hasNext()) {
            if (elements.contains(tListIterator.next())) {
                tListIterator.remove();
            }
        }
    }
}
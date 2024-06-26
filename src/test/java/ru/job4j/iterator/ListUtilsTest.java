package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        Predicate<Integer> filter = n -> n == 3;
        ListUtils.removeIf(input, filter);
        assertThat(input).isEqualTo(List.of(1));
    }

    @Test
    void whenReplaceIf() {
        Predicate<Integer> filter = n -> n == 3;
        ListUtils.replaceIf(input, filter, 4);
        assertThat(input).isEqualTo(List.of(1, 4));
    }

    @Test
    void whenRemoveAll() {
        List<Integer> list = Arrays.asList(2, 3);
        ListUtils.removeAll(input, list);
        assertThat(input).isEqualTo(List.of(1));
    }
}
package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withinPercentage;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void getNumberOfVertices() {
        Box box = new Box(4, 10);
        int number = box.getNumberOfVertices();
        assertThat(number).isNotNegative()
                .isPositive()
                .isGreaterThan(0)
                .isEqualTo(4);
    }

    @Test
    void getNumberOfVerticesIsExist() {
        Box box = new Box(0, 10);
        boolean number = box.isExist();
        assertThat(number).isTrue();
    }

    @Test
    void getNumberOfVerticesIsNotExist() {
        Box box = new Box(1, 10);
        boolean number = box.isExist();
        assertThat(number).isFalse();
    }

    @Test
    void getArea() {
        Box box = new Box(0, 4);
        double result = box.getArea();
        assertThat(result)
                .isCloseTo(201.06, withinPercentage(0.01))
                .isLessThan(201.07);
    }
}
package com.example.springtask.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ElementServiceTest {

    private final ElementService elementService = new ElementService();
    @Test
    void findElementTest() {
        int[] arr = {1, 3, 5, 2, 1, 9, 3, 5};

        int result = elementService.findElement(arr);

        assertEquals(2, result);
    }

    @Test
    void shouldThrowException() {
        int[] arr = {1, 3, 5, 1, 3, 5};

        assertThrows(
                RuntimeException.class,
                () -> elementService.findElement(arr));
    }

    @Test
    void findElementStreamTest() {
        int[] arr = {1, 3, 5, 2, 1, 9, 3, 5};

        int result = elementService.findElementStream(arr);

        assertEquals(2, result);
    }

    @Test
    void shouldThrowExceptionStream() {
        int[] arr = {1, 3, 5, 1, 3, 5};

        assertThrows(
                RuntimeException.class,
                () -> elementService.findElementStream(arr));
    }
}
package com.jad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    @Test
    @DisplayName("Test [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]")
    void reverseAlpha() {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            linkedList.add(c);
        }
        linkedList.reverse();
        assertEquals(26, linkedList.size());
        for (int i = 0; i < 26; i++) {
            assertEquals(new Character((char) ('A' + (25 - i))), linkedList.get(i));
        }
    }

    @Test
    @DisplayName("Test [Empty]")
    void reverseEmpty() {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        linkedList.reverse();
        assertEquals(true, linkedList.isEmpty());
    }

    @Test
    @DisplayName("Test [A lot of data]")
    @Timeout(value = 250, unit = TimeUnit.MILLISECONDS)
    void reverseHuge() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        linkedList.reverse();
        assertEquals(1000000, linkedList.size());
        int i = 1000000;
        for (int number : linkedList) {
            assertEquals(--i, number);
        }
    }

    @Test
    @DisplayName("Test Extended MyLinkedList")
    void reverseExtends() {
        MyLinkedList<Character> linkedList = new MyLinkedList<Character>() {
            @Override
            public void reverse() {
                super.reverse();
                System.out.println(this);
            }
        };
        for (char c = 'A'; c <= 'Z'; c++) {
            linkedList.add(c);
        }
        linkedList.reverse();
        assertEquals(26, linkedList.size());
        for (int i = 0; i < 26; i++) {
            assertEquals(new Character((char) ('A' + (25 - i))), linkedList.get(i));
        }
    }

    @Test
    @DisplayName("Test [MyLinkedList elements]")
    void reverseAnonymousClass() {
        MyLinkedList<MyLinkedList<Integer>> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            MyLinkedList<Integer> subList = new MyLinkedList<Integer>();
            linkedList.add(subList);
            for (int j = 0; j < 10; j++) {
                subList.add(i * j);
            }
        }
        linkedList.reverse();
        assertEquals(10, linkedList.size());
        for (int i = 0; i < 10; i++) {
            linkedList.get(i).reverse();
        }
        for (int i = 0; i < 10; i++) {
            MyLinkedList<Integer> subList = linkedList.get(i);
            assertEquals(10, subList.size());
            for (int j = 0; j < 10; j++) {
                assertEquals((9-i)*(9-j), subList.get(j));
            }
        }
    }

    @Test
    @DisplayName("Test double reverse [A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]")
    void reverseDouble() {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            linkedList.add(c);
        }
        linkedList.reverse();
        linkedList.reverse();
        assertEquals(26, linkedList.size());
        for (int i = 0; i < 26; i++) {
            assertEquals(new Character((char) ('A' + i)), linkedList.get(i));
        }
    }
}
package com.jad;

public class Main {

    public static void main(String[] args) {
	    MyLinkedList<Character> linkedList = new MyLinkedList<>();

        for (Character c = 'A'; c <= 'Z'; c++) {
            linkedList.add(c);
        }
        System.out.println(linkedList);
        linkedList.reverse();
    }
}

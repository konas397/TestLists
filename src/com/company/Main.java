package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List a = new ArrayList<>();
        List b = new LinkedList();
        int n = 5000000;
        int nInsRows = 10000;
        for (int i = 0; i < n*2; i++) {
            a.add("1");
        }
        for (int i = 0; i < n*2; i++) {
            b.add("2");
        }
        long start = System.nanoTime();
        String res;
        res = (String) a.get(n);
        StringBuilder sb = new StringBuilder();
        sb.append("Get ArrayList element_").append(n).append(" = ").append(res).append("  за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(1) - константная");
        System.out.println(sb.toString());

        start = System.nanoTime();
        res = (String) b.get(n);
        sb = new StringBuilder();
        sb.append("Get LinkedList element_").append(n).append(" = ").append(res).append(" за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(N) - линейная");
        System.out.println(sb.toString());

        start = System.nanoTime();
        a.add(n, "3");
        sb = new StringBuilder();
        sb.append("Add to ArrayList element_").append(n).append("   за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(1) - константная, но может быть больше");
        System.out.println(sb.toString());

        start = System.nanoTime();
        b.add(n, "3");
        sb = new StringBuilder();
        sb.append("Add to LinkedList element_").append(n).append("  за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(1) - константная");
        System.out.println(sb.toString());

        start = System.nanoTime();
        for (int i = 0; i < nInsRows; i++) {
            a.add(n+i, "3");
        }
        sb = new StringBuilder();
        sb.append("Add package to ArrayList from element_").append(n).append("                за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(1) - константная, но может быть больше");
        System.out.println(sb.toString());

        start = System.nanoTime();
        for (int i = 0; i < nInsRows; i++) {
            b.add(n+i, "3");
        }
        sb = new StringBuilder();
        sb.append("Add package to LinkedList from element_").append(n).append("               за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(N) - линейная");
        System.out.println(sb.toString());

        start = System.nanoTime();
        ListIterator<String> iterator = b.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.nextIndex()==n) {
                for (int i = 0; i < nInsRows; i++) {
                    iterator.add("4");
                }
                break;
            }
        }
        sb = new StringBuilder();
        sb.append("Add package to LinkedList from element_").append(n).append(" with Iterator за ").append(System.nanoTime()-start).append(" нано сек В теории сложность O(1) - константная");
        System.out.println(sb.toString());
        System.out.println(b.get(n));
    }

}

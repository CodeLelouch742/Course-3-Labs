package ru.pa4ok.lab1;

import ru.pa4ok.lab1.list.LinkedList;

/**
 * вариант 4
 * двусвязный список + вставка другого списка в конец
 */
public class Application
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
        System.out.println();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(2, "qwerty");
        list.set(0, "yes");
        list.set(5, "no");
        System.out.println(list);
        System.out.println();

        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(5));
        System.out.println();

        list.removeFirst();
        list.removeLast();
        list.remove(3);
        list.addFirst("what am i doing here...");
        System.out.println(list);
        System.out.println();

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list.add(list1);
        System.out.println(list);
        System.out.println();

        list.clear();
        System.out.println(list);
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
    }
}

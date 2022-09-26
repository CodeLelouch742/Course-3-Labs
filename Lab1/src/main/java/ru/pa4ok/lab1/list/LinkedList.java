package ru.pa4ok.lab1.list;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LinkedList<T>
{
    private int size;
    private LinkedListItem<T> first;

    public T get(int index)
    {
        if(isEmpty() || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListItem<T> current = first;
        int currentIndex = 0;

        while(currentIndex != index) {
            current = current.next;
            currentIndex++;
        }

        return current.value;
    }

    public void set(int index, T value)
    {
        if(isEmpty() || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListItem<T> current = first;
        int currentIndex = 0;

        while(currentIndex != index) {
            current = current.next;
            currentIndex++;
        }

        current.value = value;
    }

    public void add(T value)
    {
        if(isEmpty()) {
            first = new LinkedListItem<>(value, null, null);
        } else {
            LinkedListItem<T> current = first;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new LinkedListItem<>(value, current, null);
        }
        size++;
    }

    public void addFirst(T value)
    {
        if(isEmpty()) {
            first = new LinkedListItem<>(value, null, null);
        } else {
            LinkedListItem<T> newFirst = new LinkedListItem<>(value, null, first);
            first.previous = newFirst;
            first = newFirst;
        }
        size++;
    }

    public void add(int index, T value)
    {
        if(index == 0) {
            addFirst(value);
            return;
        }

        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListItem<T> current = first;
        int currentIndex = 0;

        while(currentIndex != index-1) {
            current = current.next;
            currentIndex++;
        }

        LinkedListItem<T> newItem = new LinkedListItem<>(value, current, current.next);
        if(current.next != null) {
            current.next.previous = newItem;
        }
        current.next = newItem;
        size++;
    }

    public void add(LinkedList<T> list)
    {
        if(list.isEmpty()) {
            return;
        }

        if(isEmpty()) {
            first = list.first;
        } else {
            LinkedListItem<T> current = first;
            while(current.next != null) {
                current = current.next;
            }

            LinkedListItem<T> newCurrent = list.first;
            while(newCurrent.next != null) {
                current.next = new LinkedListItem<>(newCurrent.value, current, null);
                current = current.next;
                newCurrent = newCurrent.next;
            }
            current.next = new LinkedListItem<>(newCurrent.value, current, null);
        }
        size += list.size;
    }

    public void remove(int index)
    {
        if(isEmpty() || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListItem<T> current = first;
        int currentIndex = 0;

        while(currentIndex != index-1) {
            current = current.next;
            currentIndex++;
        }

        LinkedListItem<T> forDelete = current.next;
        if(forDelete.next != null) {
            forDelete.next.previous = current;
        }
        current.next = forDelete.next;
        size--;
    }

    public void removeLast()
    {
        if(isEmpty()) {
            return;
        }

        LinkedListItem<T> current = first;
        while(current.next != null) {
            current = current.next;
        }
        current.previous.next = null;
        size--;
    }

    public void removeFirst()
    {
        if(isEmpty()) {
            return;
        }

        first = first.next;
        first.previous = null;
        size--;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("size: " + size);
        if(!isEmpty()) {
            LinkedListItem<T> current = first;
            while(current.next != null) {
                sb.append("\n    ").append(current);
                current = current.next;
            }
            sb.append("\n    ").append(current);
        }
        return sb.toString();
    }
}

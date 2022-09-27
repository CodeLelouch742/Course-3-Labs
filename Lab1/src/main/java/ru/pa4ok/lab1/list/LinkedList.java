package ru.pa4ok.lab1.list;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LinkedList<T>
{
    protected int size;
    public LinkedListItem<T> first;

    private LinkedListItem<T> getItem(int index)
    {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        LinkedListItem<T> current = first;
        int currentIndex = 0;

        while(currentIndex++ != index) {
            current = current.next;
        }

        return current;
    }

    public T get(int index)
    {
        return getItem(index).value;
    }

    public void set(int index, T value)
    {
        getItem(index).value = value;
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

        LinkedListItem<T> current = getItem(index);
        LinkedListItem<T> newItem = new LinkedListItem<>(value, current.previous, current);
        current.previous.next = newItem;
        current.previous = newItem;
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

    public void add(T value)
    {
        if(isEmpty()) {
            addFirst(value);
            return;
        }

        LinkedListItem<T> current = getItem(size-1);
        current.next = new LinkedListItem<>(value, current, null);
        size++;
    }

    public void add(LinkedList<T> list)
    {
        if(list.isEmpty()) {
            return;
        }

        if(isEmpty()) {
            first = list.first;
            size = list.size;
            return;
        }

        LinkedListItem<T> current = getItem(size-1);
        LinkedListItem<T> newCurrent = list.first;

        while(newCurrent.next != null) {
            current.next = new LinkedListItem<>(newCurrent.value, current, null);
            current = current.next;
            newCurrent = newCurrent.next;
        }
        current.next = new LinkedListItem<>(newCurrent.value, current, null);

        size += list.size;
    }

    public void remove(int index)
    {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            removeFirst();
            return;
        }

        LinkedListItem<T> previous = getItem(index-1);
        LinkedListItem<T> current = previous.next;

        if(current.next != null) {
            current.next.previous = previous;
        }
        previous.next = current.next;
        size--;
    }

    public void removeLast()
    {
        remove(size-1);
    }

    public void removeFirst()
    {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        if(first.next != null) {
            first.next.previous = null;
            first = first.next;
        } else {
            first = null;
        }
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

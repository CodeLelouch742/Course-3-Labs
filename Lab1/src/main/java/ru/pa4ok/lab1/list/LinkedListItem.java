package ru.pa4ok.lab1.list;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class LinkedListItem<T>
{
    protected T value;
    protected LinkedListItem<T> previous;
    public LinkedListItem<T> next;

    @Override
    public String toString() {
        return "LinkedListItem{" +
                "previous=" + (previous != null ? previous.value : "null") +
                ", value=" + value +
                ", next=" + (next != null ? next.value : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListItem<?> that = (LinkedListItem<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

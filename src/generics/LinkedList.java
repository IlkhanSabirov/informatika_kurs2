package generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<C> implements List<C> {
    private Node<C> first;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<C> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(C c) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends C> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends C> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public C get(int index) {
        return null;
    }

    @Override
    public C set(int index, C element) {
        return null;
    }

    @Override
    public void add(int index, C element) {

    }

    @Override
    public C remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<C> listIterator() {
        return null;
    }

    @Override
    public ListIterator<C> listIterator(int index) {
        return null;
    }

    @Override
    public List<C> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    private static class Node<D> {
        D value;
        Node<D> next;
    }

}

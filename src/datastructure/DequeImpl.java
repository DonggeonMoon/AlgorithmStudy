package datastructure;

import java.util.*;

public class DequeImpl implements Deque<String> {
    private final List<String> list = List.of();
    @Override
    public void addFirst(String s) {
        List<String> list = new ArrayList<>(List.of(s));
        list.addAll(list);

    }

    @Override
    public void addLast(String s) {

    }

    @Override
    public boolean offerFirst(String s) {
        return false;
    }

    @Override
    public boolean offerLast(String s) {
        return false;
    }

    @Override
    public String removeFirst() {
        return null;
    }

    @Override
    public String removeLast() {
        return null;
    }

    @Override
    public String pollFirst() {
        return null;
    }

    @Override
    public String pollLast() {
        return null;
    }

    @Override
    public String getFirst() {
        return null;
    }

    @Override
    public String getLast() {
        return null;
    }

    @Override
    public String peekFirst() {
        return null;
    }

    @Override
    public String peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(String s) {
        return false;
    }

    @Override
    public boolean offer(String s) {
        return false;
    }

    @Override
    public String remove() {
        return null;
    }

    @Override
    public String poll() {
        return null;
    }

    @Override
    public String element() {
        return null;
    }

    @Override
    public String peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public void push(String s) {

    }

    @Override
    public String pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Iterator<String> descendingIterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public boolean containsAll(Collection<?> c) {
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
}

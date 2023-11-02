package datastructure;

import java.util.Stack;

public class StackImpl extends Stack<String> {
    public StackImpl() {
        super();
    }

    @Override
    public String push(String item) {
        return super.push(item);
    }

    @Override
    public synchronized String pop() {
        return super.pop();
    }

    @Override
    public synchronized String peek() {
        return super.peek();
    }

    @Override
    public boolean empty() {
        return super.empty();
    }

    @Override
    public synchronized int search(Object o) {
        return super.search(o);
    }
}

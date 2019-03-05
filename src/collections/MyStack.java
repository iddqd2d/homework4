package collections;

public class MyStack<T> {
    private MyArrayList<T> myArrayList;

    MyStack() {
        myArrayList = new MyArrayList<T>();
    }

    public int getSize() {
        return myArrayList.getSize();
    }

    public MyStack push(T t) {
        myArrayList.add(t);
        return this;
    }

    public T peek() {
        return (!myArrayList.isEmpty()) ? myArrayList.get(getSize() - 1) : null;
    }

    public T pop() {
        return (!myArrayList.isEmpty()) ? myArrayList.remove(getSize() - 1) : null;
    }

    public void clear() {
        myArrayList.clear();
    }

    public void remove(T t) {
        myArrayList.remove(t);
    }

    @Override
    public String toString() {
        return myArrayList.toString();
    }
}

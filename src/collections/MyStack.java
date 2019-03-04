package collections;

public class MyStack<T> {
    private MyArrayList<T> myArrayList;

    MyStack() {
        myArrayList = new MyArrayList<T>();
    }

    public MyStack push(T t) {
        myArrayList.add(t);
        return this;
    }

    public T peek() {
        int size = myArrayList.getSize();
        return (size != 0) ? myArrayList.get(size - 1) : null;
    }

    public T pop() {
        int size = myArrayList.getSize();
        myArrayList.remove(size - 1);
        return (size != 0) ? myArrayList.get(size - 1) : null;
    }

    public void clear() {
        myArrayList.clear();
    }

    public int getSize() {
        return myArrayList.getSize();
    }

    public void remove(T t) {
        myArrayList.remove(t);
    }

    @Override
    public String toString() {
        return myArrayList.toString();
    }
}

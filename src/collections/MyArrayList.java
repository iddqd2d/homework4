package collections;

import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> extends MyAbstractList<T> {

    private Object[] array;
    private static final int DEFAULT_CAPACITY = 10;


    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            array = new Object[initialCapacity];
        } else {
            array = new Object[0];
        }
    }

    public Object[] getArray() {
        return array;
    }

    @Override
    public T get(int index) {
        return (check(index)) ? (T) array[index] : null;
    }

    @Override
    public MyArrayList add(T t) {
        resizeArray();
        array[getSize()] = t;
        setSize(getSize() + 1);
        return this;
    }

    public MyArrayList add(int index, T t) {
        resizeArray();
        if (check(index)) {
            int lenghtMoved = getSize() - index;
            if (lenghtMoved > 0) {
                System.arraycopy(array, index, array, index + 1, lenghtMoved);
                array[index] = t;
            }
        }
        setSize(getSize() + 1);
        return this;
    }

    @Override
    public T remove(int index) {
        if (check(index)) {
            T temp = (T) array[index];

            int lenghtMoved = getSize() - index - 1;

            if (lenghtMoved > 0) {
                System.arraycopy(array, index + 1, array, index, lenghtMoved);
            }
            array[getSize() - 1] = null;
            setSize(getSize() - 1);
            return temp;
        }
        return null;
    }

    public void remove(T t) {
        for (int i = 0; i < getSize(); i++) {
            if (array[i].equals(t)) {
                remove(i);
                setSize(getSize() - 1);
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < getSize(); i++) {
            array[i] = null;
        }
        setSize(0);
    }

    private void resizeArray() {
        if (getSize() == array.length) {
            int oldCapacity = array.length;
            array = Arrays.copyOf(array, oldCapacity + 1 + (oldCapacity >> 1));
        }
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < getSize(); i++) {
            str.append("[" + i + "] => " + array[i] + "\n");
        }
        return str.toString();
    }
}

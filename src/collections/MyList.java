package collections;

public interface MyList<T> {
    T get(int index);

    MyList add(T t);

    boolean remove(int index);

    void clear();

    int getSize();

}

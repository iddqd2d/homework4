package collections;

public abstract class MyAbstractList<T> implements MyList<T> {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    protected boolean check(int i) {
        return (i < size && i > 0) ? true : false;
    }
}

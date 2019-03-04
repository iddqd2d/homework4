package collections;

public abstract class MyAbstractList<T> implements MyList<T> {
    private int size;

    public int getSize() {
        return size;
    }

    public void icreaseSize() {
        size++;
    }

    public void decreaseSize() {
        size--;
    }

    public void clearSize() {
        size = 0;
    }

    protected boolean check(int i) {
        return (i < size && i > 0) ? true : false;
    }
}

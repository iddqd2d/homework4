package collections;

public class MyLinkedList<T> extends MyAbstractList<T> {
    private Node<T> first;
    private Node<T> last;

    private Node<T> node(int index) {
        if (index < (getSize() / 2)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<T> x = last;
            for (int i = getSize() - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public T get(int index) {
        return (check(index)) ? node(index).item : null;
    }


    @Override
    public MyLinkedList add(T t) {
        Node<T> prevNode = last;
        Node<T> curNode = new Node<>(prevNode, t, null);
        last = curNode;
        if (prevNode == null) {
            first = curNode;
        } else prevNode.next = curNode;
        icreaseSize();
        return this;
    }

    private void cutNode(Node<T> node) {
        Node<T> next = node.next;
        Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        decreaseSize();
    }


    public int remove(Object o) {
        int quantity = 0;
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    cutNode(x);
                    quantity++;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    cutNode(x);
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public boolean remove(int index) {
        if (check(index)) {
            cutNode(node(index));
            return true;
        } else return false;
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        clearSize();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        int i = 0;
        for (Node<T> x = first; x != null; x = x.next, i++) {
            str.append("[" + i + "] => " + x.item + "\n");
        }
        return str.toString();
    }
}

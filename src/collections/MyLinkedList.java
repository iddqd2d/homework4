package collections;

public class MyLinkedList<T> extends MyAbstractList<T> {
    private Node<T> first;
    private Node<T> last;

    private Node<T> node(int index) {
        if (index < (getSize() / 2)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) {
                x = x.getNext();
            }
            return x;
        } else {
            Node<T> x = last;
            for (int i = getSize() - 1; i > index; i--) {
                x = x.getPrev();
            }
            return x;
        }
    }

    @Override
    public T get(int index) {
        return (check(index)) ? node(index).getItem() : null;
    }


    @Override
    public MyLinkedList add(T t) {
        Node<T> prevNode = last;
        Node<T> curNode = new Node<>(prevNode, t, null);
        last = curNode;
        if (prevNode == null) {
            first = curNode;
        } else prevNode.setNext(curNode);
        setSize(getSize() + 1);
        return this;
    }

    private void cutNode(Node<T> node) {
        Node<T> next = node.getNext();
        Node<T> prev = node.getPrev();

        if (prev == null) {
            first = next;
        } else {
            prev.setNext(next);
            node.setPrev(null);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrev(prev);
            node.setNext(null);
        }

        node.setItem(null);
        setSize(getSize() - 1);
    }


    public int remove(Object o) {
        int quantity = 0;
        if (o == null) {
            for (Node<T> x = first; x != null; x = x.getNext()) {
                if (x.getItem() == null) {
                    cutNode(x);
                    quantity++;
                }
            }
        } else {
            for (Node<T> x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getItem())) {
                    cutNode(x);
                    quantity++;
                }
            }
        }
        return quantity;
    }

    @Override
    public T remove(int index) {
        if (check(index)) {
            T temp = node(index).getItem();
            cutNode(node(index));
            return temp;
        } else return null;
    }

    @Override
    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.getNext();
            x.setItem(null);
            x.setNext(null);
            x.setPrev(null);
            x = next;
        }
        first = last = null;
        setSize(0);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        int i = 0;
        for (Node<T> x = first; x != null; x = x.getNext(), i++) {
            str.append("[" + i + "] => " + x.getItem() + "\n");
        }
        return str.toString();
    }
}

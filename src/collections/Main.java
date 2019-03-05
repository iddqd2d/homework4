package collections;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1).add(2).add(3).add(4).add(5);
        myArrayList.remove(3);
        myArrayList.setSize(-10);
        myArrayList.add(2);
        System.out.println(myArrayList);

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("a").add("b").add("c").add("d");
        myLinkedList.remove("b");
        System.out.println(myLinkedList);

        MyStack myStack = new MyStack();
        myStack.push(1).push(2).push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack);
    }
}

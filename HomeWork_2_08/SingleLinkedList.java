package HomeWork_2_08;

public class SingleLinkedList implements GBList {
    private Node first;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next != null)
            add(current.next, val);
        else
            current.next = new Node(val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while (current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
//        int i = 0;
//        GBIterator iterator = iterator();
//        while (iterator.hasNext()) {
//            i++;
//        }
//        return i;
        return size;
    }

    @Override
    public String get(int index) {
        GBIterator getVal = new StraightForwardIterator(first);
        String value = null;
        for (int i = 0; i <= index; i++) {
            value = getVal.next();
            if(!getVal.hasNext())
                return "Нет элемента с заданым индексом";
        }
        return value;
    }

    @Override
    public GBIterator iterator() {
        return new StraightForwardIterator(first);
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                '}';
    }

    private static class Node {
        private String val;
        private Node next;

        public Node(String value) {
            this(value, null);
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    public static class StraightForwardIterator implements GBIterator {
        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrev() { return false; }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public String prev() {
            return null;
        }
    }
}

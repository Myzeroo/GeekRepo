package HomeWork_2_08;

public class DoubleLinkedList implements GBList {
    private Node first;
    private Node last;
    private int size = 0;


    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
            last = first;
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next != null)
            add(current.next, val);
        else {
            current.next = new Node(current, val);
            last = current.next;
        }
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
                current.next.setPrev(prev);
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
        return size;
    }

    @Override
    public String get(int index) {
        GBIterator getVal = new BidirectionalIterators(first);
        String value = null;
        for (int i = 0; i <= index; i++) {
            value = getVal.next();
            if (!getVal.hasNext())
                return "Нет элемента с заданым индексом";
        }
        return value;
    }

    @Override
    public GBIterator iterator() {
        return new BidirectionalIterators(first);
    }

    private static class Node {
        private String val;
        private Node next;
        private Node prev;

        public Node(String val) {
            this(null, val, null);
        }

        public Node(Node prev, String val) {
            this(prev, val, null);
        }

        public Node(Node prev, String val, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }

    public static class BidirectionalIterators implements GBIterator {
        private Node current;

        public BidirectionalIterators(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrev() {
            return current.prev != null;
        }

        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }

        @Override
        public String prev() {
            String val = current.val;
            current = current.prev;
            return val;
        }
    }
}

// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList20 {

    /*
    Write a method called shift that rearranges the elements of a list of integers by moving to the end of the list all
    values that are in odd-numbered positions and otherwise preserving list order. For example, suppose that a variable
    list stores the values [10, 31, 42, 23, 44, 75, 86] . The call of list.shift(); should rearrange the list to store
    [10, 42, 44, 86, 31, 23, 75] . It doesn’t matter whether the value itself is odd or even; what matters is whether
    the value appears in an odd index (index 1, 3, 5, etc.). Also notice that the original order of the list is
    otherwise preserved. You may not construct any new nodes nor use any auxiliary data structures to solve this
    problem. You also may not change any data fields of the nodes; you must solve this problem by rearranging the links
    of the list.
     */

    public void shift() {
        ListNode20 previous = front;
        ListNode20 current = front.next;
        ListNode20 firstOdd = front.next;
        ListNode20 last = null;
        int size = this.size();
        int counter = 0;

        if (size % 2 == 0) {
            size--;
            last = this.nodeAt(size);
        }

        nodeAt(size - 1).next = front.next;

        while (counter < size -2) {
            previous.next = current.next;
            previous = current;
            current = current.next;
            counter++;
            System.out.println(this);
        }

        /*
        if (last != null) {
            current.next = last;
        }*/
    }

    // Everything below is copied from the book

    private ListNode20 front; // first value in the list

    // post: constructs an empty list
    public LinkedIntList20() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode20 current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode20 current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: returns the position of the first occurrence of the
    // given value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode20 current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode20(value);
        } else {
            ListNode20 current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode20(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode20(value, front);
        } else {
            ListNode20 current = nodeAt(index - 1);
            current.next = new ListNode20(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode20 current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode20 nodeAt(int index) {
        ListNode20 current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}
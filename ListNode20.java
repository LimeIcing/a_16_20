public class ListNode20 {
    public int data; // data stored in this node
    public ListNode20 next; // link to next node in the list

    // post: constructs a node with data 0 and null link
    public ListNode20() {
        this(0, null);
    }

     // post: constructs a node with given data and null link
    public ListNode20(int data) {
        this(data, null);
    }

    // post: constructs a node with given data and given link
    public ListNode20(int data, ListNode20 next) {
        this.data = data;
        this.next = next;
    }
}
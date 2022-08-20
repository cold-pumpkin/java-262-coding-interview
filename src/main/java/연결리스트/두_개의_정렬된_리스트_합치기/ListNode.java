package 연결리스트.두_개의_정렬된_리스트_합치기;

import java.util.Objects;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode() {}

    public ListNode(T data) {
        this.data = data;
    }

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @SafeVarargs
    public static <T> ListNode<T> of(T... data) {
        if (data == null || data.length == 0)
            throw new IllegalArgumentException();

        ListNode<T> head = new ListNode<>();
        ListNode<T> last = head;
        ListNode<T> p;
        for (T d : data) {
            p = new ListNode<T>(d);
            last.next = p;
            last = last.next;
        }

        return head.next;
    }

    public String toStringAll() {
        ListNode<T> current = this;

        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> other = (ListNode<?>) o;
        return Objects.equals(this.data, other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
    }
}

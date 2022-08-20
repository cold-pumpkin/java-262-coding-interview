package 연결리스트.두_개의_정렬된_리스트_합치기;

import com.sun.security.jgss.GSSUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Solution {
    /**
     * 7.1 두 개의 정렬된 리스트 합치기
     * @param L1 정렬된 입력 연결 리스트
     * @param L2 정렬된 입력 연결 리스트
     * @return 정렬된 입력 연결 리스트
     */
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1, ListNode<Integer> L2) {
        // 병합 정렬 결과를 연결할 노드
        ListNode<Integer> dummyNode = new ListNode<>(0);
        ListNode<Integer> current = dummyNode;
        ListNode<Integer> p1 = L1, p2 = L2;

        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }

        // 남아있는 노드 이어 붙이기
        current.next = p1 != null ? p1 : p2;
        return dummyNode.next;
    }


    @Test
    void test() {
        ListNode<Integer> L1 = ListNode.of(1, 4, 5, 7, 8, 11);
        ListNode<Integer> L2 = ListNode.of(2, 3, 6, 7, 9, 10);

        assertThat(mergeTwoSortedLists(L1, L2).toStringAll())
                .isEqualTo("1 2 3 4 5 6 7 7 8 9 10 11");
    }
}

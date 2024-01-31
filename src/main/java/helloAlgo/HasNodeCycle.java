package helloAlgo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HasNodeCycle {
//   给你一个链表的头节点 head ，判断链表中是否有环。
//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。

    public  boolean hasCycle(MergeTwoNode.ListNode head) {
        Set<MergeTwoNode.ListNode> set = new HashSet<>();
        while (head != null) {
            if(!set.add(head)){
                return  true;
            }
            head = head.next;
        }
        return false;

    }

    public boolean hasCycle2 (MergeTwoNode.ListNode head) {
        if(head == null)return false;
        MergeTwoNode.ListNode  fast =head.next,slow = head;
        while (fast !=slow){
            if(fast== null || fast.next == null)return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
//    定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

    public MergeTwoNode.ListNode detectCycle(MergeTwoNode.ListNode head) {
        if(head == null)return null;
        MergeTwoNode.ListNode  fast =head,slow = head;
        while (true){
            if(fast.next== null || fast == null)return null;
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)break;
        }
        fast  =head;
        while (fast !=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}

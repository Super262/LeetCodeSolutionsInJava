package solutions.StackAndQueue;

import java.util.Stack;

public class Problem1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> asecData = new Stack<>();
        Stack<Integer> nextLarger = new Stack<>();
        ListNode current = head;
        while(current != null){
            Stack<Integer> tempLarger = new Stack<>();
            while(!nextLarger.empty() && !asecData.empty() && asecData.peek() < current.val){
                if(nextLarger.peek() == 0){
                    asecData.pop();
                    nextLarger.pop();
                    tempLarger.push(current.val);
                }
                else{
                    tempLarger.push(nextLarger.pop());
                }
            }
            while(!tempLarger.empty()){
                nextLarger.push(tempLarger.pop());
            }
            asecData.push(current.val);
            nextLarger.push(0);
            current = current.next;
        }
        int[] result = new int[nextLarger.size()];
        int i = result.length - 1;
        while(!nextLarger.empty()){
            result[i] = nextLarger.pop();
            --i;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


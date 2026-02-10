import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

class ListNode implements Comparable<ListNode> {
    ListNode next;
    int value;
    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
    
    @Override
    public int compareTo(ListNode other) {
        return Integer.compare(this.value, other.value);
    }
}
public class PriorityQue {
    public static void main(String[] args) {

//        [[1,4,5],[1,3,4],[2,6]]

        ListNode list1 = new ListNode(1);
        ListNode tempList1 = list1;
        tempList1.next = new ListNode(4);
        tempList1 = tempList1.next;
        tempList1.next = new ListNode(5);


        ListNode list2 = new ListNode(1);
        tempList1 = list2;
        tempList1.next = new ListNode(3);
        tempList1 = tempList1.next;
        tempList1.next = new ListNode(4);


        ListNode list3 = new ListNode(2);
        tempList1 = list3;
        tempList1.next = new ListNode(6);



        ArrayList<ListNode> masterList = new ArrayList<>();

        masterList.add(list1);
        masterList.add(list2);
        masterList.add(list3);



//         [[1,4,5],[1,3,4],[2,6]]


        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>();

        for (ListNode node : masterList) {
//            while(node != null) {
//                System.out.print(node.value + " ");
//                node = node.next;
//            }

            System.out.println();



            q.add(node);
        }

        ListNode temp1 = new ListNode(5);
        ListNode temp2 = temp1;

        while (!q.isEmpty()) {
            ListNode node = q.remove();
            if (node.next != null) {
                q.add(node.next);
            }
            temp1.next = node;
            temp1 = temp1.next;

        }


        while (temp2 != null) {
            System.out.print(temp2.value+ " ");
            temp2 = temp2.next;
        }


    }
}

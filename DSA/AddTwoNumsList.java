
import java.util.Scanner;

public class AddTwoNumsList {

    
    static public class ListNode{
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        ListNode l = new ListNode(0);
        ListNode temp = l;
        ListNode p = l1;
        ListNode q = l2;
        
        int carry = 0;
        int rem = 0;
    
        
        while(q != null || p != null){
            
            int x = (q != null) ? q.val : 0;
            int y = (p != null) ? p.val : 0;
            int val = x + y + carry;
            
            carry = val/10;
            rem = val % 10;
            
            temp.next = new ListNode(rem);
            temp = temp.next;
            if(q != null) q = q.next;
            if(p != null) p = p.next;
            
        }
        
        if(carry > 0) temp.next = new ListNode(carry);
        
        return l.next;
    }

 
    
    public static void main(String[] args) throws Exception {



        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        
        System.out.println(" Enter number of digits for 1d list: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(" Enter  "+ n +" digits to the list: ");
        ListNode p = l1;
 

        while(n-- > 0 ){
            int val = scan.nextInt();
            p.val = val;
            p.next = new ListNode(0); 
            p = p.next;
         
        }


        System.out.println(" Enter number of digits for 2d list: ");
        int m = scan.nextInt();
        System.out.println(" Enter  "+ m +" digits to the list: ");
        ListNode q = l2;
        while(m-- > 0 ){
            int val = scan.nextInt();
            q.val = val;
            q.next = new ListNode(0);
            q = q.next;
        }

        scan.close();
        ListNode ll = addTwoNumbers(l1, l2);
        System.out.println(" Sum : ");
        while(ll != null){
            System.out.print(ll.val+" ");
            ll = ll.next;
           
        }
        
    }
}

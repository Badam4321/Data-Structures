package SLL;


public class SingleLinkedList {
    
    public static void main(String[] args) {
        int[] arr = {4 , 10 , 13 , 15 , 16 , 17};

        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1 ; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }

        //Single Linked List traversal 
        display(head);
        //Insertion in Linked list  
        head = insertAtStart(head , 10);
        System.out.println();
        display(head);
        head = insertAtEnd(head, 19);
        System.out.println();
        display(head);
        head = insertAtPosition(head , 3 , 23);
        System.out.println();
        display(head);

        //deletion in linked list 
        head = deletionAtStart(head);
        System.out.println();
        display(head);

        head = deletionAtEnd(head);
        System.out.println();
        display(head);

        head = deletionAtPosition(head , 3);
        System.out.println();
        display(head);




    }

    private static Node deletionAtPosition(Node head , int position) {
        //4 23 10 13 15 16 17 
        Node curr = head;
        for(int i = 1 ; i < position - 1; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    private static Node deletionAtEnd(Node head) {
        Node curr = head;
        while(curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    private static Node deletionAtStart(Node head) {
        head = head.next;
        return head;
    }

    private static Node insertAtPosition(Node head , int position , int data) {
        Node curr = head;
        for(int i = 1 ; i < position - 1; i++){
            curr = curr.next;
        }
        Node temp = new Node(data);
        Node pos = curr.next;
        curr.next = temp;
        temp.next = pos;
        return head;
        
    }

    private static Node insertAtEnd(Node head, int data) {
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new Node(data);
        return head;
    }

    private static Node insertAtStart(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;

    }
    private static void display(Node head){
        Node curr = head ;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        
    }
    
    
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
    public Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
}

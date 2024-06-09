import java.util.*;

class doublyLinkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        abc o1 = new abc();
        o1.addfirst(10);
        o1.addfirst(20);
        o1.addfirst(30);
        o1.addlast(40);
       /*  System.out.println("list Normal Way ->");
        o1.display();
        System.out.println();

        o1.addAftervalue(22, 20);
        o1.addBeforevalue(22, 20);
        System.out.println("After adding 22 after 20 ->");
        o1.display();

        System.out.println();
        o1.deletefirst();
        o1.deletefirst();
        o1.deletelast();
        o1.display();

        System.out.println();
        o1.deleteparticularvalue(20);
        o1.display();

        System.out.println();
        System.out.println("Dispaly in reverse ->");
        o1.displayreverse();*/

        System.out.println("After Orderlist final linked list ->");
        o1.orderlist(22);
        o1.orderlist(15);
        o1.orderlist(3);
        o1.orderlist(25);
        o1.display();
        
        /*
        int ch;
        do{
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete at beginning");
            System.out.println("4. Delete at end");
            System.out.println("5. Insert After Value");
            System.out.println("6. Insert Before Value");
            System.out.println("7. Delete Particular Value");
            System.out.println("8. Display");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter element U want :");
                    int val1 = sc.nextInt();
                    o1.addfirst(val1);
                    break;
                
                case 2:
                    System.out.println("Enter element U want :");
                    int val2 = sc.nextInt();
                    o1.addlast(val2);
                    break;
                 
                case 3:
                    o1.deletefirst();
                    break;

                case 4:
                    o1.deletelast();
                    break;

                case 5:
                    System.out.println("Enter element U want to insert after:");
                    int val3 = sc.nextInt();
                    System.out.println("Enter value after which U want to insert:");
                    int val4 = sc.nextInt();
                    o1.addAftervalue(val3, val4);
                    break;

                case 6: 
                    System.out.println("Enter element U want to insert before:");
                    int val5 = sc.nextInt();
                    System.out.println("Enter value before which U want to insert:");
                    int val6 = sc.nextInt();
                    o1.addBeforevalue(val5, val6);
                    break;

                case 7:
                    System.out.println("Enter Element U want to delete");
                    int val7 = sc.nextInt();
                    o1.deleteparticularvalue(val7);
                    break;

                case 8:
                    o1.display();
                    break;

                case 9:
                    o1.displayreverse();
                    break;
                
                case 10:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice ... Enter choice Between 1 to 10");
            }
        }while(ch != 10);
        }  
        */  
    }  
}

class abc{
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }   
    }
    Node first = null;

    public void addfirst(int data){
        Node n = new Node(data);
        if(first == null){
            first = n;
        }else{
            n.next = first;
            first.prev = n;
            first = n;
        }  
        System.out.println("Sucessfully Added :"+data);  
    }

    public void addlast(int data){
        Node n = new Node(data);
        if(first == null){
            first = n;
        }else{
            Node temp = first;
            do{
                temp = temp.next;
            }while(temp.next != null);
            temp.next = n;
            n.prev = temp;
        } 
        System.out.println("Sucessfully Added :"+data);     
    }

    public void addAftervalue(int data,int value){
        Node n = new Node(data);
        if(first == null){
            System.out.println("List is empty");
            return;
        }else{
            Node temp = first;
            while(temp != null){
                if(temp.data == value){
                    if (temp.next != null) {
                        n.next = temp.next;
                        n.prev = temp;
                        temp.next.prev = n;
                        temp.next = n;
                    }else{
                        temp.next = n;
                        n.prev = temp;
                    }
                    System.out.println("sucessfully added :"+data);
                    return;
                }
                temp = temp.next;
            }    
        }   
        System.out.println("Value not found in the list"); 
    }

    public void addBeforevalue(int data,int value){
        Node n = new Node(data);
        if(first == null){
            System.out.println("List is empty");
        }else{
            if (first.data == value) {
                n.next = first;
                first.prev = n;
                first = n;
                return;
            }
            Node temp = first;
            while(temp.next != null){
                if(temp.data == value){
                    n.next = temp;
                    n.prev = temp.prev;
                    temp.prev.next = n;
                    temp.prev = n;
                    System.out.println("sucessfully added :"+data);       
                    return;
                }
                temp = temp.next;
            } 
        }        
        System.out.println("Value not found in the list");
    }

    public void display(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            Node temp = first;
            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while(temp != null);
        }
    }

    public void displayreverse(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            Node temp = first;
            while(temp.next != null){
                temp = temp.next;
            }
            do{
                System.out.print(temp.data+" ");
                temp = temp.prev;
            }while(temp != null);    
        }    
    }

    public void deletefirst(){
        if(first == null){
            System.out.println("Linked list is empty");
        }else if (first.next == null) {
            System.out.println("Deleted :"+first.data);
            first = null;
        }else{
            System.out.println("Deleted :"+first.data);
            first = first.next;
            first.prev.next = null;
            first.prev = null;
        }
    }

    public void deletelast(){
        if(first == null){
            System.out.println("Linked list is empty");
        }else if (first.next == null) {
            System.out.println("Deleted :"+first.data);
            first = null;
        }else{
            Node temp = first;
            while(temp.next != null){
                temp = temp.next;
            }
            System.out.println("Deleted :"+temp.data);
            temp.prev.next = null;
            temp.prev = null;
        }
    }

    public void deleteparticularvalue(int value){
        if(first == null){
            System.out.println("Linked list is empty");
        }else if (first.data == value && first.next == first) {
            first = null;
        }else if (first.data == value && first.next != null) {
            first = first.next;
            first.prev.next = null;
            first.prev = null;
        }else{
            Node temp = first;
            Node delete = first;
            while(temp != null){
                if(temp.data == value){
                    if(temp.next != null){
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                        temp.next = null;
                        temp.prev = null;
                        return;
                    }else{
                        temp.prev.next = null;
                        temp.prev = null;
                    }
                    System.out.println("Deleted :"+delete.data);

                }
                temp = temp.next;
            } 
            System.out.println("Value not found in linked list");
        }
    }

    public void orderlist(int data){
        //We should have atleast One element in list
        Node n = new Node(data);
        if (first == null) {
            System.out.println("Linkd list is empty");
        }else if(n.data <= first.data) {
            n.next = first;
            first.prev = n;
            first = n;
        }else{
            Node temp = first;
            while(temp.next != null && temp.next.data <= n.data){
                temp = temp.next;
            }
            n.next = temp.next;
            n.prev = temp;
            if (temp.next != null) {
                temp.next.prev = n;
            }
            temp.next = n;
        }
    }

}

class c1 {
    public static void main(String[] args) {
        xyz o1 = new xyz();
        o1.addfirst(10);
        o1.addlast(20);
        o1.addlast(30);
        o1.addlast(40);
        o1.addfirst(5);
        o1.display();
        System.out.println();
        System.out.println("Middle value :"+o1.middlevalue());
        // System.out.println();
        // System.out.println("Min value :"+o1.minValue());
        // System.out.println("Max value :"+o1.maxValue());


        /* xyz o2 = new xyz();
        o2.addlast(50);
        o2.addlast(60);
        o2.addlast(70);
        o2.display();
        System.out.println();

        xyz o3 = new xyz();
        o3.first = o3.mergelist(o1.first, o2.first);
        o3.display();
        o1.evendelete();
       o1.display();
        o1.odddelete();
        o1.display();

       o1.addAftervalue(12, 20);
        o1.addBeforevalue(12, 20);
        o1.addAftervalue(100, 40);
        o1.display();

        o1.deletefirst();
        o1.deletefirst();
        o1.deletelast();
        o1.display();

        o1.deleteparticularvalue(40);
        o1.deleteparticularvalue(100);
        o1.display();
        System.out.println();
        o1.displayoddPos();
        System.out.println();
        o1.displayevenPos();
        System.out.println();
        o1.displayevenvalue();
        System.out.println();
        o1.addfirst(5);
        o1.displayoddvalue();
        */

    }    
}

class xyz{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node first = null;
    public void addfirst(int data){
        Node n = new Node(data);
        if (first == null) {
            first = n;
            n.next = n;
        }else{
            Node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = first;
            first = n;
        }
        System.out.println("Sucessfully added :"+data);
    }

    

    public void addlast(int data){
        Node n = new Node(data);
        if (first == null) {
            first = n;
            n.next = n;
        }else{
            Node temp = first;
            while (temp.next != first) {
                temp = temp.next;
            }
            temp.next = n;
            n.next = first;
        }
        System.out.println("Sucessfully added :"+data);
    }

    public void display(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            Node temp = first;
            do{
                System.out.print(temp.data+" ");
                temp = temp.next;
            }while(temp != first);
        }
    }


    public void addBeforevalue(int data,int value){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            int flag = 0;
            Node dummy = first;
            do{
                if (dummy.data == value) {
                    flag = 1;
                }
                dummy= dummy.next;
            }while(dummy != first);
            if (flag == 0) {
                System.out.println("NO such found data");
            }else{
                Node n = new Node(data);
                if (first.data == value) {
                    Node temp = first;
                    while (temp.next != first) {
                        temp = temp.next;
                    }
                    temp.next = n;
                    n.next = first;
                    first = n;
                }else{
                    Node temp =first;
                    while (temp.next.data != value) {
                        temp = temp.next;
                    }
                    n.next = temp.next;
                    temp.next = n; 
                }
                System.out.println("sucessfully added :"+data);
            }
        }
    }

    public void addAftervalue(int data,int value){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            int flag = 0;
            Node dummy = first;
            do{
                if (dummy.data == value) {
                    flag = 1;
                }
                dummy= dummy.next;
            }while(dummy != first);
            if (flag == 0) {
                System.out.println("NO such found data");
            }else{
               Node n =  new Node(data);
               Node temp = first;
               while (temp.data != value) {
                    temp = temp.next;
               } 
               n.next = temp.next;
               temp.next = n;
               System.out.println("sucessfully added :"+data);
            }        
        }
    }
    public void deletefirst(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            if (first.next == first) {
                System.out.println("Deleted :"+first.data);
            }else{
                Node temp = first;
                while (temp.next != first) {
                    temp = temp.next;
                }
                temp.next = first.next;
                System.out.println("Deleted :"+first.data);
                first = first.next;
            }
        }
    }
    public void deletelast(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            if (first.next == first) {
                System.out.println("Deleted :"+first.data);
            }else{
                Node temp = first;
                while (temp.next.next != first) {
                    temp = temp.next;
                }
                System.out.println("Deleted :"+temp.next.data);
                temp.next = first;
            }
        }
    }

    public void deleteparticularvalue(int value){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else{
            int flag = 0;
            Node dummy = first;
            do{
                if (dummy.data == value) {
                    flag = 1;
                }
                dummy= dummy.next;
            }while(dummy != first);
            if (flag == 0) {
                System.out.println("NO such found data");
            }else{
                Node n = new Node(value);
                if (first.data == value && first == first.next) {
                    System.out.println("Deleted :"+first.data);
                }else if(first.data == value && first != first.next){
                    Node temp = first;
                    Node delete = first;
                    while (temp.next != first) {
                        temp = temp.next;
                    }
                    temp.next = first.next;
                    first = first.next;
                    delete.next = null;
                    System.out.println("Deleted :"+delete.data);
                }else{
                    Node temp = first;
                    while (temp.next.data != value) {
                        temp= temp.next;
                    }                   
                    temp.next = temp.next.next; 
                    System.out.println("Deleted :"+value);
                }
            }
        } 
    }

    public void displayoddPos(){
        Node temp = first;
        int c =1;
        do{
            if (c % 2 != 0) {
                System.out.print(temp.data+" ");
            }
            c++;
            temp = temp.next;
        }while(temp != first);
    }

    public void displayevenPos(){
        Node temp = first;
        int c =0;
        do{
            if (c % 2 != 0) {
                System.out.print(temp.data+" ");
            }
            c++;
            temp = temp.next;
        }while(temp != first);
    }

    public void displayevenvalue(){
        Node temp = first;
        do{
            if (temp.data % 2 == 0) {
                System.out.print(temp.data+" ");
            }
            temp = temp.next;
        }while(temp != first);
    }

    public void displayoddvalue(){
        Node temp = first;
        do{
            if (temp.data % 2 != 0) {
                System.out.print(temp.data+" ");
            }
            temp = temp.next;
        }while(temp != first);
    }

    public void odddelete(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }else if(first == first.next){
            first = null;
        }else{
            Node temp1 = first;
            first = first.next;
            Node temp2 = first;
            while(temp2.next != temp2 && temp2.next.next != temp1){
                temp2.next = temp2.next.next;
                temp2 = temp2.next;
            }
            temp2.next = first;
        }
    }

    public void evendelete(){
        if (first == null) {
            System.out.println("Linked list is empty");
        }
        Node temp = first;
        while (temp.next != first && temp.next.next != first) {
            temp.next = temp.next.next;
            temp = temp.next;
        }    
        temp.next = first;
    }

    public Node mergelist(Node first1,Node first2){
        if (first1 == null && first2 == null) {
            System.out.println("NO element found to merge");
            return null;
        }else if (first1 == null && first2 != null) {
            return first2;
        }else if (first1 != null && first2 == null) {
            return first1;
        }else if (first1.next == first1 && first2.next == first2) {
            first1.next = first2;
            first2.next = first1;
            return first1;
        }else{
            Node t1 = first1;
            Node t2 = first2;
            while (t1.next != first1) {
                t1 = t1.next;
            }
            t1.next = first2;
            while (t2.next != first2) {
                t2 =t2.next;
            }
            t2.next = first1;
            return first1;
        }
    }

    public int minValue(){
        if (first == null) {
            System.out.println("Linked list is empty");
            return -1;
        }else{
            int min = first.data;
            Node temp = first;
            do{
                if(temp.data < min)
                {
                    min = temp.data;
                }
                temp = temp.next;
            }while(temp != first);
            return min;
        }     
    }

    public int maxValue(){
        if (first == null) {
            System.out.println("Linked list is empty");
            return -1;
        }else{
            int max = first.data;
            Node temp = first;
            do{
                if(temp.data > max)
                {
                    max = temp.data;
                }
                temp = temp.next;
            }while(temp != first);
            return max;
        }     
    }

    public int middlevalue(){
        Node slow = first;
        Node fast = first;
        if (first == null) {
            System.out.println("Linked list is empty");
        }else if (first == first.next && first.next.next == first) {
            return first.data;
        }else{
            while(fast.next != first && fast.next.next != first){
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow.data;
    }
}
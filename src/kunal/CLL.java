package kunal;

public class CLL {
    private Node head;
    private Node tail;

    public void insert(int val)
    {
        Node node = new Node(val);
        if(head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            //node.next = head;
            tail = node;
        }
    }

    public void bubblesort()
    {
        Node temp = head;
        Node temp2 = head;

        while (temp!=null)
        {
            while (temp2.next!=null)
            {
                if(temp2.val > temp2.next.val)
                {
                    Node ptr=temp2.next;
                    temp2.next = ptr.next;
                    ptr.next= temp2;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    }

    public boolean hascycle()
    {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
    }

    public void loop()
    {
        tail.next = head.next.next.next;
    }
    public void noloop()
    {
        tail.next = null;
    }

    public int start()
    {
        Node fast = head;
        Node slow = head;
        int length=0;
        while(fast != null && fast.next!=null)
        {
            if(fast==slow)
            {
                length = cyclelength();
                break;
            }
        }
        Node f = head;
        Node s = head;
        while (length!=0)
        {
            s = s.next;
            length--;
        }
        while(f!=s)
        {
            f = f.next;
            s = s.next;
        }
        return s.val;
    }

    public int cyclelength()
    {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            int count = 0;
            if(fast==slow)
            {
                do {
                    slow = slow.next;
                    ++count;
                }
                while(slow != fast);
                return count;
            }
        }
        return -1;
    }

    public void print()
    {
        Node temp = head;
        do {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        while (temp.next != null);
        System.out.print("End");
    }

    public int mid()
    {
        Node temp1 = head;
        Node temp2 = head;
        while (temp2 !=null && temp2.next!=null) {
            temp2 = temp2.next.next;
            temp1 = temp1.next;
        }
        return temp1.val;
    }
}

    class Node
    {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

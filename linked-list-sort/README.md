# Linked list sort
give a single linked list, and sort the linked list, return the sorted linked list.
e.g.

'''

[1,3,7,20,-1]
[-,1,3,7,20]

'''


'''
public static  class  Node {
        public int value;
        public   Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node sort(Node head) {
        Node header = null;
        Node p = head;
        while(null != p) {
            if(null == header) {
                header = new Node(p.value);
            } else {
                //insert the value into the sorted linked node
                header = inserteInto(header,p.value);
            }
            p = p.next;
        }
        return header;
    }
    public static Node inserteInto(Node sortedHeader,int valueNew) {

        Node p = sortedHeader;
        Node header = p;
        Node insertHeader = null;
        while(null != p) {
            int v = p.value;
            if(valueNew >= v) { //insert a new node
                insertHeader = p;
            }
            p = p.next;
        }
        if (null != insertHeader) {
            Node nodeNew = new Node(valueNew);
            nodeNew.next = insertHeader.next;
            insertHeader.next = nodeNew;
        } else {
            Node nodeNew = new Node(valueNew);
            nodeNew.next = header;
            header = nodeNew;
        }


        return header;
    }

    public static void main( String[] args )
    {
        int[] a = new int[]{10,40,40,-3,-70,100};
        Node header = null;
        Node p = null;
        for (int i = 0; i < a.length; i++) {
            if (null == header) {
                header = new Node(a[i]);
                p = header;
            } else  {
                Node newNode = new Node(a[i]);
                p.next = newNode;
                p = newNode;
            }
        }
        Node sortedList = sort(header);
        while (null != sortedList) {
            System.out.print(" " + sortedList.value);
            sortedList = sortedList.next;
        }
        System.out.println("hello world");

}
'''

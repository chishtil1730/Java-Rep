class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T data){
        this.data=data;
    }

}


public class LinkedLL {

    static Node<String> head=null,temp=null;


    public static void main(String[] args) {
        String[] arr = {"12","djwoe","djss"};
        for(String i : arr){
            Node<String> node = new Node<>(i);
            if(head==null){
                head = node;
                temp=head;
            }else {
                temp.next = node;
                temp=node;
            }
        }

        temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

}

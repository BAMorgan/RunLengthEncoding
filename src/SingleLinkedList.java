public class SingleLinkedList {
    Node front = null;
    int count = 0;

    boolean isEmpty(){
        return front == null;
    }


    void add(char theData){

        /*
        check if LinkedList is empty and add
        a node if it is
         */
        if (front == null){

            front = new Node(theData);
            count++;

        } else {

            Node tempNode = front;

            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node(theData);

            count++;
        }
    }

    @Override
    public String toString(){
        StringBuilder contentsOfList = new StringBuilder();

        if (isEmpty()){
            return contentsOfList.append("Empty list").toString();
        } else {

            Node tempNode = front;

            while (tempNode != null) {
                contentsOfList.append(tempNode.data);
                tempNode = tempNode.next;
                if (tempNode != null){
                    contentsOfList.append("->");
                }
            }


        }
        return contentsOfList.toString();
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Node {
    Node next;

    char data;

    //blank constructor
    public Node(){
        next = null;
    }

    //constructor for data only
    public Node(char theData){
        data = theData;
        next = null;
    }

    //constructor for defining data and next node
    public Node(char theData, Node theNode){
        data = theData;
        next = theNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
}

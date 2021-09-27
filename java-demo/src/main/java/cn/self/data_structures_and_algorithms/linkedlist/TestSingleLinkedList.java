package cn.self.data_structures_and_algorithms.linkedlist;

public class TestSingleLinkedList {

    /**
     * 打印链表内容
     * @param head
     */
    public static void printNode(Node head) {
        while (head != null) {
            System.out.print("->" + head.getData());
            head = head.getNext();
        }
        System.out.println("\n===============================");
    }

    /**
     * 在单链表结尾插入新节点
     * @param head
     * @param newNode
     * @return
     */
    public static Node insertNodeTail(Node head, Node newNode) {
        if (head == null) {
            return newNode;
        }
        Node currNode = head;
        while (currNode.getNext() != null) {
            currNode = currNode.getNext();
        }
        currNode.setNext(newNode);
        return head;
    }

    /**
     * 在单链表指定位置插入新节点
     */


    /**
     * 单链表反转
     */
    public static Node reverseList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node preNode = null;
        Node currNode = head;
        Node nextNode = null;
        while (currNode != null) {
            nextNode = currNode.getNext();
            currNode.setNext(preNode);
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        System.out.println("原始数据：");
        printNode(n0);

        /**
         * Test1: insertNodeTail
         */
        Node n4 = new Node(4);
        Node test1 = insertNodeTail(n0, n4);
        System.out.println("增加4后数据：");
        printNode(test1);
        Node head = null;
        Node test11 = insertNodeTail(head, n4);
        System.out.println("空链表增加4后数据：");
        printNode(test11);
        /**
         * Test2：reverseList
         */
        Node test2 = reverseList(n0);
        System.out.println("反转后数据：");
        printNode(test2);
    }
}

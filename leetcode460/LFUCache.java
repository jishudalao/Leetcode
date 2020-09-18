package leetcode460;
import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    /**
     * key ������Ŀ�е� key
     * value �ǽ����
     */
    private Map<Integer, ListNode> map;

    /**
     * ���ʴ�����ϣ��ʹ�� ListNode[] Ҳ���ԣ�����Ҫռ�úܶ�ռ�
     */
    private Map<Integer, DoubleLinkedList> frequentMap;

    /**
     * �ⲿ�����������С
     */
    private Integer capacity;

    /**
     * ȫ����߷��ʴ�����ɾ������ʹ�÷��ʴ����Ľ��ʱ���õ��������ƿ���������ģ�
     */
    private Integer maxFrequent = 1;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        frequentMap = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * get һ�β��������ʴ��������� 1��
     * ��ԭ����������������ʴ������ߵ�����ı�ͷ
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // ���Բ�����ģ�capacity ���ܴ� 0
        if (capacity == 0) {
            return -1;
        }

        if (map.containsKey(key)) {
            // ��ý����
            ListNode listNode = removeListNode(key);

            // �ҽӵ��µķ��ʴ�����˫�������ͷ��
            int frequent = listNode.frequent;
            addListNode2Head(frequent, listNode);
            return listNode.value;
        } else {
            return -1;
        }
    }

    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // ��� key ���ڣ��͸��·��ʴ��� + 1������ֵ
        if (map.containsKey(key)) {
            ListNode listNode = removeListNode(key);

            // ���� value
            listNode.value = value;
            int frequent = listNode.frequent;
            addListNode2Head(frequent, listNode);
            return;
        }

        // ��� key ������
        // 1��������ˣ���ɾ�����ʴ�����С�ĵ�ĩβ��㣬��ɾ�� map ���Ӧ�� key
        if (map.size() == capacity) {
            for (int i = 1; i <= maxFrequent; i++) {
                if (frequentMap.containsKey(i) && frequentMap.get(i).count > 0) {
                    // 1����˫������ɾ�����
                    DoubleLinkedList doubleLinkedList = frequentMap.get(i);
                    ListNode removeNode = doubleLinkedList.removeTail();

                    // 2��ɾ�� map ���Ӧ�� key
                    map.remove(removeNode.key);
                    break;
                }
            }
        }

        // 2���ٴ����½����ڷ��ʴ���Ϊ 1 ��˫�������ǰ��
        ListNode newListNode = new ListNode(key, value);
        addListNode2Head(1, newListNode);
        map.put(key, newListNode);
    }

    // ���²�����Ҫ�ǽ�����˫������Ĳ���

    /**
     * ����࣬��˫���������ɲ���
     */
    private class ListNode {
        private int key;
        private int value;
        private int frequent = 1;
        private ListNode pre;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * ˫������
     */
    private class DoubleLinkedList {
        /**
         * ����ͷ��㣬����ǰ�����
         */
        private ListNode dummyHead;
        /**
         * ����β��㣬���޺�̽��
         */
        private ListNode dummyTail;

        /**
         * ��ǰ˫���������Ч�����
         */
        private int count;

        public DoubleLinkedList() {
            this.dummyHead = new ListNode(-1, -1);
            this.dummyTail = new ListNode(-1, -1);

            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            count = 0;
        }

        /**
         * ��һ���������ӵ�˫������Ŀ�ͷ��ͷ��������ʹ�����ݣ�
         *
         * @param addNode
         */
        public void addNode2Head(ListNode addNode) {
            ListNode oldHead = dummyHead.next;
            // ������ָ����
            dummyHead.next = addNode;
            oldHead.pre = addNode;
            // ����ǰ���ͺ��ָ��������
            addNode.pre = dummyHead;
            addNode.next = oldHead;
            count++;
        }

        /**
         * ��˫�������ĩβ���ɾ����β������ɵ����ݣ��ڻ�������ʱ����̭��
         *
         * @return
         */
        public ListNode removeTail() {
            ListNode oldTail = dummyTail.pre;
            ListNode newTail = oldTail.pre;

            // �����㽨������
            newTail.next = dummyTail;
            dummyTail.pre = newTail;

            // �������������ж�����
            oldTail.pre = null;
            oldTail.next = null;
            count--;
            return oldTail;
        }
    }


    /**
     * ��ԭ�����ʴ����Ľ�㣬��˫���������������
     *
     * @param key
     * @return
     */
    private ListNode removeListNode(int key) {
        // ��ý����
        ListNode deleteNode = map.get(key);

        ListNode preNode = deleteNode.pre;
        ListNode nextNode = deleteNode.next;
        // �����㽨������
        preNode.next = nextNode;
        nextNode.pre = preNode;
        // ɾ��ȥԭ�������������
        deleteNode.pre = null;
        deleteNode.next = null;

        // ά��˫��������
        frequentMap.get(deleteNode.frequent).count--;
        // ���ʴ����� 1
        deleteNode.frequent++;
        maxFrequent = Math.max(maxFrequent, deleteNode.frequent);

        return deleteNode;
    }


    /**
     * �ѽ����ڶ�Ӧ���ʴ�����˫�������ͷ��
     *
     * @param frequent
     * @param addNode
     */
    private void addListNode2Head(int frequent, ListNode addNode) {
        DoubleLinkedList doubleLinkedList;

        // ��������ڣ��ͳ�ʼ��
        if (frequentMap.containsKey(frequent)) {
            doubleLinkedList = frequentMap.get(frequent);
        } else {
            doubleLinkedList = new DoubleLinkedList();
        }

        // ��ӵ� DoubleLinkedList �ı�ͷ
        doubleLinkedList.addNode2Head(addNode);
        frequentMap.put(frequent, doubleLinkedList);
    }
}
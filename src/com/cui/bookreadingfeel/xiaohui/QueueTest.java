package com.cui.bookreadingfeel.xiaohui;

/**
 * @Desc:TODO
 * @author: Cui Pai
 * @date 2020/5/30 15:08
 * 循环队列
 * 当 （队尾下标+1）%数组长度 = 队头下标 时，队列满了。
 * 队尾指针指向的位置永远空出一位，所以队列最大容量比数组长度小1。
 */
public class QueueTest {
    public static void main(String[] args) throws Exception {
        QueueTest queueTest = new QueueTest(10);
        queueTest.enQueue(1);
        queueTest.enQueue(2);
        queueTest.enQueue(3);
        queueTest.enQueue(4);
        queueTest.enQueue(5);
        queueTest.enQueue(6);
        queueTest.enQueue(7);
        queueTest.enQueue(8);
        queueTest.enQueue(9);

        queueTest.deQueue();
        queueTest.deQueue();
        queueTest.deQueue();
        queueTest.deQueue();
        queueTest.deQueue();

        queueTest.enQueue(5);
        queueTest.enQueue(6);
        queueTest.enQueue(7);
        queueTest.enQueue(8);
        queueTest.enQueue(9);

        queueTest.output();
    }

    private int[] array;
    // 队列头
    private int front;
    // 队列尾
    private int rear;

    public QueueTest(int capacity) {
        array = new int[capacity];
    }

    public void enQueue(int i) throws Exception{
        // rear指向的是下一个
        //  当队空时：front=rear
        //  当队满时：front=rear 亦成立
        //  因此只凭等式front=rear无法判断队空还是队满。  有两种方法处理上述问题：
        //    （1）另设一个标志位以区别队列是空还是满。
        //    （2）少用一个元素空间，约定以“队列头指针front在队尾指针rear的下一个位置上”作为队列“满”状态的标志。即：
        //  队空时： front=rear
        //  队满时： (rear+1)%maxsize=front
        if ((rear+1) % array.length == front) {
            throw new Exception("队列已满");
        }
        array[rear] = i;
        // %array.length的意义，当添加数组的尾部元素后，rear变成了0。
        rear = (rear + 1) % array.length;
    }

    public int deQueue() throws Exception {
        if (front == rear) {
            throw new Exception("队列为null");
        }
        int i = array[front];
        front = (front + 1) % array.length;
        return i;
    }

    public void output() {
        for (int i=front; i!=rear; i=(i+1)%array.length) {
            System.out.println(array[i]);
        }
    }
}

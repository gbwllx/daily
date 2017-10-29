package book.silicon.other.part18objectorient;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

/**
 * description:
 * author: gubing.gb
 * date: 2017/10/26.
 */
public class M141BlockingQueue<T> {
    private LinkedList<T> list;
    private int limit;

    public M141BlockingQueue(int limit) {
        this.limit = limit;
        list = new LinkedList<T>();
    }

    public synchronized void put(T t) throws InterruptedException {
        while (list.size() == limit) {
            try {
                list.wait();
            } catch (InterruptedException e) {

            }
            list.add(t);
            if (list.size() > 0) { list.notifyAll(); }

        }
    }

    public synchronized T get() throws InterruptedException {
        while (list.size() == 0) {
            try {list.wait();} catch (InterruptedException e) {

            }
        }
        T t = list.pop();
        list.notifyAll();
        return t;
    }
}

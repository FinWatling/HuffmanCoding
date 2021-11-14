package huffman;

import huffman.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * A priority queue of @Node@ objects. Each node has an int as its label representing its frequency.
 * The queue should order objects in ascending order of frequency, i.e. lowest first.
 */
public class PQueue {

    private List<Node> queue;

    public PQueue() {
        queue = new ArrayList<>();
    }

    /**
     * Add a node to the queue. The new node should be inserted at the point where the frequency of next node is
     * greater than or equal to that of the new one.
     *
     * @param n The node to enqueue.
     */
    public void enqueue(Node n) {

        boolean completed = false;

        if (queue.isEmpty()) { //if the queue is empty simply add the node
            queue.add(n);
        } else {
            for (int i = 0; i < queue.size(); i++) { //otherwise, loop over the queue
                if (queue.get(i).getFreq() >= n.getFreq()) { //if the current node's freq is > or = to n's freq
                    queue.add(i, n);    //add the new node in the current position. (ArrayList shifts other nodes along)
                    completed = true;  //set completed to true
                    break;
                }
            }
            if (!completed) {
                queue.add(queue.size(), n); //if not completed add node to end of queue (in case of null entries? check with jim)
            }
        }

    }

    /**
     * Remove a node from the queue.
     *
     * @return The first node in the queue.
     */
    public Node dequeue() {

        return queue.isEmpty() ? null : queue.remove(0);
        //if the queue is empty return null otherwise remove index 0


    }

    /**
     * Return the size of the queue.
     *
     * @return Size of the queue.
     */
    public int size() {

        return queue.size();

    }
}

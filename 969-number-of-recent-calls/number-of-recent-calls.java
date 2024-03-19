import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the current request time
        requests.offer(t);

        // Remove requests older than 3000 milliseconds
        while (requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the size of the queue, which represents the number of requests in the time frame
        return requests.size();
    }
}


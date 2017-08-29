package stackQueue;

import java.util.LinkedList;

/**
 * Created by einez on 8/8/2017.
 */
public class GenMaxArrOfWindow {
    public static <T extends Comparable<T>> T[] genMaxArrOfWindow(T[] originArray, int windowSize, T[] ret) {
        if (originArray.length < windowSize)
            return null;
        LinkedList<T> queue = new LinkedList<>();
        for (int i = 0; i < originArray.length; i++) {
            while (!queue.isEmpty() && queue.getLast().compareTo(originArray[i]) < 0)
                queue.removeLast();
            queue.offer(originArray[i]);
            if (i >= windowSize - 1)
                ret[i - windowSize + 1] = queue.peekFirst();
        }
        return ret;
    }
}

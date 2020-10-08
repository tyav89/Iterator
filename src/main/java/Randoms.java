import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int value;
    private int min;
    private int max;

    public Randoms(int min, int max) {
        this.random = new Random();
        this.min = min;
        this.max = max;

    }

    public int getValue() {
        return min + random.nextInt(max - min + 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomsIterator(this);
    }

    private static class RandomsIterator implements Iterator<Integer> {
        protected Randoms randoms;

        public RandomsIterator(Randoms randoms) {
            this.randoms = randoms;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return randoms.getValue();
        }
    }
}

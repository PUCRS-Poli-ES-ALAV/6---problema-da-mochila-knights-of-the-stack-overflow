public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void startCount() {
        count = 0;
    }

    public void addCount(int n) {
        count += n;
    }

    public int getCount() {
        return count;
    }
}

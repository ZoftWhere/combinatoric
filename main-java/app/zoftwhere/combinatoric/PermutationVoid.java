package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

class PermutationVoid extends PermutationBasic<Void> {

    private final int size;

    private final int[] index;

    private final int kSize;

    PermutationVoid(int[] index, int kSize) {
        super(index, null, kSize);
        this.index = index;
        this.size = index.length;
        this.kSize = kSize;
    }

    @Override
    protected Permutation<Void> newInstance(int[] index, List<Void> list, int kSize) {
        return new PermutationVoid(index, kSize);
    }

    @Override
    public List<Void> value() {
        throw new NoSuchElementException();
    }

    @Override
    public Void value(int position) {
        throw new NoSuchElementException();
    }

    @Override
    public Permutation<Void> next() {
        return super.next();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(String.format("%d", index[0]));
        for (int i = 1; i < kSize; i++) {
            builder.append(String.format(", %d", index[i]));
        }
        if (kSize < size) {
            builder.append(String.format("][%d", index[kSize]));
        }
        for (int i = kSize + 1; i < size; i++) {
            builder.append(String.format(", %d", index[i]));
        }

        return builder.append("]").toString();
    }

}

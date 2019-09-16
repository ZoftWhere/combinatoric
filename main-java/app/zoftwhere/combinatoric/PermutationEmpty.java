package app.zoftwhere.combinatoric;

import java.util.List;
import java.util.NoSuchElementException;

class PermutationEmpty<T> extends AbstractPermutation<T> {

    PermutationEmpty() {
        super(new int[0]);
    }

    @Override
    public int[] getIndex() {
        return new int[0];
    }

    @Override
    public int getIndex(int position) {
        throw new NoSuchElementException();
    }

    @Override
    public List<T> getValue() {
        return null;
    }

    @Override
    public T getValue(int position) {
        throw new NoSuchElementException();
    }

    @Override
    public AbstractPermutation<T> next(int position) {
        throw new NoSuchElementException();
    }

}

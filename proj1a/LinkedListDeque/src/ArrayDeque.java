public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextfirst;
    private int nextlast;
    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextfirst = 0;
        nextlast = 1;
        size =0;
    }
    private int addone(int a){
        return (a+1)%items.length;
    }
    private int subone(int a){
        return (a-1+items.length)%items.length;
    }
    private void resize(int length){
        T[] newitems = (T[])new Object[length];
        int oldindex = addone(nextfirst);
        for(int i =0;i<items.length;i++){
            newitems[i] = items[oldindex];
            oldindex = addone(oldindex);
        }
        this.items = newitems;
        nextfirst = items.length-1;
        nextlast = size;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextfirst] = item;
        nextfirst = subone(nextfirst);
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextlast] = item;
        nextlast = addone(nextlast);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = addone(nextfirst);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = addone(i);
        }
    }

    public T removeFirst() {
        if(size == 0){
            return null;
        }
        T a = items[addone(nextfirst)];
        items[addone(nextfirst)] = null;
        nextfirst = addone(nextfirst);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    public T removeLast() {
        if(size == 0){
            return null;
        }
        T a = items[subone(nextlast)];
        items[subone(nextlast)] = null;
        nextlast = subone(nextlast);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

    /**
     * (start + index) % items.length
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = addone(nextfirst);
        return items[(start + index) % items.length];
    }
}

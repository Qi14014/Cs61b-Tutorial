public class LinkedListDeque<T>{
    private class ItemNode {
        private final T item;
        private ItemNode pre;
        private ItemNode next;

        public ItemNode(T item, ItemNode pre, ItemNode next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    private ItemNode sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new ItemNode(null,null,null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void addFirst(T item){
        sentinel.next.pre = new ItemNode(item,sentinel,sentinel.next);
        sentinel.next = sentinel.next.pre;
        size += 1;
    }
    public void addLast(T item){
        sentinel.pre = new ItemNode(item,sentinel.pre,sentinel);
        sentinel.pre.pre.next = sentinel.pre;
        size += 1;
    }
    public boolean isEmpty(){
        return this.sentinel.next != sentinel;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        ItemNode p = sentinel.next;
        for(int i=0;i<size;i++){
            System.out.print(p.item+" ");
            p = p.next;
        }
    }
    public T removeFirst(){
        ItemNode a = sentinel.next;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        return a.item;
    }
    public T removeLast(){
        ItemNode a = sentinel.pre;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        return a.item;
    }
    public T get(int index){
        if(index+1 > size()){
            return null;
        }
        ItemNode a = sentinel.next;
        for(int i =0;i<index;i++){
            a = a.next;
        }
        return a.item;
    }
    public static void main(String[] args){
        LinkedListDeque<Integer> p = new LinkedListDeque<Integer>();
        p.addFirst(1);
        p.addFirst(2);
        p.addLast(3);
        p.printDeque();
    }
}
public class LinkedListDeque<T>{
    class element{/*类定义*/
        T label;
        element pre;
        element next;
        private element(T label,element pre,element next){
            this.label = label;
            this.pre = pre;
            this.next = next;
        }
    }
    element last;
    element first;
    int length = 0;
    public LinkedListDeque() {
        last = new element(null, null, null);
        first = new element(null, null, last);
        last.pre = first;
    }



    public void addFirst(T item){
        element x = new element(item,first,first.next);
        first.next.pre = x;
        first.next = x;
        length += 1;
    }
    public void addLast(T item){
        element x = new element(item,last.pre,last);
        last.pre.next = x;
        last.pre = x;
        length += 1;
    }
    public boolean isEmpty(){
        return first.next == last;
    }
    public int size(){
        return length;
    }
    public void printDeque(){
        for(element i = first.next;i.next != last;i = i.next){
            System.out.print(i.label+" ");
        }
        System.out.print(last.pre.label+"");
    }
    public T removeFirst(){
        element x = first.next;
        if(first.next != last) {
            first.next.next.pre = first;
            first.next = first.next.next;
            return x.label;
        }else{
            return null;
        }
    }
    public T removeLast(){
        element x = last.pre;
        if(first != last){
            last.pre.pre.next = last;
            last.pre = last.pre.pre;
            return x.label;
        }else{
            return null;
        }
    }
    public T get(int index){
        LinkedListDeque<T> x = this;
        if(first.next == last){
            return null;
        }
        if(index != 0){
            x.first =x.first.next;
            return get(index-1);
        }else{
            return x.first.label;
        }
    }
    public T getPecursive(int index){
        LinkedListDeque<T> x = this;
        while(index != 0){
            x.first = x.first.next;
            index -= 1;
        }
        return x.first.label;
    }
    public static void main(String[] args){
        System.out.print("hello,world");
        LinkedListDeque<String> a = new LinkedListDeque<String>();
        a.addFirst("ab");
        a.addLast("cd");
        System.out.print(a.first.next.label);
        System.out.print(a.last.pre.label);
        System.out.print(a.isEmpty());
        System.out.printf("%d",a.size());
        a.printDeque();
    }
}
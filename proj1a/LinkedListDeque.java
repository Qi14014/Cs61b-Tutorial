class LinkedListDeque<T>{
    class element{
        T label;
        element pre;
        element next;
    }
    element first;
    element last;
        
    public void addFirst(T item){
        element x = new element();
        if(first == null){
            first = x;
            last = x;
        }else{
            x.next = first;
            first.pre = x;
            first = x;
        }
    }
    public static void main(String[] args){
        System.out.print("hello,world");
        LinkedListDeque<String> a = new LinkedListDeque<String>();
        a.addFirst("a");
    }
}
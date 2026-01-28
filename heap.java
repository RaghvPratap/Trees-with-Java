public class heap {
    public static class MinHeap{
        int[] arr;
        int size;
        MinHeap(int capacity){
            arr=new int[capacity];
            size=0;
        }
        public void add(int x){
            if(size==arr.length) System.out.println("Heap is Full");
            arr[size++]=x;
            upheapify(size-1);
        }
        public int remove() throws Exception{
               if(size==0) throw new Exception("Heap is Empty");
               int peek=arr[0];
               swap(0,size-1);
               downHeapify(0);
               return peek;
        }
        public void downHeapify(int i){
            int lc=2*i+1,rc=2*i+2;
            int minIdx=i;
          
            if(lc<size && arr[lc]<arr[minIdx]) minIdx=lc;
           
            if(rc<size && arr[rc]<arr[minIdx]) minIdx=rc;
            if(i==minIdx) return;
            swap(i,minIdx);
            downHeapify(minIdx);
        }
        public void upheapify(int idx){
            if(idx==0) return;
            int parent=(idx-1)/2;
            swap(idx,parent);
            upheapify(parent);
        }
        public void swap(int x,int y){
            int temp=arr[x];
            arr[x]=arr[y];
            arr[y]=temp;
        }
        public int size(){
            return size;
        }
        public int peek() throws Exception{
            if(size==0) throw new Exception("Heap is Empty");
            else return arr[0];
        }
    }
    public static void main(String[] args) {
        MinHeap pq=new MinHeap(10);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        System.out.println(pq.size());
    }
}

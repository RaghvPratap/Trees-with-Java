class solution{
  int[] p;
  int[] size;
  public void init(int n){
    p=new int[n];
    size=new int[n];
    for(int i=0;i<n;i++){
      p[i]=i;
      size[i]=1;
    }    
  }
  public int find(int n){
    if(p[x]!=x){
      p[x]=find(x);
    }
    return p[x];
  }
  public void union(int a,int b){
    int pa=find(a);
    int pb=find(b);
    if(pa==pb) return;
    if(size[a]>=size[b]){
      p[pb]=pa;
      size[pa]+=size[pb];
    }else{
      p[pa]=pb;
      size[pb]+=size[pa];
    }
  }
}

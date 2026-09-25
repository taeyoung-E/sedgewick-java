package union_find;

public class UnionFind{
    private int[] sites;
    private int count;

    public UnionFind(int size){
        this.sites = new int[size];
        this.count = size;

        for(int i = 0; i < sites.length; i++){
            sites[i] = i;
        }
    }

    public boolean isConnected(int val1, int val2){
        return find(val1) == find(val2);
    }

    private int find(int value){
        return sites[value];
    }

    private int find(int value, boolean flag){
        while(value != sites[value]) value = sites[value];
        return value;
    }

    //Quick Find implementation
    /*
    (N + 3) To read and write once because of find and write operation
    (N - 1) Assuming that we want to union all the components that are single, n - 1

    Therefore Quadratic time
    (N + 2)(N - 1)
     */
    public void union(int arg1, int arg2){ //Subtract the count value by 1 afterwards
        int pId = find(arg1);
        int qID = find(arg2);

        if(find(arg1) == find(arg2))
            return;

        for(int i = 0; i < sites.length; i++){
            if(sites[i] == pId) sites[i] = qID;
        }
        --count;
    }



    public void unionQuickFind(int arg1, int arg2){
        int pId = find(arg1,true);
        int qId = find(arg2,true);

        if(pId == qId) return;

        sites[pId] = qId;
        count--;

    }

}

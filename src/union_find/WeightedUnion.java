package union_find;

/**
 * Implement Path Compression
 * Skipping to grandparent right away
 *
 * Or use the 2nd loop to iterate again to point to parent directly making the tree flat
 */

public class WeightedUnion {
    int[] sites;
    int[] size;
    int count;

    public WeightedUnion(int N){
        this.sites = new int[N];
        this.size = new int[N];
        this.count = N;

        for(int i = 0; i < sites.length; i++){
            sites[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        while(p != sites[p]) p = sites[p];
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int pid = find(p);
        int qid = find(q);

        if(pid == qid) return;

        if(size[pid] <= size[qid]){
            sites[pid] = qid;
            size[qid] += size[pid];
        }
        else{
            sites[qid] = pid;
            size[pid] += size[qid];
        }
        count--;
    }
}

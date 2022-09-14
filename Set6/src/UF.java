import java.util.Comparator;

class UF {
    int[] parent, size;  // parent[i] = parent of i
    int count;           // number of components
    public UF(int n) {
        count = n;  parent = new int[n];   size = new int[n];
        for (int i = 0; i < n; i++) { parent[i] = i;  size[i] = 1; }
    }
    public UF(UF x) {
        this.count = x.count;  this.parent = x.parent.clone();   this.size = x.size;
    }
    public int find(int p) {
        while (p!=parent[p]) { parent[p]=parent[parent[p]]; p=parent[p]; }
        return p;
    }
    public void union(int p, int q) {
        int a = find(p), b = find(q);
        if (a == b) return;
        if      (size[a] <= size[b]) { parent[a]=b; size[b]+= size[a]; }
        else  { parent[b] = a;  size[a]+=size[b]; }
        count--;
    }
    
}

class Edge1 {
    int val;
    int node1;
    int node2;

    public Edge1(int val, int node1, int node2) {
        this.val = val;
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public int getVal() {
        return val;
    }
}

class EdgeComparator implements Comparator<Edge1> {

    public int compare(Edge1 e1, Edge1 e2) {
        if (e1.val > e2.val)
            return 1;
        else if (e1.val < e2.val)
            return -1;
        return 0;
    }
}

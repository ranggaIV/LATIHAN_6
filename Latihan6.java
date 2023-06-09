    import java.util.*;

class Graph {
    private int V; // Jumlah node dalam graf
    private LinkedList<Integer>[] adjacencyList; // Daftar ketetanggaan

    // Konstruktor
    Graph(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList();
    }

    // Menambahkan edge ke graf
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // Metode utama untuk melakukan BFS traversal
    void BFS(int start) {
        // Array untuk melacak node yang sudah dikunjungi
        boolean[] visited = new boolean[V];

        // Membuat antrian untuk BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Menandai node awal sebagai sudah dikunjungi dan dimasukkan ke antrian
        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            // Menghapus node dari antrian dan mencetaknya
            start = queue.poll();
            System.out.print(start + " ");

            // Mendapatkan semua node tetangga dari node saat ini
            Iterator<Integer> i = adjacencyList[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                // Jika node belum dikunjungi, maka ditandai sebagai dikunjungi dan dimasukkan ke antrian
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Contoh penggunaan
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);

        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(0);
    }
}
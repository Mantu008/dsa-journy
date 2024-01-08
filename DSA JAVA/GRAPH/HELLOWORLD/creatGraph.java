import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class creatGraph {
   static int v = 0;
   static int e = 0;
   static ArrayList<ArrayList<Integer>> adj;

   public static void main(String[] args) {
      v = 5;
      adj = new ArrayList<>();
      for (int i = 0; i < v; i++) {
         adj.add(new ArrayList<>());
      }
      addEdge(adj, 0, 1);
      addEdge(adj, 0, 2);
      addEdge(adj, 1, 2);
      addEdge(adj, 1, 3);
      addEdge(adj, 2, 3);
      addEdge(adj, 2, 4);
      addEdge(adj, 3, 4);

      Display();

      // bfs traversal
      ArrayList<Integer> bfsList = new ArrayList<>();
      BFS(adj, bfsList, v, 0);
      System.out.println(bfsList);

   }

   public static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest) {
      adj.get(source).add(dest);
      adj.get(dest).add(source);
   }

   public static void Display() {
      for (int i = 0; i < v; i++) {
         System.out.print("Vertex " + i + ": ");
         for (int list : adj.get(i)) {
            System.out.print(list + " ");
         }
         System.out.println();
      }
   }

   public static void BFS(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> bfsList, int v, int sourse) {
      boolean visited[] = new boolean[v];
      Queue<Integer> q = new ArrayDeque<>();
      visited[sourse] = true;
      q.offer(sourse);

      while (!q.isEmpty()) {
         int top = q.peek();
         q.poll();
         bfsList.add(top);

         for (int l : adj.get(top)) {
            if (visited[l] == false) {
               visited[l] = true;
               q.offer(l);
            }
         }
      }
   }

}

package Lab10;

public class graph{ // A utility function to find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tree
	static final int maxPath = 10; 
	private static int top = 0;// it wants be be acsessed from anywhere
	//static int acount =0;

	int minDistance(int dist[], Boolean set[]) { // Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int a = 0; a < maxPath; a++)
			if (set[a] == false && dist[a] <= min) {
				min = dist[a];
				min_index = a;
			}

		return min_index;
	}

	// A utility function to print the constructed distance array
	void findSolution(int dist[], int n) {
		for (int i = 0; i < maxPath; i++){
			if(dist[i]>top)
			{
				top =dist[i];
			}
		}
	}

	// Function that implements Dijkstra's algorithm for a graph represented using adjacency matrix representation
	void dijkstra(int graph[][], int src) {
		int dist[] = new int[maxPath]; // The output array. dist[i] will hold the shortest distance from src to i

		// set[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		
		Boolean set[] = new Boolean[maxPath];

		// Initialize all distances as INFINITE and set[] as false
		for (int i = 0; i < maxPath; i++) {
			dist[i] = Integer.MAX_VALUE;
			set[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < maxPath - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices not yet processed. u is always equal to src in first iteration.
			int u = minDistance(dist, set);
			//acount+=1;

			// Mark the picked vertex as processed
			set[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int a = 0; a < maxPath; a++)

				// Update dist[a] only if is not in set, there is an
				// edge from u to a, and total weight of path from src to
				// a through u is smaller than current value of dist[a]
				if (!set[a] && graph[u][a] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][a] < dist[a])
					dist[a] = dist[u] + graph[u][a];
		}

		// print the constructed distance array
		findSolution(dist, maxPath);
	}

	// Driver method for path values 
	public static void main(String[] args) {
		 
		int graph[][] = new int[][] { { 0, 4, 0, 3, 0, 0, 6, 0, 0, 0 }, 
									  { 4, 0, 2, 0, 9, 0, 0, 0, 3, 0 },
									  { 0, 2,0, 7, 0, 0,7, 0, 0, 9 }, 
									  { 3, 0, 7, 0, 0, 8, 0, 4, 2, 0 }, 
									  { 0, 9, 0, 0, 0, 0, 8, 0, 0, 0 },
									  { 0, 0, 0, 8, 0, 0, 4, 0, 5, 0 },
									  { 6, 0, 7, 0, 8, 4, 0, 0, 0, 0 }, 
									  { 0, 0, 0, 4, 0, 0, 0, 0, 7, 0 },
									  {0, 3, 0, 2, 0, 5, 0, 7, 0, 0 }, 
									  {0, 0, 9, 0, 0, 0, 0, 0, 0, 0 } 
									  };
		graph t = new graph();
		for(int i =0;i<maxPath;i++)
		{
		t.dijkstra(graph, i);
		}
		System.out.println("Longest path found is EBCJ and it has a length of: " +top);
	}
}

package Graph;

import java.util.*;

public class BuildOrder {

    void buildUtil(int v, boolean visited[], Stack stack, Graph g) {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = g.adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                buildUtil(i, visited, stack, g);
        }

        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }

    // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
    void build(Graph graph, int V) {
        Stack stack = new Stack();

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                buildUtil(i, visited, stack , graph);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]) {
        BuildOrder buildOrder = new BuildOrder();

        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        buildOrder.build(g, g.size());
    }

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        public Graph(int V){
            this.V = V;
            adj = new LinkedList[V];
            for(int i=0; i<V; i++){
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v){
            adj[u].add(v);
        }

        public int size(){
            return V;
        }
    }
}
/**
 * O(P+D) time (P - projects, D - dependencies)
 * Nodes with no incoming edges can be built immediately
 *
 *    f
 *  / | \		d
 * c  |  b 	    |
 *  \ | /|		g
 *    a  |
 *    |  /
 *    | /
 *    e
 *
 * 1. Add the nodes with no incoming edges.
 *	  If the set of projects can b ebuilt, there must be some "first" project,
 *	  and that project can't have any dependencies. If a project has no dependencies
 * 	  (incoming edges), then we can't break anything by building it first
 *
 * 2. We removed all outgoing edges from these roots. Once those root projects were built
 *	  it doesn't matter if another project depends on them.
 *
 * 3. We found nodes that now have no incoming edges. Using the same logic from steps 1 and 2
 *	  It's okay to build these, find nodes with no dependencies, add them to build order
 * 	  remove their outgoing edges, and repeat
 *
 * 4. What if there are nodes remaining, but all have dependencies (incoming edges)?
 *	  This means there's no way to build the system. We should return an error
 *
 *
 * 1. Build a graph where each project is a node and its outgoing edges
 * represent the projects that depend on it. That is, if A has an edge to B
 * (A->B), it means B has a dependency on A and therefore A must be built before B.
 * Each node also tracks the # of incoming edges
 *
 * 2. Initialize a buildOrder array. Once we determine a project's build order, we add it to the array.
 * We also continue to iterate through the array, using a toBeProcessed pointer to
 * point to the next node to be fully processed.
 *
 * 3. Find all the nodes with 0 incoming edges and add them to a buildOrder array.
 * Set a toBeProcessed pointer to the beginning of the array.
 *
 * Repeat until toBeProcessed is at the end of the buildOrder
 *
 * 1. Read node toBeProcessed.
 *  >> If node == null, then all remaining nodes have a dependency and we have detected a cycle
 * 2. For each child of node:
 *  >> decrement child.dependencies (# of incoming edges)
 *  >> if child.dependencies is 0, add child to end of buildOrder
 *
 */


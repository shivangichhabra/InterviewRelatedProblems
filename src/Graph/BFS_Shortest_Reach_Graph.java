package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Shivangi on 7/29/2017.
 * Consider an undirected graph consisting of  nodes where each node is labeled from  to and the edge between any two
 * nodes is always of length . We define node  to be the starting position for a BFS.
 *
 * Given  queries in the form of a graph and some starting node, , perform each query by calculating the shortest
 * distance from starting node  to all the other nodes in the graph. Then print a single line of n-1 space-separated
 * integers listing node 's shortest distance to each of the  other nodes (ordered sequentially by node number); if  is
 * disconnected from a node, print  -1 as the distance to that node.
 *
 * Input Format
 *
 * The first line contains an integer, q, denoting the number of queries. The subsequent lines describe each query in the
 * following format:
 * The first line contains two space-separated integers describing the respective values of n (the number of nodes) and
 * m (the number of edges) in the graph.
 * Each line i of the m subsequent lines contains two space-separated integers,  and , describing an edge connecting node
 * u to node  v.
 * The last line contains a single integer, s, denoting the index of the starting node.
 *
 * Output Format
 * For each of the  queries, print a single line of  space-separated integers denoting the shortest distances to each of
 * the  other nodes from starting position . These distances should be listed sequentially by node number (i.e., ), but
 * should not include node . If some node is unreachable from , print  as the distance to that node.
 *
 * Sample Input
 * 2
 * 4 2
 * 1 2
 * 1 3
 * 1
 * 3 1
 * 2 3
 * 2
 *
 * Sample Output
 * 6 6 -1
 * -1 6
 */
public class BFS_Shortest_Reach_Graph {
    static final int EDGE_DISTANCE = 6;

    static class Node{
        int data;
        int distance = -1;
        List<Integer> adjacentList = new LinkedList<>();

        public Node(int d){
            data = d;
        }
    }

    public void calculate(Node[] nodes, int start){
        Queue<Node> queue = new LinkedList<>();
        nodes[start].distance = 0;
        queue.add(nodes[start]);
        while(!queue.isEmpty()){
            Node top = queue.poll();
            for(int adj : top.adjacentList){
                if(nodes[adj].distance < 0){
                    nodes[adj].distance =  top.distance + EDGE_DISTANCE;
                    queue.offer(nodes[adj]);
                }
            }
        }
    }

    public static void main(String args[]){
        BFS_Shortest_Reach_Graph bfs = new BFS_Shortest_Reach_Graph();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i=0; i<q; i++){
            int n = sc.nextInt();
            Node[] nodes = new Node[n];
            for(int j=0; j<n; j++){
                nodes[j] = new Node(j);
            }

            int m = sc.nextInt();
            for(int k=0; k<m; k++){
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;

                nodes[u].adjacentList.add(v);
                nodes[v].adjacentList.add(u);
            }

            int start = sc.nextInt() - 1;
            bfs.calculate(nodes, start);

            System.out.println(String.join(" ", IntStream.range(0, nodes.length).filter(index -> index != start).mapToObj(index -> String.valueOf(nodes[index].distance)).collect(Collectors.toList())));
        }
    }
}

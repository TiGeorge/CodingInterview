package datastructures.graphs;

import datastructures.stacks.StackX;

import java.util.Arrays;

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // Массив вершин
    private int[][] adjMat; // Матрица смежности
    private int nVerts; // Тек. кол-во вершин
    private StackX theStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int[] i : adjMat) {
            Arrays.fill(i, 0);
        }
        theStack = new StackX(MAX_VERTS);
    }

    public void addVertex(char lable) {
        vertexList[nVerts++] = new Vertex(lable);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].lable);
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            Vertex current = vertexList[i];
            if (adjMat[v][i] == 1 && !current.wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void dfs() {
        theStack.push(0);
        vertexList[0].wasVisited = true;
        displayVertex(0);

        while (!theStack.isEmpty()) {
            int adj = getAdjUnvisitedVertex(theStack.peek());
            if (adj != -1) {
                vertexList[adj].wasVisited = true;
                displayVertex(adj);
                theStack.push(adj);
            } else {
                theStack.pop();
            }
        }
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');    // 0
        theGraph.addVertex('B');    // 1
        theGraph.addVertex('C');    // 2
        theGraph.addVertex('D');    // 3
        theGraph.addVertex('E');    // 4
        theGraph.addEdge(0, 1);     // AB
        theGraph.addEdge(1, 2);     // BC
        theGraph.addEdge(0, 3);     // AD
        theGraph.addEdge(3, 4);     // DE

        System.out.print("Visits: ");
        theGraph.dfs();             // Обход в глубину
        System.out.println();
    }
}

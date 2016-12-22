package book.javaalg.part15;

import java.util.PriorityQueue;


//TODO:


public class Graph {
	
	private final int MAX_VERTS = 20;
	private final int INFINITY = Integer.MAX_VALUE;
	//顶点
	private Vertex vertexList[];
	//邻接矩阵
	private int adjMat[][];
	private int nVerts;
	private int currentVert;
	private PriorityQueue<Edge> pq;
	private int nTree;
	
	public Graph(){
		this.vertexList = new Vertex[MAX_VERTS];
		this.adjMat = new int[MAX_VERTS][MAX_VERTS];
		
		nVerts = 0;
		for(int j = 0; j < MAX_VERTS; j++)
			for(int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = INFINITY;
		pq = new PriorityQueue<Edge>();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	//最小生成树算法
	public void mstw(){
		currentVert = 0;
		
		while(nTree < nVerts - 1){
			vertexList[currentVert].isInTree = true;
			nTree++;
			
			for(int j = 0; j < nVerts; j++){
				if(j == currentVert) continue;
				if(vertexList[j].isInTree) continue;
				int distance = adjMat[currentVert][j];
				if(distance == INFINITY) continue;
				putInPQ(j, distance);
			}
				
			if(pq.size() == 0){
				System.out.println("GRAPH NOT CONNECTED");
				return;
			}
			
			Edge edge = pq.remove();
			int sourceVert = edge.srcVert;
			currentVert = edge.destVert;
			
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			System.out.print(" ");
		}
		
		for(int j = 0; j < nVerts; j++){
			vertexList[j].isInTree = false;
		}
	}
	
	private void putInPQ(int newVert, int distance) {
		//int queueIndex = 
	}

	//最短路径算法
	public void dijkstra(){
		
	}
	
	public static void main(String[] args){
		char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
		int[][] edge = new int[][]{
				{-1, 4, 3, 5, -1, -1},
				{4, -1, -1, 8, 9, -1},
				{3, -1, -1, 10, -1, -1},
				{5, 8, 10, -1, 11, -1},
				{-1, 9, -1, 11, -1, 7},
				{-1, -1, -1, 8, 7, -1}};
		Graph g = new Graph();
		
	}
}

class Vertex {
	public char[] label;
	public int data;
	public boolean isInTree = false;
	
	public Vertex(int data){
		this.data = data;
	}
}

class Edge {
	public int destVert;
	public int srcVert;

}



package Maze;

public class Main {
	
	public static void main(String[] args) {
		
		int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
		
		
//		BFS b = new BFS();
//		b.bfs(maze);
		
		DFS d = new DFS();
		d.dfs(maze, 0, 0);
		d.printPath();
		
	}
	
}

class Coordinate {
	int x;
	int y;
	int step;
	
	public Coordinate(int x, int y, int step) {
		super();
		this.x = x;
		this.y = y;
		this.step = step;
	}
}
package Maze;


public class DFS {
	
	private String path = "";
	private String bestpath;
	private int count = 1;

	public void dfs(int[][] maze, int x, int y) {
				
		// 越界或者撞墙
		if (x < 0 || y < 0 || x > maze.length - 1 || y > maze[0].length - 1 || maze[x][y] == 1)
			return;
		
		if (x == maze.length - 1 && y == maze[0].length - 1) {
			path += "(" + x + ", " + y + ")";
			if (bestpath == null || bestpath.length() > path.length()) {
				bestpath = path;
			}
			System.out.println("Find path " + count + ": " + bestpath);
			count++;
			return;
		}
		
		String temp = path;
		path += "(" + x + ", " + y + ")";
		
		maze[x][y] = 1;
		dfs(maze, x - 1, y);
		dfs(maze, x + 1, y);
		dfs(maze, x, y - 1);
		dfs(maze, x, y + 1);
		maze[x][y] = 0;
		
		path = temp;
	}
	
	public void printPath() {
		System.out.println("The shortest path: " + bestpath);
	}
	
}

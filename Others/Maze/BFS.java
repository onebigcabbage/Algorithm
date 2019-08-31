package Maze;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public void bfs(int[][] maze) {
		
		int[][] dis = new int[maze.length][maze[0].length];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		queue.add(new Coordinate(0, 0, 0));
		dis[0][0] = 1;
		while (!queue.isEmpty()) {
			Coordinate point = queue.poll();
			if (point.x == maze.length - 1 && point.y == maze[0].length - 1) {
				System.out.println(point.step + 1);
				break;
			}
			
//			int x = point.x;
//			int y = point.y;
//			int step1 = point.step;
//			dis[x][y] = 1;
//			
//			if (x - 1 >= 0 && maze[x - 1][y] != 1 && dis[x - 1][y] == 0) {
//				queue.add(new Coordinate(x - 1, y, step1 + 1));
//			}
//			if (x + 1 < maze.length && maze[x + 1][y] != 1 && dis[x + 1][y] == 0) {
//				queue.add(new Coordinate(x + 1, y, step1 + 1));
//			}
//			if (y - 1 >= 0 && maze[x][y - 1] != 1 && dis[x][y - 1] == 0) {
//				queue.add(new Coordinate(x, y - 1, step1 + 1));
//			}
//			if (y + 1 < maze[0].length && maze[x][y + 1] != 1 && dis[x][y + 1] == 0) {
//				queue.add(new Coordinate(x, y + 1, step1 + 1));
//			}
			
			for (int i = 0; i < 4; i++) {
				int x = point.x + dx[i];
				int y = point.y + dy[i];
				int step1 = point.step;
				if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1 && dis[x][y] == 0) {
					queue.add(new Coordinate(x, y, step1 + 1));
					dis[x][y] = 1;
				}
				
			}
		}
	}

}



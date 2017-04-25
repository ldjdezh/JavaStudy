package com.game.map;

public class Map {
	private byte[][] map;

	public Map(int row, int col, byte[][] temp) {
		map = new byte[row][col];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				map[i][j] = temp[i][j];
	}

	public byte[][] getMap() {
		return map;
	}

}

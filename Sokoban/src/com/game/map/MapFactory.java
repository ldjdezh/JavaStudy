package com.game.map;

public class MapFactory {
	private static byte map[][][]={
			{
			{ 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 1, 4, 1, 0, 0, 0 },
			{ 0, 0, 1, 9, 1, 1, 1, 1 },
			{ 1, 1, 1, 2, 9, 2, 4, 1 },
			{ 1, 4, 9, 2, 5, 1, 1, 1 },
			{ 1, 1, 1, 1, 2, 1, 0, 0 },
			{ 0, 0, 0, 1, 4, 1, 0, 0 },
			{ 0, 0, 0, 1, 1, 1, 0, 0 }
			},
			{
			{ 1, 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 9, 9, 5, 1, 0, 0, 0, 0 },
			{ 1, 9, 2, 2, 1, 0, 1, 1, 1 },
			{ 1, 9, 2, 9, 1, 0, 1, 4, 1 },
			{ 1, 1, 1, 9, 1, 1, 1, 4, 1 },
			{ 0, 1, 1, 9, 9, 9, 9, 4, 1 },
			{ 0, 1, 9, 9, 9, 1, 9, 9, 1 },
			{ 0, 1, 9, 9, 9, 1, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 1, 0, 0, 0 }
			},
			{
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 9, 9, 9, 9, 9, 1, 1, 1 },
			{ 1, 1, 2, 1, 1, 1, 9, 9, 9, 1 },
			{ 1, 5, 9, 9, 2, 9, 9, 2, 9, 1 },
			{ 1, 9, 4, 4, 1, 9, 2, 9, 1, 1 },
			{ 1, 1, 4, 4, 1, 9, 9, 9, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
			},
			{
			{ 0, 1, 1, 1, 1, 0 },
			{ 1, 1, 9, 9, 1, 0 },
			{ 1, 9, 5, 2, 1, 0 },
			{ 1, 1, 2, 9, 1, 1 },
			{ 1, 1, 9, 2, 9, 1 },
			{ 1, 4, 2, 9, 9, 1 },
			{ 1, 4, 4, 3, 4, 1 },
			{ 1, 1, 1, 1, 1, 1 }
			},
			{
			{ 0, 1, 1, 1, 1, 0, 0, 0 },
			{ 0, 1, 5, 9, 1, 1, 1, 0 },
			{ 0, 1, 9, 2, 9, 9, 1, 0 },
			{ 1, 1, 1, 9, 1, 9, 1, 1 },
			{ 1, 4, 1, 9, 1, 9, 9, 1 },
			{ 1, 4, 2, 9, 9, 1, 9, 1 },
			{ 1, 4, 9, 9, 9, 2, 9, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }
			},
		{
			{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 9, 9, 1, 9, 5, 1 },
			{ 0, 0, 1, 9, 9, 9, 1, 9, 9, 1 },
			{ 0, 0, 1, 2, 9, 2, 9, 2, 9, 1 },
			{ 0, 0, 1, 9, 2, 1, 1, 9, 9, 1 },
			{ 1, 1, 1, 9, 2, 9, 1, 9, 1, 1 },
			{ 1, 4, 4, 4, 4, 4, 9, 9, 1, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }
			},
		{
			{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 9, 9, 9, 9, 1, 0 },
			{ 1, 1, 4, 9, 2, 1, 1, 9, 1, 1 },
			{ 1, 4, 4, 2, 9, 2, 9, 9, 5, 1 },
			{ 1, 4, 4, 9, 2, 9, 2, 9, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 9, 9, 1, 0 },
			{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 0 }
			},
		{
			{ 0, 0, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 9, 9, 9, 9, 1 },
			{ 1, 1, 1, 2, 2, 2, 9, 1 },
			{ 1, 5, 9, 2, 4, 4, 9, 1 },
			{ 1, 9, 2, 4, 4, 4, 1, 1 },
			{ 1, 1, 1, 1, 9, 9, 1, 0 },
			{ 0, 0, 0, 1, 1, 1, 1, 0 }
			},
		{
			{ 0, 0, 1, 1, 1, 1, 1, 0 },
			{ 1, 1, 1, 9, 9, 9, 1, 0 },
			{ 1, 9, 9, 2, 4, 9, 1, 1 },
			{ 1, 9, 9, 4, 2, 4, 5, 1 },
			{ 1, 1, 1, 9, 3, 2, 9, 1 },
			{ 0, 0, 1, 9, 9, 9, 1, 1 },
			{ 0, 0, 1, 1, 1, 1, 1, 0 }
			},
		{
			{ 0, 0, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 4, 4, 1, 0, 0 },
			{ 0, 1, 1, 9, 4, 1, 1, 0 },
			{ 0, 1, 9, 9, 2, 4, 1, 0 },
			{ 1, 1, 9, 2, 9, 9, 1, 1 },
			{ 1, 9, 9, 1, 2, 2, 9, 1 },
			{ 1, 9, 9, 5, 9, 9, 9, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }
			},
		{
			{ 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 9, 9, 1, 9, 9, 9, 1 },
			{ 1, 9, 2, 4, 4, 2, 9, 1 },
			{ 1, 5, 2, 4, 3, 9, 1, 1 },
			{ 1, 9, 2, 4, 4, 2, 9, 1 },
			{ 1, 9, 9, 1, 9, 9, 9, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1 }
			},
		{
			{ 0, 0, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 9, 9, 9, 9, 1, 1, 1 },
			{ 0, 0, 1, 9, 2, 9, 9, 9, 9, 1 },
			{ 1, 1, 1, 9, 2, 9, 1, 1, 9, 1 },
			{ 1, 4, 4, 4, 9, 2, 9, 9, 9, 1 },
			{ 1, 4, 4, 4, 2, 1, 2, 9, 1, 1 },
			{ 1, 1, 1, 1, 9, 1, 9, 2, 9, 1 },
			{ 0, 0, 0, 1, 9, 9, 5, 9, 9, 1 },
			{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 }
			},
		{
			{ 1, 1, 1, 1, 1, 1, 0, 0, 0 },
			{ 1, 9, 9, 5, 9, 1, 0, 0, 0 },
			{ 1, 9, 2, 2, 2, 1, 1, 0, 0 },
			{ 1, 9, 9, 1, 4, 4, 1, 1, 1 },
			{ 1, 1, 9, 9, 4, 4, 2, 9, 1 },
			{ 0, 1, 9, 9, 9, 9, 9, 9, 1 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1 }
			},
		{
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 9, 9, 9, 1, 4, 9, 1 },
			{ 0, 1, 1, 9, 9, 2, 4, 4, 4, 1 },
			{ 0, 1, 9, 9, 2, 9, 1, 3, 4, 1 },
			{ 1, 1, 9, 1, 1, 2, 1, 9, 1, 1 },
			{ 1, 9, 9, 9, 2, 9, 9, 2, 9, 1 },
			{ 1, 9, 9, 9, 1, 9, 9, 9, 9, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 5, 9, 1 },
			{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 }
			},
		{
			{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 4, 4, 4, 4, 9, 1, 0, 0 },
			{ 1, 1, 1, 4, 4, 4, 2, 1, 1, 1 },
			{ 1, 9, 9, 2, 1, 2, 9, 2, 9, 1 },
			{ 1, 9, 2, 2, 9, 9, 1, 2, 9, 1 },
			{ 1, 9, 9, 9, 9, 1, 9, 9, 9, 1 },
			{ 1, 1, 1, 1, 5, 9, 9, 1, 1, 1 },
			{ 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 }
			},
		{
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 4, 4, 2, 4, 4, 1 },
			{ 1, 4, 4, 1, 4, 4, 1 },
			{ 1, 9, 2, 2, 2, 9, 1 },
			{ 1, 9, 9, 2, 9, 9, 1 },
			{ 1, 9, 2, 2, 2, 9, 1 },
			{ 1, 9, 9, 1, 8, 9, 1 },
			{ 1, 1, 1, 1, 1, 1, 1 }
			},
			{
			{ 0, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 9, 5, 9, 1, 1, 1 },
			{ 1, 1, 9, 1, 2, 9, 9, 1 },
			{ 1, 9, 3, 4, 9, 4, 9, 1 },
			{ 1, 9, 9, 2, 2, 9, 1, 1 },
			{ 1, 1, 1, 9, 1, 4, 1, 0 },
			{ 0, 0, 1, 9, 9, 9, 1, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 0 }
			},
			{
			{ 1, 1, 1, 1, 1, 1 },
			{ 1, 9, 9, 9, 9, 1 },
			{ 1, 9, 2, 9, 9, 1 },
			{ 1, 1, 3, 9, 5, 1 },
			{ 1, 9, 3, 9, 1, 1 },
			{ 1, 9, 3, 9, 1, 0 },
			{ 1, 9, 3, 9, 1, 0 },
			{ 1, 9, 4, 9, 1, 0 },
			{ 1, 1, 1, 1, 1, 0 }
			},
			{
			{ 0, 0, 1, 1, 1, 1, 0 },
			{ 0, 0, 1, 9, 9, 1, 0 },
			{ 1, 1, 1, 2, 9, 1, 1 },
			{ 1, 9, 9, 3, 9, 9, 1 },
			{ 1, 9, 9, 3, 9, 9, 1 },
			{ 1, 9, 9, 3, 9, 1, 1 },
			{ 1, 1, 1, 3, 9, 1, 0 },
			{ 0, 0, 1, 4, 1, 1, 0 },
			{ 0, 0, 1, 1, 1, 0, 0 }
			},
			{
			{ 1, 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 9, 9, 9, 1, 1, 1, 1, 1 },
			{ 1, 9, 1, 9, 1, 9, 9, 9, 1 },
			{ 1, 9, 2, 9, 9, 9, 2, 9, 1 },
			{ 1, 4, 4, 1, 2, 1, 2, 1, 1 },
			{ 1, 4, 5, 2, 9, 9, 9, 1, 0 },
			{ 1, 4, 4, 9, 9, 1, 1, 1, 0 },
			{ 1, 1, 1, 1, 1, 1, 0, 0, 0 }
			}
			
	};
	
	public static byte[][] getMap(int grade) {
		byte[][] temp = map[grade];
		int row = temp.length;
		int col = temp[0].length;
		byte[][] result = new byte[row][col];
		
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				result[i][j] = temp[i][j];
		
		return result;
	}
	
	public static int getMapLength() {
		return map.length;
	}
}

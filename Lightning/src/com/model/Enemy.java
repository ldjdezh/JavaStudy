package com.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.panel.GamePanel;

public class Enemy {
	public static final int ENEMY_ALIVE_STATE = 1;
	public static final int ENEMY_DEATH_STATE = 0;
	public static final int ENEMY_STEP_Y = 10;
	public int mPosX;
	public int mPosY;
	Image picEnemy;
	Image[] explosionEnemy;
	int mState;
	public int mPlayID;
	GamePanel panel;
	public boolean flag;

	public Enemy(GamePanel panel) {
		this.panel = panel;
		explosionEnemy = new Image[6];
		for (int i = 0; i < explosionEnemy.length; i++)
			explosionEnemy[i] = Toolkit.getDefaultToolkit().getImage("images\\bomb_enemy_" + i + ".png");

		picEnemy = Toolkit.getDefaultToolkit().getImage("images\\e1_0.png");
	}

	public void init(int x, int y) {
		mPosX = x;
		mPosY = y;
		mState = ENEMY_ALIVE_STATE;
		mPlayID = 0;
		flag = true;
	}

	public void updateEnemy() {
		mPosY += ENEMY_STEP_Y;

		if (flag == false) {
			mPlayID++;
		}
	}

	public void drawEnemy(Graphics g) {
		if (flag)
			g.drawImage(picEnemy, mPosX, mPosY, panel);
		else {
			g.drawImage(explosionEnemy[mPlayID], mPosX, mPosY, panel);
		}
	}

}

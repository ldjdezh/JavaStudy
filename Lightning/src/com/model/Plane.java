package com.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.panel.GamePanel;

public class Plane {
	Image[] planePic;
	public int mAirPosX;
	public int mAirPosY;
	GamePanel panel;
	private int mPlayID;

	public Plane(GamePanel panel) {
		this.panel = panel;
		getPic();
		init(140, 370);

	}

	public void init(int x, int y) {
		mAirPosX = x;
		mAirPosY = y;
		mPlayID = 0;
	}

	private void getPic() {
		planePic = new Image[6];

		for (int i = 0; i < planePic.length; i++)
			planePic[i] = Toolkit.getDefaultToolkit().getImage("images\\plan_" + i + ".png");
	}

	public void drawPlane(Graphics g) {
		g.drawImage(planePic[mPlayID], mAirPosX, mAirPosY, panel);
	}

	/**
	 * 
	 * 
	 * @Description: 把更新图片的操作分开，反而没有问题了
	 */
	public void updatePlane() {
		mPlayID++;
		if (mPlayID == 6)
			mPlayID = 0;
	}

	public void moveLeft() {
		mAirPosX -= 10;

		if (mAirPosX < 0)
			mAirPosX = 0;
	}

	public void moveRight() {
		mAirPosX += 10;

		if (mAirPosX + 45 > 320)
			mAirPosX = 320 - 45;
	}

	public void moveDown() {
		mAirPosY += 10;

		if (mAirPosY + 75 > 480)
			mAirPosY = 480 - 75;
	}

	public void moveUp() {
		mAirPosY -= 10;

		if (mAirPosY < 0)
			mAirPosY = 0;
	}
}

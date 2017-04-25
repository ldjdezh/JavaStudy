package com.game.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel checkPoint, step, time;
	private JLabel jlCheckPoint, jlStep, jlTime;
	private JLabel undo, left, right, down, up;
	private JLabel jlUndo, jlLeft, jlRight, jlDown, jlUp;
	private SimpleDateFormat sdf;
	private long count;

	public StatusPanel() {
		sdf = new SimpleDateFormat("HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		setBackground(Color.GRAY);
		setLayout(new GridLayout(9, 2));

		checkPoint = new JLabel("当前关卡:");
		step = new JLabel("步数:");
		time = new JLabel("进行时间:");
		jlCheckPoint = new JLabel();
		jlStep = new JLabel();
		jlTime = new JLabel();
		undo = new JLabel("撤消:");
		left = new JLabel("角色向左:");
		right = new JLabel("角色向右:");
		down = new JLabel("角色向下:");
		up = new JLabel("角色向上:");
		jlUndo = new JLabel("R");
		jlLeft = new JLabel("A或←");
		jlRight = new JLabel("D或→");
		jlDown = new JLabel("S或↓");
		jlUp = new JLabel("W或↑");

		add(checkPoint);
		add(jlCheckPoint);
		add(step);
		add(jlStep);
		add(time);
		add(jlTime);
		add(undo);
		add(jlUndo);
		add(left);
		add(jlLeft);
		add(right);
		add(jlRight);
		add(down);
		add(jlDown);
		add(up);
		add(jlUp);

		new Thread(this).start();
	}

	public JLabel getJlCheckPoint() {
		return jlCheckPoint;
	}

	public JLabel getJlStep() {
		return jlStep;
	}

	@Override
	public void run() {
		while (true) {
			count += 1000;
			String s = sdf.format(count);
			jlTime.setText(s);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

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

		checkPoint = new JLabel("��ǰ�ؿ�:");
		step = new JLabel("����:");
		time = new JLabel("����ʱ��:");
		jlCheckPoint = new JLabel();
		jlStep = new JLabel();
		jlTime = new JLabel();
		undo = new JLabel("����:");
		left = new JLabel("��ɫ����:");
		right = new JLabel("��ɫ����:");
		down = new JLabel("��ɫ����:");
		up = new JLabel("��ɫ����:");
		jlUndo = new JLabel("R");
		jlLeft = new JLabel("A���");
		jlRight = new JLabel("D���");
		jlDown = new JLabel("S���");
		jlUp = new JLabel("W���");

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

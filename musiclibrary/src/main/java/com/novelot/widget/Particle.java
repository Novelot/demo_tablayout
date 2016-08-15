package com.novelot.widget;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Particle {

	protected static int rndInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	protected static double rndDbl(double min, double max) {
		return min + (max - min) * Math.random();
	}

	public void update() {
	}

	public void draw(Canvas canvas) {
	}

	public boolean isAlive() {
		return false;
	}

	public void update(Rect container) {
	}
}

package com.novelot.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class CircleParticle extends Particle {

	public static final int STATE_ALIVE = 0; // particle is alive
	public static final int STATE_DEAD = 1; // particle is dead
	/**
	 * 矩形的宽度
	 */
	private int width = 1;
	/**
	 * 中心x,即起点x
	 */
	private float x0;
	/**
	 * 中心y,即起点y
	 */
	private float y0;
	/**
	 * 时间
	 */
	private int time = 0;
	/**
	 * 起始角度
	 */
	private float beginAngle = 0;
	/**
	 * 起始半径
	 */
	private float beginRadius = 0;
	/**
	 * 角度变参数
	 */
	private float angleParam = 5;
	/**
	 * 半径变参数
	 */
	private float radiusParam = 5;
	/**
	 * 求得的x坐标
	 */
	private float x1;
	/**
	 * 求得的y坐标
	 */
	private float y1;
	/**
	 * 画笔
	 */
	private Paint paint;
	/**
	 * 颜色
	 */
	private int color;
	/**
	 * 生死状态
	 */
	private int state;

	public CircleParticle(float x0, float y0) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		//
		this.color = Color.argb(255, rndInt(0, 255), rndInt(0, 255),
				rndInt(0, 255));
		paint = new Paint(color);

		//
		width = rndInt(1, 10);
		beginAngle = (float) rndDbl(0, 360);
		beginRadius = (float) rndDbl(0, 5);
		this.angleParam = (float) rndDbl(1, 15);
		this.radiusParam = (float) rndDbl(1, 15);
	}

	@Override
	public void update() {
		if (state != STATE_DEAD) {
			time++;
			float a = angleParam * time + beginAngle;
			float r = radiusParam * time + beginRadius;
			x1 = (float) (r * Math.cos(a) + x0);
			y1 = (float) (r * Math.sin(a) + y0);
			//
			int alpha = color >>> 24;
			alpha -= 2;
			if (alpha <= 0) {
				state = STATE_DEAD;
			} else {
				color = (color & 0x00ffffff) + (alpha << 24);
				paint.setColor(color);
				paint.setAlpha(alpha);
			}
		}
	}

	@Override
	public void draw(Canvas canvas) {

		canvas.drawRect(x1, y1, x1 + width, y1 + width, paint);
	}

	@Override
	public boolean isAlive() {
		return this.state == STATE_ALIVE;
	}

	@Override
	public void update(Rect container) {
		update();
	}

}

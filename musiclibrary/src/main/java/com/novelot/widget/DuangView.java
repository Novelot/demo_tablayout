package com.novelot.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class DuangView extends View {

	private Explosion mExplosion;
	private int explosionX;
	private int explosionY;

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public DuangView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	public DuangView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public DuangView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public DuangView(Context context) {
		super(context);
		init();
	}

	public DuangView(Context context, int explosionX, int explosionY) {
		super(context);
		this.explosionX = explosionX;
		this.explosionY = explosionY;
		init();
	}

	private void init() {
		mExplosion = new Explosion(400, this.explosionX, this.explosionY);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mExplosion.draw(canvas);
		mExplosion.update();
		invalidate();
	}

}

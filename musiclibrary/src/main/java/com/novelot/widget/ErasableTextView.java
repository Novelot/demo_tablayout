package com.novelot.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class ErasableTextView extends View {

	private Paint paint;
	private Bitmap bgBitmap;
//	private Canvas mCanvas;
	private Path path;
	private Bitmap createBitmap;

	public ErasableTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public ErasableTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ErasableTextView(Context context) {
		super(context);
		init();
	}

	private void init() {
		bgBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.background);
		Bitmap frontBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.mv);
		createBitmap = Bitmap.createBitmap(frontBitmap.getWidth(),
				frontBitmap.getHeight(), Config.ARGB_8888);

		paint = new Paint();
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(20);
		paint.setAlpha(0);
		paint.setXfermode(new PorterDuffXfermode(
				PorterDuff.Mode.SRC_IN));

//		mCanvas = new Canvas(createBitmap);
//		mCanvas.drawBitmap(frontBitmap, new Matrix(), null);

		path = new Path();
		path.moveTo(100, 100);
		path.lineTo(200, 200);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(createBitmap, new Matrix(), null);
//		mCanvas.drawPath(path, paint);
		canvas.drawPath(path, paint);
		super.onDraw(canvas);
	}
	
	
	/*******/
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			path.moveTo(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			path.lineTo(x, y);
			invalidate();
			break;
		}
		return true;
	}
	
//	private void touch_start(float x, float y) {
//		path.reset();
//		path.moveTo(x, y);
//		mX = x;
//		mY = y;
//	}
//
//	private void touch_move(float x, float y) {
//		float dx = Math.abs(x - mX);
//		float dy = Math.abs(y - mY);
//		if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
//			path.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
//			mX = x;
//			mY = y;
//		}
//	}
//
//	private void touch_up() {
//		path.lineTo(mX, mY);
//		path.reset();
//	}

}

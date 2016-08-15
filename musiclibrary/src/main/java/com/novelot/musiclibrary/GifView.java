package com.novelot.musiclibrary;

import com.cdel.chinaacc.phone.R;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

public class GifView extends View {

	private static final String TAG = "GifView";
	private Movie mMovie;
	private long mMovieStart;
	private float mMetrics;
	private float mScale = 1f;
	private int mGifResId;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public GifView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		initAttrs(context, attrs);
		init();
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public GifView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAttrs(context, attrs);
		init();
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public GifView(Context context) {
		super(context);

		init();
	}

	private void initAttrs(Context context, AttributeSet attrs) {
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.GifView);
		mScale = a.getFloat(R.styleable.GifView_scale, 1f);
		mGifResId = a.getResourceId(R.styleable.GifView_gif, 0);
		if (mGifResId != 0) {
			mMovie = Movie.decodeStream(getResources().openRawResource(
					mGifResId));
		}
		a.recycle();
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void init() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}

		// 计算密度
		mMetrics = getMetrics();
	}

	/**
	 * 设置资源
	 * 
	 * @param resId
	 */
	public void setMovieResource(int resId) {
		mGifResId = resId;
		if (mGifResId != 0) {
			mMovie = Movie.decodeStream(getResources().openRawResource(
					mGifResId));
		}
	}

	/**
	 * 设置缩放
	 * 
	 * @param s
	 */
	public void setScale(float s) {
		mScale = s;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (mMovie != null) {
			int w = (int) (mMovie.width() * mScale);
			int h = (int) (mMovie.height() * mScale);

			w = Math.max(w, getSuggestedMinimumWidth());
			h = Math.max(h, getSuggestedMinimumHeight());

			setMeasuredDimension(w, h);

			//
			Log.v(TAG, String.format("onMeasure[%d,%d],movie[%d,%d]",
					widthMeasureSpec, heightMeasureSpec, mMovie.width(),
					mMovie.height()));
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}

	}

	// @Override
	// protected void onLayout(boolean changed, int left, int top, int right,
	// int bottom) {
	// super.onLayout(changed, left, top, right, bottom);
	//
	// mMovie.setTime(0);
	// Log.v(TAG, String.format("onLayout[%d,%d,%d,%d],movie0[%d,%d]", left,
	// top, right, bottom, mMovie.width(), mMovie.height()));
	// Log.v(TAG, String.format("get[%d,%d]", getWidth(), getHeight()));
	// }

	@Override
	protected void onDraw(Canvas canvas) {
		long now = android.os.SystemClock.uptimeMillis();
		if (mMovieStart == 0) { // first time
			mMovieStart = now;
		}
		if (mMovie != null) {
			int dur = mMovie.duration();
			if (dur == 0) {
				dur = 1000;
			}
			int relTime = (int) ((now - mMovieStart) % dur);
			mMovie.setTime(relTime);
			/* 联想A668t(版本10,分辨率160) 出现多出右侧和下侧的空边,导致动画不能居中 */
			if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1)
				canvas.scale(mMetrics, mMetrics);
			canvas.scale(mScale, mScale);
			mMovie.draw(canvas, 0, 0);
			invalidate();
		}
	}

	/**
	 * 获取屏幕密度
	 * 
	 * @return
	 */
	private float getMetrics() {
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		return metrics.densityDpi / 160f;
	}

}

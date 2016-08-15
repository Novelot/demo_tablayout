package com.novelot.musiclibrary;

import java.util.ArrayList;

import com.cdel.chinaacc.phone.R;
import com.cdel.chinaacc.phone.app.adapter.ShareAdapter;
import com.cdel.chinaacc.phone.user.entity.News;
import com.cdel.frame.extra.BaseConfig;
import com.cdel.frame.share.QQ;
import com.cdel.frame.share.WeChat;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class ShareBoardView extends RelativeLayout {

	private GridView mGV;

	// android L
	// public ShareBoardView(Context context, AttributeSet attrs,
	// int defStyleAttr, int defStyleRes) {
	// super(context, attrs, defStyleAttr, defStyleRes);
	// init();
	// }

	public ShareBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public ShareBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ShareBoardView(Context context) {
		super(context);
		init();
	}

	private void init() {
		View view = View.inflate(getContext(), R.layout.widget_board_share,
				this);
		mGV = (GridView) view.findViewById(R.id.grid);
		mGV.setAdapter(new ShareAdapter(getContext()));

	}

	public void setOnItemClickListener(OnItemClickListener l) {
		mGV.setOnItemClickListener(l);
	}

	/**
	 * 
	 * @param activity
	 */
	public static void showSharePop(final Activity activity) {
		News news = new News();// news 实体中设置分享内容
		news.setTitle(BaseConfig.getInstance().getConfig()
				.getProperty("SHARE_TITLE"));// 分享title
		news.setContent(BaseConfig.getInstance().getConfig()
				.getProperty("SHARE_CONTENT"));// 内容
		news.setUrl(BaseConfig.getInstance().getConfig()
				.getProperty("SHARE_WEB_SITE"));// 点击后访问地址

		ShareBoardView.showSharePop(activity, news);
	}

	/**
	 * 
	 * @param activity
	 * @param news
	 */
	public static void showSharePop(final Activity activity, final News news) {
		//
		final PopupWindow sharePop = new PopupWindow(activity);
		sharePop.setAnimationStyle(R.style.style_anim_pop);
		sharePop.setFocusable(true);// 返回键pop消失,否则直接退出Activity
		sharePop.setOutsideTouchable(true);// 点击pop外其他区域,pop消失
		sharePop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// 背景透明,否则存在边框
		ShareBoardView shareBoard = new ShareBoardView(activity);
		shareBoard.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0: {
					WeChat weChat = new WeChat(activity, WEIXIN_APP_ID);
					weChat.shareWebPage(WeChat.WXSceneSession, news.getTitle(),
							news.getContent(), news.getUrl(),
							R.drawable.ic_launcher);
				}
					break;
				case 1: {
					QQ qq = new QQ(activity, QQ_APP_ID);
					String imageUrl = BaseConfig.getInstance().getConfig()
							.getProperty("APP_SHARE_IMAGE_URL");
					qq.shareApp(news.getTitle(), news.getContent(),
							news.getUrl(), imageUrl, BaseConfig.getInstance()
									.getConfig().getProperty("APP_NAME"), null);
				}
					break;
				case 2: {
					QQ q = new QQ(activity, QQ_APP_ID);
					String imageUrl2 = BaseConfig.getInstance().getConfig()
							.getProperty("APP_SHARE_IMAGE_URL");
					ArrayList<String> imageUrls = new ArrayList<String>();
					imageUrls.add(imageUrl2);
					q.shareToQzone(news.getTitle(), news.getContent(),
							news.getUrl(), imageUrls, null);
				}
					break;
				case 3: {
					WeChat weChat = new WeChat(activity, WEIXIN_APP_ID);
					weChat.shareWebPage(WeChat.WXSceneTimeline,
							news.getTitle(), news.getContent(), news.getUrl(),
							R.drawable.ic_launcher);
				}
					break;
				}
				sharePop.dismiss();
			}
		});

		sharePop.setContentView(shareBoard);
		/* 设置大小,否则不显示 */
		sharePop.setWidth(LayoutParams.MATCH_PARENT);
		sharePop.setHeight(LayoutParams.WRAP_CONTENT);
		sharePop.showAtLocation(activity.getWindow().getDecorView(),
				Gravity.BOTTOM, 0, 0);
	}

	/**
	 * 
	 * @param activity
	 * @param news
	 * @param type
	 *            1:分享app;其他,分享url
	 */
	public static void showSharePop(final Activity activity, final News news,
			final int type) {
		//
		final PopupWindow sharePop = new PopupWindow(activity);
		sharePop.setAnimationStyle(R.style.style_anim_pop);
		sharePop.setFocusable(true);// 返回键pop消失,否则直接退出Activity
		sharePop.setOutsideTouchable(true);// 点击pop外其他区域,pop消失
		sharePop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));// 背景透明,否则存在边框
		ShareBoardView shareBoard = new ShareBoardView(activity);
		shareBoard.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0: {
					WeChat weChat = new WeChat(activity, WEIXIN_APP_ID);
					weChat.shareWebPage(WeChat.WXSceneSession, news.getTitle(),
							news.getContent(), news.getUrl(),
							R.drawable.ic_launcher);
				}
					break;
				case 1: {
					QQ qq = new QQ(activity, QQ_APP_ID);
					String imageUrl = BaseConfig.getInstance().getConfig()
							.getProperty("APP_SHARE_IMAGE_URL");
					if (type == 1) {
						qq.shareApp(news.getTitle(), news.getContent(),
								news.getUrl(), imageUrl,
								BaseConfig.getInstance().getConfig()
										.getProperty("APP_NAME"), null);
					} else {
						qq.shareUrl(news.getTitle(), news.getContent(),
								news.getUrl(), imageUrl,
								BaseConfig.getInstance().getConfig()
										.getProperty("APP_NAME"), null);
					}
				}
					break;
				case 2: {
					QQ q = new QQ(activity, QQ_APP_ID);
					String imageUrl2 = BaseConfig.getInstance().getConfig()
							.getProperty("APP_SHARE_IMAGE_URL");
					ArrayList<String> imageUrls = new ArrayList<String>();
					imageUrls.add(imageUrl2);
					q.shareToQzone(news.getTitle(), news.getContent(),
							news.getUrl(), imageUrls, null);
				}
					break;
				case 3: {
					WeChat weChat = new WeChat(activity, WEIXIN_APP_ID);
					weChat.shareWebPage(WeChat.WXSceneTimeline,
							news.getTitle(), news.getContent(), news.getUrl(),
							R.drawable.ic_launcher);
				}
					break;
				}
				sharePop.dismiss();
			}
		});

		sharePop.setContentView(shareBoard);
		/* 设置大小,否则不显示 */
		sharePop.setWidth(LayoutParams.MATCH_PARENT);
		sharePop.setHeight(LayoutParams.WRAP_CONTENT);
		sharePop.showAtLocation(activity.getWindow().getDecorView(),
				Gravity.BOTTOM, 0, 0);
	}

	private static final String WEIXIN_APP_ID = BaseConfig.getInstance()
			.getConfig().getProperty("wxappid");
	private static final String QQ_APP_ID = BaseConfig.getInstance()
			.getConfig().getProperty("qqappid");
}

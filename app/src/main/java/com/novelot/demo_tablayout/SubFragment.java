package com.novelot.demo_tablayout;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.novelot.demo_tablayout.provider.MyContentProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘云龙 on 2016/6/3.
 */
public class SubFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    public static final String KEY_EXTRA = "key";
    private Bean mData;
    private List<TextView> tvs = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mData = args.getParcelable(KEY_EXTRA);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_item, null);
        TextView iv1 = (TextView) view.findViewById(R.id.iv1);
        TextView iv2 = (TextView) view.findViewById(R.id.iv2);
        TextView iv3 = (TextView) view.findViewById(R.id.iv3);

        tvs.add(0, iv1);
        tvs.add(1, iv2);
        tvs.add(2, iv3);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(), MyContentProvider.URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.v("novelot", "onLoadFinished");
        if (data != null) {
            List<String> urls = new ArrayList<>();

            for (data.moveToFirst(); !data.isAfterLast(); data.moveToNext()) {
                String url = data.getString(data.getColumnIndex("url"));
                urls.add(url);
            }

            for (int i = 0; i < tvs.size(); i++) {
                tvs.get(i).setText(TextUtils.isEmpty(urls.get(i)) ? "空" : urls.get(i));
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

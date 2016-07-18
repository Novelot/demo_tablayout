package com.novelot.musiclibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RadiosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RadiosFragment extends Fragment {
    public static final String KEY_EXTRA = "key";
    private String mKey;
    private TextView tvTitle;


    public RadiosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment RadiosFragment.
     */
    public static RadiosFragment newInstance(String param1) {
        RadiosFragment fragment = new RadiosFragment();
        Bundle args = new Bundle();
        args.putString(KEY_EXTRA, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mKey = getArguments().getString(KEY_EXTRA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radios, container, false);
        tvTitle = (TextView) view.findViewById(R.id.tv);
        if (TextUtils.isEmpty(mKey)) {
            mKey = "Empty";
        }
        tvTitle.setText(mKey);
        return view;
    }

}

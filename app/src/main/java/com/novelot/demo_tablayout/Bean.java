package com.novelot.demo_tablayout;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 刘云龙 on 2016/6/3.
 */
public class Bean implements Parcelable {
    public String name;

    public Bean(String s) {
        this.name = s;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected Bean(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<Bean> CREATOR = new Creator<Bean>() {
        @Override
        public Bean createFromParcel(Parcel source) {
            return new Bean(source);
        }

        @Override
        public Bean[] newArray(int size) {
            return new Bean[size];
        }
    };
}

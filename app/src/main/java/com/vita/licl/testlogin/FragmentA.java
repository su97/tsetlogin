package com.vita.licl.testlogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pc on 2016/8/22.
 */
public class FragmentA extends android.support.v4.app.Fragment {

    String logout;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("logout", "效果图.onCreate");
        logout+="效果图.onCreate调用->";
    }

    public String getLogout(){
        return logout;
    }

    public void addLogout(String addstr){
        logout+=addstr;
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("logout", "效果图.onStart");
        logout+="效果图.onStart调用->";
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("logout", "效果图.onStop");
        logout+="效果图.onStop调用->";
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("logout", "效果图.onResume");
        logout+="效果图.onResume调用->";
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("logout", "效果图.onPause");
        logout+="效果图.onPause调用->";
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("logout", "效果图.onDestroy");
        logout+="效果图.onDestroy调用->";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__a, container, false);

        Log.d("logout", "效果图.onCreateView");
        logout+="效果图.onCreateView->";

        return view;
    }

}

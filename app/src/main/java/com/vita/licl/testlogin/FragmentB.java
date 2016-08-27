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
public class FragmentB extends android.support.v4.app.Fragment {

    String logout;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("logout", "线性布局.onCreate");
        logout+="线性布局.onCreate->";
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
        Log.d("logout", "线性布局.onStart");
        logout+="线性布局.onStart调用->";
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("logout", "线性布局.onStop");
        logout+="线性布局.onStop调用->";
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("logout", "线性布局.onResume");
        logout+="线性布局.onResume调用->";
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("logout", "线性布局.onPause");
        logout+="线性布局.onPause调用->";
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("logout", "线性布局.onDestroy");
        logout+="线性布局.onDestroy调用->";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);

        Log.d("logout", "线性布局.onCreateView");
        logout+="线性布局.onCreateView调用->";

        return view;
    }
}

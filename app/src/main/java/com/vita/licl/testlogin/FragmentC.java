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
public class FragmentC extends android.support.v4.app.Fragment {

    String logout;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("logout", "计算器界面.onCreate");
        logout+="计算器界面.onCreate调用->";
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
        Log.d("logout", "计算器界面.onStart");
        logout+="计算器界面.onStart调用->";
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("logout", "计算器界面.onStop");
        logout+="计算器界面.onStop调用->";
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("logout", "计算器界面.onResume");
        logout+="计算器界面.onResume调用->";
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("logout", "计算器界面.onPause");
        logout+="计算器界面.onPause调用->";
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("logout", "计算器界面.onDestroy");
        logout+="计算器界面.onDestroy调用->";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__c, container, false);

        Log.d("logout", "计算器界面.onCreateView");
        logout+="计算器界面.onCreateView调用->";

        return view;
    }
}

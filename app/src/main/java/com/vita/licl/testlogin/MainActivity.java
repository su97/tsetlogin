package com.vita.licl.testlogin;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends android.support.v7.app.AppCompatActivity {

    Button btn_a;
    Button btn_b;
    Button btn_c;
    Button btn_d;
    Button btn_e;
    android.support.v4.app.FragmentManager fragmentManager;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    FragmentA fragA;
    FragmentB fragB;
    FragmentC fragC;
    String logout;


    public String getLogout(){
        return logout;
    }

    public void addLogout(String addstr){
        logout+=addstr;
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("logout","Main.onStart");
        logout+="Main.onStart调用->";
    }

    @Override
    protected void onStop() {
        super.onStop();

        boolean t=isFinishing();
        if (t)
            Log.d("logout", "Main isFinishing");
        Log.d("logout", "Main.onStop");
        logout+="Main.onStop调用->";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("logout", "Main.onResume  TaskID:"+getTaskId()+"  Hash Code:"+hashCode());
        logout+="Main.onResume调用->";
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("logout", "Main.onPause");
        logout+="Main.onPause调用->";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("logout", "Main.onDestroy");
        logout+="Main.onDestroy调用->";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        Log.d("logout", "Main.onCreate");
        logout+="Main.onCreate调用->";

        btn_a=(Button)findViewById(R.id.btn_a);
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragA==null)
                    fragA=new FragmentA();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_content,fragA);
                fragmentTransaction.addToBackStack("FragA");
                fragmentTransaction.commit();
            }
        });
        btn_b=(Button)findViewById(R.id.btn_b);
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragB==null)
                    fragB=new FragmentB();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_content,fragB);
                fragmentTransaction.addToBackStack("FragB");
                fragmentTransaction.commit();
            }
        });
        btn_c=(Button)findViewById(R.id.btn_c);
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragC==null)
                    fragC=new FragmentC();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frag_content,fragC);
                fragmentTransaction.addToBackStack("FragC");
                fragmentTransaction.commit();
            }
        });
        btn_d=(Button)findViewById(R.id.btn_d);
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment frag=fragmentManager.findFragmentById(R.id.frag_content);
                String str="";
                if (frag instanceof FragmentA)
                    str=((FragmentA) frag).getLogout();
                if (frag instanceof FragmentB)
                    str=((FragmentB) frag).getLogout();
                if (frag instanceof FragmentC)
                    str=((FragmentC) frag).getLogout();
                Toast.makeText(getApplicationContext(),logout+"->"+str,Toast.LENGTH_LONG).show();
            }
        });
        btn_e=(Button)findViewById(R.id.btn_e);
        btn_e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("logout","MainActivity");
    }

    @Override
    public void onBackPressed(){
        fragmentManager.popBackStack();
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("logout", "Main isFinishing");
    }

}

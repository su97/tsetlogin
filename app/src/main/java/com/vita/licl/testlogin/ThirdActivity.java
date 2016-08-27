package com.vita.licl.testlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ThirdActivity extends AppCompatActivity {

    private String logout;
    Button back;

    public String getLogout(){
        return logout;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("logout", "ThirdActivity");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("logout", "Third.onStart");
        logout+="Third.onStart调用->";
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("logout", "Third.onStop");
        logout+="Third.onStop调用->";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("logout", "Third.onResume  TaskID:"+getTaskId()+"  Hash Code:"+hashCode());
        logout+="Third.onResume调用->";
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("logout", "Third.onPause");
        logout+="Third.onPause调用->";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("logout", "Third.onDestroy");
        logout+="Third.onDestroy调用->";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ListView list=(ListView)findViewById(R.id.arrlist);//创建ListView
        String[] data=new String[]{"itemA","itemB","itemC","itemD","itemE"};//初始化一些数据
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.item_arrlist,data);//用对应布局文件与数据创建适配器
        list.setAdapter(adapter);//给ListView设置上适配器

        back=(Button)findViewById(R.id.btn_back2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

    }

}

package com.vita.licl.testlogin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    String logout;
    Button back;
    Button thirdActivity;
    ListView listview;
    List list;


    public String getLogout(){
        return logout;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("logout","SecondActivity");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("logout", "Second.onStart");
        logout+="Second.onStart调用->";
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("logout", "Second.onStop");
        logout+="Second.onStop调用->";
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("logout", "Second.onResume  TaskID:"+getTaskId()+"  Hash Code:"+hashCode());
        logout+="Second.onResume调用->";
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("logout", "Second.onPause");
        logout+="Second.onPause调用->";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("logout", "Second.onDestroy");
        logout+="Second.onDestroy调用->";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        back=(Button)findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        thirdActivity=(Button)findViewById(R.id.btn_thirdActivity);
        thirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        Log.d("logout", "Second.onCreate");
        logout+="Second.onCreate调用->";

        listview=(ListView)findViewById(R.id.listview);
        ListviewAdapter adapter2=new ListviewAdapter(this,init());
        listview.setAdapter(adapter2);
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("logout", "Second isFinishing");
    }


    public class ViewHolder{

        TextView title;
        TextView subtitle;
        TextView content;
        ImageView mainbg;

        public void setViewHolder(View view) {
            mainbg=(ImageView)view.findViewById(R.id.mainbg);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
            content = (TextView) view.findViewById(R.id.content);
        }
    }

    private List<Listitem> init() {
        list=new ArrayList();
        for(int i=0;i<10;i++){
            Listitem item=new Listitem();
            item.setTitle("title " + (i + 1));
            item.setSubtitle("subtitlesubtitle");
            item.setContent("Content Content Content Content Content");
            /*图片可以从网络获取，就在这获取
            item.setMainbg(BitmapFactory.decodeResource(getResources(),R.drawable.mainbg));*/
            list.add(item);
        }
        return list;
    }

    public class ListviewAdapter extends BaseAdapter {

        private Context context;
        private ViewHolder viewHolder;
        private List<Listitem> list;

        public ListviewAdapter(Context ctx,List<Listitem> lst){
            context=ctx;
            list=lst;
            //int x=8/0;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Listitem getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        protected void getItemView(View view, ViewHolder viewHolder,final Listitem item) {
            final ViewHolder holder=viewHolder;
            holder.title.setText(item.getTitle());
            holder.subtitle.setText(item.getSubtitle());
            holder.content.setText(item.getContent());
            holder.mainbg.setImageDrawable(getResources().getDrawable(R.drawable.mainbg));
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){

            if (view==null){
                LayoutInflater layoutInflater=LayoutInflater.from(context);
                view=layoutInflater.inflate(R.layout.item_list,viewGroup,false);
                viewHolder = getViewHolder();//每次view是null时都创建一个viewHolder对象，能保证view和holder一一绑定
                viewHolder.setViewHolder(view);//执行一次性的搜索并绑定控件对象到Holder

                getItemView(view, viewHolder,getItem(i));//在这里填充数据

                view.setTag(viewHolder);//以设置标签的方式绑定viewHolder到这个view
            }

            viewHolder= (ViewHolder)view.getTag();//如果这个view存在，那么肯定绑定了Holder，我们就去获取
            getItemView(view,viewHolder,getItem(i));//获取到之后重新设置数据

            return view;
        }

        protected ViewHolder getViewHolder() {
            return new ViewHolder();
        }
    }

}

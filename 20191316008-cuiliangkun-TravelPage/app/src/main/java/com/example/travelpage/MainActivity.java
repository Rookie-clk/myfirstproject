package com.example.travelpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_login;
    private Button btn_user;
    private String[] titles = {"巴黎铁塔","帝国大厦","雷门","迪士尼"};
    private String[] prices = {"180元/人","80元/人","270元/人","200元/人"};
    private String[] details = {"“巴黎地标之一”","“众多影视取景地”","“零距离感受日本宗教与民俗”","“充满欢乐与童真的梦幻乐园”"};
    private int[] icons = {R.drawable.bali,R.drawable.buliding,R.drawable.leimen,R.drawable.disney};
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv);
        MyBaseAdapter adapter = new MyBaseAdapter();
        listView.setAdapter(adapter);
        init();
        Intent intent = getIntent();
        String loginname=intent.getStringExtra("loginname");


        if(loginname!=null) {
            View b = findViewById(R.id.btn_login);
            b.setVisibility(View.INVISIBLE);
            textView.setText("景点介绍                         用户名："+loginname);
            View userbtn = findViewById(R.id.btn_user);
            userbtn.setVisibility(View.VISIBLE);

        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                break;
            case R.id.btn_user:
                Intent user = new Intent(MainActivity.this,user.class);
                Intent get = getIntent();
                String loginname=get.getStringExtra("loginname");
                user.putExtra("loginname",loginname);
                startActivity(user);
                break;
                case 0:
                    Intent num_0 = new Intent(MainActivity.this,detail.class);
                    num_0.putExtra("sign","0");
                    startActivity(num_0);
                break;
                case 1:
                    Intent num_1 = new Intent(MainActivity.this,detail.class);
                    num_1.putExtra("sign","1");
                    startActivity(num_1);
                break;
                case 2:
                    Intent num_2 = new Intent(MainActivity.this,detail.class);
                    num_2.putExtra("sign","2");
                    startActivity(num_2);
                break;
                case 3:
                    Intent num_3 = new Intent(MainActivity.this,detail.class);
                    num_3.putExtra("sign","3");
                    startActivity(num_3);
                break;
        }
    }

    class  MyBaseAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           View view= View.inflate(MainActivity.this,R.layout.listitem,null);
            Button button = view.findViewById(R.id.xiangqing);
           TextView title=view.findViewById(R.id.title);
            TextView price=view.findViewById(R.id.price);
            ImageView iv =view.findViewById(R.id.iv);
            TextView detail = view.findViewById(R.id.detail);
            title.setText(titles[position]);
            price.setText(prices[position]);
            detail.setText(details[position]);
            iv.setImageResource(icons[position]);
            button.setId(position);
            return view;
        }
    }
    private void init(){
        btn_login = (Button) findViewById(R.id.btn_login);
        textView = (TextView) findViewById(R.id.theme);
    }

}

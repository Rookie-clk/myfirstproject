package com.example.travelpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class detail extends AppCompatActivity {

    private String[] intros = {"埃菲尔铁塔（法语：La Tour Eiffel；英语：the Eiffel Tower）矗立在塞纳河南岸法国巴黎的战神广场，于1889年建成，是当时世界上最高的建筑物。埃菲尔铁塔得名于设计它的著名建筑师、结构工程师古斯塔夫·埃菲尔，全部由施耐德铁器（现施耐德电气）建造。",
            "帝国大厦（Empire State Building），是竣工于1931年4月11日的高层建筑物，是美国纽约的地标建筑物之一。位于曼哈顿第五大道350号、西33街与西34街之间。它是保持世界最高建筑地位最久的摩天大楼（1931-1972共41年）。帝国大厦楼高381米、总103层，1951年增添了高62米的天线后，总高度为443.7米，该建筑由Shreve, Lamb and Harmon建筑公司设计，为装饰艺术风格建筑。",
            "雷门是浅草寺入口的大门，几经火灾焚毁，后于1960年重建。雷门正门入口处左右威风凛凛的风神和雷神二将，镇守着浅草寺。雷门相当于金龙山浅草寺的总门，红漆八脚门是典型的宽边瓦顶。被称为风神雷神门，对象着门安置在右边的是风神像，左边的是雷神像。雷门最著名的要数门前悬挂的那盏巨大的灯笼，高3.9米，重达700公斤。远远可见黑底白边的“雷门”二字，赫然醒目，着实为浅草寺增添不少气派。作为了解日本民族文化的旅游名胜，来自世界各国的游客，络绎不绝。",
            "东京迪士尼乐园，修建于1982年，位于日本东京都以东的千叶县浦安市舞滨，是由美国迪士尼公司和日本梓设计公司合作建造的。被誉为亚洲第一游乐园的东京迪士尼乐园，依照美国迪士尼乐园而修建，主题乐园面积为四十六公顷。"};
    private String[] pos = {"法国（France）——巴黎（Paris）","美国（America）——纽约（NewYork）","日本（Japan）——东京（Tokyo）","日本（Japan）——东京（Tokyo）"};
    private String[] time = {"4月-9月 6:00-17:00,10月-次年3月 6:30-17:00。","4月-9月 6:00-17:00,10月-次年3月 6:30-17:00。","4月-9月 6:00-17:00,10月-次年3月 6:30-17:00。","4月-9月 6:00-17:00,10月-次年3月 6:30-17:00。"};
    private String[] contact = {"https://www.toureiffel.paris/fr","www.esbnyc.com","www.senso-ji.jp","www.disney.jp"};
    private int[] img = {R.drawable.bali,R.drawable.buliding,R.drawable.leimen,R.drawable.disney};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String sign = getIntent().getStringExtra("sign");
        ListView la = findViewById(R.id.la);
        MyBaseAdapter adapter = new MyBaseAdapter();
        la.setAdapter(adapter);
    }
    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return intros[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(detail.this,R.layout.detail_layout,null);
            TextView tv_intro = view.findViewById(R.id.intro);
            TextView tv_pos = view.findViewById(R.id.pos);
            TextView tv_time = view.findViewById(R.id.time);
            TextView tv_contact = view.findViewById(R.id.contact);
            Intent intent = getIntent();
            String sign = getIntent().getStringExtra("sign");
            ImageView iv_img = view.findViewById(R.id.detail_image);
            switch (sign) {
                case "0":
                tv_intro.setText(intros[0]);
                tv_pos.setText(pos[0]);
                tv_time.setText(time[0]);
                tv_contact.setText(contact[0]);
                iv_img.setImageResource(img[0]);
                break;
                case "1":
                    tv_intro.setText(intros[1]);
                    tv_pos.setText(pos[1]);
                    tv_time.setText(time[1]);
                    tv_contact.setText(contact[1]);
                    iv_img.setImageResource(img[1]);
                    break;
                case "2":
                    tv_intro.setText(intros[2]);
                    tv_pos.setText(pos[2]);
                    tv_time.setText(time[2]);
                    tv_contact.setText(contact[2]);
                    iv_img.setImageResource(img[2]);
                    break;
                case "3":
                    tv_intro.setText(intros[3]);
                    tv_pos.setText(pos[3]);
                    tv_time.setText(time[3]);
                    tv_contact.setText(contact[3]);
                    iv_img.setImageResource(img[3]);
                    break;
            }


            return view;
        }
    }

}

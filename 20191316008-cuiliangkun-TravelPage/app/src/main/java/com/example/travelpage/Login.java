package com.example.travelpage;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.ContentValues;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    MyHelper myHelper;
    private EditText LoginName;
    private EditText Password;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myHelper = new  MyHelper (this);
        init();
        findViewById(R.id.btn_login).setOnClickListener(this);
        sp = getSharedPreferences("data",MODE_PRIVATE);
        editor=sp.edit();
        Password.setText(sp.getString("密码",""));
        LoginName.setText(sp.getString("账号",""));

    }

    private void init() {
        LoginName = (EditText) findViewById(R.id.et_account);
        Password = (EditText) findViewById(R.id.et_password);
    }

    @Override
    public void onClick(View v) {
        String loginname,password;
        SQLiteDatabase db;
        loginname = LoginName.getText().toString();
        password = Password.getText().toString();
        ContentValues values;
        switch (v.getId()){
            case R.id.btn_login:
                if(loginname==null||loginname.isEmpty()){
                    Toast.makeText(Login.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password==null||password.isEmpty()){
                    Toast.makeText(Login.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                db= myHelper.getReadableDatabase();
                Cursor cursor = db.query("Login",null,null,null,null,null,null);
                cursor.moveToFirst();
                    do {
                        if (cursor.getString(1).equals(LoginName.getText().toString())  &&
                                cursor.getString(2).equals(Password.getText().toString() )) {
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.putExtra("loginname", LoginName.getText().toString());
                            startActivity(intent);
                            Toast.makeText(Login.this, "登录成功!", Toast.LENGTH_SHORT).show();
                            editor.putString("账号", loginname);
                            editor.putString("密码", password);
                            editor.commit();
//                            Toast.makeText(Login.this,cursor.getString(1),Toast.LENGTH_SHORT).show();
                        }
                    } while (cursor.moveToNext());
//                }
                cursor.close();
                break;
            case  R.id.btn_register:

                db=myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("loginname",loginname);
                values.put("password",password);
                db.insert("Login",null,values);
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                Intent intentregister = new Intent(Login.this,MainActivity.class);
                intentregister.putExtra("loginname",loginname);
                startActivity(intentregister);
                break;

        }

    }
    class MyHelper extends SQLiteOpenHelper {

        public MyHelper(Context context){
            super(context,"travelpage.db",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE Login(_id INTEGER PRIMARY KEY AUTOINCREMENT,loginname VARCHAR(20),password VARCHAR(20),auth VARCHAR(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

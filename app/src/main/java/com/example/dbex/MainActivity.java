package com.example.dbex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText edtName,edtNum;
    Button btnreset,btninput,btnlookup;
    TextView tvName,tvadd;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();   //액션바 가리기

        edtName = (EditText)findViewById(R.id.edtName);
        edtNum =(EditText)findViewById(R.id.edtNum);
        btnreset = (Button)findViewById(R.id.btnreset);
        btninput=(Button)findViewById(R.id.btninput);
        btnlookup = (Button)findViewById(R.id.btnlookup);
        tvName =(TextView)findViewById(R.id.tvName);
        tvadd = (TextView)findViewById(R.id.tvadd);




    }

    //1.SQLiteOpenHelper 클래스를 상속받은 클래스 생성 후에, 메소드 생성 및 생성자 생성 (빨간 줄 표기 됨)

    public class myDBHelper extends SQLiteOpenHelper {

        public myDBHelper( Context context) {  //2.Context context 만 제외하고 전부 지운다. Context(장소)를 제외한 나머지는 상속받을 것이 아니기 때문에 지움. 나머지는 내가 만들어서 사용한다.
            super(context,"groupDB2",null,1); //3.super (); 안에도 수정한다.  생성자에서 DB를 생성한다. (context-상속,  ""-db이름,  외부에서 받을 것,  내가만든 버전수)
        }

        @Override
        public void onCreate(SQLiteDatabase db) { //4. onCreate 메소드는 테이블을 생성하는 메소드 이다. ★★
            db.execSQL("CREATE TABLE groupTBL (gName TEXT  PRIMARY KEY, gNumber INTEGER);" );  //5. db를 생성하는 메소드    db.execSQL("CREATE TABLE 생성할 테이블 이름 (필드명 타입, 필드명타입);" );  지금의 경우 필드가 2개이다.  PRIMARY KEY는 고유값 설정
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");    //6. 테이블 삭제하는 명령어  DROP TABLE
            onCreate(db);  //7. 삭제 후 다시 생성하기 위해 onCreate 메소드 소환

        }
    }
}

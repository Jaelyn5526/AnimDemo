package jaelyn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Anidroid Animation");
        findViewById(R.id.btn_xml).setOnClickListener(this);
        findViewById(R.id.btn_java).setOnClickListener(this);
        findViewById(R.id.btn_frame).setOnClickListener(this);
        findViewById(R.id.btn_value).setOnClickListener(this);
        findViewById(R.id.btn_object).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
        case R.id.btn_xml:
            intent.setClass(MainActivity.this, AnimXmlActivity.class);
            startActivity(intent);
            break;
        case R.id.btn_java:
            intent.setClass(MainActivity.this, AnimActivity.class);
            startActivity(intent);
            break;
        case R.id.btn_frame:
            intent.setClass(MainActivity.this, FrameActivity.class);
            startActivity(intent);
            break;
        case R.id.btn_value:
            intent.setClass(MainActivity.this, ValueAnimActivity.class);
            startActivity(intent);
            break;
        case R.id.btn_object:
            intent.setClass(MainActivity.this, ObjectAnimActivity.class);
            startActivity(intent);
            break;
        }
    }
}

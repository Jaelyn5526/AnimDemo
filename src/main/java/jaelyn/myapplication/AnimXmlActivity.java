package jaelyn.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AnimXmlActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        setTitle("用XML实现动画");
        textView = (TextView) findViewById(R.id.text);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_tran).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_set).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.btn_alpha:
            animation = AnimationUtils.loadAnimation(AnimXmlActivity.this, R.anim.animalpha);
            textView.startAnimation(animation);
            break;
        case R.id.btn_scale:
            animation = AnimationUtils.loadAnimation(AnimXmlActivity.this, R.anim.animscale);
            textView.startAnimation(animation);
            break;
        case R.id.btn_tran:
            animation = AnimationUtils.loadAnimation(AnimXmlActivity.this, R.anim.animtran);
            textView.startAnimation(animation);
            break;
        case R.id.btn_rotate:
            animation = AnimationUtils.loadAnimation(AnimXmlActivity.this, R.anim.animrotate);
            textView.startAnimation(animation);
            break;
        case R.id.btn_set:
            animation = AnimationUtils.loadAnimation(AnimXmlActivity.this, R.anim.animset);
            textView.startAnimation(animation);
            break;
        }
    }
}

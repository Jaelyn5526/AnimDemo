package jaelyn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class AnimActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textView;
    private AlphaAnimation alphaAnimation;
    private ScaleAnimation scaleAnimation;
    private TranslateAnimation translateAnimation;
    private RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        setTitle("java语句实现动画");
        textView = (TextView) findViewById(R.id.text);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        findViewById(R.id.btn_tran).setOnClickListener(this);
        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_set).setOnClickListener(this);
        alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(false);

        scaleAnimation = new ScaleAnimation(1, 0, 1,0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(false);

        translateAnimation = new TranslateAnimation(0, 100, 0, 400);
        translateAnimation.setDuration(1000);

        rotateAnimation = new RotateAnimation(0, 360 , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.btn_alpha:

            textView.startAnimation(alphaAnimation);
            break;
        case R.id.btn_scale:

            textView.startAnimation(scaleAnimation);
            break;
        case R.id.btn_tran:

            textView.startAnimation(translateAnimation);
            break;
        case R.id.btn_rotate:

            textView.startAnimation(rotateAnimation);
            break;
        case R.id.btn_set:
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(rotateAnimation);
            textView.startAnimation(animationSet);
            break;
        }
    }
}

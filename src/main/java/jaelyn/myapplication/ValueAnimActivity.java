package jaelyn.myapplication;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

public class ValueAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private ValueAnimator valueAnimator;

    private int moveDx = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim);
        setTitle("ValueAnimator");
        textView = (TextView) findViewById(R.id.text);
        findViewById(R.id.btn_tran).setOnClickListener(this);
        findViewById(R.id.btn_int).setOnClickListener(this);
        findViewById(R.id.btn_eva).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);

        moveDx = dip2px(moveDx);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.btn_tran: //移动动画
            valueAnimator = ValueAnimator.ofInt(0, moveDx);
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int x = (int) valueAnimator.getAnimatedValue();
                    textView.setTranslationY(x);
                }
            });
            valueAnimator.start();
            break;
        case R.id.btn_int: //添加加速器
//            valueAnimator.setInterpolator(new AccelerateInterpolator(2));
            valueAnimator = ValueAnimator.ofInt(0, moveDx);
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int x = (int) valueAnimator.getAnimatedValue();
                    textView.setTranslationY(x);
                }
            });
            //自定义插值器
            valueAnimator.setInterpolator(new TimeInterpolator() {
                @Override
                public float getInterpolation(float v) {
                    return v * v;
                }
            });
            valueAnimator.start();
            break;

        case R.id.btn_eva: //扩大移动范围
            valueAnimator = ValueAnimator.ofInt(0, moveDx);
            valueAnimator.setDuration(1000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int x = (int) valueAnimator.getAnimatedValue();
                    textView.setTranslationY(x);
                }
            });
            valueAnimator.setEvaluator(new IntEvaluator(){
                @Override
                public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                    return ((int) ((endValue - startValue) * fraction + 300 * fraction));
                }
            });
            valueAnimator.start();
            break;
        case R.id.btn_color: //背景颜色变化
            valueAnimator = ValueAnimator.ofArgb(0xffea9d9d, 0xffffffff, 0xffa0e02f);
            valueAnimator.setDuration(2000);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int color = (int) valueAnimator.getAnimatedValue();
                    Log.d("color--", color +"");
                    textView.setBackgroundColor(color);
                }
            });
            valueAnimator.start();
            break;
        }
    }

    public int dip2px( float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

package jaelyn.myapplication;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ObjectAnimActivity extends AppCompatActivity implements View.OnClickListener{

    private ObjectAnimator objectAnimator;
    private TextView textView;
    private int moveDx = 300;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        setTitle("ObjectAnimator");
        findViewById(R.id.btn_tran).setOnClickListener(this);
        findViewById(R.id.btn_holder).setOnClickListener(this);
        textView = (TextView) findViewById(R.id.text);
        moveDx = dip2px(moveDx);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.btn_tran:
            objectAnimator = ObjectAnimator.ofFloat(textView, "translationY", 0, moveDx);
            objectAnimator.setDuration(1000);
            objectAnimator.start();
            break;
        case R.id.btn_holder:
            PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("rotation", 0, 360);
            PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1f, 0.3f);
            PropertyValuesHolder tran = PropertyValuesHolder.ofFloat("translationY", 0, moveDx);
            PropertyValuesHolder color = PropertyValuesHolder.ofObject("BackgroundColor", new ArgbEvaluator(),0xffea9d9d, 0xffffffff, 0xffa0e02f);

            objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, rotation, alpha, tran, color);
            objectAnimator.setDuration(2000);
            objectAnimator.start();
            break;
        }
    }

    public int dip2px( float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

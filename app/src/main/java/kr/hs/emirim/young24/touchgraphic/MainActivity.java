package kr.hs.emirim.young24.touchgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    static final int LINE = 1, RECT = 2, CIRCLE = 3;
    int chooseShape = CIRCLE;
    DrawShape ds;
    int startX,startY,stopX, stopY;
    int r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ds = new DrawShape(getApplicationContext());
        LinearLayout linear = (LinearLayout) findViewById(R.id.linear_view);
        linear.addView(ds);

    }

    public void drawShape(View v){
        switch(v.getId()){
            case R.id.but_line:
                chooseShape = LINE;
                break;
            case R.id.but_rect:
                chooseShape = RECT;
                break;
            case R.id.but_circle:
                chooseShape = CIRCLE;
                break;
        }
        ds.invalidate();
    }
    class DrawShape extends View {
        DrawShape(Context context){ //상속을 받았기에 그에 맞는 부모 객체를 만들어줘야함
            super(context);

        }
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            float cx = getWidth()/2.0f;
            float cy = getHeight()/2.0f;
            Paint paint = new Paint();
            paint.setStrokeWidth(7);
            paint.setStyle(Paint.Style.STROKE);
            switch (chooseShape){
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY,paint);
                    break;
                case RECT:
                    paint.setColor(Color.MAGENTA);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                  // float cc =(float)( Math.pow(cx,2)+Math.pow(cy,2));
                    r = (int)Math.sqrt(Math.pow(stopX-startX,2) + Math.pow(stopY-startY,2));
                    canvas.drawCircle(startX,startY, r,paint);
                    // canvas.drawCircle(cx,cy,200,paint);//paint - 선의 굵기 설정
                    break;

            }
            ds.invalidate();

        }
        public boolean onTouchEvent(MotionEvent event){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX();
                    startY = (int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                    break;
            }
            invalidate();
            return true;
        }
    }
}

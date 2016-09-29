package kr.hs.emirim.young24.touchgraphic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drawShape(View v){

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
            paint.setColor(Color.MAGENTA);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(10, 10, 210, 160, paint);
            canvas.drawCircle(cx,cy,200,paint);//paint - 선의 굵기 설정
        }
    }
}

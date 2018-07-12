package com.example.zhoule.barragedemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.zhoule.barragedemo.bean.ReplyComment;
import com.example.zhoule.barragedemo.bean.ReplyUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhoule on 2018/7/10.
 * <p>
 * 弹幕类
 */

public class TranTextView extends View {

    private int width, height;
    //记录当前弹幕Y的坐标
    private int tempY;
    int colors[] = new int[]{Color.YELLOW, Color.RED, Color.WHITE, Color.BLUE, Color.LTGRAY};
    List<TextModeView> datas = new ArrayList<>();

    List<ReplyComment> dataX;


    //记录当前的弹幕数有多少还未经过指定区域
    private int count = 0;

    public TranTextView(Context context) {
        super(context);
    }

    public TranTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 添加数据
     *
     * @param dataX
     */
    public void setMag(List<ReplyComment> dataX) {
        this.dataX = dataX;

        for (int i = 0; i < dataX.size(); i++) {
            TextModeView textModeView = new TextModeView();
            textModeView.msg = dataX.get(i).getMsg();
            datas.add(textModeView);
        }

        if (count == 0) {
            invalidate();
        }
        count += dataX.size();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        Log.e("-------", width + "   " + height);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (datas.size() > 0) {
            for (int i = 0; i < datas.size(); i++) {
                datas.get(i).drawText(canvas, i);
            }

            //每个5毫秒刷新一次
            postInvalidateDelayed(5);
        }
    }


    class TextModeView {

        //当前位移的x坐标
        int currentX;
        //当前位移的Y坐标
        int currentY;
        //每次位移的变化系数
        int tranX;
        //画笔
        private Paint paint;
        private Random random;

        //弹幕的内容
        private String msg;

        //判断当前弹幕是否移动超过1/3
        boolean isLessWidth = true;

        public TextModeView() {

            random = new Random();
            resetData();
            initPaint();

        }

        private void drawText(Canvas canvas, int pos) {
            currentX -= tranX;
            if (paint != null) {
                canvas.drawText(msg, currentX, currentY, paint);

                //当弹幕移动到屏幕看不到之后，就销毁画笔
                if (currentX <= 0 - paint.measureText(msg)) {
                    paint = null;
                }


                //判断当有弹幕移动超过宽度的1/3  就拉新的弹幕
                if (currentX < width / 3 * 2 && isLessWidth) {
                    count--;
                    isLessWidth = false;
                    Log.e("-------", "count" + count + "   " + pos);
                    if (count == 8) {
                        Log.e("-------", System.currentTimeMillis() + "  ");
                        if (isFinsh2Anim != null) {
                            isFinsh2Anim.finish();
                        }
                    }
                }
            }

        }


        /**
         * 重置 弹幕属性
         */
        private void resetData() {

            currentY = tempY + 50;
            tempY = currentY;
            if (tempY >= height) {
                tempY = 0;
            }
            tranX = random.nextInt(2) + 3;

            //随机从屏幕之外的位置开始移动
            this.currentX = width + random.nextInt(200) +  300;

        }


        /**
         * 初始化paint
         */
        private void initPaint() {
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setTextSize(random.nextInt(20) + 30);
            paint.setColor(colors[random.nextInt(colors.length - 1)]);
        }
    }


    //接口，监听是否已经移动到指定位置
    public interface isFinsh2Anim {
        void finish();
    }

    public isFinsh2Anim isFinsh2Anim;

    public void setIsFinsh2Anim(isFinsh2Anim isFinsh2Anim) {
        this.isFinsh2Anim = isFinsh2Anim;
    }
}

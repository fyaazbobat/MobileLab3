package fyaaz.bobat.s301071094.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BobatCanvasView extends View{

    private static final float TOLERANCE = 5;
    public int width;
    public int height;
    Context context;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mPaint;
    private float mX, mY;

    public void getSelectedOptions(String mColor, String mThickness) {
        setColor(mColor);
        setThickness(mThickness);
    }

    // set color
    private void setColor(String color) {
        switch (color) {
            case "Black" : mPaint.setColor(Color.BLACK);
                break;
            case "White" : mPaint.setColor(Color.WHITE);
                break;
            case "Purple" : mPaint.setColor(Color.MAGENTA);
                break;
            case "Grey" : mPaint.setColor(Color.GRAY);
                break;
            case "Blue" : mPaint.setColor(Color.BLUE);
                break;
            default:
                break;
        }
    }



    // set Thickness
    private void setThickness(String thickness) {
        switch (thickness) {
            case "2f" : mPaint.setStrokeWidth(2f);
                break;
            case "4f" : mPaint.setStrokeWidth(4f);
                break;
            case "6f" : mPaint.setStrokeWidth(6f);
                break;
            case "8f" : mPaint.setStrokeWidth(8f);
                break;
            case "10f" : mPaint.setStrokeWidth(10f);
                break;
            default:
                break;
        }
    }

    public BobatCanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        //mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        //mPaint.setStrokeWidth(4f);
    }

    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath, mPaint);
    }

    public void clearPath() {
        mPath = new Path();
        invalidate();
    }

    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }


    // when ACTION_UP stop touch
    private void upTouch() {
        mPath.lineTo(mX, mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }

}

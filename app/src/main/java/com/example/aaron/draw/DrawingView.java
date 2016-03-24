package com.example.aaron.draw;

import android.graphics.Color;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.TypedValue;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.ArrayList;


/**
 * Created by aaron on 3/11/16.
 * DrawingView class is a custom View
 * for the drawing functions in which to take place.
 */
public class DrawingView extends View
{
    //drawing path
    private Path drawPath;
    //drawing and canvas paint
    private Paint drawPaint, canvasPaint;
    //initial color
    private int paintColor = 0xFF660000;
    //canvas
    private Canvas drawCanvas;
    //canvas bitmap
    private Bitmap canvasBitmap;

    private float brushSize, lastBrushSize;
    private boolean erase=false;

    private ArrayList<Path> paths; //paths are pushed into the stack
    private LinkedList<Path> undoPaths; //paths that are popped from the stack are added to undoPaths
    
    public DrawingView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setupDrawing();

    }

    /**
     * setupDrawing() method
     *    initializes all variables for drawing
     */
    private void setupDrawing()
    {
        brushSize = getResources().getInteger(R.integer.medium_size);
        lastBrushSize = brushSize;

        /**
         * instantiate new Path and Paint objects
         * */
        drawPath = new Path();
        drawPaint = new Paint();

        //set the initial color
        drawPaint.setColor(paintColor);

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(brushSize);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        drawPaint.setStrokeWidth(brushSize);

        canvasPaint = new Paint(Paint.DITHER_FLAG);

        paths = new ArrayList<>();
        undoPaths = new LinkedList<>();
//get drawing area setup for interaction
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
//view given size
    }

    @Override
    protected void onDraw(Canvas canvas)
    {

        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
//        canvas.drawPath(drawPath, drawPaint);
//draw view
        for(Path p : paths)
        {
            canvas.drawPath(p, drawPaint);

        }

        canvas.drawPath(drawPath, drawPaint);
    }

    /**
     * Detects a user's touch which draws on the screen
     * @param event actions in which the users touches the screen
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                //push the path onto the stack
                if(paths.add(drawPath)){
                    Toast.makeText(getContext(), "adding", Toast.LENGTH_SHORT).show();
                }

                drawPath.reset();
                break;
            default:
                return false;
        }

        invalidate(); //calls implicitly onDraw()
        return true;
    }

    public void setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);

//set color
    }

    public void setBrushSize(float newSize){

        float pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                newSize, getResources().getDisplayMetrics());
        brushSize=pixelAmount;
        drawPaint.setStrokeWidth(brushSize);
//update size
    }

    public void setLastBrushSize(float lastSize){
        lastBrushSize=lastSize;
    }
    public float getLastBrushSize(){
        return lastBrushSize;
    }


    public void setErase(boolean isErase) {
        erase = isErase;
        if(erase) drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        else drawPaint.setXfermode(null);
    }

    public void startNew(){
        drawCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

    public void OnClickUndo()
    {
        if(paths.size() != 0) {
            Path path = paths.remove(paths.size() - 1);
            undoPaths.add(path);
            invalidate();
        }
    }
}

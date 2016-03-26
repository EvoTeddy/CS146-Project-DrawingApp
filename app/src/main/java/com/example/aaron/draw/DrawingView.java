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

<<<<<<< HEAD
=======

>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
/**
 * Created by aaron on 3/11/16.
 * DrawingView class is a custom View
 * for the drawing functions in which to take place.
 */
public class DrawingView extends View
{
<<<<<<< HEAD
    /**
     * instance variables:
     * Path drawPath
     * Paint drawPaint, canvasPaint
     * int paintColor
     * Canvas drawCanvas
     * Bitmap canvasBitmap
     * float brushSize, lastBrushSize
     * boolean erase
     * ArrayList<Path> paths
     * LinkedList<Path> undonePaths
     */
=======
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
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
<<<<<<< HEAD
    private LinkedList<Path> undonePaths; //paths that are popped from the stack are added to undoPaths

    //CONSTRUCTOR
=======
    private LinkedList<Path> undoPaths; //paths that are popped from the stack are added to undoPaths
    
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
    public DrawingView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setupDrawing();

    }

    /**
<<<<<<< HEAD
     * initializes all variables for drawing
=======
     * setupDrawing() method
     *    initializes all variables for drawing
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
     */
    private void setupDrawing()
    {
        brushSize = getResources().getInteger(R.integer.medium_size);
        lastBrushSize = brushSize;

<<<<<<< HEAD
        //instantiate new Path and Paint objects
        drawPath = new Path();
        drawPaint = new Paint();

        //set the initial color of drawPaint
        drawPaint.setColor(paintColor);

        //set initial path properties
=======
        /**
         * instantiate new Path and Paint objects
         * */
        drawPath = new Path();
        drawPaint = new Paint();

        //set the initial color
        drawPaint.setColor(paintColor);

>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(brushSize);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);

        drawPaint.setStrokeWidth(brushSize);
<<<<<<< HEAD
        //instantiate the Paint object canvasPaint
        //Note:
        //definition of dithering:
        //add white noise to (a digital recording)
        //to reduce distortion of low-amplitude signals.
        //Happens when source of color must fit into small space
        canvasPaint = new Paint(Paint.DITHER_FLAG);

        paths = new ArrayList<>();
        undonePaths = new LinkedList<>();
//get drawing area setup for interaction
    }

    /**
     * Called when custom View is assigned a size.
     * Makes a new canvas of appropriate size.
     * Instantiates Canvas drawCanvas and Bitmap canvasBitmap
     * using width and height values
     * @param w width of canvas
     * @param h height of canvas
     * @param oldw old width
     * @param oldh old height
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        //call superclass method from View
=======

        canvasPaint = new Paint(Paint.DITHER_FLAG);

        paths = new ArrayList<>();
        undoPaths = new LinkedList<>();
//get drawing area setup for interaction
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(canvasBitmap);
//view given size
    }

<<<<<<< HEAD
    /**
     * Each time the user draws using touch, View is invalidated,
     * causing onDraw() to execute
     * @param canvas canvas, created in onSizeChanged, for drawing on top of
     */
    @Override
    //TODO: fix onDraw so that correct Paths are there after Undo is called
    protected void onDraw(Canvas canvas)
    {
        //draws the canvas
        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
        //draws the drawing path
// canvas.drawPath(drawPath, drawPaint);
//draw view
        for(Path p : paths) {
=======
    @Override
    protected void onDraw(Canvas canvas)
    {

        canvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
//        canvas.drawPath(drawPath, drawPaint);
//draw view
        for(Path p : paths)
        {
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
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
<<<<<<< HEAD
    //TODO: fix the last case.
    public boolean onTouchEvent(MotionEvent event) {
        //detects user touch by location
=======
    public boolean onTouchEvent(MotionEvent event) {

>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction())
        {
<<<<<<< HEAD
            //User touches the View.
            //Move to that position to start drawing.
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(touchX, touchY);
                break;
            //When user moves finger on View,
            //draw the path along their touch
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(touchX, touchY);
                break;
            //Touch is lifted off View,
            //draw path and reset for next drawing operation.
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                //push the path onto the stack
                if(paths.add(drawPath))
                {
=======
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
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
                    Toast.makeText(getContext(), "adding", Toast.LENGTH_SHORT).show();
                }

                drawPath.reset();
                break;
            default:
                return false;
        }

<<<<<<< HEAD
        //after break from switch, invalidate View
=======
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        invalidate(); //calls implicitly onDraw()
        return true;
    }

<<<<<<< HEAD
    /**
     * sets the new color
     * @param newColor the new color
     */
    public void setColor(String newColor)
    {
        //invalidates the View
        invalidate();
        //new color is set
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);
=======
    public void setColor(String newColor){
        invalidate();
        paintColor = Color.parseColor(newColor);
        drawPaint.setColor(paintColor);

//set color
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
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
<<<<<<< HEAD
            undonePaths.add(path);
=======
            undoPaths.add(path);
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
            invalidate();
        }
    }
}

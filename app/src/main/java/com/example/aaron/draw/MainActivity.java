package com.example.aaron.draw;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.UUID;
import android.provider.MediaStore;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.widget.Toast;

<<<<<<< HEAD
/**
 * MainActivity Class for background processing.
 * Inherits methods from Activity superclass.
 * Implements OnClickListener so app can detect screen touch.
 */
public class MainActivity extends Activity implements OnClickListener{

    /**
     * DrawingView drawView - the instance of DrawingView class
     * float smallBrush, mediumBrush, largeBrush
     * ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn
     * Button UndoButton
     */
    private DrawingView drawView;
    private float smallBrush, mediumBrush, largeBrush;
    private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn;
    //need to make this ImageButton
    private Button UndoButton;

    /**
     * Sets initial settings for the app when first start app
     * @param savedInstanceState state of View
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize DrawingView drawView
        drawView = (DrawingView)findViewById(R.id.drawing);
        //gets the first paint button as starting color
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        //store initial button to the currPaint button
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
=======
public class MainActivity extends Activity implements OnClickListener{

    private DrawingView drawView;
    private float smallBrush, mediumBrush, largeBrush;
    private ImageButton currPaint, drawBtn, eraseBtn, newBtn, saveBtn;
    private Button UndoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawView = (DrawingView)findViewById(R.id.drawing);

        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);

        currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint_pressed, null));
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799

        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);

        drawBtn = (ImageButton)findViewById(R.id.draw_btn);
<<<<<<< HEAD
        //sets up a click listener for this draw button
=======
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        drawBtn.setOnClickListener(this);

        eraseBtn = (ImageButton)findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        newBtn = (ImageButton)findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);

        saveBtn = (ImageButton)findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);

        UndoButton = (Button) findViewById(R.id.Undo_Button);
        UndoButton.setOnClickListener(this);
    }

<<<<<<< HEAD
    /**
     * Updates paint color to newly chosen color
     * Changes background ImageButton from unchosen to chosen
     * and previously chosen to unchosen color background
     * @param view
     */
    public void paintClicked(View view)
    {
        //use chosen color
        if(view!=currPaint) //if paint color is not currently selected
        {
            //update color
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawView.setColor(color);
            //changes chosen button to darker background
            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
=======
    public void paintClicked(View view){

        if(view!=currPaint){
            ImageButton imgView = (ImageButton)view;
            String color = view.getTag().toString();
            drawView.setColor(color);
            //update color
            imgView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint_pressed, null));
            currPaint.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint_pressed, null));
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
            currPaint=(ImageButton)view;
            drawView.setErase(false);
            drawView.setBrushSize(drawView.getLastBrushSize());
        }
        //use chosen color
    }

<<<<<<< HEAD
    /**
     * Checks for clicks on the
     * draw, new, save, and erase buttons
     * @param view the drawingView class object argument
     */
    @Override
    public void onClick(View view)
    {
        //for clicked draw button
        if(view.getId()==R.id.draw_btn)
        {
            //draw button clicked, so set up dialog of three button sizes
=======
    @Override
    public void onClick(View view){

        if(view.getId()==R.id.draw_btn){

>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Brush size:");

            brushDialog.setContentView(R.layout.brush_chooser);
            ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(false);
                    drawView.setBrushSize(smallBrush);
                    drawView.setLastBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });

            ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(false);
                    drawView.setBrushSize(mediumBrush);
                    drawView.setLastBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });

            ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(false);
                    drawView.setBrushSize(largeBrush);
                    drawView.setLastBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();
<<<<<<< HEAD
        }
        //for clicked erase button
=======
            //draw button clicked
        }
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        else if(view.getId()==R.id.erase_btn){
            final Dialog brushDialog = new Dialog(this);
            brushDialog.setTitle("Eraser size:");
            brushDialog.setContentView(R.layout.brush_chooser);
            ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });
            brushDialog.show();
        }
<<<<<<< HEAD
        //for clicked New button
=======
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        else if(view.getId()==R.id.new_btn){
            AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
            newDialog.setTitle("New drawing");
            newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
            newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    drawView.startNew();
                    dialog.dismiss();
                }
            });
            newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            newDialog.show();
            //new button
        }
<<<<<<< HEAD
        //for clicked Save button
        else if(view.getId()==R.id.save_btn)
        {
            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Save drawing");
            saveDialog.setMessage("Save drawing to device Gallery?");
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which)
                {
                    //save drawing
                    drawView.setDrawingCacheEnabled(true);
                    String imgSaved = MediaStore.Images.Media.insertImage(
                            getContentResolver(), drawView.getDrawingCache(),
                            UUID.randomUUID().toString()+".png", "drawing");
                    if(imgSaved!=null)
                    {
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                        savedToast.show();
                    }
                    else
                    {
                        Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
                        unsavedToast.show();
                    }
                    drawView.destroyDrawingCache();
                }
            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.cancel();
                    //improperly placed code:
                   /* String imgSaved = MediaStore.Images.Media.insertImage(
=======
        else if(view.getId()==R.id.save_btn){

            AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
            saveDialog.setTitle("Save drawing");
            saveDialog.setMessage("Save drawing to device Gallery?");
            drawView.setDrawingCacheEnabled(true);
            saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which){
                    //save drawing
                }
            });
            saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    String imgSaved = MediaStore.Images.Media.insertImage(
>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
                            getContentResolver(), drawView.getDrawingCache(),
                            UUID.randomUUID().toString() + ".png", "drawing");
                    if (imgSaved != null) {
                        Toast savedToast = Toast.makeText(getApplicationContext(),
                                "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
                        savedToast.show();
                    } else {
                        Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
                        unsavedToast.show();
<<<<<<< HEAD
                    }*/
                }
            });
            //drawView.destroyDrawingCache();
            saveDialog.show();
        }
//respond to clicks

        //for clicked UNDO button
=======
                    }
                }
            });
            drawView.destroyDrawingCache();
            saveDialog.show();
            //save drawing
        }
//respond to clicks

>>>>>>> 093e371b80e8f3185d196f052726cc4e6c65a799
        //TODO: implement undo button
        else if(view.getId() == R.id.Undo_Button) {
            // calls onclickundo
            drawView.OnClickUndo();
        }
    }
}

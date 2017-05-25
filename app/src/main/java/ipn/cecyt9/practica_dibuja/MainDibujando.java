package ipn.cecyt9.practica_dibuja;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.MotionEvent;
import android.view.View;

public class MainDibujando extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);

        SpecialView miVista = new SpecialView(this);
        setContentView(miVista);
    }



    class SpecialView extends View {
        float x = 50;
        float y = 50;
        String accion = "Accion";
        String texto = "Evento";
        Path ArrayDibujos = new Path();

        public SpecialView(Context context) {

            super(context);
        }

        @Override
        protected void onDraw(Canvas Pizarron) {
            Pizarron.drawColor(Color.WHITE);
            Paint Lapiz = new Paint();
            Lapiz.setStyle(Paint.Style.STROKE);
            Lapiz.setStrokeWidth(3);
            Lapiz.setColor(Color.GREEN);

            if (accion == "down") {
                ArrayDibujos.moveTo(x, y);
                ArrayDibujos.addCircle(x,y,6, Direction.CCW);
            }
            if (accion == "move") {
                ArrayDibujos.addCircle(x,y,6, Direction.CCW);
            }
            Pizarron.drawPath(ArrayDibujos, Lapiz);

            Lapiz.setColor(Color.BLUE);
            Lapiz.setTextSize(20);
            Lapiz.setStrokeWidth(2);
            Pizarron.drawText(texto, 100, 130, Lapiz); Pizarron.drawText("x = " + x +
                    "  y = " + y, 100, 50, Lapiz);
            //canvas.drawc
        }

        @Override
        public boolean onTouchEvent(MotionEvent evento) {

            x = evento.getX();
            y = evento.getY();

            if (evento.getAction() == MotionEvent.ACTION_DOWN) {
                accion = "down";
                texto = "Action Down";
            }

            if (evento.getAction() == MotionEvent.ACTION_UP) {
                texto = "Action Up";
            }

            if (evento.getAction() == MotionEvent.ACTION_MOVE) {
                accion = "move";
                texto = "Action Move";
            }
            invalidate();
            return true;
        }
    }

}

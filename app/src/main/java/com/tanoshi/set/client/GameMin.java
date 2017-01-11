package com.tanoshi.set.client;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tanoshi.set.R;
import com.tanoshi.set.object.BoardMin;
import com.tanoshi.set.object.CardMin;
import com.tanoshi.set.object.SetMin;
import com.tanoshi.set.service.ServiceBoardMin;
import com.tanoshi.set.service.ServiceCardMin;
import com.tanoshi.set.service.ServiceSetMin;
import com.tanoshi.set.serviceimpl.ServiceBoardMinImpl;
import com.tanoshi.set.serviceimpl.ServiceCardMinImpl;
import com.tanoshi.set.serviceimpl.ServiceSetMinImpl;

import java.util.ArrayList;

/**
 * Created by Human Booster on 04/01/2017.
 */

public class GameMin extends AppCompatActivity {
    static int size = 12;
    static int scoreI = 0;
    Button reD;
    LinearLayout[] ll;
    ImageView[] iv;
    TextView timer, score;
    BoardMin board;
    ServiceBoardMin sb = new ServiceBoardMinImpl();
    ServiceSetMin ss = new ServiceSetMinImpl();
    ServiceCardMin sc = new ServiceCardMinImpl();
    ArrayList<Integer> answ = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDisplay();
        linkXml();
        listen();
        setTimer(3000);
        board = sb.dispatchCard(size);
        dispatchCards();
    }

    private void setDisplay() {
        setContentView(R.layout.game_min);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    private void linkXml() {
        reD = (Button) findViewById(R.id.reDispatch);

        ll = new LinearLayout[size];
        ll[0] = (LinearLayout) findViewById(R.id.one);
        ll[1] = (LinearLayout) findViewById(R.id.two);
        ll[2] = (LinearLayout) findViewById(R.id.three);
        ll[3] = (LinearLayout) findViewById(R.id.four);
        ll[4] = (LinearLayout) findViewById(R.id.five);
        ll[5] = (LinearLayout) findViewById(R.id.six);
        ll[6] = (LinearLayout) findViewById(R.id.seven);
        ll[7] = (LinearLayout) findViewById(R.id.eight);
        ll[8] = (LinearLayout) findViewById(R.id.nine);
        ll[9] = (LinearLayout) findViewById(R.id.ten);
        ll[10] = (LinearLayout) findViewById(R.id.eleven);
        ll[11] = (LinearLayout) findViewById(R.id.twelve);

        iv = new ImageView[size];
        iv[0] = (ImageView) findViewById(R.id.one1);
        iv[1] = (ImageView) findViewById(R.id.two1);
        iv[2] = (ImageView) findViewById(R.id.three1);

        iv[3] = (ImageView) findViewById(R.id.four1);
        iv[4] = (ImageView) findViewById(R.id.five1);
        iv[5] = (ImageView) findViewById(R.id.six1);

        iv[6] = (ImageView) findViewById(R.id.seven1);
        iv[7] = (ImageView) findViewById(R.id.eight1);
        iv[8] = (ImageView) findViewById(R.id.nine1);

        iv[9] = (ImageView) findViewById(R.id.ten1);
        iv[10] = (ImageView) findViewById(R.id.eleven1);
        iv[11] = (ImageView) findViewById(R.id.twelve1);

        timer = (TextView) findViewById(R.id.timer);
        score = (TextView) findViewById(R.id.score);
    }

    private void listen() {
        for (int i = 0; i < ll.length; ++i) {
            final Integer x = i;
            ll[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!answ.contains(x)) {
                        answ.add(x);
                        setValid(x, R.drawable.border_valid);
                        if (answ.size() == 3) {
                            trySet();
                        }
                    } else {
                        answ.remove(x);
                        setValid(x, R.drawable.border);
                    }

                }
            });
        }

        reD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                board = sb.dispatchCard(size);
                dispatchCards();
            }
        });
    }

    private void setValid(int index, int res) {
        if (Build.VERSION.SDK_INT > 21) {
            ll[index].setBackground(getDrawable(res));
        } else {
            ll[index].setBackgroundDrawable(ContextCompat.getDrawable(getApplication(), res));
        }
    }

    private void dispatchCards() {
        clearBoard();
        for (int i = 0; i < size; ++i) {
            setCard(i, board.getBoard()[i]);
        }
    }

    private void clearBoard() {
        answ = new ArrayList<Integer>();
        for (int i = 0; i < size; ++i) {
            iv[i].setImageDrawable(null);
            setValid(i, R.drawable.border);
        }
    }

    private void setCard(int index, CardMin card) {
        //Form && Fill
        Drawable symb = ContextCompat.getDrawable(getApplication(), R.drawable.one_empty);
        switch (card.getForm()) {
            case 0:
                switch (card.getFill()) {
                    case 0:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.one_empty);
                        break;
                    case 1:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.one_semi);
                        break;
                    case 2:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.one_full);
                        break;
                }
                break;
            case 1:
                switch (card.getFill()) {
                    case 0:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.two_empty);
                        break;
                    case 1:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.two_semi);
                        break;
                    case 2:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.two_full);
                        break;
                }
                break;
            case 2:
                switch (card.getFill()) {
                    case 0:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.three_empty);
                        break;
                    case 1:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.three_semi);
                        break;
                    case 2:
                        symb = ContextCompat.getDrawable(getApplication(), R.drawable.three_full);
                        break;
                }
                break;
        }
        symb = DrawableCompat.wrap(symb);

        //Color
        switch (card.getColor()) {
            case 0:
                DrawableCompat.setTint(symb.mutate(), getResources().getColor(R.color.one));
                break;
            case 1:
                DrawableCompat.setTint(symb.mutate(), getResources().getColor(R.color.two));
                break;
            case 2:
                DrawableCompat.setTint(symb.mutate(), getResources().getColor(R.color.three));
                break;
        }
        iv[index].setImageDrawable(symb);
    }

    private void trySet() {
        SetMin set = new SetMin(sb.getCard(board, answ.get(0)), sb.getCard(board, answ.get(1)),
                sb.getCard(board, answ.get(2)));
        if (ss.isSetValid(set)) {
            newSet();
            success();
        } else {
            falseSet();
        }
        answ = new ArrayList<>();
    }

    private void newSet() {
        for (int i : answ) {
            sb.deleteCard(board, i);
            sb.addCard(board, i, sc.generateCard());
            setValid(i, R.drawable.border);
        }
        dispatchCards();
    }

    private void falseSet() {
        for (int i : answ) {
            setValid(i, R.drawable.border);
            Context context = getApplicationContext();
            CharSequence text = "INVALID SET";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private void success() {
        scoreI += 1;
        score.setText(String.valueOf(scoreI));
    }

    private void setTimer(long time) {
        timer.setText(String.valueOf(time / 1000));
        CountDownTimer timerC = new CountDownTimer(time, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                timer.setText("0");
                end();
            }
        };
        timerC.start();
    }

    private void end(){
        endAlert();
    }

    private void endAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View v = findViewById(R.id.end);
        builder.setView(v);
        builder.setPositiveButton(R.string.re, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        TextView tv = (TextView) this.findViewById(R.id.endTV);
        tv.setText("Bravo ! Votre score est de "+score+".");
    }
}

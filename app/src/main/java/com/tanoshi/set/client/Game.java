package com.tanoshi.set.client;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tanoshi.set.object.Board;


import com.tanoshi.set.R;
import com.tanoshi.set.object.Card;
import com.tanoshi.set.object.Set;
import com.tanoshi.set.service.ServiceBoard;
import com.tanoshi.set.service.ServiceCard;
import com.tanoshi.set.service.ServiceSet;
import com.tanoshi.set.serviceimpl.ServiceBoardImpl;
import com.tanoshi.set.serviceimpl.ServiceCardImpl;
import com.tanoshi.set.serviceimpl.ServiceSetImpl;

import java.util.ArrayList;

/**
 * Created by Human Booster on 04/01/2017.
 */

public class Game extends AppCompatActivity {
    static int size = 12;
    Button reD;
    LinearLayout[] ll;
    ImageView[][] iv;
    Board board;
    ServiceBoard sb = new ServiceBoardImpl();
    ServiceSet ss = new ServiceSetImpl();
    ServiceCard sc = new ServiceCardImpl();
    ArrayList<Integer> answ = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        linkXml();
        listen();

        ServiceBoard sb = new ServiceBoardImpl();
        board = sb.dispatchCard(size);

        dispatchCards();
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

        iv = new ImageView[size][3];
        iv[0][0] = (ImageView) findViewById(R.id.one1);
        iv[0][1] = (ImageView) findViewById(R.id.one2);
        iv[0][2] = (ImageView) findViewById(R.id.one3);
        iv[1][0] = (ImageView) findViewById(R.id.two1);
        iv[1][1] = (ImageView) findViewById(R.id.two2);
        iv[1][2] = (ImageView) findViewById(R.id.two3);
        iv[2][0] = (ImageView) findViewById(R.id.three1);
        iv[2][1] = (ImageView) findViewById(R.id.three2);
        iv[2][2] = (ImageView) findViewById(R.id.three3);

        iv[3][0] = (ImageView) findViewById(R.id.four1);
        iv[3][1] = (ImageView) findViewById(R.id.four2);
        iv[3][2] = (ImageView) findViewById(R.id.four3);
        iv[4][0] = (ImageView) findViewById(R.id.five1);
        iv[4][1] = (ImageView) findViewById(R.id.five2);
        iv[4][2] = (ImageView) findViewById(R.id.five3);
        iv[5][0] = (ImageView) findViewById(R.id.six1);
        iv[5][1] = (ImageView) findViewById(R.id.six2);
        iv[5][2] = (ImageView) findViewById(R.id.six3);

        iv[6][0] = (ImageView) findViewById(R.id.seven1);
        iv[6][1] = (ImageView) findViewById(R.id.seven2);
        iv[6][2] = (ImageView) findViewById(R.id.seven3);
        iv[7][0] = (ImageView) findViewById(R.id.eight1);
        iv[7][1] = (ImageView) findViewById(R.id.eight2);
        iv[7][2] = (ImageView) findViewById(R.id.eight3);
        iv[8][0] = (ImageView) findViewById(R.id.nine1);
        iv[8][1] = (ImageView) findViewById(R.id.nine2);
        iv[8][2] = (ImageView) findViewById(R.id.nine3);

        iv[9][0] = (ImageView) findViewById(R.id.ten1);
        iv[9][1] = (ImageView) findViewById(R.id.ten2);
        iv[9][2] = (ImageView) findViewById(R.id.ten3);
        iv[10][0] = (ImageView) findViewById(R.id.eleven1);
        iv[10][1] = (ImageView) findViewById(R.id.eleven2);
        iv[10][2] = (ImageView) findViewById(R.id.eleven3);
        iv[11][0] = (ImageView) findViewById(R.id.twelve1);
        iv[11][1] = (ImageView) findViewById(R.id.twelve2);
        iv[11][2] = (ImageView) findViewById(R.id.twelve3);
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
        for (ImageView[] iv1 : iv) {
            for (ImageView iv2 : iv1) {
                iv2.setImageDrawable(null);
            }
        }
    }

    private void setCard(int index, Card card) {
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

        //Qty
        switch (card.getQty()) {
            case 2:
                iv[index][2].setImageDrawable(symb);
            case 1:
                iv[index][1].setImageDrawable(symb);
            case 0:
                iv[index][0].setImageDrawable(symb);
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
    }

    private void trySet() {
        Set set = new Set(sb.getCard(board, answ.get(0)), sb.getCard(board, answ.get(1)),
                sb.getCard(board, answ.get(2)));
        if (ss.isSetValid(set)) {
            newSet();
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
}

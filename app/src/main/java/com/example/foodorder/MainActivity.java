package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroupSize, radioGroupTor;

    RadioButton radioButtonM, radioButton70;

    CheckBox chk_tranchauden, chk_flan, chk_pudding, chk_cheese, chk_jelly, chk_dau, chk_matcha, chk_socola, chk_kiwi, chk_cacao;

    Button btn_send;

    //String s = "";
    List<CheckBox> checkBoxList, checkBoxList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        initView();

        //Fillings checkboxs
        checkBoxList = new ArrayList<>();
        checkBoxList.add(chk_tranchauden);
        checkBoxList.add(chk_flan);
        checkBoxList.add(chk_pudding);
        checkBoxList.add(chk_cheese);
        checkBoxList.add(chk_jelly);
        checkBoxList.add(chk_dau);
        checkBoxList.add(chk_matcha);
        checkBoxList.add(chk_socola);
        checkBoxList.add(chk_kiwi);
        checkBoxList.add(chk_cacao);

        //


        //SendingMessage
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String phoneNumber = "5556";

                String s0 = getSize_Tor_Radio();
                String s1 = "Toppings " + getCheckbox(checkBoxList);
                String message = "Tôi muốn order trà sữa : "+s0+s1;

                Log.i("message", s0 + s1 );

                send_SMS(phoneNumber,message);
            }
        });





    }

    private void send_SMS(String phoneNumber,String message){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + phoneNumber));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
    private String getSize_Tor_Radio() {
        int id_size = radioGroupSize.getCheckedRadioButtonId();
        int id_tor = radioGroupTor.getCheckedRadioButtonId();
        RadioButton radioButtonSize = (RadioButton) findViewById(id_size);
        RadioButton radioButtonTor = (RadioButton) findViewById(id_tor);

        Log.i("a", "size " + radioButtonSize.getText());
        Log.i("a", "tor " + radioButtonTor.getText());

        return "Size : " + radioButtonSize.getText() + " Lượng đường " + radioButtonTor.getText() + " ";
    }

    private String getCheckbox(List<CheckBox> checkBoxList) {
        String s = "";
        for (CheckBox item : checkBoxList) {
            if (item.isChecked()) {
                s += item.getText() + " ";
            }
        }
        return s;
    }


    private void initView() {
        //
        radioGroupSize = findViewById(R.id.radioGroup_Size);
        radioGroupTor = findViewById(R.id.radioGroup_Tortilla);

        //
        radioButtonM = findViewById(R.id.radioButtonM);
        radioButton70 = findViewById(R.id.radioButton70);
        //default
        radioButtonM.setChecked(true);
        radioButton70.setChecked(true);

        //
        chk_tranchauden = findViewById(R.id.checkBoxtranchauden);
        chk_flan = findViewById(R.id.checkBoxflan);
        chk_pudding = findViewById(R.id.checkBoxpudding);
        chk_cheese = findViewById(R.id.checkBoxcheese);
        chk_jelly = findViewById(R.id.checkBoxjelly);
        chk_dau = findViewById(R.id.checkBoxdau);
        chk_matcha = findViewById(R.id.checkBoxmatcha);
        chk_socola = findViewById(R.id.checkBoxsocola);
        chk_kiwi = findViewById(R.id.checkBoxkiwi);
        chk_cacao = findViewById(R.id.checkBoxcacao);

        //
        btn_send = findViewById(R.id.button);


    }
}

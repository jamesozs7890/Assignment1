package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    double input;
    double result = 0;
    Toast sameScale;
    Toast emptyField;
    Toast error;
    String converted;

    EditText inputValue;
    TextView output;
    Spinner sp1,sp2;
    Button convertBtn,resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sameScale = Toast.makeText(this,"Please select different Scale",Toast.LENGTH_SHORT);
        emptyField = Toast.makeText(this,"Please enter a value in the input box", Toast.LENGTH_SHORT);
        error = Toast.makeText(this,"An error occured",Toast.LENGTH_SHORT);

        inputValue = (EditText) findViewById(R.id.editTextInput);
        output = (TextView) findViewById(R.id.resultTextView);
        sp1 =(Spinner) findViewById(R.id.spinnerFrom);
        sp2 =(Spinner) findViewById(R.id.spinnerTo);
        convertBtn=(Button) findViewById(R.id.buttonConvert);
        resetBtn=(Button) findViewById(R.id.buttonReset);



        convertBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                if(!TextUtils.isEmpty(inputValue.getText().toString())){

                    input = Double.parseDouble(inputValue.getText().toString());

                   if(sp1.getSelectedItemPosition()==0 && sp2.getSelectedItemPosition()==1){
                        result = (9/5)*(input-273)+32;
                    }else if(sp1.getSelectedItemPosition()==0 && sp2.getSelectedItemPosition()==2){
                       result = input-273;
                    }else if(sp1.getSelectedItemPosition()==1 && sp2.getSelectedItemPosition()==0) {
                       result = (5/9) * (input - 32) + 273;
                    }else if(sp1.getSelectedItemPosition()==1 && sp2.getSelectedItemPosition()==2) {
                       result = (5/9) * (input - 32);
                    }else if(sp1.getSelectedItemPosition()==2 && sp2.getSelectedItemPosition()==0) {
                       result = (input+273);
                    }else if(sp1.getSelectedItemPosition()==2 && sp2.getSelectedItemPosition()==1) {
                       result = (9/5)*(input)+32;
                    }else if (sp1.getSelectedItemPosition()==sp2.getSelectedItemPosition()){
                       sameScale.show();
                       result = input;
                    }else{
                        error.show();
                    }

                    converted = Double.toString(result);
                    output.setText(converted);

                }else{
                    emptyField.show();
                }

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inputValue.getText().clear();
                output.setText("0");
            }
        });
    }



    }


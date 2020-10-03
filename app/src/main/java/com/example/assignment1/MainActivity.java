package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    double input;
    Toast sameScale;

    double FahrToKel,FahrToCels;
    double KelToFahr,KelToCels;
    double CelsToFahr,CelsToKel;

    EditText inputValue;
    TextView output;
    Spinner sp1,sp2;
    Button convertBtn,resetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sameScale = Toast.makeText(this,"Please select different Scale",Toast.LENGTH_SHORT);

        inputValue = (EditText) findViewById(R.id.editTextInput);
        output = (TextView) findViewById(R.id.resultTextView);
        sp1 =(Spinner) findViewById(R.id.spinnerFrom);
        sp2 =(Spinner) findViewById(R.id.spinnerTo);
        convertBtn=(Button) findViewById(R.id.buttonConvert);
        resetBtn=(Button) findViewById(R.id.buttonReset);

        convertBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                sameScale.show();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inputValue.getText().clear();
                output.setText(Integer.toString(0));
            }
        });
    }
}
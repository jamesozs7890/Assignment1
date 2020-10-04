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
    Toast sameScale;
    Toast emptyField;

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

        inputValue = (EditText) findViewById(R.id.editTextInput);
        output = (TextView) findViewById(R.id.resultTextView);
        sp1 =(Spinner) findViewById(R.id.spinnerFrom);
        sp2 =(Spinner) findViewById(R.id.spinnerTo);
        convertBtn=(Button) findViewById(R.id.buttonConvert);
        resetBtn=(Button) findViewById(R.id.buttonReset);



        convertBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String converted;

                if(!TextUtils.isEmpty(inputValue.getText().toString())){
                    input = Double.parseDouble(inputValue.getText().toString());
                    if(sp1.getSelectedItem()=="Kelvin(K)"){
                        converted = Double.toString(Kelvin(input));
                        output.setText(converted);
                    }else if(sp1.getSelectedItem()=="Fahrenheit(°F)"){
                        converted = Double.toString(Fahrenheit(input));
                        output.setText(converted);
                    }else
                        converted = Double.toString(Celsius(input));
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

    double Kelvin(double i){
        double result;

        if(sp2.getSelectedItem() == "Fahrenheit(°F)"){
            result = 9/5*(i-273)+32;
            return result;
        }else if (sp2.getSelectedItem() == "Celcius(°C)") {
            result = i-273;
            return result;
        }else if(sp2.getSelectedItem() == "Kelvin(K)") {
            result = i;
            sameScale.show();
            return result;
        }else {
            return 0;
        }
    }

    double Fahrenheit(double i){
        double result;

        if(sp2.getSelectedItem() == "Kelvin(K)"){
            result = 5/9*(i-32)+273;
            return result;
        }else if (sp2.getSelectedItem() == "Celcius(°C)") {
            result = 5/9*(i-32);
            return result;
        }else if(sp2.getSelectedItem() == "Fahrenheit(°F)") {
            result = i;
            sameScale.show();
            return result;
        }else{
            return 0;
        }



    }

    double Celsius(double i){
        double result;

        if(sp2.getSelectedItem() == "Kelvin(K)"){
            result = i+273;
            return result;
        }else if (sp2.getSelectedItem() == "Fahrenheit(°F)") {
            result = 9/5*(i)+32;
            return result;
        }else if(sp2.getSelectedItem() == "Celcius(°C)") {
            result = i;
            sameScale.show();
            return result;
        }else{
            return 0;
        }


    }
}


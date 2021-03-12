package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;

    private Button add;
    private Button substract;
    private Button multiply;
    private Button divide;

    private Button equals;
    private Button plusMinus;
    private Button point;
    private Button clear;

    String value="";
    String op ="=";
    String oldValue="0.0";
    String newValue="0.0";
    int compteur= 0;
    double resu = 0.0;
    Double lastValue =0.0;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On associe les objets aux vues
        display = findViewById(R.id.display);
        zero = findViewById(R.id.zeroBTN);
        one = findViewById(R.id.oneBTN);
        two = findViewById(R.id.twoBTN);
        three = findViewById(R.id.threeBTN);
        four = findViewById(R.id.fourBTN);
        five = findViewById(R.id.fiveBTN);
        six = findViewById(R.id.sixBTN);
        seven = findViewById(R.id.sevenBTN);
        eight = findViewById(R.id.eightBTN);
        nine = findViewById(R.id.nineBTN);

        add = findViewById(R.id.addBTN);
        substract = findViewById(R.id.substractBTN);
        multiply = findViewById(R.id.multiplyBTN);
        divide = findViewById(R.id.divideBTN);

        equals = findViewById(R.id.equalsBTN);
        plusMinus = findViewById(R.id.plusMinusBTN);
        point = findViewById(R.id.pointBTN);
        clear = findViewById(R.id.clearBTN);

        // On attribue un listener adapté aux vues qui en ont besoin
        zero.setOnClickListener(zeroListener);
        one.setOnClickListener(oneListener);
        two.setOnClickListener(twoListener);
        three.setOnClickListener(threeListener);
        four.setOnClickListener(fourListener);
        five.setOnClickListener(fiveListener);
        six.setOnClickListener(sixListener);
        seven.setOnClickListener(sevenListener);
        eight.setOnClickListener(eightListener);
        nine.setOnClickListener(nineListener);

        add.setOnClickListener(addListener);
        substract.setOnClickListener(substractListener);
        multiply.setOnClickListener(multiplyListener);
        divide.setOnClickListener(divideListener);

        equals.setOnClickListener(equalsListener);

        plusMinus.setOnClickListener(plusMinusListener);
        point.setOnClickListener(pointListener);
        clear.setOnClickListener(clearListener);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            display.setShowSoftInputOnFocus(false);
        }

        display.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }


    private void value(String value){
        if(value == ""){
            this.value = "";
        }
        this.value = this.value +value;
    }


    private View.OnClickListener zeroListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("0");
            display.setText(value);
        }
    };

    private View.OnClickListener oneListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("1");
            display.setText(value);
        }
    };

    private View.OnClickListener twoListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("2");
            display.setText(value);
        }
    };

    private View.OnClickListener threeListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("3");
            display.setText(value);
        }
    };

    private View.OnClickListener fourListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("4");
            display.setText(value);
        }
    };

    private View.OnClickListener fiveListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("5");
            display.setText(value);
        }
    };

    private View.OnClickListener sixListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("6");
            display.setText(value);
        }
    };

    private View.OnClickListener sevenListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("7");
            display.setText(value);
        }
    };

    private View.OnClickListener eightListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("8");
            display.setText(value);
        }
    };

    private View.OnClickListener nineListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value("9");
            display.setText(value);
        }
    };

    private View.OnClickListener addListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            operation(v);
        }
    };

    private View.OnClickListener substractListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            operation(v);
        }
    };

    private View.OnClickListener multiplyListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            operation(v);
        }
    };

    private View.OnClickListener divideListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            operation(v);
        }
    };

    private View.OnClickListener plusMinusListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            display.setText("-"+value);
        }
    };

    private View.OnClickListener pointListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            value += ".";
            display.setText(value);
        }
    };

    private View.OnClickListener clearListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String val = "";
            value="";
            display.setText(val);
            resu =0.0;
            compteur=0;
            op="=";
        }
    };

    //Reconnaitre l'opération et l'associer à "op"
    public void operation(View v){
        oldValue = display.getText().toString();
        display.setText("");

        //On récupère l'ID de l'opération associée à la vue
        switch(v.getId()){
            case R.id.addBTN:
                op ="+";
                compteur=0;
                break;
            case R.id.substractBTN:
                op ="-";
                compteur=0;
                break;
            case R.id.multiplyBTN:
                op ="*";
                compteur=0;
                break;
            case R.id.divideBTN:
                op ="/";
                compteur=0;
                break;
        }
        value("");
    }



    private View.OnClickListener equalsListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            /**Initialisation de newValue et oldValue à 0.0 si display == chaine vide
             * Dans le cas contraire oldValue garde la valeur du premier nombre saisie avant de cliquer sur l'opération
             * Et newValue recupère la valeur saisie dans le display
             */
            newValue = display.getText().toString();
            if(newValue.equals("")){
                newValue ="0.0";
            }

            if(oldValue.equals("")){
                oldValue ="0.0";
            }

            // Premiere operation on clique sur equals pour la premiere pas et/ou de façon successive
            if (compteur == 0) {
                switch (op) {
                    case "+":
                        resu = Double.parseDouble(oldValue) + Double.parseDouble(newValue);
                        display.setText(resu + "");
                        lastValue = Double.parseDouble(newValue);
                        break;
                    case "-":
                        resu = Double.parseDouble(oldValue) - Double.parseDouble(newValue);
                        display.setText(resu + "");
                        lastValue = Double.parseDouble(newValue);
                        break;
                    case "*":
                        resu = Double.parseDouble(oldValue) * Double.parseDouble(newValue);
                        display.setText(resu + "");
                        lastValue = Double.parseDouble(newValue);
                        break;
                    case "/":
                        if (Double.parseDouble(newValue) == 0.0) {
                            String message = "Impossible de diviser par 0";
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                            value("");
                            op="=";
                            resu=0.0;
                            display.setText("");
                            break;
                        } else {
                            resu = Double.parseDouble(oldValue) / Double.parseDouble(newValue);
                            display.setText(resu + "");
                            lastValue = Double.parseDouble(newValue);
                            break;
                        }
                    case "=":
                        display.setText(resu + "");
                        break;

                }

            }

            // On click 2 fois de suite ou plus sur equals on addition le resultat avec la derniere valeur saisie
            if(compteur >= 1 ){
                Toast.makeText(MainActivity.this, "je suis dans le compteur n° "+compteur, Toast.LENGTH_LONG).show();
                switch (op){
                    case "+":
                        resu = Double.parseDouble(newValue) + lastValue;
                        display.setText(resu+"");
                        break;
                    case "-":
                        resu = Double.parseDouble(newValue) - lastValue;
                        display.setText(resu+"");
                        break;
                    case "*":
                        resu = Double.parseDouble(newValue) * lastValue;
                        display.setText(resu+"");
                        break;
                    case "/":
                        resu = Double.parseDouble(newValue) / lastValue;
                        display.setText(resu+"");
                        break;
                }
            }
            compteur++;
        }
    };



}
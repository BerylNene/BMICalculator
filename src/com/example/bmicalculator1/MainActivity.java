package com.example.bmicalculator1;

import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final RadioGroup group = (RadioGroup) findViewById(R.id.ubitRadioGroup);
		final RadioButton englishRadio1 = (RadioButton) findViewById(R.id.englishRadio);
		final RadioButton metricRadio1 = (RadioButton) findViewById(R.id.metricRadio);
		final EditText yourWeight = (EditText) findViewById(R.id.weightEdit);
		final EditText yourHeight = (EditText) findViewById(R.id.heightEdit);
		final TextView largeText = (TextView) findViewById(R.id.largeText);
		final TextView calcAnalysis = (TextView) findViewById(R.id.calcAnalysisText);
		final Button calculate = (Button) findViewById(R.id.calculateButton);

		
		englishRadio1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					yourWeight.setHint("in pounds");
					yourHeight.setHint("in inches");
				}

			}
		});
		
		
		metricRadio1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					yourWeight.setHint("in kg");
					yourHeight.setHint("in meter");
				}

			} 
		});
		
		
		calculate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(yourWeight.getText()
						.toString().length()>0 && yourHeight.getText()
						.toString().length()>0){
				double weight = Float.parseFloat(yourWeight.getText()
						.toString());
				double height = Float.parseFloat(yourHeight.getText()
						.toString());

				DecimalFormat d = new DecimalFormat("0.00");
				if (metricRadio1.isChecked()) {
					double calculate = weight / (height * height);
					calcAnalysis.setText("Your BMI is: " + "" + d.format(calculate));
					if (calculate < 18.5) {
						largeText.setText("You are less than the standand BMI, so you are UnderWeight");
					}
					if (calculate > 18.5 && calculate < 24.9) {
						largeText.setText("Your BMI is standard, so you are Normal Weight");
					}
					if (calculate > 25 && calculate < 29.9) {
						largeText.setText("You are quite more than the standard BMI, so you are Overweight");
					}
					if (calculate > 30) {
						largeText.setText("You are much more than the standard BMI, so you are Obese");
					}
					
					
				} else if (englishRadio1.isChecked()) {
					double calculate = ((weight * 703) / (height * height));
					calcAnalysis.setText("Your BMI is :" + "" + d.format(calculate));
					if (calculate < 18.5) {
						largeText.setText("You are less than the standand BMI, so you are UnderWeight");
					}
					if (calculate > 18.5 && calculate < 24.9) {
						largeText.setText("Your BMI is standard, so you are Normal Weight");
					}
					if (calculate > 25 && calculate < 29.9) {
						largeText.setText("You are quite more than the standard BMI, so you are Overweight");
					}
					if (calculate > 30) {
						largeText.setText("You are much more than the standard BMI, so you are Obese");
					}
				}
			}else{
				Toast.makeText(MainActivity.this, "enter values ", Toast.LENGTH_SHORT).show();
			}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
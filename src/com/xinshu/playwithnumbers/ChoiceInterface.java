package com.xinshu.playwithnumbers;

/*
 * Copyright (c) 2014 xinshu
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * 
 * @author Shaola Ren
 *
 */

public class ChoiceInterface extends ActionBarActivity{
	public final static String HARD_LEVEL = "levelMessage";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice_interface);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choice_interface, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void selectInteger(View view) {
		TextView intOrFloat = (TextView)findViewById(R.id.int_or_float); 
		intOrFloat.setText("Integer or Decimal: Integer");
	}
	
	public void selectDecimal(View view) {
		TextView intOrFloat = (TextView)findViewById(R.id.int_or_float); 
		intOrFloat.setText("Integer or Decimal: Decimal");
	}
	
	public void selectOne(View view) {
		TextView level = (TextView)findViewById(R.id.level); 
		level.setText("Hard Level: 1");
		MainActivity.range = 10;
	}
	
	public void selectTwo(View view) {
		TextView level = (TextView)findViewById(R.id.level); 
		level.setText("Hard Level: 2");
		MainActivity.range = 100;
	}
	
	public void selectThree(View view) {
		TextView level = (TextView)findViewById(R.id.level); 
		level.setText("Hard Level: 3");
		MainActivity.range = 10000;
	}
	
	public void selectPlusMinus(View view) {
		TextView operator = (TextView)findViewById(R.id.operator); 
		operator.setText("Select Operators: + -");
		MainActivity.opSelection = 0;
	}
	
	public void selectProductDivide(View view) {
		TextView operator = (TextView)findViewById(R.id.operator); 
		operator.setText("Select Operators: * /");
		MainActivity.opSelection = 1;
	}
	
	public void selectFourOp(View view) {
		TextView operator = (TextView)findViewById(R.id.operator); 
		operator.setText("Select Operators: + - * /");
		MainActivity.opSelection = 2;
	}
	
	public void goToMainActivity(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}


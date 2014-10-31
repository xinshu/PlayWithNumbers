package com.xinshu.playwithnumbers;

/*
 * Copyright (c) 2014 xinshu
 */

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 
 * @author Shaola Ren
 *
 */

public class MainActivity extends ActionBarActivity {
	String[] equation = new String[2];
	boolean integer = true;
	public static int range = 10;
	public static int opSelection = 0;
	int countTotal;
	int countCorrect;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	private void init() {
		countTotal = 1;
		countCorrect = 0;
		generateQuestion();
		TextView feedBack = (TextView)findViewById(R.id.feed_back);
		feedBack.setText("");
		TextView score = (TextView)findViewById(R.id.score);
		score.setText("0/0");
	}
	
	public void getAnswer(View view) {
		EditText ans = (EditText)findViewById(R.id.answer);
		String userAnswer = ans.getText().toString();
		userAnswer = simplifyAnswer(userAnswer);
		String feed;
		if (userAnswer.equals(equation[1])) {
			feed = "Right!";
			countCorrect++;
		}
		else {
			String correctAns = equation[0] + " = " + equation[1];
			feed = "Wrong! " + correctAns;
		}
		TextView feedBack = (TextView)findViewById(R.id.feed_back);
		feedBack.setText(feed);
		TextView score = (TextView)findViewById(R.id.score);
		String rate = countCorrect + "/" + countTotal;
		score.setText(rate);
		generateQuestion();
		countTotal++;
	}
	
	private void generateQuestion() {
		Random rnd = new Random();
		int a = rnd.nextInt(range);
		int b = rnd.nextInt(range);
		int c;
		int operator = rnd.nextInt(4);
		if (opSelection == 0) {
			c = a + b;
			if (operator % 2 == 0) {
				equation[0] = a + " + " + b;
				equation[1] = c + "";
			}
			else {
				equation[0] = c + " - " + b;
				equation[1] = a + "";
			}
		}
		else if (opSelection == 1) {
			c = a * b;
			if ((a == 0 && b == 0) || operator % 2 == 0) {
				equation[0] = a + " * " + b;
				equation[1] = c + "";
			}
			else {
				if (b != 0) {
					equation[0] = c + " / " + b;
					equation[1] = a + "";
				}
				else {
					equation[0] = c + " / " + a;
					equation[1] = b + "";
				}
			}
		}
		else {
			if (operator < 2) {
				c = a + b;
				if (operator == 0) {
					equation[0] = a + " + " + b;
					equation[1] = c + "";
				}
				else {
					equation[0] = c + " - " + b;
					equation[1] = a + "";
				}
			}
			else {
				c = a * b;
				if ((a == 0 && b == 0) || operator == 2) {
					equation[0] = a + " * " + b;
					equation[1] = c + "";
				}
				else {
					if (b != 0) {
						equation[0] = c + " / " + b;
						equation[1] = a + "";
					}
					else {
						equation[0] = c + " / " + a;
						equation[1] = b + "";
					}
				}
			}
		}
		TextView que = (TextView)findViewById(R.id.question);
		que.setText(equation[0]);
		EditText ans = (EditText)findViewById(R.id.answer);
		ans.setText("");
	}
	
	public void clear(View view) {
		init();
	}
	
	private String simplifyAnswer(String s) {
		return s.trim();
	}
	
	public void choiceInterface(View view) {
		Intent intent = new Intent(this, ChoiceInterface.class);
		startActivity(intent);
	}

}


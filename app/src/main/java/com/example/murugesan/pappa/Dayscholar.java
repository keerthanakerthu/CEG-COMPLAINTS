package com.example.murugesan.pappa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Dayscholar extends Activity {
    public final static String EXTRA_MESSAGE1 = "com.example.murugesan.paapa.MESSAGE1";
    private RadioGroup radioGroup;
    private RadioButton radioButtons;
    private Button btnDisplay;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayscholar);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        btnDisplay=(Button)findViewById(R.id.button);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButtons = (RadioButton) findViewById(selectedId);
                Toast.makeText(Dayscholar.this, radioButtons.getText(), Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), Problem.class);
                    String message2 = "Bus Pass Problem";

                    intent.putExtra(EXTRA_MESSAGE1, message2);
                    startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dayscholar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
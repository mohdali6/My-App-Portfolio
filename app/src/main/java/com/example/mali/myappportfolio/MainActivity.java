package com.example.mali.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClick(View view) {
        Button button = (Button) view;

        String textToDisplay = button.getText().toString().split(":")[0];
        String[] textSplitOnSpaces = textToDisplay.split(" ");

        if (!textSplitOnSpaces[textSplitOnSpaces.length - 1].equalsIgnoreCase("app")) {
            textToDisplay = getString(R.string.toastText).concat(" ").concat(textToDisplay.concat(" app!"));
        } else {
            textToDisplay = getString(R.string.toastText).concat(" ").concat(textToDisplay.concat("!"));
        }

        Toast toast = Toast.makeText(getApplicationContext(), textToDisplay, Toast.LENGTH_SHORT);
        TextView toastTextView = (TextView) toast.getView().findViewById(android.R.id.message);
        if (toastTextView != null) toastTextView.setGravity(Gravity.CENTER);
        toast.show();
    }

}

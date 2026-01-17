package com.example.task13_ya;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity
{
    private TextView tvSummary;
    private ConstraintLayout mainLayout;
    private Button btn1;
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * Handles action bar item clicks.
     * <p>
     * This method is called whenever an item in your options menu is selected.
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_credits)
        {
            Intent intent = new Intent(this, Credits.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        mainLayout = findViewById(R.id.main);
        tvSummary = findViewById(R.id.tvSummary);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showEventDialog();
            }
        });
    }

    private void showEventDialog()
    {
        View dialog_btn1 = getLayoutInflater().inflate(R.layout.dialog_btn1, null);
        ImageButton ibPool = dialog_btn1.findViewById(R.id.btn1Alart1);
        ImageButton idShow = dialog_btn1.findViewById(R.id.btn2Alart1);
        ImageButton idParty = dialog_btn1.findViewById(R.id.btn3Alart1);
        ImageButton idHapning = dialog_btn1.findViewById(R.id.btn4Alart1);

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setView(dialog_btn1);
        adb.setCancelable(false);
        final AlertDialog ad = adb.create();
        ibPool.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mainLayout.setBackgroundColor(Color.CYAN);
                tvSummary.setText("POOL");
                ad.dismiss();
            }
        });
        idShow.setOnClickListener(v ->
        {
            mainLayout.setBackgroundColor(Color.RED);
            tvSummary.setText("SHOW");
            ad.dismiss();
        });
        idParty.setOnClickListener(v ->
        {
            mainLayout.setBackgroundColor(Color.YELLOW);
            tvSummary.setText("PARTY");
            ad.dismiss();
        });
        idHapning.setOnClickListener(v ->
        {
            mainLayout.setBackgroundColor(Color.GREEN);
            tvSummary.setText("HAPNING");
            ad.dismiss();
        });
        ad.show();
    }
}
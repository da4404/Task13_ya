package com.example.task13_ya;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity
{
    private TextView tvSummary;
    private ConstraintLayout mainLayout;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

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
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        mainLayout = findViewById(R.id.main);
        tvSummary = findViewById(R.id.tvSummary);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEquipmentDialog();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showEventDialog();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingDialog();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showResetDialog();
            }
        });
    }

    private void showResetDialog()
    {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_btn4, null);

        Button btnYes = dialogView.findViewById(R.id.btnYesReset);
        Button btnNo = dialogView.findViewById(R.id.btnNoReset);

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setView(dialogView);
        adb.setCancelable(false);
        final AlertDialog ad = adb.create();
        btnYes.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.WHITE);
            tvSummary.setText("");
            ad.cancel();
        });
        btnNo.setOnClickListener(v -> ad.cancel());
        ad.show();
    }
    /**
     * Opens a dialog with EditText and RatingBar.
     * Shows a Toast message with the input data upon submission.
     */
    private void showRatingDialog()
    {
        View myView = getLayoutInflater().inflate(R.layout.dialog_btn3, null);
        EditText etName = myView.findViewById(R.id.etOrganizer);
        RatingBar rb = myView.findViewById(R.id.rbStars);
        Button btnSubmit = myView.findViewById(R.id.btnSubmitRating);
        Button btnCancel = myView.findViewById(R.id.btnCancelRating);
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setView(myView);
        adb.setCancelable(false);
        final AlertDialog ad = adb.create();
        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString();
            float rating = rb.getRating();
            Toast.makeText(MainActivity.this,
                    "Organizer: " + name + ", Rating: " + rating,
                    Toast.LENGTH_LONG).show();
            tvSummary.setText("Rated: " + rating + " Stars");

            ad.cancel();
        });
        btnCancel.setOnClickListener(v -> ad.cancel());
        ad.show();
    }
    private void showEquipmentDialog()
    {
        View myView = getLayoutInflater().inflate(R.layout.dialog_btn2, null);
        CheckBox cb1 = myView.findViewById(R.id.cbChairs);
        CheckBox cb2 = myView.findViewById(R.id.cbGenerator);
        CheckBox cb3 = myView.findViewById(R.id.cbLighting);
        CheckBox cb4 = myView.findViewById(R.id.cbDrinks);
        CheckBox cb5 = myView.findViewById(R.id.cbMusic);
        Button btnAdd = myView.findViewById(R.id.btnConfirmEquip);
        Button btnNo = myView.findViewById(R.id.btnCancelEquip);
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setView(myView);
        adb.setCancelable(false);
        final AlertDialog ad = adb.create();
        btnAdd.setOnClickListener(v ->
        {
            String str = "Equipment: ";
            if (cb1.isChecked()) str += "Chairs, ";
            if (cb2.isChecked()) str += "Generator, ";
            if (cb3.isChecked()) str += "Lighting, ";
            if (cb4.isChecked()) str += "Drinks, ";
            if (cb5.isChecked()) str += "Music, ";
            if (str.endsWith(", "))
            {
                str = str.substring(0, str.length() - 2);
            }

            tvSummary.setText(str);
            ad.cancel();
        });

        btnNo.setOnClickListener(v -> ad.cancel());
        ad.show();
    }

    private void showEventDialog()
    {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_btn1, null);

        ImageButton ibPool = dialogView.findViewById(R.id.btn1Alart1);
        ImageButton idShow = dialogView.findViewById(R.id.btn2Alart1);
        ImageButton idParty = dialogView.findViewById(R.id.btn3Alart1);
        ImageButton idHapning = dialogView.findViewById(R.id.btn4Alart1);

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setView(dialogView);
        adb.setCancelable(false);

        final AlertDialog ad = adb.create();

        ibPool.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.CYAN);
            tvSummary.setText("Event: Pool Party");
            ad.cancel();
        });
        idShow.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.MAGENTA);
            tvSummary.setText("Event: Live Show");
            ad.cancel();
        });
        idParty.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.YELLOW);
            tvSummary.setText("Event: Street Party");
            ad.cancel();
        });
        idHapning.setOnClickListener(v -> {
            mainLayout.setBackgroundColor(Color.GREEN);
            tvSummary.setText("Event: Urban Picnic");
            ad.cancel();
        });
        ad.show();
    }
}
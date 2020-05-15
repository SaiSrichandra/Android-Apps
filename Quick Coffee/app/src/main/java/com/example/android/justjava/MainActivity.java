/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import java.text.NumberFormat;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava.R;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int noc = 0;
    String c1,c2,Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        EditText nam = (EditText) findViewById(R.id.name_edit);
        Name = nam.getText().toString();
        CheckBox cb1 = (CheckBox) findViewById(R.id.wp_checkbox);
        CheckBox cb2 = (CheckBox) findViewById(R.id.co_checkbox);
        if(cb1.isChecked())
            c1 = "Yes";
        else
            c1 = "No";
        if(cb2.isChecked())
            c2 = "Yes";
        else
            c2 = "No";
        createOrderSummary(noc,c1,c2,Name);
    }
    public void Increment(View view) {
        if(noc>=100) {
            Toast.makeText(getApplicationContext(),"Maximum of 100 Coffees allowed", Toast.LENGTH_SHORT).show();
            return;
        }
        noc = noc + 1;
        displayQuantity(noc);
    }
    public void Decrement(View view) {
        noc = noc - 1;
        if (noc<=0) {
            Toast.makeText(getApplicationContext(),"Minimum of 1 Coffee allowed", Toast.LENGTH_SHORT).show();
            noc = 1;
        }
        displayQuantity(noc);
    }
    public int calculatePrice(int quantity, int perCup)
    {   int toppings=0;
        if (c1 == "Yes")
            toppings += 1;
        if (c2 == "Yes")
            toppings += 2;
        return (perCup+toppings)*quantity;
    }
    private void createOrderSummary(int p, String check1, String check2, String naMe)
    {
        String message = "Name : "+naMe+"\nAdd Whipped Cream : "+check1+"\nAdd Chocolate : "+check2+"\nQuantity : "+noc+"\nTotal : $"+calculatePrice(noc,5)+"\nThank You!";
        String address[] = {"saisrichandra@gmail.com"};
        String subject = "A Coffee Order from "+naMe;
        Mail(address,subject,message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */


    public void Mail(String[] mAddress, String mSub, String body)
    {
        Intent it = new Intent(Intent.ACTION_SENDTO);
        it.setData(Uri.parse("mailto:"));
        it.putExtra(Intent.EXTRA_EMAIL,mAddress);
        it.putExtra(Intent.EXTRA_SUBJECT, mSub);
        it.putExtra(Intent.EXTRA_TEXT, body);
        if(it.resolveActivity(getPackageManager()) != null)
            startActivity(it);

    }
}

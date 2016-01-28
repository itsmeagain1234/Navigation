package com.example.android.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText editFrom;
    private EditText editTo;
    private Button btnGo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFrom = (EditText) findViewById(R.id.editFrom);
        editTo = (EditText) findViewById(R.id.editTo);
        btnGo = (Button) findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new OnClickListener() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void onClick(final View v) {
                if("".equals(editFrom.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "Enter the starting point", Toast.LENGTH_SHORT).show();
                }
                else if("".equals(editTo.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this, "Enter the destination point", Toast.LENGTH_SHORT).show();
                }
                else {
                    final Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    intent.putExtra("FROM", editFrom.getText().toString().trim());
                    intent.putExtra("TO", editTo.getText().toString().trim());
                    //Log.d("vvvv",editFrom.getText().toString());
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}




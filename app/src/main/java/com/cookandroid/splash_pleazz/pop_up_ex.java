package com.cookandroid.splash_pleazz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class pop_up_ex extends AppCompatActivity {
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_ex);

        txtResult = (TextView)findViewById(R.id.txtResult);
    }

    public void mOnPopupClick(View v){
        Intent intent = new Intent(this,PopupActivity.class);
        intent.putExtra("data","Test Popup");
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }
}

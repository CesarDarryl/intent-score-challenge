package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ScorerActivity extends AppCompatActivity {

    EditText scorerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);
        scorerName = findViewById(R.id.editText);
    }

    public void handleFinishNamed(View view) {
        String scorer = scorerName.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("pencetak",scorer);
        setResult(RESULT_OK,resultIntent);
        finish();
    }
}

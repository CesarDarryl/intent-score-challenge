package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static id.putraprima.skorbola.MatchActivity.RESULT;

public class ResultActivity extends AppCompatActivity {
    public static final String RESULT = "result";
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView3);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            //TODO : Display Value
            result.setText("Name Of Winning Team "+extras.getString(RESULT));
        }
    }
}

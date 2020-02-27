package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static id.putraprima.skorbola.MatchActivity.RESULT;
import static id.putraprima.skorbola.MatchActivity.SCORER;

public class ResultActivity extends AppCompatActivity {
    private TextView result,scorer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView3);
        scorer = findViewById(R.id.texxView_Scorer);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            //TODO : Display Value
            String txt = result.getText().toString();
            String txtScorer = scorer.getText().toString();
            result.setText(txt +" "+extras.getString(RESULT));
            scorer.setText(extras.getString(txtScorer+"\n"+SCORER));
        }
    }
}

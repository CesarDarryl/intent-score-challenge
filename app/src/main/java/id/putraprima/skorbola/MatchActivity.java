package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    public static final String HOME_TEAM = "hometeam";
    public static final String AWAY_TEAM = "awayteam";
    public static final String RESULT = "result";
    public static final String IMAGE_KEY_HOME = "imagekeyhome";
    public static final String IMAGE_KEY_AWAY = "imagekeyaway";
    private TextView namehome,nameaway;
    private int homeScore = 0 ,awayScore = 0 ;
    private TextView homeScoretxt,awayScoretxt;
    private ImageView homeflag;
    private ImageView awayflag;
    private TextView scorerHome;
    private TextView scorerAway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO Binding
        namehome = findViewById(R.id.txt_home);
        nameaway = findViewById(R.id.txt_away);
        homeflag = findViewById(R.id.home_logo);
        awayflag = findViewById(R.id.away_logo);
        scorerHome = findViewById(R.id.scorerHome_);
        scorerAway = findViewById(R.id.scorerAway_);
        homeScoretxt = (TextView) findViewById(R.id.score_home);
        awayScoretxt = (TextView) findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            //TODO : display value here
            namehome.setText(extras.getString(HOME_TEAM));
            nameaway.setText(extras.getString(AWAY_TEAM));
            Bitmap home = extras.getParcelable("imagekeyhome");
            Bitmap away = extras.getParcelable("imagekeyaway");
            homeflag.setImageBitmap(home);
            awayflag.setImageBitmap(away);
        }

        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan memindah activity ke scorerActivity dimana pada scorer activity di isikan nama pencetak gol
        //3.Dari activity scorer akan mengirim kembali ke activity matchactivity otomatis nama pencetak gol dan skor bertambah +1
        //4.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang beserta nama pencetak gol ke ResultActivity, jika seri di kirim text "Draw",
    }

    public void handleAddHomeScore(View view) {
        Intent intent = new Intent(this,ScorerActivity.class);
        startActivityForResult(intent,1);
        homeScore++;
    }

    public void handleAddAwayScore(View view) {
        Intent intent = new Intent(this,ScorerActivity.class);
        startActivityForResult(intent,2);
        awayScore++;
    }
    //TODO : Overide the onActivityResult


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            if(resultCode == RESULT_OK)
            {
                String a = scorerHome.getText().toString();
                String scorer = data.getStringExtra("pencetak");
                scorerHome.setText(a + "\n" + scorer);
                homeScoretxt.setText(Integer.toString(homeScore));
            }
        }
        if(requestCode == 2)
        {
            if(resultCode == RESULT_OK)
            {
                String a = scorerAway.getText().toString();
                String scorer = data.getStringExtra("pencetak");
                scorerAway.setText(a + "\n" + scorer);
                awayScoretxt.setText(Integer.toString(awayScore));
            }
        }
    }

    public void handleResultBtn(View view) {
        String NameHome = namehome.getText().toString();
        String NameAway = nameaway.getText().toString();
        String Draw = " : HASIL NYA DRAW";
        Intent intent = new Intent(this,ResultActivity.class);
        if( awayScore > homeScore )
        {
            intent.putExtra(RESULT,NameAway);
            startActivity(intent);
        }
        else if( awayScore < homeScore )
        {
            intent.putExtra(RESULT,NameHome);
            intent.putExtra(RESULT,NameHome);
            startActivity(intent);
        }else
        {
            intent.putExtra(RESULT,Draw);
            startActivity(intent);
        }
    }
}

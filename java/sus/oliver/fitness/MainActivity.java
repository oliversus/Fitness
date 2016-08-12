package sus.oliver.fitness;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM_TITLE = "extra.item.title";
    public static final String EXERCISE_WEIGHTS = "Weight lifting";
    public static final String EXERCISE_YOGA = "Yoga";
    public static final String EXERCISE_CARDIO = "Cardio";
    public static boolean exerciseIsNight = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout weightButton = (RelativeLayout) findViewById(R.id.weightButton);
        RelativeLayout yogaButton = (RelativeLayout) findViewById(R.id.yogaButton);
        RelativeLayout cardioButton = (RelativeLayout) findViewById(R.id.cardioButton);
        ImageButton nightButton = (ImageButton) findViewById(R.id.gearButton);

        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_WEIGHTS);
            }
        });

        yogaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_YOGA);
            }
        });

        cardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDetailActivity(MainActivity.EXERCISE_CARDIO);
            }
        });

        nightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSettingsActivity();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        RelativeLayout weightButton = (RelativeLayout) findViewById(R.id.weightButton);
        RelativeLayout yogaButton   = (RelativeLayout) findViewById(R.id.yogaButton);
        RelativeLayout cardioButton = (RelativeLayout) findViewById(R.id.cardioButton);
        LinearLayout mainBackground = (LinearLayout) findViewById(R.id.mainBackground);
        if (exerciseIsNight){
            weightButton.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
            yogaButton.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
            cardioButton.getBackground().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
            mainBackground.setBackgroundColor(Color.GRAY);
        } else {
            weightButton.getBackground().setColorFilter(Color.parseColor("#2ca5f5"), PorterDuff.Mode.SRC_IN);
            yogaButton.getBackground().setColorFilter(Color.parseColor("#916bcd"), PorterDuff.Mode.SRC_IN);
            cardioButton.getBackground().setColorFilter(Color.parseColor("#52ad56"), PorterDuff.Mode.SRC_IN);
            mainBackground.setBackgroundColor(Color.WHITE);
        }

    }

    private void loadDetailActivity(String exerciseTitle){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(MainActivity.EXTRA_ITEM_TITLE, exerciseTitle);
        startActivity(intent);
    }

    private void loadSettingsActivity(){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

}

package sus.oliver.fitness;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView exerciseText = (TextView)findViewById(R.id.exerciseTitle);
        ImageView exerciseImage = (ImageView)findViewById(R.id.exerciseImage);
        LinearLayout mainBackground = (LinearLayout)findViewById(R.id.mainBG);

        String exerciseTitle = getIntent().getStringExtra(MainActivity.EXTRA_ITEM_TITLE);
        exerciseText.setText(exerciseTitle);

        if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_WEIGHTS)){
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.weight, getApplicationContext().getTheme()));
            mainBackground.setBackgroundColor(Color.parseColor("#2ca5f5"));
        } else if (exerciseTitle.equalsIgnoreCase(MainActivity.EXERCISE_YOGA)){
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.lotus, getApplicationContext().getTheme()));
            mainBackground.setBackgroundColor(Color.parseColor("#916bcd"));
        } else {
            exerciseImage.setImageDrawable(getResources().getDrawable(R.drawable.heart, getApplicationContext().getTheme()));
            mainBackground.setBackgroundColor(Color.parseColor("#52ad56"));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        LinearLayout mainBackground = (LinearLayout) findViewById(R.id.mainBG);

        if (MainActivity.exerciseIsNight) {
            mainBackground.setBackgroundColor(Color.DKGRAY);
        }
    }

}

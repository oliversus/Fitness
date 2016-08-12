package sus.oliver.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        CheckBox nightMode = (CheckBox) findViewById(R.id.nightModeBox);
        setDark(nightMode);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void setDark(View view){

        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            MainActivity.exerciseIsNight = true;
        } else {
            MainActivity.exerciseIsNight = false;
        }

    }
}

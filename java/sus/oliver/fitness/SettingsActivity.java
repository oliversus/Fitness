package sus.oliver.fitness;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatActivity {

    public static CheckBox nightMode;
    public static boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nightMode = (CheckBox) findViewById(R.id.nightModeBox);
        setDark(nightMode);

    }

    @Override
    protected void onPause() {
        super.onPause();

        save(nightMode.isChecked());
    }

    @Override
    protected void onResume() {
        super.onResume();

        nightMode.setChecked(load());
        setDark(nightMode);

    }

    public void setDark(View view){

        LinearLayout settingsLayout = (LinearLayout) findViewById(R.id.settingsLayout);
        checked = ((CheckBox) view).isChecked();

        if (checked) {
            MainActivity.exerciseIsNight = true;
            settingsLayout.setBackgroundColor(Color.DKGRAY);
        } else {
            MainActivity.exerciseIsNight = false;
            settingsLayout.setBackgroundColor(Color.WHITE);
        }

    }

    private void save(final boolean isChecked) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("check", isChecked);
        editor.apply();
    }

    private boolean load() {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("check", false);
    }
}

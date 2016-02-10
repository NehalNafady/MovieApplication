package com.example.nehalnafady.movieapplication;


        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.Toast;

/**
 * Created by Nehal Nafady on 2/3/2016.
 */
public class ActivityDetails extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details_activity);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.Fregment_placehodler, new ActivityFragmentDetails()).commit();
        }
    }
}

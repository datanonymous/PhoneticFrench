package ko.alex.phoneticfrench;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //https://www.androidhive.info/2017/12/android-working-with-bottom-navigation/
    //https://www.androidhive.info/2015/09/android-material-design-working-with-tabs/

    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Bot1Frag());

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //viewPager = findViewById(R.id.ViewPager);
        //setupViewPager(viewPager);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText("home");
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot1Frag());
//                    toolbar.setTitle("Frag1");
                    return true;
                case R.id.navigation_food:
//                    mTextMessage.setText("home");
                    Toast.makeText(getApplicationContext(), "Food", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot2Frag());
//                    toolbar.setTitle("Frag2");
                    return true;
                case R.id.navigation_commute:
//                    mTextMessage.setText("home");
                    Toast.makeText(getApplicationContext(), "Commute", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot3Frag());
//                    toolbar.setTitle("Frag3");
                    return true;
                case R.id.navigation_gesture:
//                    mTextMessage.setText("home");
                    Toast.makeText(getApplicationContext(), "Gesture", Toast.LENGTH_SHORT).show();
                    loadFragment(new Bot4Frag());
//                    toolbar.setTitle("Frag3");
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //ViewPager should not be used when using bottom navigation
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}

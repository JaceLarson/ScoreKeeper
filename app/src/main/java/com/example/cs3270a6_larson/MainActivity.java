package com.example.cs3270a6_larson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomFragment.updateScores, Dialog_increment.increment {

    private FragmentManager fm;
    TopFragment topFrag;
    BottomFragment bottomFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadFragment(new TopFragment(), R.id.topFragmentContainer, "top_fragment");
        LoadFragment(new BottomFragment(), R.id.bottomFragmentContainer, "bottom_fragment");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    private void LoadFragment(Fragment f, int fID, String tag) {
        fm=getSupportFragmentManager();
        fm.beginTransaction().replace(fID, f, tag).commit();
    }

    @Override
    public void playerOneScore(int value) {

        topFrag = (TopFragment) fm.findFragmentByTag("top_fragment");
        assert topFrag != null;

        topFrag.playerOneScore(value);
        topFrag.setCountSeek1Value(value);


    }

    @Override
    public void playerTwoScore(int value) {

        topFrag = (TopFragment) fm.findFragmentByTag("top_fragment");
        assert topFrag != null;

        topFrag.playerTwoScore(value);
        topFrag.setCountSeek2Value(value);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.set_increment:
                Dialog_increment dialogFragment = new Dialog_increment();
                dialogFragment.show(getSupportFragmentManager(), "increment");


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void increment(int value) {

        bottomFrag = (BottomFragment) fm.findFragmentByTag("bottom_fragment");
        assert bottomFrag != null;

        bottomFrag.setIncrement(value);


    }
}

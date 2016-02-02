package greatergoodguy.jeesh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import greatergoodguy.feature.FeaturePing;
import greatergoodguy.feature.FeatureStatus;
import greatergoodguy.toolbox.TBAndroid;
import greatergoodguy.toolbox.TBToaster;

public class ActivityJeesh extends AppCompatActivity {

    ActivityJeeshAssistant assistant = new ActivityJeeshAssistant();

    FeaturePing featurePing;
    FeatureStatus featureStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeesh);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        featurePing = new FeaturePing(assistant);
        featureStatus = new FeatureStatus(assistant);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jeesh, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_getInfo) {
            TBToaster.showToast(ActivityJeesh.this, TBAndroid.getSecureId(ActivityJeesh.this));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ActivityJeeshAssistant {

        public Context getContext() {
            return ActivityJeesh.this;
        }

        public Activity getActivity() {
            return ActivityJeesh.this;
        }

        public View findViewById(int resourceId) {
            return ActivityJeesh.this.findViewById(resourceId);
        }
    }
}

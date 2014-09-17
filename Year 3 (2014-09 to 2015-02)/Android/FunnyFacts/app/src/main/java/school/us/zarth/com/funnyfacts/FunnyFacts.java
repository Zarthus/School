package school.us.zarth.com.funnyfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class FunnyFacts extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funny_facts);

        final TextView tv = (TextView) findViewById(id.textView);
        tv.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View v) {
                final TextView tv = (TextView) findViewById(tv.id.textView);
                generateNextFact(tv);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.funny_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void generateNextFact(TextView v) {
        String[] facts = {
                "Facts are meaningless. You could use facts to prove anything that's even remotely true.",
                "ok",
                "placeholder"
        };

        Random r = new Random();
        String rFact = facts[r.nextInt(facts.length)];
        v.setText(rFact);
    }
}

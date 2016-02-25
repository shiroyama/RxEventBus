package us.shiroyama.android.subjectexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscription;

/**
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new Adapter(this));
    }


    @Override
    protected void onResume() {
        super.onResume();
        subscription = BusProvider.getInstance().subscribe(
                ItemSelectEvent.class,
                e -> Toast.makeText(this, "position: " + e.getPosition(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    protected void onPause() {
        subscription.unsubscribe();
        super.onPause();
    }
}

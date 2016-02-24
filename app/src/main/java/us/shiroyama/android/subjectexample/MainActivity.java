package us.shiroyama.android.subjectexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(
                val -> Log.i(TAG, val),
                error -> Log.e(TAG, error.getMessage(), error)
        );

        try {
            subject.onNext("FOO");
            subject.onNext("BAR");
            subject.onNext("BAZ");
            subject.onCompleted();
        } catch (Exception e) {
            subject.onError(e);
        }
        */

        Observable<String> observable = Observable.just("FOO", "BAR", "BAZ");
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create("init val");
        observable.subscribe(
                behaviorSubject::onNext
        );
        behaviorSubject.subscribe(
                val -> Log.i(TAG, val),
                error -> Log.e(TAG, error.getMessage(), error)
        );
    }
}

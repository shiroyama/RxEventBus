package us.shiroyama.android.subjectexample;


import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */
public class RxEventBus {
    private final Subject<Object, Object> bus = new SerializedSubject<>(PublishSubject.create());

    public void post(Object event) {
        bus.onNext(event);
    }

    public <T> Subscription subscribe(Class<T> clazz, Action1<T> onNext) {
        return bus.ofType(clazz).subscribe(onNext);
    }
}

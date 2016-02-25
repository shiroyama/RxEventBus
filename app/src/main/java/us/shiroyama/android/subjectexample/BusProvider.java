package us.shiroyama.android.subjectexample;

/**
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */
public class BusProvider {
    private static final RxEventBus eventBus = new RxEventBus();

    private BusProvider() {
    }

    public static RxEventBus getInstance() {
        return eventBus;
    }
}

package us.shiroyama.android.subjectexample;

/**
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */
public class ItemSelectEvent {
    private int position;

    public ItemSelectEvent(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}

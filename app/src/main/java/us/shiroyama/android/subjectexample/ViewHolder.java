package us.shiroyama.android.subjectexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.text)
    TextView textView;

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String text) {
        textView.setText(text);
    }
}

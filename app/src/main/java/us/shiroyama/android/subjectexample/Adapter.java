package us.shiroyama.android.subjectexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fumihiko Shiroyama (fu.shiroyama@gmail.com)
 */
public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<String> texts;

    public Adapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        texts = new ArrayList<>();
        texts.add("あああああああああああ");
        texts.add("いいいいいいいいいいい");
        texts.add("ううううううううううう");
        texts.add("えええええええええええ");
        texts.add("おおおおおおおおおおお");
        texts.add("かかかかかかかかかかか");
        texts.add("ききききききききききき");
        texts.add("くくくくくくくくくくく");
        texts.add("けけけけけけけけけけけ");
        texts.add("こここここここここここ");
        texts.add("さささささささささささ");
        texts.add("ししししししししししし");
        texts.add("すすすすすすすすすすす");
        texts.add("せせせせせせせせせせせ");
        texts.add("そそそそそそそそそそそ");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.itemView.setOnClickListener(view -> {
            int position = viewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                BusProvider.getInstance().post(new ItemSelectEvent(position));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(texts.get(position));
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }
}

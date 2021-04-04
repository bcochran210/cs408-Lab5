package edu.jsu.mcis.cs408.lab5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Memo> data;

    public RecyclerViewAdapter (List<Memo> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memo_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, int position) {
        holder.setMemo(data.get(position));
        holder.bindData();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private Memo memo;
        private TextView memoNum;
        private TextView memoContent;

        public ViewHolder (View itemView) {
            super(itemView);
        }

        public Memo getMemo() {
            return memo;
        }

        public void setMemo (Memo memo) {
            this.memo = memo;
        }

        public void bindData() {
            if (memoContent == null) {
                memoContent = (TextView)itemView.findViewById(R.id.memo);
            }
            if (memoNum == null) {
                memoNum = (TextView)itemView.findViewById(R.id.memoNum);
            }

            memoNum.setText(String.valueOf(memo.getId()) + ": ");
            memoContent.setText(memo.getMemo());
        }

    }

}

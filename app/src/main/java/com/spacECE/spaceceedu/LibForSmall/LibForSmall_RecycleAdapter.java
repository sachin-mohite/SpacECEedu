package com.spacECE.spaceceedu.LibForSmall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.spacECE.spaceceedu.R;

import java.util.ArrayList;

public class LibForSmall_RecycleAdapter extends RecyclerView.Adapter<LibForSmall_RecycleAdapter.MyViewHolder>{

    ArrayList<Book> list;

    private final RecyclerViewClickListener listener;

    public LibForSmall_RecycleAdapter(ArrayList<Book> myList, RecyclerViewClickListener listener) {
        this.list = myList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.library_list_listitem, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.book_name.setText(list.get(position).getProduct_title());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView book_name;
        public MyViewHolder(@NonNull View view) {
            super(view);
            book_name=view.findViewById(R.id.cardview_bookname);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
}

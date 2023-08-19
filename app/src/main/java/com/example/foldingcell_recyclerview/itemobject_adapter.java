package com.example.foldingcell_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

public class itemobject_adapter extends RecyclerView.Adapter<itemobject_adapter.itemobject_ViewHolder>{

    private List<itemobject> mItemobjects;



    public void setdata(List<itemobject> list){
        this.mItemobjects=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public itemobject_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_object,parent,false);
        return new itemobject_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemobject_ViewHolder holder, int position) {
        itemobject itemobject=mItemobjects.get(position);
        if(itemobject==null){
            return;
        }

        holder.txtcontent.setText(itemobject.getContent());
        holder.txttitle.setText(itemobject.getTitle());
        holder.folcell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.folcell.toggle(false);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(mItemobjects!=null){
            return mItemobjects.size();
        }
        return 0;
    }

    public class itemobject_ViewHolder extends RecyclerView.ViewHolder{

        private FoldingCell folcell;
        private TextView txttitle;
        private TextView txtcontent;
        public itemobject_ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttitle=(TextView) itemView.findViewById(R.id.txttitle);
            txtcontent=(TextView) itemView.findViewById(R.id.txtcontent);
            folcell=(FoldingCell) itemView.findViewById(R.id.fl_cell);

        }
    }
}

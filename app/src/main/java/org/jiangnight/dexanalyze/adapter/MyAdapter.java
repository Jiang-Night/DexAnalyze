package org.jiangnight.dexanalyze.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jiangnight.dexanalyze.R;
import org.jiangnight.dexanalyze.bean.Item;

import java.util.List;

/**
 * @author JiangNight
 * @date 2023-08-10 13:42
 * @ClassName
 * @Description
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHoder> {

    private List<Item> data;

    public MyAdapter(List<Item> data){
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =View.inflate(parent.getContext(), R.layout.item_list,null);
        MyViewHoder myViewHoder = new MyViewHoder(view);
        return myViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        Item item = data.get(position);
        holder.name.setText(item.name);
        holder.hex.setText(item.hex);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class MyViewHoder extends RecyclerView.ViewHolder{

    TextView name;
    EditText hex;

    public MyViewHoder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        hex = itemView.findViewById(R.id.hex);
    }
}
package org.example.navigationdrawer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavIconAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class NavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView navIconPic;
        TextView navIconName;

        public NavViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            navIconPic = itemView.findViewById(R.id.nav_icon_pic);
            navIconName = itemView.findViewById(R.id.nav_icon_name);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), AlarmActivity.class);
            view.getContext().startActivity(intent);
        }
    }

    private ArrayList<NavIcon>NavIconArrayList;
    NavIconAdapter(ArrayList<NavIcon> NavIconArrayList) {
        this.NavIconArrayList = NavIconArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View itemView = LayoutInflater.from(context).inflate(R.layout.nav_icon, parent, false);
        //ViewHolder viewHolder = new ViewHolder(itemView);

        View iconView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_icon, parent, false);

        return new NavViewHolder(iconView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NavViewHolder navViewHolder = (NavViewHolder) holder;

        navViewHolder.navIconPic.setImageResource(NavIconArrayList.get(position).drawableId);
        navViewHolder.navIconName.setText(NavIconArrayList.get(position).viewname);

    }

    @Override
    public int getItemCount() {
        return NavIconArrayList.size();
    }
}

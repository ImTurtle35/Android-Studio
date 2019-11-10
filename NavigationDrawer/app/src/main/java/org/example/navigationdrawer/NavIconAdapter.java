package org.example.navigationdrawer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class NavIconAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    public static class NavViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView navIconPic;
        TextView navIconName;

        private final Context context;

        public NavViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            navIconPic = itemView.findViewById(R.id.nav_icon_pic);
            navIconName = itemView.findViewById(R.id.nav_icon_name);
            navIconName.setClickable(true);
            navIconPic.setClickable(true);
            navIconName.setOnClickListener(this);
            navIconPic.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            switch(getAdapterPosition()) {
                case 0:
                    intent = new Intent(context,AlarmActivity.class);
                    break;
                case 1:
                    intent = new Intent(context,BranchActivity.class);
                    break;
                case 2:
                    intent = new Intent(context,HeartActivity.class);
                    break;
                case 3:
                    intent = new Intent(context,StoreActivity.class);
                    break;
                case 4:
                    intent = new Intent(context,SponsorActivity.class);
                    break;
                case 5:
                    intent = new Intent(context,WebActivity.class);
                    break;
                case 6:
                    intent = new Intent(context,OptionActivity.class);
                    break;
                case 7:
                    intent = new Intent(context,QuestionActivity.class);
                    break;
                case 8:
                    intent = new Intent(context,SuggestActivity.class);
                    break;
                default:
                    intent = null;
            }
            context.startActivity(intent);
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        NavViewHolder navViewHolder = (NavViewHolder) holder;

        navViewHolder.navIconPic.setImageResource(NavIconArrayList.get(position).drawableId);
        navViewHolder.navIconName.setText(NavIconArrayList.get(position).viewname);
    }

    @Override
    public int getItemCount() {
        return NavIconArrayList.size();
    }

}

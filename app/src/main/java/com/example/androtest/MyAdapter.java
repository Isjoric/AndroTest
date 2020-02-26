package com.example.androtest;

/*import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;*/
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final List<Pair<String[], Integer>> characters = Arrays.asList(

            Pair.create(new String[]{"Lyra Belacqua", "96 98 65 89"}, R.drawable.download),
            Pair.create(new String[]{"Pantalaimon", "96 02 65 89" }, R.drawable.download1),
            Pair.create(new String[]{"Roger Parslow", "96 55 65 89"}, R.drawable.download2),
            Pair.create(new String[]{"Lord Asriel", "96 98 65 00"} , R.drawable.download3)
    );

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pair<String[], Integer> pair = characters.get(position);
        holder.display(pair);
    }

    public static final String EXTRA_NOM = "com.example.androtest.NOM";
    public static final String EXTRA_TEL = "com.example.androtest.TEL";
    public static final String EXTRA_DESCRIPTION = "com.example.androtest.DESC";

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final ImageView avatar;

        //private final Resources res;


        private Pair<String[], Integer> currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);
            //res = itemView.getResources();

            name = ((TextView) itemView.findViewById(R.id.name));
            avatar = ((ImageView) itemView.findViewById(R.id.avatar2));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Log.i("ItemView","Choix d'un item");



                    Intent myIntent = new Intent(view.getContext(), DetailActivity.class);
                    myIntent.putExtra(EXTRA_NOM,currentPair.first[0]);
                    myIntent.putExtra(EXTRA_TEL,currentPair.first[1]);
                    myIntent.putExtra(EXTRA_DESCRIPTION,currentPair.second.toString());


                    view.getContext().startActivity(myIntent);
                }
            });
        }

        public void display(Pair<String[], Integer> pair) {
            //Drawable myImage = ResourcesCompat.getDrawable(res, Integer.parseInt(pair.second), null);
            currentPair = pair;
            name.setText(pair.first[0]);
            avatar.setImageResource(pair.second);
        }
    }

}

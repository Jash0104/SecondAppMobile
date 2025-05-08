package com.secondpartial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> datos;
    public UserAdapter(List<User> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User dato = datos.get(position);
        holder.bind(dato);
    }


    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_name, txt_status, txt_species;
        ImageView img_profile;
        Button btn_see_more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_name);
            txt_status = itemView.findViewById(R.id.txt_status);
            txt_species = itemView.findViewById(R.id.txt_species);
            img_profile = itemView.findViewById(R.id.img_profile);
            btn_see_more = itemView.findViewById(R.id.btn_see_more);
        }

        public void bind(User dato) {
            txt_name.setText(dato.getName());
            txt_status.setText(dato.getStatus());
            txt_species.setText(dato.getSpecies());


            Picasso.get().load(dato.getImageUrl()).into(img_profile);


            btn_see_more.setOnClickListener(v -> {

            });
        }
    }
}

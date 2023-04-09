package com.example.mysmartlab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mysmartlab.CartManager;
import com.example.mysmartlab.DataClass.Product;
import com.example.mysmartlab.R;

import java.util.ArrayList;

public class ProgectAdapter extends RecyclerView.Adapter<ProgectAdapter.ViewHolder>  {


    private ArrayList<Product> products;
    private Context context;
    private CartManager cartManager;
    public  ProgectAdapter(ArrayList<Product> products, Context context, CartManager cartManager) {
        this.products = products;
        this.context = context;
        this.cartManager = cartManager;
    }

    @NonNull
    @Override
    public ProgectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgectAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.name.setText(product.getName());
        holder.date.setText(product.getTime_result());
        holder.price.setText(String.format("Цена: %s", product.getPrice()));

        holder.button.setOnClickListener(v -> {


            Toast.makeText(context, "Товар добавлен в корзину", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, date, price;
        Button button;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView10) ;
            date = itemView.findViewById(R.id.textView11) ;
            price = itemView.findViewById(R.id.textView12);
            button = itemView.findViewById(R.id.button4);
        }
    }
}

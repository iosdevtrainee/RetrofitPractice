package pursuit.iosdevtrainee.com.retrofitpractice.controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

import pursuit.iosdevtrainee.com.retrofitpractice.R;
import pursuit.iosdevtrainee.com.retrofitpractice.models.Company;
import pursuit.iosdevtrainee.com.retrofitpractice.views.StockViewHolder;

public class StockAdapter extends RecyclerView.Adapter<StockViewHolder> {
    private ArrayList<Company> companies;

    public StockAdapter(ArrayList<Company> companies){
        this.companies = companies;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stock_layout,viewGroup, false);
        return new StockViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder stockViewHolder, int i) {
        stockViewHolder.onBind(companies.get(i).getTicker());
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }
}

package pursuit.iosdevtrainee.com.retrofitpractice.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import pursuit.iosdevtrainee.com.retrofitpractice.DetailActivity;
import pursuit.iosdevtrainee.com.retrofitpractice.R;
import pursuit.iosdevtrainee.com.retrofitpractice.models.Company;

public class StockViewHolder extends ViewHolder {
    private TextView tickerTextView;


    public StockViewHolder(@NonNull View itemView) {
        super(itemView);
        tickerTextView = itemView.findViewById(R.id.stock_textview);
    }

    public void onBind(final String ticker){
        tickerTextView.setText(ticker);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra("ticker", ticker);
                itemView.getContext().startActivity(intent);
            }
        });


    }

}

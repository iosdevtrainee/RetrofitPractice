package pursuit.iosdevtrainee.com.retrofitpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import pursuit.iosdevtrainee.com.retrofitpractice.models.CompanyDetail;
import pursuit.iosdevtrainee.com.retrofitpractice.network.RetrofitSingleton;
import pursuit.iosdevtrainee.com.retrofitpractice.network.StockService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailActivity extends AppCompatActivity {
    private TextView tickerTextView;
    private TextView companyDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String ticker = intent.getStringExtra("ticker");
        tickerTextView = findViewById(R.id.textView);
        companyDescription = findViewById(R.id.longDescription);
        Retrofit retrofit = RetrofitSingleton.getInstance();
        StockService stockService = retrofit.create(StockService.class);
        Call<CompanyDetail> details = stockService.getCompanyDetails(ticker);
        details.enqueue(new Callback<CompanyDetail>() {
            @Override
            public void onResponse(Call<CompanyDetail> call, Response<CompanyDetail> response) {
                final String name = response.body().getName();
                final String description = response.body().getLong_description();
                tickerTextView.setText(name);
                companyDescription.setText(description);
            }

            @Override
            public void onFailure(Call<CompanyDetail> call, Throwable t) {

            }
        });

    }
}

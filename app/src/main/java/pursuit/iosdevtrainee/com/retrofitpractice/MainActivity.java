package pursuit.iosdevtrainee.com.retrofitpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import pursuit.iosdevtrainee.com.retrofitpractice.controllers.StockAdapter;
import pursuit.iosdevtrainee.com.retrofitpractice.database.StockDatabase;
import pursuit.iosdevtrainee.com.retrofitpractice.models.Company;
import pursuit.iosdevtrainee.com.retrofitpractice.models.CompanyData;
import pursuit.iosdevtrainee.com.retrofitpractice.network.RetrofitSingleton;
import pursuit.iosdevtrainee.com.retrofitpractice.network.StockService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.stock_recyclerview);
        Retrofit retrofit = RetrofitSingleton.getInstance();

        StockService stockService = retrofit.create(StockService.class);

        Call<CompanyData> companies = stockService.getCompaniesData();
        companies.enqueue(new Callback<CompanyData>() {
            @Override
            public void onResponse(Call<CompanyData> call, Response<CompanyData> response) {
                if (response.body() == null) {
                    System.out.println("WHATS HAPPENIN!!!");
                    System.out.println(response.toString());
                    System.out.println(response.code());
                } else {
                    final ArrayList<Company> companies = response.body().getCompanies();
                    if (companies != null) {
                        StockDatabase stockDatabase = StockDatabase.getInstance(getApplicationContext());
                        for (Company company:companies){
                            final String name = company.getName();
                            final String ticker = company.getTicker();
                            System.out.println("ticker: "+ticker+" name: "+name);
                            stockDatabase.insertStock(ticker,name);
                        }
                        recyclerView.setAdapter(new StockAdapter(companies));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    } else {
                        System.out.println("WHAT HAPPENED!!!");
                    }
                }



            }

            @Override
            public void onFailure(Call<CompanyData> call, Throwable t) {

            }
        });
    }
}

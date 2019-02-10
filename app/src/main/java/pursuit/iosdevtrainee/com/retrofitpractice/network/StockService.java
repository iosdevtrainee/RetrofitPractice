package pursuit.iosdevtrainee.com.retrofitpractice.network;

import pursuit.iosdevtrainee.com.retrofitpractice.models.AssetPrice;
import pursuit.iosdevtrainee.com.retrofitpractice.models.CompanyData;
import pursuit.iosdevtrainee.com.retrofitpractice.models.CompanyDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StockService {
    @GET("companies?api_key="+SecretKeys.INTRINIOKEY)
    Call<CompanyData> getCompaniesData();
    @GET("/companies/{ticker}?api_key="+SecretKeys.INTRINIOKEY)
    Call<CompanyDetail> getCompanyDetails(@Path("ticker") String ticker);
    @GET("companies/search?query={search_term}&api_key="+SecretKeys.INTRINIOKEY)
    Call<CompanyData> searchCompanies(@Path("search_term") String searchTerm);
    @GET("securities/{ticker}/prices?api_key="+SecretKeys.INTRINIOKEY+"&page_size={page_size}")
    Call<AssetPrice> getStockPrices(@Path("ticker") String ticker, @Path("page_size") int pageSize);
}

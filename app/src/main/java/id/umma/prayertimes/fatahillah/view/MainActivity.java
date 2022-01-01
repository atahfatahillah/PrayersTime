package id.umma.prayertimes.fatahillah.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Locale;

import id.umma.prayertimes.fatahillah.R;
import id.umma.prayertimes.fatahillah.models.Times;
import id.umma.prayertimes.fatahillah.utils.Utils;
import id.umma.prayertimes.fatahillah.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvDateTimeToday, tvCurrentLocation,
    tvShubuhTime, tvDzuhurTime, tvAsharTime, tvMaghribTime, tvIsyaTime;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDateTimeToday = findViewById(R.id.datetimeToday);
        tvCurrentLocation = findViewById(R.id.currentLocation);
        tvShubuhTime = findViewById(R.id.tvShubuhTime);
        tvDzuhurTime = findViewById(R.id.tvDzuhurTime);
        tvAsharTime = findViewById(R.id.tvAsharTime);
        tvMaghribTime = findViewById(R.id.tvMaghribTime);
        tvIsyaTime = findViewById(R.id.tvIsyaTime);

        getData();
    }

    private void getData() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.makeApiCall();
        viewModel.getMutableLiveData().observe(this, rootResponse -> {
            if (rootResponse != null) {
                String hijri = rootResponse.getResults().getDatetime().get(0).getDate().getHijri();
                hijri = Utils.dateTimeFormat(hijri, "dd MM yyyy", new Locale("id", "ID"));
                String gregorian = rootResponse.getResults().getDatetime().get(0).getDate().getGregorian();
                gregorian = Utils.dateTimeFormat(gregorian, "dd MMM yyyy", new Locale("id", "ID"));
                String city = rootResponse.getResults().getLocation().getCity();
                Times times = rootResponse.getResults().getDatetime().get(0).getTimes();

                tvDateTimeToday.setText(String.format("%s/%s", hijri+"H", gregorian));
                tvCurrentLocation.setText(city);
                tvShubuhTime.setText(times.getFajr());
                tvDzuhurTime.setText(times.getDhuhr());
                tvAsharTime.setText(times.getAsr());
                tvMaghribTime.setText(times.getMaghrib());
                tvIsyaTime.setText(times.getIsha());
            } else {
                Toast.makeText(MainActivity.this, "unable to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
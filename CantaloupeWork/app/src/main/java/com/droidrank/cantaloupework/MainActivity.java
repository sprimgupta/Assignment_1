package com.droidrank.cantaloupework;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.droidrank.cantaloupework.databinding.ActivityMainBinding;
import com.droidrank.cantaloupework.model.AllData;
import com.droidrank.cantaloupework.model.Results;
import com.droidrank.cantaloupework.utils.AppUtils;
import com.droidrank.cantaloupework.viewmodel.AllDataViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {
    AllDataViewModel viewModel;
    ActivityMainBinding activityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBindings(savedInstanceState);

    }

    private void setupBindings(Bundle savedInstanceState) {
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(AllDataViewModel.class);
        if (savedInstanceState == null) {
            viewModel.init();
        }
        activityBinding.setModel(viewModel);
        setupListUpdate();

    }

    private void setupListUpdate() {
        viewModel.fetchList();
        viewModel.getMostPopularModel().observe(this, new Observer<AllData>() {
            @Override
            public void onChanged(AllData results) {
                if (results != null && results.getResults() != null && results.getResults().size() > 0) {
                    activityBinding.progressBar.setVisibility(View.GONE);
                    viewModel.setMostMopularDataInAdapter(results);
                    activityBinding.emptyText.setVisibility(View.GONE);
                } else {
                    activityBinding.emptyText.setVisibility(View.VISIBLE);
                }

            }
        });
        setupListClick();
    }

    private void setupListClick() {
        viewModel.getSelected().observe(this, new Observer<Results>() {
            @Override
            public void onChanged(Results results) {
                if (results != null) {
                    String url = results.getUrl();
                    if (!TextUtils.isEmpty(url)) {
                        AppUtils.intentUtil(MainActivity.this, url);
                    } else {
                        Toast.makeText(MainActivity.this, getString(R.string.error_try_later), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

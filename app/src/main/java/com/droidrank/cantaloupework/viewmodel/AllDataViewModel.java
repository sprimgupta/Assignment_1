package com.droidrank.cantaloupework.viewmodel;

import android.view.View;
import android.widget.ProgressBar;

import com.droidrank.cantaloupework.R;
import com.droidrank.cantaloupework.adapter.DataAdapter;
import com.droidrank.cantaloupework.model.AllDataModel;
import com.droidrank.cantaloupework.model.AllData;
import com.droidrank.cantaloupework.model.Results;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AllDataViewModel extends ViewModel {

    private AllDataModel mostPopularModel;
    private DataAdapter adapter;
    private MutableLiveData<Results> selectedResult;


    public void init() {
        mostPopularModel = new AllDataModel();
        selectedResult = new MutableLiveData<>();
        adapter = new DataAdapter(R.layout.list_item_view, this);
    }

    public void fetchList() {
        mostPopularModel.fetchList();
    }

    public MutableLiveData<AllData> getMostPopularModel() {
        return mostPopularModel.getMostPopularDataMutableLiveData();
    }

    public DataAdapter getAdapter() {
        return adapter;
    }

    public void setMostMopularDataInAdapter(AllData mostPopularData) {
        this.adapter.setMostPopularData(mostPopularData);
        this.adapter.notifyDataSetChanged();
    }

    public void setError(String error) {
        this.adapter.setError(error);
        this.adapter.notifyDataSetChanged();
    }

    public MutableLiveData<Results> getSelected() {
        return selectedResult;
    }

    public void onItemClick(Results selectedResult) {
        this.selectedResult.setValue(selectedResult);
    }
}

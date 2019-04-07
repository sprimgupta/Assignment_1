package com.droidrank.cantaloupework.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.droidrank.cantaloupework.model.AllData;
import com.droidrank.cantaloupework.model.Results;
import com.droidrank.cantaloupework.viewmodel.AllDataViewModel;
import com.droidrank.cantaloupework.BR;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.GenericViewHolder> {

    private int layoutId;
    private AllData mostPopularData;
    private AllDataViewModel viewModel;
    private String error;

    public DataAdapter(@LayoutRes int layoutId, AllDataViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }


    private Results getObjForPosition(int position) {
        return mostPopularData.getResults().get(position);
    }


    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return ((mostPopularData == null || mostPopularData.getResults() == null) ? 0 : mostPopularData.getResults().size());
    }

    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        Results obj = getObjForPosition(position);
        holder.bind(obj, viewModel);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setMostPopularData(AllData mostPopularData) {
        this.mostPopularData = mostPopularData;
    }

    public void setError(String error) {
        this.error = error;
    }


    public static class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Results obj, AllDataViewModel viewModel) {
            binding.setVariable(BR.obj, obj);
            binding.setVariable(BR.viewModel, viewModel);
            binding.executePendingBindings();
        }

    }
}

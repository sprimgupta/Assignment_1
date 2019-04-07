package com.droidrank.cantaloupework.bindings;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droidrank.cantaloupework.R;

import androidx.databinding.BindingAdapter;

public class CustomViewBindings {


    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            // If we don't do this, you'll see the old image appear briefly
            // before it's replaced with the current image
            if (imageView.getTag(R.id.image_url) == null || !imageView.getTag(R.id.image_url).equals(imageUrl)) {
                imageView.setImageBitmap(null);
                imageView.setTag(R.id.image_url, imageUrl);
                Glide.with(imageView).
                        load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView);
            }
        } else {
            imageView.setTag(R.id.image_url, null);
            imageView.setImageBitmap(null);
        }
    }

    @BindingAdapter("progress_bar_visibility")
    public static void bindMainEmptyText(ProgressBar progressBar, boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}

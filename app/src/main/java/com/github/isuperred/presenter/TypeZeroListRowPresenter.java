package com.github.isuperred.presenter;

import android.widget.TextView;
import android.widget.Toast;

import androidx.leanback.widget.BaseOnItemViewClickedListener;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;

import com.github.isuperred.R;
import com.github.isuperred.base.BaseListRowPresenter;
import com.github.isuperred.bean.Content;


public class TypeZeroListRowPresenter extends BaseListRowPresenter {
    @Override
    protected void initializeRowViewHolder(RowPresenter.ViewHolder holder) {
        super.initializeRowViewHolder(holder);
        final ViewHolder rowViewHolder = (ViewHolder) holder;

        rowViewHolder.getGridView().setHorizontalSpacing((int) rowViewHolder.getGridView().getResources().getDimension(R.dimen.px48));
        rowViewHolder.getGridView().setFocusScrollStrategy(HorizontalGridView.FOCUS_SCROLL_ITEM);
        RowHeaderPresenter.ViewHolder vh = rowViewHolder.getHeaderViewHolder();
        TextView textView = vh.view.findViewById(R.id.row_header);
        textView.setTextSize(textView.getContext().getResources().getDimensionPixelSize(R.dimen.px30));
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.colorWhite));
        textView.setPadding(0, 0, 0, 20);
        setOnItemViewClickedListener(new BaseOnItemViewClickedListener() {
            @Override
            public void onItemClicked(Presenter.ViewHolder itemViewHolder,
                                      Object item, RowPresenter.ViewHolder rowViewHolder, Object row) {
                if (item instanceof Content.DataBean.WidgetsBean) {
                    Toast.makeText(((ViewHolder) rowViewHolder).getGridView().getContext(),
                            "位置:" + ((ViewHolder) rowViewHolder).getGridView().getSelectedPosition(),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}

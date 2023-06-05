package com.dargoz.android.component.swipe.adapters;



import androidx.recyclerview.widget.RecyclerView;

import com.dargoz.android.component.swipe.SwipeLayout;
import com.dargoz.android.component.swipe.util.Attributes;
import com.dargoz.android.component.swipe.implments.SwipeItemMangerImpl;
import com.dargoz.android.component.swipe.interfaces.SwipeAdapterInterface;
import com.dargoz.android.component.swipe.interfaces.SwipeItemMangerInterface;

import java.util.List;

public abstract class RecyclerSwipeAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements SwipeItemMangerInterface, SwipeAdapterInterface {

    public SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this);

    @Override
    public void notifyDatasetChanged(int position) {
        int itemCount = getItemCount();
        if (position >= itemCount-1) {
            notifyItemRangeChanged(0, itemCount - 2);
        } else if (position == 0) {
            notifyItemRangeChanged(1, itemCount - 2);
        } else {
            notifyItemRangeChanged(position + 1, itemCount - position - 1);
            notifyItemRangeChanged(0, position);
        }
    }

    @Override
    public void openItem(int position) {
        mItemManger.openItem(position);
    }

    @Override
    public void closeItem(int position) {
        mItemManger.closeItem(position);
    }

    @Override
    public void closeAllExcept(SwipeLayout layout) {
        mItemManger.closeAllExcept(layout);
    }

    @Override
    public void closeAllItems() {
        mItemManger.closeAllItems();
    }

    @Override
    public List<Integer> getOpenItems() {
        return mItemManger.getOpenItems();
    }

    @Override
    public List<SwipeLayout> getOpenLayouts() {
        return mItemManger.getOpenLayouts();
    }

    @Override
    public void removeShownLayouts(SwipeLayout layout) {
        mItemManger.removeShownLayouts(layout);
    }

    @Override
    public boolean isOpen(int position) {
        return mItemManger.isOpen(position);
    }

    @Override
    public Attributes.Mode getMode() {
        return mItemManger.getMode();
    }

    @Override
    public void setMode(Attributes.Mode mode) {
        mItemManger.setMode(mode);
    }
}

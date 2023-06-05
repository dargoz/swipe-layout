package com.dargoz.android.component.swipe.interfaces;

public interface SwipeAdapterInterface {

    int getSwipeLayoutResourceId(int position);

    void notifyDatasetChanged(int position);

}

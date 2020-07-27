package com.harscode.javamvpexample;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);
    void onDetach();
    void disposeComposite();
    void clearComposite();
}

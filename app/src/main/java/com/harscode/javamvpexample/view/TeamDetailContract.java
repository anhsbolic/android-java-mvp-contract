package com.harscode.javamvpexample.view;

import androidx.annotation.NonNull;

import com.harscode.javamvpexample.BasePresenter;
import com.harscode.javamvpexample.BaseView;
import com.harscode.javamvpexample.model.Team;

public interface TeamDetailContract {

    interface View extends BaseView {
        void showLoading();
        void hideLoading();
        void setTeamDetail(@NonNull Team team);
    }

    interface Presenter extends BasePresenter<TeamDetailContract.View> {
        void getTeamDetail(@NonNull String teamId);
    }

}
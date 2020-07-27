package com.harscode.javamvpexample.view;

import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.harscode.javamvpexample.api.ApiServices;
import com.harscode.javamvpexample.api.SportApiServices;
import com.harscode.javamvpexample.api.response.TeamDetailResponse;
import com.harscode.javamvpexample.model.Team;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

class TeamDetailPresenter implements TeamDetailContract.Presenter {

    private TeamDetailContract.View mView;
    private CompositeDisposable composite = new CompositeDisposable();
    private SportApiServices sportApiServices = ApiServices.getSportApiServices();

    @Override
    public void onAttach(TeamDetailContract.View view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    @Override
    public void disposeComposite() {
        composite.dispose();
    }

    @Override
    public void clearComposite() {
        composite.clear();
    }

    @Override
    public void getTeamDetail(@NonNull String teamId) {
        mView.showLoading();

        composite.add(
            sportApiServices.getTeamDetails(teamId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTeamDetailSuccess, this::onGetTeamDetailError)
        );
    }

    private void onGetTeamDetailSuccess(TeamDetailResponse teamDetailResponse) {
        if (teamDetailResponse != null) {
            List<Team> teams = teamDetailResponse.getTeams();
            if (!teams.isEmpty()) {
                Team team = teams.get(0);
                mView.setTeamDetail(team);
                new Handler().postDelayed(() -> mView.hideLoading(), 500);
            }
        }
    }

    private void onGetTeamDetailError(Throwable throwable) {
        String msg = throwable.getMessage();
        if (msg != null) {
            Log.e(this.getClass().getName(), msg);
        }
    }

}

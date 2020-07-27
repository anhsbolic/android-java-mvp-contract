package com.harscode.javamvpexample.view;

import android.os.Handler;

import androidx.annotation.NonNull;

import com.harscode.javamvpexample.model.Team;

class TeamDetailPresenter implements TeamDetailContract.Presenter {

    private TeamDetailContract.View mView;

    @Override
    public void onAttach(TeamDetailContract.View view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    @Override
    public void getTeamDetail(@NonNull String teamId) {
        mView.showLoading();

        final Team team = new Team();
        team.setStrTeamBadge("https://www.thesportsdb.com/images/media/team/badge/a1af2i1557005128.png");
        team.setStrTeam("Arsenal");
        team.setStrStadium("Stadium");
        team.setStrLeague("Premier League");
        team.setStrDescriptionEN("Desc");

        new Handler().postDelayed(() -> {
            mView.setTeamDetail(team);
            mView.hideLoading();
        }, 2000);
    }

}

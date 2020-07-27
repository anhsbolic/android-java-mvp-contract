package com.harscode.javamvpexample.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.harscode.javamvpexample.databinding.ActivityTeamDetailBinding;
import com.harscode.javamvpexample.model.Team;
import com.squareup.picasso.Picasso;

public class TeamDetailActivity extends AppCompatActivity implements TeamDetailContract.View {

    private ActivityTeamDetailBinding binding;
    private TeamDetailPresenter presenter;
    private String teamId = "133604";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeamDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initPresenter();
        onAttachView();
        getData();
    }

    @Override
    protected void onStop() {
        presenter.clearComposite();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        presenter.disposeComposite();
        onDetachView();
        super.onDestroy();
    }

    private void initPresenter() {
        presenter = new TeamDetailPresenter();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void showLoading() {
        binding.teamDetailsProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.teamDetailsProgress.setVisibility(View.GONE);
    }

    @Override
    public void setTeamDetail(@NonNull Team team) {
        Picasso.get().load(team.getStrTeamBadge()).into(binding.teamDetailsImgTeamBadge);
        binding.teamDetailsTxtName.setText(team.getStrTeam());
        binding.teamDetailsTxtStadium.setText(team.getStrStadium());
        binding.teamDetailsTxtLeague.setText(team.getStrLeague());
        binding.teamDetailsTxtDescription.setText(team.getStrDescriptionEN());
    }

    private void getData() {
        presenter.getTeamDetail(teamId);
    }
}
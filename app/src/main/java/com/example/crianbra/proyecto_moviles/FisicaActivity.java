package com.example.crianbra.proyecto_moviles;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class FisicaActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyB3Lo3FVWitwengnGYfvjscZiK5zh43AjA";
    public static final String VIDEO_ID = "3I8sVqo07GM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuenteFisica = Typeface.createFromAsset(getAssets(), carpetaFuente);
        TextView txt_fisica = (TextView)findViewById(R.id.txt_fisica_1);
        TextView txt_fisica_texto = (TextView)findViewById(R.id.texto_fisica);
        txt_fisica.setTypeface(fuenteFisica);
        txt_fisica_texto.setTypeface(fuenteFisica);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_fisica);
        youTubePlayerView.initialize(API_KEY, this);
    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
/** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
/** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
}

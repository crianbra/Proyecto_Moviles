package com.example.crianbra.proyecto_moviles;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class EstadisticaActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyB3Lo3FVWitwengnGYfvjscZiK5zh43AjA";
    public static final String VIDEO_ID = "Nlfk7kRz2uU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuenteEstadistica = Typeface.createFromAsset(getAssets(), carpetaFuente);
        TextView txt_estadistica = (TextView)findViewById(R.id.txt_estadistica_1);
        TextView txt_estadisticas_texto = (TextView)findViewById(R.id.texto_estadistica);
        txt_estadistica.setTypeface(fuenteEstadistica);
        txt_estadisticas_texto.setTypeface(fuenteEstadistica);

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_estadistica);
        youTubePlayerView.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
/** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
/** Start buffering **/
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
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
    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(ErrorReason arg0) {
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

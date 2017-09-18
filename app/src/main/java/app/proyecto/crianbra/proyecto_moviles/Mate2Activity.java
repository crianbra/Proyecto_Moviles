package app.proyecto.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Mate2Activity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {



    String tag = "Lifecycle";

    public static final String API_KEY = "AIzaSyB3Lo3FVWitwengnGYfvjscZiK5zh43AjA";
    //public static final String VIDEO_ID = "SYNCycRslPg";
    public static final String VIDEO_ID = "A1uIuT9QQLU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mate2);



        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuenteMatematica = Typeface.createFromAsset(getAssets(), carpetaFuente);
        TextView txt_matematicas = (TextView)findViewById(R.id.txt_mate_2);
        TextView txt_matematicas_texto = (TextView)findViewById(R.id.texto_mate_2);
        txt_matematicas.setTypeface(fuenteMatematica);
        txt_matematicas_texto.setTypeface(fuenteMatematica);

        /** Initializing YouTube Player View **/
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youTubePlayer_mate_2);
        youTubePlayerView.initialize(API_KEY, this);


        final Button buttonMatematica = (Button) findViewById(R.id.btn_mate2);
        buttonMatematica.setTypeface(fuenteMatematica);
        buttonMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent = new Intent(Mate2Activity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

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

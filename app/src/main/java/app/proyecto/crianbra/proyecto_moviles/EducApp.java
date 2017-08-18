package app.proyecto.crianbra.proyecto_moviles;

/**
 * Created by crianbra on 18/08/17.
 */

import android.app.Application;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class EducApp extends Application{

    public void onCreate(){
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

    }
}

package com.codeurzebs.bookreaderict;


import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Keep;
import com.codeurzebs.bookreaderict.*;
import java.lang.ref.WeakReference;
@Keep
public class ImmersiveReader {

    WeakReference<Activity> mActivityWR;
    @Keep
    public interface IAuthenticator {
        String getAccessToken();
    }

    public ImmersiveReader(Activity activity, IAuthenticator authenticator) {
        mActivityWR = new WeakReference<>(activity);
        IRDataHolder.getInstance().setAuthenticator(authenticator);
    }

    public ImmersiveReader(Activity activity) {
        this(activity, null);
    }

    public IRError read(ReadableContent dataToRead) {

        Activity activity = mActivityWR.get();
        if (activity == null) {
            return new IRError(Error.INVALID_STATE, "Client activity is null");
        }

        if (dataToRead == null || dataToRead.getTextChunks().size() == 0) {
            return new IRError(Error.INVALID_CONTENT, "Readable Text Chunks not passed to Immersive Reader");
        }

        IRDataHolder.getInstance().setContentToRead(dataToRead);
        Intent intent = new Intent(mActivityWR.get(), IRActivity.class);
        activity.startActivity(intent);

        return new IRError(Error.NONE, "Immersive Reader launched");
    }

}
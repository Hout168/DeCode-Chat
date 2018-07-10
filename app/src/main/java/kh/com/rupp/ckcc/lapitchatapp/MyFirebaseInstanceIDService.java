package kh.com.rupp.ckcc.lapitchatapp;

import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        Toast.makeText(this,"Token Refresh",Toast.LENGTH_LONG).show();
    }
}

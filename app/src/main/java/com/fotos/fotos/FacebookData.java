package com.fotos.fotos;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import java.util.ArrayList;

/**
 * Created by t-yoadat on 9/3/2015.
 */
public class FacebookData {
    private AccessToken token = null;

    public FacebookData() {
        token = AccessToken.getCurrentAccessToken();
    }

    public void GetFriends() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/{friend-list-id}",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        response.getJSONObject();
                    }
                }
        ).executeAndWait();
    }
}

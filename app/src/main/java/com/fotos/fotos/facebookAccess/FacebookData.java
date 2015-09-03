package com.fotos.fotos.facebookAccess;

import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by t-yoadat on 9/3/2015.
 */
public class FacebookData {
    private AccessToken token = null;

    public FacebookData() {
        token = AccessToken.getCurrentAccessToken();
    }
    public FacebookDataAsyncResponse delegate = null;

    public void GetFriends() {
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        try {

                            List<Friend> friendList = new ArrayList<Friend>();

                            JSONArray friends = response.getJSONObject().getJSONArray("data");
                            for (int i=0; i<friends.length(); i++) {
                                String name = friends.getJSONObject(i).getString("name");
                                String id = friends.getJSONObject(i).getString("id");

                                //Log.d("FBLogin", name + id);
                                friendList.add(new Friend(name, id));

                                delegate.GetFriendListResponce(friendList);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //JSONObject friends = (JSONObject)response.getJSONObject().get("data");

                    }
                }
        ).executeAsync();

}}

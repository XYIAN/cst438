package com.kxdilbeck.login.data;

import com.kxdilbeck.login.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        LoggedInUser Admin = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Admin");
        LoggedInUser user1 = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Kyle");
        LoggedInUser user2 = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Test");
        if(username == "Admin"){
            return new Result.Success<>(Admin);
        }
        if(username == "Kyle"){
            return new Result.Success<>(user1);
        }if(username == "Test"){
            return new Result.Success<>(user2);
        }else {


            try {
                // TODO: handle loggedInUser authentication
                LoggedInUser fakeUser = new LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe");
                return new Result.Success<>(fakeUser);
            } catch (Exception e) {
                return new Result.Error(new IOException("Error logging in", e));
            }
        }

    }//end result

    public void logout() {
        // TODO: revoke authentication
    }
}

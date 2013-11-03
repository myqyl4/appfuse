/**
 * 
 */
package org.appfuse.webapp.client.application;

import org.appfuse.webapp.client.application.base.activity.AsyncActivityProxy;
import org.appfuse.webapp.client.application.base.place.EntityProxyPlace;
import org.appfuse.webapp.client.application.base.place.EntitySearchPlace;
import org.appfuse.webapp.client.proxies.UserProxy;
import org.appfuse.webapp.client.ui.login.LoginActivity;
import org.appfuse.webapp.client.ui.login.LoginPlace;
import org.appfuse.webapp.client.ui.logout.LogoutActivity;
import org.appfuse.webapp.client.ui.logout.LogoutPlace;
import org.appfuse.webapp.client.ui.mainMenu.MainMenuActivity;
import org.appfuse.webapp.client.ui.mainMenu.MainMenuPlace;
import org.appfuse.webapp.client.ui.reloadOptions.ReloadOptionsActivity;
import org.appfuse.webapp.client.ui.reloadOptions.ReloadOptionsPlace;
import org.appfuse.webapp.client.ui.upload.FileUploadActivity;
import org.appfuse.webapp.client.ui.upload.FileUploadPlace;
import org.appfuse.webapp.client.ui.users.active.ActiveUsersActivity;
import org.appfuse.webapp.client.ui.users.active.ActiveUsersPlace;
import org.appfuse.webapp.client.ui.users.editProfile.EditProfileActivity;
import org.appfuse.webapp.client.ui.users.editProfile.EditProfilePlace;
import org.appfuse.webapp.client.ui.users.editUser.EditUserActivity;
import org.appfuse.webapp.client.ui.users.search.UsersSearchActivity;
import org.appfuse.webapp.client.ui.users.signUp.SignUpActivity;
import org.appfuse.webapp.client.ui.users.signUp.SignUpPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

/**
 * @author ivangsa
 *
 */
public class ApplicationActivityMapper implements ActivityMapper {

    @Inject
    private AsyncProvider<MainMenuActivity> mainMenuActivityProvider;
    @Inject
    private AsyncProvider<LoginActivity> loginActivityProvider;
    @Inject
    private AsyncProvider<LogoutActivity> logoutActivityProvider;
    @Inject
    private AsyncProvider<ReloadOptionsActivity> reloadOptionsActivityProvider;
    @Inject
    private AsyncProvider<SignUpActivity> signUpActivityProvider;
    @Inject
    private AsyncProvider<EditProfileActivity> editProfileActivityProvider;
    @Inject
    private AsyncProvider<ActiveUsersActivity> activeUsersActivityProvider;
    @Inject
    private AsyncProvider<FileUploadActivity> fileUploadActivityProvider;
    @Inject
    private AsyncProvider<EditUserActivity> editUserActivityProvider;
    @Inject
    private AsyncProvider<UsersSearchActivity> usersSearchActivityProvider;



    @Override
    public Activity getActivity(final Place place) {
        Activity activity = null;

        if(place instanceof LoginPlace) {
            activity = new AsyncActivityProxy<LoginActivity>(loginActivityProvider);
        }
        else if (place instanceof MainMenuPlace) {
            activity = new AsyncActivityProxy<MainMenuActivity>(mainMenuActivityProvider);
        }
        else if (place instanceof LogoutPlace) {
            activity = new AsyncActivityProxy<LogoutActivity>(logoutActivityProvider);
        }
        else if (place instanceof SignUpPlace) {
            activity = new AsyncActivityProxy<SignUpActivity>(signUpActivityProvider);
        }
        else if (place instanceof EditProfilePlace) {
            activity = new AsyncActivityProxy<EditProfileActivity>(editProfileActivityProvider);
        }
        else if (place instanceof ActiveUsersPlace) {
            activity = new AsyncActivityProxy<ActiveUsersActivity>(activeUsersActivityProvider);
        }
        else if (place instanceof FileUploadPlace) {
            activity = new AsyncActivityProxy<FileUploadActivity>(fileUploadActivityProvider);
        }
        else if (place instanceof ReloadOptionsPlace) {
            activity = new AsyncActivityProxy<ReloadOptionsActivity>(reloadOptionsActivityProvider);
        }
        else if (place instanceof EntityProxyPlace) {
            final EntityProxyPlace proxyPlace = (EntityProxyPlace) place;
            if (UserProxy.class.equals(proxyPlace.getProxyClass())) {
                activity = new AsyncActivityProxy<EditUserActivity>(editUserActivityProvider);
            }
        }
        else if (place instanceof EntitySearchPlace) {
            final EntitySearchPlace listPlace = (EntitySearchPlace) place;
            if (UserProxy.class.equals(listPlace.getProxyClass())) {
                activity = new AsyncActivityProxy<UsersSearchActivity>(usersSearchActivityProvider);
            }
        }

        return activity;
    }

}

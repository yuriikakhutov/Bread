package com.rtm516.mcxboxbroadcast.core.notifications;

import com.rtm516.mcxboxbroadcast.core.Logger;
import com.rtm516.mcxboxbroadcast.core.configs.NotificationConfig;

public class BaseNotificationManager implements NotificationManager {
    protected final Logger logger;
    protected final NotificationConfig config;

    public BaseNotificationManager(Logger logger, NotificationConfig config) {
        this.logger = logger;
        this.config = config;
    }

    /**
     * Sends the notification for when the session is expired and needs to be updated
     *
     * @param verificationUri The verification URI to use
     * @param userCode The user code to use
     */
    public void sendSessionExpiredNotification(String verificationUri, String userCode) {
        sendNotification(config.sessionExpiredMessage().formatted(verificationUri, userCode));
    }

    /**
     * Sends the notification for when a friend has restrictions in place that prevent them from be friend with our account
     *
     * @param username The username of the user
     * @param xuid The XUID of the user
     */
    public void sendFriendRestrictionNotification(String username, String xuid) {
        sendNotification(config.friendRestrictionMessage().formatted(username, xuid));
    }

    protected void sendNotification(String message) {
        if (!config.enabled()) {
            return;
        }
        throw new UnsupportedOperationException();
    }
}

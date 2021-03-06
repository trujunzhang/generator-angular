package org.wikipedia.settings;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.ieatta.IEATTAApp;
import org.ieatta.R;
import org.wikipedia.SharedPreferenceCookieManager;
import org.wikipedia.util.StringUtil;

import java.util.List;

import retrofit.RestAdapter;

import static org.wikipedia.settings.PrefsIoUtil.contains;
import static org.wikipedia.settings.PrefsIoUtil.getBoolean;
import static org.wikipedia.settings.PrefsIoUtil.getInt;
import static org.wikipedia.settings.PrefsIoUtil.getKey;
import static org.wikipedia.settings.PrefsIoUtil.getLong;
import static org.wikipedia.settings.PrefsIoUtil.getString;
import static org.wikipedia.settings.PrefsIoUtil.remove;
import static org.wikipedia.settings.PrefsIoUtil.setBoolean;
import static org.wikipedia.settings.PrefsIoUtil.setInt;
import static org.wikipedia.settings.PrefsIoUtil.setLong;
import static org.wikipedia.settings.PrefsIoUtil.setString;

/** Shared preferences utility for convenient POJO access. */
public final class Prefs {
    @Nullable
    public static String getAppChannel() {
        return getString(R.string.preference_key_app_channel, null);
    }

    public static void setAppChannel(@Nullable String channel) {
        setString(R.string.preference_key_app_channel, channel);
    }

    @NonNull
    public static String getAppChannelKey() {
        return getKey(R.string.preference_key_app_channel);
    }

    @Nullable
    public static String getAppInstallId() {
        return getString(R.string.preference_key_reading_app_install_id, null);
    }

    public static void setAppInstallId(@Nullable String id) {
        // The app install ID uses readingAppInstallID for backwards compatibility with analytics.
        setString(R.string.preference_key_reading_app_install_id, id);
    }

    @Nullable
    public static String getAppLanguageCode() {
        return getString(R.string.preference_key_language, null);
    }

    public static void setAppLanguageCode(@Nullable String code) {
        setString(R.string.preference_key_language, code);
    }

    @NonNull
    public static String getCookieDomains() {
        return getString(R.string.preference_key_cookie_domains, "");
    }

    @NonNull
    public static List<String> getCookieDomainsAsList() {
        return SharedPreferenceCookieManager.makeList(getCookieDomains());
    }

    public static void setCookieDomains(@Nullable String domains) {
        setString(R.string.preference_key_cookie_domains, domains);
    }

    @NonNull
    public static String getCookiesForDomain(@NonNull String domain) {
        return getString(getCookiesForDomainKey(domain), "");
    }

    public static void setCookiesForDomain(@NonNull String domain, @Nullable String cookies) {
        setString(getCookiesForDomainKey(domain), cookies);
    }

    public static void removeCookiesForDomain(@NonNull String domain) {
        remove(getCookiesForDomainKey(domain));
    }

    public static boolean isCrashReportAutoUploadEnabled() {
        return getBoolean(R.string.preference_key_auto_upload_crash_reports, true);
    }

    public static boolean isShowDeveloperSettingsEnabled() {
        return getBoolean(R.string.preference_key_show_developer_settings,
                IEATTAApp.getInstance().isDevRelease());
    }

    public static void setShowDeveloperSettingsEnabled(boolean enabled) {
        setBoolean(R.string.preference_key_show_developer_settings, enabled);
    }

    @NonNull
    public static String getEditTokenWikis() {
        return getString(R.string.preference_key_edittoken_wikis, "");
    }

    public static void setEditTokenWikis(@Nullable String wikis) {
        setString(R.string.preference_key_edittoken_wikis, wikis);
    }

    @Nullable
    public static String getEditTokenForWiki(@NonNull String wiki) {
        return getString(getEditTokenForWikiKey(wiki), null);
    }

    public static void setEditTokenForWiki(@NonNull String wiki, @Nullable String token) {
        setString(getEditTokenForWikiKey(wiki), token);
    }

    public static void removeEditTokenForWiki(@NonNull String wiki) {
        remove(getEditTokenForWikiKey(wiki));
    }

    public static void removeLoginUsername() {
        remove(R.string.preference_key_login_username);
    }

    @Nullable
    public static String getLoginPassword() {
        return getString(R.string.preference_key_login_password, null);
    }

    public static void setLoginPassword(@Nullable String password) {
        setString(R.string.preference_key_login_password, password);
    }

    public static boolean hasLoginPassword() {
        return contains(R.string.preference_key_login_password);
    }

    public static void removeLoginPassword() {
        remove(R.string.preference_key_login_password);
    }

    public static int getLoginUserId() {
        return getInt(R.string.preference_key_login_user_id, 0);
    }

    public static void setLoginUserId(int id) {
        setInt(R.string.preference_key_login_user_id, id);
    }

    public static void removeLoginUserId() {
        remove(R.string.preference_key_login_user_id);
    }

    @Nullable
    public static String getLoginUsername() {
        return getString(R.string.preference_key_login_username, null);
    }

    public static void setLoginUsername(@Nullable String username) {
        setString(R.string.preference_key_login_username, username);
    }

    public static boolean hasLoginUsername() {
        return contains(R.string.preference_key_login_username);
    }

    @Nullable
    public static String getMruLanguageCodeCsv() {
        return getString(R.string.preference_key_language_mru, null);
    }

    public static void setMruLanguageCodeCsv(@Nullable String csv) {
        setString(R.string.preference_key_language_mru, csv);
    }

    @NonNull
    public static String getRemoteConfigJson() {
        return getString(R.string.preference_key_remote_config, "{}");
    }

    public static void setRemoteConfigJson(@Nullable String json) {
        setString(R.string.preference_key_remote_config, json);
    }

    public static void clearTabs() {
        remove(R.string.preference_key_tabs);
    }

    public static boolean hasSessionData() {
        return contains(R.string.preference_key_session_data);
    }


    public static int getTextSizeMultiplier() {
        return getInt(R.string.preference_key_text_size_multiplier, 0);
    }

    public static void setTextSizeMultiplier(int multiplier) {
        setInt(R.string.preference_key_text_size_multiplier, multiplier);
    }

    public static boolean isEventLoggingEnabled() {
        return getBoolean(R.string.preference_key_eventlogging_opt_in, true);
    }

    public static boolean useRestBaseSetManually() {
        return getBoolean(R.string.preference_key_use_restbase_manual, false);
    }

    public static boolean useRestBase() {
        return getBoolean(R.string.preference_key_use_restbase, false);
    }

    public static void setUseRestBase(boolean enabled) {
        setBoolean(R.string.preference_key_use_restbase, enabled);
    }

    public static int getRbTicket(int defaultValue) {
        return getInt(R.string.preference_key_restbase_ticket, defaultValue);
    }

    public static void setRbTicket(int rbTicket) {
        setInt(R.string.preference_key_restbase_ticket, rbTicket);
    }

    public static int getRequestSuccessCounter(int defaultValue) {
        return getInt(R.string.preference_key_request_successes, defaultValue);
    }

    public static void setRequestSuccessCounter(int successes) {
        setInt(R.string.preference_key_request_successes, successes);
    }

    public static RestAdapter.LogLevel getRetrofitLogLevel() {
        String prefValue = getString(R.string.preference_key_retrofit_log_level, null);
        if (prefValue == null) {
            return RestAdapter.LogLevel.NONE;
        }
        switch (prefValue) {
            case "BASIC":
                return RestAdapter.LogLevel.BASIC;
            case "HEADERS":
                return RestAdapter.LogLevel.HEADERS;
            case "HEADERS_AND_ARGS":
                return RestAdapter.LogLevel.HEADERS_AND_ARGS;
            case "FULL":
                return RestAdapter.LogLevel.FULL;
            case "NONE":
            default:
                return RestAdapter.LogLevel.NONE;
        }
    }

    @NonNull
    public static String getRestbaseUriFormat() {
        return StringUtil.defaultIfBlank(getString(R.string.preference_key_restbase_uri_format, null),
                "%1$s://%2$s/api/rest_v1");
    }

    public static long getLastRunTime(@NonNull String task) {
        return getLong(getLastRunTimeKey(task), 0);
    }

    public static void setLastRunTime(@NonNull String task, long time) {
        setLong(getLastRunTimeKey(task), time);
    }

    public static boolean isShowZeroInterstitialEnabled() {
        return getBoolean(R.string.preference_key_zero_interstitial, true);
    }

    public static boolean isSelectTextTutorialEnabled() {
        return getBoolean(R.string.preference_key_select_text_tutorial_enabled, true);
    }

    public static void setSelectTextTutorialEnabled(boolean enabled) {
        setBoolean(R.string.preference_key_select_text_tutorial_enabled, enabled);
    }

    public static boolean isShareTutorialEnabled() {
        return getBoolean(R.string.preference_key_share_tutorial_enabled, true);
    }

    public static void setShareTutorialEnabled(boolean enabled) {
        setBoolean(R.string.preference_key_share_tutorial_enabled, enabled);
    }

    public static boolean isFeatureReadMoreSearchOpeningTextEnabled() {
        return getBoolean(R.string.preference_key_feature_read_more_search_opening_text, true);
    }

    public static void setFeatureReadMoreSearchOpeningTextEnabled(boolean enabled) {
        setBoolean(R.string.preference_key_feature_read_more_search_opening_text, enabled);
    }

    public static boolean hasFeatureReadMoreSearchOpeningText() {
        return contains(R.string.preference_key_feature_read_more_search_opening_text);
    }

    public static boolean isTocTutorialEnabled() {
        return getBoolean(R.string.preference_key_toc_tutorial_enabled, true);
    }

    public static void setTocTutorialEnabled(boolean enabled) {
        setBoolean(R.string.preference_key_toc_tutorial_enabled, enabled);
    }

    public static boolean isImageDownloadEnabled() {
        return getBoolean(R.string.preference_key_show_images, true);
    }

    public static String getEditTokenForWikiKey(String wiki) {
        return getKey(R.string.preference_key_edittoken_for_wiki_format, wiki);
    }

    public static String getCookiesForDomainKey(@NonNull String domain) {
        return getKey(R.string.preference_key_cookies_for_domain_format, domain);
    }

    private static String getLastRunTimeKey(@NonNull String task) {
        return getKey(R.string.preference_key_last_run_time_format, task);
    }

    public static boolean isLinkPreviewEnabled() {
        return getBoolean(R.string.preference_key_show_link_previews, true);
    }

    private Prefs() { }
}

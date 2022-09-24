package net.rcarz.jiraclient;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tatooi
 * @since 1.0
 */
public class Assignee extends Resource {
    private String key = null;
    private String accountId = null;
    private String accountType = null;
    private String name = null;
    private Map<String, String> avatarUrls = null;
    private String displayName = null;
    private String timeZone = null;
    private String emailAddress = null;
    private String locale = null;
    private boolean active = false;

    /**
     * Creates a user JIRA resource.
     *
     * @param restclient REST client instance
     */
    public Assignee(RestClient restclient, JSONObject jsonObject) {
        super(restclient);
        deserialise(jsonObject);
    }

    public static List<Assignee> searchAssignee(RestClient restclient, String username, String projectKey,
                                                String maxResults) throws JiraException {
        JSON result = null;

        Map<String, String> params = new HashMap<String, String>();
        params.put("query", username);
        params.put("projectKeys", projectKey);
        params.put("maxResults", maxResults != null ? maxResults : "50");
        params.put("startAt", "0");

        try {
            result = restclient.get(getBaseUri() + "user/assignable/multiProjectSearch", params);
        } catch (Exception ex) {
            throw new JiraException("Failed to retrieve user " + username, ex);
        }

        if (!(result instanceof JSONArray))
            throw new JiraException("JSON payload is malformed");

        return Field.getResourceArray(Assignee.class, result, restclient);
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    private void deserialise(JSONObject json) {
        Map map = json;

        self = Field.getString(map.get("self"));
        id = Field.getString(map.get("accountId"));
        accountId = Field.getString(map.get("accountId"));
        accountType = Field.getString(map.get("accountType"));
        emailAddress = Field.getString(map.get("emailAddress"));
        avatarUrls = Field.getMap(String.class, String.class, map.get("avatarUrls"));
        active = Field.getBoolean(map.get("active"));
        timeZone = Field.getString(map.get("timeZone"));
        locale = Field.getString(map.get("locale"));
        displayName = Field.getString(map.get("displayName"));
        name = Field.getString(map.get("name"));
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(Map<String, String> avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}

package net.rcarz.jiraclient;

import junit.framework.TestCase;

import java.util.List;

/**
 * @author Tatooi
 * @since 1.0
 */
public class AssigneeTest extends TestCase {

    public void testSearchAssignee() {

        BasicCredentials creds = new BasicCredentials("tatooi.noyo@gmail.com", "xxxx");
        JiraClient jiraClient = null;
        try {
            jiraClient= new JiraClient("https://tatooinoyo.atlassian.net", creds);
        } catch (JiraException e) {
            e.printStackTrace();
        }
        try {
            List<Assignee> assignees = Assignee.searchAssignee(jiraClient.getRestClient(), "Noyo", "EX", null);
            System.out.println(assignees);
        } catch (JiraException e) {
            e.printStackTrace();
        }
    }
}
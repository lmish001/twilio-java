/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Workflow extends Resource {
    private static final long serialVersionUID = 90619369199227L;

    /**
     * Create a WorkflowFetcher to execute fetch.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return WorkflowFetcher capable of executing the fetch
     */
    public static WorkflowFetcher fetcher(final String workspaceSid, 
                                          final String sid) {
        return new WorkflowFetcher(workspaceSid, sid);
    }

    /**
     * Create a WorkflowUpdater to execute update.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return WorkflowUpdater capable of executing the update
     */
    public static WorkflowUpdater updater(final String workspaceSid, 
                                          final String sid) {
        return new WorkflowUpdater(workspaceSid, sid);
    }

    /**
     * Create a WorkflowDeleter to execute delete.
     * 
     * @param workspaceSid The workspace_sid
     * @param sid The sid
     * @return WorkflowDeleter capable of executing the delete
     */
    public static WorkflowDeleter deleter(final String workspaceSid, 
                                          final String sid) {
        return new WorkflowDeleter(workspaceSid, sid);
    }

    /**
     * Create a WorkflowReader to execute read.
     * 
     * @param workspaceSid The workspace_sid
     * @return WorkflowReader capable of executing the read
     */
    public static WorkflowReader reader(final String workspaceSid) {
        return new WorkflowReader(workspaceSid);
    }

    /**
     * Create a WorkflowCreator to execute create.
     * 
     * @param workspaceSid The workspace_sid
     * @param friendlyName The friendly_name
     * @param configuration The configuration
     * @return WorkflowCreator capable of executing the create
     */
    public static WorkflowCreator creator(final String workspaceSid, 
                                          final String friendlyName, 
                                          final String configuration) {
        return new WorkflowCreator(workspaceSid, friendlyName, configuration);
    }

    /**
     * Converts a JSON String into a Workflow object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Workflow object represented by the provided JSON
     */
    public static Workflow fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Workflow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Workflow object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Workflow object represented by the provided JSON
     */
    public static Workflow fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Workflow.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final URI assignmentCallbackUrl;
    private final String configuration;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String documentContentType;
    private final URI fallbackAssignmentCallbackUrl;
    private final String friendlyName;
    private final String sid;
    private final Integer taskReservationTimeout;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private Workflow(@JsonProperty("account_sid")
                     final String accountSid, 
                     @JsonProperty("assignment_callback_url")
                     final URI assignmentCallbackUrl, 
                     @JsonProperty("configuration")
                     final String configuration, 
                     @JsonProperty("date_created")
                     final String dateCreated, 
                     @JsonProperty("date_updated")
                     final String dateUpdated, 
                     @JsonProperty("document_content_type")
                     final String documentContentType, 
                     @JsonProperty("fallback_assignment_callback_url")
                     final URI fallbackAssignmentCallbackUrl, 
                     @JsonProperty("friendly_name")
                     final String friendlyName, 
                     @JsonProperty("sid")
                     final String sid, 
                     @JsonProperty("task_reservation_timeout")
                     final Integer taskReservationTimeout, 
                     @JsonProperty("workspace_sid")
                     final String workspaceSid, 
                     @JsonProperty("url")
                     final URI url) {
        this.accountSid = accountSid;
        this.assignmentCallbackUrl = assignmentCallbackUrl;
        this.configuration = configuration;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.documentContentType = documentContentType;
        this.fallbackAssignmentCallbackUrl = fallbackAssignmentCallbackUrl;
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.taskReservationTimeout = taskReservationTimeout;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The assignment_callback_url.
     * 
     * @return The assignment_callback_url
     */
    public final URI getAssignmentCallbackUrl() {
        return this.assignmentCallbackUrl;
    }

    /**
     * Returns The The configuration.
     * 
     * @return The configuration
     */
    public final String getConfiguration() {
        return this.configuration;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The document_content_type.
     * 
     * @return The document_content_type
     */
    public final String getDocumentContentType() {
        return this.documentContentType;
    }

    /**
     * Returns The The fallback_assignment_callback_url.
     * 
     * @return The fallback_assignment_callback_url
     */
    public final URI getFallbackAssignmentCallbackUrl() {
        return this.fallbackAssignmentCallbackUrl;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The task_reservation_timeout.
     * 
     * @return The task_reservation_timeout
     */
    public final Integer getTaskReservationTimeout() {
        return this.taskReservationTimeout;
    }

    /**
     * Returns The The workspace_sid.
     * 
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Workflow other = (Workflow) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(assignmentCallbackUrl, other.assignmentCallbackUrl) && 
               Objects.equals(configuration, other.configuration) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(documentContentType, other.documentContentType) && 
               Objects.equals(fallbackAssignmentCallbackUrl, other.fallbackAssignmentCallbackUrl) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(taskReservationTimeout, other.taskReservationTimeout) && 
               Objects.equals(workspaceSid, other.workspaceSid) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            assignmentCallbackUrl,
                            configuration,
                            dateCreated,
                            dateUpdated,
                            documentContentType,
                            fallbackAssignmentCallbackUrl,
                            friendlyName,
                            sid,
                            taskReservationTimeout,
                            workspaceSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("assignmentCallbackUrl", assignmentCallbackUrl)
                          .add("configuration", configuration)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("documentContentType", documentContentType)
                          .add("fallbackAssignmentCallbackUrl", fallbackAssignmentCallbackUrl)
                          .add("friendlyName", friendlyName)
                          .add("sid", sid)
                          .add("taskReservationTimeout", taskReservationTimeout)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .toString();
    }
}
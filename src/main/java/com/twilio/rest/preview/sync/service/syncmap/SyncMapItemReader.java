/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.preview.sync.service.syncmap;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SyncMapItemReader extends Reader<SyncMapItem> {
    private final String serviceSid;
    private final String mapSid;
    private SyncMapItem.QueryResultOrder order;
    private String from;
    private SyncMapItem.QueryFromBoundType bounds;

    /**
     * Construct a new SyncMapItemReader.
     * 
     * @param serviceSid The service_sid
     * @param mapSid The map_sid
     */
    public SyncMapItemReader(final String serviceSid, 
                             final String mapSid) {
        this.serviceSid = serviceSid;
        this.mapSid = mapSid;
    }

    /**
     * The order.
     * 
     * @param order The order
     * @return this
     */
    public SyncMapItemReader setOrder(final SyncMapItem.QueryResultOrder order) {
        this.order = order;
        return this;
    }

    /**
     * The from.
     * 
     * @param from The from
     * @return this
     */
    public SyncMapItemReader setFrom(final String from) {
        this.from = from;
        return this;
    }

    /**
     * The bounds.
     * 
     * @param bounds The bounds
     * @return this
     */
    public SyncMapItemReader setBounds(final SyncMapItem.QueryFromBoundType bounds) {
        this.bounds = bounds;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return SyncMapItem ResourceSet
     */
    @Override
    public ResourceSet<SyncMapItem> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return SyncMapItem ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<SyncMapItem> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.PREVIEW.toString(),
            "/Sync/Services/" + this.serviceSid + "/Maps/" + this.mapSid + "/Items",
            client.getRegion()
        );
        
        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<SyncMapItem> nextPage(final Page<SyncMapItem> page, 
                                      final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.PREVIEW.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of SyncMapItem Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<SyncMapItem> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("SyncMapItem read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Page.fromJson(
            "items",
            response.getContent(),
            SyncMapItem.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (order != null) {
            request.addQueryParam("Order", order.toString());
        }
        
        if (from != null) {
            request.addQueryParam("From", from);
        }
        
        if (bounds != null) {
            request.addQueryParam("Bounds", bounds.toString());
        }
        
        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.preview.wireless;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class RatePlanTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.PREVIEW.toString(),
                                          "/wireless/RatePlans");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            RatePlan.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"first_page_url\": \"https://preview.twilio.com/wireless/RatePlans?Page=0&PageSize=50\",\"key\": \"rate_plans\",\"next_page_url\": null,\"page\": 0,\"page_size\": 0,\"previous_page_url\": null,\"url\": \"https://preview.twilio.com/wireless/RatePlans\"},\"rate_plans\": []}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(RatePlan.reader().read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"first_page_url\": \"https://preview.twilio.com/wireless/RatePlans?Page=0&PageSize=50\",\"key\": \"rate_plans\",\"next_page_url\": null,\"page\": 0,\"page_size\": 1,\"previous_page_url\": null,\"url\": \"https://preview.twilio.com/wireless/RatePlans\"},\"rate_plans\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"alias\": \"alias\",\"commands\": {\"enabled\": true},\"data\": {\"limit\": 1000,\"metering\": \"pooled\"},\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"renewal\": {\"period\": 10,\"units\": \"days\"},\"roaming\": [\"National\"],\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://preview.twilio.com/wireless/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(RatePlan.reader().read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.PREVIEW.toString(),
                                          "/wireless/RatePlans/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            RatePlan.fetcher("DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"alias\": \"alias\",\"commands\": {\"enabled\": true},\"data\": {\"limit\": 1000,\"metering\": \"pooled\"},\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"renewal\": {\"period\": 10,\"units\": \"days\"},\"roaming\": [\"National\"],\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://preview.twilio.com/wireless/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(RatePlan.fetcher("DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").fetch());
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.PREVIEW.toString(),
                                          "/wireless/RatePlans");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            RatePlan.creator().create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"alias\": \"alias\",\"commands\": {\"enabled\": true},\"data\": {\"limit\": 1000,\"metering\": \"pooled\"},\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"renewal\": {\"period\": 10,\"units\": \"days\"},\"roaming\": [\"National\"],\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://preview.twilio.com/wireless/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        RatePlan.creator().create();
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.PREVIEW.toString(),
                                          "/wireless/RatePlans/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            RatePlan.updater("DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"alias\": \"alias\",\"commands\": {\"enabled\": true},\"data\": {\"limit\": 1000,\"metering\": \"pooled\"},\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"renewal\": {\"period\": 10,\"units\": \"days\"},\"roaming\": [\"National\"],\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://preview.twilio.com/wireless/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        RatePlan.updater("DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").update();
    }
}
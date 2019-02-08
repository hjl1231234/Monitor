package leavesc.hello.monitor.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import leavesc.hello.monitor.model.HttpInformation;

/**
 * 作者：leavesC
 * 时间：2019/2/8 21:03
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
@Entity(tableName = "monitor_httpInformation")
public class MonitorHttpInformation {

    public enum Status {Requested, Complete, Failed}

    private static final SimpleDateFormat TIME_ONLY_FMT = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);

    @PrimaryKey(autoGenerate = true)
    private long id;

    private Date requestDate;
    private Date responseDate;
    private long duration;
    private String method;

    private String url;
    private String host;
    private String path;
    private String scheme;
    private String protocol;

    private String requestHeaders;
    private String requestBody;
    private String requestContentType;
    private long requestContentLength;

    private int responseCode = HttpInformation.DEFAULT_RESPONSE_CODE;
    private String responseHeaders;
    private String responseBody;
    private String responseMessage;
    private String responseContentType;
    private long responseContentLength;

    private String error;

    public Status getStatus() {
        if (error != null) {
            return Status.Failed;
        } else if (responseCode == HttpInformation.DEFAULT_RESPONSE_CODE) {
            return Status.Requested;
        } else {
            return Status.Complete;
        }
    }

    public String getRequestDateFormat() {
        if (requestDate == null) {
            return "";
        }
        return TIME_ONLY_FMT.format(requestDate);
    }

    public String getResponseDateFormat() {
        if (responseDate == null) {
            return "";
        }
        return TIME_ONLY_FMT.format(responseDate);
    }

    public String getNotificationText() {
        switch (getStatus()) {
            case Failed:
                return " ! ! !  " + path;
            case Requested:
                return " . . .  " + path;
            default:
                return String.valueOf(responseCode) + " " + path;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public void setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestContentType() {
        return requestContentType;
    }

    public void setRequestContentType(String requestContentType) {
        this.requestContentType = requestContentType;
    }

    public long getRequestContentLength() {
        return requestContentLength;
    }

    public void setRequestContentLength(long requestContentLength) {
        this.requestContentLength = requestContentLength;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseContentType() {
        return responseContentType;
    }

    public void setResponseContentType(String responseContentType) {
        this.responseContentType = responseContentType;
    }

    public long getResponseContentLength() {
        return responseContentLength;
    }

    public void setResponseContentLength(long responseContentLength) {
        this.responseContentLength = responseContentLength;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @NonNull
    @Override
    public String toString() {
        return "MonitorHttpInformation{" +
                "id=" + id +
                ", requestDate=" + requestDate +
                ", responseDate=" + responseDate +
                ", duration=" + duration +
                ", method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", scheme='" + scheme + '\'' +
                ", protocol='" + protocol + '\'' +
                ", requestHeaders='" + requestHeaders + '\'' +
                ", requestBody='" + requestBody + '\'' +
                ", requestContentType='" + requestContentType + '\'' +
                ", requestContentLength=" + requestContentLength +
                ", responseCode=" + responseCode +
                ", responseHeaders='" + responseHeaders + '\'' +
                ", responseBody='" + responseBody + '\'' +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseContentType='" + responseContentType + '\'' +
                ", responseContentLength=" + responseContentLength +
                ", error='" + error + '\'' +
                '}';
    }

}
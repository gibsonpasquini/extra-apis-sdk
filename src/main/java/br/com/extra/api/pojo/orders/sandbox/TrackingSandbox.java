package br.com.extra.api.pojo.orders.sandbox;

import java.io.Serializable;

public class TrackingSandbox implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String trackingCode;
    private String trackingDate;
    private String trackingStep;
    private String trackingTitle;
    private String trackingMessage;
    private String trackingStepStatus;
    
    public TrackingSandbox() {
    }

	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public String getTrackingDate() {
		return trackingDate;
	}

	public void setTrackingDate(String trackingDate) {
		this.trackingDate = trackingDate;
	}

	public String getTrackingStep() {
		return trackingStep;
	}

	public void setTrackingStep(String trackingStep) {
		this.trackingStep = trackingStep;
	}

	public String getTrackingTitle() {
		return trackingTitle;
	}

	public void setTrackingTitle(String trackingTitle) {
		this.trackingTitle = trackingTitle;
	}

	public String getTrackingMessage() {
		return trackingMessage;
	}

	public void setTrackingMessage(String trackingMessage) {
		this.trackingMessage = trackingMessage;
	}

	public String getTrackingStepStatus() {
		return trackingStepStatus;
	}

	public void setTrackingStepStatus(String trackingStepStatus) {
		this.trackingStepStatus = trackingStepStatus;
	}
    
    
}

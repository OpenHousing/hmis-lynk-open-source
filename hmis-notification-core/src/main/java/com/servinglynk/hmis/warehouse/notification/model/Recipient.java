package com.servinglynk.hmis.warehouse.notification.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationMethod;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationStatus;


@JsonRootName("recipient")
public class Recipient {

	private String externalId;

	private String username;
	
	private String notificationId;

	private NotificationMethod deliveryMethod;
	
	private String deliverTo;
	
	private Integer carrierAttempts;

	private Integer attempts;

	private NotificationStatus status;
	
	private String statusMessage;

	private String carrier;

	private String carrierConfirmation;

	private String templateId;
	

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public NotificationMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public void setDeliveryMethod(NotificationMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDeliverTo() {
		return deliverTo;
	}

	public void setDeliverTo(String to) {
		this.deliverTo = to;
	}
	
	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	public NotificationStatus getStatus() {
		return status;
	}

	public void setStatus(NotificationStatus status) {
		this.status = status;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Integer getCarrierAttempts() {
		return carrierAttempts;
	}

	public void setCarrierAttempts(Integer carrierAttempts) {
		this.carrierAttempts = carrierAttempts;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCarrierConfirmation() {
		return carrierConfirmation;
	}

	public void setCarrierConfirmation(String carrierConfirmation) {
		this.carrierConfirmation = carrierConfirmation;
	}
}
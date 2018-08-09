package com.relay42.axoncomplaintsstatistics.domain;

/**
 * The Class ComplaintFiledEvent.
 */
/**
 * @author meetidnani
 *
 */
public class ComplaintFiledEvent {

	/** The complaint id. */
	private final String complaintId;
	
	/** The company. */
	private final String company;
	
	/** The description. */
	private final String description;

	
	/**
	 * Instantiates a new complaint filed event.
	 *
	 * @param complaintId the complaint id
	 * @param company the company
	 * @param description the description
	 */
	public ComplaintFiledEvent(String complaintId, String company, String description) {
		super();
		this.complaintId = complaintId;
		this.company = company;
		this.description = description;
	}


	/**
	 * Gets the complaint id.
	 *
	 * @return the complaint id
	 */
	public String getComplaintId() {
		return complaintId;
	}


	/**
	 * Gets the company.
	 *
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	
	
}

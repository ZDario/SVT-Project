package com.example.SvtProject.dto;

import java.util.Date;

import com.example.SvtProject.model.Community;

public class CommunityDTO {

	private Long idCommunity;
    private String name;
    private String description;
    private Date creationDate;
    private String rules;
    private boolean isSuspended;
    private String suspendedReason;
    
    public CommunityDTO() {
		super();
	}

    public CommunityDTO(Long idCommunity, String name, String description, Date creationDate, String rules, boolean isSuspended, String suspendedReason) {
        this.idCommunity = idCommunity;
    	this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.rules = rules;
        this.isSuspended = isSuspended;
        this.suspendedReason = suspendedReason;
    }
    
    public CommunityDTO(Community community) {
    	this(community.getIdCommunity(), community.getName(), community.getDescription(), community.getCreationDate(), community.getRules(), community.isSuspended(), community.getSuspendedReason());
    }

	public Long getIdCommunity() {
		return idCommunity;
	}

	public void setIdCommunity(Long idCommunity) {
		this.idCommunity = idCommunity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public String getSuspendedReason() {
		return suspendedReason;
	}

	public void setSuspendedReason(String suspendedReason) {
		this.suspendedReason = suspendedReason;
	}
    
}

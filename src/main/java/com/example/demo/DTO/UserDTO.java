package com.example.demo.DTO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



/**
 * User
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
 
    "id",
    "created",
    "firstName",
    "lastName",
    "email",
    "username",
    "enabled",
    "roles"
   
})
public class UserDTO {

 
    @JsonProperty("id")
    @JsonPropertyDescription("The unique identifier for a user")
    private long id;
    @JsonProperty("created")
    private Date created;
  
    
    @JsonProperty("firstName")
    private String firstName;
  
 
    

    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;
  
    @JsonProperty("enabled")
    private int enabled;
    
    @JsonProperty("roles")
    private List<RolesDTO> roles=new ArrayList<RolesDTO>();;
  


    /**
     * The unique identifier for a user
     * (Required)
     * 
     */
    @JsonProperty("id")
    public long getId() {
        return id;
    }
    
    @JsonProperty("id")
    public void setId(long id) {
		this.id = id;
	}



    @JsonProperty("created")
	public Date getCreated() {
		return created;
	}


    @JsonProperty("created")
	public void setCreated(Date created) {
		this.created = created;
	}


    @JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}


    @JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    @JsonProperty("lastName")
    public String getLastName() {
		return lastName;
	}


    @JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


    @JsonProperty("email")
	public String getEmail() {
		return email;
	}


    @JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}


    @JsonProperty("username")
	public String getUsername() {
		return username;
	}


    @JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}


    @JsonProperty("enabled")
	public int getEnabled() {
		return enabled;
	}


    @JsonProperty("enabled")
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


    @JsonProperty("roles")
	public List<RolesDTO> getRoles() {
		return roles;
	}


    @JsonProperty("roles")
	public void setRoles(List<RolesDTO> roles) {
		this.roles = roles;
	}


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
  
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(created).append(firstName).append(lastName).append(email).append(username).append(enabled).append(roles).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserDTO) == false) {
            return false;
        }
        UserDTO rhs = ((UserDTO) other);
        return new EqualsBuilder().append(id, rhs.id).append(created, rhs.created).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(email, rhs.email).append(username, rhs.username).append(enabled, rhs.enabled).append(roles, rhs.roles).isEquals();
    }
}



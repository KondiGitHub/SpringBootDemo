package com.mydomain.DbService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String clientName;
	private String clientId;
    private String firstName;
    private String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName, String clientName, String clientId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientId = clientId;
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s' clientName='%s', clientId='%s']",
                id, firstName, lastName,clientName,clientId);
    }
}

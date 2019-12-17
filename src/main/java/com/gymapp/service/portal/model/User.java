package com.gymapp.service.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement(name = "users")
@Entity
@Table(name = "users")
@Audited
public class User extends AbstractEntity {

    /**
     *
     */
    private static final long serialVersionUID = 6097953091074780838L;

    @JsonProperty("name")
    @Column(name = "name", nullable = false, unique=true, length = 150)
    private String name;

    @JsonProperty("telephoneNumbers")
    @Column(name = "telephoneNumbers", nullable = true, length = 150)
    private String telephoneNumbers;


    @JsonProperty("emailAddresses")
    @Column(name = "emailAddresses", nullable = true, length = 150)
    private String emailAddresses;

    @PrePersist
    @PreUpdate
    public void update() {
        if(super.getUuid()==null)
            setUuid(UUID.randomUUID().toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(String telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(String emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", telephoneNumbers='" + telephoneNumbers + '\'' +
                ", emailAddresses='" + emailAddresses + '\'' +
                '}';
    }
}

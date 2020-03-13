package com.foodforcharity.common;

import java.util.HashSet;
import java.util.Set;

public class Authority {

    static public enum AuthorityEnum {
        Broker(1), Donee(2), Donor(3), CreateRequest(4), MakeFoodAvailable(5), NoAuthority(6);

        private final int value;

        private AuthorityEnum(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }
    }

    static public enum PersonRole {
        Broker(1, AuthorityEnum.Broker), Donee(2, AuthorityEnum.Donee), Donor(3, AuthorityEnum.Donor);

        private final int value;
        private final AuthorityEnum authorityEnum;

        private PersonRole(final int value, final AuthorityEnum authorityEnum) {
            this.value = value;
            this.authorityEnum = authorityEnum;
        }

        public int getvalue() {
            return value;
        }

        public AuthorityEnum getAuthority(){
            return authorityEnum;
        }

    }

    public interface Status {
        public AuthorityEnum getAuthority();
        public PersonRole targetPersonRole();
    }

    static public enum BrokerStatus implements Status {
        ;

        public AuthorityEnum getAuthority() {
            return AuthorityEnum.Broker;
        } 
        
        public PersonRole targetPersonRole(){
            return PersonRole.Broker;
        }
    }

    static public enum DonorStatus implements Status {
        Initial(1, AuthorityEnum.Donor), Active(2, AuthorityEnum.MakeFoodAvailable),
        Inactive(3, AuthorityEnum.MakeFoodAvailable), Suspended(3, AuthorityEnum.NoAuthority);

        private final int value;
        private final AuthorityEnum authorityEnum;

        private DonorStatus(final int value, final AuthorityEnum authorityEnum) {
            this.value = value;
            this.authorityEnum = authorityEnum;
        }

        public int getvalue() {
            return value;
        }

        public AuthorityEnum getAuthority() {
            return authorityEnum;
        }

        public PersonRole targetPersonRole(){
            return PersonRole.Donor;
        }

    }

    static public enum DoneeStatus implements Status {
        Initial(1, AuthorityEnum.Donee), Active(2, AuthorityEnum.CreateRequest),
        Suspended(3, AuthorityEnum.NoAuthority);

        private final int value;
        private final AuthorityEnum authorityEnum;

        private DoneeStatus(final int value, final AuthorityEnum authorityEnum) {
            this.value = value;
            this.authorityEnum = authorityEnum;
        }

        public int getvalue() {
            return value;
        }

        public AuthorityEnum getAuthority() {
            return authorityEnum;
        }

        public PersonRole targetPersonRole(){
            return PersonRole.Donee;
        }

    }

    private final PersonRole personRole;

    private final Status status;

    public Authority(PersonRole personRole, Status status) {
        if(personRole != status.targetPersonRole())
            throw new IllegalArgumentException();
        
        this.personRole = personRole;
        this.status = status;
    }

    public PersonRole getRole() {
        return personRole;
    }

    public Status getStatus() {
        return status;
    }

    public Set<AuthorityEnum> getAuthority(){
        Set<AuthorityEnum> authorities = new HashSet<AuthorityEnum>();
        authorities.add(personRole.getAuthority());
        authorities.add(status.getAuthority());
        return authorities;
    }

}
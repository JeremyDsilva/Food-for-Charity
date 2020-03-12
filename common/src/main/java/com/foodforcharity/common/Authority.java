package com.foodforcharity.common;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    static public enum PersonRole {
        Broker(1), Donee(2), Donor(3);

        private final int value;

        private PersonRole(final int value) {
            this.value = value;
        }

        public int getvalue() {
            return value;
        }

    }

    public interface Status {
        public String name();
        public boolean hasAccess();
    }

    static public enum BrokerStatus implements Status {
        Active(true);

        private final boolean _hasAccess;

        private BrokerStatus(final boolean hasAccess) {
            this._hasAccess = hasAccess;
        }

        public boolean hasAccess() {
            return _hasAccess;
        }
    }

    static public enum DonorStatus implements Status  {
        Initial(1, false), Active(2, true), Inactive(3, true), Suspended(3, true);

        private final int value;
        private final boolean _hasAccess;

        private DonorStatus(final int value, final boolean hasAccess) {
            this.value = value;
            this._hasAccess = hasAccess;
        }

        public int getvalue() {
            return value;
        }

        public boolean hasAccess() {
            return _hasAccess;
        }

    }

    static public enum DoneeStatus implements Status {
        Initial(1, false), Active(2, true), Suspended(3, true);

        private final int value;
        private final boolean _hasAccess;

        private DoneeStatus(int value, boolean hasAccess) {
            this.value = value;
            this._hasAccess = hasAccess;
        }

        public int getvalue() {
            return value;
        }

        public boolean hasAccess() {
            return _hasAccess;
        }

    }

    private final PersonRole personRole;

    private final Status status;

    public Authority(PersonRole personRole, Status status){
        this.personRole = personRole;
        this.status = status;
    }

    public PersonRole getRole(){
        return personRole;
    }

    public Status getStatus(){
        return status;
    }

    @Override
    public String getAuthority() {
        return personRole.name() + '_' + status.name();
    }

}
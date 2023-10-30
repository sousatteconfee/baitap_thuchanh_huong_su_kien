package shop.configuration;

import lombok.AllArgsConstructor;

public interface AuthAccess {

    @AllArgsConstructor
    enum ROLE {
        ADMIN("ADMIN"),
        STAFF("STAFF"),
        SELLER("SELLER"),
        BUYER("BUYER");

        public final String value;
    }

    ROLE[] C_ACCOUNT = {ROLE.ADMIN};
    ROLE[] C_PRODUCT = {ROLE.ADMIN, ROLE.SELLER};
    ROLE[] C_CATEGORY = {ROLE.ADMIN, ROLE.STAFF};
    ROLE[] C_ACTIVE_PRODUCT = {ROLE.ADMIN, ROLE.STAFF};
    ROLE[] C_ORDER_SCANNER = {ROLE.ADMIN, ROLE.STAFF};
    ROLE[] C_ORDER = {ROLE.ADMIN, ROLE.STAFF, ROLE.BUYER};
}

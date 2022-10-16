package com.company.composition;

public class BetterAccount {
        private String firstName;
        private String lastName;
        private String username;

        private Address shippingAddress;
        private Address billingAddress;

        public BetterAccount() {
        }

        public BetterAccount(String firstName, String lastName, String username, Address shippingAddress, Address billingAddress) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.username = username;
            this.shippingAddress = shippingAddress;
            this.billingAddress = billingAddress;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Address getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public Address getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
        }

        @Override
        public String toString() {
            return "BetterAccount{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", username='" + username + '\'' +
                    ", shippingAddress=" + shippingAddress +
                    ", billingAddress=" + billingAddress +
                    '}';
        }
}

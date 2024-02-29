
package com.dev.clibank.domain.vo;
class Address {

        private final String street;
        private final String country;
        private final String streetNumber;

        public Address(String street, String country, String streetNumber) {

            if(!isValidStreetNumber(streetNumber)) {
                throw new IllegalArgumentException("Street number invalid.");
            }

            this.street = street;
            this.country = country;
            this.streetNumber = streetNumber;
        }


        private boolean isValidStreetNumber(String streetNumber) {
            try {
                Integer number = Integer.parseInt(streetNumber);
                return number > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }


}
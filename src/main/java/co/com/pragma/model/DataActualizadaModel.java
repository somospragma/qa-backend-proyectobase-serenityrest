package co.com.pragma.model;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonIgnore;

public class DataActualizadaModel {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    @JsonIgnore
    private Bookingdate bookingdate;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public Bookingdate getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Bookingdate bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "DataActualizadaModel{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdate=" + bookingdate +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}

package com.example.lab3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Call {
    private int CallID;
    private String SubscriberNumber;
    private String CalledNumber;
    private LocalDateTime CallDateTime;
    private int DurationSeconds;
    private BigDecimal TariffRate;

    public Call() {
    }

    public Call(int callID, String subscriberNumber, String calledNumber, LocalDateTime callDateTime, int durationSeconds, BigDecimal tariffRate) {
        CallID = callID;
        SubscriberNumber = subscriberNumber;
        CalledNumber = calledNumber;
        CallDateTime = callDateTime;
        DurationSeconds = durationSeconds;
        TariffRate = tariffRate;
    }

    public int getCallID() {
        return CallID;
    }

    public void setCallID(int callID) {
        CallID = callID;
    }

    public String getSubscriberNumber() {
        return SubscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        SubscriberNumber = subscriberNumber;
    }

    public String getCalledNumber() {
        return CalledNumber;
    }

    public void setCalledNumber(String calledNumber) {
        CalledNumber = calledNumber;
    }

    public LocalDateTime getCallDateTime() {
        return CallDateTime;
    }

    public void setCallDateTime(LocalDateTime callDateTime) {
        CallDateTime = callDateTime;
    }

    public int getDurationSeconds() {
        return DurationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        DurationSeconds = durationSeconds;
    }

    public BigDecimal getTariffRate() {
        return TariffRate;
    }

    public void setTariffRate(BigDecimal tariffRate) {
        TariffRate = tariffRate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Call{" +
                "CallID=" + CallID +
                ", SubscriberNumber='" + SubscriberNumber + '\'' +
                ", CalledNumber='" + CalledNumber + '\'' +
                ", CallDateTime=" + CallDateTime.format(formatter) +
                ", DurationSeconds=" + DurationSeconds +
                ", TariffRate=" + TariffRate +
                '}';
    }
}

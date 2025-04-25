package com.example.lab3.repository;

import com.example.lab3.model.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Repository
public class CallDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Call> getAllCalls() {
        return jdbcTemplate.query("SELECT CallID, SubscriberNumber, CalledNumber, CallDateTime, DurationSeconds, TariffRate FROM Calls", new BeanPropertyRowMapper<>(Call.class));
    }

    public void writeCallsToFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("CallID,SubscriberNumber,CalledNumber,CallDateTime,DurationSeconds,TariffRate\n");
            for (Call call : getAllCalls()) {
                writer.write(call.getCallID() + "," +
                        call.getSubscriberNumber() + "," +
                        call.getCalledNumber() + "," +
                        call.getCallDateTime() + "," +
                        call.getDurationSeconds() + "," +
                        call.getTariffRate() + "\n");
            }
        }
    }

    public int addCall(Call call) {
        return jdbcTemplate.update("INSERT INTO Calls (SubscriberNumber, CalledNumber, CallDateTime, DurationSeconds, TariffRate) VALUES (?, ?, ?, ?, ?)",
                call.getSubscriberNumber(), call.getCalledNumber(), call.getCallDateTime(), call.getDurationSeconds(), call.getTariffRate());
    }

    public int updateCall(Call call) {
        return jdbcTemplate.update("UPDATE Calls SET SubscriberNumber = ?, CalledNumber = ?, CallDateTime = ?, DurationSeconds = ?, TariffRate = ? WHERE CallID = ?",
                call.getSubscriberNumber(), call.getCalledNumber(), call.getCallDateTime(), call.getDurationSeconds(), call.getTariffRate(), call.getCallID());
    }

    public int deleteCall(int id) {
        return jdbcTemplate.update("DELETE FROM Calls WHERE CallID = ?", id);
    }

    public Call findCallById(int id) {
        return jdbcTemplate.queryForObject("SELECT CallID, SubscriberNumber, CalledNumber, CallDateTime, DurationSeconds, TariffRate FROM Calls WHERE CallID = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Call.class));
    }

    public List<Call> findCallsBySubscriberNumber(String subscriberNumber) {
        return jdbcTemplate.query("SELECT CallID, SubscriberNumber, CalledNumber, CallDateTime, DurationSeconds, TariffRate FROM Calls WHERE SubscriberNumber = ?", new Object[]{subscriberNumber}, new BeanPropertyRowMapper<>(Call.class));
    }
}
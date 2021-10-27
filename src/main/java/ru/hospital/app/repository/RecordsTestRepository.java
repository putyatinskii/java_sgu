package ru.hospital.app.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class RecordsTestRepository {
    @Getter
    private List<Record> recordList = new ArrayList<>();

    public void add(Record record) {
        recordList.add(record);
    }

    public List<Record> getRecordsByPredicate(Predicate<Record> predicate) {
        return recordList.stream().filter(predicate).collect(Collectors.toList());
    }
}

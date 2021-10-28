package ru.hospital.app;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.DigestUtils;
import ru.hospital.app.model.Record;
import ru.hospital.app.model.*;
import ru.hospital.app.service.DoctorService;
import ru.hospital.app.service.UserService;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



public class HospitalApplication {
//    public static void main(String[] args) throws Exception {
//        ApplicationContext context = new AnnotationConfigApplicationContext(HospitalApplication.class);
//        setData(context);
//    }

//    public static void setData(ApplicationContext context) throws Exception {
//        Doctor doctor = new Doctor(
//                UUID.randomUUID(),
//                "doc123",
//                DigestUtils.md5DigestAsHex("qwerty".getBytes(StandardCharsets.UTF_8)),
//                "Иванов Иван Иванович",
//                "88005553535",
//                "doc@gmail.com",
//                Date.valueOf("1970-12-12"),
//                Speciality.ORTHOPEDIST,
//                "Стаж 10 лет");
//        Doctor doctor1 = new Doctor(
//                UUID.randomUUID(),
//                "doc1234",
//                DigestUtils.md5DigestAsHex("qwerty2".getBytes(StandardCharsets.UTF_8)),
//                "Петров Петр Петрович",
//                "88005553539",
//                "doc123@gmail.com",
//                Date.valueOf("1983-04-12"),
//                Speciality.ALLERGIST,
//                "Стаж 8 лет");
//        User user1 = new User(UUID.randomUUID(),
//                "user123",
//                DigestUtils.md5DigestAsHex("qwerty12".getBytes(StandardCharsets.UTF_8)),
//                "Иванов Петр Петрович",
//                "87775553535",
//                "iv123@gmail.com",
//                Date.valueOf("1990-01-05"));
//        User user2 = new User(UUID.randomUUID(),
//                "user123",
//                DigestUtils.md5DigestAsHex("qwerty12".getBytes(StandardCharsets.UTF_8)),
//                "Петрова Ольга Ивановна",
//                "87775553345",
//                "olg123@gmail.com",
//                Date.valueOf("1995-05-05"));
////        Record record = new Record(UUID.randomUUID(), user1, doctor, LocalDateTime.parse("2021-10-30T12:00"));
////        Appointment appointment = new Appointment(record, "", false, false, false);
//
//        UserService userService = context.getBean("testUserService", UserService.class);
//        userService.addUser(user1);
//        userService.addUser(user2);
//
//
//        DoctorService doctorService = context.getBean("testDoctorService", DoctorService.class);
//        doctorService.addDoctor(doctor);
//        doctorService.addDoctor(doctor1);
//        doctorService.createRecords(doctor.getId(), LocalDateTime.parse("2021-10-27T12:00"));
//        doctorService.createRecords(doctor.getId(), LocalDateTime.parse("2021-10-28T12:00"));
//
//        System.out.println(userService.checkFreeTime(doctor.getName(), null, 4));
//        List<Record> records = userService.checkFreeTime(doctor.getName(), null, 4);
//        userService.checkUser(user1.getLogin(), user1.getPassword());
//
//        userService.createRecord(records.get(0), user1.getId());
//        System.out.println(userService.checkFreeTime(doctor.getName(), null, 4));
//
//        System.out.println(doctorService.getTodayRecords(doctor.getId()));
//        Record record = new Record();
//        record = records.get(0);
//        //record.setId(UUID.randomUUID());
//        doctorService.updateAppointment(new Appointment(record, "sad", false, true, true));
//    }
}
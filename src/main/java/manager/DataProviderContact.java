package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder()
                .name("Henry")
                .lastname("Fux")
                .phone("666")
                .email("hf"+"@mail.com")
                .address("Kentuki")
                .description("Work")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Norman")
                .lastname("Dexy")
                .phone("35657589393944575756866")
                .email("nd"+"@mail.com")
                .address("Maryland")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Barry")
                .lastname("Gut")
                .phone("356575893ww")
                .email("bg"+"@mail.com")
                .address("Maryland")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Mirra")
                .lastname("Novack")
                .phone("")
                .email("mn"+"@mail.com")
                .address("Maryland")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastname("Potter")
                .phone("6667778834")
                .email("hpr"+"@mail.com")
                .address("Hogsmid")
                .description("School")
                .build()});

        list.add(new Object[]{Contact.builder()
                .name("Harry")
                .lastname("Potter")
                .phone("6662338834")
                .email("hprs"+"@mail.com")
                .address("Hogsmid")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while(line != null){
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder().
                    name(all[0])
                    .lastname(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}

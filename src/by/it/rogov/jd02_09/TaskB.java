package by.it.rogov.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static final String XML = "src/by/it/rogov/jd02_09/Clients+xsd.xml";
    private static final String XMLOUT = "src/by/it/rogov/jd02_09/out.html";

    static Users users;

    static void readXml() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            users = (Users) unmarshaller.unmarshal(new File(XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static String getJson() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(users);
        return json;
    }

    static void readJson(String json) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .serializeNulls()
                .create();
        users = gson.fromJson(json, Users.class);
    }

    static void saveXml() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(XMLOUT));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readXml();
        String json = getJson();
        System.out.println(json);
        readJson(json);
        saveXml();
    }
}

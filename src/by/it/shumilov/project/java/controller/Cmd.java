package by.it.shumilov.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

abstract class Cmd {
    abstract  Action execute(HttpServletRequest req) throws Exception;
}

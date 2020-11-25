package ua.lviv.iot;


import ua.lviv.iot.passive.view.MyView;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        MyView view = new MyView();
        view.showMenu();
    }
}

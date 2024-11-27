package com.example.employeedb.services;

import java.util.List;

public interface AppService<T> {
    boolean add();
    List<T> list();

    boolean print();
}

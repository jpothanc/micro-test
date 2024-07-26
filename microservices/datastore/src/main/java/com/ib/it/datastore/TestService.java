package com.ib.it.datastore;

import com.ib.it.lib.TestUtils;

public class TestService {
    public static String run() {
        TestUtils.getGreeting();
        System.out.println("TestService run method");
        return "TestService run method";
    }
}

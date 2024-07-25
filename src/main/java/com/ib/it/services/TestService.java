package com.ib.it.services;

import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    public TestService() {
        System.out.println("TestService constructor");
    }
    public String runTests(String packageName) {
        // Create a list of selectors for the tests to be executed
        List<DiscoverySelector> selectors = new ArrayList<>();
        selectors.add(DiscoverySelectors.selectPackage(packageName));

        // Create a LauncherDiscoveryRequest
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectors)
                .build();

        // Get the Launcher
        Launcher launcher = LauncherFactory.create();

        // Register a listener to receive test execution events
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        // Execute the tests
        launcher.execute(request);

        // Get the test execution summary
        TestExecutionSummary summary = listener.getSummary();
        StringWriter writer = new StringWriter();
        summary.printTo(new PrintWriter(writer));

        return writer.toString();
    }
}

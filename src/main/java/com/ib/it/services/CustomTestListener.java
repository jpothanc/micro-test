package com.ib.it.services;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import java.util.ArrayList;
import java.util.List;

public class CustomTestListener implements TestExecutionListener {
    private List<String> testNames = new ArrayList<>();

    private boolean hasFailures = false;

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        TestExecutionListener.super.executionFinished(testIdentifier, testExecutionResult);
        if (testExecutionResult.getStatus() == TestExecutionResult.Status.FAILED) {
            hasFailures = true;
        }
    }

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        System.out.println("Test execution started.");
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        if (testIdentifier.isTest()) {  // Ensures it's an actual test case, not a container
            testNames.add(testIdentifier.getDisplayName());
        }
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        System.out.println("Test execution finished.");
        System.out.println("Executed tests:");
        testNames.forEach(System.out::println);

        TestExecutionListener.super.testPlanExecutionFinished(testPlan);
        if (hasFailures) {
            System.out.println("Test plan execution finished with failures.");
        } else {
            System.out.println("Test plan execution finished successfully.");
        }


    }



    public List<String> getTestNames() {
        return testNames;
    }
}

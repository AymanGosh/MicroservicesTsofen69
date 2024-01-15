package com.runner;

import com.exception.CompanyException;
import com.facade.CompanyFacade;
import com.model.Company;

public class Runner {

    public static void main(String[] args) {
        try {
            CompanyFacade companyFacade = new CompanyFacade();

            // Example: Multithreading to add companies concurrently
            Thread addCompanyThread1 = new Thread(() -> {
                try {
                    companyFacade.addCompany(new Company("Company1", "email1@example.com", "password1"));
                } catch (CompanyException e) {
                    e.printStackTrace();
                }
            });

            Thread addCompanyThread2 = new Thread(() -> {
                try {
                    companyFacade.addCompany(new Company("Company2", "email2@example.com", "password2"));
                } catch (CompanyException e) {
                    e.printStackTrace();
                }
            });

            addCompanyThread1.start();
            addCompanyThread2.start();

            // Wait for the threads to finish
            try {
                addCompanyThread1.join();
                addCompanyThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Example: Executing tasks with a connection concurrently
            Thread executeTaskThread1 = new Thread(() -> {
                try {
                    companyFacade.executeWithConnection(connection -> {
                        // Perform database operations using the provided connection
                        // ...
                    });
                } catch (CompanyException e) {
                    e.printStackTrace();
                }
            });

            Thread executeTaskThread2 = new Thread(() -> {
                try {
                    companyFacade.executeWithConnection(connection -> {
                        // Perform different database operations using the provided connection
                        // ...
                    });
                } catch (CompanyException e) {
                    e.printStackTrace();
                }
            });

            executeTaskThread1.start();
            executeTaskThread2.start();

            // Wait for the threads to finish
            try {
                executeTaskThread1.join();
                executeTaskThread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (CompanyException e) {
            e.printStackTrace();
        }
    }
}

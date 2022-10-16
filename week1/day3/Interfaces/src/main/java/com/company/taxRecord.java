package com.company;

import com.company.interfaces.Auditable;

public class taxRecord implements Auditable {

    public void runAudit() {
        System.out.println("auditing");
    }

    @Override
    public void sendAuditToState() {
        System.out.println("audition completed");
    }
}

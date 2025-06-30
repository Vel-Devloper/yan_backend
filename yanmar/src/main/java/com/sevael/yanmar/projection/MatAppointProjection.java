package com.sevael.yanmar.projection;

import java.time.LocalDate;

public interface MatAppointProjection {
    Long getRequest_id();
    String getSupplier_name();
    String getPurpose();
    LocalDate getExpec_delivery_date();
    String getDriver_name();
    String getItem_name();
    int getApproval_status();
}

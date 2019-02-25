package com.tekion.approval.Models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(schema = "MYSCHEMA")
public
class ApprovalTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalId;
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "approvalTable" )
    private List<ApprovalTaskTable> approvalTaskTables;
    @Column(name = "ApprovalType")
    private String approvalType;
    @Column(name="finalStatus")
    private String finalStatus;



    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }

    public List<ApprovalTaskTable> getApprovalTaskTables() {
        return approvalTaskTables;
    }

    public void setApprovalTaskTables(List<ApprovalTaskTable> approvalTaskTables) {
        this.approvalTaskTables = approvalTaskTables;
    }
}
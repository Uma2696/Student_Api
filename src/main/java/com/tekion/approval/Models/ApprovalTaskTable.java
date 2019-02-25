package com.tekion.approval.Models;

import javax.persistence.*;


//@Entity
//@Table(name = "student")

@Entity
public
class ApprovalTaskTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalTaskId;
    @Column(name = "SenderId")
    private String senderId;
    @Column(name = "AssetId")
    private String assetId;
    @Column(name = "AssetType")
    private String assetType;
    @Column(name = "approver")
    private String approver;
    @Column(name = "next")
    private Long next;
    @Column(name = "approval_id")
    private Long approvalId;
//    @ManyToOne(targetEntity = ApprovalTable.class, cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "approval_id")
//    private ApprovalTable approvalTable;
//    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//    @JoinColumn(name = "approvalTaskId")
//    private List<ApprovalTable> approvalTables;


    public Long getApprovalTaskId() {
        return approvalTaskId;
    }

    public void setApprovalTaskId(Long approvalTaskId) {
        this.approvalTaskId = approvalTaskId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Long getNext() {
        return next;
    }

    public void setNext(Long next) {
        this.next = next;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
}
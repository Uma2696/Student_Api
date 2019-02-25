package com.tekion.approval.dto;

import com.tekion.approval.Models.ApprovalTable;
import com.tekion.approval.Models.ApprovalTaskTable;

public class ApprovalRequest {

    private String senderId;

    private String assetId;

    private String assetType;

    private String approvalType;

    private  String approvar;

    private Long next;

    private String finalStatus;

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


    public String getApprovar() {
        return approvar;
    }

    public void setApprovar(String approvar) {
        this.approvar = approvar;
    }

    public Long getNext() {
        return next;
    }

    public void setNext(Long next) {
        this.next = next;
    }

    public ApprovalTable createApprovalTable(String finalStatus){
        ApprovalTable approvalTable=new ApprovalTable();
      //  approvalTable.setApprovalId(UUID.randomUUID().toString());
        approvalTable.setApprovalType(getApprovalType());
        approvalTable.setFinalStatus(finalStatus);
        return approvalTable;
    }


    public ApprovalTaskTable createApprovalTaskTable(String approvar, Long next, ApprovalTable result) {
        ApprovalTaskTable approvalTaskTable=new ApprovalTaskTable();
       // approvalTaskTable.setApprovalTaskId(UUID.randomUUID().toString());
        approvalTaskTable.setApprovalId(result.getApprovalId());
        approvalTaskTable.setAssetId(getAssetId());
        approvalTaskTable.setAssetType(getAssetType());
        approvalTaskTable.setSenderId(getSenderId());
        approvalTaskTable.setApprover(approvar);
        approvalTaskTable.setNext(next);
        return approvalTaskTable;
    }
}

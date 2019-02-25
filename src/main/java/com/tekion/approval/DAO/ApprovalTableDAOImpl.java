package com.tekion.approval.DAO;

import com.tekion.approval.Models.ApprovalTable;
import com.tekion.approval.Models.ApprovalTaskTable;
import com.tekion.approval.dto.ApprovalRequest;
import com.tekion.approval.repo.ApprovalTableRepo;
import com.tekion.approval.repo.ApprovalTaskTableRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public
class ApprovalTableDAOImpl implements ApprovalTableDAO {
    final static Logger logger = LoggerFactory.getLogger(ApprovalTableDAOImpl.class);
    @Autowired
    ApprovalTableRepo approvalTableRepo;
    @Autowired
    ApprovalTaskTableRepo approvalTaskTableRepo;


    @Override
    public ApprovalTaskTable findById(Long id) {

        Optional<ApprovalTaskTable> optional = approvalTaskTableRepo.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<ApprovalTable> findAll() {
        return (List<ApprovalTable>) approvalTableRepo.findAll();
    }

    @Override
    public ApprovalTable create(ApprovalRequest approvalRequest) {

        ArrayList<ApprovalTable> existRecords = (ArrayList<ApprovalTable>) approvalTableRepo.findAll();
        String status;
        String finalStatus = "";
        String approver = "Associate";
        Long next = null;
        String id = null;
        if (existRecords.size() != 0) {
            for (ApprovalTable fetch : existRecords) {
                status = fetch.getFinalStatus();
                if (!status.equals("PENDING")) {
                    if (!status.equals("OPEN")) {
                        finalStatus = "PENDING";
                    } else {
                        finalStatus = "OPEN";
                        break;
                    }
                } else {
                    finalStatus = "OPEN";
                    break;

                }
            }
        } else {
            finalStatus = "PENDING";
        }


        ApprovalTable approvalTable = approvalRequest.createApprovalTable(finalStatus);
        ApprovalTable result = approvalTableRepo.save(approvalTable);

        if (approvalRequest.getApprovalType().equalsIgnoreCase("chain")) {
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    approver = "Associate";
                } else if (i == 2) {
                    approver = "Principal Engineer";
                } else {
                    approver = "Manager";
                }
                ApprovalTaskTable approvalTaskTable =
                        approvalRequest.createApprovalTaskTable(approver, next, result);
                next = approvalTaskTable.getApprovalTaskId();
                List<ApprovalTaskTable> approvalTaskTableList = new ArrayList<>();
                approvalTaskTableList.add(approvalTaskTable);
//                approvalTable.setApprovalTaskTables(approvalTaskTableList);
                approvalTaskTableRepo.save(approvalTaskTable);

            }
        } else {
            ApprovalTaskTable approvalTaskTable = approvalRequest.createApprovalTaskTable(approver, next, result);
            List<ApprovalTaskTable> approvalTaskTableList = new ArrayList<ApprovalTaskTable>();
            approvalTaskTableList.add(approvalTaskTable);
//            approvalTable.setApprovalTaskTables(approvalTaskTableList);
            approvalTaskTableRepo.save(approvalTaskTable);
        }

        // ApprovalTable result = approvalTableRepo.save(approvalTable);

        if (result == null) {
            throw new AssertionError("Table not found");
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        approvalTaskTableRepo.deleteById(id);
    }


}


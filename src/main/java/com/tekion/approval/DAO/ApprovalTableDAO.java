package com.tekion.approval.DAO;

import com.tekion.approval.Models.ApprovalTable;
import com.tekion.approval.Models.ApprovalTaskTable;
import com.tekion.approval.dto.ApprovalRequest;

public interface ApprovalTableDAO {


    ApprovalTaskTable findById (Long id );

    Object findAll ();

    ApprovalTable create (ApprovalRequest approvalRequest );


    void delete ( Long id );


}

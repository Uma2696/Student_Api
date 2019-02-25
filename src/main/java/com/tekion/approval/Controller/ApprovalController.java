package com.tekion.approval.Controller;

import com.tekion.approval.DAO.ApprovalTableDAO;
import com.tekion.approval.Models.ApprovalTable;
import com.tekion.approval.Models.ApprovalTaskTable;
import com.tekion.approval.dto.ApprovalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public
class ApprovalController {

    @Autowired
    private ApprovalTableDAO approvalTableDAO;

    @GetMapping("/approvalTaskTable")
    @ResponseBody
    public
    List <ApprovalTaskTable> getClasses () {
        return (List <ApprovalTaskTable>) approvalTableDAO.findAll( );
    }

    @GetMapping("/approvalTaskTable/{id}")
    @ResponseBody
    public
    ApprovalTaskTable getApprovalTableById ( @PathVariable Long id ) {
        return approvalTableDAO.findById(id);
    }

    @PostMapping("/save")
    public ApprovalTable createApprovalTable ( @RequestBody ApprovalRequest approvalRequest ) {
        return approvalTableDAO.create(approvalRequest);


    }

    @PutMapping("/approvalTaskTable/{id}")
    public
    void modifyApprovalTableById (@PathParam("senderId") String senderId, ApprovalRequest approvalRequest) {
        approvalRequest.setSenderId(senderId);
        approvalTableDAO.create(approvalRequest);
    }


    @DeleteMapping("/{id}")
    public
    void deleteApprovalTable( @PathVariable("id") Long id ) {
        approvalTableDAO.delete(id);
    }





}


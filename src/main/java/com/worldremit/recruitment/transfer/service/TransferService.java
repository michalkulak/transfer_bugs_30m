package com.worldremit.recruitment.transfer.service;

import com.worldremit.recruitment.transfer.domain.Transfer;
import org.apache.log4j.Logger;

public class TransferService {
    private final Logger logger = Logger.getLogger(TransferService.class);

    public void makeTransfer(final Transfer transfer) {
        validateOrThrow(transfer);
        if (transfer.getSourceAccount().getBalance() < transfer.getAmount()) {
            logger.error("The transfer cannot be performed due to insufficient funds on the source account");
        } else {
            transfer.getSourceAccount().withdraw(transfer.getAmount());
            transfer.getTargetAccount().deposit(transfer.getAmount());
        }
    }

    private void validateOrThrow(final Transfer transfer) {
        if (transfer == null) {
            throw new Error("Transfer cannot be null!");
        } else if (transfer.getAmount() == null) {
            throw new Error("Transfer must have amount specified");
        } else if (transfer.getCreated() == null) {
            throw new Error("Transfer cannot be null!");
        } else if (transfer.getSourceAccount() == null) {
            throw new Error("Transfer cannot be null!");
        } else if (transfer.getTargetAccount() == null) {
            throw new Error("Transfer cannot be null!");
        }
    }
}

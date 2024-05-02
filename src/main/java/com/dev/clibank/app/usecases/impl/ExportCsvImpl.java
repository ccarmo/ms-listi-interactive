package com.dev.clibank.app.usecases.impl;

import com.dev.clibank.app.rest.records.TransactionRecord;
import com.dev.clibank.app.usecases.ExportCsv;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;

import java.util.List;
import java.util.Optional;

@Service
public class ExportCsvImpl implements ExportCsv {

    private static final String CSV_HEADER = "Conta,Tipo,Valor\n";
    @Override
    public Optional<ByteArrayOutputStream> generateCsv(List<TransactionRecord> transactionList) {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);

        for (TransactionRecord transaction : transactionList) {
            csvContent.append(transaction.accountNumber()).append(",")
                    .append(transaction.typeTransaction()).append(",")
                    .append(transaction.valueTransaction())
                    .append("\n");

        }

        return saveFileJson(csvContent.toString());
    }

    protected Optional<ByteArrayOutputStream> saveFileJson(String contentCsv) {

        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(baos);
            osw.write(contentCsv);
            osw.flush();
            return Optional.of(baos);
        } catch (IOException e) {
            System.out.println("Error saved file" + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}

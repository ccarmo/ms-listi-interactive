package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.app.usecases.impl.*;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Payment;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.infra.file.AccountFileRepository;
import com.dev.clibank.infra.file.StatementFileRepository;
import com.dev.clibank.infra.file.UserFileRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Integer op = 1;
    private static final boolean flag = true;

    AccountService accountService = new AccountService(new GetAccountImpl(new AccountFileRepository()));
    UserService userService = new UserService(new GetUserImpl(new UserFileRepository()));

    public void printMenu() {
        String accountNumber = "07105";
        Account account = accountService.getAccount(accountNumber).get();
        User user = userService.getUserService(account.getIdUser()).get();


        Scanner leia = new Scanner(System.in);
        do {

            System.out.println("                                                                                        \n-----------------------------------------");
            System.out.println("                                                                                        |             BEM VINDO   " + user.getName() + "  |");
            System.out.println("                                                                                        |             BANCO SIMPLIFICADO         |");
            System.out.println("                                                                                        -----------------------------------------");
            System.out.println("                                                                                        | Opções:                               |");
            System.out.println("                                                                                        |    1. Consulta Saldo                  |");
            System.out.println("                                                                                        |    2. Extrato                         |");
            System.out.println("                                                                                        |    3. Pix                             |");
            System.out.println("                                                                                        |    4. Pagamentos                      |");
            System.out.println("                                                                                        |    5. Cartoẽs                         |");
            System.out.println("                                                                                        |    99. Sair                           |");
            System.out.println("                                                                                         -----------------------------------------");
            System.out.print("Opção: ");
            op = leia.nextInt();

            switch (op) {
                case 1:
                    AccountService accountService = new AccountService(new GetAccountImpl(new AccountFileRepository()));
                    BigDecimal balance = accountService.getAccount(accountNumber).get().getBalance();
                    System.out.println("Saldo total: " + balance);

                    break;
                case 2:
                    StatementService statementService = new StatementService(new GetStatementImpl(new StatementFileRepository()));
                    List<Statement> statementList = statementService.getListStatement(account);
                    System.out.println("\tExtrato: \n");
                    statementList.stream().forEach(statement -> {
                        System.out.println("\tValor: R$" + statement.getPayment().getValue() + "      | \tData: " + statement.getPayment().getDatePayment() + "\n");
                    });
                    break;

                case 3:
                    System.out.println("Pix");
                    break;
                case 4:
                    PaymentService paymentService = new PaymentService(new SendPaymentImpl(new StatementFileRepository()));
                    Payment payment = new Payment(BigDecimal.valueOf(1),accountNumber,"PIX", LocalDateTime.now());
                    paymentService.sendPayment(payment);
                    break;
                default:
                    System.out.println(" ");

            }

        } while (op != 99);
        System.out.println("Você encerrou o app, volte sempre! ");
    }



}
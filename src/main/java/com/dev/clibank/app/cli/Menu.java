package com.dev.clibank.app.cli;

import com.dev.clibank.app.services.AccountService;
import com.dev.clibank.app.services.StatementService;
import com.dev.clibank.app.services.TransactionService;
import com.dev.clibank.app.services.UserService;
import com.dev.clibank.app.usecases.impl.*;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.Transaction;
import com.dev.clibank.domain.entities.Statement;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.infra.file.AccountFileRepository;
import com.dev.clibank.infra.file.StatementFileRepository;
import com.dev.clibank.infra.file.UserFileRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class Menu {

    private static Integer op = 1;
    private static final boolean flag = true;

    AccountService accountService = new AccountService(new GetAccountImpl(new AccountFileRepository()));
    UserService userService = new UserService(new GetUserImpl(new UserFileRepository()));


    public void printMenu() {
        String[] campos = {"Conta", "Senha"};
        Scanner scanner = new Scanner(System.in);



        System.out.println("\n");
        System.out.println("\n");
        System.out.print("                                           \tConta: ");
        String value = scanner.nextLine();
        String accountNumber = value;
        Account account = accountService.getAccount(accountNumber).get();
        User user = userService.getUserService(account.getIdUser()).get();



        do {

            mainMenu(user);
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    AccountService accountService = new AccountService(new GetAccountImpl(new AccountFileRepository()));
                    BigDecimal balance = accountService.getAccount(accountNumber).get().getBalance();
                    System.out.println("Saldo total: " + balance);
                    printSpaceLines();
                    break;
                case 2:
                    StatementService statementService = new StatementService(new GetStatementImpl(new StatementFileRepository()));
                    List<Statement> statementList = statementService.getListStatement(account);
                    System.out.println("\tExtrato: \n");
                    statementList.stream().forEach(statement -> {
                        System.out.println("\tValor: R$" + statement.getPayment().getValue() + "      | \tData: " + statement.getPayment().getDateTransaction()+ "\n");
                    });
                    printSpaceLines();
                    break;

                case 3:
                    System.out.println("Pix");
                    break;
                case 4:
                    System.out.print("\tValor: ");
                    BigDecimal valueTransaction = scanner.nextBigDecimal();
                    System.out.print("\tTipo: ");
                    scanner.nextLine();
                    String type = scanner.nextLine();
                    printTransaction(accountNumber, valueTransaction, type);
                    System.out.print("\tPagamento realizado");
                    printSpaceLines();
                    break;
                default:
                    printSpaceLines();

            }

        } while (op != 99);
        System.out.println("Você encerrou o app, volte sempre! ");
    }

    void printSpaceLines() {
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
    }

    void mainMenu(User user) {
        String bemVindo = "BEM VINDO      " + user.getName();
        String banco = "CLIBANK";
        String[] opcoes = {
                "1. Consulta Saldo",
                "2. Extrato",
                "3. Pix",
                "4. Pagamentos",
                "5. Cartões",
                "99. Sair"
        };


        int largura = bemVindo.length() + 2;
        for (String opcao : opcoes) {
            if (opcao.length() + 6 > largura) {
                largura = opcao.length() + 6;
            }
        }

        // Imprimir a interface
        System.out.println("+" + " -".repeat(largura / 2) + " +");
        System.out.println("|" + " ".repeat((largura - bemVindo.length()) / 2) + bemVindo + " ".repeat((largura - bemVindo.length()) / 2) + "|");
        System.out.println("|" + " ".repeat((largura - banco.length()) / 2) + banco + " ".repeat((largura - banco.length()) / 2) + "|");
        System.out.println("+" + " -".repeat(largura / 2) + " +");

        for (String opcao : opcoes) {
            System.out.println("|" + " ".repeat(2) + opcao + " ".repeat(largura - opcao.length() - 2) + "|");
        }

        System.out.println("+" + " -".repeat(largura / 2) + " +");




        System.out.print("Opção: ");
    }

     private void printTransaction(String accountNumber, BigDecimal value, String type) {

        TransactionService transactionService = new TransactionService(new StartTransactionImpl(new StatementFileRepository()));

        Transaction transaction =   new Transaction.Builder()
                                        .value(value)
                                        .typeTransaction(type)
                                        .idAccount(accountNumber)
                                        .create();

        transactionService.createTransaction(transaction);

    }





}
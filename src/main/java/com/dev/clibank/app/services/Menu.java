package com.dev.clibank.app.services;

import com.dev.clibank.app.usecases.GetBalance;
import com.dev.clibank.app.usecases.impl.GetAccountImpl;
import com.dev.clibank.app.usecases.impl.GetBalanceImpl;
import com.dev.clibank.app.usecases.impl.GetUserImpl;
import com.dev.clibank.domain.entities.Account;
import com.dev.clibank.domain.entities.User;
import com.dev.clibank.infra.file.AccountFileRepository;
import com.dev.clibank.infra.file.UserFileRepository;

import java.math.BigDecimal;
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

                    BigDecimal balance = account.getBalance();
                    System.out.println("Saldo total: " + balance);

                    break;

                default:
                    System.out.println(" ");

            }

        } while (op != 99);
        System.out.println("Você encerrou o app, volte sempre! ");
    }



}
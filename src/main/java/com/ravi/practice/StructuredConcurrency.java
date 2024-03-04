package com.ravi.practice;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Stream;

/**preview feature, may change in the future.
 * better for long-running tasks.
 * Uses virtual thread.
 */
public class StructuredConcurrency {
    public static void main(String[] args) {
        StructuredConcurrency structuredConcurrency = new StructuredConcurrency();
        List<Transaction> transactionList = structuredConcurrency.getCreditAndDebitTransactionViaStructuredTaskScope();
        transactionList.forEach(System.out::println);

    }

    public List<Transaction> getCreditAndDebitTransactionViaStructuredTaskScope(){
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<List<Transaction>> creditTransactionFuture = scope.fork(new CreditTransaction());
            StructuredTaskScope.Subtask<List<Transaction>> debitTransactionFuture = scope.fork(new DebitTransaction());
            scope.join();
            List<Transaction> creditTxnList = creditTransactionFuture.get();
            List<Transaction> debitTxnList = debitTransactionFuture.get();
            return Stream.concat(creditTxnList.stream(), debitTxnList.stream()).toList();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    class CreditTransaction implements Callable<List<Transaction>> {
        @Override
        public List<Transaction> call() {
            return List.of(
                    new Transaction("credit", 100.0, LocalDateTime.now()),
                    new Transaction("credit", 130.0, LocalDateTime.now()),
                    new Transaction("credit", 140.0, LocalDateTime.now())

            );
        }
    }

    class DebitTransaction implements Callable<List<Transaction>> {
        @Override
        public List<Transaction> call() {
            return List.of(
                    new Transaction("Debit", 1000.0, LocalDateTime.now()),
                    new Transaction("Debit", 1300.0, LocalDateTime.now()),
                    new Transaction("Debit", 1400.0, LocalDateTime.now())

            );
        }
    }
    @AllArgsConstructor
    @ToString
    class Transaction{
        private String transactionType;
        private Double amount;
        private LocalDateTime localDateTime;
    }
}

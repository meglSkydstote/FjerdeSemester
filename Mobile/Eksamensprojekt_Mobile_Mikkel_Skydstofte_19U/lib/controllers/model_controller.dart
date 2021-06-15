import 'package:flutter/material.dart';

import '../database_service.dart';
import '../models/account.dart';
import '../models/transactions.dart';

class ModelController extends ChangeNotifier {
  //////////// Properties
  List<Account> _accounts = [];
  final DatabaseService _dbService = DatabaseService();

  /////////// Constructor
  ModelController() {
    _dbService.accountStream().listen((snapshot) {
      _accounts.clear();
      snapshot.docs.forEach((acc) {
        Account _account = Account.fromFirestore(acc);
        _accounts.add(_account);
        _dbService.transactionStream(_account.id).listen((snapshot) {
          snapshot.docs.forEach((tx) {
            TransactionModel _tx = TransactionModel.fromFirestore(tx);
            _account.addTransactionModel(_tx);
          });
          notifyListeners();
        });
      });
    });
  }

  //////////// Getters
  int get numberOfAccounts {
    return _accounts.length;
  }

  Account getAccount(int index) {
    return _accounts[index];
  }

  List<TransactionModel> getTransactions(Account account) {
    List<TransactionModel> _transactions = [];
    _dbService.transactionStream(account.id).listen((snapshot) {
      snapshot.docs.forEach((tx) {
        TransactionModel _tx = TransactionModel.fromFirestore(tx);
        _transactions.add(_tx);
      });
      notifyListeners();
      return _transactions;
    });
    return null;
  }

  ////////////////// Add to DB
  add({Account account}) async {
    _accounts.add(account);
    await _dbService.add(account: account);
    notifyListeners();
  }

  addTransaction({Account account, TransactionModel tx}) async {
    if (account.transactions == null) return;
    await _dbService.addTransaction(accId: account.id, tx: tx);
    notifyListeners();
  }
}

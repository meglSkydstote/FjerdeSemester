import 'dart:math';

import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:intl/intl.dart';

import './kind.dart';
import './transactions.dart';

class Account {
  ///////// Properties
  String id;
  String name;
  String iban;
  Kind kind;
  List<TransactionModel> transactions;

  ///////// Constructors
  Account({
    this.id,
    this.name,
    this.iban,
    this.kind,
    this.transactions,
  });

  factory Account.fromFirestore(DocumentSnapshot doc) {
    Map<String, dynamic> data = doc.data();
    Account _account = Account();
    _account.id = doc.id;
    _account.name = data['name'];
    _account.iban = data['iban'];
    _account.kind = Kind(type: data['kind']);
    _account.transactions = [];
    return _account;
  }

  ///////// Getters
  String getName() {
    return this.name;
  }

  List<TransactionModel> getTransactions() {
    return this.transactions;
  }

  ///////// computed property saldo
  String get saldo {
    final formatter = NumberFormat("##0.00#", "da_DK");
    if (transactions == null) return '0';
    if (transactions.isNotEmpty) {
      double amount = this
          .transactions
          .map((tx) => tx.amount)
          .reduce((value, tx) => value + tx);
      return formatter.format(amount);
    }
    return '0';
  }

  ///////// pseudo random iban generator
  setIBAN() {
    String startWith = "32";
    Random generator = new Random();
    int r = generator.nextInt(999999);
    this.iban = 'DK' + startWith + r.toString();
  }

  ///////// control new transaction + saldo > 0
  bool checkSaldo(double newTxAmount) {
    final formatter = NumberFormat("##0.00#", "en_UK");
    double currentHolding = 0;
    double value = double.parse(formatter.format(newTxAmount));
    List<String> formattingAmount = this.saldo.split(',');
    if (formattingAmount.length > 1) {
      currentHolding =
          double.parse((formattingAmount[0] + '.' + formattingAmount[1]));
      return currentHolding + value >= 0;
    } else {
      return currentHolding + value >= 0;
    }
  }

  ///////// Add transaction to account.transactions
  addTransactionModel(TransactionModel tx) {
    for (var i = 0; i < this.transactions.length; i++) {
      if (this.transactions[i].id == tx.id) return;
    }
    this.transactions.add(tx);
  }

  ///////// Mapping to store in db
  toMap() {
    return {
      'name': this.name,
      'iban': this.iban,
      'kind': this.kind.type,
    };
  }
}

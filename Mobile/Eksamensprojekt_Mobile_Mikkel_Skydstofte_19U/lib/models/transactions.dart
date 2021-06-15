import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:intl/intl.dart';

class TransactionModel {
  ///////// Properties
  String id;
  double amount;
  DateTime creationDate;
  String beneficiary;

  ///////// Constructors
  TransactionModel({
    this.id,
    this.amount,
    this.creationDate,
    this.beneficiary,
  });

  factory TransactionModel.fromFirestore(DocumentSnapshot doc) {
    Map<String, dynamic> data = doc.data();

    TransactionModel _transaction = TransactionModel();
    _transaction.id = doc.id;
    _transaction.amount = double.parse(data['amount'].toString());
    _transaction.creationDate =
        DateTime.parse(data['creationDate'].toDate().toString());
    _transaction.beneficiary = data['beneficiary'];

    return _transaction;
  }

  ///////// formatting amount to danish standard
  String formatAmount() {
    final formatter = NumberFormat("##0.00#", "da_DK");
    return formatter.format(this.amount);
  }

  ///////// Mapping to store in db
  toMap() {
    return {
      'amount': this.amount,
      'creationDate': this.creationDate,
      'beneficiary': this.beneficiary,
    };
  }
}

import 'package:cloud_firestore/cloud_firestore.dart';
import './models/transactions.dart';
import './models/account.dart';

class DatabaseService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

  Stream<QuerySnapshot> accountStream() {
    return _db.collection('accounts').snapshots();
  }

  Stream<QuerySnapshot> transactionStream(String accId) {
    try {
      return _db
          .collection('accounts')
          .doc(accId)
          .collection('transactions')
          .orderBy('creationDate', descending: true)
          .snapshots();
    } catch (e) {
      return null;
    }
  }

  add({Account account}) async {
    await _db.collection('accounts').add(account.toMap());
  }

  addTransaction({String accId, TransactionModel tx}) async {
    await _db.collection('accounts/$accId/transactions').add(tx.toMap());
  }
}

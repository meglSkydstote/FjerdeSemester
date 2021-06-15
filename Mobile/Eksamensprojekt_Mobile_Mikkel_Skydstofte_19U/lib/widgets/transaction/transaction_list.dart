import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import './transaction_item.dart';
import '../../controllers/model_controller.dart';
import '../../models/account.dart';

class TransactionList extends StatefulWidget {
  final Account account;

  TransactionList({Key key, this.account}) : super(key: key);

  @override
  _TransactionListState createState() => _TransactionListState(account);
}

class _TransactionListState extends State<TransactionList> {
  final Account _account;

  _TransactionListState(this._account);

  @override
  Widget build(BuildContext context) {
    return Consumer<ModelController>(
        builder: (context, _accountController, widgets) {
      return Scaffold(
        appBar: AppBar(
          title: Text('${_account.name}'),
        ),
        body: Container(
          child: ListView(
              children: _account.transactions.isEmpty ||
                      _account.transactions == null
                  ? <Widget>[
                      Container(
                        margin: EdgeInsets.only(
                            top: 50, left: 20, right: 20, bottom: 20),
                        alignment: Alignment.center,
                        child: Text(
                          'Ingen transaktioner!',
                          style: TextStyle(
                            fontSize: 20,
                            color: Colors.black,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ),
                      Container(
                        margin:
                            EdgeInsets.only(left: 20, right: 20, bottom: 20),
                        alignment: Alignment.center,
                        child: Text(
                          'Tryk på "+" for at oprette den første.',
                          style: TextStyle(
                            fontSize: 20,
                            color: Colors.black,
                          ),
                        ),
                      ),
                    ]
                  : _account.transactions.map((tx) {
                      return TransactionItem(transaction: tx);
                    }).toList()),
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.add),
          onPressed: () {
            Navigator.of(context)
                .pushNamed('/addTransaction', arguments: _account);
          },
        ),
      );
    });
  }
}

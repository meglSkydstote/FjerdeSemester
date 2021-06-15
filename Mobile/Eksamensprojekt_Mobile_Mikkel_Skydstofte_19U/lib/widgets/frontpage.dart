import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../models/account.dart';
import '../widgets/account/account_item.dart';
import '../controllers/model_controller.dart';

class Frontpage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Bank App - Mikkel Skydstofte 19U'),
      ),
      body: Column(
        mainAxisSize: MainAxisSize.min,
        children: <Widget>[
          Container(
            width: double.infinity,
            child: Card(
              child: Container(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Container(
                      margin: EdgeInsets.all(8),
                      padding: EdgeInsets.symmetric(vertical: 8, horizontal: 0),
                      child: Text(
                        'KONTI',
                        style: TextStyle(
                          fontSize: 35,
                          color: Colors.blueGrey[600],
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Container(
                      margin: EdgeInsets.all(8),
                      padding: EdgeInsets.symmetric(vertical: 8, horizontal: 0),
                      child: Text(
                        'SALDO',
                        style: TextStyle(
                          fontSize: 35,
                          color: Colors.blueGrey[600],
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
          Consumer<ModelController>(
              builder: (context, _accountController, widgets) {
            return Expanded(
              child: ListView.builder(
                  itemCount: _accountController.numberOfAccounts,
                  itemBuilder: (context, index) {
                    Account account = _accountController.getAccount(index);
                    return AccountItem(account: account);
                  }),
            );
          }),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.add),
        onPressed: () {
          Navigator.of(context).pushNamed('/addAccount');
        },
      ),
    );
  }
}

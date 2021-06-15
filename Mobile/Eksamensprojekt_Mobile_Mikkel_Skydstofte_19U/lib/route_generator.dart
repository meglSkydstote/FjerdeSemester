import 'package:firebaseconnection/widgets/frontpage.dart';
import 'package:flutter/material.dart';

import './widgets/account/add_account.dart';
import './models/account.dart';
import './widgets/transaction/transaction_list.dart';
import './widgets/transaction/add_transaction.dart';

class RouteGenerator {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    final args = settings.arguments;

    switch (settings.name) {
      case '/':
        return MaterialPageRoute(builder: (_) => Frontpage());
      case '/addAccount':
        return MaterialPageRoute(
          builder: (_) => AddAccount(),
        );
      case '/transactions':
        if (args is Account) {
          return MaterialPageRoute(
            builder: (_) => TransactionList(
              account: args,
            ),
          );
        }
        return _errorRoute();
      case '/addTransaction':
        if (args is Account) {
          return MaterialPageRoute(
            builder: (_) => AddTransaction(
              account: args,
            ),
          );
        }
        return _errorRoute();
      default:
        return _errorRoute();
    }
  }

  static Route<dynamic> _errorRoute() {
    return MaterialPageRoute(builder: (_) {
      return Scaffold(
        appBar: AppBar(
          title: Text('Error'),
        ),
        body: Center(
          child: Text('Der skete en fejl!'),
        ),
      );
    });
  }
}

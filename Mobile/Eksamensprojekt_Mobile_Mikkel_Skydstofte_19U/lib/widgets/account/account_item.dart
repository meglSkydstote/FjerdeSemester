import 'package:flutter/material.dart';

import '../../models/account.dart';

class AccountItem extends StatelessWidget {
  final Account account;
  const AccountItem({Key key, this.account}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        Navigator.of(context).pushNamed(
          '/transactions',
          arguments: account,
        );
      },
      child: Card(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: <Widget>[
            Container(
              padding: EdgeInsets.all(8),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Text(
                    account.name,
                    style: TextStyle(
                      fontSize: 18,
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  Text(
                    '${account.kind.type}',
                    style: TextStyle(
                      fontSize: 16,
                      color: Colors.blueGrey,
                    ),
                  ),
                  Text(
                    'IBAN: ${account.iban}',
                    style: TextStyle(
                      fontSize: 16,
                      color: Colors.blueGrey,
                    ),
                  ),
                ],
              ),
            ),
            Container(
              alignment: Alignment.centerRight,
              padding: EdgeInsets.all(10),
              width: MediaQuery.of(context).size.width * 0.4,
              margin: EdgeInsets.all(8),
              decoration: BoxDecoration(
                  // border: Border.all(
                  //   color: Colors.grey,
                  //   width: 2,
                  // ),
                  ),
              child: Text(
                'Kr. ${account.saldo}',
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 20,
                  color: Colors.grey[800],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

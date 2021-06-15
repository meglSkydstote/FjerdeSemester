import 'package:flutter/material.dart';
import '../../models/account.dart';

class NotAllowed extends StatelessWidget {
  final Account account;

  NotAllowed({this.account});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: MediaQuery.of(context).size.height * 0.6,
      child: Card(
        elevation: 50,
        color: Colors.transparent,
        child: Container(
          color: Colors.transparent,
          child: Container(
            padding: EdgeInsets.only(top: 10),
            decoration: BoxDecoration(
              color: Colors.white,
              border: Border.all(
                color: Colors.blueAccent,
                width: 1.0,
              ),
              borderRadius: BorderRadius.only(
                topLeft: Radius.circular(10),
                topRight: Radius.circular(10),
              ),
            ),
            child: Container(
              padding: EdgeInsets.symmetric(vertical: 20, horizontal: 50),
              child: ListView(
                children: <Widget>[
                  Container(
                    width: double.infinity,
                    alignment: Alignment.center,
                    child: Card(
                      margin: EdgeInsets.only(bottom: 25),
                      elevation: 0,
                      child: Text(
                        'OOPS!',
                        style: TextStyle(
                          fontSize: 20,
                          color: Colors.black,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                  ),
                  Container(
                    width: double.infinity,
                    alignment: Alignment.center,
                    child: Card(
                      margin: EdgeInsets.only(bottom: 25),
                      elevation: 0,
                      child: Text(
                        'Der må ikke laves overtræk på kontoen.',
                        style: TextStyle(
                          fontSize: 20,
                          color: Colors.black,
                        ),
                      ),
                    ),
                  ),
                  Container(
                    width: double.infinity,
                    alignment: Alignment.center,
                    child: Text(
                      'Overfør først nok til ikke at gå i negativ.',
                      style: TextStyle(
                        fontSize: 20,
                        color: Colors.black,
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}

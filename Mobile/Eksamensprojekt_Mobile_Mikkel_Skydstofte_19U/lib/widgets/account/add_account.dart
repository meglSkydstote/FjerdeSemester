import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../models/kind.dart';
import '../../models/account.dart';
import '../../controllers/model_controller.dart';

class AddAccount extends StatefulWidget {
  AddAccount({Key key}) : super(key: key);

  @override
  _AddAccountState createState() => _AddAccountState();
}

class _AddAccountState extends State<AddAccount> {
  final _accountInputController = TextEditingController();
  String _typeDescription = "Vælg konto type";
  String _accountDescription = "Konto navn";
  String _chosenType;

  _AddAccountState();

  ///////// Hardcoded types
  final List<String> dropdownItems = [
    'Forbrugskonto',
    'Investeringer',
    'Opsparing',
    'Budget',
    'Husholdning',
    'Tøj',
  ];

  ///////// Validation of input fields
  void addAccount(ModelController controller) {
    String accName = _accountInputController.text.trim();
    Account _account = Account();
    bool isValid = true;
    if (_chosenType == null) {
      setState(() {
        _typeDescription = "Mangler konto type!";
      });
      isValid = false;
    }
    if (accName.isEmpty) {
      setState(() {
        _accountDescription = "Indtast konto navn!";
      });
      isValid = false;
    } else if (accName.length > 20) {
      setState(() {
        _accountDescription = "Hold dig kortfattet!";
      });
      isValid = false;
    }
    if (isValid) {
      _account.name = accName;
      _account.kind = Kind(type: _chosenType);
      _account.setIBAN();
      controller.add(account: _account);
      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Consumer<ModelController>(
        builder: (context, _accountController, widgets) {
      return Scaffold(
        appBar: AppBar(
          title: Text('Ny Konto'),
        ),
        body: Container(
          padding: EdgeInsets.all(8.0),
          child: Card(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.end,
              children: <Widget>[
                TextFormField(
                  decoration: InputDecoration(labelText: _accountDescription),
                  controller: _accountInputController,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Text(
                      _typeDescription,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.grey,
                      ),
                    ),
                    Container(
                      margin: EdgeInsets.symmetric(vertical: 2, horizontal: 20),
                      padding: const EdgeInsets.all(10),
                      child: DropdownButton<String>(
                        value: _chosenType,
                        style: TextStyle(color: Colors.black),
                        items: dropdownItems
                            .map<DropdownMenuItem<String>>((String value) {
                          return DropdownMenuItem<String>(
                            value: value,
                            child: Text(value),
                          );
                        }).toList(),
                        hint: Container(
                          child: Text(
                            "Vælg type",
                            style: TextStyle(
                              color: Colors.black,
                              fontSize: 14,
                            ),
                          ),
                        ),
                        onChanged: (String value) {
                          setState(() {
                            _chosenType = value;
                          });
                        },
                      ),
                    ),
                  ],
                ),
                Container(
                  margin: EdgeInsets.only(right: 36, top: 50),
                  decoration: BoxDecoration(
                    border: Border.all(width: 2, color: Colors.blueGrey[400]),
                  ),
                  child: TextButton(
                    child: Text(
                      'Opret konto',
                      style: TextStyle(
                        color: Colors.black,
                      ),
                    ),
                    onPressed: () => addAccount(_accountController),
                  ),
                ),
              ],
            ),
          ),
        ),
      );
    });
  }
}

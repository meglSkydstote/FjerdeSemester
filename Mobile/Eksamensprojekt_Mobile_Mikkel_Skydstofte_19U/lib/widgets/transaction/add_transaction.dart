import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';

import '../../models/account.dart';
import '../../models/transactions.dart';
import '../../controllers/model_controller.dart';
import './not_allowed.dart';

class AddTransaction extends StatefulWidget {
  final Account account;
  AddTransaction({Key key, this.account}) : super(key: key);

  @override
  _AddTransactionState createState() => _AddTransactionState(account);
}

class _AddTransactionState extends State<AddTransaction> {
  final _amountInputController = TextEditingController();
  final _beneficiaryInputController = TextEditingController();
  String _textDescription = "Tekst til dig";
  String _amountDescription = "Beløb";
  final Account account;
  DateTime _date;

  _AddTransactionState(this.account);

  ///////// Creating a datepicker
  void _presentDatePicker() {
    showDatePicker(
      context: context,
      initialDate: DateTime.now(),
      firstDate: DateTime(2015),
      lastDate: DateTime(2025),
    ).then((value) {
      if (value == null) return;
      setState(() {
        _date = value;
      });
    });
  }

  ///////// Creating a modal sheet to inform the user of an invalid transaction
  void _showNotAllowed(BuildContext ctx) {
    showModalBottomSheet(
      context: ctx,
      backgroundColor: Colors.blue,
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.only(
          topLeft: Radius.circular(10),
          topRight: Radius.circular(10),
        ),
      ),
      builder: (_) {
        return GestureDetector(
          onTap: () {},
          child: NotAllowed(account: account),
          behavior: HitTestBehavior.opaque,
        );
      },
    );
  }

  ///////// Validation of input fields
  void addTx(ModelController controller, Account account) {
    final formatter = NumberFormat("###.0#", "en_UK");
    TransactionModel _transaction = TransactionModel();
    List<String> formattingAmount;
    bool _isValid = true;
    String inputAmount = _amountInputController.text.trim();
    if (inputAmount.contains(','))
      formattingAmount = inputAmount.split(',');
    else
      formattingAmount = inputAmount.split('.');

    ///////// If amount is not empty
    if (inputAmount.isNotEmpty) {
      try {
        ///////// If it just a bunch of numbers try parse
        if (inputAmount.contains('.') || inputAmount.contains(',')) {
          ///////// and if the amount contains a , seperator
          if (inputAmount.split(',').length == 2 ||
              inputAmount.split('.').length == 2) {
            ///////// Check if the saldo is valid otherwise call _showNotAllowed
            if (!account.checkSaldo(double.parse(
                (formattingAmount[0] + '.' + formattingAmount[1])))) {
              _showNotAllowed(context);

              _isValid = false;
            } else if (double.parse(
                    formattingAmount[0] + '.' + formattingAmount[1]) >=
                99999) {
              setState(() {
                _amountDescription = "Er det sorte penge?";
              });
              _isValid = false;
            }
          }
          ///////// If there's not an , check regularly for a valid saldo
        } else if (!account.checkSaldo(double.parse(formattingAmount[0]))) {
          _showNotAllowed(context);
          _isValid = false;
        }
        ///////// Bad input - error caught
      } catch (e) {
        setState(() {
          _amountDescription =
              "Beløbet må kun indeholde tal adskildt af ',' eller '.'";
        });
        _isValid = false;
      }
    }

    ///////// If amount is empty update description
    try {
      if (inputAmount.isEmpty) {
        setState(() {
          _amountDescription = "Indtast et beløb!";
        });
        _isValid = false;
      } else if (double.parse(formattingAmount[0]) >= 99999) {
        setState(() {
          _amountDescription = "Er det sorte penge?";
        });
        _isValid = false;
      }
    } catch (e) {
      setState(() {
        _amountDescription =
            "Beløbet må kun indeholde tal adskildt af ',' eller '.'";
      });
      _isValid = false;
    }

    ///////// If date is null do nothing
    if (_date == null) _isValid = false;
    ///////// if beneficiary input is empty update description
    if (_beneficiaryInputController.text.trim().isEmpty) {
      setState(() {
        _textDescription = "Indtast transaktions tekst";
      });
      _isValid = false;
    } else if (_beneficiaryInputController.text.trim().length > 20) {
      setState(() {
        _textDescription = "Hold dig kortfattet!";
      });
      _isValid = false;
    }

    ///////// If all checks has passed create the transaction
    if (_isValid) {
      try {
        _transaction.amount =
            double.parse(formatter.format(double.parse(inputAmount)));
      } catch (e) {
        List<String> formattingAmount = inputAmount.split(',');
        _transaction.amount = double.parse(formatter.format(
            double.parse((formattingAmount[0] + '.' + formattingAmount[1]))));
      }
      _transaction.creationDate = _date;
      _transaction.beneficiary = _beneficiaryInputController.text.trim();
      controller.addTransaction(account: account, tx: _transaction);
      Navigator.pop(context);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Consumer<ModelController>(
        builder: (context, _accountController, widgets) {
      return Scaffold(
        appBar: AppBar(
          title: Text('Ny Transaktion'),
        ),
        body: Container(
          padding: EdgeInsets.all(8.0),
          child: Card(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.end,
              children: <Widget>[
                TextFormField(
                  decoration: InputDecoration(
                    labelText: _textDescription,
                  ),
                  controller: _beneficiaryInputController,
                ),
                TextFormField(
                  decoration: InputDecoration(labelText: _amountDescription),
                  keyboardType: TextInputType.number,
                  controller: _amountInputController,
                ),
                Row(
                  children: [
                    Text(_date == null
                        ? 'Ingen dato valgt!'
                        : DateFormat.yMMMd().format(_date)),
                    TextButton(
                      child: Text(
                        'Vælg dato',
                      ),
                      onPressed: _presentDatePicker,
                    ),
                  ],
                ),
                Container(
                  margin: EdgeInsets.only(right: 20),
                  decoration: BoxDecoration(
                    border: Border.all(width: 2, color: Colors.grey),
                  ),
                  child: TextButton(
                    child: Text(
                      'Tilføj Transaktion',
                      style: TextStyle(
                        color: Colors.black,
                      ),
                    ),
                    onPressed: () {
                      addTx(_accountController, account);
                    },
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

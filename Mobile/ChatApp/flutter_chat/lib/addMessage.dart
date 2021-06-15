import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'model.dart';
import 'modelController.dart';
import 'userController.dart';
import 'package:provider/provider.dart';

class AddMessage extends StatefulWidget {
  AddMessage({Key? key}) : super(key: key);

  @override
  _AddMessageState createState() => _AddMessageState();
}

class _AddMessageState extends State<AddMessage> {
  final _formKey = GlobalKey<FormState>();

  Message _message = Message();

  _AddMessageState() {
    //TODO: Bwaddr. UserCredentials datatype skal pakkes ind
    UserCredential _user = Provider.of<UserController>(context).getUser();
    _message.owner = _user.user?.email;
  }

  @override
  Widget build(BuildContext context) {
    // Det her er totalt overkill!!
    // Vi kunne også bare bruge Provider.of<ModelController>(context, listen: false).add(message: _message)
    // i linie 35 herunder
    return Consumer<ModelController>(
        builder: (context, _modelController, widgets) {
      return Scaffold(
        appBar: AppBar(
          title: Text('Opret besked'),
          actions: [
            IconButton(
                onPressed: () {
                  final _form = _formKey.currentState;
                  _form?.save();
                  _modelController.add(message: _message);
                  Navigator.pop(context);
                },
                icon: const Icon(Icons.add))
          ],
        ),
        body: Container(
          padding: EdgeInsets.all(8.0),
          child: Form(
            key: _formKey,
            child: Column(
              children: [
                TextFormField(
                  initialValue: _message.owner,
                  decoration: InputDecoration(labelText: 'Afsender'),
                  onSaved: (afsender) {
                    setState(() {
                      _message.owner = afsender;
                    });
                  },
                ),
                TextFormField(
                  decoration: InputDecoration(labelText: 'Besked'),
                  onSaved: (besked) {
                    setState(() {
                      _message.message = besked;
                    });
                  },
                )
              ],
            ),
          ),
        ),
      );
    });
  }
}

import 'package:flutter/material.dart';
import 'messageDetail.dart';
import 'model.dart';
import 'modelController.dart';
import 'package:provider/provider.dart';

class Frontpage extends StatelessWidget {
  const Frontpage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Flutter Chat'),
        actions: [
          IconButton(
            onPressed: () {
              Navigator.pushNamed(context, '/login');
            },
            icon: const Icon(Icons.login),
          )
        ],
      ),
      body: Consumer<ModelController>(
          builder: (context, _modelController, widgets) {
        return ListView.builder(
            itemCount: _modelController.numberOfMessages,
            itemBuilder: (context, index) {
              Message message = _modelController.getMessage(index);
              return messageRow(context, message);
            });
      }),
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.add_comment, size: 36.0),
        onPressed: () => {Navigator.pushNamed(context, '/addMessage')},
      ),
    );
  }

  messageRow(BuildContext context, Message message) {
    return ListTile(
      leading: Icon(Icons.person_pin),
      title: Text("${message.message}"),
      subtitle: Text("${message.date} ${message.owner}"),
      isThreeLine: true,
      onTap: () => {
        Navigator.push(
            context,
            MaterialPageRoute(
                builder: (context) => MessageDetail(message: message)))
      },
    );
  }
}

/* TODO: OPGAVE FOR FORMIDDAGEN - 

1. messageDetail side med overførsel af den enkelte message ved klik i listen
2. GoogleMaps integration på denne messageDetail side - brug APIKEY fra sidst
3. Multiprovider og Provider.of<> for UserController()
4. messageDetail siden - brug message og vis marker på message.location 

*/


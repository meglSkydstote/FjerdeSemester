import 'package:flutter/material.dart';
import '../models/person.dart';

class InfoPage extends StatelessWidget {
  final Person person;

  InfoPage({this.person});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: MediaQuery.of(context).size.height * 0.15,
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
                color: Theme.of(context).primaryColor,
                width: 1.0,
              ),
              borderRadius: BorderRadius.only(
                topLeft: Radius.circular(50),
                topRight: Radius.circular(50),
              ),
            ),
            child: Column(
              children: <Widget>[
                Text(
                  '${person.name.title} ${person.name.first} ${person.name.last}',
                  style: Theme.of(context).textTheme.bodyText1,
                ),
                Text(
                  '${person.email}',
                ),
                Text(
                  '${person.location.state} - ${person.location.country}',
                ),
                Text(
                  '${person.location.city} - ${person.location.postcode}',
                ),
                Text(
                  '${person.location.street.name} ${person.location.street.number}',
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

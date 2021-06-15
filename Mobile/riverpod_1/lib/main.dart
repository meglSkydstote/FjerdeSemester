import 'package:flutter/material.dart';
import 'package:flutter_hooks/flutter_hooks.dart';
import 'package:hooks_riverpod/hooks_riverpod.dart';

void main() {
  runApp(ProviderScope(child: MyApp()));
}

// To create a StateNotifier you first need to create class/model to hold the state
class CounterState {
  CounterState({this.value = 0});
  final int value;

  // This is just a simple utility method, you might want to try out freezed
  // for more complex implementations
  CounterState copyWith({int count}) {
    return CounterState(value: count ?? this.value);
  }
}

class CounterNotifier extends StateNotifier<CounterState> {
  CounterNotifier() : super(CounterState());

  increase() => state = state.copyWith(count: state.value + 1);
  decrease() => state = state.copyWith(count: state.value - 1);
}

// Adding .autoDispose will dispose of the provider when it is no longer needed
final counterProvider =
    StateNotifierProvider.autoDispose((_) => CounterNotifier());

class MyApp extends HookWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: CounterPage(),
    );
  }
}

class CounterPage extends HookWidget {
  @override
  Widget build(BuildContext context) {
    final CounterState counterState = useProvider(counterProvider.state);
    final CounterNotifier counterNotifier = useProvider(counterProvider);
    return Scaffold(
      appBar: AppBar(
        title: Text('CounterPage'),
      ),
      body: Container(
        width: double.infinity,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Padding(
                padding: EdgeInsets.all(10),
                child: Text('Count: ${counterState.value}')),
            ElevatedButton(
              child: Text('Increase'),
              onPressed: () => counterNotifier.increase(),
            ),
            ElevatedButton(
              child: Text('Decrease'),
              onPressed: () => counterNotifier.decrease(),
            )
          ],
        ),
      ),
    );
  }
}

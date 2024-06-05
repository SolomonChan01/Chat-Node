# Chat Node

This is a single P2P node, using TCP to connect each Node

## Installation

You would like to install this program package on both computer connected to the same wifi network. You should not be worry about your ip address because it will auto search it for you. You can change the port if need. 

```bash

```

## Usage

Download these program to both device connected to the same wifi, set their port in ChatClient1.java. and execute both. the console will print out connected if connected, and you can type in message and click enter in either device, the message will send to the other device.

```java
//device 1
public static int targetPort = 12345;
public static int ownPort = 12344;

//device 2
public static int targetPort = 12344;
public static int ownPort = 12345;

```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.


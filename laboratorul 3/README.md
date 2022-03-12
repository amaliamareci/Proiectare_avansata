The Network Routing Problem
A network contains various nodes, such as computers, routers, switches, etc. Nodes in the network have unique names and may have other common properties such as hardware (MAC) address, the location on a map, etc.
Some of them are identified using an IP-address. Some of them are able to store data, having a storage capacity, expressed in gigabytes (GB).
The time (measured in milliseconds) required for a network packet to go from one node to another is known.
Example: locations are: v1 (Computer A) v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).
I have the classes Network, Node, Computer, Router, Switch and the interfaces Identifiable and Storage.I'm printing the nodes in the network ordered by locations(v1,v2,etc.).

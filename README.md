Hello

This is simple TCP protocol for school project.

It is a n -> 1 type which means that multiple clients can access.

Also it is binary and it was done the kinda bad way by moving bits.

Here is the look of package:
<ul>
<li>2 bits - operation</li>
<li>32 bits x 3 (96) - three numbers </li>
<li>4 bits - status data </li>
<li>6 bits - session data </li>
<li>4 bits - unused </li>
</ul>
All gives the 14 bytes of data

Some code useful when listening to this connection

Operation:
<ul>
<li>SUB - 00</li>
<li>DIV - 01</li>
<li>ADD - 10</li>
<li>MUL - 11</li>
</ul>

Status:
<ul>
<li>CORRECT - 0000</li>
<li>SESSION_KEY - 0001</li>
<li>NUMBER_INFINITE - 0011</li>
<li>NUMBER_NAN - 0100</li>
<li>NUMBER_DIV - 0101</li>
<li>ERROR - 0110</li>
<li>CLOSING - 0111</li>
</ul>
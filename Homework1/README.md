# Домашна работа 1

Домашното е реализирано на Java.
Програмата получава произволен брой аргументи - IP адреси. Те се въвеждат на отделни редове. След последно въведения IP адрес се въвежда празния низ(празен ред), така указваме че сме приключили с въвеждането на IP адресите, които искаме да бъдат проверени.

```sh
127.0.0.2
127.0.0.14
114.231.105.37
(празен ред)
```

Проверяваме всеки от IP адресите. За да разберем дали даден IP адрес е спамър, наличен в черния списък, обръщаме байтовете на адреса и добавяме .zen.spamhaus.org.
След като се извърши проверката връщаме следните съобщения в зависимост от върнатия отговор:
```sh
The IP address: 127.0.0.2 is found in the following Spamhaus public IP zone: 
127.0.0.2 - SBL - Spamhaus SBL Data
127.0.0.10 - PBL - ISP Maintained
127.0.0.4 - XBL - CBL Data
The IP address: 127.0.0.14 is NOT found in the Spamhaus blacklists.
The IP address: 114.231.105.37 is found in the following Spamhaus public IP zone: 127.0.0.11 - PBL - Spamhaus Maintained
```

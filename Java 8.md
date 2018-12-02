# 学习java 8
 主要学习java 8中Lambda,接口默认函数，Steam
## Labmda
Lambda 表达式可以理解为#**简洁**的可以**传递**的**匿名函数**一个方式：没有名称，但是有参数列表，函数主体，返回类型，还可以有一个可以抛异常的异常列表
Lambda语法：
无参Lambda
```
()->expression;
```
有参Lambda:
有参构造函数可以在左边小括号中写参数类型，也可以省略不写
```
([Class] param,[Class] param2...)->expression;
```
多行代码Lambda:
```
([Class] param,[Class] param2...)->{expression1;expression2;expression3...;[return expression]};
```

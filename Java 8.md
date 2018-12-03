# 学习java 8
 主要学习java 8中Lambda,接口默认函数，Steam
## Lambda
基于熟悉Lambda语法基础上，熟练掌握java.util.function下所有函数式接口，在后面的Stream中就更加容易理解和合理使用
### Lambda 语法
Lambda 表达式可以理解为#**简洁**的可以**传递**的**匿名函数**一个方式：没有名称，但是有参数列表，函数主体，返回类型，还可以有一个可以抛异常的异常列表
Lambda语法：
无参Lambda
```
()->[{]expression[}];
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

### Lambda使用条件
Lambda不是什么情况下都可以使用Lambda表达式，只有在**函数式接口**定义的情况下才可以使用Lambda表达式。
#### 函数式接口
**定义有且只有一个抽象方法的接口叫做函数式接口** ??(虽然不包括default方法，但是在compartor函数接口中多一个equals抽象方法不明白)
该抽象方法的签名可以描述Lambda表达式的签名。Java8中java.util.function包中引入新函数式接口。
#### @FunctionalInterface
该注解是Java8中新定义，该注解表示为背注解接口必须是函数式接口，否则编译失败。但是这个不是必须的，和@Override一样。使用该注解表示函数式接口更加标准
便于阅读代码

### 方法引用
方法引用：可以被看做仅仅调用特定方法的Lambda的一个快捷键（更像是针对单一方法调用的Lambda语法糖）
限定：该Lambdab表达式只是“直接调用方法的”
#### 语法
基本语法：
```
目标引用::方法名
```
静态方法方法,参数实例方法引用：
```
Class::functionName
```
**指向现有对象的实例的方法引用**。**不存在于当前Lambda表达式中的对象**,例如外部变量:outExpensive
```
outExpensive::functionName
```

### 复合Lambda
复合Lambda表达式主要设计用于重用和组合多个Lambda表达式。可以参考java.util.function中接口定义的默认方法名

## Stream
流：**从支持数据处理操作的源生成的元素序列**（暂时不理解），即可以被操作（按需计算）的有序集合
特点：
1.从有序集合中生成流时保留原有顺序
2.可以按需操
3.流只能被消费一次
4.流必须有中间操作和终端操作





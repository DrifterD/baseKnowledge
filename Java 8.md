# 学习java 8
 主要学习java 8中Lambda,接口默认函数，Steam
## Lambda
基于熟悉Lambda语法基础上，熟练掌握java.util.function下所有函数式接口，在后面的Stream中就更加容易理解和合理使用
### Lambda 语法
Lambda 表达式可以理解为#**简洁**的可以**传递**的**匿名函数**一个方式：没有名称，但是有参数列表，函数主体，返回类型，还可以有一个可以**抛异常**的异常列表
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

### 类型检查、类型推断以及限制
Lambda类型是从上下文推断出来的，上下文中Lambda表达式需要的类型称为**目标类型**（个人理解目标类型：参数类型相同，返回值类型相同）

### void返回值的兼容规则
如果一个Lambda主体是一个语句表达式，他就和一个返回void的函数描述符兼容

### 局部变量限制
Lambda表达式主体可以访问自由变量（外层作用域中定义的变量）。**Lambda可以没有限制的捕获（引用）实例变量和静态变量**，
但是**局部变量必须显示声明为final或者事实上是final**。Lambda表达式只能引用指派给他们局部变量一次（实例变量可以看做最终局部变量this)
> 实例变量存储在堆中，局部变量存储在栈中。堆是线程共享，栈栈并不是。在在Lambda中访问自由变量实际上是访问副本

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
4.流三要素：
    1. 数据源
    2.中间操作链。**中间操作：返回值必须是有Stream属性**
    3.终端操作。**终端操作是返回值不属于Stream，包括void**

## 流常规使用

### 筛选
主要是通过Stream类下filter实现筛选，filter参数是Predicate,可以通过Lambda实现
### 映射
主要是map和flatMap
### 查找和匹配
匹配:anyMatch,allMatch,noneMatch 
查找:findFirst,findAny.**注意该方法返回是Optional 类**
### 归纳（类似于sql中聚合）
Stream类下一个reduce方法，**该方法就是将流中所有元素结合起来返回一个特定类型**
###  \*数值流 
流在对数字操作过程中一般都会涉及到从装箱拆箱操作，从而影响性能，为了避免这种情况，提供数值流IntStream,LongStream,DoubleStream.分别是int,long和double的原始类型。**数值流存在各自不同的特色的方法**
#### 转换成数值流
这个操作是将引用类型转换成基础类型流。mapToInt,mapToDouble,mapToLong
#### 转换成对象流
将原始流转换成对应的对象流，使用Stream的boxed

### \*构建流
Stream不仅可以通过集合转出流，还可以通过多种方式实现构建流。主要还是给予Stream类下方法：of，iterate,generate.还有其他类FIle等都新建接口提供流程的生成

## 收集器

### 归约和汇总

### 分组

#### 多级分组

#### 按子组收集数据
Collectors.groupingBy第二个参数必须是Collector类型，意味着可放除groupingBy以外的任何Collector类型。在遇到收集器返回值Optional时需注意：
**groupingBy收集器只有在应用分组条件后，第一次在流中找到某个键对应的元素时才会把键加入分组Map中，因为他不会仅仅因为他是归约收集器的返回类型而表达一个最重可能不存在却意外存在的值**（个人理解：在groupingBy中如果不存在对应类型，则也不会有对应optional值，如果存在optional值一定有内容）
不喜欢Optional结果类型的可以通过**Collectors.collectingAndThen**实现类型转换
一下是Collectors.collectingAndThen的方法签名
```
public static<T,A,R,RR> Collector<T,A,RR> collectingAndThen(Collector<T,A,R> downstream,
                                                                Function<R,RR> finisher)

```

#### 分区
Collectors.partitionBy 分区。通过一个boolean类型分区，主要分true和false两个分区。优势在于可以提供两套完整流（true和false）

### 自定义Collector



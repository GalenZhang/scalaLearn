scala 笔记
================================

http://blog.csdn.net/asongoficeandfire/article/details/21490101  
Scala从零开始


main方法并没有使用static修饰，而Scala中已经摒弃了static作为方法的关键字。mian方法的入参是一个Array[String]，即为一个String数组，这与java中一致。但是Scala中使用方括号而不是尖括号来指定泛型的类型。这有效避免了与尖括号作为方法名称（以后的文章中会涉及）的混淆。  

而Scala类中方法的定义形式如下：def 方法名(参数): 返回值类型 = {方法体}  

其中参数和返回值的模式为：val: type，这种变量名在前、变量类型在后、相互之间使用冒号隔开的方式将贯穿在Scala的代码中。另外方法和方法体之间使用等号隔开。  

返回值的类型为Unit，相当于java中的void。

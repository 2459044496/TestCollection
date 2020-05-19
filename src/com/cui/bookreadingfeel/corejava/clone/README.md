Java浅拷贝与深拷贝

Object类的clone方法如下：
protected native Object clone() throws CloneNotSupportedException;
子类覆写需要实现Cloneable接口，覆写clone方法，并修改访问权限关键字为public。
实现的是浅拷贝。
浅拷贝只克隆原对象，如果原对象包含子对象的引用，就会共享。
如果浅拷贝的子对象是不可变类如String，包装类。那么浅拷贝是没有问题的。
深拷贝需要调用子对象的clone方法来修补默认的clone方法。


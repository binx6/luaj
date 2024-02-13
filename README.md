# luaj

Fork自luaj项目的jse（标准版），并对其做出部分改进，Lua5.2基础上兼容至Lua5.3版本，当然，不足之处还是存在的，届时敬请指教

Ps：初衷是其中的paser在我写项目的时候有用武之地，但是只能解析Lua5.2的，改着改着后来索性合并着一块改了

## 更新了什么？

- [X] Lua5.2（strip后仍是）向Lua5.3兼容
- [x] parser支持Lua5.3语法
- [x] 修复历史遗留的一些issue
- [ ] luajc & script & server & jme（全部舍弃）

## 使用小技巧

- 这里给出一份parser Chunk（语句组）小技巧，封装了一下

```java
import org.luaj.vm2.ast.*;
import org.luaj.vm2.parser.*;

public static String luaChunk(String chunk) {
    try {
        LuaParser parser = new LuaParser(new StringReader(chunk));
            return String.valueOf(parser.Chunk());
        } catch (ParseException | TokenMgrError e) {
            return e.toString() + "\n";
    }
}
```

除了Chunk这些也是同理，换汤不换药

```md
这些也很重要，尤其是在分析不透明谓词，分析控制流结构的时候等等
Exp() 解析表达式
Block() 解析代码块
NameList() 解析名称列表
ParList() 解析函数参数列表
FieldList() 解析表字段列表
FuncArgs() 解析函数调用参数
```

回归纯粹，打造一份平凡而不平庸的luaj

## Special thanks

[Enyby](https://github.com/Enyby)

[luaj](https://github.com/luaj/luaj)